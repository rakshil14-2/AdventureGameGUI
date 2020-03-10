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

public class Level2Controller implements Initializable{
	@FXML ImageView door,medicalDoc,phone,comboLock,padLock;
	@FXML Label lockDoor;
	Prop prop;
	boolean puzzle1Solved,puzzle2Solved;
	Level things;
public void padLockClick() {
		
	PuzzleWindow puzzle1Window = new PuzzleWindow();
	Puzzle puzzle_1 = things.getPuzzle(1);
	try {
		puzzle1Solved = puzzle1Window.display("Puzzle", puzzle_1);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}	
	}
	public void medicalDocClick() {
		try {
			
			PropWindow prop1 = new PropWindow();
			prop = new Prop("ssss",1,1);
			
			prop1.display("Medical document", prop,"/Phone.png");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
	public void comboLockClick() {
		PuzzleWindow puzzle1Window = new PuzzleWindow();
		Puzzle puzzle_2 = things.getPuzzle(2);
		try {
			puzzle2Solved = puzzle1Window.display("Puzzle", puzzle_2);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}
	public void phoneClick() {
		try {
			PropWindow prop1 = new PropWindow();
			prop = new Prop("ssss",1,1);
			
			prop1.display("Voicmail", prop,"/Phone.png");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
	public void doorClick(MouseEvent e) throws IOException {
		if ( puzzle1Solved && puzzle2Solved )
    	{
			Parent l3 = FXMLLoader.load(getClass().getResource("/Level3.fxml"));
			Scene level3=new Scene(l3,600,400);
			Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
			window.setScene(level3);
			window.show();
    	}
//    	else if (lvlNumber == 3) {
//    		// game over screen here
//    	}
    	else {
    		lockDoor.setText("DOOR IS LOCKED");
    	}
    
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		things = new Level(2);
		
	}
}
