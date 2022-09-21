package com.tyss.ContactTestScripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.GenericUtilities.BaseClass;
import com.tyss.GenericUtilities.ExcelUtilities;
import com.tyss.vtiger.CreateContactPage;
import com.tyss.vtiger.HomePage;
import com.tyss.vtiger.VerificationInfoPage;

public class CreateContactPageTest extends BaseClass {

  @Test(groups={"smokeTest"})
  public void CreateContactPageTest() throws EncryptedDocumentException, FileNotFoundException, IOException {
    
    
 // TODO Auto-generated method stub
    		//To click on contactlnk
			HomePage homepage=new HomePage(driver);
			homepage.getContactsLink().click();
			
			
			
			//to get data from excel
			String firstname=excelUtilities.getDataFromExcel("Contacts",1,2);
			String lastname=excelUtilities.getDataFromExcel("Contacts",1,3);
			
			//to get the createcontact page
			CreateContactPage contact=new CreateContactPage(driver);
			contact.getCreateContactBtn().click();
			
 			contact.contactPage(firstname, lastname);

 			//Verification
 			VerificationInfoPage verifyContact=new VerificationInfoPage(driver);
 			String actualContact=verifyContact.getInfoEdt().getText();
 			Assert.assertTrue(actualContact.contains(firstname));

 			
 		

  }
}
