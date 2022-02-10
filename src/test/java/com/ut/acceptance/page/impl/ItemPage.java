package com.ut.acceptance.page.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ItemPage extends AbstractPage {

    public ItemPage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void verifyPage() {
        final String itemDescriptionTabText = webDriver.findElement(By.linkText("Description")).getText();
        final String itemReviewsTabText = webDriver.findElement(By.partialLinkText("Reviews")).getText();
        final boolean cartButtonElementDisplayed = webDriver.findElement(By.id("button-cart")).isDisplayed();
        final boolean itemQuantityInputElementDisplayed = webDriver.findElement(By.id("input-quantity")).isDisplayed();
        assertThat("Item page should contain description tab", itemDescriptionTabText, is("Description"));
        assertThat("Item page should contain reviews tab", itemReviewsTabText, containsString("Reviews"));
        assertThat("Item page cart button element should be displayed", cartButtonElementDisplayed, is(true));
        assertThat("Item page item quantity input element should be displayed", itemQuantityInputElementDisplayed, is(true));
    }

    public void verifyItem(final String item) {
        final String selectedItemPageTitleText = webDriver.getTitle();
        final String itemDescriptionText = webDriver.findElement(By.className("intro")).getText();
        assertThat("Item page title text should contain searched item", selectedItemPageTitleText, is(item));
        assertThat("Item page should contain description tab", itemDescriptionText, containsString(item));
    }

    public void inputQuantity(final int quantity) {
        final WebElement itemQuantityInputElement = webDriver.findElement(By.id("input-quantity"));
        itemQuantityInputElement.clear();
        itemQuantityInputElement.sendKeys(String.valueOf(quantity));
    }

    public void clickAddToCart() {
        final WebElement cartButtonElement = webDriver.findElement(By.id("button-cart"));
        cartButtonElement.click();
    }

    public void verifyCart() {
        final String successAlertText = webDriver.findElement(By.className("alert-success")).getText();
        assertThat("Success alert text should contain: Success: You have added", successAlertText, containsString("Success: You have added"));
    }

    public void clickCartLink() {
        final WebElement shoppingCartLinkElement = webDriver.findElement(By.className("alert-success")).findElement(By.linkText("shopping cart"));
        shoppingCartLinkElement.click();
    }
}
