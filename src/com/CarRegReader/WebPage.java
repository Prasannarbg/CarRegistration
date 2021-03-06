package com.CarRegReader;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class WebPage {
	
		public  List<String>  CarRegistationWebPage(String url, String regNo) throws InterruptedException {
			
List<String> webDetail = new ArrayList<String>();
			
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\geckodriver.exe");
	
			WebDriver driver = new FirefoxDriver();
			
			driver.get(url);
			driver.findElement(By.id("vrm-input")).sendKeys(regNo);
	
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//div[@id='m']/descendant-or-self::button")).click();	
			
			try {
			  driver.findElement(By.xpath("//div[@id='m']/descendant-or-self::p[position()=1]")).getText();
			}
			catch(Error e) {
				 System.out.println(" Registration Number not identified" );	
				 Reporter.log("Error"+ e.getLocalizedMessage() );
				 driver.close();
				
			}
			
			/*String errorStr= driver.findElement(By.xpath("//div[@id='m']/descendant-or-self::p[position()=1]")).getText();
			 if (errorStr.contentEquals("Please provide a valid vehicle registration")) {
			 System.out.println(" Registration Failed");	
			 driver.close();
			 }
			*/
			
			String browserTile= driver.getTitle();		
			System.out.println(browserTile);
		
			try {
			 Boolean flag = driver.findElement(By.xpath("//div[@id='m']/descendant-or-self::dd[position()=4]")).isDisplayed();
				
			}
			catch(Error e)
			{
				 System.out.println(" Registration Number not identified");	
				 Reporter.log("Error"+ e.getLocalizedMessage() );
				 driver.close();
			}
			
			Thread.sleep(3000);
			String webReg="";
			 webReg= driver.findElement(By.xpath("//div[@id='m']/descendant-or-self::dd[position()=4]")).getText();
			if (webReg.isBlank()) {
			 System.out.println(" Vehicle Not Found ");	
			 driver.close();	
			}
			webDetail.add(webReg);
			
			String webMake= driver.findElement(By.xpath("//div[@id='m']/descendant-or-self::dd[position()=5]")).getText();
			webDetail.add(webMake);
		
			String webModel= driver.findElement(By.xpath("//div[@id='m']/descendant-or-self::dd[position()=6]")).getText();
			webDetail.add(webModel);
			
		
			String webColor= driver.findElement(By.xpath("//div[@id='m']/descendant-or-self::dd[position()=7]")).getText();
			webDetail.add(webColor);
			
			
			String webYear= driver.findElement(By.xpath("//div[@id='m']/descendant-or-self::dd[position()=8]")).getText();
			webDetail.add(webYear);
			
			driver.close();
			
		return webDetail;
			/*
		String registration =driver.findElement(By.xpath("//dt[contains(text(),'Registration')]/../dd")).getText();
		String make =driver.findElement(By.xpath("//dt[text()='Make']/../dd")).getText();
		String model1 =driver.findElement(By.xpath("//dt[text()='Model']/../dd")).getText();
 		String color1=driver.findElement(By.xpath("//dt[text()='Colour']/../dd")).getText();
 		String year1 =driver.findElement(By.xpath("//dt[text()='Year']/../dd")).getText();
			
//			System.out.println(registration);	
			System.out.println(vehicle);
			System.out.println(model);
			System.out.println(color);
			System.out.println(year);
		*/
		
									
		}
		
		public String compareContents(String fileString, String webString)
		{
			String comparaison="";
			if (fileString.equalsIgnoreCase(webString))
				comparaison= " Web content and File content are same for " + fileString;
			else
				comparaison= " Web content and File Content are different : " + fileString;
			return comparaison;
		}

}
