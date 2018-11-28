package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import javafx.scene.layout.VBox;
import logic.Quiz;
import logic.QuizQuestion;

public class QuizTest {
	/*
	// Patrick Kramer unit test
		@Test
		public void testButtons() throws IOException {
			Quiz q = new Quiz();
			q.renderPage(0);
			assertEquals(q.getButtons().size() > 0, true);
		}
		
		// Patrick Kramer no loop
		@Test
		public void testGetResultsLoopNone() throws IOException {
			Quiz q = new Quiz();
			List<QuizQuestion> qs = new ArrayList<QuizQuestion>();
			VBox b = q.getResults(qs);
			assertEquals(b.getChildren().size() , 2);
		}
		
		// Patrick Kramer integration test
		@Test
		public void testQuizQestionAndQuizIntegration() throws IOException {
			Quiz q = new Quiz();
			q.renderPage(0);
			List<QuizQuestion> qqs = QuizQuestion.getQuestions("questions.txt");
			assertEquals(qqs.size() + 2, q.getButtons().size());
		}
		
		*/


}
