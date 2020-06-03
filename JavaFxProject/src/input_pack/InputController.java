package input_pack;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class InputController implements Initializable{
	@FXML Button btnReg;
	@FXML Button btnCancel;
	
	@FXML TextField txtTitle;
	@FXML PasswordField txtPassword;
	@FXML ComboBox<String> comboPublic;
	@FXML DatePicker dateEdit;
	@FXML TextArea txtContent;
	
	Connection conn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "hr", "hr");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("DB 접속 실패");
		}
	}

	public void handleBtnRegAction(ActionEvent e) {
		if(txtTitle.getText() == null || txtTitle.getText().equals("")) {
			messageDialog("제목 입력하세요.");
		}
		else if(txtPassword.getText() == null || txtPassword.getText().equals("")) {
			messagePopup("비밀번호를 입력하세요.");
		}
		else if(txtContent.getText() == null || txtContent.getText().equals("")) {
			messagePopup("내용을 입력하세요.");
		}
		else if(comboPublic.getValue() == null || comboPublic.getValue().equals("")) {
			messagePopup("공개 여부를 하세요.");
		}
		else if(dateEdit.getValue() == null || dateEdit.getValue().equals("")) {
			messagePopup("날짜를 입력하세요.");
		} 
		else {
			//디비 입력... Connection, PreparedStatement, executeUpdate()
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			String sql = "insert into board2(title, password, publicity, exit_date, content)"
					+ "values(?, ?, ?, ?, ?)";
			
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, txtTitle.getText());
				pstmt.setString(2, txtPassword.getText());
				pstmt.setString(3, comboPublic.getValue());
				pstmt.setString(4, dateEdit.getValue().format(formatter));
				pstmt.setString(5, txtContent.getText());
				
				int r = pstmt.executeUpdate();
				System.out.println(r + "건 입력됨.");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//각 필드 초기화
			txtTitle.setText(null);
			txtPassword.setText(null);
			comboPublic.setValue("공개");
			dateEdit.setValue(null);
			txtContent.setText(null);
		} // end of if
	} //end of handle

	public void messageDialog(String message) {
		Stage customStage = new Stage(StageStyle.UTILITY);
		customStage.initModality(Modality.WINDOW_MODAL);
		customStage.initOwner(btnReg.getScene().getWindow());
		
		AnchorPane ap = new AnchorPane();
		ap.setPrefSize(400, 150);
		
		ImageView imageView = new ImageView();
		imageView.setImage(new Image("/icons/dialog-info.png"));
		imageView.prefWidth(50);
		imageView.prefHeight(50);
		imageView.setPreserveRatio(true);
		imageView.setLayoutX(15);
		imageView.setLayoutY(15);
		
		Button button = new Button("확인");
		button.setLayoutX(336);
		button.setLayoutY(104);
		button.setOnAction(e->customStage.close());
		
		Label label = new Label(message);
		label.setLayoutX(87);
		label.setLayoutY(33);
		label.setPrefHeight(15);
		label.setPrefWidth(290);
		
		ap.getChildren().add(imageView);
		ap.getChildren().add(button);
		ap.getChildren().add(label);
		
		Scene scene = new Scene(ap);
		customStage.setScene(scene);
		customStage.show();
	}
	
	public void messagePopup(String message) {
		HBox hbox = new HBox();
		hbox.setStyle("-fx-background-color: black; -fx-background-radius: 20;");
		hbox.setAlignment(Pos.CENTER);
		
		ImageView imageView = new ImageView();
		imageView.setImage(new Image("/icons/dialog-info.png"));
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		
		
		Label label = new Label();
		label.setText(message);
		label.setStyle("-fx-text-fill: white;");
		HBox.setMargin(label, new Insets(0,5,0,5));
		
		hbox.getChildren().add(imageView);
		hbox.getChildren().add(label);
		
		Popup popup = new Popup();
		popup.getContent().add(hbox);
		popup.setAutoHide(true);
		
		popup.show(btnReg.getScene().getWindow());
	}
	
	public void handleBtnCancelAction(ActionEvent e) {
		
	}
}
