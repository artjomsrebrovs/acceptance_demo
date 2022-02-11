package com.ut.acceptance.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features", glue = "com.ut.acceptance.cucumber.glue", plugin = {"pretty", "html:target/cucumber.html", "junit:target/cucumber.xml", "json:target/cucumber.json"})
public class SimpleOrderFeatureRunner {
}
