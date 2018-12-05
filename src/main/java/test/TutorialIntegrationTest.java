package test;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import logic.About;
import logic.Account;
import logic.Home;
import logic.Page;
import logic.PolyElectives;
import logic.Quiz;
import logic.Tutorial;

public class TutorialIntegrationTest {
	
	@Test
	public void test_tutorial_id()
	{
		// Setup for test case
		PolyElectives main = new PolyElectives();
		Page obj = main.tutorial;
		
		//String str = obj.toString();
		// testing to make sure that id is the same
		assertNull(obj);
	}

}
