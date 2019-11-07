package com.atmecs.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.atmecs.check.constant.FilePath;
import com.atmecs.check.constant.TimeOut;
import com.atmecs.check.helper.CommonUtlity;
import com.atmecs.check.util.ReadProp;

public class RedBus {
	WebDriver driver;
	Properties loc;
	CommonUtlity WebUtility;

	public RedBus(WebDriver driver) {
		this.driver = driver;
		loc = ReadProp.loadProperty(FilePath.LOCATOR_FILE);
		WebUtility = new CommonUtlity(driver);

	}

	public void searchBus(String source,String destination) {
	WebUtility.clickElement(loc.getProperty("loc.src.click"));
	WebUtility.clearTextData(loc.getProperty("loc.src.click"));
	WebUtility.clickAndSendText(loc.getProperty("loc.src.click"), TimeOut.TIMEOUT_INSECONDS, source);
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	WebUtility.clickElement(loc.getProperty("loc.scrlocation.select"));
	WebUtility.clickElement(loc.getProperty("loc.dest.click"));
	WebUtility.clearTextData(loc.getProperty("loc.dest.click"));
	WebUtility.clickAndSendText(loc.getProperty("loc.dest.click"), TimeOut.TIMEOUT_INSECONDS, destination);
try {
	Thread.sleep(3000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	WebUtility.clickElement(loc.getProperty("loc.destlocation.select"));
	WebUtility.clickElement(loc.getProperty("loc.departdate.click"));
	WebUtility.clickElement(loc.getProperty("loc.deptdate.select"));
	WebUtility.clickElement(loc.getProperty("loc.returndate.click"));
	WebUtility.clickElement(loc.getProperty("loc.returndate.select"));
//	WebUtility.clickElement(loc.getProperty("loc.searchbutton.click"));

	
	}
}