package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StoryController {
	@FXML 
	Label story;
	public void setStory(String s) {
		story.setText(s);
	}
}
