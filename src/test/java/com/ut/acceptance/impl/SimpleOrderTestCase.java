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
        openMainPage();
        searchFor(ITEM_NAME);
        searchResultsFor(ITEM_NAME);

        searchResultsPage.clickItem(ITEM_NAME);

        itemPage.verifyPage();
        itemPage.verifyItem(ITEM_NAME);

        itemPage.inputQuantity(ITEM_QUANTITY);
        itemPage.clickAddToCart();
        itemPage.verifyCart();
        itemPage.clickCartLink();

        cartPage.verifyPage();
        cartPage.clickCheckout();

        checkoutPage.verifyPage();
        checkoutPage.verifyStepOneAccount();
        checkoutPage.selectStepOneGuestAccount();
        checkoutPage.clickStepOneAccount();

        checkoutPage.verifyStepTwoGuest();
        checkoutPage.inputStepTwoGuestInfo(guestInformation);
        checkoutPage.clickStepTwoGuest();

        checkoutPage.verifyStepFourShipping();
        checkoutPage.selectStepFourFlatShippingMethod();
        checkoutPage.clickStepFourShipping();

        checkoutPage.verifyStepFivePayment();
        checkoutPage.selectStepFiveStepFivePaymentMethod();
        checkoutPage.tickStepFiveTermAndConditionsCheckbox();
        checkoutPage.clickStepFivePayment();

        checkoutPage.verifyStepSixConfirm();
        checkoutPage.clickStepSixConfirm();

        orderSuccessPage.verifyPage();
        orderSuccessPage.clickContinue();

        mainPage.verifyPage();
    }

    public void openMainPage() {
        webDriver.get(APPLICATION_URL);
    }

    public void searchFor(final String item) {
        mainPage.verifyPage();
        mainPage.inputSearch(item);
        mainPage.clickSearch();
    }

    public void searchResultsFor(final String item) {
        searchResultsPage.verifyPage();
        searchResultsPage.verifyItem(ITEM_NAME);
    }
}
