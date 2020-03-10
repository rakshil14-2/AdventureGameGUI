package application;


import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
         	
    	primaryStage.setTitle("Adventure Game");
    	       
    	//Creates a button that allows the player to start the game
        Button newGame = new Button();
        newGame.setText("New Game");
        newGame.setOnAction(e->{
        Parent l1;
		try {
			l1 = FXMLLoader.load(getClass().getResource("/Level1.fxml"));
			Scene level1=new Scene(l1,600,400);
	   		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
	   		window.setScene(level1);
	   		window.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

    		});
       
      //Creates a button to demonstrate the player movement demo.
      Button movementDemo = new Button();
      movementDemo.setText("Player Movement Demo");
      movementDemo.setOnAction(e->{
      CharacterMovement movement = new CharacterMovement();
      movement.movement();
      primaryStage.close();

      
      });
      
      //Creates a button to allow the player to exit the game.
      Button exitGame = new Button();
      exitGame.setText("Exit Game");
      exitGame.setOnAction(new EventHandler<ActionEvent>() {
        	
        public void handle(ActionEvent event) {
        	primaryStage.close();
            }
      });
      

      
      Pane root = new Pane();
      
      
      root.getChildren().add(newGame);
      root.getChildren().add(movementDemo);
      root.getChildren().add(exitGame);
      newGame.setLayoutX(50);
      newGame.setLayoutY(350);
      movementDemo.setLayoutX(215);
      movementDemo.setLayoutY(350);
      exitGame.setLayoutX(450);
      exitGame.setLayoutY(350);
      
      primaryStage.setScene(new Scene(root, 600, 400));
      primaryStage.show();    
}}
