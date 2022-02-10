package com.ut.acceptance.cucumber.glue;

import com.ut.acceptance.factory.WebDriverFactory;
import com.ut.acceptance.impl.SimpleOrderTestCase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SimpleOrderFeatureGlue {

    private WebDriver webDriver;

    private SimpleOrderTestCase simpleOrderTestCase;

    @Before
    public void setup() {
        webDriver = WebDriverFactory.CHROME();
        simpleOrderTestCase = new SimpleOrderTestCase(webDriver);
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
        }
    }

    @Given("user is on the main page")
    public void userIsOnTheMainPage() {
        simpleOrderTestCase.openMainPage();
    }

    @When("user searches for the product {string}")
    public void userSearchesForTheProductItem(final String item) {
        simpleOrderTestCase.searchFor(item);
    }

    @Then("user gets search results for {string}")
    public void userGetsSearchResults(final String item) {
        simpleOrderTestCase.searchResultsFor(item);
    }
}
