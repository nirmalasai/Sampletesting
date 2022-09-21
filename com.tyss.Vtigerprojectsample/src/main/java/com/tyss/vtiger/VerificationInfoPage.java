package com.tyss.vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerificationInfoPage {

	public VerificationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']") private WebElement infoEdt;

	public WebElement getInfoEdt() {
		return infoEdt;
	}
	
}
