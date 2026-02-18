package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	//constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//locators
	private By username=By.id("user-name");
	private By password=By.id("password");
	private By loginBtn=By.id("login-button");
	@FindBy(xpath="//h3[@data-test='error']")
	WebElement errorMsg;
	
	
	//Actions
	public void enterUsername(String user) {
		driver.findElement(username).sendKeys(user);
	}
	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	public void clickLoginBtn() {
		driver.findElement(loginBtn).click();
	}
	public void login(String user,String pass) {
		enterUsername(user);
		enterPassword(pass);
		clickLoginBtn();
	}
	public String getErrorMsg() {
		return errorMsg.getText();
		
	}


}
