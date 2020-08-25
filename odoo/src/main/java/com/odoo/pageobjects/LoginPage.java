package com.odoo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id = "login")
	private WebElement emailTxtBx;
	
	@FindBy(id = "password")
	private WebElement passTxtBx;
	
	@FindBy(className = "btn btn-primary btn-block")
	public WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getEmailTxtBx() {
		return emailTxtBx;
	}
	public WebElement getPassTxtBx() {
		return passTxtBx;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void login(String email, String password) {
		emailTxtBx.sendKeys(email);
		passTxtBx.sendKeys(password);
		loginBtn.click();
	}

}
