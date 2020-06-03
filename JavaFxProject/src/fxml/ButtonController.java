package fxml;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ButtonController implements Initializable{
	@FXML Button btnNew;
	@FXML Button btnOpen;
	@FXML Button btnSave;
	
	@Override
	public void initialize(URL loc, ResourceBundle resource) {
		// TODO Auto-generated method stub
		Image img = new Image("/panes/icons/new.png");
		btnNew.setGraphic(new ImageView(img));
		Image imgOpen = new Image("/panes/icons/open.png");
		btnOpen.setGraphic(new ImageView(imgOpen));
		Image imgSave = new Image("/panes/icons/save.png");
		btnSave.setGraphic(new ImageView(imgSave));
		
		btnNew.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("new clicked...");
			}});
		
		btnOpen.setOnAction((Event)-> {
			System.out.println("Open clicked...");
		});
	}

	public void btnSaveAction(ActionEvent event) {
		System.out.println("Save Clicked");
	}
}
