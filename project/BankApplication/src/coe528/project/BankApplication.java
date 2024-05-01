package coe528.project;

import javafx.scene.image.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *Overview: BankApplication is the main class to start the program for
 * TMUBanking. This class is immutable;
 * 
 * Abstraction Function: Represents itself (a program)
 * 
 * Rep Invariant: Nothing for user to set
 * @author babye
 */
public class BankApplication extends Application {
    
 
    public static void main(String[] args) {
 /**
 *EFFECTS: launches the application
 */
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
  /**
 *EFFECTS: Sets up the necessary staging for the application
 */
     
        Manager m = new Manager();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("tmubanking.fxml"));
        Parent root = loader.load();

        MainController controller = loader.getController();
        
        controller.setManager(m);
        
        Scene scene = new Scene(root);

        primaryStage.setTitle(" TMUBank Application");
        primaryStage.getIcons().add(new Image("file:icon.jpg"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
