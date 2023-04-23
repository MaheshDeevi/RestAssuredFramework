package com.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

    private ExtentManager(){}

    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

     static ExtentTest getTest() {
        return extentTest.get();
    }

     static void setTest(ExtentTest test) {
        extentTest.set(test);
    }
}
