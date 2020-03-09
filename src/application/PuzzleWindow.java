package application;
import java.io.IOException;

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


public class PuzzleWindow {
	    static boolean solved = false;
		public boolean display(String title,Puzzle p) throws IOException{
	        Stage window = new Stage();
	        
	        //Block events to other windows
	        window.initModality(Modality.APPLICATION_MODAL);
	        window.setTitle(title);
	        window.setMinWidth(250);
	        
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("Puzzle.fxml"));
	        Parent root = loader.load();
	        PuzzleController controller = loader.<PuzzleController>getController();
	        controller.setData(new Puzzle(p));
	        
//	        Parent root = FXMLLoader.load(getClass().getResource("Puzzle.fxml"));
//	        root.getChildrenUnmodifiable().getClass()
	        //Display window and wait for it to be closed before returning
	        Scene scene = new Scene(root,800, 600);
	        window.setScene(scene);
	        window.showAndWait();
	        return controller.isSolved();
	    }
	

}
