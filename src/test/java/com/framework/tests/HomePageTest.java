package com.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.base.LoggedInBaseTest;
import com.framework.pages.HomePage;

public class HomePageTest extends LoggedInBaseTest  {
	
	@Test
	public void verifyHomePageTitle() {
		HomePage hp=new HomePage(driver);
		String title=driver.getTitle();
		Assert.assertEquals(title,"Swag Labs");
	}
	@Test
	public void verifylogoIsDisplayed() {
		HomePage hp=new HomePage(driver);
		Assert.assertTrue(hp.isLogoDisplayed(),"logo not found");
	}
	@Test
	public void verifyCartIsDisplayed() {
		HomePage hp=new HomePage(driver);
		Assert.assertTrue(hp.isCartIconDisplayed(),"cart icon not found");
	}
	

}
