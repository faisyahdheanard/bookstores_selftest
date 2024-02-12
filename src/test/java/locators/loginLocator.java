package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginLocator {

    @FindBy(css = "a[href='/login']")
    protected WebElement MENU_LOGIN;

    @FindBy(css = "#userName")
    protected WebElement FIELD_USERNAME;

    @FindBy(css = "#password")
    protected WebElement FIELD_PASSWORD;

    @FindBy(css = "#login")
    protected WebElement BUTTON_LOGIN;

    @FindBy(css = "#name")
    protected WebElement TEXT_ERROR_MESSAGE;
}
