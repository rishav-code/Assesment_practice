package com.atmecs.pages;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.atmecs.check.constant.FilePath;
import com.atmecs.check.helper.CommonUtlity;
import com.atmecs.check.util.ReadProp;

public class PractoFlow {
	WebDriver driver;
	Properties loc;
	CommonUtlity WebUtility;
	int index=0;

	public PractoFlow(WebDriver driver) {
		this.driver = driver;
		loc = ReadProp.loadProperty(FilePath.LOCATOR_FILE);
		WebUtility = new CommonUtlity(driver);
        
	}
	public void flow() {
		String mainWindowHandle = driver.getWindowHandle();
	
		WebUtility.clickElement(loc.getProperty("loc.pharmacy.click"));
		WebUtility.clickElement(loc.getProperty("loc.skin.click"));
		for (String childWindowHandle : driver.getWindowHandles()) {
			 //If window handle is not main window handle then close it
			 if(!childWindowHandle.equals(mainWindowHandle)){
			 driver.switchTo().window(childWindowHandle);
	}
		}
	}
	public void clickonbreadcrumbs(String expected) {
		WebUtility.clickElement(loc.getProperty("loc.xxbreadcrums.click").replace("xxx", index + ""));
		
		String actual=WebUtility.getElement(loc.getProperty("loc.gettexthome.click")).getText();
		assertEquals(actual, expected,"assertion not done ");
		System.out.println("assertion done");
		index++;
	}
	
}
