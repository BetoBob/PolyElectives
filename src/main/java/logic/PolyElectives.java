package logic;

import javafx.application.Application;
import javafx.stage.Stage;

public class PolyElectives extends Application {
	private Page about;
	private Page home;
	private Page tutorial;
	private Page quiz;
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("PolyElectives");
		
		// Create all the pages
		about = new About();
		home = new Home();
		tutorial = new Tutorial();
		quiz = new Quiz();
		
		Page[] pages = {about, home, tutorial, quiz};
		
		// Set up menu links between pages
		for (Page p: pages)
		{
			p.getMenu().setUpNavigation(stage, pages);
		}
		
		// Set up first page to view
		home.getMenu().setCurrentPage("home");
		home.getMenu().highlightPage("home");
		stage.setScene(pages[Home.ID_PAGE].getScene());
		
		stage.show();
	}
}
