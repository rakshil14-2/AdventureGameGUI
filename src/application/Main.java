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
		Button startButton = new Button("Start");
		Button prop = new Button();
		Prop p = new Prop("dddddddd",0,0);
		prop.setOnAction(e->{
			
			PropWindow pr = new PropWindow();
			try {
				pr.display("title", p);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		startButton.setTranslateX(100);
		startButton.setTranslateY(100);
		root.getChildren().add(startButton);
		root.getChildren().add(prop);
		startButton.setOnAction(e->{
			LevelWindow level = new LevelWindow();
			Level level1 = new Level(1);
			try {
				level.display(1, level1);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(new Scene(root,800, 600));
        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
