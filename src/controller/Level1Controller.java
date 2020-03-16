package controller;

/**
 * This class handles the event for the level 1 scene loaded from the Level1.fxml
 * @author Delara
 * 
 */
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
import view.PuzzleWindow;

public class Level1Controller implements Initializable{
	@FXML ImageView notePuzzle,lockPuzzle,invitaionPuzzle,door;
	@FXML Label lockDoor;
	Puzzle lock;
	boolean puzzle1Solved,puzzle2Solved,puzzle3Solved;
	Level things;

	/**
	 * 
	 * This method handles the event on the lock image in the level 1 scene
	 * It opens a puzzle window if it is clicked
	 */
	public void lockClick() {

		PuzzleWindow puzzle1Window = new PuzzleWindow();
		Puzzle puzzle_1 = things.getPuzzle(2);
		try {
			puzzle1Solved = puzzle1Window.display("Lock Puzzle", puzzle_1);
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}

	/**
	 * This method handles the event on the note image in the level 3 scene
	 * It opens a puzzle window if it is clicked
	 */
	public void noteClick() {
		try {
			PuzzleWindow puzzle1 = new PuzzleWindow();
			lock = things.getPuzzle(3);
			puzzle3Solved = puzzle1.display("Note Cipher", lock);
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}

	/**
	 * This method handles the event on the invitation image in the level 1 scene
	 * It opens a puzzle window if it is clicked
	 */
	public void invitationClick() {
		PuzzleWindow puzzle2Window = new PuzzleWindow();
		Puzzle puzzle_2 = things.getPuzzle(1);
		try {
			puzzle2Solved = puzzle2Window.display("Invitaion Puzzle", puzzle_2);
		} catch (IOException e1) {
			e1.printStackTrace();
		}			
	}

	/**
	 * This method handles the event on the door image in level 1 scene
	 * If this is clicked it will check to see if all the puzzles are solved to change the scene to level 2
	 * @param e a MouseEvent used to change the current scene to the level 2 scene
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
	 * This method will generate level 1 props and puzzles as well as intro text
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		things = new Level(1);

	}
}

