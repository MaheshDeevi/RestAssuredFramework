package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.constants.FrameworkConstants;

public final class ExtentReport {

    private ExtentReport(){}
    private static final ExtentReports extent = new ExtentReports();
    private static ExtentTest test;




    public static void initReports(){
        ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFolderPath());
        extent.attachReporter(spark);
    }

    public static void tearDownReports(){
        extent.flush();
    }

    public static void createTest(String name) {
        test = extent.createTest(name);
        ExtentManager.setTest(test);
    }

    public static void addAuthor(String[] authors) {
        for (String author : authors) {
            ExtentManager.getTest().assignAuthor(author);
        }
    }

    public static void addCategory(String[] categories) {
        for (String category : categories) {
            ExtentManager.getTest().assignAuthor(category);
        }
    }


    }

