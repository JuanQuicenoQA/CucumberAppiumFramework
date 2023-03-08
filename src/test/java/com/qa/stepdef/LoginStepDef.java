package com.qa.stepdef;

import com.qa.pages.CheckoutPage;
import com.qa.pages.MenuActionsPage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;
import com.qa.utils.GlobalParams;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginStepDef {
    GlobalParams globalParams = new GlobalParams();
    MenuActionsPage menuActionsPage = new MenuActionsPage();

    @Given("I'm in login page")
    public void iMInLoginPage() throws InterruptedException {
        switch (globalParams.getPlatformName()) {
            case "Android" -> {
                menuActionsPage.logOutFromAndroidApp();
            }
            case "iOS" -> {
                menuActionsPage.logOutFromIOSApp();
            }
        };
    }

    @When("I enter username as {string}")
    public void iEnterUsernameAs(String username) throws InterruptedException {
        new LoginPage().enterUsername(username);
    }

    @When("I enter password as {string}")
    public void iEnterPasswordAs(String password) {
        new LoginPage().enterPassword(password);
    }

    @When("I click on Login button")
    public void iClickOnLoginButton() {
        new LoginPage().pressLoginBtn();
    }

    @Then("login should fail with an error {string}")
    public void loginShouldFailWithAnError(String err) {
        Assert.assertEquals(new LoginPage().getErrorText(), err);
    }

    @Then("I should see Products page with title {string}")
    public void iShouldSeeProductsPageWithTitle(String title) {
        Assert.assertEquals(new ProductsPage().getTitle(), title);
    }

    @Then("User should be redirected to {string} page")
    public void userShouldBeRedirectedToPage(String titlePage) {
       Assert.assertEquals(new CheckoutPage().getCheckoutTitlePage(), titlePage);
    }
}
