package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	Stage window;
	Scene level1,level2,level3,mainMenu;
	@Override
	public void start(Stage primaryStage) {
		// this is sample main just to demonstrate how the puzzle window will work
		// once the levels are created we can set handlers to display the puzzle window once a puzzle is clicked
		window = primaryStage;
		Puzzle p = new Puzzle(0,0,"question","answer");
		Button c = new Button("click to change");
		c.setOnAction(e->{
			try {
				boolean ans = PuzzleWindow.display("name",p);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		Pane root = new Pane();
		root.getChildren().add(c);
		mainMenu = new Scene(root,800,600);
		window.setScene(mainMenu);
	    window.setTitle("Virtual Scape Room");
	    window.show();	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
