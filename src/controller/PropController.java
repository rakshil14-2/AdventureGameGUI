package controller;

//importing libraries
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Prop;

/**
* The PropController class handles the text for the props from the fxml files.
* Props are used to give the user more information about the stoyline and
* the information helps them solve future puzzles.
*/
public class PropController {
	@FXML
	private Label propText;
	@FXML
	private ImageView img;
	public Label getPropText() {
		return propText;
	}
	
	/**
	* The setPropText method is a setter which takes a paramater propText and sets it for each prop.
	* @param propText is the text for a given prop.
	*/
	public void setPropText(Label propText) {
		this.propText = propText;
	}
	/**
	* The setData method is a setter which takes parameters for a prop and an image 
	* and sets them as the "data" for a given prop. 
	* @param p is a prop with a description.
	* @param i is a string which contains an image to be loaded with the prop.
	*/
	public	void setData(Prop p,String i) {
		propText.setText(p.getText());
		Image r = new Image(i);
		img.setImage(r);
	}
}
