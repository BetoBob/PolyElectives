package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.Home;


public class HomeTest extends ApplicationTest {
		
	@Test
	public void testInitializationId()
	{
		int result = Home.ID_PAGE;
		assertEquals(1, result);
	}
	
	@Test
	public void testGetSubpageNumChildren()
	{
		Home tester = new Home();
		VBox subpage = tester.getSubpage();
		int result = subpage.getChildren().size();
		assertEquals(result, 3);
	}
	
	@Test
	public void testGetButtonsLoopNone()
	{
		Home tester = new Home();
		tester.setSubpage(new VBox());
		HBox result = tester.getButtons(tester.getSubpage().getChildren());		
		assertEquals(result, null);
	}
	
	@Test
	public void testGetButtonsLoopTypical()
	{
		Home tester = new Home();
		HBox result = tester.getButtons(tester.getSubpage().getChildren());
		assertEquals(result.getId(), "buttons");
	}
	
	@Test
	public void testGetButtonsNumChildren()
	{
		Home tester = new Home();
		HBox buttons = tester.getButtons(tester.getSubpage().getChildren());
		int result = buttons.getChildren().size();
		assertEquals(result, 3);
	}
	
	@Test
	public void testFindButtonLoopNone()
	{
		Home tester = new Home();
		HBox buttons = new HBox();
		Button result = tester.findButton(buttons.getChildren(), "tutorial");
		assertEquals(result, null);
	}
	
	@Test
	public void testFindButtonLoopTypical()
	{
		Home tester = new Home();
		HBox buttons = tester.getButtons(tester.getSubpage().getChildren());
		Button result = tester.findButton(buttons.getChildren(), "tutorial");
		assertEquals(result.getId(), "tutorial");
	}
	
	@Test
	public void testFindButtonNonexistant()
	{
		Home tester = new Home();
		HBox buttons = tester.getButtons(tester.getSubpage().getChildren());
		Button result = tester.findButton(buttons.getChildren(), "none");
		assertEquals(result, null);
	}
}
