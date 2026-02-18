package com.framework.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	public void login(String user, String pass) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    // Wait for username field
	    wait.until(ExpectedConditions.visibilityOfElementLocated(username));

	    // Enter credentials
	    driver.findElement(username).sendKeys(user);
	    driver.findElement(password).sendKeys(pass);

	    // Click login
	    driver.findElement(loginBtn).click();
	}

	public String getErrorMsg() {
		return errorMsg.getText();
		
	}


}
