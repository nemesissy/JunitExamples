package com.nemesissy.runners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.concurrent.TimeUnit;
/*

Run a single test from the command line
Why would I need this?
You want to regen the logs for a single test that failed

 */
public class TestRunnerSingle {

    final static Logger log = LogManager.getLogger(TestRunnerSingle.class);
    private static String testString = "com.nemesissy.tests.VerifyURL";

    public static void main(String[] args) {

        log.debug("TestRunnerSingle main() start...");

        Class class1 = null;

        try {
            class1 = Class.forName(testString);
        } catch (Exception c) {
            c.printStackTrace();
        }

        Result result = JUnitCore.runClasses(class1);

        String formatted = String.format("%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes(result.getRunTime()),
                TimeUnit.MILLISECONDS.toSeconds(result.getRunTime()) -
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(result.getRunTime()))
        );

        log.debug("Run Duration?            [" + formatted+"]");
        log.debug("Was the run successful?  [" + result.wasSuccessful() + "]");
        log.debug("How many cases were run? [" + result.getRunCount() + "]");
        int total = result.getRunCount() - result.getFailureCount();
        log.debug("How many cases passed?   [" + total + "]");
        log.debug("How many cases failed?   [" + result.getFailureCount() + "]");

        for (Failure failure : result.getFailures()) {
            log.debug("Failure Test Name? ["+failure.getTestHeader()+"]");
            log.debug("Failure Trace?     ["+failure.getTrace()+"]");

        }

        log.debug("TestRunnerSingle main() end.");
    }
}
