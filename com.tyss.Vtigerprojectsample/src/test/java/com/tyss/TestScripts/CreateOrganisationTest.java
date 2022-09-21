package com.tyss.TestScripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tyss.GenericUtilities.BaseClass;
import com.tyss.GenericUtilities.DatabaseUtlities;
import com.tyss.GenericUtilities.FileUtilities;
import com.tyss.GenericUtilities.ExcelUtilities;
import com.tyss.GenericUtilities.IConstants;
import com.tyss.GenericUtilities.JavaUtilities;
import com.tyss.GenericUtilities.WebDriverUtilities;
import com.tyss.vtiger.CreateOrganisationPage;
import com.tyss.vtiger.HomePage;
import com.tyss.vtiger.LoginPage;
import com.tyss.vtiger.OrganisationPage;
import com.tyss.vtiger.OrganizationInfoPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.tyss.GenericUtilities.Listener.class)
public class CreateOrganisationTest extends BaseClass{
	@Test(groups= {"regressionTest","smokeTest"},retryAnalyzer = com.tyss.GenericUtilities.RetryAnalyImp.class)
	public void CreateOrganisation() throws EncryptedDocumentException,IOException,FileNotFoundException {
		// TODO Auto-generated method stub
		
		//to generate random number
		int random=javaUtilities.getrandomNumber();

		//to get the organisation name from excel
		String OrgName=excelUtilities.getDataFromExcel("Organization", 1, 2);

		//creating object of homepage
		HomePage homepage=new HomePage(driver);
		
		homepage.getOrganizationsLink().click();
		
		
		//organisation add
		OrganisationPage organisationadd=new OrganisationPage(driver);
		organisationadd.getOrganisationaddBtn().click();
		
		//organisation page
		CreateOrganisationPage organisationPage=new CreateOrganisationPage(driver);
		organisationPage.getcreateOrganisation(OrgName+random);
		
		
		//To save the organisation
		organisationPage.getSaveBtn().click();
		
		//verification
		OrganizationInfoPage orginfo=new OrganizationInfoPage(driver);
		String org=orginfo.getOrgName().getText();
		
		Assert.assertTrue(org.contains(OrgName));
		
	}
}
