package pages;

import data.loginData;
import helpers.assertions;
import helpers.generators;
import locators.loginLocator;
import helpers.operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends loginLocator{
    WebDriver driver;
    private assertions asserts;
    private operations operates;

    public loginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.asserts = new assertions(driver);
        this.operates = new operations(driver);
    }

    public void navigateToTheWebsite() {
        driver.get("https://demoqa.com/profile");
    }

    public void clickLoginMenu() {
        asserts.shouldBeClickable(MENU_LOGIN).click();
    }

    public void inputUsernamePasswordField_valid() {
        FIELD_USERNAME.sendKeys(loginData.TRUE_USERNAME);
        FIELD_PASSWORD.sendKeys(loginData.TRUE_PASSWORD);
    }

    public void clickLoginButton() throws InterruptedException {
        Thread.sleep(2000);
       operates.scrollToElement(BUTTON_LOGIN);
       asserts.shouldBeClickable(BUTTON_LOGIN).click();
    }

    public void validateErrorMessageAppear(String errorMessage) {
        asserts.shouldContains(TEXT_ERROR_MESSAGE, errorMessage);
    }

    public void alreadyLoggedIn() throws InterruptedException {
        clickLoginMenu();
        inputUsernamePasswordField_valid();
        clickLoginButton();
    }

    public void inputUsernamePassword_invalid(String dataType) {
        String Username = "";
        String Password = "";

        switch (dataType) {
            case "Unregistered":
                Username = generators.generateRandomString(6);
                Password = generators.generateRandomPassword(10);
                break;
            case "EmptyUsername":
                Password = generators.generateRandomPassword(10);
                break;
            case "EmptyPassword":
                Password = generators.generateRandomPassword(10);
                break;
            case "InvalidUsername":
                Username = generators.generateRandomString(6);
                Password = loginData.TRUE_PASSWORD;
                break;
            case "InvalidPassword":
                Username = loginData.TRUE_USERNAME;
                Password = generators.generateRandomPassword(10);
                break;
            case "ValidWithSpace":
                Username = loginData.TRUE_USERNAME + "  ";
                Password = loginData.TRUE_PASSWORD;
                break;
            case "EmptyUserPass":
                break;
        }

        FIELD_USERNAME.sendKeys(Username);
        FIELD_PASSWORD.sendKeys(Password);
    }

}
