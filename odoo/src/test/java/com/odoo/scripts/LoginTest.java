package com.odoo.scripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.odoo.generic.BaseLib;
import com.odoo.generic.ExcelLib;
import com.odoo.pageobjects.LoginPage;

public class LoginTest extends BaseLib{
	
	@Test(priority = 1,groups = {"smoke"} )
	public void validLogin() {
		ExcelLib el =new ExcelLib("./testdata/testdata.xlsx");
		String username= el.readData("sheet1", 1, 1);
		String password=el.readData("sheet1", 1, 2);
		
		LoginPage lp= new LoginPage(driver);
		lp.login(username, password);
		Reporter.log("Successfully logged in", true);
		
	}
	@Test(priority= 2,groups= { "functional"})
	public void invalidLogin() {
		ExcelLib el =new ExcelLib("./testdata/testdata.xlsx");
		String username= el.readData("sheet1", 1, 1);
		String password=el.readData("sheet1", 1, 1);
		LoginPage lp= new LoginPage(driver);
		lp.login(username, password);
		
		String msg= driver.findElement(By.xpath("//p[@class='alert alert-danger']")).getText();
		String act= "Wrong login/password";
		
		Assert.assertEquals(msg, act);
		Reporter.log(act, true);
	}

}
