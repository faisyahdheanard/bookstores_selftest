package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.profilePage;
import config.base;

import java.util.List;

public class profileStep extends base{

    profilePage ProfilePage;

    @Then("Username is visible in Profile page")
    public void usernameIsVisibleInProfilePage() throws InterruptedException {
        ProfilePage = new profilePage(driver);
        Thread.sleep(5000);
        ProfilePage.validateVisibleUsernameValue();
        quitDriver();
    }

    @When("Click Profile menu")
    public void clickProfileMenu() throws InterruptedException {
        ProfilePage = new profilePage(driver);
        Thread.sleep(5000);
        ProfilePage.clickProfileMenu();
    }

    @And("The following book should appear:")
    public void theseBookWillAppear(List<String> bookNames) {
        ProfilePage.validateBookDisplayed(bookNames);
    }

    @And("Displayed a message guiding the user to log in or register before accessing profile information")
    public void displayedAMessageGuidingTheUserToLogInOrRegisterBeforeAccessingProfileInformation() {
        ProfilePage = new profilePage(driver);
        ProfilePage.errorMessageNotLogin();
        quitDriver();
    }

    @And("Click Next button")
    public void clickNextButton() throws InterruptedException {
        Thread.sleep(5000);
        ProfilePage.clickNextButton();
    }

    @When("Click Previous button")
    public void clickPreviousButton() throws InterruptedException {
        Thread.sleep(5000);
        ProfilePage.clickPreviousButton();
    }

    @When("Input {string} in search box")
    public void inputInSearchBox(String bookName) {
        ProfilePage.inputSearchField(bookName);
    }

    @When("Input {string} in page box")
    public void inputInPageBox(String pageNumber) throws InterruptedException {
        ProfilePage.inputPageJumpField(pageNumber);
    }

    @When("Select {string} dropdown")
    public void selectDropdown(String rowNumber) throws InterruptedException {
        ProfilePage = new profilePage(driver);
        ProfilePage.selectRowsDropdown(rowNumber);
    }

    @And("Click Remove button")
    public void clickRemoveButton() throws InterruptedException {
        Thread.sleep(5000);
        ProfilePage.clickDeleteButton();
    }

    @And("Click OK button")
    public void clickOKButton() throws InterruptedException {
        Thread.sleep(5000);
        ProfilePage.clickOkDeleteButton();
    }

    @And("The following book has been deleted:")
    public void bookHasBeenDeletedAlert(List<String> bookName) {
        ProfilePage.validateBookIsNotOnTheCollection(bookName);
        quitDriver();
    }

    @And("Click Delete All Books button")
    public void clickDeleteAllBooksButton() throws InterruptedException {
        Thread.sleep(5000);
        ProfilePage = new profilePage(driver);
        ProfilePage.clickDeleteAllBooksButton();
    }

    @When("Click Log out button")
    public void clickLogOutButton() throws InterruptedException {
        Thread.sleep(5000);
        ProfilePage = new profilePage(driver);
        ProfilePage.clickLogoutButton();
    }

    @When("Click Delete Account button")
    public void clickDeleteAccountButton() throws InterruptedException {
        Thread.sleep(5000);
        ProfilePage = new profilePage(driver);
        ProfilePage.clickDeleteAccountButton();
    }

    @And("All books will be deleted for testing purposes")
    public void allBooksWillBeDeletedForTestingPurposes() throws InterruptedException {
        ProfilePage = new profilePage(driver);
        ProfilePage.allBooksDeletedForTestingPurposes();
        quitDriver();
    }

    @And("The book will be deleted for testing purposes")
    public void theBookDeleted() throws InterruptedException {
        ProfilePage = new profilePage(driver);
        ProfilePage.theBookDeletedForTestingPurposes();
        quitDriver();
    }

    @And("Removed all book collections")
    public void removedAllBookCollections() throws InterruptedException {
        ProfilePage = new profilePage(driver);
        ProfilePage.removedAllBookCollectionsPerOne();
    }
}
