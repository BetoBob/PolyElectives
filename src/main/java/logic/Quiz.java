package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Quiz extends Base implements Page
{
	
	public static final int ID_PAGE = 3;
	private VBox root = new VBox();
	private Menu menu;
	private Scene scene;
	private List<QuizQuestion> questions; 
	private List<Button> buttons = new ArrayList<Button>();
	private VBox subPage = createSub(root);
	private int curQ = -1;
	private boolean finished = false;
	
	public Quiz() throws IOException {
		questions = QuizQuestion.getQuestions("questions.txt");
		for (int i = 0; i <= questions.size() + 1; ++i) {
			Button b = new Button("" + (i + 1));
			b.setStyle("-fx-padding: 20px;");
			b.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					try {
						renderQ(Integer.parseInt(((Button) e.getSource()).getText()) - 1);
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			
			buttons.add(b);
		}
		curQ = 0;
		renderPage(0);
	}
	
	private Button prevNext(String bT, final int nextQ) {
		Button b = new Button(bT);
		b.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				int next = nextQ + curQ;
				if (!finished && next >= 0 && next <= questions.size() + 1)
					try {
						renderQ(next);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			}
		});
		return b;
	}
	
	public void renderQ(int cq) throws IOException {
		curQ = cq;
		subPage.getChildren().remove(1);
		
		if (cq == questions.size()) 
			subPage.getChildren().add(1, getConfirmation(questions));
		else if (cq < questions.size())
			subPage.getChildren().add(1, questions.get(cq).getBox());
	    else 
	    	subPage.getChildren().add(1, getResults(questions));
		
		((VBox)subPage.getChildren().get(1)).setPrefHeight(scene.getHeight() * .5);
		((VBox)subPage.getChildren().get(1)).setAlignment(Pos.CENTER_LEFT);
	}
	
	public void renderPage(int currentQuestion) {
		root = new VBox();
		scene = new Scene(root, 1200, 800);
		subPage = createSub(root);
		Background b = new Background();
		HBox bs = new HBox();
		HBox pN = new HBox();
		pN.setPrefHeight(scene.getHeight() * .25);
		pN.getChildren().add(prevNext("prev", -1));
		pN.getChildren().add(prevNext("next", 1));
		pN.setSpacing(scene.getWidth() / 1.517d);
		bs.setSpacing((scene.getWidth() * .3) / (double) (questions.size() + 1));
		bs.getChildren().addAll(buttons);
		bs.setPrefHeight(scene.getHeight() * .25);
		menu = new Menu();
		b.add(menu.getRoot());
		b.add(subPage);
		root.getChildren().addAll(b.getRoot());
		subPage.getChildren().add(pN);
		subPage.getChildren().add(questions.get(currentQuestion).getBox());
		((VBox)subPage.getChildren().get(1)).setPrefHeight(scene.getHeight() * .5);
		((VBox)subPage.getChildren().get(1)).setAlignment(Pos.CENTER_LEFT);
		bs.setAlignment(Pos.BOTTOM_LEFT);
		subPage.getChildren().add(bs);
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
	
	public static Map<String, Integer> tagsToMap(List<String> tagList)
	{
		Map<String, Integer> tags = new LinkedHashMap<String, Integer>();
		   
		for (String s : tagList) {
			if (tags.get(s) != null) {
				tags.put(s, tags.get(s) + 1);
			 } else {
				 tags.put(s, 1);
			 }
		}
     
     /* sort tags */
     return tags;
	}
	
	 public static List<Elective> computeResults(Map<String, Integer> tags) throws IOException
	 {
	 	Map<String, Double> eTagWeights;
	     List<Elective> electivesList = ReadCSV.readCSV("src/Electives_CSV.csv");
	     
	     /* Top Elective Tags */
	     for (Map.Entry<String, Integer> val : tags.entrySet())
	     {	
	     	/* Calculate the Scores */
	     	for(Elective e: electivesList)
	         {
	     		eTagWeights = e.getTags();
	     		if(eTagWeights.containsKey(val.getKey())) {
	     			e.setScore(val.getValue(), eTagWeights.get(val.getKey()));
	     		}
	         }
	     }
	     
	     /* Sort electivesList */
	     Collections.sort(electivesList);
	     
	     return electivesList;
	 }
	 
	 private VBox getConfirmation(List<QuizQuestion> qs) {
			VBox b = new VBox();
			b.getChildren().add(new Text("Confirmation Page\n"));
			Boolean bool = false;
			
			for (QuizQuestion q : qs) {
				Text text = null;
				VBox choice = new VBox();
				VBox qb = q.getBox();
				for (Node child : qb.getChildren()) {
					if (child instanceof RadioButton && ((RadioButton) child).isSelected()) {
						text = new Text("Your Answer: " + ((RadioButton) child).getText() + "\n");
						break;
					}
				}
				if (text == null ) {
					bool = true;
					break;
				}
				choice.getChildren().add(qb.getChildren().get(0));
				choice.getChildren().add(text);
				b.getChildren().add(choice);
			}
			if (bool) {
				b.getChildren().removeAll();
				b.getChildren().add(new Text("Must Answer All Questions to See Confirmation!"));
			}
			
			return b;
		}
	 
	 private VBox getResults(List<QuizQuestion> qs) throws IOException {
			VBox b = new VBox();
			b.getChildren().add(new Text("Results Page\n"));
			Boolean bool = false;
			List<String> tagList = new ArrayList<String>();
			List<Elective> electives = null;
			for (QuizQuestion q : qs) {
				List<String> tags = null;
				VBox qb = q.getBox();
				for (Node child : qb.getChildren()) {
					if (child instanceof RadioButton && ((RadioButton) child).isSelected()) {
						tags = q.getTags(Integer.parseInt(((RadioButton) child).getId()));
						break;
					}
				}
				if (tags == null) {
					bool = true;
					break;
				}
				tagList.addAll(tags);
			}
			if (bool) {
				b.getChildren().removeAll();
				b.getChildren().add(new Text("Must Answer All Questions to See Results!"));
				return b;
			}
			electives = computeResults(tagsToMap(tagList));
			for (Elective el : electives) b.getChildren().add(el.getBox());
			finished = true;
			return b;
		}
	
}
