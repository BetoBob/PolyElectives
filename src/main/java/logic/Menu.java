package logic;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Menu {
	public static int idPage = 1;
	private VBox root;
	private String currentPage;
	
	public Menu() {
		String fontType = "Tahoma";
		String backGround = "-fx-background-color: #035642;";
		String blackBG = "-fx-border-color: black;";
		String border = "-fx-border-width: 5 0 0 0;";
		currentPage = "";
		root = new VBox();
		root.setId("menu");
		root.setMinWidth(300);
		root.setMinHeight(800); 
		root.setStyle(backGround);
		root.setStyle(root.getStyle()+blackBG+"-fx-border-width: 5;");
		
		Label title = new Label("PolyElectives");
		title.setId("title");
		title.setMinWidth(300);
		title.setMinHeight(210);
		title.setTextFill(Color.BLACK);
		title.setStyle("-fx-background-color: #B5A76C;");
		title.setAlignment(Pos.CENTER);
		title.setFont(Font.font(fontType, FontWeight.BOLD, 40));
		
		Button home = new Button("Home");
		home.setId("home");
		home.setMinWidth(300);
		home.setMinHeight(117);
		home.setTextFill(Color.BLACK);
		home.setStyle(blackBG + border);
		home.setStyle(home.getStyle()+ backGround);
		home.setAlignment(Pos.CENTER);
		home.setFont(Font.font(fontType, FontWeight.NORMAL, 30));
		
		Button tutorial = new Button("Tutorial");
		tutorial.setId("tutorial");
		tutorial.setMinWidth(300);
		tutorial.setMinHeight(117);
		tutorial.setTextFill(Color.BLACK);
		tutorial.setStyle(blackBG + border);
		tutorial.setStyle(tutorial.getStyle()+backGround);
		tutorial.setAlignment(Pos.CENTER);
		tutorial.setFont(Font.font(fontType, FontWeight.NORMAL, 30));
		
		Button quiz = new Button("Quiz");
		quiz.setId("quiz");
		quiz.setMinWidth(300);
		quiz.setMinHeight(117);
		quiz.setTextFill(Color.BLACK);
		quiz.setStyle(blackBG + border);
		quiz.setStyle(quiz.getStyle()+backGround);
		quiz.setAlignment(Pos.CENTER);
		quiz.setFont(Font.font(fontType, FontWeight.NORMAL, 30));
		
		Button about = new Button("About");
		about.setId("about");
		about.setMinWidth(300);
		about.setMinHeight(117);
		about.setTextFill(Color.BLACK);
		about.setStyle(blackBG + border);
		about.setStyle(about.getStyle()+backGround);
		about.setAlignment(Pos.CENTER);
		about.setFont(Font.font(fontType, FontWeight.NORMAL, 30));
		
		Button logout = new Button("Logout");
		logout.setId("logout");
		logout.setMinWidth(300);
		logout.setMinHeight(117);
		logout.setTextFill(Color.BLACK);
		logout.setStyle(blackBG + border);
		logout.setStyle(logout.getStyle()+backGround);
		logout.setAlignment(Pos.CENTER);
		logout.setFont(Font.font(fontType, FontWeight.NORMAL, 30));
		
		root.getChildren().addAll(title, home, tutorial, quiz, about, logout);
	}
	
	public VBox getRoot()
	{
		return root;
	}
	
	public void setCurrentPage(String cp)
	{
		currentPage = cp;
	}
	
	// Highlight the current page 
	public void highlightPage(String page)
	{
		List<Node> l = root.getChildren();
		if (!(currentPage.equals("")))
		{
			for (Node n : l)
			{
				if (n.getId().equals(currentPage))
				{
					Button b = (Button)n;
					b.setTextFill(Color.BLACK);
				}
			}
		}
		for (Node n : l)
		{
			if (n.getId().equals(page))
			{
				Button b = (Button)n;
				b.setTextFill(Color.WHITE);
				setCurrentPage(page);
			}
		}
	}
	
	// Set up a single connection for one button
	public void setUpSingleConnection(final Stage stage, final Page[] pages, final Button b, final int pageID)
	{
		b.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				stage.setScene(pages[pageID].getScene());
				pages[pageID].getMenu().highlightPage(b.getId());
			}
		});
	}
	
	// Set up button connections on the menu
	public void setUpNavigation(Stage stage, Page[] pages) {
		List<Node> l = root.getChildren();
		for (Node n : l)
		{
			if (n.getId().equals("home"))
			{
				setUpSingleConnection(stage, pages, (Button)n, Home.idPage);
			}
			else if (n.getId().equals("about"))
			{
				setUpSingleConnection(stage, pages, (Button)n, About.idPage);
			}
			else if (n.getId().equals("tutorial"))
			{
				setUpSingleConnection(stage, pages, (Button)n, Tutorial.idPage);
			}
		}
	}
	
	
}
