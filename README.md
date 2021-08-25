# JunitExamples

### App Under Test ###

https://www.amsmeteors.org

(2021/07/21)

### Pre-requisites ###

* Im using IJ to create
* Im using GRADLE to build
* You will need to download ChromeDriver from https://chromedriver.chromium.org/downloads
* Update TestCaseBase to point to your ChromeDriver

### Run all Tests

$ java -cp build/libs/junitExamples-all-1.0-SNAPSHOT.jar com.nemesissy.runners.TestRunnerRunlist

### Run a  singe test
$ java -Dtestcase=VerifyHomeLink -cp build/libs/junitExamples-all-1.0-SNAPSHOT.jar com.nemesissy.runners.TestRunnerSingle

### Location of the HTML report
Junit doesn't provide

### Usages
* Page Object Modeling
* Collections
* Waiting on actionalbe elements
* Asserting
* Logging
* Reporting
* Testcase Management Integration
* Test Runners (I know you don't know what these are lol, please ask)
