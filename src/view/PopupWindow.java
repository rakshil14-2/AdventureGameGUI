package view;

import java.io.IOException;
/**
 * This class used to generate pop up windows 
 * There are three different display methods that depending on their parameter do different things
 * On displays a puzzle window, one displays a prop window and the other a story window
 */

import controller.PropController;
import controller.PuzzleController;
import controller.TextController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Prop;
import model.Puzzle;

public class PopupWindow {

	/**
	 * The display method creates a new window by getting a title, and a Puzzle object from the user
	 *
	 * @param title will be the title of the window
	 * @param p is a Puzzle object used to get the answer and the question for the window
	 *
	 * @return boolean this checks to see if the user input the correct answer for the puzzle
	 * @throws IOException for loading the puzzle.fxml file
	 */
	public boolean display(String title,Puzzle p) throws IOException{
		Stage window = new Stage();

		//Block events to other windows
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);

		// load the scene from the Puzzle.fxml file
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Puzzle.fxml"));
		Parent root = loader.load();
		PuzzleController controller = loader.<PuzzleController>getController();
		controller.setData(new Puzzle(p));


		//Display window and wait for it to be closed before returning
		Scene scene = new Scene(root,800, 600);
		window.setScene(scene);
		window.showAndWait();
		return controller.isSolved();
	}

	/**
	 * The display method creates a new window by getting a title, a Prop object and a url that contains the
	 * name of the image for that prop.
	 *
	 * @param title is the title of the window.
	 * @param p is a Prop object used to get the image and the descriptive text for the window.
	 * @param url is a string containing the respective prop image name to load the image for the prop.
	 *
	 * @throws IOException for loading the puzzle.fxml file
	 */

	public void display(String title,Prop p,String url) throws IOException{
		Stage window = new Stage();

		//Block events to other windows
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);

		// load the scene from the Prop.fxml file
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Prop.fxml"));
		Parent root = loader.load();
		PropController controller = loader.<PropController>getController();
		controller.setData(new Prop(p),url);


		//Display window and wait for it to be closed
		Scene scene = new Scene(root,800, 600);
		window.setScene(scene);
		window.showAndWait();

	}
	
	/**
	 * This display method is for making a pop up window for the intro and outro text of the story 
	 * It gets a string as a story and title for the window
	 * @param title is a string for the title of the window
	 * @param story a string that is the story or text that will show up in the pop up window
	 * @param color is a string for the hex color of the background
	 * @throws IOException is an exception thrown when opening the fxml file
	 */
	public void display(String title,String story,String color) throws IOException {
		Stage window = new Stage();

		//Block events to other windows
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);

		// load the scene from the TextWindow.fxml file
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TextWindow.fxml"));
		Parent root = loader.load();
		TextController controller = loader.<TextController>getController();
		controller.setText(story);
		controller.setBackgroundColor(color);
		//Display window and wait for it to be closed
		Scene scene = new Scene(root);
		window.setScene(scene);
		window.showAndWait();
	}

}
