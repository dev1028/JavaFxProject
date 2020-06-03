package button_pack;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ButtonController implements Initializable{
	@FXML CheckBox chk1;
	@FXML CheckBox chk2;
	@FXML ImageView imageView;
	@FXML ImageView imageView2;
	
	@FXML ToggleGroup group;
	@FXML RadioButton rad1;
	@FXML RadioButton rad2;
	@FXML RadioButton rad3;
	
	@FXML Button exitBtn;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){

			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle oldVal, Toggle newVal) {
				imageView2.setImage(new Image("/images/"+newVal.getUserData().toString()+".png"));
			}});
		
		chk2.setOnAction((e)->{
				chkAction();
		});
		
		exitBtn.setOnAction((e)->{
			Platform.exit();
		});
	}

	public void chkAction() {
		boolean b1 = chk1.isSelected();
		boolean b2 = chk2.isSelected();
		String imageName = "";
		if(b1 && b2) {
			imageName = "geek-glasses-hair.gif"; 
		}else if(b1) {
			imageName = "geek-glasses.gif";
		}else if(b2) {
			imageName = "geek-hair.gif";
		}else {
			imageName = "geek.gif";
		}
		imageView.setImage(new Image("/images/" + imageName));
	}
	
	public void handleCheckAction(ActionEvent evt) {
		chkAction();
	}
}
