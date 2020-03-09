package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class LevelWindow {
	
	private boolean puzzle1Solved = false;
	private boolean puzzle2Solved = false;
	private Label doorLabel;
	
	public void display(int lvlNumber, Level level) throws IOException{
		Group levelGroup = new Group();
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(Integer.toString(lvlNumber));
        window.setWidth(800);
        window.setHeight(600);

        

		Button puzzle1 = new Button("Puzzle 1");
		puzzle1.setTranslateX(50);
		puzzle1.setTranslateY(250);
		
		puzzle1.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
				PuzzleWindow puzzle1Window = new PuzzleWindow();
				Puzzle puzzle_1 = level.getPuzzle(1);
				try {
					puzzle1Solved = puzzle1Window.display("Puzzle", puzzle_1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
		    }
		});
		Button puzzle2 = new Button("Puzzle 2");
		puzzle2.setTranslateX(600);
		puzzle2.setTranslateY(250);
		
		puzzle2.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
				PuzzleWindow puzzle2Window = new PuzzleWindow();
				Puzzle puzzle_2 = level.getPuzzle(2);
				try {
					puzzle2Solved = puzzle2Window.display("Puzzle", puzzle_2);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
		    }
		});
		Button exitButton = new Button("Exit");
		exitButton.setTranslateX(50);
		exitButton.setTranslateY(500);
		
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        Stage stage = (Stage) exitButton.getScene().getWindow();
		        stage.close();
		    }
		});
		doorLabel = new Label();
		doorLabel.setTranslateX(650);
		doorLabel.setTranslateY(475);
		Button openDoor = new Button("Open Door");
		openDoor.setTranslateX(650);
		openDoor.setTranslateY(500);
		openDoor.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	if (puzzle1Solved && puzzle2Solved)
		    	{
					LevelWindow levelWindow = new LevelWindow();
					Level level = new Level(lvlNumber + 1);
					try {
						levelWindow.display(lvlNumber + 1, level);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	}
		    	else {
		    		doorLabel.setText("DOOR IS LOCKED");
		    	}
		    }
		});
		levelGroup.getChildren().addAll(puzzle1, puzzle2, exitButton, openDoor, doorLabel);
        
        Scene scene = new Scene(levelGroup);
        window.setScene(scene);
        window.showAndWait();
	}
}
