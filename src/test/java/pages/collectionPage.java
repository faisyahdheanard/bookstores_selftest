package pages;

import helpers.assertions;
import helpers.operations;
import locators.collectionLocator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class collectionPage extends collectionLocator{
    WebDriver driver;
    private assertions asserts;
    private operations operates;

    public collectionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.asserts = new assertions(driver);
        this.operates = new operations(driver);
    }

    private By bookTitle(String bookNames) {
        return By.cssSelector("[id=\"see-book-" + bookNames + "\"]");
    }

    public void clickBookStoreMenu() throws InterruptedException {
        Thread.sleep(5000);
        operates.scrollDown();
        Thread.sleep(7000);
        asserts.shouldBeClickable(BUTTON_GO_TO_BOOKSTORE).click();
    }
    public void clickBookText(String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement bookTitles = wait.until(ExpectedConditions.visibilityOfElementLocated(bookTitle(title)));
        bookTitles.click();
    }

    public void clickAddToYouCollection() throws InterruptedException {
        operates.scrollToElement(BUTTON_ADD_TO_YOUR_COLLECTION);
        Thread.sleep(3000);
        asserts.shouldBeClickable(BUTTON_ADD_TO_YOUR_COLLECTION).click();
    }

    public void clickBackToBookStore() {
        asserts.shouldBeClickable(BUTTON_BACK_TO_BOOK_STORE).click();
    }
     public void addTheseBook(List<String> titles) throws InterruptedException {
        for(String title : titles) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

            Thread.sleep(3000);
            operates.scrollToElementLocated(bookTitle(title));

            WebElement bookTitles = wait.until(ExpectedConditions.visibilityOfElementLocated(bookTitle(title)));
            Thread.sleep(2000);
            bookTitles.click();

            Thread.sleep(3000);

            clickAddToYouCollection();

            asserts.alertShouldBeVisible();
            Alert alert = driver.switchTo().alert();
            alert.accept();

            Thread.sleep(3000);

            clickBackToBookStore();
        }
     }
}
