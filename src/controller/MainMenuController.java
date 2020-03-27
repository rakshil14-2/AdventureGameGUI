package controller;

//importing libraries
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.CharacterMovement;

/**
 * This is a class that handles the main menu button actions
 * @author Delara, Paul, and Carlo
 */

public class MainMenuController {
	
	/**
	 * The exit method handles the exit button click action.
	 * If the user mouse clicks this button, it will end the game by closing the main window.
	 * @param e is an event of type ActionEvent that will be used to close the scene created in main class.
	 */
	public void exit(ActionEvent e) {
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		window.close();
	}
	
	/**
	 * The avatarClick method handles the button for the avatar movement demo.
	 * If the button is mouse clicked, a new window will open that has the avatar in it,
	 * where the user can move the avatar around in.
	 */
	public void avatarClick() {
		CharacterMovement movement = new CharacterMovement();
	    movement.movement();

	}
	/**
	 * The starClick method handles the start button on the main menu.
	 * If the start button is clicked, a new scene will load from the fxml file 
	 * called Level1.fxml for the level 1 scene. Then the user can begin playing the adventure game.
	 * @param e is an event of type ActionEvent that will be used to change the scene created in main class to level 1 scene
	 * @throws IOException on loading the fxml file
	 */
	public void startClick(ActionEvent e) throws IOException {
		// load the scene from the Level1.fxml file
		Parent root = FXMLLoader.load(getClass().getResource("/view/Level1.fxml"));
		Scene gameover=new Scene(root,600,400);
		// get the window that has the button in it and change the scene in it to level 1 scene
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		window.setScene(gameover);
		window.show();

	}
}
