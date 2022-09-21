package com.tyss.TestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tyss.GenericUtilities.BaseClass;
import com.tyss.GenericUtilities.DatabaseUtlities;
import com.tyss.GenericUtilities.ExcelUtilities;
import com.tyss.GenericUtilities.FileUtilities;
import com.tyss.GenericUtilities.JavaUtilities;
import com.tyss.GenericUtilities.WebDriverUtilities;
import com.tyss.vtiger.CreateOrganisationPage;
import com.tyss.vtiger.HomePage;
import com.tyss.vtiger.LoginPage;
import com.tyss.vtiger.OrganisationPage;
import com.tyss.vtiger.OrganizationInfoPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrganisationIndustryTypeTest extends BaseClass{
	
	@Test(groups= {"regressionTest"})
	
	public void CreateOrganisation() throws IOException {
		
		//random number
		int random=javaUtilities.getrandomNumber();
		
		//to get organame from excel
		String OrgName=excelUtilities.getDataFromExcel("Organization", 1, 2);
 
		//creating object of homepage
	 	    HomePage homepage=new HomePage(driver);
	 		homepage.getOrganizationsLink().click();
	 		
	 	//organisation add
	 	OrganisationPage organisationadd=new OrganisationPage(driver);
	 	organisationadd.getOrganisationaddBtn().click();
	 		
	 	//organisation page
	 	CreateOrganisationPage organisationPage1=new CreateOrganisationPage(driver);
	 	organisationPage1.getcreateOrganisation(OrgName+random);
	 		
	 	//to click on industry 
	 		
	 		String industryname=excelUtilities.getDataFromExcel("Organization",2,2);
	 		//wdUtility.selectDropDownByIndex(organisationPage.getIndustryDropdn(),6);
	 		organisationPage1.selectIndustry(industryname);
	 		
	 		
	 		organisationPage1.getSaveBtn().click();
	 		OrganizationInfoPage orginfo=new OrganizationInfoPage(driver);
	 		orginfo.orgInfo(OrgName);
		String org=orginfo.getOrgName().getText();
		
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(org.contains(OrgName));

		//Print output is report and console
		Reporter.log("CreateOrganizationWithIndustryAndTypeTest is pass",true);
		softAssert.assertAll();

	 	}
		
}


