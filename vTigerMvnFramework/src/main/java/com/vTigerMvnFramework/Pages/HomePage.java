package com.vTigerMvnFramework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.vTigerMvnFramework.genericLib.Base;

public class HomePage 
{
	@FindBy(xpath="//img[contains(@src,'user.PNG')]")
	WebElement userImage;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	WebElement signOutLink;
	
	public WebElement getUserImage()
	{
		return userImage;
	}
	
	public WebElement getSignOutLink()
	{
		return signOutLink;
	}
	
	public void logout()
	{
		Actions act = new Actions(Base.newDriver);
		act.moveToElement(userImage).perform();;
		signOutLink.click();
	}
	
	
}
