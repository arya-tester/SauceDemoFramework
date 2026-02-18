package com.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.pages.LoginPage;
import com.framework.utils.DataProviderUtil;






public class LoginTest extends BaseTest{
	@Test(
			dataProvider = "loginData",
			retryAnalyzer = com.framework.retry.RetryAnalyzer.class,
			dataProviderClass = DataProviderUtil.class
			)
	public void validLoginTest(String username,String password) {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username,password);
		String title=driver.getTitle();
		System.out.println("page title is "+title);
		Assert.assertTrue(title.contains("Swag"),"Login Failed for user "+username);
		//Assert.assertTrue(false);
		
		
	//String user=prop.getProperty("username");
	//String pass=prop.getProperty("password");
	//	String currentUrl=driver.getCurrentUrl();
	//	System.out.println(currentUrl);
	//	Assert.assertTrue(currentUrl.contains("inventory"),"Login Failed");
		
	//	Assert.assertTrue(false); force failure to check if screnshot and listener works
	}
	/*
	@Test
	public void invalidLoginTest() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login("wrong_user", "wrong_pass");
		String error=loginpage.getErrorMsg();
		System.out.println("Error Message "+error);
		Assert.assertTrue(error.contains("Epic sadface"),"Error message not showing properly");
		
	}
	*/

}
