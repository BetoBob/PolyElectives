package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import javafx.scene.layout.VBox;
import logic.QuizQuestion;

public class QuizQuestionTest {
	
	// Patrick Kramer Loop Test typical number
	@Test
	public void testQuestionReaderLoop7() throws IOException {
		List<QuizQuestion> qs = QuizQuestion.getQuestions("./src/main/java/test/" + "dummyQuestions7.txt");
		assertEquals(7, qs.size());
	}
	
	// Patrick Kramer Loop Test typical number
	@Test
	public void testQuestionReaderLoop0() throws IOException {
		List<QuizQuestion> qs = QuizQuestion.getQuestions("./src/main/java/test/" + "dummyQuestions0.txt");
		assertEquals(0, qs.size());
	}
		
	// Patrick Kramer Loop Test typical number
	@Test
	public void testQuestionReaderLoop1() throws IOException {
		List<QuizQuestion> qs = QuizQuestion.getQuestions("./src/main/java/test/" + "dummyQuestions1.txt");
		assertEquals(1, qs.size());
	}
		
		// Patrick Kramer Loop Test typical number
	@Test
	public void testQuestionReaderLoop2() throws IOException {
		List<QuizQuestion> qs = QuizQuestion.getQuestions("./src/main/java/test/" + "dummyQuestions2.txt");
		assertEquals(2, qs.size());
	}
	
	
}
