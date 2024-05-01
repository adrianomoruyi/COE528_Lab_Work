/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *Overview: MainController is the mutable class that controls the login in page, directing customers 
 * and managers to their proper dashboards.
 * 
 * Abstraction Function: MainController is represented by text fields for the username, password, and role for the users.
 * 
 * Rep Invariant: The username, password, and role fields must not be null.
 * @author babye
 */
public class MainController {

    @FXML
    private TextField userText;
    @FXML
    private TextField passText;
    @FXML
    private TextField roleText;
    @FXML
    private Button button;

    private String username;

    private String password;

    private String role;

    private Manager m;
    
    private Stage homeStage;
    
    @FXML
    private Text logtext;
    @FXML
    private Button exitButton;

    public void setManager(Manager manager) {
        m = manager;
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
 /**
 *EFFECTS: authenticates the given username, role, and password and decides whether the user should be let it or not.
 */
        if (event.getSource() == button) {
            username = userText.getText();
            password = passText.getText();
            role = roleText.getText();

            if (role.equals(m.getRole())) {
                if (username.equals(m.getUsername()) && password.equals(m.getPassword())) {
                    System.out.println("Manager in");
                    homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
                    Parent root = loader.load();

                    Scene scene = new Scene(root);

                    DashboardController controller = loader.getController();

                    controller.setManager(m);

                    homeStage.setTitle("TMUBank Application");
                    homeStage.setScene(scene);
                    scene.setRoot(root);
                    homeStage.show();

                }
            } else if (role.equals("customer")) {

                for (int i = 0; i < m.getCustomerList().size(); i++) {
                        if (username.equals(m.getCustomerList().get(i).fileRead(1)) && password.equals(m.getCustomerList().get(i).fileRead(2)) && role.equals(m.getCustomerList().get(i).fileRead(3))) {
                            System.out.println("Customer in");
                            homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                            FXMLLoader loader = new FXMLLoader(getClass().getResource("account.fxml"));
                            Parent root = loader.load();

                            Scene scene = new Scene(root);

                            AccountController controller = loader.getController();

                            controller.setCustomer(m.getCustomerList().get(i));
                            controller.setManager(m);

                            homeStage.setTitle("TMUBank Application");
                            homeStage.setScene(scene);
                            scene.setRoot(root);
                            homeStage.show();
                            break;
                        }
                }

            } else {
                logtext.setText("Username/Password/Role is incorrect.");
            }
        }
        if (event.getSource() == exitButton)
        {
           m.deleteAll();
           homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           homeStage.close();
        }
    }
    
    public boolean repOK() {
// EFFECTS: Returns true if the rep invariant holds for this
// object; otherwise returns false
        if (userText == null || passText == null || roleText == null)
        {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
// EFFECTS: Returns a string that contains the username, password, and role text fields. Implements the
// abstraction function.
        return "Username: " + userText + ". Password: " + passText + ". Role: " + roleText + ".";
    }
}
    

