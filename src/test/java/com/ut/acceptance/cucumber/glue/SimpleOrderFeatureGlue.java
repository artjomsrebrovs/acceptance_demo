package com.ut.acceptance.cucumber.glue;

import com.ut.acceptance.factory.WebDriverFactory;
import com.ut.acceptance.impl.SimpleOrderTestCase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
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

    @Given("user navigates to {string}")
    public void userNavigatesTo(final String url) {
        simpleOrderTestCase.navigateTo(url);
    }

    @Then("user is on the main page")
    public void userIsOnTheMainPage() {
        simpleOrderTestCase.mainPage();
    }

    @When("user searches for the product {string}")
    public void userSearchesForTheProductItem(final String item) {
        simpleOrderTestCase.searchFor(item);
    }

    @Then("user gets search results for {string}")
    public void userGetsSearchResults(final String item) {
        simpleOrderTestCase.searchResultsFor(item);
    }

    @When("user clicks on found product {string}")
    public void userClicksOnFoundProduct(final String item) {
        simpleOrderTestCase.clickOnItem(item);
    }

    @Then("product {string} details page opens")
    public void productDetailsPageOpens(final String item) {
        simpleOrderTestCase.detailsFor(item);
    }

    @When("user inputs product quantity of {int}")
    public void userInputsProductQuantityOf(final int quantity) {
        simpleOrderTestCase.addQuantity(quantity);
    }

    @And("user clicks add to cart button")
    public void userClicksAddToCartButton() {
        simpleOrderTestCase.clickAddToCart();
    }

    @Then("user gets message saying product successfully added to cart")
    public void userGetsMessageSayingProductSuccessfullyAddedToCart() {
        simpleOrderTestCase.cartAddSuccess();
    }

    @And("user clicks on cart link in success message")
    public void userClicksOnCartLinkInSuccessMessage() {
        simpleOrderTestCase.clickCartLink();
    }

    @Then("cart page opens")
    public void cartPageOpens() {
        simpleOrderTestCase.userCart();
    }

    @When("user clicks on checkout button")
    public void userClicksOnCheckoutButton() {
        simpleOrderTestCase.clickCheckout();
    }

    @Then("checkout page opens")
    public void checkoutPageOpens() {
        simpleOrderTestCase.checkoutPage();
    }

    @And("first step account panel is expanded")
    public void firstStepAccountPanelIsExpanded() {
        simpleOrderTestCase.stepOneAccount();
    }

    @Then("user selects guest account option")
    public void userSelectsGuestAccountOption() {
        simpleOrderTestCase.selectGuestAccount();
    }

    @And("user clicks continue button on account panel")
    public void userClicksContinueButtonOnAccountPanel() {
        simpleOrderTestCase.clickContinueOnAccountPanel();
    }

    @Then("second step guest information panel is expanded")
    public void secondStepGuestInformationPanelIsExpanded() {
        simpleOrderTestCase.stepTwoGuestInfo();
    }

    @Then("user enters its guest information in form")
    public void userEntersItsGuestInformationInForm() {
        simpleOrderTestCase.guestInformationForm();
    }

    @And("user clicks continue button on guest information panel")
    public void userClicksContinueButtonOnGuestInformationPanel() {
        simpleOrderTestCase.clickContinueOnGuestInformationPanel();
    }

    @Then("forth step shipping panel is expanded")
    public void forthStepShippingPanelIsExpanded() {
        simpleOrderTestCase.stepFourShipping();
    }

    @Then("user selects flat shipping method")
    public void userSelectsFlatShippingMethod() {
        simpleOrderTestCase.selectFlatShipping();
    }

    @And("user clicks continue on shipping panel")
    public void userClicksContinueOnShippingPanel() {
        simpleOrderTestCase.clickContinueOnShippingPanel();
    }

    @Then("fifth step payment panel is expanded")
    public void fifthStepPaymentPanelIsExpanded() {
        simpleOrderTestCase.stepFivePayment();
    }

    @Then("user selects cod payment method")
    public void userSelectsCodPaymentMethod() {
        simpleOrderTestCase.selectCodPayment();
    }

    @Then("user agrees with terms and conditions")
    public void userAgreesWithTermsAndConditions() {
        simpleOrderTestCase.checkTermsAndConditions();
    }

    @And("user clicks continue on payment panel")
    public void userClicksContinueOnPaymentPanel() {
        simpleOrderTestCase.clickContinueOnPaymentPanel();
    }

    @Then("sixth step order confirmation panel is expanded")
    public void sixthStepOrderConfirmationPanelIsExpanded() {
        simpleOrderTestCase.stepSixConfirm();
    }

    @And("user clicks continue on confirmation panel")
    public void userClicksContinueOnConfirmationPanel() {
        simpleOrderTestCase.clickContinueOnConfirmPanel();
    }

    @Then("order success page opens")
    public void orderSuccessPageOpens() {
        simpleOrderTestCase.orderSuccessPage();
    }

    @And("user clicks continue on success page")
    public void userClickContinueOnSuccessPage() {
        simpleOrderTestCase.clickContinueOnOrderSuccessPage();
    }
}
