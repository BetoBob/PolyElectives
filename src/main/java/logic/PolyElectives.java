package logic;

//import java.awt.Dimension;
//import java.awt.Toolkit;

import javafx.application.Application;
import javafx.stage.Stage;

public class PolyElectives extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
				
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		stage.setTitle("PolyElectives");
		
		// Create all the pages
		Page about = new About();
		Page home = new Home();
		Page tutorial = new Tutorial();
		
		Page[] pages = {about, home, tutorial};
		
		// Set up menu links between pages
		for (Page p: pages)
		{
			p.getMenu().setUpNavigation(stage, pages);
		}
		
		// Set up first page to view
		home.getMenu().setCurrentPage("home");
		home.getMenu().highlightPage("home");
		stage.setScene(pages[Home.idPage].getScene());
		
		//stage.setFullScreen(true);
		//stage.setResizable(false);
		stage.show();
	}
}
