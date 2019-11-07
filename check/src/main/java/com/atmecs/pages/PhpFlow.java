package com.atmecs.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.atmecs.check.constant.FilePath;
import com.atmecs.check.constant.TimeOut;
import com.atmecs.check.helper.CommonUtlity;
import com.atmecs.check.util.ReadProp;

public class PhpFlow {
	WebDriver driver;
	Properties loc;
	CommonUtlity WebUtility;

	public PhpFlow(WebDriver driver) {
		this.driver = driver;
		loc = new ReadProp().loadProperty(FilePath.LOCATOR_FILE);
		WebUtility = new CommonUtlity(driver);

	}

	

	public void addAdults(String adult, String child, String destination) {
//		driver.switchTo().frame("chat-widget");
//		WebUtility.clickElement(loc.getProperty("loc.chatbot.click"));
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		WebUtility.clickElement(loc.getProperty("loc.minimize.click"));

		

		System.out.println(adult);

		double noofadults = Double.parseDouble(adult);
		double fianlAdults = noofadults - 2.0;
		WebUtility.clickElement(loc.getProperty("loc.chat.click"));

		for (int index = 1; index <= fianlAdults; index++) {
			WebUtility.clickElement(loc.getProperty("loc.add.button.adult"));
			boolean status = WebUtility .isElementVisible(loc.getProperty("loc.add.button.adult"));
			Assert.assertEquals(status, true);

		}
		WebUtility.clickElement(loc.getProperty("loc.destination.click"));
		

		double noOfChild = Double.parseDouble(child);
		System.out.println(noOfChild);
		for (int index = 1; index <= noOfChild; index++) {
			WebUtility.clickElement(loc.getProperty("loc.add.button.child"));

		}
		WebUtility.clickElement(loc.getProperty("loc.destination.click"));
		WebUtility.clickElement(loc.getProperty("loc.enterdestination"));
		WebUtility.clickAndSendText(loc.getProperty("loc.enterdestination.text"), TimeOut.TIMEOUT_INSECONDS,
				destination);
		  //WebUtility.clickElement(loc.getProperty("loc.chat.click"));
        
		WebUtility.clickElement(loc.getProperty("loc.destionnationcity.select"));
		WebUtility.clickElement(loc.getProperty("loc.clickoncheckin.click"));
          //cu.scrollDocuwnPage(100);
		WebUtility.clickElement(loc.getProperty("loc.checkindate.select"));
		WebUtility.clickElement(loc.getProperty("lloc.checkoutdate.click"));
		WebUtility.clickElement(loc.getProperty("loc.checkoutdate.select"));
		WebUtility.clickElement(loc.getProperty("loc.clickonsearch.button"));

	}

}
