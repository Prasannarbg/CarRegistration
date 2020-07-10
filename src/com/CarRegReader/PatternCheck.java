package com.CarRegReader;

import java.io.FileNotFoundException;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PatternCheck {

	
	@Test(dataProvider="getData")
	public static void ValidationCheck(String registrationNumber) throws FileNotFoundException, InterruptedException    {
		
		String INPUT_FILE = System.getProperty("user.dir")+"\\car_input.txt";
		String OUT_FILE = System.getProperty("user.dir")+ "\\car_output.txt";
		String URL= "https://cartaxcheck.co.uk/";
			
		
		InputFileReader inputReg= new InputFileReader();
		OutputFileReader  outReg= new OutputFileReader();
		WebPage  webPage = new WebPage();
		
		List<String> regNumberList = inputReg.getRegistrationNumber(INPUT_FILE); 
			 
			 System.out.println("The Current Registration no is " +registrationNumber );
			 
			 Thread.sleep(1000);
			 
			 List<String> fileRegistationDetailList =  outReg.validateResult(OUT_FILE, registrationNumber); 
			 List<String> webRegistationDetailList = webPage.CarRegistationWebPage(URL,  registrationNumber);
			 
			 for (int k=0;k<=4;k++) {
			 String result = webPage.compareContents(fileRegistationDetailList.get(k), webRegistationDetailList.get(k));
			 System.out.println(result);
			 }
			
	}
	
	
	@DataProvider
	public Object[] getData() throws FileNotFoundException {
		
		InputFileReader inputReg= new InputFileReader();
		String INPUT_FILE = System.getProperty("user.dir")+"\\car_input.txt";
		List<String> regNumberList = inputReg.getRegistrationNumber(INPUT_FILE); 
		String registrationNumber = "";
		String regbreak;
		
		Object[] Data = new Object[regNumberList.size()];
		for (int i=0;i<regNumberList.size();i++) {
			 registrationNumber =regNumberList.get(i).substring(0, 7);
			 regbreak=registrationNumber;
			
			 if ((i==1) ||(i==3)) {
			  regbreak= registrationNumber.substring(0, 4);
			 regbreak=regbreak+ " ";
			 regbreak = regbreak + registrationNumber.substring(4);
			 }
		
			 Data[i]=regbreak;
		}
		
		return Data;
	}
	
}