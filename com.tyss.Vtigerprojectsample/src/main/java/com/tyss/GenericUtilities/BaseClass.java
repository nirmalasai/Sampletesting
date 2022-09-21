package com.tyss.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.tyss.vtiger.HomePage;
import com.tyss.vtiger.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver sdriver;
	public WebDriver driver;
	public DatabaseUtlities dbUtilities =new DatabaseUtlities();
	public ExcelUtilities excelUtilities=new ExcelUtilities();
	public FileUtilities fileUtilities=new FileUtilities();
	public WebDriverUtilities wdUtilities=new WebDriverUtilities();
	public JavaUtilities javaUtilities=new JavaUtilities();
	
	
/*	@BeforeSuite(groups= {"regressionTest","smokeTest"})
	public void dbConfig()
	{
		dbUtilities.connectToDatabase();
	}*/
	@Parameters("Browser")
	@BeforeClass(groups= {"regressionTest","smokeTest"})
	//to launch the browser
	public void lauchTheBrowser(String BROWSER)throws IOException
	{
		//String BROWSER=fileUtilities.getPropertyValue("browser");
		
		//String BROWSER=System.getProperty("Browser");
		String URL=fileUtilities.getPropertyValue("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=WebDriverManager.chromedriver().create();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=WebDriverManager.firefoxdriver().create();
		}
		else
		{
			WebDriverManager.chromedriver().create();
		}
		System.out.println("Browser launched");
		
		sdriver=driver;
		
		
		//Enter the Url into the apllication
		driver.get(URL);
		
		//maximize the screen
		wdUtilities.maximizeBrowser(driver);
		
		wdUtilities.waitTillPageLoad(driver);
		
	}
	
	@BeforeMethod(groups= {"regressionTest","smokeTest"})
	public void loginToApp() throws IOException
	{
		String USERNAME=fileUtilities.getPropertyValue("username");
		String PASSWORD=fileUtilities.getPropertyValue("password");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("Login Sucessful");
	}
	@AfterMethod(groups= {"regressionTest","smokeTest"})
	public void logoutFromApp()
	{
		HomePage homepage=new HomePage(driver);
		homepage.Logout(driver);
		System.out.println("Logout Successful");
	}
	@AfterClass(groups= {"regressionTest","smokeTest"})
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("Browser sucessfully closed");
	}
	/*@AfterSuite(groups= {"regressionTest","smokeTest"})
	public void closeDBConn()
	{
		dbUtilities.closeDatabase();
	}*/

	}	

