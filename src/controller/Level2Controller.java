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

public class Level2Controller implements Initializable{
	@FXML ImageView door,medicalDoc,phone,comboLock,padLock;
	@FXML Label lockDoor;
	Prop prop;
	boolean puzzle1Solved,puzzle2Solved;
	Level things;

	/**
	 * 
	 * This method handles the event on the pad lock image in the level 2 scene
	 * It opens a puzzle window if it is clicked
	 */
	public void padLockClick() {

		PuzzleWindow puzzle1Window = new PuzzleWindow();
		Puzzle puzzle_1 = things.getPuzzle(1);
		try {
			puzzle1Solved = puzzle1Window.display("PadLock Puzzle", puzzle_1);
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}
	/**
	 * 
	 * This method handles the event on the medical document image in the level 2 scene
	 * It opens a prop window if it is clicked
	 */
	public void medicalDocClick() {
		try {

			PropWindow prop1 = new PropWindow();
			prop = things.getProp(2);

			prop1.display("Medical document", prop,"/photos/medical.jpg");
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}
	/**
	 * This method handles the event on the combination lock image in the level 2 scene
	 * It opens a puzzle window if it is clicked
	 */
	public void comboLockClick() {
		PuzzleWindow puzzle1Window = new PuzzleWindow();
		Puzzle puzzle_2 = things.getPuzzle(2);
		try {
			puzzle2Solved = puzzle1Window.display("Lock Puzzle", puzzle_2);
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
	}
	/**
	 * 
	 * This method handles the event on the phone image in the level 2 scene
	 * It opens a prop window if it is clicked
	 */
	public void phoneClick() {
		try {
			PropWindow prop1 = new PropWindow();
			prop = things.getProp(1);

			prop1.display("Voicmail", prop,"/photos/Phone.png");
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}
	/**
	 * This method handles the event on the door image in level 1 scene
	 * If this is clicked it will check to see if all the puzzles are solved to change the scene to level 3
	 * @param e a MouseEvent used to change the current scene to the level 3 scene
	 * @throws IOException exceptions for loading the Level2.fxml file
	 */
	public void doorClick(MouseEvent e) throws IOException {
		if ( puzzle1Solved && puzzle2Solved )
		{
			// load the scene from the Level3.fxml file
			Parent l3 = FXMLLoader.load(getClass().getResource("/view/Level3.fxml"));
			Scene level3=new Scene(l3,600,400);
			// get the window that has the button in it and change the scene in it to level 3 scene
			Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
			window.setScene(level3);
			window.show();
		}
		else {
			lockDoor.setText("DOOR IS LOCKED");
		}

	}
	/**
	 * This method will generate level 2 props and puzzles as well as intro text
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		things = new Level(2);

	}
}
