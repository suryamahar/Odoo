package com.odoo.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	
	
	public static WebDriver launchBrowser(String browser) {
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")) {
			String key="webdriver.chrome.driver";
			String value="./exefiles/chromedriver.exe";
			
			System.setProperty(key, value);
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			String key="webdriver.chrome.driver";
			String value="./exefiles/chromedriver.exe";
			
			System.setProperty(key, value);
			driver=new ChromeDriver();
		}
		return driver;
	}

}
