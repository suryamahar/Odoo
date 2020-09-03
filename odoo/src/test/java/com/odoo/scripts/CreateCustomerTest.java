package com.odoo.scripts;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.odoo.generic.BaseLib;
import com.odoo.generic.ExcelLib;
import com.odoo.pageobjects.CustomerPage;
import com.odoo.pageobjects.DashBoardPage;
import com.odoo.pageobjects.LoginPage;

public class CreateCustomerTest extends BaseLib{
	
	@Test
	public void createCustomer() throws InterruptedException {
		ExcelLib el= new ExcelLib("./testdata/testdata.xlsx");
		String username= el.readData("sheet1", 1, 1);
		String password= el.readData("sheet1", 1, 2);
		String name=el.readData("sheet1", 2, 3);
		LoginPage lp= new LoginPage(driver);
		lp.login(username, password);
		
		Reporter.log("logged in", true);
		
		DashBoardPage dp= new DashBoardPage(driver);
		dp.getCrmBtn().click();
		
		CustomerPage cp= new CustomerPage(driver);
		cp.getSalesBtn().click();
		
		driver.findElement(By.xpath("//span[text()='Customers']")).click();
		
		
		Reporter.log(name+"clic", true);
		CustomerPage cp1= new CustomerPage(driver);
		cp1.createCustomer(name);
		

		
		
	}
}
