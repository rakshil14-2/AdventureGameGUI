package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PropController {
	@FXML
	private Label propText;
	@FXML
	private ImageView img;
	public Label getPropText() {
		return propText;
	}

	public void setPropText(Label propText) {
		this.propText = propText;
	}
	public	void setData(Prop p,String i) {
		propText.setText(p.getDescription());
		Image r = new Image(i);
		img.setImage(r);
	}
}
