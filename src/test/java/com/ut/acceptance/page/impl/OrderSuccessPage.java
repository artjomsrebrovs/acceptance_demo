package com.ut.acceptance.page.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class OrderSuccessPage extends AbstractPage {

    public OrderSuccessPage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void verifyPage() {
        final boolean continueButtonElementDisplayed = webDriver.findElement(By.linkText("Continue")).isDisplayed();
        final String orderSuccessPageHeaderText = webDriver.findElement(By.xpath("//*[@id='content']/h1")).getText();
        final String orderSuccessPageTitleText = webDriver.getTitle();
        assertThat("Order success page title should have a continue button displayed ", continueButtonElementDisplayed, is(true));
        assertThat("Order success page title should contain: Your order has been placed!", orderSuccessPageTitleText, is("Your order has been placed!"));
        assertThat("Order success page header should contain: Your order has been placed!", orderSuccessPageHeaderText, is("Your order has been placed!"));
    }

    public void clickContinue() {
        final WebElement continueButtonElement = webDriver.findElement(By.linkText("Continue"));
        continueButtonElement.click();
    }
}
