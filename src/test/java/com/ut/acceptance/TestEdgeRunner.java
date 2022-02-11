package com.ut.acceptance;

import com.ut.acceptance.factory.WebDriverFactory;
import com.ut.acceptance.impl.SimpleOrderTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestEdgeRunner {

    private WebDriver webDriver;
    private SimpleOrderTestCase testCase;

    @Before
    public void setup() {
        webDriver = WebDriverFactory.EDGE();
        testCase = new SimpleOrderTestCase(webDriver);
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
        }
    }

    @Test
    public void testSimpleOrderPlacement() {
        testCase.run();
    }
}
