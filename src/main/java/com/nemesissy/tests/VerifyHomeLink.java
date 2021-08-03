package com.nemesissy.tests;

import com.nemesissy.pages.Home;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class VerifyHomeLink extends TestCaseBase {

    final static Logger log = LogManager.getLogger(VerifyHomeLink.class);

    @Test
    public void testVerifyHomeLink() {

        log.debug("testVerifyHomeLink() Start.");

        Home home = new Home(driver);
        home.clickHomeLink();
        log.info("testVerifyHomeLink() passed.");

        log.debug("verifyURL() End.");

    }
}
