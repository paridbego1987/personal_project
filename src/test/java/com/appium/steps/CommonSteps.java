package com.appium.steps;

import com.appium.runner.RunTest;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

/**
 * Edited by on 11/11/2015.
 */
public class CommonSteps extends RunTest{

    @When("^I tap continue$")
    public void i_tap_continue() throws Throwable {
        if (common.isElementPresent(common.Alert)){
            common.Alert_Btn.click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(common.Continue_Btn)).click();
    }

    @Then("^I can clear all text fields using the Clear icon$")
    public void i_can_clear_all_text_fields_using_the_clear_icon(DataTable table) throws Throwable {
        for (Map<String, String> map : table.asMaps(String.class, String.class)) {
            String field = map.get("field");

            switch (field) {
                case "First_Name":
                    if (platform.equals("android")) {
                        wait.until(ExpectedConditions.visibilityOf(yourDetailsPage.First_Name)).sendKeys("Test");
                        common.Clear_Field.click();
                        yourDetailsPage.Second_Name.click();
                        wait.until(ExpectedConditions.visibilityOf(yourDetailsPage.First_Name_empty));
                        break;

                    }
                case "Surname":
                    wait.until(ExpectedConditions.visibilityOf(yourDetailsPage.Second_Name)).sendKeys("Test");
                    common.Clear_Field.click();
                    yourDetailsPage.DOB.click();
                    wait.until(ExpectedConditions.visibilityOf(yourDetailsPage.Second_Name_empty));
                    break;
                case "DOB":
                    wait.until(ExpectedConditions.visibilityOf(yourDetailsPage.DOB)).sendKeys("123");
                    common.Clear_Field.click();
                    yourDetailsPage.Mobile_Number.click();
                    wait.until(ExpectedConditions.visibilityOf(yourDetailsPage.DOB_empty));
                    break;
                case "Mobile_Number":
                    wait.until(ExpectedConditions.visibilityOf(yourDetailsPage.Mobile_Number)).sendKeys("123");
                    common.Clear_Field.click();
                    yourDetailsPage.Email.click();
                    wait.until(ExpectedConditions.visibilityOf(yourDetailsPage.Mobile_Number_empty));
                    break;
                case "Email":
                    wait.until(ExpectedConditions.visibilityOf(yourDetailsPage.Email)).sendKeys("Test");
                    common.Clear_Field.click();
                    yourDetailsPage.Mobile_Number.click();
                    wait.until(ExpectedConditions.visibilityOf(yourDetailsPage.Email_empty));
            }
        }
    }
}
