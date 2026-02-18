package com.framework.base;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;

import com.framework.pages.LoginPage;

@Listeners(com.framework.listeners.TestListener.class)
public class BaseTest {
	
	public static WebDriver driver;
	protected Properties prop;
	
	@BeforeMethod
	public void setUp() throws IOException {
		prop=new Properties();
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
		FileInputStream fis=new FileInputStream(path);
		prop.load(fis);
		
		driver=new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		
		
		
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	

}
