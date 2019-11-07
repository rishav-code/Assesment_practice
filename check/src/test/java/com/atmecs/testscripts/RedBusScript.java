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
import com.atmecs.pages.RedBus;
import com.atmecs.validations.RedBusValidation;

public class RedBusScript extends TestBase {
	RedBus flow;
	RedBusValidation validation;
	Properties baseClass;
	ReadProp property ;
	String url;
	
	@BeforeClass
	public void urlqw() {
		baseClass=ReadProp.loadProperty(FilePath.CONFIG_FILE);
		url=baseClass.getProperty("url4");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TimeOut.TIMEOUT_INSECONDS, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeOut.IMPLICIT_TIMEOUT_INSECONDS, TimeUnit.SECONDS);
	}
	@Test(priority = 1, dataProvider = "redbusdata", dataProviderClass = Dataprovider.class)

	public void testbus(String source,String destination,String expected) {
		flow=new RedBus(driver) ;
		validation=new RedBusValidation(driver);
		flow.searchBus(source, destination);
		validation.NextPageLanding(expected);
			
		
	}

}
