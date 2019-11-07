package com.atmecs.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.atmecs.check.constant.Findloc;
import com.atmecs.check.helper.CommonUtlity;

public class PageFlow {
	WebDriver driver;
	CommonUtlity CommonUtlity;
	 
	Findloc loc;

	public PageFlow(WebDriver driver) {
		this.driver = driver;
	  CommonUtlity = new CommonUtlity(driver);
		loc = new Findloc();
	}
	int index=1;
	public void selectPlace() {
		CommonUtlity.scrollDownPage(1300);
		
		
//		  List <WebElement>places=CommonUtlity.getElementsList("xpath:(//div[@class='_p62vg1'])[1]");
//		  int placecount= places.size();
//		  System.out.println(placecount);
		 
	
			CommonUtlity.clickElement(loc.getlocator("loc.iad.select").replace("xxx", index + ""));
		
			index++;
			
	}	
	
public void secondwindow() {
	

	String mainWindowHandle = driver.getWindowHandle();


	for (String childWindowHandle : driver.getWindowHandles()) {
	 //If window handle is not main window handle then close it
	 if(!childWindowHandle.equals(mainWindowHandle)){
	 driver.switchTo().window(childWindowHandle);
	 String text=CommonUtlity.getElement(loc.getlocator("loc.getbuthan.text")).getText();
	 System.out.println(text);
	 // Close child windows
	 driver.close();

	
	
	 }

	//switch back to main window
	driver.switchTo().window(mainWindowHandle);
		
		
	}
 
}
}
