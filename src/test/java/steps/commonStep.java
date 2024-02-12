package steps;

import io.cucumber.java.en.Then;

import config.base;
import io.cucumber.java.en.When;
import pages.commonPage;

public class commonStep extends base{

    commonPage CommonPage = new commonPage(driver);

    @Then("The {string} page is displayed")
    public void thePageIsDisplayed(String pageName) throws InterruptedException {
        Thread.sleep(5000);
        CommonPage = new commonPage(driver);
        CommonPage.validatePageDisplayed(pageName);
    }

    @Then("Failed to sign in")
    public void failedToSignIn() {
        CommonPage.validatePageDisplayed("Login");
        quitDriver();
    }

    @Then("Pop-up alert is displayed saying {string}")
    public void popUpAlertIsDisplayedSaying(String alertMessage) throws InterruptedException {
        Thread.sleep(5000);
        CommonPage.popUpAlertIsAppear(alertMessage);
    }
}
