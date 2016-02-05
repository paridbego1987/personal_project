package com.appium.steps;

import com.appium.runner.RunTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by Derin on 25/11/15.
 */

public class ParidSteps extends RunTest {

    public String domestic_spend = "0";
    public Double current_spend = Double.parseDouble(domestic_spend);
    public Double updated_spend = Double.parseDouble(domestic_spend);

    @Then("^I can see the Add Currency button$")
    public void i_can_see_the_Add_Currency_button() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Add_Currency));
    }

    @When("^I click the Add Currency button$")
    public void i_click_the_Add_Currency_button() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Add_Currency)).click();
    }

    @Then("^I can see the Currency List screen$")
    public void i_can_see_the_Currency_List_screen() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(currencyListPage.Currency_List_Title));
        wait.until(ExpectedConditions.visibilityOf(currencyListPage.Currency_List));
    }

    @Given("^I select \"([^\"]*)\" as a Second currency country$")
    public void i_select_as_a_Second_currency(String currency) throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(currencyListPage.Currency_List));
        Thread.sleep(2000);

        List<MobileElement> countries;
        if (platform.equals("iOS")) {
            countries = driver.findElementsByName("(" + currency + ")");
        } else {
            countries = driver.findElementsById("currency_code");
        }

        for (MobileElement country : countries) {
            if (country.getText().contains(currency)) {
                country.click();
                break;
            }
        }
    }

    @Then("^both \"([^\"]*)\" and \"([^\"]*)\" are displayed in the Your Order screen$")
    public void both_and_are_displayed_in_the_Your_Order_screen(String currency1, String currency2) throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Currency_Code));
        Thread.sleep(2000);
        List<MobileElement> codes = driver.findElementsById("currency_code");
        for (MobileElement code : codes) {
            Assert.assertTrue(code.getText().contains(currency1) || code.getText().contains(currency2) || code.getText().isEmpty());
        }
    }

    @Then("^the subtotal includes my total spend for all currencies$")
    public void the_subtotal_includes_my_total_spend_for_all_currencies() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Domestic_Amount));
        String subtotal_text = "";
        double total_spend = 0.00;
        double subtotal;

        //Currency Spend amounts
        List<MobileElement> amounts = driver.findElementsById("domestic_amount");
        for (MobileElement amount:amounts) {
            String spend = amount.getText().replaceAll("[^0-9.]", "");
            double spend_value = Double.parseDouble(spend);
            total_spend = spend_value + total_spend;
        }

        //Subtotal Amount
        if (platform.equals("iOS")) {
            subtotal_text = wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Order_Subtotal)).getText().replaceAll("[^0-9.]", "");
//            subtotal = Double.parseDouble(subtotal_text);
        }   else if (platform.equals("android")) {
            String fees = checkoutPage.Fees_Panel.getAttribute("name");
            String[] lines = fees.split("\n");

            for (String line : lines) {
                String[] vars = line.split(": ");
                if (vars[0].equals("Subtotal")) {
                    subtotal_text = vars[1].replaceAll("[^0-9.]", "");
//                    subtotal = Double.parseDouble(subtotal_text);
                }
            }
        }
        subtotal = Double.parseDouble(subtotal_text);
        Assert.assertTrue(subtotal >= total_spend);
    }

    @Then("^\"([^\"]*)\" is the only currency displayed in the Your Order screen$")
    public void is_the_only_currency_displayed_in_the_Your_Order_screen(String currency) throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Currency_Code));
        Thread.sleep(2000);
        List<MobileElement> codes = driver.findElementsById("currency_code");
//        Assert.assertEquals(1, codes.size());
        for (MobileElement code : codes) {
            Assert.assertTrue(code.getText().contains(currency) || code.getText().isEmpty());
        }
    }


    @When("^I tap Edit currency$")
    public void i_tap_Edit_currency() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Domestic_Amount));
        domestic_spend = yourOrderPage.Domestic_Amount.getText().replaceAll("[^0-9.]", "");
        current_spend = Double.parseDouble(domestic_spend);
        wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Edit_Order)).click();
    }

    @When("^I tap Done editing$")
    public void i_tap_Done_editing() throws Throwable {
        if (platform.equals("iOS")) {
            wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Done)).click();
        }
    }

    @Given("^I tap the Amend icon$")
    public void i_tap_the_Amend_icon() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Amend_Currency)).click();
    }

    @When("^I tap the Remove icon$")
    public void i_tap_the_Remove_icon() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Remove_Currency)).click();
        if (platform.equals("iOS")) {
            Thread.sleep(1000);
            if (common.isElementPresent(yourOrderPage.Remove_Alert)){
                yourOrderPage.Remove_Alert.click();
            }
        }
    }

    @When("^I accept the Remove alert$")
    public void i_accept_the_Remove_alert() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Remove_Alert)).click();
    }

    @When("^I cancel the Remove alert$")
    public void i_cancel_the_Remove_alert() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(common.Alert_Cancel)).click();
    }

    @When("^I remove one currency$")
    public void i_remove_one_currency() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Remove_Currency)).click();
        wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Remove_Alert)).click();
    }

    @When("^I remove the only currency$")
    public void i_remove_the_only_currency() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Remove_Currency)).click();
        wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Remove_Alert)).click();
        if (platform.equals("iOS")) {
            wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Remove_Alert)).click();
        }
    }

    @Then("^I am returned to Your Order Screen$")
    public void i_am_returned_to_Your_Order_Screen() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Currency_Code));
    }

    @Then("^the spend amount is updated in Your Order$")
    public void the_spend_amount_is_updated_in_Your_Order() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Domestic_Amount));
        domestic_spend = yourOrderPage.Domestic_Amount.getText().replaceAll("[^0-9.]", "");
        updated_spend = Double.parseDouble(domestic_spend);
        Assert.assertTrue(updated_spend > current_spend);
    }

    @Then("^the Subtotal includes the spend amount$")
    public void the_Subtotal_includes_the_spend_amount() throws Throwable {

    }

    @Then("^\"([^\"]*)\" currency is disabled for selection$")
    public void currency_is_disabled_for_selection(String currency) throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(currencyListPage.Currency_List));
        List<MobileElement> countries = driver.findElementsById("title");
        for (MobileElement country : countries) {
            if (country.getText().equals(currency)) {
                country.click();
                break;
            }
        }
    }

    @When("^I have one currency in Your order$")
    public void i_have_one_currency_in_Your_order() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Currency_Code));
        List<MobileElement> codes = driver.findElementsById("currency_code");
        Assert.assertEquals(1, codes.size());
    }

    @When("^I tap Back$")
    public void i_tap_Back() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(common.Back_Btn)).click();
    }

    @Then("^I go back to the slider$")
    public void i_go_back_to_the_slider() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(sliderPage.Slider_Screen));
    }

    @Then("^I am presented with a confirmation prompt$")
    public void i_am_presented_with_a_confirmation_prompt() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Clear_currency_prompt));
    }

    @Then("^I tap I'll stay here$")
    public void i_tap_I_ll_stay_here() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Stay_here_btn)).click();
    }

    @Then("^I am in Your order screen$")
    public void i_am_in_Your_order_screen() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Order_Header));
    }

    @Then("^I tap Clear them$")
    public void i_tap_Clear_them() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Clear_btn)).click();
    }

    @Given("^I tap Checkout$")
    public void i_tap_Checkout() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(yourOrderPage.Checkout)).click();
    }


}
