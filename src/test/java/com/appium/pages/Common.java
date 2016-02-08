package com.appium.pages;

import com.appium.runner.RunTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * edited by Parid on 10/02/16.
 */
public class Common extends RunTest{


    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.Button[1]")
//  @iOSFindBy()
    public MobileElement Accept_Agree_Btn;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]\n")
//  @iOSFindBy()
    public MobileElement ForSale_Btn;

    @AndroidFindBy(name = "OK, got it")
    @iOSFindBy(name = "OK, got it")
    public MobileElement Rounding_Popup_Btn;

    @AndroidFindBy(name = "Continue")
    @iOSFindBy(id = "Continue")
    public MobileElement Cnt_Btn ;

    @AndroidFindBy(name = "menu_basket_btn")
    @iOSFindBy(id = "icon basket")
    public MobileElement Basket;

    @AndroidFindBy(id = "alert_title")
//    @iOSFindBy(id = "x")
    public MobileElement Alert;

    @AndroidFindBy(id = "alert_btn")
    @iOSFindBy(id = "OK, got it")
    public MobileElement Alert_Btn;

    @AndroidFindBy(id = "alert_btn_cancel")
    @iOSFindBy(id = "Cancel")
    public MobileElement Alert_Cancel;

    @AndroidFindBy(name = "alert_content")
//    @iOSFindBy(id = "Continue")
    public MobileElement Alert_Content;

    @AndroidFindBy(id = "Navigate up")
    @iOSFindBy(id = "back_bar_button")
    public MobileElement Back_Btn;


    @AndroidFindBy(id = "tvxImageView")
  //  @iOSFindBy()
    public MobileElement Clear_Field;

    public Common(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isElementPresent(MobileElement locator) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        try {
            locator.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
        finally {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }

}
