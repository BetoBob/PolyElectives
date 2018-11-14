package logic;

//import java.awt.Dimension;
//import java.awt.Toolkit;
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
	public static int ID = 1;
	private VBox root;
	private String currentPage;
	
	public Menu() {
		currentPage = "";
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		root = new VBox();
		root.setId("menu");
		root.setMinWidth(300);
		root.setMinHeight(800); //screenSize.height);
		root.setStyle("-fx-background-color: #035642;");
		root.setStyle(root.getStyle()+"-fx-border-color: black;"+"-fx-border-width: 5;");
		
		Label title = new Label("PolyElectives");
		title.setId("title");
		title.setMinWidth(300);
		title.setMinHeight(210);
		title.setTextFill(Color.BLACK);
		title.setStyle("-fx-background-color: #B5A76C;");
		title.setAlignment(Pos.CENTER);
		title.setFont(Font.font("Tahoma", FontWeight.BOLD, 40));
		
		Button home = new Button("Home");
		home.setId("home");
		home.setMinWidth(300);
		home.setMinHeight(117);
		home.setTextFill(Color.BLACK);
		home.setStyle("-fx-border-color: black;" + "-fx-border-width: 5 0 0 0;");
		home.setStyle(home.getStyle()+"-fx-background-color: #035642;");
		home.setAlignment(Pos.CENTER);
		home.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		
		Button tutorial = new Button("Tutorial");
		tutorial.setId("tutorial");
		tutorial.setMinWidth(300);
		tutorial.setMinHeight(117);
		tutorial.setTextFill(Color.BLACK);
		tutorial.setStyle("-fx-border-color: black;" + "-fx-border-width: 5 0 0 0;");
		tutorial.setStyle(tutorial.getStyle()+"-fx-background-color: #035642;");
		tutorial.setAlignment(Pos.CENTER);
		tutorial.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		
		Button quiz = new Button("Quiz");
		quiz.setId("quiz");
		quiz.setMinWidth(300);
		quiz.setMinHeight(117);
		quiz.setTextFill(Color.BLACK);
		quiz.setStyle("-fx-border-color: black;" + "-fx-border-width: 5 0 0 0;");
		quiz.setStyle(quiz.getStyle()+"-fx-background-color: #035642;");
		quiz.setAlignment(Pos.CENTER);
		quiz.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		
		Button about = new Button("About");
		about.setId("about");
		about.setMinWidth(300);
		about.setMinHeight(117);
		about.setTextFill(Color.BLACK);
		about.setStyle("-fx-border-color: black;" + "-fx-border-width: 5 0 0 0;");
		about.setStyle(about.getStyle()+"-fx-background-color: #035642;");
		about.setAlignment(Pos.CENTER);
		about.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		
		Button logout = new Button("Logout");
		logout.setId("logout");
		logout.setMinWidth(300);
		logout.setMinHeight(117);
		logout.setTextFill(Color.BLACK);
		logout.setStyle("-fx-border-color: black;"+"-fx-border-width: 5 0 5 0;");
		logout.setStyle(logout.getStyle()+"-fx-background-color: #035642;");
		logout.setAlignment(Pos.CENTER);
		logout.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		
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
				System.out.println(b.getId());
				stage.setScene(pages[pageID].getScene());
				pages[pageID].getMenu().highlightPage(b.getId());
				//stage.setFullScreen(true);
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
				setUpSingleConnection(stage, pages, (Button)n, Home.id);
			}
			else if (n.getId().equals("about"))
			{
				setUpSingleConnection(stage, pages, (Button)n, About.idPage);
			}
			else if (n.getId().equals("tutorial"))
			{
				setUpSingleConnection(stage, pages, (Button)n, Tutorial.ID);
			}
		}
	}
	
	
}
