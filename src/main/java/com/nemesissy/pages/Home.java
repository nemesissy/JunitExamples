package com.nemesissy.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import org.openqa.selenium.By;

public class    Home {

    private static final Logger log = LogManager.getLogger("Home");
    private WebDriver driver = null;

    //
    // Header
    @FindBy(css = "div[id='logo'] > a")
    private WebElement headerLink;

    //
    // Menu buttons
    @FindBy(css = "li[id='menu-item-5391'] > a")
    private WebElement homeButton;
    @FindBy(css = "li[id='menu-item-5392'] > a")
    private WebElement newsButton;
    @FindBy(css = "li[id='menu-item-5445'] > a")
    private WebElement calendarButton;

    // Search and results
    @FindBy(css = "input[id='search-input']")
    private WebElement searchInput;
//    @FindBy(css = "form[class='form-inline'] > button[type='submit']")
//    private WebElement searchButton;
//    Enter search criteria and hit enter
    @FindBy(css = "article")
    private List<WebElement> articles;

    @FindBy(css = "div[id='header-top-right'] > a:nth-child(1)")
    private WebElement fbButton;
    @FindBy(css = "div[id='header-top-right'] > a:nth-child(2)")
    private WebElement twitterButton;
    @FindBy(css = "div[id='header-top-right'] > a:nth-child(3)")
    private WebElement xmlMapButton;

    public Home(WebDriver d) {
        driver = d;
        log.debug("Initializing the Home Page");
        PageFactory.initElements(driver, this);
        /*
        Wait for the homeButton to be clickable for continuing
         */
        WebElement e = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(homeButton));

    }

    public void clickHomeLink() {
        log.debug("clickHomeLink().");
        homeButton.click();
    }

    public void searchForSomething(String something) {
        log.debug("searchForSomething() Search for ["+something+"].");
        searchInput.click();
        searchInput.sendKeys(something);
//        searchButton.click();
        searchInput.sendKeys(Keys.RETURN);
    }

    public void selectArticle(int index) {
        log.debug("selectArticle() Select article number ["+index+"].");
        articles.get(index).click();
    }

    public int getArticleCount() {
        log.debug("getArticleCount().");
        return articles.size();
    }

}
