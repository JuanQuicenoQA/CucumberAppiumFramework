package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Products\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView")
    private WebElement productTitleText;


    public String getTitle(){
        return getText(productTitleText, "Title page is: ");
    }
}
