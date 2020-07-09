package com.CarRegReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputFileReader {

	public List<String> getRegistrationNumber(String fileName) throws FileNotFoundException {
		
		List<String> saveReg = new ArrayList<String>();
		String regex1= "\\w\\w\\d\\d\\w\\w\\w";
		String regex2= "\\w\\w\\d\\d";
		String text = "";
		Pattern pt1,pt2; 
		Matcher mt1,mt2 ; 

		Scanner scanRead= new Scanner(new File(fileName));
		while(scanRead.hasNextLine()) {
			text= scanRead.next();
			pt1= Pattern.compile(regex1);
			pt2= Pattern.compile(regex2);
			mt1 = pt1.matcher(text);
			mt2 = pt2.matcher(text);

			boolean result1 = mt1.matches();
			if( result1) {	
				saveReg.add(text);
			}

			boolean result2 = mt2.matches();
			if( result2) {
				String fullString2 = text+scanRead.next();	
				saveReg.add(fullString2);
			}
		}
		return saveReg;
	}
	

	
}
