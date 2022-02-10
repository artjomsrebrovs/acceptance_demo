package com.ut.acceptance.page.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SearchResultsPage extends AbstractPage {

    public SearchResultsPage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void verifyPage() {
        final String searchResultPageTitleText = webDriver.getTitle();
        final String searchContentText = webDriver.findElement(By.xpath("//*[@id='content']/h1")).getText();
        assertThat("Search results page title text should contain searched item", searchResultPageTitleText, containsString("Search - "));
        assertThat("Search results page should contain searched item", searchContentText, containsString("Search - "));
    }

    public void verifyItem(final String item) {
        final String searchResultItemNameText = webDriver.findElement(By.linkText(item)).getText();
        final String searchResultItemPriceText = webDriver.findElement(By.className("price")).getText();
        final String searchResultItemPriceTaxText = webDriver.findElement(By.className("price-tax")).getText();
        final boolean itemLinkElementDisplayed = webDriver.findElement(By.linkText(item)).isDisplayed();
        assertThat("Search results page should contain found item name", searchResultItemNameText, is(item));
        assertThat("Search results page should contain found item price", searchResultItemPriceText, containsString("123.20"));
        assertThat("Search results page should contain found item price tax", searchResultItemPriceTaxText, containsString("101.00"));
        assertThat("Search results page item link should be visible", itemLinkElementDisplayed, is(true));
    }

    public void clickItem(final String item) {
        final WebElement itemLinkElement = webDriver.findElement(By.linkText(item));
        itemLinkElement.click();
    }
}
