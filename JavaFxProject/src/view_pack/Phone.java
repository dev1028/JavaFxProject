package view_pack;

import javafx.beans.property.SimpleStringProperty;

public class Phone {
	private SimpleStringProperty smartPhone;
	private SimpleStringProperty image;
	

	Phone(String smartPhone, String image){
		this.smartPhone = new SimpleStringProperty(smartPhone);
		this.image = new SimpleStringProperty(image);
	}
	
	public String getSmartPhone() {
		return this.smartPhone.get();
	}

	public SimpleStringProperty smartPhoneProperty() {
		return this.smartPhone;
	}
	
	public void setSmartPhone(String smartPhone) {
		this.smartPhone.set(smartPhone);
	}

	public String getImage() {
		return image.get();
	}
	
	public SimpleStringProperty smartImageProperty() {
		return this.image;
	}
	
	public void setImage(String image) {
		this.image.set(image);
	}

}
