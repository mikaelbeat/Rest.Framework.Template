package demo.Rest.Framework.Template.TestUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.Assert;

public class JSON_Validator {
	
	
	public static void Compare_JSON(String response, String expected) throws IOException {
		
		Read_Response(reponse);

		 }
	
	public static void Read_Response() {
		
	}
		 BufferedReader bufferedReader = new BufferedReader(new FileReader((System.getProperty("user.dir") + "\\Resources\\Responses\\" + response)));
		 
		  StringBuffer stringBuffer = new StringBuffer();
		  String line = null;
		 
		  while((line =bufferedReader.readLine())!=null){
		 
		   stringBuffer.append(line).append("\n");
		  }
		   
		  System.out.println("dsdadsadadsaddas"+stringBuffer);
	}
	

	
//public static void Compare_JSON(String response, String expected) throws IOException {
//	
//	 BufferedReader bufferedReader = new BufferedReader(new FileReader((System.getProperty("user.dir") + "\\Resources\\Responses\\" + response)));
//	 
//	  StringBuffer stringBuffer = new StringBuffer();
//	  String line = null;
//	 
//	  while((line =bufferedReader.readLine())!=null){
//	 
//	   stringBuffer.append(line).append("\n");
//	  }
//	   
//	  System.out.println("dsdadsadadsaddas"+stringBuffer);
//	 }
