package com.CarRegReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OutputFileReader {
	
	public List<String> validateResult(String path, String checkReg) throws FileNotFoundException {
		
		
		List<String> outputList = new ArrayList<String>();
	
		String line= "";
		String reg="";
		
		BufferedReader bufferRead= new BufferedReader(new FileReader(path));
		
		try {
			while( (line=bufferRead.readLine()) != null) {
				String[] values = line.split(",");
				 reg=values[0];
				 boolean flag = reg.equalsIgnoreCase(checkReg);
			
				if ( flag)
				{
				outputList.add(values[0]);
				outputList.add(values[1]);
				outputList.add(values[2]);
				outputList.add(values[3]);
				outputList.add(values[4]);
							
				}		
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(" Error in read file"+ e.getMessage());
		}
		
		return outputList;
		
	}

}
