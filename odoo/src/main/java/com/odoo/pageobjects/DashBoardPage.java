package com.odoo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
	
	@FindBy(xpath = "//div[text()='CRM']")
	private WebElement crmBtn;
	
	public DashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCrmBtn() {
		return crmBtn;
	}

}
