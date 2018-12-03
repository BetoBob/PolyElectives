package logic;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

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
		HBox buttons = new HBox();
		HBox tutorial = new HBox();
		Background b = new Background();
		menu = new Menu();
		b.add(menu.getRoot());
		b.add(subPage);
		root.getChildren().addAll(b.getRoot());
		scene = new Scene(root, 1200, 800);
		
		/*Label title = new Label("Tutorial");
		title.setId("title");
		title.setMinWidth(300);
		title.setMinHeight(210);
		title.setTextFill(Color.BLACK);
		title.setAlignment(Pos.CENTER);
		title.setFont(Font.font("Tahoma", FontWeight.BOLD, 40));
		*/
		
		final Label step = new Label("Step 1");
		step.setMinWidth(500);
		step.setMinHeight(75);
		step.setTextFill(Color.BLACK);
		step.setStyle("-fx-background-color: #B5A76C;");
		subPage.getAlignment();
		step.setAlignment(Pos.CENTER);
		step.setFont(Font.font("Tahoma", FontWeight.THIN, 40));
		
		Region spacer1 = new Region();
		spacer1.setPrefHeight(60);
		
		Region spacer2 = new Region();
		spacer2.setPrefHeight(60);
		
		Region spacer3 = new Region();
		spacer3.setPrefHeight(60);
		
		Region spacer_width1 = new Region();
		spacer_width1.setPrefWidth(160);
		
		Region spacer_width2 = new Region();
		spacer_width2.setPrefWidth(160);
		
		Region spacer_width3 = new Region();
		spacer_width3.setPrefWidth(60);
		
		final Text txt1 = new Text("First, create an optional account or login to save/download your final results");
		txt1.setWrappingWidth(400);
		final String txt_1 = ("First, create an optional account or login to save/download your final results");
		final String txt_2 = ("Second, take the questionnaire to find what tech electives best suite your interests");
		final String txt_3 = ("Finally, after answering the questions, click 'next' on the last quiz question page to see the results");
	    txt1.setFont(Font.font("Tahoma", FontPosture.REGULAR, 26));
	    TextFlow description = new TextFlow(txt1);
	    description.setMaxWidth(400);
		
	    final ImageView stepPlaceholder1 = new ImageView(new Image(getClass().getResourceAsStream("homepage_login.png"), 3000, 420, true, true));
		stepPlaceholder1.setStyle("-fx-border-color: black; -fx-border-width: 4;-fx-border-style: dotted;");
		
		Button button1 = new Button("step 1");
		button1.setTextFill(Color.BLACK);
		button1.setStyle("-fx-background-color: #035642;-fx-border-color: #000000; -fx-border-width: 1px;-fx-border-radius: 5 5 5 5;");
		button1.setFont(Font.font("Tahoma", 23));
		Button button2 = new Button("step 2");
		button2.setTextFill(Color.BLACK);
		button2.setStyle("-fx-background-color: #035642;-fx-border-color: #000000; -fx-border-width: 1px;-fx-border-radius: 5 5 5 5;");
		button2.setFont(Font.font("Tahoma", 23));
		Button button3 = new Button("step 3");
		button3.setTextFill(Color.BLACK);
		button3.setStyle("-fx-background-color: #035642;-fx-border-color: #000000; -fx-border-width: 1px;-fx-border-radius: 5 5 5 5;");
		button3.setFont(Font.font("Tahoma", 23));
		
		buttons.getChildren().addAll(button1, spacer_width1, button2, spacer_width2,button3);
		buttons.setAlignment(Pos.CENTER);
		
		
		button1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				step.setText("Step 1");
				txt1.setText(txt_1);
				stepPlaceholder1.setImage(new Image(getClass().getResourceAsStream("homepage_login.png"), 3000, 420, true, true));
				
			}
		});
		
		button2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				step.setText("Step 2");
				txt1.setText(txt_2);
				stepPlaceholder1.setImage(new Image(getClass().getResourceAsStream("quiz.png"), 1000, 300, true, true));
			}
		});
		
		button3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				step.setText("Step 3");
				txt1.setText(txt_3);
				stepPlaceholder1.setImage(new Image(getClass().getResourceAsStream("confirmation_result.png"), 3000, 420, true, true));
			}
		});
		
		tutorial.getChildren().addAll(stepPlaceholder1,spacer_width3,txt1);
		tutorial.setAlignment(Pos.CENTER);
		
		//Label page = step1;
		//subPage.getChildren().addAll(spacer1,step,spacer1,buttons,spacer1,flow,stepPlaceholder1);
		subPage.getChildren().addAll(spacer1,step,spacer2,buttons,spacer3,tutorial);
		//while (true) {
		//	if 
		//}
		//subPage.getChildren().addAll(title,step1,spacer1,stepPlaceholder);
		
		
		

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
