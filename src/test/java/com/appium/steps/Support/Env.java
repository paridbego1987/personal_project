package com.appium.steps.Support;

import com.appium.runner.RunTest;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Created by Derin on 15/10/15.
 */

public class Env extends RunTest{

    @Before
    public void beforeTest() throws Exception {

    }

    @After
    public void afterTest(Scenario scenario) throws Exception {

        try {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }
        } finally {
            driver.closeApp();
            driver.launchApp();
        }

    }
}
