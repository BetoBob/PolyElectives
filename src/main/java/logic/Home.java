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
		
		Button login = new Button("Login");
		login.setId("account");
		login.setMinWidth(250);
		login.setMinHeight(70);
		login.setTextFill(Color.BLACK);
		login.setStyle(blackBG+goldBG);
		login.setAlignment(Pos.CENTER);
		login.setFont(Font.font(fontType, FontWeight.NORMAL, 30));
		
		Button quiz = new Button("Quiz");
		quiz.setId("quiz");
		quiz.setMinWidth(250);
		quiz.setMinHeight(70);
		quiz.setTextFill(Color.BLACK);
		quiz.setStyle(blackBG+greenBG);
		quiz.setAlignment(Pos.CENTER);
		quiz.setFont(Font.font(fontType, FontWeight.NORMAL, 30));
		
		buttons.getChildren().addAll(login, betweenSpacing, quiz);
		
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
		
	// Set up button connections on the home page
	public void setUpNavigation(Stage stage, Page[] pages) 
	{
		List<Node> l = subpage.getChildren();
		HBox buttons = getButtons(l);
		if (buttons != null)
		{
			l = buttons.getChildren();
			final Button log = findButton(l, "account");
			setUpButton(stage, pages, log, Account.ID_PAGE);
			
			final Button q = findButton(l, "quiz");
			setUpButton(stage, pages, q, Quiz.ID_PAGE);
		}
	}
	
	public HBox getButtons(List<Node> l)
	{
		HBox buttons = null;
		for (Node n: l)
		{
			if (n.getId().equals("buttons"))
			{
				buttons = (HBox)n;
			}
		}
		return buttons;
	}
		
	public Button findButton(List<Node> l, String name)
	{
		Button b = null;
		for (Node n : l)
		{
			if (n.getId().equals(name))
			{
				b = (Button)n;
			}
		}
		return b;
	}
		
	public void setUpButton(final Stage stage, final Page[] pages, final Button b, final int pageId)
	{
		if (b != null)
		{
			b.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					if(b.getId().equals("account"))
						Account.loadResults();
					stage.setScene(pages[pageId].getScene());
					pages[pageId].getMenu().highlightPage(b.getId());
				}
			});
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
	
	public void setSubpage(VBox s) {
		this.subpage = s;
	}
}
