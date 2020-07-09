package com.CarRegReader;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebPage {
	
		public  List<String>  CarRegistationWebPage(String url, String regNo) throws InterruptedException {
			
			List<String> webDetail = new ArrayList<String>();
		
			System.setProperty("webdriver.gecko.driver","E:\\PG\\Automation\\Chrome\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			
			driver.get(url);
			driver.findElement(By.id("vrm-input")).sendKeys(regNo);
	
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div/div/span/form/button")).click();		
			
			Boolean errorText;
			errorText= driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div/div/span/form/p")).isDisplayed();
			if (errorText) {
			System.out.println("The Registraion is invalid"); }
			
			String browserTile= driver.getTitle();		
			System.out.println(browserTile);
		
			
			Thread.sleep(3000);
			String webReg="";
			webReg= driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[1]/div/span/div[2]/dl[1]/dd")).getText();
			if (webReg.isBlank())
			 driver.close();	
			webDetail.add(webReg);
			
			
			String webVehicle= driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[1]/div/span/div[2]/dl[2]/dd")).getText();
			webDetail.add(webVehicle);

			String webModel= driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[1]/div/span/div[2]/dl[3]/dd")).getText();
			webDetail.add(webModel);
			
			
			String webColor= driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[1]/div/span/div[2]/dl[4]/dd")).getText();	
			webDetail.add(webColor);
			
			String webYear= driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[1]/div/span/div[2]/dl[5]/dd")).getText();
			webDetail.add(webYear);
			
			driver.close();
			
			return webDetail;
		/*	
			String registration =driver.findElement(By.xpath("//dt[contains(text(),'Registration')]/../dd")).getText();
			String vehicle =driver.findElement(By.xpath("//dt[text()='Vehicle']/../dd")).getText();
			String model =driver.findElement(By.xpath("//dt[text()='Model']/../dd")).getText();
	 		String color=driver.findElement(By.xpath("//dt[text()='Colour']/../dd")).getText();
	 		String year =driver.findElement(By.xpath("//dt[text()='Year']/../dd")).getText();
			
			System.out.println(registration);	
			System.out.println(vehicle);
			System.out.println(model);
			System.out.println(color);
			System.out.println(year);
			
			*/						
		}

}
