package application;

/**
 * This is a class that load the main menu scene from an fxml file called MainMenu.fxml
 * 
 * @author delara
 * 
 */
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


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
    	// sets the stage title to advantur game then loads the scene from MainMenu.fxml
         primaryStage.setTitle("Adventure Game");
         Parent root = FXMLLoader.load(getClass().getResource("/MainMenu.fxml"));
         primaryStage.setScene(new Scene(root, 600, 400));
         primaryStage.show();    
}}
