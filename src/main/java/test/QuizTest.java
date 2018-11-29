package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		
		// Robert Hensley loop test (readCSV)
		@Test
		public void testReadCSV() throws IOException {
			
			Quiz q = new Quiz();
			List<Elective> electives = new ArrayList<Elective>(); 
			
			electives = q.readCSV("src/Electives_CSV.csv");
			assertEquals(50, electives.size());
			
		}
		
		// Robert Hensley loop test (readCSV)
		// also an integration test (examines methods of Elective Entity)
		@Test
		public void testOneReadCSV() throws IOException {
					
			Quiz q = new Quiz();
			List<Elective> electives = new ArrayList<Elective>(); 
					
			electives = q.readCSV("src/main/java/test/testOneCSV.csv");
			
			// check that only one tech elective exists
			assertEquals(1, electives.size());
			
			// check properities of tech elective class (proper read in)
			assertEquals("CSC 301. Personal Software Process", electives.get(0).getFullname());
			assertEquals("{SE=1.0}", electives.get(0).getTags().toString());
			assertEquals(0.0, electives.get(0).getScore(), 0.01);
					
		}
		
		// Robert Hensley loop test (readCSV)
		@Test
		public void testEmptyReadCSV() throws IOException {
							
			Quiz q = new Quiz();
			List<Elective> electives = new ArrayList<Elective>(); 
							
			electives = q.readCSV("src/main/java/test/testEmptyCSV.csv");
			
			assertEquals(0, electives.size());
							
		}		
		
		// Robert Hensley loop test (general loop case)
		@Test
		public void testTags() throws IOException {
			
			Quiz q = new Quiz();
			ArrayList<String> tags = new ArrayList<String>();
			tags.add("AI");
			tags.add("AI");
			tags.add("R");
			tags.add("SE");
			tags.add("R");
			tags.add("AI");
			tags.add("AI");
			
			assertEquals("{AI=4, R=2, SE=1}", q.tagsToMap(tags).toString());
		}
		
		// Robert Hensley loop test (one loop case)
		@Test
		public void testOneTags() throws IOException {
					
			Quiz q = new Quiz();
			ArrayList<String> tags = new ArrayList<String>();
			tags.add("AI");
					
			assertEquals("{AI=1}", q.tagsToMap(tags).toString());
		}
		
		// Robert Hensley loop test (empty loop case)
		@Test
		public void testEmptyTags() throws IOException {
							
			Quiz q = new Quiz();
			ArrayList<String> tags = new ArrayList<String>();
							
			assertEquals("{}", q.tagsToMap(tags).toString());
		}
		
		// Robert Hensley integration test (computeResults)
		@Test
		public void testComputeResults() throws IOException {
			
			Quiz q = new Quiz();
			ArrayList<String> tags = new ArrayList<String>();
			Map<String, Integer> tagMap;
			
			List<Elective> results;
			tags.add("AI");
			tags.add("AI");
			tags.add("R");
			tags.add("SE");
			tags.add("R");
			tags.add("AI");
			tags.add("AI");
			
			// based on tag calculations, CSC 489 should be the top tech elective 
			// because of high-frequency of tags "AI" and "R"
			String predictedTop = "CSC 489. Current Topics in Artificial Intelligence";
			
			tagMap = q.tagsToMap(tags); // Prove true in "testTags"
			
			results = q.computeResults(tagMap);
			
			assertEquals(50, results.size()); // number of tech electives in CSV
			
			assertEquals(predictedTop, results.get(0).getFullname());
			
		}
		
}
		