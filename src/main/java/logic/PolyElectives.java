package logic;

import javafx.application.Application;
import javafx.stage.Stage;

public class PolyElectives extends Application {
	public Page about;
	public Page home;
	public Page tutorial;
	public Page quiz;
	public Page account;
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {

		stage.setTitle("PolyElectives");
		
		createPages();
		
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
	public void createPages () throws Exception {
		// Create all the pages
		about = new About();
		home = new Home();
		tutorial = new Tutorial();
		quiz = new Quiz();
		account = new Account();
	}
}
