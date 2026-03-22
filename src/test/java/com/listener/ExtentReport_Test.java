package com.listener;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import com.aventstack.extentreports.ExtentTest;
import com.base.Base_Class;



public class ExtentReport_Test extends Base_Class {
	public static ExtentTest extenttest;
	
	@BeforeSuite
	public void extentTestReportStartup() {	
		extentReportStart(null);
	}
	
	@AfterSuite
	public void extentReportEnd() throws IOException {
		extentReportTearsDown(null);

	}

}
