package com.atmecs.validations;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.atmecs.check.constant.FilePath;
import com.atmecs.check.helper.CommonUtlity;
import com.atmecs.check.util.ReadProp;

public class RedBusValidation {
	WebDriver driver;
	Properties loc;
	CommonUtlity WebUtility;

	public RedBusValidation (WebDriver driver) {
		this.driver = driver;
		loc = ReadProp.loadProperty(FilePath.LOCATOR_FILE);
		WebUtility = new CommonUtlity(driver);

	}
	public void NextPageLanding(String expected) {
		String actualtext=WebUtility.getElement(loc.getProperty("loc.filter.text")).getText();
		assertEquals(actualtext, expected,"assertion not done ");
		System.out.println("assertion done");
		
	}

}
