package com.tyss.vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	public  OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")private WebElement orgName;

	//utilization
	public WebElement getOrgName() {
		return orgName;
	}
	public void orgInfo(String title) {
		
	
		String actualtitle = orgName.getText();
		if(actualtitle.contains(title)) {
			System.out.println("Organisation created");
		}else {
			System.out.println("Organisation is not created");
		}
	}
	
}
