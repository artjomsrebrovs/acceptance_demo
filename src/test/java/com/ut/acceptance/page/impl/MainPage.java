package com.ut.acceptance.page.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='search']/input")
    private WebElement searchInputElement;

    @FindBy(xpath = "//*[@id='search']/span/button")
    private WebElement searchButtonElement;

    public MainPage(final WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public void verifyPage() {
        final String mainPageLogoText = webDriver.findElement(By.xpath("//*[@id='logo']/h1/a")).getText();
        final String mainPageTitleText = webDriver.getTitle();
        final boolean searchInputElementDisplayed = searchInputElement.isDisplayed();
        final boolean searchButtonElementDisplayed = searchButtonElement.isDisplayed();
        assertThat("Main page title test should be: Your Store", mainPageTitleText, is("Your Store"));
        assertThat("Main page logo text should be: Your Store", mainPageLogoText, is("Your Store"));
        assertThat("Main page search input element should be displayed", searchInputElementDisplayed, is(true));
        assertThat("Main page search button element should be displayed", searchButtonElementDisplayed, is(true));
    }

    public void inputSearch(final String item) {
        searchInputElement.clear();
        searchInputElement.sendKeys(item);
    }

    public void clickSearch() {
        searchButtonElement.click();
    }
}
