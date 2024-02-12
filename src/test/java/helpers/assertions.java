package helpers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class assertions {
    private WebDriverWait wait;

    public assertions(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(70));

    }
    public WebElement shoudBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement shouldBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Boolean shouldContains(WebElement element, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public Alert alertShouldBeVisible() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }


}
