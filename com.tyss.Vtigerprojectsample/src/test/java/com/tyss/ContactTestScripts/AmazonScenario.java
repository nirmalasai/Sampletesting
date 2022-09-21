package com.tyss.ContactTestScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tyss.GenericUtilities.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonScenario{
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
	    List<WebElement> ele=driver.findElements(By.xpath("//span[contains(text(),'Apple iPhone')]"));
	    System.out.println(ele.size());
		for(WebElement phonelist:ele) {
			String a=phonelist.getText();
			System.out.println(a);
		}
		
		
	}
	

}
