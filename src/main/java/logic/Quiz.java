package logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

public class Quiz extends Base implements Page
{
	public static final String QUESTIONS_FILE = "./src/main/java/logic/questions.txt";
	public static final String DUMMY_FILE_0 = "./src/main/java/test/dummyQuestions0.txt";
	public static final String DUMMY_FILE_1 = "./src/main/java/test/dummyQuestions1.txt";
	public static final String DUMMY_FILE_2 = "./src/main/java/test/dummyQuestions2.txt";
	public static final String DUMMY_FILE_7 = "./src/main/java/test/dummyQuestions7.txt";
	
	public static final int ID_PAGE = 3;
	private VBox root = new VBox();
	private Menu menu;
	private Scene scene;
	private List<QuizQuestion> questions; 
	private List<Button> buttons = new ArrayList<Button>();
	private VBox subPage = createSub(root);
	private int curQ = -1;
	private boolean finished = false;
	public static Quiz instance = null;
	
	public static Quiz getInstance() throws IOException {
		return getInstance(QUESTIONS_FILE);
	}
	
	public static Quiz getInstance(String s) throws IOException {
		if (instance == null) instance = new Quiz(s);
		return instance;
	}
	
	public static Quiz resetInstance() throws IOException {
		return resetInstance(QUESTIONS_FILE);
	}
	
	public static Quiz resetInstance(String s) throws IOException {
		instance = new Quiz(s);
		return instance;
	}
	
	private Quiz(String s) throws IOException {
		genButtonsAndRender(s);
	}
	
	private void addBorder() {
		//for (Node n : subPage.getChildren()) n.setStyle("-fx-border-color : #000");
	}
	
