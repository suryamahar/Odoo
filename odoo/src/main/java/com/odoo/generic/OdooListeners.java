package com.odoo.generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class OdooListeners implements ITestListener {
	
	int testPassed, testSkipped, testFailed, totalTest=0;

	public void onTestStart(ITestResult result) {
		
		Reporter.log(result.getName()+"Test execution started at"+new Date(), true);
		totalTest++;
		
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName()+"Test execution passed", true);
		testPassed++;
	}

	public void onTestFailure(ITestResult result) {
		Reporter.log(result.getName()+"Test execution failed", true);
		TakesScreenshot ts= (TakesScreenshot) new BaseLib().driver;
		
		File src= ts.getScreenshotAs(OutputType.FILE);
		
		File dest= new File("./Screenshots"+result.getName()+".png");
		
		try {
			Files.copy(src, dest);
			
			Reporter.log("Screenshot Taken", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		testFailed++;
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getName()+"Test Skipped", true);
		testSkipped++;
		
	}

	public void onStart(ITestContext context) {
		Reporter.log("Suite execution started at"+ new Date(), true);

	}

	public void onFinish(ITestContext context) {
		Reporter.log("Suite execution Finished at"+ new Date(), true);
		
		Reporter.log("Total test executed "+ totalTest, true);
		Reporter.log("Total test passed "+ testPassed, true);
		Reporter.log("Total test failed "+ testFailed, true);
		Reporter.log("Total test skipped "+ testSkipped, true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}


}
