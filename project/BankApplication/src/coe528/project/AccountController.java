/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project;

import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
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
 * Overview: AccountController is the mutable class that controls the account page for customers to check their balance,
 * withdraw and deposit money, make online purchases, and logout.
 * 
 * Abstraction Function: AccountController is represented by customer controlling the page.
 * 
 * Rep Invariant: The customer cannot be null.
 * @author babye
 */
public class AccountController {

    @FXML
    private Button logOutButton;
    @FXML
    private Text balanceText;

    private Customer c;
    private Manager m;
    private Stage primaryStage;
    double balance;
    @FXML
    private TextField witAmount;
    @FXML
    private TextField depAmount;
    @FXML
    private Button witButton;
    @FXML
    private Button depButton;
    @FXML
    private Text welcomer;
    @FXML
    private Text errorText;
    @FXML
    private Text levelText;
    @FXML
    private TextField purAmount;
    @FXML
    private Button purButton;
    @FXML
    private Text purResult;
    private Double purCost;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == logOutButton) {
            System.out.println("Logging out");
            primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("tmubanking.fxml"));
            Parent root = loader.load();

            MainController controller = loader.getController();

            controller.setManager(m);

            Scene scene = new Scene(root);

            primaryStage.setTitle("TMUBank Application");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        if (event.getSource() == purButton) {
            try {
                purCost = Double.parseDouble(purAmount.getText());

                System.out.println("Making purchase");

                if (purCost >= 50.00) {

                    if (purCost > c.getBalance()) {
                        errorText.setText("Not enough money in the balance!");
                    } else {

                        c.setBalance(c.getBalance() - purCost - c.getContext().getState().purchase());
                        balanceText.setText(new DecimalFormat("#.00#").format(c.getBalance()));
                        errorText.setText("");
                        purResult.setText("Your purchase was successful! $" + c.getContext().getState().purchase() + " fee.");
                        c.levelCheck();
                        levelText.setText(c.getContext().getState().getName());
                    }
                } else {
                    purResult.setText("Purchase must be minimum $50.00");
                }
            } catch (Exception e) {
                errorText.setText("Please enter only digits with no $");
            }
        }

        if (event.getSource() == witButton) {
            try {
                balance = parseDouble(witAmount.getText());

                System.out.println("Withdrawing balance");

                if (balance > c.getBalance()) {
                    errorText.setText("Not enough money in the balance!");
                } else {
                    c.setBalance(c.getBalance() - balance);
                    balanceText.setText(new DecimalFormat("#.00#").format(c.getBalance()));
                    errorText.setText("");
                    c.levelCheck();
                    levelText.setText(c.getContext().getState().getName());
                }
            } catch (Exception e) {
                errorText.setText("Please enter only digits with no $");
            }
        }

        if (event.getSource() == depButton) {
            try {
                balance = parseDouble(depAmount.getText());

                System.out.println("Depositing balance");

                c.setBalance(c.getBalance() + balance);
                balanceText.setText(new DecimalFormat("#.00#").format(c.getBalance()));
                errorText.setText("");
                c.levelCheck();
                levelText.setText(c.getContext().getState().getName());
            } catch (Exception e) {
                errorText.setText("Please enter only digits with no $");
            }
        }
    }

    void setCustomer(Customer customer) throws FileNotFoundException {
        c = customer;
        balanceText.setText(new DecimalFormat("#.00#").format(c.getBalance()));
        welcomer.setText("Welcome, " + c.fileRead(1));
        levelText.setText(c.getContext().getState().getName());
    }

    void setManager(Manager manager) {
        m = manager;
    }
    
    public boolean repOK() {
// EFFECTS: Returns true if the rep invariant holds for this
// object; otherwise returns false
        if (c == null)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
// EFFECTS: Returns a string that contains the customer information. Implements the
// abstraction function.
        return "Customer controlling: " + c + ".";
    }
    
}
