package com.cybertek.tests.d14_ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentDemoTest {

    ExtentReports report;
    ExtentHtmlReporter htmlReporter;
    ExtentTest extentLogger;

    @BeforeTest
    public void setup() {
        //initializes the classes
        report = new ExtentReports();

        //System.getProperty("user.dir") --> returns the location/path of my project
        //"/test-output/report.html"--> report will be in test output folder, name

        String path = System.getProperty("user.dir") + "/test-output/report.html";

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to the report object
        report.attachReporter(htmlReporter);

        //set the title of the report
        htmlReporter.config().setReportName("VyTrack smoke tests");

        //set environment information
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("browser", "chrome");
        report.setSystemInfo("executed by", "John B. Goodman");

    }

    @Test
    public void test1(){
        //give name to the current test
        extentLogger = report.createTest("TC001 Login as driver Test");
        //test steps
        extentLogger.info("Open chrome");
        extentLogger.info("go to URL");
        extentLogger.info("enter driver login info");
        extentLogger.info("click submit");
        extentLogger.info("click verify logged in");
        extentLogger.pass("TC001 passed");
    }


    @AfterMethod
    public void close() {
        //this is when the report is actually created
        report.flush();
    }


}
