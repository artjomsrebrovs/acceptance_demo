package com.ut.acceptance.page.impl;

import com.ut.acceptance.to.GuestInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CheckoutPage extends AbstractPage {

    public CheckoutPage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void verifyPage() {
        final String checkoutTitleText = webDriver.getTitle();
        assertThat("Checkout page title text should contain: Checkout", checkoutTitleText, is("Checkout"));
    }

    public void verifyStepOneAccount() {
        final WebElement stepOneCheckoutElement = webDriver.findElement(By.partialLinkText("Step 1"));
        final String stepOneCheckoutElementAriaExpandedAttr = stepOneCheckoutElement.getAttribute("aria-expanded");
        final boolean guestAccountRadioButtonElementEnabled = webDriver.findElement(By.cssSelector("input[type='radio'][name='account'][value='guest']")).isEnabled();
        final boolean accountButtonElementEnabled = webDriver.findElement(By.id("button-account")).isEnabled();
        assertThat("Checkout page step 1 checkout panel should be expanded", stepOneCheckoutElementAriaExpandedAttr, is("true"));
        assertThat("Checkout page step 1 guest account radio button should be enabled", guestAccountRadioButtonElementEnabled, is(true));
        assertThat("Checkout page step 1 account button should be enabled", accountButtonElementEnabled, is(true));
    }

    public void selectStepOneGuestAccount() {
        final WebElement guestAccountRadioButtonElement = webDriver.findElement(By.cssSelector("input[type='radio'][name='account'][value='guest']"));
        guestAccountRadioButtonElement.click();
    }

    public void clickStepOneAccount() {
        final WebElement accountButtonElement = webDriver.findElement(By.id("button-account"));
        accountButtonElement.click();
    }

    public void verifyStepTwoGuest() {
        final WebElement stepTwoCheckoutElement = webDriver.findElement(By.partialLinkText("Step 2"));
        final String stepTwoCheckoutElementAriaExpandedAttr = stepTwoCheckoutElement.getAttribute("aria-expanded");
        final boolean buttonGuestElementEnabled = webDriver.findElement(By.id("button-guest")).isEnabled();
        assertThat("Checkout page step 2 checkout panel should be expanded", stepTwoCheckoutElementAriaExpandedAttr, is("true"));
        assertThat("Checkout page step 2 guest button should be enabled", buttonGuestElementEnabled, is(true));
    }

    public void inputStepTwoGuestInfo(final GuestInformation guestInformation) {
        webDriver.findElement(By.id("input-payment-firstname")).sendKeys(guestInformation.getName());
        webDriver.findElement(By.id("input-payment-lastname")).sendKeys(guestInformation.getSurname());
        webDriver.findElement(By.id("input-payment-email")).sendKeys(guestInformation.getEmail());
        webDriver.findElement(By.id("input-payment-telephone")).sendKeys(guestInformation.getPhone());
        webDriver.findElement(By.id("input-payment-address-1")).sendKeys(guestInformation.getAddress());
        webDriver.findElement(By.id("input-payment-city")).sendKeys(guestInformation.getCity());
        webDriver.findElement(By.id("input-payment-postcode")).sendKeys(guestInformation.getPostCode());
        new Select(webDriver.findElement(By.id("input-payment-country"))).selectByVisibleText(guestInformation.getCountry());
        new Select(webDriver.findElement(By.id("input-payment-zone"))).selectByVisibleText(guestInformation.getArea());

    }

    public void clickStepTwoGuest() {
        final WebElement guestButtonElement = webDriver.findElement(By.id("button-guest"));
        guestButtonElement.click();
    }

    public void verifyStepFourShipping() {
        final WebElement stepFourCheckoutElement = webDriver.findElement(By.partialLinkText("Step 4"));
        final String stepFourCheckoutElementAriaExpandedAttr = stepFourCheckoutElement.getAttribute("aria-expanded");
        final boolean shippingRadioButtonElementEnabled = webDriver.findElement(By.cssSelector("input[type='radio'][name='shipping_method'][value='flat.flat']")).isEnabled();
        final boolean shippingMethodButtonElementEnabled = webDriver.findElement(By.id("button-shipping-method")).isEnabled();
        assertThat("Checkout page step 4 checkout panel should be expanded", stepFourCheckoutElementAriaExpandedAttr, is("true"));
        assertThat("Checkout page step 4 shipping method radio button should be enabled", shippingRadioButtonElementEnabled, is(true));
        assertThat("Checkout page step 4 shipping button should be enabled", shippingMethodButtonElementEnabled, is(true));
    }

    public void selectStepFourFlatShippingMethod() {
        final WebElement shippingRadioButtonElement = webDriver.findElement(By.cssSelector("input[type='radio'][name='shipping_method'][value='flat.flat']"));
        shippingRadioButtonElement.click();
    }

    public void clickStepFourShipping() {
        final WebElement shippingMethodButtonElement = webDriver.findElement(By.id("button-shipping-method"));
        shippingMethodButtonElement.click();
    }

    public void verifyStepFivePayment() {
        final WebElement stepFiveCheckoutElement = webDriver.findElement(By.partialLinkText("Step 5"));
        final String stepFiveCheckoutElementAriaExpandedAttr = stepFiveCheckoutElement.getAttribute("aria-expanded");
        final boolean paymentMethodButtonEnabled = webDriver.findElement(By.id("button-payment-method")).isEnabled();
        final boolean paymentRadioButtonElementEnabled = webDriver.findElement(By.cssSelector("input[type='radio'][name='payment_method'][value='cod']")).isEnabled();
        final boolean termAndConditionsCheckboxElementEnabled = webDriver.findElement(By.cssSelector("input[type='checkbox'][name='agree']")).isEnabled();
        assertThat("Checkout page step 5 checkout panel should be expanded", stepFiveCheckoutElementAriaExpandedAttr, is("true"));
        assertThat("Checkout page step 5 payment button should be enabled", paymentMethodButtonEnabled, is(true));
        assertThat("Checkout page step 5 payment method radio button should be enabled", paymentRadioButtonElementEnabled, is(true));
        assertThat("Checkout page step 5 term and conditions checkbox should be enabled", termAndConditionsCheckboxElementEnabled, is(true));
    }

    public void selectStepFiveStepFivePaymentMethod() {
        final WebElement paymentRadioButtonElement = webDriver.findElement(By.cssSelector("input[type='radio'][name='payment_method'][value='cod']"));
        paymentRadioButtonElement.click();
    }

    public void tickStepFiveTermAndConditionsCheckbox() {
        final WebElement termAnsConditionsCheckboxElement = webDriver.findElement(By.cssSelector("input[type='checkbox'][name='agree']"));
        if (!termAnsConditionsCheckboxElement.isSelected()) {
            termAnsConditionsCheckboxElement.click();
        }
    }

    public void clickStepFivePayment() {
        final WebElement paymentMethodButton = webDriver.findElement(By.id("button-payment-method"));
        paymentMethodButton.click();
    }

    public void verifyStepSixConfirm() {
        final WebElement stepSixCheckoutElement = webDriver.findElement(By.partialLinkText("Step 6"));
        final String stepSixCheckoutElementAriaExpandedAttr = stepSixCheckoutElement.getAttribute("aria-expanded");
        final boolean confirmButtonElementEnabled = webDriver.findElement(By.id("button-confirm")).isEnabled();
        assertThat("Checkout page step 6 checkout panel should be expanded", stepSixCheckoutElementAriaExpandedAttr, is("true"));
        assertThat("Checkout page step 6 confirm button should be enabled", confirmButtonElementEnabled, is(true));
    }

    public void clickStepSixConfirm() {
        final WebElement confirmButtonElement = webDriver.findElement(By.id("button-confirm"));
        confirmButtonElement.click();
    }
}
