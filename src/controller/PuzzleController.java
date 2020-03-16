package controller;

/**
 * This method handles the puzzle window actions
 * @author Delara
 */
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Puzzle;

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
	 * This methods gets a Puzzle object and change the instance variables to that
	 * @param p is an object Puzzle for which a new window is created
	 */
	public	void setData(Puzzle p) {
		question.setText(p.getQuestion());
		puzzleAnswer = p.getAnswer();
	}
	
	/**
	 * This method handles the update answer button in the puzzle window 
	 * It checks to see if the user inputed the correct answer in the text field and will change the label according to that
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
