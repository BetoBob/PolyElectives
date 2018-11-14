package logic;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public interface Page {
	void renderPage();
	Pane getRoot();
	Menu getMenu();
	Scene getScene();
}
