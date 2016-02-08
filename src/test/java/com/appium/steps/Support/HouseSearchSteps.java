package com.appium.steps.Support;

import com.appium.pages.HouseSearch;
import com.appium.runner.RunTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;



/**
 * Created by begop on 08/02/2016.
 */
public class HouseSearchSteps extends RunTest {

    @When("^I tap For Sale$")
    public void i_tap_For_Sale() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(houseSearch.For_Sale_Btn)).click();

    }

    @And("^I tap Enter a location$")
    public void i_tap_Enter_a_location() throws Throwable {wait.until(ExpectedConditions.visibilityOf(houseSearch.Enter_Location_Btn)).click();

    }



}
