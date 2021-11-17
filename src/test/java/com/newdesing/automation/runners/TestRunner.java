package com.newdesing.automation.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/Test.feature",
        glue="com.newdesing.automation.stepdefinitions",
        snippets=SnippetType.CAMELCASE)
public class TestRunner {

}
