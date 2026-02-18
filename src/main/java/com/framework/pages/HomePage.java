package com.framework.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}
	
	//locators
	By inventoryContainer=By.id("inventory_container");
	By appLogo=By.className("app_logo");
	By menuBtn=By.id("react-burger-menu-btn");
	By cartIcon=By.className("shopping_cart_link");
	
			
	//Actions
	
	public String getTitle() {
		String title=driver.getTitle();
		return title;
	}
	public void waitForHomePage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.urlContains("inventory"));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryContainer));
	}
	public boolean isLogoDisplayed() {
		waitForHomePage();
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(appLogo));
		boolean logo=driver.findElement(appLogo).isDisplayed();
		return logo; 
	}
	public boolean isMenuBtnDisplayed() {
		boolean menu=driver.findElement(menuBtn).isDisplayed();
		return menu;
	}
	public boolean isCartIconDisplayed() {
		waitForHomePage();
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(cartIcon));
		boolean cart=driver.findElement(cartIcon).isDisplayed();
		return cart;
	}
	public void onMenuClick() {
		driver.findElement(menuBtn).click();
	}

}
