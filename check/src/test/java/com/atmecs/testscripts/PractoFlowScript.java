package com.atmecs.testscripts;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atmecs.check.constant.FilePath;
import com.atmecs.check.constant.TimeOut;
import com.atmecs.check.dataprovider.Dataprovider;
import com.atmecs.check.testbase.TestBase;
import com.atmecs.check.util.ReadProp;
import com.atmecs.pages.PractoFlow;

public class PractoFlowScript extends TestBase {
	PractoFlow flow;
	Properties baseClass;
	ReadProp property ;
	String url;
	
	@BeforeClass
	public void urlqw() {
		baseClass=ReadProp.loadProperty(FilePath.CONFIG_FILE);
		url=baseClass.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TimeOut.TIMEOUT_INSECONDS, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeOut.IMPLICIT_TIMEOUT_INSECONDS, TimeUnit.SECONDS);
	}
	
	
	  @Test(priority = 1, dataProvider = "PractoData", dataProviderClass = Dataprovider.class)
	  
	  public void practoTest(String expected) {
		
	  flow=new PractoFlow(driver);
	  flow.flow();
	  flow.clickonbreadcrumbs(expected);
	  
	  }
	 
}
