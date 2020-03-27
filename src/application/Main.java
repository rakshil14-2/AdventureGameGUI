package application;

//importing libraries

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 
 * Main class for Adventure Game GUI version
 * Launches the main menu to start a new game
 *
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
<<<<<<< Updated upstream
    	 // sets the stage title to adventure game, then loads the scene from MainMenu.fxml file
=======
    	 // sets the stage title to advanture game then loads the scene from MainMenu.fxml
>>>>>>> Stashed changes
         primaryStage.setTitle("Adventure Game");
         Parent root = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
         primaryStage.setScene(new Scene(root, 600, 400));
         primaryStage.show();    
}}
