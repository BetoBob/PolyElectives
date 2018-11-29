package test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logic.About;
import logic.Account;
import logic.Home;
import logic.Page;
import logic.Quiz;
import logic.Tutorial;

public class HomeIntegrationTest extends ApplicationTest {
	
	private Stage stage;
	
	@Override
	public void start(Stage stage)
	{
		this.stage = stage;
		return;
	}
	
	
	/* Home Integration Test Explanation
	   - The Home class's method, setUpNavigation, calls several different methods (getButtons, findButton, setUpButton)
	   	 	*** See HomeTest.java to see unit tests for getButtons and findButton ***
	   - The goal of these tests is to ensure that the different methods work together in setUpNavigation
	   
	   - SetUpNavigation Purpose: to set up the button EventHandlers on the home page
	    	* Since setUpNavigation sets up a button handler for each button in the Home page, the tests will make sure 
	     	  that the tutorial and quiz button EventHandlers are not null
	   		* If the EventHandlers are not null, then setUpNavigation correctly set up connections for the home page
	*/
	
	
	@Test
	public void testSetUpNavigationTutorialButton() throws Exception 
	{
		// Setup for test case
		Page about = new About();
		Page home = new Home();
		Page tutorial = new Tutorial();
		Page quiz = new Quiz();
		Page account = new Account();
		Page[] pages = {about, home, tutorial, quiz, account};
		
		// calling setUpNavigation
		Home tester = (Home)home;
		tester.setUpNavigation(this.stage, pages);
		HBox buttons = tester.getButtons(tester.getSubpage().getChildren());
		Button tut = tester.findButton(buttons.getChildren(), "tutorial");
		
		// testing to make sure that tutorial button got button handler
		assertNotNull(tut.getOnAction());
	}
	
	@Test
	public void testSetUpNavigationQuizButton() throws Exception 
	{
		// Setup for test case
		Page about = new About();
		Page home = new Home();
		Page tutorial = new Tutorial();
		Page quiz = new Quiz();
		Page account = new Account();
		Page[] pages = {about, home, tutorial, quiz, account};
		
		// calling setUpNavigation
		Home tester = (Home)home;
		tester.setUpNavigation(this.stage, pages);
		HBox buttons = tester.getButtons(tester.getSubpage().getChildren());
		Button q = tester.findButton(buttons.getChildren(), "quiz");
		
		// testing to make sure that tutorial button got button handler
		assertNotNull(q.getOnAction());
	}
}
