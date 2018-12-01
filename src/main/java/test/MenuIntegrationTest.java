// Steven Pineda
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.control.Button;
import logic.Menu;


public class MenuIntegrationTest extends ApplicationTest {
	
	/* Menu Integration Test Explanation
	   - The Menu class's method, highlightPage, calls different methods (findButton, setCurrentPage)
	   	 	*** See MenuTest.java to see unit tests for findButtons and setCurrentPage ***
	   - The goal of these tests is to ensure that the different methods work together in highlightPage
	   
	   - HighlightPage Purpose: to highlight the current page's text in the menu
	   		* These test make sure the current page text is changed to white and the previous page text is back to black
	*/
	
	@Test
	public void testHighlightPageInvalidPage()
	{
		Menu tester = new Menu();
		
		// about page starts off highlighted
		tester.highlightPage("about");
		
		// tries to highlight invalid page
		tester.highlightPage("nope");
		
		// ensures that previous page is still highlighted in white
		Button tutorial = tester.findButton(tester.getRoot().getChildren(), "about");
		assertEquals(tutorial.getTextFill().toString(), "0xffffffff");
	}
	
	@ Test
	public void testHighlightPageCurrentPageIsWhite()
	{
		Menu tester = new Menu();
		
		// about page starts off highlighted
		tester.highlightPage("about");
		
		// then highlight tutorial page
		tester.highlightPage("tutorial");
		
		// make sure tutorial page text is white
		Button tutorial = tester.findButton(tester.getRoot().getChildren(), "tutorial");
		assertEquals(tutorial.getTextFill().toString(), "0xffffffff");
	}
	
	@Test
	public void testHighlightPagePreviousPageIsBlack()
	{
		Menu tester = new Menu();
		
		// about page starts off highlighted
		tester.highlightPage("about");
		
		// tries to highlight invalid page
		tester.highlightPage("tutorial");
		
		// ensures that previous page is still highlighted in white
		Button tutorial = tester.findButton(tester.getRoot().getChildren(), "about");
		assertEquals(tutorial.getTextFill().toString(), "0x000000ff");
	}
}
