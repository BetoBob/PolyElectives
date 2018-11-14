package logic;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class Home implements Page {
	
	public static int idPage = 1;
	private VBox root;
	private Menu menu;
	private Scene scene;
	
	public Home() {
		root = new VBox();
	}
	public void renderPage(){
		VBox subPage = new VBox();
		subPage.setMinWidth(900);
		subPage.setMaxWidth(800);
		subPage.setMinHeight(800);
		subPage.setStyle("-fx-background-color: #035642;");
		subPage.setStyle(root.getStyle()+"-fx-border-color: black;" + "-fx-border-width: 5");
		subPage.setAlignment(subPage.getAlignment().TOP_CENTER);
		
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
