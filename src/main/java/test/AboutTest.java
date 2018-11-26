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
import javafx.stage.Stage;
import logic.Quiz;
import logic.Tutorial;

import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

public class AboutTest extends FxRobot {


    @Test
    public void title() throws Exception {
    	/*FxToolkit.registerPrimaryStage();
    	FxToolkit.setupApplication(PolyElectives.class);
    	rightClickOn("#about");
    	assertNotNull("#about");*/
    }
    
}
