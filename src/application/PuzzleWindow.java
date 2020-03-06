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
		public static boolean display(String title,Puzzle p) throws IOException{
	        Stage window = new Stage();
	        
	        //Block events to other windows
	        window.initModality(Modality.APPLICATION_MODAL);
	        window.setTitle(title);
	        window.setMinWidth(250);
	        // a button to click on when answer is updated
	        Button update = new Button ("Update answer");
	        update.setLayoutX(301);
	        update.setLayoutY(246);
	        
	        //a field where the user can put their answer in
	        TextField ans = new TextField("Enter answer here");
	        ans.setLayoutX(90);
	        ans.setLayoutY(245);
	        
	        // a label indicating if the answer is right or wrong
	        Label check = new Label("No answer yet");
	        check.setLayoutX(90);
	        check.setLayoutY(304);
	        
	        //a label containing the question for the puzzle
	        Label q = new Label(p.getQuestion());
	        q.setLayoutX(90);
	        q.setLayoutY(39);
	        
	        //this button closes the window if it's clicked
	        Button close = new Button("Close");
	        close.setLayoutX(310);
	        close.setLayoutY(300);
	        
	        // if update button is clicked it checks to see if the answer is correct or not
	        update.setOnAction(e->{
	        	if(ans.getText().equals(p.getAnswer())) {
	        		check.setText("Your answer is correct!");
	        				solved = true;
	        	}else {
	        		check.setText("Try again!");
	        	}
	        });
	        
	        close.setOnAction(e->{
	        	window.close();
	        	
	        });
	        // adds everything to the pane
	        Pane root = new Pane();
	        root.getChildren().add(q);
	        root.getChildren().add(ans);
	        root.getChildren().add(update);
	        root.getChildren().add(check);
	        root.getChildren().add(close);
	        
	        

	       
	        //Display window and wait for it to be closed before returning
	        Scene scene = new Scene(root,500,400);
	        window.setScene(scene);
	        window.showAndWait();
	        return solved;
	    }
	

}
