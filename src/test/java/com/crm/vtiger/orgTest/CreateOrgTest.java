package com.crm.vtiger.orgTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.genericLibrary.BaseClass;
import com.crm.vtiger.objectRepo.CreateNewOrganizationPage;
import com.crm.vtiger.objectRepo.HomePage;
import com.crm.vtiger.objectRepo.OrganizationInfoPage;
import com.crm.vtiger.objectRepo.OrganizationsPage;



public class CreateOrgTest extends BaseClass
{
	
	@Test(groups = "smokeTest")
	public void createOrgTest() throws Throwable
	{
		/*Extract Org Name from Excel Sheet*/
		int rno = jLib.getRandomNumber();
		String orgName = eLib.getExcelData("Org", 1, 0)+rno;
		System.out.println(orgName);
		
		/*Step 1: Click on Organization Tab*/
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();
		
		/*Step 2: Click on Create new Organisation*/
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrgImg().click();
		
		/*Step 3: Enter Org Name in Org Name Text Box and Click on Save*/
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrg(orgName);
		
		/*Step 4: Verify Whether Org Name showing in Header Text or not*/
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actualHeaderTxt = oip.getHeadertxt().getText();
		System.out.println(actualHeaderTxt);
		Assert.assertTrue(actualHeaderTxt.contains(orgName), "Org Name not contains Actual Header Text =======> FAIL");
		System.out.println("Test Case ==============> PASSED");
	}
	

}
