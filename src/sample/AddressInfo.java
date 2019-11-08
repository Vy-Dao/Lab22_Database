package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class AddressInfo {
    private SimpleIntegerProperty id;
    private SimpleStringProperty lastName;
    private  SimpleStringProperty firstName;
    private SimpleStringProperty phone;
    private SimpleStringProperty email;

    public  AddressInfo(int id, String firstName, String lastName, String email, String phone){
        this.setId(new SimpleIntegerProperty(id));
        this.setEmail(new SimpleStringProperty(email));
        this.setFirstName(new SimpleStringProperty(firstName));
        this.setLastName(new SimpleStringProperty(lastName));
        this.setPhone(new SimpleStringProperty(phone));
    }

    public SimpleIntegerProperty getId() {
        return id;
    }

    public void setId(SimpleIntegerProperty id) {
        this.id = id;
    }

    public SimpleStringProperty getLastName() {
        return lastName;
    }

    public void setLastName(SimpleStringProperty lastName) {
        this.lastName = lastName;
    }

    public SimpleStringProperty getFirstName() {
        return firstName;
    }

    public void setFirstName(SimpleStringProperty firstName) {
        this.firstName = firstName;
    }

    public SimpleStringProperty getPhone() {
        return phone;
    }

    public void setPhone(SimpleStringProperty phone) {
        this.phone = phone;
    }

    public SimpleStringProperty getEmail() {
        return email;
    }

    public void setEmail(SimpleStringProperty email) {
        this.email = email;
    }
}
