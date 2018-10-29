import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Tutorial implements Page {
	
	public static int ID = 2;
	private VBox root;
	private Menu menu;
	private Scene scene;
	
	public Tutorial() {
		root = new VBox();
		Label l = new Label("Tutorial Page");
		Background b = new Background();
		menu = new Menu();
		b.add(menu.getRoot());
		b.add(l);
		root.getChildren().addAll(b.getRoot());
		scene = new Scene(root, 1200, 800);
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
