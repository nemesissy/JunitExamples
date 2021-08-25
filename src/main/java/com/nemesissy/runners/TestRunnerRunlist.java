package com.nemesissy.runners;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import java.util.concurrent.TimeUnit;
/*

Run a list of test cases from the command line
Why would I need this?
You want to execute a run list you have created in your test case management system

Note: I don't gave an actual TestRail server to hit. Commented code to make the API calls and
building the string manually for demo purposes.

 */
public class TestRunnerRunlist {

    final static Logger log = LogManager.getLogger(TestRunnerRunlist.class);
    private static final String packageString = "com.nemesissy.tests";
    private static String runId= "1008";
    private static long totalDuration = 0l;

    public static void main(String[] args) {

        int testsRun = 0;
        int testsFailed = 0;

        log.debug("TestRunnerRunlist main() start...");

/*
Get all test cases from the runlist on the test case mgt server
if we had a test case management server
 */
//        List<String> testList = new ArrayList<String>();
//        JSONArray json = null;
//        try {
//            json = (JSONArray) client.sendGet("get_tests/" + runID);
//
//        } catch (APIException c) {
//            c.printStackTrace();
//
//        } catch (Exception c) {
//            c.printStackTrace();
//
//        }

        List<String> testLibrary = new FastClasspathScanner(packageString).scan().getNamesOfAllClasses();
        List<Class> classes = new ArrayList<Class>();
        for (String tc : testLibrary) {
            classes.add(getClassFromString(tc, testLibrary));
        }

        for (Class testcase : classes) {

            log.debug("Running test ["+testcase.getName()+"].");

            Result result = JUnitCore.runClasses(testcase);
            log.debug("Test result <<<<<<<<<<<<<<<< >>>>>>>>>>>>>>>");
            log.debug("Test result [" + result.wasSuccessful() + "]");
            log.debug("Test result <<<<<<<<<<<<<<<< >>>>>>>>>>>>>>>");
            if (result.getFailureCount() > 0) {
                /*
                This is where we report the result to the test case management system
                 */
                totalDuration += result.getRunTime();
                testsFailed ++;
            } else {
                totalDuration += result.getRunTime();
            }

        }
        testsRun ++;

        log.debug("Total run duration?      [" + formattedDuration(totalDuration) + "]");
        log.debug("How many cases were run? [" + testsRun + "]");
        log.debug("How many cases failed?   [" + testsFailed + "]");

        log.debug("TestRunnerRunlist main() end.");
    }

    public static Class getClassFromString (String caseId, List<String> classList) {

        Class clazz = null;
        String className = "";

        for (String cn : classList) {
            if (cn.contains(caseId)) {
                className = cn;
                break;
            }
        }

        try {
            clazz = Class.forName(className);

        } catch (Exception c) {
            //c.printStackTrace();
            log.error("Could not find a java class that matches ["+className+"]. This test won't be run.");
        }

        return clazz;
    }

    public static String formattedDuration (Long milli) {

        String formatted = String.format("%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes(milli),
                TimeUnit.MILLISECONDS.toSeconds(milli) -
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milli))
        );

        return formatted;
    }
}
