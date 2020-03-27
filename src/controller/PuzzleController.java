package controller;

//importing libraries
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Puzzle;


/**
 * The PuzzleController class handles the puzzle window actions.
 * @author Delara
 */

public class PuzzleController{
	
	@FXML
	private Button update;
	@FXML
	private Label check;
	@FXML
	private TextField answer;
	@FXML
	private Label question;
	
	private boolean solved = false;
	
	/**
	 * getter for the instance variable is solved
	 * @return boolean solved
	 */
	
	public boolean isSolved() {
		return solved;
	}

	/**
	 * setter for the instance variable is solved
	 * @param boolean solved
	 */
	
	public void setSolved(boolean solved) {
		this.solved = solved;
	}

	private String puzzleAnswer;
	
	/**
	 * The setData method gets a Puzzle object and changes the instance variables
	 * to the given puzzle object.
	 * @param p is an object Puzzle for which a new window is created.
	 */
	public	void setData(Puzzle p) {
		question.setText(p.getQuestion());
		puzzleAnswer = p.getAnswer();
	}
	
	/**
	 *
	 * The checkAnswer method handles the update answer button in the puzzle window.
	 * The update Answer button is a button which takes a mouse click event from the user.
	 * The method checks to see if the user inputed the correct answer in the text field for the puzzle,
	 * and will change the label according to that. If the correct answer is inputted it tells the user
	 * they are correct, and otherwise if their inputted answer is incorrect it asks the user to make 
	 * another attempt at solving the puzzle.
	 *
	 */
	public void checkAnswer() {
		if(answer.getText().equalsIgnoreCase(puzzleAnswer)) {
			check.setText("Your answer was Correct!");
			solved = true;
		}
		else
			check.setText("The answer you put was not the right answer. Please try again!");
	}

	
}
