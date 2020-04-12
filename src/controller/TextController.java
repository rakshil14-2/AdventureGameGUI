package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
/**
 * This controller is for handling event for the story scene which is just a label with a story text
 *
 */
public class TextController {
	@FXML 
	private Label story;
	@FXML
	private Pane pane;
	/**
	 * This method gets a string for the story and sets the label text to that string
	 * @param s is String of the story
	 */
	public void setText(String s) {
		story.setText(s);
	}
	/**
	 * This method sets the background color for the text window
	 * @param c is a string of a the hex code for the color
	 */
	public void setBackgroundColor(String c) {
		pane.setStyle("-fx-background-color: #" + c);
	}
}
