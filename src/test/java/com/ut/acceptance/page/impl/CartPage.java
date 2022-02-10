package com.ut.acceptance.page.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CartPage extends AbstractPage {

    public CartPage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void verifyPage() {
        final boolean checkoutButtonDisplayed = webDriver.findElement(By.linkText("Checkout")).isDisplayed();
        final String cartPageTitleText = webDriver.getTitle();
        final String cartPageHeaderText = webDriver.findElement(By.xpath("//*[@id='content']/h2")).getText();
        assertThat("Cart page checkout button should be displayed", checkoutButtonDisplayed, is(true));
        assertThat("Cart page title text should contain: Shopping Cart", cartPageTitleText, is("Shopping Cart"));
        assertThat("Cart page title text should contain: What would you like to do next?", cartPageHeaderText, is("What would you like to do next?"));
    }

    public void clickCheckout() {
        final WebElement checkoutButtonCheckout = webDriver.findElement(By.linkText("Checkout"));
        checkoutButtonCheckout.click();
    }
}
