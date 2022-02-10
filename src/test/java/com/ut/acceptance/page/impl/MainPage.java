package com.ut.acceptance.page.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MainPage extends AbstractPage {

    public MainPage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void verifyPage() {
        final String mainPageLogoText = webDriver.findElement(By.xpath("//*[@id='logo']/h1/a")).getText();
        final String mainPageTitleText = webDriver.getTitle();
        final boolean searchInputElementDisplayed = webDriver.findElement(By.xpath("//*[@id='search']/input")).isDisplayed();
        final boolean searchButtonElementDisplayed = webDriver.findElement(By.xpath("//*[@id='search']/span/button")).isDisplayed();
        assertThat("Main page title test should be: Your Store", mainPageTitleText, is("Your Store"));
        assertThat("Main page logo text should be: Your Store", mainPageLogoText, is("Your Store"));
        assertThat("Main page search input element should be displayed", searchInputElementDisplayed, is(true));
        assertThat("Main page search button element should be displayed", searchButtonElementDisplayed, is(true));
    }

    public void inputSearch(final String item) {
        final WebElement searchInputElement = webDriver.findElement(By.xpath("//*[@id='search']/input"));
        searchInputElement.clear();
        searchInputElement.sendKeys(item);
    }

    public void clickSearch() {
        final WebElement searchButtonElement = webDriver.findElement(By.xpath("//*[@id='search']/span/button"));
        searchButtonElement.click();
    }
}
