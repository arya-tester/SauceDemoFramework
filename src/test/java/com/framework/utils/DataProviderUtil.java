package com.framework.utils;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {
	
	@DataProvider(name="loginData")
	public Object[][] getLoginData(){
		String path=System.getProperty("user.dir")+"/src/test/resources/testdata/LoginData.xlsx";
		
		return ExcelUtil.getTestData(path, "Sheet1");
		
	}

}
