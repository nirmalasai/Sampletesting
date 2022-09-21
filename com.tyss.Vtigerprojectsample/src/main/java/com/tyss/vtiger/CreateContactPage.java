package com.tyss.vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.GenericUtilities.WebDriverUtilities;
/**
 * 
 * @author Nirmala
 *
 */
public class CreateContactPage extends WebDriverUtilities {
	/**
	 * 
	 * @param driver
	 */
	
	//Intialization
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Declaration
	@FindBy(linkText="Contacts") private WebElement contactEdt;
	
	@FindBy(xpath="//img[@alt='Create Contact...']") private WebElement createContactBtn;
	
	@FindBy(name="firstname") private WebElement firstnameEdt;
	
	@FindBy(name="lastname") private WebElement lastnameEdt;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])") private WebElement saveBtn;
	
	/**
	 * 
	 * @return
	 */
	//Utilization
	public WebElement getContactEdt() {
		return contactEdt;
	}

	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}

	public WebElement getFirstnameEdt() {
		return firstnameEdt;
	}

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void contactPage(String fname,String lname)
	{
		firstnameEdt.sendKeys(fname);
		lastnameEdt.sendKeys(lname);
		saveBtn.click();
	}

}
