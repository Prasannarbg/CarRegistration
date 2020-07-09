package com.CarRegReader;

import java.io.FileNotFoundException;
import java.util.List;

public class PatternCheck {

	public static void main(String[] arg) throws FileNotFoundException, InterruptedException    {
		
		String INPUT_FILE = System.getProperty("user.dir")+"\\car_input.txt";
		String OUT_FILE = System.getProperty("user.dir")+ "\\car_output.txt";
		String URL= "https://cartaxcheck.co.uk/";
		String registrationNumber = "";
	
		
		InputFileReader inputReg= new InputFileReader();
		OutputFileReader outReg= new OutputFileReader();
		WebPage  webPage = new WebPage();
		
		List<String> regNumberList = inputReg.getRegistrationNumber(INPUT_FILE); 
			  
		
		
		 for (int i=2;i<regNumberList.size();i++) {
			 registrationNumber =regNumberList.get(i).substring(0, 7);
			 System.out.println("The Current Registration no is " +registrationNumber );
			 
			 Thread.sleep(1000);
			 
			 List<String> fileRegistationDetailList =  outReg.validateResult(OUT_FILE, registrationNumber); 
			 List<String> webRegistationDetailList = webPage.CarRegistationWebPage(URL,  registrationNumber);
			 
				 
			 if (fileRegistationDetailList.get(0).equalsIgnoreCase(webRegistationDetailList.get(0))) {
						System.out.println("Registration number is ->" + fileRegistationDetailList.get(0));
			 }
				 
			 if (fileRegistationDetailList.get(1).equalsIgnoreCase(webRegistationDetailList.get(1))) {
					System.out.println("Make are same -> " +fileRegistationDetailList.get(1));
			 }
			 
			 if (fileRegistationDetailList.get(2).equalsIgnoreCase(webRegistationDetailList.get(2))) {
					System.out.println("Model number is correct -> "+ fileRegistationDetailList.get(2));
			 }
			 
			 if (fileRegistationDetailList.get(3).equalsIgnoreCase(webRegistationDetailList.get(3))) {
					System.out.println("Color are same -> "+ fileRegistationDetailList.get(3));
			 }
			 
			 if (fileRegistationDetailList.get(4).equalsIgnoreCase(webRegistationDetailList.get(4))) {
					System.out.println("Year  are same -> "+ fileRegistationDetailList.get(4));
			 }
	
			
		 }
	
	}
}