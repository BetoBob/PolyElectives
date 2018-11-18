package logic;

import java.util.List;

import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class QuizQuestion {
	
	private List<String> choices = new ArrayList<String>();
	private List<Elective> choiceRelations = new ArrayList<>();
	private int choice = -1;
	
	
	public static List<QuizQuestion> getQuestions() {
		ArrayList<QuizQuestion> questions = new ArrayList<QuizQuestion>();
		for (int i = 0; i < 10; ++i) {
			QuizQuestion q = new QuizQuestion();
			q.choice = i + 1;
			for (int j = 0; j < 5; ++j) {
				q.choices.add("i : " + i + " j : " + j + " ");
				//q.choiceRelations.add(new Elective("", "", "", "", "", ""));
			}
			questions.add(q);
		}
		return questions;
	}
	
	public VBox getBox() {
		VBox box = new VBox();
		for (int i = 0; i < choices.size(); ++i) {
			RadioButton b = new RadioButton(choices.get(i));
			box.getChildren().add(b);
		}
		return box;
	}
}
