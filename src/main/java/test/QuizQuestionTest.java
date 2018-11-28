package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import javafx.scene.layout.VBox;
import logic.QuizQuestion;
public class QuizQuestionTest {

	// Patrick Kramer Loop no times test
	@Test
	public void testGetBox() {
		QuizQuestion qq = new QuizQuestion();
		VBox box = qq.getBox();
		// first element added before the loop
		// the loop adds elements
		assertEquals(box.getChildren().size(), 1);
	}
	
	// Patrick Kramer Loop Test typical number
	@Test
	public void testQuestionReaderLoop() throws IOException {
		List<QuizQuestion> qs = QuizQuestion.getQuestions("questions.txt");
		assertEquals(qs.size(), 7);
	}
	
	
}
