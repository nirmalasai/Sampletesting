package com.tyss.ContactTestScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingFrames {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
	
	driver.switchTo().frame(driver.findElement(By.id("frm3")));
	driver.switchTo().frame(driver.findElement(By.id("frm1")));
	Select s=new Select(driver.findElement(By.id("selectnav")));
	s.selectByVisibleText("Tutorials");
	driver.switchTo().parentFrame();
	driver.findElement(By.id("name")).sendKeys("hello");
	driver.switchTo().defaultContent();
	driver.findElement(By.id("name")).clear();
	
	
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
}
}
