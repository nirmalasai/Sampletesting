package com.tyss.vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.GenericUtilities.WebDriverUtilities;

public class HomePage extends WebDriverUtilities {
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	

	//declaration 
	@FindBy(xpath="(//a[.='Organizations'])[1]") 
	private WebElement organizationsLink;
	
	@FindBy(xpath="//a[.='Contacts']")
	private WebElement contactsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorLink;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signoutLink;

	//utilization
	
	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getAdministratorLink() {
		return administratorLink;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
	
	public void Logout(WebDriver driver)
	{
		mouseHoverOnElement(driver,administratorLink);
		signoutLink.click();
	}
}
	
	
