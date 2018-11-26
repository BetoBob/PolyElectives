package test;

import static org.junit.Assert.*;

import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.junit.Test;

import logic.About;
import logic.Account;
import logic.Background;
import logic.Home;
import logic.Page;
import logic.PolyElectives;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.Quiz;
import logic.QuizQuestion;
import logic.Tutorial;

import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
// Testing Background's constructor and it's setRoot method together
public class IntegrationTest1{

    @Test
    public void intTest() throws Exception {
    	Background obj = new Background();
    	HBox root2 = new HBox();
    	root2.setId("background2");
		root2.setStyle("-fx-background-color: linear-gradient(to bottom, #ffffff, #6d6d6d);");
		obj.setRoot(root2);
    	assertEquals(obj.getRoot().getId(), "background2");
		
	}
}
