package test;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.scene.layout.VBox;
import logic.QuizQuestion;
public class QuizQuestionTest {

	@Test
	public void test() {
		QuizQuestion qq = new QuizQuestion();
		VBox box = qq.getBox();
		assertEquals(box.getChildren().size() > 0, true);
	}

}
