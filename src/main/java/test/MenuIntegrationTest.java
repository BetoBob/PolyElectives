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
	   		* These test make sure the current page text is changed to white and the text of other pages is black
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
		
		// tutorial page starts off highlighted
		tester.highlightPage("tutorial");
		
		// make sure tutorial page text is white
		Button tutorial = tester.findButton(tester.getRoot().getChildren(), "tutorial");
		assertEquals(tutorial.getTextFill().toString(), "0xffffffff");
	}
	
	@Test
	public void testHighlightPageOtherPageIsBlack()
	{
		Menu tester = new Menu();
		
		// tutorial page starts off highlighted
		tester.highlightPage("tutorial");
		
		// ensures that about page is black
		Button ab = tester.findButton(tester.getRoot().getChildren(), "about");
		assertEquals(ab.getTextFill().toString(), "0x000000ff");
	}
}
