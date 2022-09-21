package com.tyss.vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.GenericUtilities.WebDriverUtilities;

public class CreateOrganisationPage extends WebDriverUtilities{
	
	//intialization
	public CreateOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Declaration
	
	//Organisation name
	@FindBy(name="accountname") private WebElement orgnameEdt;
	
	//save button
	@FindBy(xpath="//input[@title='Save [Alt+S]']") private WebElement saveBtn;
	
	//industry dropdown
	@FindBy(name="industry") private WebElement industryDropdn; 
	
	//type drop down
	@FindBy(name="accounttype") private WebElement accountTypeDropdn;
	
	
	public WebElement getOrgnameEdt() {
		return orgnameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getIndustryDropdn() {
		return industryDropdn;
	}

	public WebElement getAccountTypeDropdn() {
		return accountTypeDropdn;
	}
	
	
	//utilization
	public void getcreateOrganisation(String orgName)
	{
		orgnameEdt.sendKeys(orgName);
		
		
		
	}	
	public void selectIndustry(String industry)
	{
		selectDropDownByVisibileText(industryDropdn, industry);
	}

	

}
