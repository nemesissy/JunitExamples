package com.nemesissy.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Article {

    private static final Logger log = LogManager.getLogger("Home");
    private WebDriver driver = null;

    //
    // Header
    By calenderWidget = By.cssSelector("article > div > div > time");
    @FindBy(css = "article > div > div > time")
    private WebElement calendar;
    @FindBy(css = "a[rel='author']")
    private WebElement author;

    public Article(WebDriver d) {
        driver = d;
        log.debug("Initializing the rticle Page");
        PageFactory.initElements(driver, this);
        /*
        Wait for the calendar widget to be present for continuing
         */
        WebElement e = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(calenderWidget));

    }

    public String getCalendarText() {
        log.debug("getCalendarText().");
        return calendar.getText();
    }

    public String getAuthor() {
        log.debug("getAuthor().");
        return author.getText();
    }
}
