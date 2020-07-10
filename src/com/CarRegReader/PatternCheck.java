package com.CarRegReader;

import java.io.FileNotFoundException;
import java.util.List;

public class PatternCheck {

	public static void main(String[] arg) throws FileNotFoundException, InterruptedException    {
		
		String INPUT_FILE = System.getProperty("user.dir")+"\\car_input.txt";
		String OUT_FILE = System.getProperty("user.dir")+ "\\car_output.txt";
		String URL= "https://cartaxcheck.co.uk/";
		String registrationNumber = "";
		String regbreak;
	
		
		InputFileReader inputReg= new InputFileReader();
		OutputFileReader outReg= new OutputFileReader();
		WebPage  webPage = new WebPage();
		
		List<String> regNumberList = inputReg.getRegistrationNumber(INPUT_FILE); 
			  
		
		
		 for (int i=2;i<regNumberList.size();i++) {
			 registrationNumber =regNumberList.get(i).substring(0, 7);
			 regbreak=registrationNumber;
			 if ((i==1) ||(i==3)) {
			  regbreak= registrationNumber.substring(0, 4);
			 regbreak=regbreak+ " ";
			 regbreak = regbreak + registrationNumber.substring(4);
			 }
			 
			 System.out.println("The Current Registration no is " +registrationNumber );
			 
			 Thread.sleep(1000);
			 
			 List<String> fileRegistationDetailList =  outReg.validateResult(OUT_FILE, registrationNumber); 
			 List<String> webRegistationDetailList = webPage.CarRegistationWebPage(URL,  regbreak);
			 
			 for (int k=0;k<=4;k++) {
			 String result = webPage.compareContents(fileRegistationDetailList.get(k), webRegistationDetailList.get(k));
			 System.out.println(result);
			 }
			
		 }
	
	}
}