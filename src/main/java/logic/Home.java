package logic;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class Home extends Base implements Page {
	
	public static final int idPage = 1;
	private VBox root;
	private Menu menu;
	private Scene scene;
	
	public Home() {
		renderPage();
	}
	public void renderPage(){
		root = new VBox();
		VBox subPage = createSub(root);		
		Background b = new Background();
		menu = new Menu();
		b.add(menu.getRoot());
		b.add(subPage);
		root.getChildren().add(b.getRoot());
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
