package com.framework.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {
	public static String takeScreenshot(WebDriver driver,String testName) {
		
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmss");
		String timeStamp=sdf.format(d);
		String path=System.getProperty("user.dir")+"\\screenshots\\"+testName+"_"+timeStamp+".png";
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(path);
		try {
		FileUtils.copyFile(src,dest);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return path;
		
		
		
	}

}
