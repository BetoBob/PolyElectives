package polyelectives;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public interface Page {
	Pane getRoot();
	Menu getMenu();
	Scene getScene();
}
