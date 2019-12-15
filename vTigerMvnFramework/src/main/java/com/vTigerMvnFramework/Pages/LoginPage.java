package com.vTigerMvnFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	@FindBy(name="user_name")
	WebElement usernameEdit;
	
	@FindBy(name="user_password")
	WebElement passwordEdit;
	
	@FindBy(id="submitButton")
	WebElement loginButton;

	public WebElement getUsernameEdit()
	{
		return usernameEdit;
	}

	public WebElement getPasswordEdit() 
	{
		return passwordEdit;
	}

	public WebElement getLoginButton() 
	{
		return loginButton;
	}
	
	public void login(String un, String psd)
	{
		usernameEdit.sendKeys(un);
		passwordEdit.sendKeys(psd);
		loginButton.click();
	}
	
}
