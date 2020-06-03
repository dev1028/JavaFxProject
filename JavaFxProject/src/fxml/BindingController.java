package fxml;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

public class BindingController implements Initializable{
	@FXML TextArea txtArea1;
	@FXML TextArea txtArea2;
	@FXML Label label;
	@FXML Slider slider;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		slider.minProperty().setValue(10);
//		slider.maxProperty().setValue(200);
		// TODO Auto-generated method stub
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldVal, Number newVal) {
				// TODO Auto-generated method stub
				System.out.println(newVal.doubleValue());
				label.setFont(new Font(newVal.doubleValue()));
			}
		});
		
		slider.valueProperty().addListener((evt)->{
			
		});
		
//		txtArea2.textProperty().bind(txtArea1.textProperty());
//		txtArea2.textProperty().bindBidirectional(txtArea1.textProperty());
		Bindings.bindBidirectional(txtArea1.textProperty(), txtArea2.textProperty());
	}

}
