package com.ut.acceptance.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class WebDriverFactory {

    public static WebDriver CHROME() {
        WebDriverManager.chromiumdriver().setup();
        return new ChromeDriver();
    }

    public static WebDriver FIREFOX() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    public static WebDriver EDGE() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
