package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import config.base;
import pages.collectionPage;

import java.util.List;

public class collectionStep extends base {
    collectionPage CollectionPage;

    @When("Click Go To Book Store button")
    public void clickBookStoreMenu() throws InterruptedException {
        CollectionPage = new collectionPage(driver);
        Thread.sleep(5000);
        CollectionPage.clickBookStoreMenu();
    }

    @And("Click {string} title")
    public void clickTitle(String bookName) throws InterruptedException {
        Thread.sleep(5000);
        CollectionPage.clickBookText(bookName);
    }

    @And("Click Add to your collection button")
    public void clickAddToYourCollectionButton() throws InterruptedException {
        Thread.sleep(5000);
        CollectionPage.clickAddToYouCollection();
    }

    @When("Add the following books to the collection:")
    public void addTheFollowingBooksToTheCollection(List<String> bookNames) throws InterruptedException {
        Thread.sleep(5000);
        CollectionPage = new collectionPage(driver);
        CollectionPage.addTheseBook(bookNames);
    }
}
