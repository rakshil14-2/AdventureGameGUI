package application;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
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

public class Level1Controller implements Initializable{
	@FXML ImageView notePuzzle,lockPuzzle,invitaionPuzzle,door;
	@FXML Label lockDoor;
	Puzzle lock;
	boolean puzzle1Solved,puzzle2Solved,puzzle3Solved;
	Level things;
	public void lockClick() {
		
		PuzzleWindow puzzle1Window = new PuzzleWindow();
		Puzzle puzzle_1 = things.getPuzzle(2);
		try {
			puzzle1Solved = puzzle1Window.display("Lock Puzzle", puzzle_1);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
	public void noteClick() {
		try {
			PuzzleWindow puzzle1 = new PuzzleWindow();
			lock = things.getPuzzle(3);
			puzzle3Solved = puzzle1.display("Note Cipher", lock);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
	public void invitationClick() {
		PuzzleWindow puzzle2Window = new PuzzleWindow();
		Puzzle puzzle_2 = things.getPuzzle(1);
		try {
			puzzle2Solved = puzzle2Window.display("Invitaion Puzzle", puzzle_2);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}			
	}
	public void doorClick(MouseEvent e) throws IOException {
		if ( puzzle1Solved && puzzle2Solved && puzzle3Solved )
    	{
			Parent l2 = FXMLLoader.load(getClass().getResource("/Level2.fxml"));
			Scene level2=new Scene(l2,600,400);
			Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
			window.setScene(level2);
			window.show();
    	}
    	else {
    		lockDoor.setText("DOOR IS LOCKED");
    	}
    
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		things = new Level(1);
		
	}
}

