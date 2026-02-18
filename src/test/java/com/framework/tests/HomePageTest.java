package com.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.pages.HomePage;

public class HomePageTest extends BaseTest  {
	
	@Test
	public void verifyHomePageTitle() {
		HomePage hp=new HomePage(driver);
		Assert.assertTrue(hp.getTitle().contains("Swag Labs"));
	}

}
