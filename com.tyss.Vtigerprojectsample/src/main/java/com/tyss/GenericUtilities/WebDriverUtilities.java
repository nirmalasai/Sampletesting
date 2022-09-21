package com.tyss.GenericUtilities;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;



public class WebDriverUtilities {
	
	
	
	public void maximizeBrowser(WebDriver driver)
	{
	driver.manage().window().maximize();
	}
	
	public void minimizeBrowser(WebDriver driver)
	{
		driver.manage().window().minimize();
	}

	public void refreshBrowser(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	
	public void goToPreviousPage(WebDriver driver)
	{
		driver.navigate().back();
	}
	
	public void goToForwardPage(WebDriver driver)
	{
		driver.navigate().forward();
	}
	
	public void waitTillPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstants.implicitlyWaitDuration));
	}
	
	public void waitTillElementClick(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicityWaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	
	}
	
	
	
	public void waitTillElementVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicityWaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	
	}
	public void waitTillPageLoadTitle(WebDriver driver,String title)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicityWaitDuration));
		wait.until(ExpectedConditions.titleContains(title));
	
	}
	
	public void waitTillPageLoaderURL(WebDriver driver,String url)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicityWaitDuration));
		wait.until(ExpectedConditions.urlContains(url));
	
	}
	
	public void ignoreNoSuchElementException(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicityWaitDuration));
		wait.ignoring(NoSuchElementException.class);
	}
	
	public void waitForAlertPopupMessage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.explicityWaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrameUsingID(WebDriver driver, String id) {
		driver.switchTo().frame(id);
	}

	public void switchToFrameWithElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);

	}
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().defaultContent();

	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();;

	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();;

	}

	/**
	 * 
	 * @param driver
	 */
	public void clickOnEnterKey(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		
	}
	/**
	 * 
	 * @param element
	 * @param index
	 */
	public void selectDropDownByIndex(WebElement element, int index) {
		Select selectDropDown = new Select(element);
		selectDropDown.selectByIndex(index);
	}
	/**
	 * 
	 * @param element
	 * @param value
	 */
	public void selectDropDownByValue(WebElement element, String value) {
		Select selectDropDown = new Select(element);
		selectDropDown.selectByValue(value);
	}
	/**
	 * 
	 * @param element
	 * @param value
	 */
	public void selectDropDownByVisibileText(WebElement element, String value) {
		Select selectDropDown = new Select(element);
		selectDropDown.selectByVisibleText(value);
	}
	
	/**
	 * 
	 * @param driver
	 * @param screenShotName
	 */
	public static String takesScreenShot(WebDriver driver, String screenShotName) {
		TakesScreenshot takescreenShot = (TakesScreenshot)driver;
		File source=takescreenShot.getScreenshotAs(OutputType.FILE);
		File destination=new File("./screenshot/"+screenShotName+".PNG");
		try {
			FileUtils.copyFile(source, destination);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return screenShotName;
	}
	/**
	 * 
	 * @param driver
	 */
	public void waitAndClickUsingCustomWait(WebDriver driver) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofSeconds(10));
		wait.ignoring(NoSuchElementException.class);
		try {
			wait.wait(10);;
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}

	}
	/**
	 * 
	 * @param element
	 * @param pollingTime
	 * @param duration
	 */
	public void waitAndClick(WebElement element, long pollingTime, int duration) {
		int count=0;
		while(count<duration) {
			try {
				element.click();
				break;
			}catch(Exception e) {
				try {
					Thread.sleep(pollingTime);
				}catch(Exception e2) {
					e2.printStackTrace();
				}
				count++;
			}
		}
	}
	/**
	 * 
	 * @param driver
	 * @param actualTitle
	 */
	public void switchToWindow(WebDriver driver, String actualTitle) {
		Set<String> windowList = driver.getWindowHandles();
		for(String window : windowList)
		{
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.contains(actualTitle)) 
			{
				break;
			}
		}
	}
	/**
	 * 
	 * @param driver
	 * @param actualurl
	 */
	public void switchToWindow(String actualurl,WebDriver driver) {
		Set<String> windowList = driver.getWindowHandles();
		Iterator<String> windowiterator = windowList.iterator();
		while(windowiterator.hasNext()) {
			String window = windowiterator.next();
			driver.switchTo().window(window);
			String url = driver.getCurrentUrl();
			if(url.contains(actualurl)) {
				break;
			}
		}
	}
	
}