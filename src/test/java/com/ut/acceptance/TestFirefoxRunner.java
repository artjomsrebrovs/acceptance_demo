package com.ut.acceptance;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestFirefoxRunner {

    private WebDriver webDriver;

    @BeforeClass
    public static void init() {
        WebDriverManager.chromiumdriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.edgedriver().setup();
    }

    @Before
    public void setup() {
        webDriver = new ChromeDriver();
        //webDriver = new FirefoxDriver();
        //webDriver = new EdgeDriver();
    }

    @Test
    public void login() {
        webDriver.get("https://opencart.abstracta.us/");

        final String pageLogoText = webDriver.findElement(By.xpath("//*[@id='logo']/h1/a")).getText();
        final String mainPageTitleText = webDriver.getTitle();
        assertThat("Main page logo text should be: Your Store", pageLogoText, is("Your Store"));
        assertThat("Main page title test should be: Your Store", mainPageTitleText, is("Your Store"));

        webDriver.findElement(By.xpath("//*[@id='search']/input")).sendKeys("iphone");
        webDriver.findElement(By.xpath("//*[@id='search']/span/button")).click();

        final String searchResultPageTitleText = webDriver.getTitle();
        final String searchContentText = webDriver.findElement(By.xpath("//*[@id='content']/h1")).getText();
        final String searchResultItemNameText = webDriver.findElement(By.linkText("iPhone")).getText();
        final String searchResultItemPriceText = webDriver.findElement(By.className("price")).getText();
        final String searchResultItemPriceTaxText = webDriver.findElement(By.className("price-tax")).getText();
        assertThat("Search results page title text should contain searched item", searchResultPageTitleText, is("Search - iphone"));
        assertThat("Search results page should contain searched item", searchContentText, is("Search - iphone"));
        assertThat("Search results page should contain found item name", searchResultItemNameText, is("iPhone"));
        assertThat("Search results page should contain found item price", searchResultItemPriceText, containsString("123.20"));
        assertThat("Search results page should contain found item price tax", searchResultItemPriceTaxText, containsString("101.00"));

        webDriver.findElement(By.linkText("iPhone")).click();

        final String selectedItemPageTitleText = webDriver.getTitle();
        final String itemDescriptionTabText = webDriver.findElement(By.linkText("Description")).getText();
        final String itemReviewsTabText = webDriver.findElement(By.partialLinkText("Reviews")).getText();
        final String itemDescriptionText = webDriver.findElement(By.className("intro")).getText();
        assertThat("Item page title text should contain searched item", selectedItemPageTitleText, is("iPhone"));
        assertThat("Item page should contain description tab", itemDescriptionTabText, is("Description"));
        assertThat("Item page should contain reviews tab", itemReviewsTabText, containsString("Reviews"));
        assertThat("Item page should contain description tab", itemDescriptionText, containsString("iPhone is a revolutionary"));

        webDriver.findElement(By.id("input-quantity")).sendKeys("2");
        webDriver.findElement(By.id("button-cart")).click();

        try {
            synchronized (webDriver) {
                webDriver.wait(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final String successAlertText = webDriver.findElement(By.className("alert-success")).getText();
        assertThat("Success alert text should contain: Success: You have added", successAlertText, containsString("Success: You have added"));

        webDriver.findElement(By.className("alert-success")).findElement(By.linkText("shopping cart")).click();


    }

    @After
    public void tear() {
        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
        }
    }
}
