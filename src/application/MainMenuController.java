package application;

/**
 * This is a class that handles the main menu button actions
 * @author Delara, Paul, Carlo
 */
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuController {
	/**
	 * This method handles the exit button click action
	 * If the user clicks this button it will end the game by closing the main window
	 * @param e this is an even of type ActionEvent that will be used to close the scene created in main class
	 */
	public void exit(ActionEvent e) {
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		window.close();
	}
	
	/**
	 * This method handles the button for the avatar demo
	 * If the button is clicked a new window will open that had the avatar in it
	 * @param e 
	 */
	public void avatarClick() {
		CharacterMovement movement = new CharacterMovement();
	    movement.movement();

	}
	/**
	 * This methos handles the start button on main menu
	 * If the button is clicked a new scene will load from the fxml file called Level1.fxml for level 1 scene
	 * @param e this is an even of type ActionEvent that will be used to change the scene created in main class to level 1 scene
	 * @throws IOException on loading the fxml file
	 */
	public void startClick(ActionEvent e) throws IOException {
		// load the scene from the Level1.fxml file
		Parent root = FXMLLoader.load(getClass().getResource("/Level1.fxml"));
		Scene gameover=new Scene(root,600,400);
		// get the window that has the button in it and change the scene in it to level 1 scene
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		window.setScene(gameover);
		window.show();

	}
}
