package application;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

public class Level3Controller implements Initializable {
	@FXML ImageView diary,note,footnote,knife;
	@FXML 
	Label label,lockDoor;
	
	Prop prop;
	boolean puzzle1Solved,puzzle2Solved;
	Level things;
	
public void knifeClick() {
		
	PuzzleWindow puzzle1Window = new PuzzleWindow();
	Puzzle puzzle_2 = things.getPuzzle(2);
	try {
		puzzle2Solved = puzzle1Window.display("Puzzle", puzzle_2);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}	
	}

	public void footnoteClick() {
		try {
			if(puzzle1Solved) {
				PropWindow prop1 = new PropWindow();
				prop = things.getProp(2);
				prop1.display("What does it mean??", prop,"/Phone.png");
				label.setText("");
				}
			else {
				label.setText("You need to solve they puzzle first");
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
	public void noteClick() {
		PuzzleWindow puzzle1Window = new PuzzleWindow();
		Puzzle puzzle_1 = things.getPuzzle(1);
		try {
			puzzle1Solved = puzzle1Window.display("Puzzle", puzzle_1);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}
	public void diaryClick() {
		try {
			PropWindow prop1 = new PropWindow();
			prop = things.getProp(1);
			
			prop1.display("Diary notes", prop,"/Phone.png");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
	public void doorClick(MouseEvent e) throws IOException {
		if ( puzzle1Solved && puzzle2Solved )
    	{
			Parent root = FXMLLoader.load(getClass().getResource("/GameOver.fxml"));
			Scene gameover=new Scene(root,600,400);
			Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
			window.setScene(gameover);
			window.show();
    	}

    	else {
    		lockDoor.setText("DOOR IS LOCKED");
    	}
    
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		things = new Level(3);
		
	}
}
