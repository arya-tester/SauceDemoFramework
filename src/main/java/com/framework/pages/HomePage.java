package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	//locators
	By appLogo=By.className("app_logo");
	By menuBtn=By.id("react-burger-menu-btn");
	By cartIcon=By.className("shopping_cart_link");
	
			
	//Actions
	
	public String getTitle() {
		String title=driver.getTitle();
		return title;
	}
	public boolean isLogoDisplayed() {
		boolean logo=driver.findElement(appLogo).isDisplayed();
		return logo; 
	}
	public boolean isMenuBtnDisplayed() {
		boolean menu=driver.findElement(menuBtn).isDisplayed();
		return menu;
	}
	public boolean isCartIconDisplayed() {
		boolean cart=driver.findElement(cartIcon).isDisplayed();
		return cart;
	}
	public void onMenuClick() {
		driver.findElement(menuBtn).click();
	}

}
