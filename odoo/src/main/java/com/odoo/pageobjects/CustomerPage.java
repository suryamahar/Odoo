package com.odoo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class CustomerPage extends BasePage{
	
	@FindBy(xpath = "//button[@class='btn btn-primary o-kanban-button-new']")
	private WebElement createBtn;
	
	@FindBy(id = "o_field_input_731")
	private WebElement nameTxtBx;
	
	@FindBy(partialLinkText = "Sav")
	private WebElement saveTxtBtn;
	
	public CustomerPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateBtn() {
		return createBtn;
	}
	public WebElement getNameTxtBx() {
		return nameTxtBx;
	}
	public WebElement getSaveTxtBtn() {
		return saveTxtBtn;
}
	public void createCustomer(String CustName) throws InterruptedException {
		createBtn.click();
		Reporter.log("clicked crarrrr", true);
		Thread.sleep(10);
		nameTxtBx.sendKeys(CustName);
		saveTxtBtn.click();
	}
	
}
