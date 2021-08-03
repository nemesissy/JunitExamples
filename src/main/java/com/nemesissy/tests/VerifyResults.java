package com.nemesissy.tests;

import com.nemesissy.pages.Article;
import com.nemesissy.pages.Home;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class VerifyResults extends TestCaseBase {

    final static Logger log = LogManager.getLogger(VerifyResults.class);

    @Test
    public void testVerifyArticle() {

        log.debug("testVerifyArticle() Start.");

        Home home = new Home(driver);
        home.searchForSomething("fireball");
        home.selectArticle(0);

        Article a = new Article(driver);

        assertTrue("Failed - article has incorrect date.", a.getCalendarText().contains("MAR\n22\n2021"));
        assertTrue("Failed - article has incorrect author.", a.getAuthor().contains("Vincent Perlerin"));

        log.info("testVerifyArticle() passed.");
        log.debug("testVerifyArticle() End.");

    }
}
