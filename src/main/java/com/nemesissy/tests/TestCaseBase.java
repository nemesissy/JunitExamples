package com.nemesissy.tests;

import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class TestCaseBase extends TestCase {

    WebDriver driver = null;
    final static Logger log = LogManager.getLogger(TestCaseBase.class);
    private String chromeDriverMACLocation = "/Users/nemesissy/chromedriver/chromedriver";
    private String chromeDriverWINLocation = "C:\\Users\\nemesissy\\chromedriver\\chromedriver.exe";

    public void setUp() {
        log.debug("setup() >>> Setup Start for [" + this.toString() + "]");
        this.chromeDriverstart();
        log.debug("setup() >>> Setup End for [" + this.toString() + "]");

    }

    public void tearDown() {
        log.debug("setup() >>> Teardown Start for [" + this.toString() + "]");
        driver.quit();
        log.debug("setup() >>> Teardown End for [" + this.toString() + "]");
    }

    public void chromeDriverstart() {
        log.debug("chromeDriverstart() start.");

        String os = "mac";
        if (os.contains("win")) {
            System.setProperty("webdriver.chrome.driver", chromeDriverWINLocation);
        } else {
            System.setProperty("webdriver.chrome.driver", chromeDriverMACLocation);
        }

        driver = new ChromeDriver();
        driver.get("https://www.amsmeteors.org/");

        log.debug("chromeDriverstart() end.");

    }
}
