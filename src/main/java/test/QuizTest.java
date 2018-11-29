package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.layout.VBox;
import logic.Elective;
import logic.Quiz;
import logic.QuizQuestion;

public class QuizTest extends ApplicationTest{
	
	// Patrick Kramer unit test
		@Test
		public void testButtons() throws IOException {
			Quiz q = new Quiz();
			q.renderPage(0);
			assertEquals(true, q.getButtons().size() > 0);
		}
		
		// Patrick Kramer no loop
		@Test
		public void testGetResultsLoopNone() throws IOException {
			Quiz q = new Quiz();
			List<QuizQuestion> qs = new ArrayList<QuizQuestion>();
			VBox b = q.getResults(qs);
			assertEquals(2, b.getChildren().size());
		}
		
		// Patrick Kramer integration test
		@Test
		public void testQuizQuestionAndQuizIntegration() throws IOException {
			Quiz q = new Quiz();
			q.renderPage(0);
			List<QuizQuestion> qqs = QuizQuestion.getQuestions("./src/main/java/logic/" + "questions.txt");
			assertEquals(2, q.getButtons().size() - qqs.size());
		}
		
		// Robert Hensley unit test ReadCSV
		@Test
		public void testReadCSV() throws IOException {
			
			Quiz q = new Quiz();
			List<Elective> electives = new ArrayList<Elective>(); 
			
			electives = q.readCSV("src/Electives_CSV.csv");
			System.out.println(electives);
			assertEquals(50, electives.size());
			
		}
}
		
		
