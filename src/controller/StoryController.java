package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
/**
 * This controller is for handling event for the story scene which is just a label with a story text
 *
 */
public class StoryController {
	@FXML 
	Label story;
	/**
	 * This method gets a string for the story and sets the label text to that string
	 * @param s is String of the story
	 */
	public void setStory(String s) {
		story.setText(s);
	}
}
