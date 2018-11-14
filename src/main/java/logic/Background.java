package logic;

import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class Background {

	public static final int ID = 0;
	private HBox root;
	
	public Background() {
		root = new HBox();
		root.setId("background");
		root.setStyle("-fx-background-color: linear-gradient(to bottom, #ffffff, #6d6d6d);");
	}
	
	public HBox getRoot() {
		return root;
	}
	
	public void add(Node n)
	{
		root.getChildren().add(n);
	}
}
