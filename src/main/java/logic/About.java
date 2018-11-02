package logic;

import javafx.scene.image.Image;

import java.awt.TextField;
import java.io.File;

import javax.swing.ImageIcon;
import javafx.scene.layout.Region;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.*;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.Priority;

public class About implements Page {
	
	public static int ID = 0;
	private VBox root;
	private VBox subPage;
	private Menu menu;
	private Scene scene;
	
	public About() {
		root = new VBox();		
		subPage = new VBox();
		HBox imgs = new HBox();
		subPage.setMinWidth(900);
		subPage.setMaxWidth(800);
		subPage.setMinHeight(800);
		subPage.setStyle("-fx-background-color: #035642;");
		subPage.setStyle(root.getStyle()+"-fx-border-color: black;" + "-fx-border-width: 5");
		subPage.setAlignment(subPage.getAlignment().TOP_CENTER);
		
		Label title1 = new Label("Who are we?");
		title1.setMinWidth(500);
		title1.setMinHeight(75);
		title1.setTextFill(Color.BLACK);
		title1.setStyle("-fx-background-color: #B5A76C;");
		title1.setAlignment(subPage.getAlignment().CENTER);
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
		title2.setAlignment(subPage.getAlignment().CENTER);
		title2.setFont(Font.font("Tahoma", FontWeight.BOLD, 40));
		
		Region spacer3 = new Region();
		spacer3.setPrefHeight(30);
		
		Text txt1 = new Text("We've all experienced the pain of choosign technical electives. With"
				+ " so many technical electives and varying course offerings, it's an ardous ordeal."
				+ " To make matters worse it's all the more difficult finding classes that met your"
				+ " technical interests. This is where we come in! We offer a tool to find recommended"
				+ " courses based on our comprehensive quiz. Never again spend hours trying to find"
				+ " the classes you want.");
	    txt1.setFont(Font.font("Helvetica", FontPosture.REGULAR, 30));
	    TextFlow flow = new TextFlow(txt1);

		
		subPage.getChildren().addAll(title1, spacer1, imgs, spacer2, title2, spacer3, flow);
		
		Background b = new Background();
		menu = new Menu();
		b.add(menu.getRoot());
		b.add(subPage);
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
