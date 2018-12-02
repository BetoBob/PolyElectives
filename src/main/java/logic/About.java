package logic;

import javafx.scene.image.Image;

import javafx.scene.layout.Region;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.*;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class About extends Base implements Page{
	
	public static final int ID_PAGE = 0;
	private VBox root;
	private Menu menu;
	private Scene scene;
	
	public About() {
		renderPage();
	}
	public boolean renderPage() {
		root = new VBox();		
		VBox subPage = createSub(root);
		HBox imgs = new HBox();
		Background b = new Background();
		menu = new Menu();
		b.add(menu.getRoot());
		b.add(subPage);
		root.getChildren().addAll(b.getRoot());
		scene = new Scene(root, 1200, 800);
		getScene();
		getRoot();
		Label title1 = new Label("Who are we?");
		title1.setMinWidth(500);
		title1.setMinHeight(75);
		title1.setTextFill(Color.BLACK);
		title1.setStyle("-fx-background-color: #B5A76C;");
		subPage.getAlignment();
		title1.setAlignment(Pos.CENTER);
		title1.setFont(Font.font("Tahoma", FontWeight.BOLD, 40));
		
		Region spacer1 = new Region();
		spacer1.setPrefHeight(60);
		
		ImageView antonio = new ImageView(new Image(getClass().getResourceAsStream("selfie.png"), 147, 147, true, true));
		ImageView nicole = new ImageView(new Image(getClass().getResourceAsStream("nicole.jpeg"), 147, 147, true, true));
		ImageView patrick = new ImageView(new Image(getClass().getResourceAsStream("patrick.jpeg"), 163, 147, true, true));
		ImageView jay = new ImageView(new Image(getClass().getResourceAsStream("jay.jpeg"), 147, 147, true, true));
		ImageView robert = new ImageView(new Image(getClass().getResourceAsStream("robert.jpeg"), 147, 147, true, true));
		ImageView steven = new ImageView(new Image(getClass().getResourceAsStream("steven.jpeg"), 147, 147, true, true));

		imgs.setAlignment(Pos.TOP_LEFT);

		imgs.getChildren().addAll(antonio, nicole, patrick, jay, robert, steven);
		
		Region spacer2 = new Region();
		spacer2.setPrefHeight(60);
		
		Label title2 = new Label("Our Mission");
		title2.setMinWidth(500);
		title2.setMinHeight(75);
		title2.setTextFill(Color.BLACK);
		title2.setStyle("-fx-background-color: #B5A76C;");
		subPage.getAlignment();
		title2.setAlignment(Pos.CENTER);
		title2.setFont(Font.font("Tahoma", FontWeight.BOLD, 40));
		
		Region spacer3 = new Region();
		spacer3.setPrefHeight(30);
		
		Text txt1 = new Text("We've all experienced the pain of choosing technical electives. With"
				+ " so many technical electives and varying course offerings, it's an ardous ordeal."
				+ " To make matters worse it's all the more difficult finding classes that met your"
				+ " technical interests. This is where we come in! We offer a tool to find recommended"
				+ " courses based on our comprehensive quiz. Never again spend hours trying to find"
				+ " the classes you want.");
	    txt1.setFont(Font.font("Helvetica", FontPosture.REGULAR, 26));
	    TextFlow flow = new TextFlow(txt1);
	    flow.setMaxWidth(800);
	
		subPage.getChildren().addAll(title1, spacer1, imgs, spacer2, title2, spacer3, flow);
		
		return true;
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
