package com.odoo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
	
	@FindBy(linkText = "CRM")
	private WebElement crmBtn;
	@FindBy(linkText = "Sales")
	private WebElement salesBtn;
	@FindBy(linkText = "Leads")
	private WebElement leadsBtn;
	@FindBy(linkText = "Reporting")
	private WebElement reportingBtn;
	@FindBy(linkText = "Configuration")
	private WebElement configurationBtn;
	
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCrmBtn() {
		return crmBtn;
	}
	public WebElement getSalesBtn() {
		return salesBtn;
	}
	public WebElement getLeadsBtn() {
		return leadsBtn;
	}
	public WebElement getReportingBtn() {
		return reportingBtn;
	}
	public WebElement getConfigurationBtn() {
		return configurationBtn;
	}
}
