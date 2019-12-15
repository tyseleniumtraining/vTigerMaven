package com.vTigerMvnFramework.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.vTigerMvnFramework.Pages.HomePage;
import com.vTigerMvnFramework.Pages.LoginPage;

public class Base 
{
	public FileLib flib;
	public  WebDriver driver;	
	public LoginPage lp;
	public HomePage hp;
	public static WebDriver newDriver;
	
	@BeforeClass
	public void configBC()
	{
		flib = new FileLib();
		
		//Launch the browser
		if(flib.getPropertyKeyValue("browser").equals("chrome"))
		{
			driver = new ChromeDriver();
			newDriver = driver;
		}
		else if(flib.getPropertyKeyValue("browser").equals("firefox"))
		{
			driver = new FirefoxDriver();
			newDriver = driver;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Enter the URL
		driver.get(flib.getPropertyKeyValue("url"));
	}
	
	@BeforeMethod
	public void configBM()
	{
		lp = PageFactory.initElements(driver, LoginPage.class);
		lp.login(flib.getPropertyKeyValue("username"), flib.getPropertyKeyValue("password"));
	}
	
	@AfterMethod
	public void configAM()
	{
		hp = PageFactory.initElements(driver, HomePage.class);
		hp.logout();
	}
	
	@AfterClass
	public void configAC()
	{
		driver.quit();
	}
	
}
