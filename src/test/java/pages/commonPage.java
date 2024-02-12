package pages;

import helpers.assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class commonPage {
    WebDriver driver;
    WebDriverWait wait;
    private assertions asserts;


    public commonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.asserts = new assertions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    public void validatePageDisplayed(String pageNames) {
        By pageTextLocator = By.xpath("//*[contains(text(), '" + pageNames + "')]");
        WebElement pageText = wait.until(ExpectedConditions.elementToBeClickable(pageTextLocator));
        assertTrue(pageText.isDisplayed());
    }

    public void popUpAlertIsAppear(String message) {
        asserts.alertShouldBeVisible();
        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        assertEquals(alertText, message);
        alert.accept();
    }
}
