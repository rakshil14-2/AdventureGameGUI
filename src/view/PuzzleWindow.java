package view;
import java.io.IOException;

import controller.PuzzleController;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Puzzle;

/**
 * This class will create a new window that will pop up when the user clicks on any puzzle
 * @author Delara
 *
 */
public class PuzzleWindow {
	    private boolean solved = false;
	    /**
	     * This method creates a new window by getting a title, and a Puzzle object from the user
	     * @param title this will be the title of the window
	     * @param p a Puzzle object used to get the answer and the question for the window
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
	

}
