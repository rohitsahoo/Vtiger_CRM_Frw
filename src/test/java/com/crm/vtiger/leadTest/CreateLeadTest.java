package com.crm.vtiger.leadTest;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.genericLibrary.BaseClass;
import com.crm.vtiger.objectRepo.CreateNewLeadPage;
import com.crm.vtiger.objectRepo.HomePage;
import com.crm.vtiger.objectRepo.LeadsInfoPage;
import com.crm.vtiger.objectRepo.LeadsPage;
import com.crm.vtiger.objectRepo.OrganizationInfoPage;


public class CreateLeadTest extends BaseClass
{
	@Test(groups = "smokeTest")
	public void createLeadTest() throws Throwable
	{
		/*Step 0: Retrieve lastName and companyName from Excel sheet */
		String lastName = eLib.getExcelData("Leads", 1, 0);
		String companyName = eLib.getExcelData("Leads", 1, 0);
		
		/*Step 1 : Go to Leads Page*/
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();
		
		/*Step 2: Click on Create New Lead*/
		LeadsPage lp = new LeadsPage(driver);
		lp.getCreateLeadImg().click();
		
		/*Step 3: Create New Lead*/
		CreateNewLeadPage cnlp = new CreateNewLeadPage(driver);
		cnlp.createNewLead(lastName, companyName);
		
		/*Step 4: Check whether last name contains in header text or not*/
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actualtxt = oip.getHeadertxt().getText();
		Assert.assertTrue(actualtxt.contains(lastName), "Last Name not contains in actual text =============> FAILED");
		System.out.println("PASSED");
		
	}
	
	@Test(groups = "regressionTest")
	public void createLeadWithIndustryTest() throws Throwable
	{
		/*Step 0: Retrieve lastName and companyName from Excel sheet */
		String lastName = eLib.getExcelData("Leads", 1, 0);
		String companyName = eLib.getExcelData("Leads", 1, 1);
		String industryName = eLib.getExcelData("Leads", 1, 2);
		
		/*Step 1 : Go to Leads Page*/
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();
		
		/*Step 2: Click on Create New Lead*/
		LeadsPage lp = new LeadsPage(driver);
		lp.getCreateLeadImg().click();
		
		/*Step 3: Create New Lead with Industry Name*/
		CreateNewLeadPage cnlp = new CreateNewLeadPage(driver);
		cnlp.getLastNameTbx().sendKeys(lastName);
		cnlp.getCompanyTbx().sendKeys(companyName);
		wLib.select(cnlp.getIndustrySelectBox(), industryName);
		cnlp.getSaveBtn().click();
		
		/*Step 4: Check whether last name contains in header text or not*/
		LeadsInfoPage lip = new LeadsInfoPage(driver);
		String actualHeaderText = lip.getHeaderTxt().getText();
		Assert.assertTrue(actualHeaderText.contains(lastName), "LastName does not contain Header Text");
		System.out.println("Test Case ==============> PASSED");
		
	}

}
