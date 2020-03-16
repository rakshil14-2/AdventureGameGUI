package controller;

/**
 * This class handles the event for the level 1 scene loaded from the Level1.fxml
 * @author Delara
 * 
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import model.Prop;
import model.Puzzle;
import view.PropWindow;
import view.PuzzleWindow;

public class Level3Controller implements Initializable {
	@FXML ImageView diary,note,footnote,knife;
	@FXML 
	Label label,lockDoor;

	Prop prop;
	boolean puzzle1Solved,puzzle2Solved;
	Level things;

	/**
	 * 
	 * This method handles the event on the knife image in the level 3 scene
	 * It opens a puzzle window if it is clicked but it will not open the window if the other puzzle has not been solved first
	 */
	public void knifeClick() {

		PuzzleWindow puzzle1Window = new PuzzleWindow();
		Puzzle puzzle_2 = things.getPuzzle(2);
		try {
			if(puzzle1Solved) {
				puzzle2Solved = puzzle1Window.display("Who Is the Killer?", puzzle_2);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
	/**
	 * 
	 * This method handles the event on the footnote image in the level 3 scene
	 * It opens a prop window if it is clicked and puzzle 1 is solved
	 */
	public void footnoteClick() {
		try {
			if(puzzle1Solved) {
				PropWindow prop1 = new PropWindow();
				prop = things.getProp(2);
				prop1.display("What does it mean??", prop,"/photos/will.jpg");
				label.setText("");
			}
			else {
				label.setText("You need to solve they puzzle first");
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
	/**
	 * 
	 * This method handles the event on the note image in the level 3 scene
	 * It opens a puzzle window if it is clicked
	 */
	public void noteClick() {
		PuzzleWindow puzzle1Window = new PuzzleWindow();
		Puzzle puzzle_1 = things.getPuzzle(1);
		try {
			puzzle1Solved = puzzle1Window.display("Small Notes", puzzle_1);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}
	/**
	 * 
	 * This method handles the event on the diary image in the level 3 scene
	 * It opens a prop window if it is clicked
	 */
	public void diaryClick() {
		try {

			PropWindow prop1 = new PropWindow();
			prop = things.getProp(1);

			prop1.display("Diary notes", prop,"/photos/Diary.jpg");


		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
	/**
	 * This method handles the event on the door image in level 1 scene
	 * If this is clicked it will check to see if all the puzzles are solved to change the scene to wining scene
	 * @param e a MouseEvent used to change the current scene to the wining scene
	 * @throws IOException exceptions for loading the Level2.fxml file
	 */
	public void doorClick(MouseEvent e) throws IOException {
		if ( puzzle1Solved && puzzle2Solved )
		{
			// load the scene from the Won.fxml file
			Parent root = FXMLLoader.load(getClass().getResource("/view/Won.fxml"));
			Scene gameover=new Scene(root,600,400);
			// get the window that has the button in it and change the scene in it to wining scene
			Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
			window.setScene(gameover);
			window.show();
		}

		else {
			lockDoor.setText("DOOR IS LOCKED");
		}

	}
	/**
	 * This method will generate level 3 props and puzzles as well as intro text
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		things = new Level(3);

	}
}
