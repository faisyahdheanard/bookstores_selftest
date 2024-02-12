package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class profileLocator {

    @FindBy(css = "#userName-value")
    protected WebElement TEXT_USERNAME_VALUE;

    @FindBy(xpath = "//div[@class=\"accordion\"]/div[6]/div/ul/li[3]")
    protected WebElement MENU_PROFILE;

    @FindBy(css = "#notLoggin-label")
    protected WebElement TEXT_ERROR_MESSAGE_PROFILE;

    @FindBy(css = ".-next")
    protected WebElement BUTTON_NEXT;

    @FindBy(css = ".-previous")
    protected WebElement BUTTON_PREVIOUS;

    @FindBy(css = "#searchBox")
    protected WebElement FIELD_SEARCH;

    @FindBy(xpath = "//*[@aria-label='jump to page']")
    protected WebElement FIELD_PAGE_JUMP;

    @FindBy(css = "[aria-label=\"rows per page\"]")
    protected WebElement DROPDOWN_ROWS;

    @FindBy(css = "#delete-record-undefined")
    protected WebElement BUTTON_DELETE;

    @FindBy(css = "#closeSmallModal-ok")
    protected WebElement BUTTON_DELETE_OK;

    @FindBy(css = "#closeSmallModal-cancel")
    protected WebElement BUTTON_DELETE_CANCEL;

    @FindBy(xpath = "//div[@class=\"mt-2 buttonWrap row\"]/div[3]/button")
    protected WebElement BUTTON_DELETE_ALL_BOOKS;

    @FindBy(css = ".text-center.button")
    protected WebElement BUTTON_DELETE_ACCOUNT;

    @FindBy(xpath = "//div[@class=\"text-right col-md-5 col-sm-12\"]/button")
    protected WebElement BUTTON_LOGOUT;
}
