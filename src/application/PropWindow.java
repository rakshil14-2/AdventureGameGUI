package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PropWindow {
	public void display(String title,Prop p) throws IOException{
        Stage window = new Stage();
        
        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Prop.fxml"));
        Parent root = loader.load();
        PropController controller = loader.<PropController>getController();
        controller.setData(new Prop(p),"/Phone.png");
        
//        Parent root = FXMLLoader.load(getClass().getResource("Puzzle.fxml"));
//        root.getChildrenUnmodifiable().getClass()
        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(root,800, 600);
        window.setScene(scene);
        window.showAndWait();
        
    }


}
