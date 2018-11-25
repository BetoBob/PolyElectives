package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import logic.About;
import logic.Account;
import logic.Home;
import logic.Page;
import javafx.stage.Stage;
import logic.Quiz;
import logic.Tutorial;

import org.testfx.framework.junit.ApplicationTest;

public class AboutTest extends ApplicationTest{

	/*

	@Override
    public void start(Stage stage) throws IOException {
		stage.setTitle("PolyElectives");
		
		// Create all the pages
		Page about = new About();
		Page home = new Home();
		Page tutorial = new Tutorial();
		Page quiz = new Quiz();
		Page account = new Account();
		
		Page[] pages = {about, home, tutorial, quiz, account};
		
		// Set up menu links between pages
		for (Page p: pages)
		{
			p.getMenu().setUpNavigation(stage, pages);
		}
		
		// Set up home links
		((Home)home).setUpNavigation(stage, pages);
		
		// Set up first page to view
		home.getMenu().setCurrentPage("home");
		home.getMenu().highlightPage("home");
		stage.setScene(pages[Home.ID_PAGE].getScene());
		
		stage.show();
    }

    @Test
    public void title() {
    	rightClickOn("#about");
    	assertNotNull("#about");
    }
  */   
}
