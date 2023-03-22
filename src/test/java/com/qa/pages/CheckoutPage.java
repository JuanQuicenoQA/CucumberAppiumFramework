package com.qa.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage{

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Checkout\" AND name == \"Checkout\"")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Checkout\")")
    public WebElement checkoutTitlePage;

    public String getCheckoutTitlePage() {
        return getText(checkoutTitlePage,"Title page is: ");
    }
}
