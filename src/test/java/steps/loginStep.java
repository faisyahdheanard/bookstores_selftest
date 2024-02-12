package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.loginPage;
import config.base;

public class loginStep extends base{
    loginPage LoginPage;

    @Given("Navigate to the website")
    public void navigateToTheWebsite() {
        getDriver();
        LoginPage = new loginPage(driver);
        LoginPage.navigateToTheWebsite();
    }

    @When("Click Login menu")
    public void clickLoginMenu() throws InterruptedException {
        Thread.sleep(2000);
        LoginPage.clickLoginMenu();
    }

    @When("Input UserName and Password fields with valid data")
    public void inputUserNameAndPasswordFieldsWithValidData() {
        LoginPage.inputUsernamePasswordField_valid();
    }

    @And("Click Login button")
    public void clickLoginButton() throws InterruptedException {
        Thread.sleep(2000);
        LoginPage.clickLoginButton();
    }

    @When("Input UserName and Password fields with unregistered account")
    public void inputUserNameAndPasswordFieldsWithUnregisteredAccount() {
        LoginPage.inputUsernamePassword_invalid("Unregistered");
    }

    @Then("Error message is displayed saying {string}")
    public void errorMessageIsDisplayedSaying(String errorMessage) {
        LoginPage.validateErrorMessageAppear(errorMessage);
        quitDriver();

    }

    @When("Input UserName and Password fields with invalid {string} data")
    public void inputUserNameAndPasswordFieldsWithInvalidData(String dataType) {
        LoginPage.inputUsernamePassword_invalid(dataType);
    }

    @Given("Already logged in and on the Profile page")
    public void alreadyLoggedInAndOnTheProfilePage() throws InterruptedException {
        Thread.sleep(2000);
        LoginPage = new loginPage(driver);
        LoginPage.alreadyLoggedIn();
    }


}
