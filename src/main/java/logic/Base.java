package logic;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class Base {
	public VBox createSub(VBox root) {
		VBox subPage = new VBox();
		subPage.setMinWidth(900);
		subPage.setMaxWidth(800);
		subPage.setMinHeight(800);
		subPage.setStyle("-fx-background-color: #035642;");
		subPage.setStyle(root.getStyle()+"-fx-border-color: black;" + "-fx-border-width: 5");
		subPage.getAlignment();
		subPage.setAlignment(Pos.TOP_CENTER);
		return subPage;
	}
}
