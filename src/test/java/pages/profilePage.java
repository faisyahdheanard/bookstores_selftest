package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import helpers.assertions;
import helpers.operations;

import locators.profileLocator;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class profilePage extends profileLocator{
    WebDriver driver;
    private assertions asserts;
    private operations operates;

    public profilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.asserts = new assertions(driver);
        this.operates = new operations(driver);
    }

    private By bookTitle(String bookNames) {
        return By.cssSelector("[id=\"see-book-" + bookNames + "\"]");
    }

    public void validateVisibleUsernameValue() {
        asserts.shouldContains(TEXT_USERNAME_VALUE, "dheatesting");
    }

    public void clickProfileMenu() {
        asserts.shouldBeClickable(MENU_PROFILE).click();
    }

    public void validateBookDisplayed(List<String> books) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        for (String expectedBook : books) {
            WebElement productsInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(bookTitle(expectedBook)));
            String actualBook = productsInCart.getText();

            assertEquals(expectedBook, actualBook);
        }
    }

    public void errorMessageNotLogin() {
        asserts.shoudBeVisible(TEXT_ERROR_MESSAGE_PROFILE);
    }

    public void clickNextButton() throws InterruptedException {
        operates.scrollDown();
        Thread.sleep(5000);
        asserts.shouldBeClickable(BUTTON_NEXT).click();
    }

    public void clickPreviousButton() throws InterruptedException {
        operates.scrollDown();
        Thread.sleep(5000);
        asserts.shouldBeClickable(BUTTON_PREVIOUS).click();
    }

    public void inputSearchField(String bookName) {
        FIELD_SEARCH.sendKeys(bookName);
    }

    public void inputPageJumpField(String pageNumber) throws InterruptedException {
        operates.scrollDown();
        Thread.sleep(3000);
        FIELD_PAGE_JUMP.sendKeys(pageNumber);
        FIELD_PAGE_JUMP.sendKeys(Keys.ENTER);
    }

    public void selectRowsDropdown(String value) throws InterruptedException {
        operates.scrollDown();
        Thread.sleep(3000);
        Select dropdown = new Select(DROPDOWN_ROWS);
        dropdown.selectByValue(value);
    }

    public void clickDeleteButton() {
        asserts.shouldBeClickable(BUTTON_DELETE).click();
    }

    public void clickOkDeleteButton() {
        asserts.shouldBeClickable(BUTTON_DELETE_OK).click();
    }

    public void validateBookIsNotOnTheCollection(List<String> bookName) {
        for(String bookNames : bookName) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            Boolean book = wait.until(ExpectedConditions.invisibilityOfElementLocated(bookTitle(bookNames)));
            assertTrue(book);
            }
    }

    public void clickDeleteAllBooksButton() throws InterruptedException {
        Thread.sleep(3000);
        operates.scrollDown();
        Thread.sleep(12000);
        asserts.shouldBeClickable(BUTTON_DELETE_ALL_BOOKS).click();
    }

    public void clickDeleteAccountButton() throws InterruptedException {
        Thread.sleep(3000);
        operates.scrollDown();
        Thread.sleep(3000);
        asserts.shouldBeClickable(BUTTON_DELETE_ACCOUNT).click();
    }

    public void clickLogoutButton() {
        asserts.shouldBeClickable(BUTTON_LOGOUT).click();
    }

    public void allBooksDeletedForTestingPurposes() throws InterruptedException {
        Thread.sleep(3000);
        clickDeleteAllBooksButton();
        clickOkDeleteButton();
    }

    public void theBookDeletedForTestingPurposes() throws InterruptedException {
        clickProfileMenu();
        clickDeleteAllBooksButton();
        clickOkDeleteButton();
    }

    public void removedAllBookCollectionsPerOne() throws InterruptedException {
        Thread.sleep(3000);
        clickDeleteButton();
        clickOkDeleteButton();

        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.navigate().refresh();

        Thread.sleep(3000);
        operates.scrollDown();
        clickDeleteAllBooksButton();
        clickOkDeleteButton();
    }
}
