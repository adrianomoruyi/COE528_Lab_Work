/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Overview: DashboardController is the mutable class that controls the dashboard for banking admins. On this page, admins can
 * add or remove customers and logout.
 * 
 * Abstraction Function: DashboardController is represented by the manager controlling the page.
 * Rep Invariant: The manager cannot be null;
 * @author babye
 */
public class DashboardController {

    @FXML
    private Button logOutButton;
    @FXML
    private TextField addUsername;
    @FXML
    private TextField deleteUsername;
    @FXML
    private Button deleteButton;

    private Stage primaryStage;
    private String username;
    private String password;
    private Manager m;
    @FXML
    private TextField addPassword;
    @FXML
    private TableView<Customer> cusTable;
    @FXML
    private TableColumn<Customer, String> cusColumn;
    @FXML
    private Button addingButton;
    @FXML
    private AnchorPane addButton;

    @FXML
    private void initialize() {
        cusColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("username"));
    }

    @FXML
    public void setTableContent(ArrayList<Customer> list) {
        ObservableList<Customer> data = FXCollections.observableArrayList(list);
        cusTable.setItems(data);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, Exception {
        if (event.getSource() == logOutButton) {
            System.out.println("Logging out");
            primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("tmubanking.fxml"));
            Parent root = loader.load();

            MainController controller = loader.getController();

            controller.setManager(m);

            Scene scene = new Scene(root);

            primaryStage.setTitle(" TMUBank Application");
            primaryStage.setScene(scene);
            primaryStage.show();

        }

        if (event.getSource() == addingButton) {

            System.out.println("Adding customer");
            username = addUsername.getText();
            password = addPassword.getText();

            m.addCustomer(username, password);

            setTableContent(m.getCustomerList());
        }

        if (event.getSource() == deleteButton) {

            System.out.println("Delete customer");
            username = deleteUsername.getText();

            m.deleteCustomer(username);

            setTableContent(m.getCustomerList());
        }
    }

    public void setManager(Manager manager) {
        m = manager;
        
        if (m.getCustomerList().isEmpty() == false)
        {
            setTableContent(m.getCustomerList());
        }
    }
    
    public boolean repOK() {
// EFFECTS: Returns true if the rep invariant holds for this
// object; otherwise returns false
        if (m == null)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
// EFFECTS: Returns a string that contains the manager information. Implements the
// abstraction function.
        return "Customer controlling: " + m + ".";
    }
    
}
