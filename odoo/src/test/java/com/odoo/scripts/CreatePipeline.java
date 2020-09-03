package com.odoo.scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.odoo.generic.BaseLib;
import com.odoo.generic.ExcelLib;
import com.odoo.pageobjects.DashBoardPage;
import com.odoo.pageobjects.LoginPage;
import com.odoo.pageobjects.PipelinePage;

public class CreatePipeline extends BaseLib{
	
	@Test
	public void createPipeline() {
		ExcelLib el= new ExcelLib("./testdata/testdata.xlsx");
		String username= el.readData("sheet1", 1, 1);
		String password= el.readData("sheet1", 1, 2);
		String name=el.readData("sheet1", 1, 3);
		String customer= el.readData("sheet1", 1, 4);
		String revenue= el.readData("sheet1", 1, 5);
		
		LoginPage lp= new LoginPage(driver);
		lp.login(username, password);
		
		Reporter.log("logged in", true);
		
		DashBoardPage dp= new DashBoardPage(driver);
		dp.getCrmBtn().click();
		
		PipelinePage pp= new PipelinePage(driver);
		pp.getCreateBtn().click();
		
		pp.create(name, customer, revenue);
		

}
	}
