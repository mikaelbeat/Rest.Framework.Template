package demo.Rest.Framework.Template.TestUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import demo.Rest.Framework.Template.Update;
import io.restassured.response.Response;



public class File_Handler {
	
	private static Logger log = LogManager.getLogger(Update.class.getName());
	
	static String location = System.getProperty("user.dir") + "\\Resources\\Responses\\";

	public static String getRequest(String fileName) throws IOException {
		log.info("*** GETTING REQUEST FILE ***");
		String filePath = System.getProperty("user.dir") + "\\Resources\\Payloads\\" + fileName;
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}
	
	public static String getResponse(String fileName) throws IOException {
		log.info("*** GETTING RESPONSE FILE***");
		String filePath = System.getProperty("user.dir") + "\\Resources\\Responses\\" + fileName;
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}
	
	public static String getExpected(String fileName) throws IOException {
		log.info("*** GETTING EXPECTED FILE ***");
		String filePath = System.getProperty("user.dir") + "\\Resources\\Expected\\" + fileName;
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}
	
	public static void saveResponse(String filename, String response) throws IOException {
		log.info("*** SAVING RESPONSE ***");
		File file = new File(location+filename);
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(response);
		bw.close();
	}
	
	
}
