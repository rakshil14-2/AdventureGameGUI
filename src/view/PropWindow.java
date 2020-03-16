package view;

import java.io.IOException;

import controller.PropController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Prop;

public class PropWindow {
	public void display(String title,Prop p,String url) throws IOException{
        Stage window = new Stage();
        
        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        
        // load the scene from the Prop.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Prop.fxml"));
        Parent root = loader.load();
        PropController controller = loader.<PropController>getController();
        controller.setData(new Prop(p),url);
        

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(root,800, 600);
        window.setScene(scene);
        window.showAndWait();
        
    }


}
