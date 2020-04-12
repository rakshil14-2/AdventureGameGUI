package controller;

//importing libraries
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
 * The Level2Controller class handles the event for the level 1 scene loaded from Level1.fxml
 * @author Delara
 * 
 */

public class Level2Controller implements Initializable{
	@FXML  private ImageView door,medicalDoc,phone,comboLock,padLock;
	private Prop prop;
	private boolean puzzle1Solved,puzzle2Solved;
	private Level things;
	
	/**
	 * The initialize  method will generate level 2 props and puzzles 
	 * as well as introduction and outro text.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		things = new Level(2);
		PopupWindow intro = new PopupWindow();
		try {
			intro.display("Level e Intro", things.getLevelIntroText(),"F3B566");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * The padLockCLick method handles the event on the pad lock image in the level 2 scene
	 * If the user mouse clicks the image of the pad lock it opens a new puzzle window
	 * in which a new puzzle will appear for the user to complete.
	 */
	public void padLockClick() {

		PopupWindow puzzle1Window = new PopupWindow();
		Puzzle puzzle_1 =new Puzzle( things.getPuzzle(1));
		try {
			// if the puzzle has been solved before this will prevent the user from opening the window again
			// instead there will be a pop up wondow that says they already solved this puzzle
			if(puzzle1Solved) {
				PopupWindow doorLocked = new PopupWindow();
				doorLocked.display("Puzzle already solved","You have already solved this puzzle!","05C8ED");
			}
			else
				puzzle1Solved = puzzle1Window.display("PadLock Puzzle", puzzle_1);
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}
	/**
	 * The medicalDocClick method handles the event on the medical document image in the level 2 scene
	 * If the image of the medical doument is mouse clicked it opens a new prop window
	 * which contains information for the user to read about the story to help them solve future puzzles,
	 * and advance in the game.
	 */
	public void medicalDocClick() {
		try {

			PopupWindow prop1 = new PopupWindow();
			prop = new Prop(things.getProp(2));

			prop1.display("Medical document", prop,"/photos/medical.jpg");
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}
	/**
	 * The comboLockClick method handles the event on the combination lock image in the level 2 scene
	 * It opens a puzzle window if the image of the combination clock is mouse clicked,
	 * which gives ther user a new puzzle they must complete.
	 */
	public void comboLockClick() {
		PopupWindow puzzle1Window = new PopupWindow();
		Puzzle puzzle_2 = new Puzzle(things.getPuzzle(2));
		try {
			// if the puzzle has been solved before this will prevent the user from opening the window again
			// instead there will be a pop up wondow that says they already solved this puzzle
			if(puzzle2Solved) {
				PopupWindow doorLocked = new PopupWindow();
				doorLocked.display("Puzzle already solved","You have already solved this puzzle!","05C8ED");
			}
			else
				puzzle2Solved = puzzle1Window.display("Lock Puzzle", puzzle_2);
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
	}
	/**
	 * The phoneClick method handles the event on the phone image in the level 2 scene
	 * It opens a prop window if the image of the phone is mouse clicked
	 * which contains information for the user to read about the story to help them solve future puzzles,
	 * and advance in the game.
	 */
	public void phoneClick() {
		try {
			PopupWindow prop1 = new PopupWindow();
			prop = new Prop(things.getProp(1));

			prop1.display("Voicmail", prop,"/photos/Phone.png");
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}
	/**
	 * The doorClick method handles the event on the door image in level 1 scene
	 * If the image of the door is mouse clicked it will check to see if all the puzzles are solved
	 * and if they are it allows the user to then continue to the third level.
	 * Otherwise, it tells the user the door is still locked.
	 * @param e a MouseEvent used to change the current scene to the level 3 scene
	 * @throws IOException exceptions for loading the Level2.fxml file
	 */
	public void doorClick(MouseEvent e) throws IOException {
		//if-else statements are used to check for puzzles being solved
		
		if ( puzzle1Solved && puzzle2Solved )
		{
			PopupWindow outro = new PopupWindow();
			outro.display("Level 2 outro", things.getLevelExitText(),"F3B566");
			
			// load the scene from the Level3.fxml file
			Parent l3 = FXMLLoader.load(getClass().getResource("/view/Level3.fxml"));
			Scene level3=new Scene(l3,600,400);
			// get the window that has the button in it and change the scene in it to level 3 scene
			Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
			window.setScene(level3);
			window.show();
		}
		else {
			PopupWindow doorLocked = new PopupWindow();
			doorLocked.display("Door is locked", "You need to solve all the puzzle before you can open this door!","ED2805");
		}

	}
}
