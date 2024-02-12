package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class collectionLocator {

    @FindBy(css = "[id=\"gotoStore\"]")
    protected WebElement BUTTON_GO_TO_BOOKSTORE;

    @FindBy(css = "div[class='text-right fullButton'] #addNewRecordButton")
    protected WebElement BUTTON_ADD_TO_YOUR_COLLECTION;

    @FindBy(css = "div[class^='text-left'] button[id='addNewRecordButton']")
    public WebElement BUTTON_BACK_TO_BOOK_STORE;
}
