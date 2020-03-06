package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	Stage window;
	Scene level1,level2,level3,mainMenu;
	@Override
	public void start(Stage primaryStage) throws IOException {
		Pane root = new Pane();
		Button b = new Button();
		root.getChildren().add(b);
		b.setOnAction(e->{
			PuzzleWindow p = new PuzzleWindow();
			Puzzle puzzle = new Puzzle(0,0,"question","answer");
			try {
				p.display("Puzzle", puzzle);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root,567, 437));
        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
