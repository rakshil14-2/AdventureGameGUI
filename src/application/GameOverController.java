package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class handles the events in the game over scene
 * @author Delara
 *
 */
public class GameOverController {
	/**
	 * This method handles the button click in game over scene
	 * If the button is clicked the scene will change to the main menu scene
	 * @param e event of type ActionEvent use to change the current scene to the main menu scene
	 * @throws IOException exception handling for loading the MainMenu.fxml file
	 */
	public void buttonClick(ActionEvent e) throws IOException {
		// load the scene from the MainMenu.fxml file
		Parent root = FXMLLoader.load(getClass().getResource("/MainMenu.fxml"));
		Scene gameover=new Scene(root,600,400);
		// get the window that has the button in it and change the scene in it to main menu scene
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		window.setScene(gameover);
		window.show();
	}
}
