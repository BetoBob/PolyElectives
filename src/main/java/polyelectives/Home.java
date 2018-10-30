package polyelectives;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Home implements Page {
	
	public static int id = 1;
	private VBox root;
	private Menu menu;
	private Scene scene;
	
	public Home() {
		root = new VBox();
		Label l = new Label("Home Page");
		Background b = new Background();
		menu = new Menu();
		b.add(menu.getRoot());
		b.add(l);
		root.getChildren().add(b.getRoot());
		scene = new Scene(root, 1200, 800); //screenSize.width, screenSize.height);
	}
	
	public VBox getRoot() {
		return root;
	}
	
	public Menu getMenu() {
		return menu;
	}
	
	public Scene getScene() {
		return scene;
	}
}
