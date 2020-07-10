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
		Pattern fullPattern,halfPattern; 
		Matcher fullMatch,halfMatch ; 

		Scanner scanRead= new Scanner(new File(fileName));
		while(scanRead.hasNextLine()) {
			text= scanRead.next();
			fullPattern= Pattern.compile(regex1);
			halfPattern= Pattern.compile(regex2);
			fullMatch = fullPattern.matcher(text);
			halfMatch = halfPattern.matcher(text);

			boolean result1 = fullMatch.matches();
			if( result1) {	
				saveReg.add(text);
			}

			boolean result2 = halfMatch.matches();
			if( result2) {
				String fullString2 = text+scanRead.next();	
				saveReg.add(fullString2);
			}
		}
		return saveReg;
	}
	

	
}
