package com.odoo.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PipelinePage {

	@FindBy(xpath = "//button[@class='btn btn-primary o-kanban-button-new']")
	private WebElement createBtn;
	
	@FindBy(xpath = "//button[@class='btn btn-secondary o_button_import']")
	private WebElement ImportBtn;
	
	@FindBy(name = "name")
	private WebElement nameTxtBx;
	
	@FindBy(xpath = "(//input[@class='o_input ui-autocomplete-input'])[1]")
	private WebElement custTxtBx;
	
	@FindBy(id = "o_field_input_593")
	private WebElement ExpTxtBx;
	
	@FindBy(xpath = "(//button[text()='Add'])[1]")
	private WebElement AddBtn;
	
	public PipelinePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateBtn() {
		return createBtn;
	}
	public WebElement getImportBtn() {
		return ImportBtn;
	}
	public WebElement getNameTxtBx() {
		return nameTxtBx;
	}
	public WebElement getCustTxtBx() {
		return custTxtBx;
	}
	public WebElement getExpTxtBx() {
		return ExpTxtBx;
	}
	public WebElement getAddBtn() {
		return AddBtn;
	}
	
	public void create(String name, String customer, String revenue) {
		nameTxtBx.sendKeys(name);
		//Select sl= new Select(custTxtBx);
		custTxtBx.sendKeys(customer,Keys.ENTER);
		
		ExpTxtBx.sendKeys(revenue);
		AddBtn.click();
		
	}
	
	
}
