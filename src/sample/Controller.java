package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    // Create variable
    static ResultSet rs;
    ObservableList<AddressInfo> obList = FXCollections.observableArrayList();

    public Button btnPrev; public Button btnNext; public Button btnShowFirst;
    public Label lblFirstName; public Label lblLastName; public Label lblFirst; public Label lblId;

    public TableView<AddressInfo> tblView;
    public TableColumn<AddressInfo,Integer> colID;
    public TableColumn<AddressInfo,String> colFirstName;
    public TableColumn<AddressInfo,String> colLastName;
    public TableColumn<AddressInfo,String> colPhone;
    public TableColumn<AddressInfo,String> colEmail;

    //
    public void prevCustClicked(ActionEvent actionEvent) throws SQLException{
        if(!rs.isFirst())
            rs.previous();
        lblId.setText(rs.getString(1)); lblFirstName.setText(rs.getString(2));
        lblLastName.setText(rs.getString(3));
    }

    public void nextCustClicked(ActionEvent actionEvent) throws SQLException{
        if(!rs.isFirst())
            rs.previous();
        lblId.setText(rs.getString(1)); lblFirstName.setText(rs.getString(2));
        lblLastName.setText(rs.getString(3));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("In Initialize");
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        try{
            rs = connection.createStatement().executeQuery("select * from Addresses");
            rs.first();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (ResultSet rs = connection.createStatement().executeQuery("select * from Addresses")){
            while (rs.next()){
                obList.add(new AddressInfo(rs.getInt("AddressID"), rs.getString("FirstName"), rs.getString("LastName"),
                        rs.getString("Email"), rs.getString("Phone")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        colID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        tblView.setItems(obList);
        try {
            connectionClass.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showFirstNameClicked(ActionEvent actionEvent){
        try{
            lblFirst.setText(rs.getString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
