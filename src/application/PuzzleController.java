package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PuzzleController{
	
	@FXML
	Button update;
	@FXML
	Label check;
	@FXML
	TextField answer;
	@FXML
	Label question;
	
	private boolean solved = false;
	String puzzleAnswer;
	public	void setData(Puzzle p) {
		question.setText(p.getQuestion());
		puzzleAnswer = p.getAnswer();
	}
	
	public void checkAnswer() {
		if(answer.getText().equalsIgnoreCase(puzzleAnswer)) {
			check.setText("Your answer was Correct!");
			solved = true;
		}
		else
			check.setText("The answer you put was not the right answer. Please try again!");
	}

	public Button getUpdate() {
		return update;
	}

	public void setUpdate(Button update) {
		this.update = update;
	}

	public Label getCheck() {
		return check;
	}

	public void setCheck(Label check) {
		this.check = check;
	}

	public TextField getAnswer() {
		return answer;
	}

	public void setAnswer(TextField answer) {
		this.answer = answer;
	}

	public Label getQuestion() {
		return question;
	}

	public void setQuestion(Label question) {
		this.question = question;
	}

	public boolean isSolved() {
		return solved;
	}

	public void setSolved(boolean solved) {
		this.solved = solved;
	}

	public String getPuzzleAnswer() {
		return puzzleAnswer;
	}

	public void setPuzzleAnswer(String puzzleAnswer) {
		this.puzzleAnswer = puzzleAnswer;
	}
	
}
