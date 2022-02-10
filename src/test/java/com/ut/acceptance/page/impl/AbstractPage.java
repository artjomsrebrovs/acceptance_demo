package com.ut.acceptance.page.impl;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected final WebDriver webDriver;

    public AbstractPage(final WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public abstract void verifyPage();

}
