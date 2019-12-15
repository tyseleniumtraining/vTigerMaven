package com.vTigerMvnFramework.TestCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTigerMvnFramework.genericLib.Base;

@Listeners(com.vTigerMvnFramework.genericLib.ListenerImpClass.class)
public class LoginTest extends Base 
{
	@Test
	public void loginTest()
	{
		System.out.println("LoginSuccessful");
		System.out.println("Bye");
	}
}
