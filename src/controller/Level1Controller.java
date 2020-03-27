package controller;

//importing libraries
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Level;
import model.Puzzle;
import view.PopupWindow;


/**
 * The Level1Controller class handles the event for the level 1 scene loaded from the Level1.fxml
 * @author Delara
 * 
 */
public class Level1Controller implements Initializable{
	@FXML ImageView notePuzzle,lockPuzzle,invitaionPuzzle,door;
	@FXML Label lockDoor;
	Puzzle lock;
	boolean puzzle1Solved,puzzle2Solved,puzzle3Solved;
	Level things;

	/**
	 * 
	 * This method handles the event on the lock image in the level 1 scene
	 * When the image of the lock is clicked by the mouse a puzzle window will open
	 * then the user can try to solve the puzzle in the new window
	 *
	 */
	public void lockClick() {

		PopupWindow puzzle1Window = new PopupWindow();
		Puzzle puzzle_1 = things.getPuzzle(2);
		try {
			puzzle1Solved = puzzle1Window.display("Lock Puzzle", puzzle_1);
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}

	/**
	 * The noteClick handles the event on the note image in the level 3 scene
	 * When the mouse clicks on the image of the note it will open a new puzzle window
	 * and then the user can try to complete the puzzle
	 */
	public void noteClick() {
		try {
			PopupWindow puzzle1 = new PopupWindow();
			lock = things.getPuzzle(3);
			puzzle3Solved = puzzle1.display("Note Cipher", lock);
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}

	/**
	 * The invitationClick method handles the event on the invitation image in the level 1 scene
	 * When the mouse is used to click on the image of the invitation 
	 * a new puzzle window will open and ther user can try to complete the puzzle
	 */
	public void invitationClick() {
		PopupWindow puzzle2Window = new PopupWindow();
		Puzzle puzzle_2 = things.getPuzzle(1);
		try {
			puzzle2Solved = puzzle2Window.display("Invitaion Puzzle", puzzle_2);
		} catch (IOException e1) {
			e1.printStackTrace();
		}			
	}

	/**
	 * The doorClick method handles the event on the door image in level 1 scene
	 * If the door image is clicked by the mouse it will check to see if all the puzzles
	 * are solved, and if all puzzles are solved it will allow the user to continue to the second level.
	 * @param e is a MouseEvent used to change the current scene to the level 2 scene
	 * @throws IOException exceptions for loading the Level2.fxml file
	 */
	public void doorClick(MouseEvent e) throws IOException {
		if ( puzzle1Solved && puzzle2Solved && puzzle3Solved )
		{
			// load the scene from the Level2.fxml file
			Parent l2 = FXMLLoader.load(getClass().getResource("/view/Level2.fxml"));
			Scene level2=new Scene(l2,600,400);
			// get the window that has the button in it and change the scene in it to level 2 scene
			Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
			window.setScene(level2);
			window.show();
		}
		else {
			lockDoor.setText("DOOR IS LOCKED");
		}

	}
	/**
	 * The initialize method will generate level 1 props and puzzles,
	 * as well as an introduction text.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		things = new Level(1);

	}
}

