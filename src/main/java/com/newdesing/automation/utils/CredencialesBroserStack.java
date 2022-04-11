package com.newdesing.automation.utils;

public class CredencialesBroserStack {
    public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    public static final String URL_BROWSERSTACK = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
}
