package logic;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Home extends Base implements Page {
	
	public static final int ID_PAGE = 1;
	private VBox root;
	private Menu menu;
	private Scene scene;
	private VBox subpage;
	
	public Home() {
		renderPage();
	}
	public void renderPage(){
		String fontType = "Tahoma";
		String blackBG = "-fx-border-color: black;";
		String goldBG = "-fx-background-color: #B5A76C;";
		String greenBG = "-fx-background-color: #035642;";
		
		HBox buttons = new HBox();
		buttons.setId("buttons");
		buttons.setAlignment(Pos.CENTER);
		
		Label title = new Label("PolyElectives");
		title.setId("title");
		title.setTextFill(Color.BLACK);
		title.setAlignment(Pos.CENTER);
		title.setFont(Font.font(fontType, FontWeight.NORMAL, 120));
		
		Label beforeSpacing = new Label("\n\n");
		beforeSpacing.setId("beforeSpacing");
		Label betweenSpacing = new Label("   ");
		betweenSpacing.setId("betweenSpacing");
		beforeSpacing.setFont(Font.font(100));
		betweenSpacing.setFont(Font.font(100));
		
		Button tutorial = new Button("Tutorial");
		tutorial.setId("tutorial");
		tutorial.setMinWidth(250);
		tutorial.setMinHeight(70);
		tutorial.setTextFill(Color.BLACK);
		tutorial.setStyle(blackBG+goldBG);
		tutorial.setAlignment(Pos.CENTER);
		tutorial.setFont(Font.font(fontType, FontWeight.NORMAL, 30));
		
		Button quiz = new Button("Quiz");
		quiz.setId("quiz");
		quiz.setMinWidth(250);
		quiz.setMinHeight(70);
		quiz.setTextFill(Color.BLACK);
		quiz.setStyle(blackBG+greenBG);
		quiz.setAlignment(Pos.CENTER);
		quiz.setFont(Font.font(fontType, FontWeight.NORMAL, 30));
		
		buttons.getChildren().addAll(tutorial, betweenSpacing, quiz);
		
		this.root = new VBox();
		this.subpage = createSub(this.root);
		this.subpage.getChildren().addAll(beforeSpacing, title, buttons);

		Background b = new Background();
		this.menu = new Menu();
		b.add(this.menu.getRoot());
		b.add(this.subpage);
		
		this.root.getChildren().add(b.getRoot());
		this.scene = new Scene(this.root, 1200, 800);
	}
	
	// Set up links for buttons
	public void setUpConnections(final Stage stage, final Page[] pages, final HBox buttons)
	{
		List<Node> l = buttons.getChildren();
		for (Node n : l)
		{
			if (n.getId().equals("tutorial"))
			{
				Button b = (Button)n;
				b.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						stage.setScene(pages[Tutorial.ID_PAGE].getScene());
						pages[Tutorial.ID_PAGE].getMenu().highlightPage(b.getId());
					}
				});
			}
			else if (n.getId().equals("quiz"))
			{
				Button b = (Button)n;
				b.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						stage.setScene(pages[Quiz.ID_PAGE].getScene());
						pages[Quiz.ID_PAGE].getMenu().highlightPage(b.getId());
					}
				});
			}
		}
	}
		
	// Set up button connections on the home page
	public void setUpNavigation(Stage stage, Page[] pages) {
		List<Node> l = subpage.getChildren();
		for (Node n : l)
		{
			if (n.getId().equals("buttons"))
			{
				HBox buttons = (HBox)n;
				setUpConnections(stage, pages, buttons);
			}
		}
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
	
	public VBox getSubpage() {
		return subpage;
	}
}
