package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.junit.Test;

import logic.About;
import logic.Account;
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
// Antonio's 1st Test
public class AboutTest{

    @Test
    public void nullTest() {
    	PolyElectives main = new PolyElectives();
		Page obj = main.about;
		assertNull(obj);
	}
}
