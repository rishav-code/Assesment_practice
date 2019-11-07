package com.atmecs.testscripts;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.atmecs.check.constant.FilePath;
import com.atmecs.check.constant.TimeOut;
import com.atmecs.check.dataprovider.Dataprovider;
import com.atmecs.check.testbase.TestBase;
import com.atmecs.check.util.ReadProp;
import com.atmecs.pages.PhpFlow;

public class PhpFlowScript extends TestBase {
	Properties baseClass;
	PhpFlow flow;
	ReadProp property ;
	String url;
	public void urlqw() {
		baseClass=ReadProp.loadProperty(FilePath.CONFIG_FILE);
		url=baseClass.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TimeOut.TIMEOUT_INSECONDS, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeOut.IMPLICIT_TIMEOUT_INSECONDS, TimeUnit.SECONDS);
	}
	@Test(priority = 1, dataProvider = "content", dataProviderClass = Dataprovider.class)
	public void test(String adult, String child, String destination) {
		flow=new PhpFlow(driver);

		flow.addAdults(adult, child, destination);
		
	}

}
