package logic;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Tutorial extends Base implements Page {
	
	public static final int ID_PAGE = 2;
	private VBox root;
	private Menu menu;
	private Scene scene;
	
	public Tutorial() {
		renderPage();
	}
	public void renderPage() {
		
		root = new VBox();
		VBox subPage = createSub(root);
		HBox imgs = new HBox();
		Background b = new Background();
		menu = new Menu();
		b.add(menu.getRoot());
		b.add(subPage);
		root.getChildren().addAll(b.getRoot());
		scene = new Scene(root, 1200, 800);
		
		Label title = new Label("Tutorial");
		title.setId("title");
		title.setMinWidth(300);
		title.setMinHeight(210);
		title.setTextFill(Color.BLACK);
		title.setAlignment(Pos.CENTER);
		title.setFont(Font.font("Tahoma", FontWeight.BOLD, 40));
		
		Label step1 = new Label("Step 1:");
		step1.setMinWidth(500);
		step1.setMinHeight(75);
		step1.setTextFill(Color.BLACK);
		step1.setStyle("-fx-background-color: #B5A76C;");
		subPage.getAlignment();
		step1.setAlignment(Pos.CENTER);
		step1.setFont(Font.font("Tahoma", FontWeight.THIN, 40));
		
		Region spacer1 = new Region();
		spacer1.setPrefHeight(60);
		
		ImageView stepPlaceholder = new ImageView(new Image(getClass().getResourceAsStream("placeholder.png"), 1000, 200, true, true));
		imgs.setAlignment(Pos.TOP_LEFT);
		imgs.getChildren().addAll(stepPlaceholder);
		
		subPage.getChildren().addAll(title,step1,spacer1,stepPlaceholder);		

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
