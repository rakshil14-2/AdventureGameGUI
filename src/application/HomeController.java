package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeController implements Initializable {
	@FXML
	Button b;
	Puzzle p = new Puzzle(0,0,"question","answer");
	
	
	public void clickButton(ActionEvent e) throws IOException {
		 Parent l1 = FXMLLoader.load(getClass().getResource("/Level1.fxml"));
		 Scene level1=new Scene(l1,600,400);
//		 Level1Controller controller = new Level1Controller();
//		 controller.setData(p, p, p);
		 
		 Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		 window.setScene(level1);
		 window.show();
	}
	public void mouseClick() {
		System.out.print("image was clicked");
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
}
