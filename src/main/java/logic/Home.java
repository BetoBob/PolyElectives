package logic;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class Home extends Base implements Page {
	
	public static final int ID_PAGE = 1;
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
	
	@Override
	public VBox getRoot() {
		return root;
	}
	
	@Override
	public Menu getMenu() {
		return menu;
	}
	
	@Override
	public Scene getScene() {
		return scene;
	}
}
