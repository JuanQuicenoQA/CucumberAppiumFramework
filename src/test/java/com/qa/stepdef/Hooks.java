package com.qa.stepdef;

import com.qa.pages.BasePage;
import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;

public class Hooks {

    @Before
    public void initialize(Scenario scenario) throws Exception {
        GlobalParams params = new GlobalParams();
        BasePage basePage = new BasePage();
        basePage.closeApp();
        basePage.launchApp();
        scenario.log("*** " + params.getPlatformName() + " " + params.getDeviceName() + " ***" + "\n");
    }

    @After
    public void quit(Scenario scenario) {
        if(scenario.isFailed()){
            byte[] screenshot = new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed scenario screenshot");
        }
    }
}

