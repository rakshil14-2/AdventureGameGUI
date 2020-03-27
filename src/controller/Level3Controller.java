package controller;

//importing libraries.
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
import view.PopupWindow;


/**
 * The Level3Controller class handles the event for the level 3 scene loaded from Level3.fxml
 * @author Delara
 */

public class Level3Controller implements Initializable {
	@FXML ImageView diary,note,footnote,knife;
	@FXML 
	Label label,lockDoor;

	Prop prop;
	boolean puzzle1Solved,puzzle2Solved;
	Level things;

	/**
	 * The knifeClick method handles the mouse click event on the knife image in the level 3 scene
	 * It opens a puzzle window if the image of the knife is clicked,
	 * but it will not open the window if the other puzzle in the level has not been solved prior.
	 * This is the final puzzle so it requires the user to have the information from all the other 
	 * game puzzles and props before it will be possible to solve.
	 */
	public void knifeClick() {

		PopupWindow puzzle1Window = new PopupWindow();
		Puzzle puzzle_2 = things.getPuzzle(2);
		try {
			if(puzzle1Solved) {
				puzzle2Solved = puzzle1Window.display("Who Is the Killer?", puzzle_2);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}
	/**
	 * 
	 * The footnoteClick method handles the mouse click event on the footnote image in the level 3 scene.
	 * It opens a prop window if the image of the footnote is clicked and the first puzzle is already solved.
	 * Then the user can read important story information in the prop window to help them advance in the game.
	 */
	public void footnoteClick() {
		try {
			if(puzzle1Solved) {
				PopupWindow prop1 = new PopupWindow();
				prop = things.getProp(2);
				prop1.display("What does it mean??", prop,"/photos/will.jpg");
				label.setText("");
			}
			else {
				label.setText("You need to solve they puzzle first");
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}
	/**
	 * 
	 * The noteClick method handles the mouse click event on the note image in the level 3 scene.
	 * It opens a puzzle window if the image of the note is clicked and then the user is prompted
	 * to solve the puzzle in the puzzle window. 
	 * This puzzle has to be solved before others in this level.
	 */
	public void noteClick() {
		PopupWindow puzzle1Window = new PopupWindow();
		Puzzle puzzle_1 = things.getPuzzle(1);
		try {
			puzzle1Solved = puzzle1Window.display("Small Notes", puzzle_1);
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
	}
	/**
	 * 
	 * The diaryClick method handles the mouse click event on the diary image in the level 3 scene.
	 * It opens a prop window if the image of the diary is clicked, and then the user can read 
	 * important story information in the prop window to help them advance in the game.
	 */
	public void diaryClick() {
		try {

			PopupWindow prop1 = new PopupWindow();
			prop = things.getProp(1);

			prop1.display("Diary notes", prop,"/photos/Diary.jpg");


		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
	/**
	 * The doorClick method handles the mouse click event on the door image in this level 3 scene.
	 * If the image of the door is clicked, it will check to see if all the puzzles are solved 
	 * to change the scene to the winning scene. If not all puzzles have been solved prior to the door 
	 * being clicked it will tell the user the door is locked. 
	 * @param e is a MouseEvent used to change the current scene to the wining scene
	 * @throws IOException exceptions for loading the Level2.fxml file
	 */
	public void doorClick(MouseEvent e) throws IOException {
		if ( puzzle1Solved && puzzle2Solved )
		{
			PopupWindow outro = new PopupWindow();
			outro.display("Level 3 outro", things.getLevelExitText());
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
	 * The initialize method will generate level 3 props and puzzles
	 * as well as introduction text.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		things = new Level(3);
		PopupWindow intro = new PopupWindow();
		try {
			intro.display("Level 3 Intro", things.getLevelIntroText());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
