package com.qa.pages;

import com.qa.pages.LoginPage;
import com.qa.pages.MenuPage;

public class MenuActionsPage extends MenuPage {
    public LoginPage logOutFromAndroidApp() throws InterruptedException {
        pressHamburgerBtn();
        pressCatalogLogoutOption();
        pressLogoutOptionConfirmationMessage();
        Thread.sleep(1000);
        pressLogoutOptionConfirmationMessage();
        return new LoginPage();
    }

    public LoginPage logOutFromIOSApp() throws InterruptedException {
        pressHamburgerBtn();
        pressCatalogLogoutOption();
        pressLogoutOptionConfirmationMessage();
        iOSPressOKConfirmationLogOut();
        return new LoginPage();
    }
}
