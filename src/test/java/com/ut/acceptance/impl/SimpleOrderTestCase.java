package com.ut.acceptance.impl;

import com.ut.acceptance.TestCase;
import com.ut.acceptance.page.impl.*;
import com.ut.acceptance.to.GuestInformation;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class SimpleOrderTestCase implements TestCase {

    private final static String APPLICATION_URL = "https://opencart.abstracta.us/";
    private final static String ITEM_NAME = "iPhone";
    private final static int ITEM_QUANTITY = 1;

    private final static String NAME = "Artjoms";
    private final static String SURNAME = "Rebrovs";
    private final static String EMAIL = "artjoms.rebrovs@email.com";
    private final static String PHONE = "123456789";
    private final static String ADDRESS = "Riga street 1A";
    private final static String CITY = "Riga";
    private final static String POSTAL_CODE = "LV-0000";
    private final static String COUNTRY = "Latvia";
    private final static String AREA = "Rīga";

    private WebDriver webDriver;
    private MainPage mainPage;
    private ItemPage itemPage;
    private SearchResultsPage searchResultsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private OrderSuccessPage orderSuccessPage;

    private GuestInformation guestInformation;

    public SimpleOrderTestCase(final WebDriver webDriver) {
        this.webDriver = webDriver;
        mainPage = new MainPage(webDriver);
        searchResultsPage = new SearchResultsPage(webDriver);
        itemPage = new ItemPage(webDriver);
        cartPage = new CartPage(webDriver);
        checkoutPage = new CheckoutPage(webDriver);
        orderSuccessPage = new OrderSuccessPage(webDriver);
        guestInformation = new GuestInformation(NAME, SURNAME, EMAIL, PHONE, ADDRESS, CITY, POSTAL_CODE, COUNTRY, AREA);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Override
    public void run() {
        navigateTo(APPLICATION_URL);
        mainPage();
        searchFor(ITEM_NAME);
        searchResultsFor(ITEM_NAME);
        clickOnItem(ITEM_NAME);
        detailsFor(ITEM_NAME);
        addQuantity(ITEM_QUANTITY);
        clickAddToCart();
        cartAddSuccess();
        clickCartLink();
        userCart();
        clickCheckout();
        stepOneAccount();
        selectGuestAccount();
        clickContinueOnAccountPanel();
        stepTwoGuestInfo();
        guestInformationForm();
        clickContinueOnGuestInformationPanel();
        stepFourShipping();
        selectFlatShipping();
        clickContinueOnShippingPanel();
        stepFivePayment();
        selectCodPayment();
        checkTermsAndConditions();
        clickContinueOnPaymentPanel();
        stepSixConfirm();
        clickContinueOnConfirmPanel();
        orderSuccessPage();
        clickContinueOnOrderSuccessPage();

        mainPage.verifyPage();
    }

    public void navigateTo(final String url) {
        webDriver.get(url);
    }

    public void mainPage() {
        mainPage.verifyPage();
    }

    public void searchFor(final String item) {
        mainPage.inputSearch(item);
        mainPage.clickSearch();
    }

    public void searchResultsFor(final String item) {
        searchResultsPage.verifyPage();
        searchResultsPage.verifyItem(item);
    }

    public void clickOnItem(final String item) {
        searchResultsPage.clickItem(item);
    }

    public void detailsFor(final String item) {
        itemPage.verifyPage();
        itemPage.verifyItem(item);
    }

    public void addQuantity(final int quantity) {
        itemPage.inputQuantity(quantity);
    }

    public void clickAddToCart() {
        itemPage.clickAddToCart();
    }

    public void cartAddSuccess() {
        itemPage.verifyCart();
    }

    public void clickCartLink() {
        itemPage.clickCartLink();
    }

    public void userCart() {
        cartPage.verifyPage();
    }

    public void clickCheckout() {
        cartPage.clickCheckout();
    }

    public void checkoutPage() {
        checkoutPage.verifyPage();
    }

    public void stepOneAccount() {
        checkoutPage.verifyStepOneAccount();
    }

    public void selectGuestAccount() {
        checkoutPage.selectStepOneGuestAccount();
    }

    public void clickContinueOnAccountPanel() {
        checkoutPage.clickStepOneAccount();
    }

    public void stepTwoGuestInfo() {
        checkoutPage.verifyStepTwoGuest();
    }

    public void guestInformationForm() {
        checkoutPage.inputStepTwoGuestInfo(guestInformation);
    }

    public void clickContinueOnGuestInformationPanel() {
        checkoutPage.clickStepTwoGuest();
    }

    public void stepFourShipping() {
        checkoutPage.verifyStepFourShipping();
    }

    public void selectFlatShipping() {
        checkoutPage.selectStepFourFlatShippingMethod();
    }

    public void clickContinueOnShippingPanel() {
        checkoutPage.clickStepFourShipping();
    }

    public void stepFivePayment() {
        checkoutPage.verifyStepFivePayment();
    }

    public void selectCodPayment() {
        checkoutPage.selectStepFiveStepFivePaymentMethod();
    }

    public void checkTermsAndConditions() {
        checkoutPage.tickStepFiveTermAndConditionsCheckbox();
    }

    public void clickContinueOnPaymentPanel() {
        checkoutPage.clickStepFivePayment();
    }

    public void stepSixConfirm() {
        checkoutPage.verifyStepSixConfirm();
    }

    public void clickContinueOnConfirmPanel() {
        checkoutPage.clickStepSixConfirm();
    }

    public void orderSuccessPage() {
        orderSuccessPage.verifyPage();
    }

    public void clickContinueOnOrderSuccessPage() {
        orderSuccessPage.clickContinue();
    }
}
