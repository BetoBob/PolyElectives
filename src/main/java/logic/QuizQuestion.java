package logic;

import java.util.List;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class QuizQuestion {
	
	private String question = "";
	private List<String> choices = new ArrayList<String>();
	private List<List<String>> tags = new ArrayList<List<String>>();
	private int choice = -1;
	private static HashMap<String, String> tagMap = initMap();
	private final VBox box = new VBox();
	private static HashMap<String, String> initMap() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("AI", "Artificial Intelligence");
		map.put("AVD", "Autonomous Vehicle Development");
		map.put("DS", "Data Science");
		map.put("GD", "Game Development");
		map.put("GR", "Graphics");
		map.put("NW", "Networks");
		map.put("CP", "Computer Performance");
		map.put("R", "Research");
		map.put("SC", "Security");
		map.put("SE", "Software Engineering");
		return map;
	}
	
	public static List<QuizQuestion> getQuestions(String file) throws IOException {
		return questionReader(file);
	}
	
	private static List<QuizQuestion> questionReader(String file) throws IOException {
		List<QuizQuestion> questions = new ArrayList<QuizQuestion>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(file));
			while(scanner.hasNextLine()) {
				QuizQuestion q = new QuizQuestion();
				q.question = scanner.nextLine();
				String temp;
				while (scanner.hasNextLine() && (!(temp = scanner.nextLine()).equals(""))) {
					String[] options = temp.split(",");
					q.choices.add(options[0]);
					ArrayList<String> tgs = new ArrayList<String>();
					for (int i = 1; i < options.length; ++i) {
						tgs.add(tagMap.get(options[i]));
					}
					q.tags.add(tgs);
				}
				questions.add(q);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException();
		} finally {
			if (scanner != null) scanner.close();
			
		}
		return questions;
	}
	
	public VBox getBox() {
		if (box.getChildren().size() == 0) {
			Text text = new Text(question);
			box.getChildren().add(text);
			for (int i = 0; i < choices.size(); ++i) {
				RadioButton b = new RadioButton(choices.get(i));
				b.setId("" + i);
				b.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						choice = Integer.parseInt(((RadioButton) e.getSource()).getId());
						for (int j = 1; j < box.getChildren().size(); ++j) {
								RadioButton temp = (RadioButton) box.getChildren().get(j);
								temp.setSelected(Integer.parseInt(temp.getId()) == choice);
						}
					}
				});
				box.getChildren().add(b);
			}
		}
		return box;
	}
	
	public List<String> getTags(int idx) {
		return tags.get(idx);
	}
	
	
}
