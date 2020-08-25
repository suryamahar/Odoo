package com.odoo.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseLib {
	
	public WebDriver driver;
	@BeforeMethod
	@Parameters({"baseurl","browserName"})
	public void preCondition(String url, String browser) {
		
		driver= BrowserFactory.launchBrowser(browser);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("Browser Launched", true);
	}

	@AfterMethod
	public void postCondition() {
		driver.close();
	}
}
