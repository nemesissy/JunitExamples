package com.nemesissy.tests;

import com.nemesissy.pages.Article;
import com.nemesissy.pages.Home;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

public class VerifySearch extends TestCaseBase {

    final static Logger log = LogManager.getLogger(VerifySearch.class);

    @Test
    public void testSearchForFireBalls() {

        log.debug("testSearchForFireBalls() Start.");

        Home home = new Home(driver);
        home.searchForSomething("fireball");

        log.debug(home.getArticleCount());

        assertTrue("Failed - expecting 470 articles", home.getArticleCount() == 21);
        log.info("testSearchForFireBalls() passed.");

        log.debug("testSearchForFireBalls() End.");

    }
}
