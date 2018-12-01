// Steven Pineda
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.About;
import logic.Account;
import logic.Home;
import logic.Menu;
import logic.Page;
import logic.Quiz;
import logic.Tutorial;

public class MenuTest extends ApplicationTest {
	
	private Stage stage;
	
	@Override
	public void start(Stage stage)
	{
		this.stage = stage;
		return;
	}
	
	@Test
	public void testGetRootNumChildren()
	{
		Menu tester = new Menu();
		VBox root = tester.getRoot();
		int result = root.getChildren().size();
		assertEquals(6, result);
	}
	
	@Test
	public void testGetRootHasTitle()
	{
		Menu tester = new Menu();
		VBox root = tester.getRoot();
		Node n = root.getChildren().get(0);
		assertEquals("title", n.getId());
	}
	
	@Test
	public void testGetRootHasHome()
	{
		Menu tester = new Menu();
		VBox root = tester.getRoot();
		Button b = (Button)root.getChildren().get(1);
		assertEquals("home", b.getId());
	}
	
	@Test
	public void testGetRootHasTutorial()
	{
		Menu tester = new Menu();
		VBox root = tester.getRoot();
		Button b = (Button)root.getChildren().get(2);
		assertEquals("tutorial", b.getId());
	}
	
	@Test
	public void testGetRootHasQuiz()
	{
		Menu tester = new Menu();
		VBox root = tester.getRoot();
		Button b = (Button)root.getChildren().get(3);
		assertEquals("quiz", b.getId());
	}
	
	@Test
	public void testGetRootHasAbout()
	{
		Menu tester = new Menu();
		VBox root = tester.getRoot();
		Button b = (Button)root.getChildren().get(4);
		assertEquals("about", b.getId());
	}
	
	@Test
	public void testGetRootHasAccount()
	{
		Menu tester = new Menu();
		VBox root = tester.getRoot();
		Button b = (Button)root.getChildren().get(5);
		assertEquals("account", b.getId());
	}
	
	@Test
	public void setCurrentPage()
	{
		Menu tester = new Menu();
		tester.setCurrentPage("quiz");
		assertEquals("quiz", tester.getCurrentPage());
	}
	
	@Test
	public void testFindButtonLoopNone()
	{
		Menu tester = new Menu();
		tester.setRoot(new VBox());
		Button result = tester.findButton(tester.getRoot().getChildren(), "home");
		assertEquals(null, result);
	}
	
	@Test
	public void testFindButtonLoopTypical()
	{
		Menu tester = new Menu();
		Button result = tester.findButton(tester.getRoot().getChildren(), "home");
		assertEquals("home", result.getId());
	}
	
	@Test
	public void testFindButtonNonexistant()
	{
		Menu tester = new Menu();
		Button result = tester.findButton(tester.getRoot().getChildren(), "none");
	    assertEquals(null, result);
	}
	
	@Test 
	public void testSetUpSingleConnectionHomeButton() throws Exception
	{
		// Setup for test case
		Page about = new About();
		Page home = new Home();
		Page tutorial = new Tutorial();
		Page quiz = Quiz.getInstance();
		Page account = new Account();
		Page[] pages = {about, home, tutorial, quiz, account};
		
		// calling setUpSingleConnecition
		Menu tester = new Menu();
		Button h = tester.findButton(tester.getRoot().getChildren(), "home");
		tester.setUpSingleConnection(this.stage, pages, h, Home.ID_PAGE);
		
		// testing to make sure that home button has a button handler
		assertNotNull(h.getOnAction());
	}
	
	
	@Test
	public void testSetUpNavigationLoopNone() throws Exception 
	{
		// Setup for test case
		Page about = new About();
		Page home = new Home();
		Page tutorial = new Tutorial();
		Page quiz = Quiz.getInstance();
		Page account = new Account();
		Page[] pages = {about, home, tutorial, quiz, account};
		
		// calling setUpNavigation
		Menu tester = new Menu();
		VBox root = tester.getRoot();
		tester.setRoot(new VBox()); // make root's children empty so no loop iterations
		tester.setUpNavigation(this.stage, pages);
		Button h = tester.findButton(root.getChildren(), "home");
		
		// testing to make sure that account button has no handler since loop didn't run
		assertEquals(null, h.getOnAction());
	}
	
	@Test
	public void testSetUpNavigationLoopTypical() throws Exception 
	{
		// Setup for test case
		Page about = new About();
		Page home = new Home();
		Page tutorial = new Tutorial();
		Page quiz = Quiz.getInstance();
		Page account = new Account();
		Page[] pages = {about, home, tutorial, quiz, account};
		
		// calling setUpNavigation
		Menu tester = new Menu();
		tester.setUpNavigation(this.stage, pages);
		Button h = tester.findButton(tester.getRoot().getChildren(), "home");
		
		// testing to make sure that home button got button handler since loop did iterate
		assertNotNull(h.getOnAction());
	}
}
