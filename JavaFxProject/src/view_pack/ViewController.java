package view_pack;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ViewController implements Initializable{
	@FXML ListView<String> listView;
	@FXML TableView<Phone> tableView;
	@FXML ImageView imageView;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ObservableList<String> list = FXCollections.observableArrayList();
		list.add("GalaxyS1");
		list.add("GalaxyS2");
		list.add("GalaxyS3");
		list.add("GalaxyS4");
		list.add("GalaxyS5");
		list.add("GalaxyS6");
		list.add("GalaxyS7");
		
		tableView.setItems(FXCollections.observableArrayList(
				new Phone("GalaxyS1", "phone01.png"),
				new Phone("GalaxyS2", "phone02.png"),
				new Phone("GalaxyS3", "phone03.png"),
				new Phone("GalaxyS4", "phone04.png"),
				new Phone("GalaxyS5", "phone05.png"),
				new Phone("GalaxyS6", "phone06.png"),
				new Phone("GalaxyS7", "phone07.png")));
		listView.setItems(list);
		TableColumn<Phone, ?> tcSmartPhone = tableView.getColumns().get(0);
		tcSmartPhone.setCellValueFactory(new PropertyValueFactory("smartPhone"));
		
		TableColumn<Phone, ?> tcImage = tableView.getColumns().get(1);
		tcImage.setCellValueFactory(new PropertyValueFactory("image"));
		tcImage.setStyle("-fx-alignment: CENTER;");
		
		listView.getSelectionModel();
		
		listView.getSelectionModel().selectedIndexProperty()
		.addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldVal, Number newVal) {
				tableView.getSelectionModel().select(newVal.intValue());
				tableView.scrollTo(newVal.intValue());
			}});
		
		tableView.getSelectionModel().selectedItemProperty()
				.addListener(new ChangeListener<Phone>() {

					@Override
					public void changed(ObservableValue<? extends Phone> observable, Phone oldValue, Phone newValue) {
						imageView.setImage(new Image("/images/" + newValue.getImage()));
					}
				});
		imageView.setImage(new Image("/images/phone01.png"));
	}

	public void handlebtnRegAction() {
		
	}
	
	public void handlebtnCancelAction() {
		
	}
}
