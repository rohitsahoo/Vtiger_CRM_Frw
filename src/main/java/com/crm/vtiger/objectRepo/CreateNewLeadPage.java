package com.crm.vtiger.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.genericLibrary.WebDriverUtility;




public class CreateNewLeadPage 
{
	@FindBy(name = "lastname")
	private WebElement lastNameTbx;
	
	@FindBy(name = "company")
	private WebElement companyTbx;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceSelectBox;
	
	@FindBy(name = "industry")
	private WebElement industrySelectBox;
	
	public CreateNewLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameTbx() {
		return lastNameTbx;
	}

	public WebElement getCompanyTbx() {
		return companyTbx;
	}

	public WebElement getSaveBtn() 
	{
		return saveBtn;
	}
	
	public WebElement getIndustrySelectBox() {
		return industrySelectBox;
	}
	
	public void createNewLead(String lastName, String companyName)
	{
		lastNameTbx.sendKeys(lastName);
		companyTbx.sendKeys(companyName);
		saveBtn.click();
	}
	
	public void createNewLead(String lastName, String companyName, String industryName)
	{
		lastNameTbx.sendKeys(lastName);
		companyTbx.sendKeys(companyName);
		
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.select(industrySelectBox, industryName);
		
		saveBtn.click();
	}
	
	

	

}
