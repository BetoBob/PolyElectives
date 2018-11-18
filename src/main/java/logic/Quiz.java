package logic;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

//import java.util.ArrayList;
//import java.util.Map;
//import java.util.Scanner;

/* Handles user I/O of questions
 * will be replaced with a GUI interface once the design is unified
 * questions will also change (these questions are only designed to test the point system)
 */

public class Quiz extends Base implements Page
{
	
	public static final int ID_PAGE = 3;
	private VBox root = new VBox();
	private Menu menu;
	private Scene scene;
	private List<QuizQuestion> questions = QuizQuestion.getQuestions();
	private List<Button> buttons = new ArrayList<Button>();
	private VBox subPage = createSub(root);
	
	public Quiz() {
		for (int i = 0; i < questions.size(); ++i) {
			final Button b = new Button("" + i);
			b.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					renderQ(Integer.parseInt(b.getText()));
				}
			});
			buttons.add(b);
		}
		renderPage(0);
	}
	
	public void renderQ(int cq) {
		subPage.getChildren().remove(0);
		subPage.getChildren().add(0, questions.get(cq).getBox());
	}
	
	public void renderPage(int currentQuestion) {
		root = new VBox();
		subPage = createSub(root);
		Background b = new Background();
		HBox bs = new HBox();
		bs.getChildren().addAll(buttons);
		menu = new Menu();
		b.add(menu.getRoot());
		b.add(subPage);
		root.getChildren().addAll(b.getRoot());
		subPage.getChildren().add(questions.get(currentQuestion).getBox());
		subPage.getChildren().add(bs);
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
	
}