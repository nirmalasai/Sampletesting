package com.tyss.GenericUtilities;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listener implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=report.createTest(result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS,result.getMethod().getMethodName());
		test.log(Status.PASS,result.getThrowable());
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.FAIL,result.getMethod().getMethodName());
		test.log(Status.FAIL,result.getThrowable());
		try {
			String screenShot=WebDriverUtilities.takesScreenShot(BaseClass.sdriver,result.getMethod().getMethodName());
			test.addScreenCaptureFromBase64String(screenShot);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
//		String testName=result.getMethod().getMethodName();
//		System.out.println("---------Listening-------");
//		TakesScreenshot takescreenshot=(TakesScreenshot)BaseClass.sdriver;
//		LocalDateTime localDateTime=LocalDateTime.now();
//		String dateTime = localDateTime.toString().replace(" ", "_").replace(":", "_");
//		File src=takescreenshot.getScreenshotAs(OutputType.FILE);
//		File dst=new File("screenshot/"+"_"+testName+"_"+dateTime+".PNG");
//		try {
//			FileUtils.copyFile(src,dst);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			System.out.println("Problem in saving ScreenShot"+e.getMessage());
//		}
//		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP,result.getMethod().getMethodName());
		test.log(Status.SKIP,result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReport/report1.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("sanjay");
		spark.config().setDocumentTitle("extent report 1");
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("platformName", "windows11");
		report.setSystemInfo("document Created By", "Nirmala");
		report.setSystemInfo("report Verified By", "Me");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
		
	}

}