	private void genButtonsAndRender(String s) throws IOException {
		String goldBG = "-fx-background-color: #B5A76C;";
		questions = QuizQuestion.getQuestions(s);
		for (int i = 0; i <= questions.size() + 1; ++i) {
			Button b = new Button("" + (i + 1));
			b.setStyle("-fx-padding: 20px;" + goldBG);
			b.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					try {
						renderQ(Integer.parseInt(((Button) e.getSource()).getText()) - 1);
						addBorder();
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
		addBorder();
		
	}
	
	private Button prevNext(String bT, final int nextQ) {
		String greenBG = "-fx-background-color: #035642;";
		Button b = new Button(bT);
		b.setStyle(greenBG);
		b.setFont(Font.font("Tahoma", FontWeight.BOLD, 23));
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
		subPage.getChildren().remove(2);
		
		if (cq == questions.size()) {
			subPage.getChildren().add(2, getConfirmation(questions));
			updateTitle("Confirmation Page");
			subPage.setAlignment(Pos.CENTER);
		} else if (cq < questions.size()) {
			subPage.getChildren().add(2, questions.get(cq).getBox());
			updateTitle("Question " + (cq + 1));
		}
	    else {
	    	HBox title  = (HBox)subPage.getChildren().get(0);
	    	subPage.getChildren().clear();
	    	subPage.getChildren().add(title);
	    	subPage.getChildren().add(getResults(questions));
	    	updateTitle("Results Page");
	    	return;
	    }
		
		((VBox)subPage.getChildren().get(2)).setPrefHeight(scene.getHeight() * .45);
		((VBox)subPage.getChildren().get(2)).setAlignment(Pos.CENTER_LEFT);
	}
	
	private void updateTitle(String s) {
		((Label)((HBox)subPage.getChildren().get(0)).getChildren().get(0)).setText(s);
	}
	
	public void renderPage(int currentQuestion) {
		root = new VBox();
		scene = new Scene(root, 1200, 800);
		subPage = createSub(root);
		Background b = new Background();
		HBox bs = new HBox();
		HBox pN = new HBox();
		Label title2 = new Label("Question " + (currentQuestion + 1));
		title2.setMinWidth(500);
		title2.setMinHeight(75);
		title2.setTextFill(Color.BLACK);
		title2.setStyle("-fx-background-color: #B5A76C;");
		subPage.getAlignment();
		title2.setAlignment(Pos.CENTER);
		title2.setFont(Font.font("Tahoma", FontWeight.BOLD, 40));
		HBox title = new HBox();
		title.getChildren().add(title2);
		title.setAlignment(Pos.CENTER);
		title.setPrefHeight(scene.getHeight() * .25);
		subPage.getChildren().add(title);
		pN.setPrefHeight(scene.getHeight() * .1);
		pN.getChildren().add(prevNext("prev", -1));
		pN.getChildren().add(prevNext("next", 1));
		pN.setSpacing(scene.getWidth() / 2.d);
		bs.setSpacing((scene.getWidth() * .3) / (double) (questions.size() + 1));
		bs.getChildren().addAll(buttons);
		bs.setPrefHeight(scene.getHeight() * .2);
		menu = new Menu();
		b.add(menu.getRoot());
		b.add(subPage);
		root.getChildren().addAll(b.getRoot());
		subPage.getChildren().add(pN);
		if (!questions.isEmpty()) {
			subPage.getChildren().add(questions.get(currentQuestion).getBox());
			((VBox)subPage.getChildren().get(2)).setPrefHeight(scene.getHeight() * .45);
			((VBox)subPage.getChildren().get(2)).setAlignment(Pos.CENTER_LEFT);
		}
		pN.setAlignment(Pos.CENTER);
		bs.setAlignment(Pos.CENTER);
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
	
	public List<Button> getButtons() {
		return buttons;
	}
	
	/* Quiz Algorithm Methods */
	
	public Map<String, Integer> tagsToMap(List<String> tagList)
	{
		Map<String, Integer> tags = new LinkedHashMap<String, Integer>();
		   
		for (String s : tagList) {
			if (tags.get(s) != null) {
				tags.put(s, tags.get(s) + 1);
			 } else {
				 tags.put(s, 1);
			 }
		}
     
		return tags;
	}
	
	 public List<Elective> computeResults(Map<String, Integer> tags) throws IOException
	 {
	 	Map<String, Double> eTagWeights;
	     List<Elective> electivesList = readCSV("src/Electives_CSV.csv");
	     
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
	 
	 public List<Elective> readCSV(String csv) throws IOException
	 {
		 List<Elective> electivesList = new ArrayList<Elective>();
		 BufferedReader br = null;
	     try
	     {
	    	 br = new BufferedReader(new FileReader(csv));		
	         String line;
	         ArrayList<String> lineList;
	         Elective electiveInput;
	            
	         for (int i = 0; (line = br.readLine()) != null; i++) 
	         {
	        	 if(i > 0) 
	             {
	        		 lineList = new ArrayList<String>(Arrays.asList(line.split("\"\"\",\"\"\"")));
	                    
	                 if(lineList.size() != 6)
	                	 break;
	                	 
	                 electiveInput = new Elective(lineList.get(0).replace("\"\"\"", ""), lineList.get(1), 
	                                              lineList.get(2), lineList.get(3), 
	                                              lineList.get(4), lineList.get(5).replace("\"\"\"", ""));
	                
	                 electivesList.add(electiveInput);
	             }
	         }
	         
	         br.close();
	      }
	      catch (Exception e) { throw new IllegalArgumentException(); }
	      finally
	      {
	    	  if(br != null) br.close();
	      }
	      return electivesList;
	 }
	 
	 /* Results Page */
	 
	 public VBox getConfirmation(List<QuizQuestion> qs) {
			VBox b = new VBox();
			Boolean bool = false;
			for (QuizQuestion q : qs) {
				Text text = null;
				VBox choice = new VBox();
				VBox qb = q.getBox();
				for (Node child : qb.getChildren()) {
					if (child instanceof RadioButton && ((RadioButton) child).isSelected()) {
						text = new Text("Your Answer: " + ((RadioButton) child).getText() + "\n");
						text.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
						break;
					}
				}
				if (text == null ) {
					bool = true;
					break;
				}
				Text qq = new Text(q.getText());
				TextFlow qq_flow;
				qq.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
				qq_flow = new TextFlow(qq);
				qq_flow.setTextAlignment(TextAlignment.CENTER);
				choice.getChildren().add(qq_flow);
				choice.getChildren().add(text);
				choice.setAlignment(Pos.CENTER);
				b.getChildren().add(choice);
			}
			if (bool) {
				b.getChildren().clear();
				Text confText = new Text("Must Answer All Questions to See Confirmation!");
				confText.setFont(Font.font("Tahoma", FontWeight.BOLD, 35));
				b.getChildren().add(confText);
			}
			
			return b;
		}
	 
	 public VBox getResults(List<QuizQuestion> qs) throws IOException {
			VBox b = new VBox();
			Boolean bool = true;
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
				bool = false;
				if (tags == null) {
					continue; // TODO: remove after done testing
					//bool = true;
					//break;
				}
				tagList.addAll(tags);
			}
			if (bool) {
				b.getChildren().clear();
				b.getChildren().add(new Text("Must Answer All Questions to See Results!"));
				return b;
			}
			electives = computeResults(tagsToMap(tagList));
			System.out.println(electives);
			for (int i = 0; i < 3; i++)
				b.getChildren().add(electives.get(i).getBox());
			finished = true;
			b.setAlignment(Pos.CENTER);
			return b;
		}
	
}
