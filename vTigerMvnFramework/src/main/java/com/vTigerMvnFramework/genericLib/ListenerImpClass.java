package com.vTigerMvnFramework.genericLib;

import java.io.File;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImpClass extends Base implements ITestListener
{
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		try 
		{
			String failedMethodName = result.getMethod().getMethodName();
			String date = new Date().toString().replaceAll(" ", "_").replaceAll(":", "_");
			
			EventFiringWebDriver edriver = new EventFiringWebDriver(Base.newDriver);
			File srcFile = edriver.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./screenshots/"+date+"_"+failedMethodName+".png");
		
		
			FileUtils.copyFile(srcFile, destFile);
		} 
		
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
		
	}


	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
