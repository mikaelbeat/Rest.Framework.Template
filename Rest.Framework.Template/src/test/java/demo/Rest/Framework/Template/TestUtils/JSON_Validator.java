package demo.Rest.Framework.Template.TestUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import demo.Rest.Framework.Template.Update;

public class JSON_Validator {
	
	private static Logger log = LogManager.getLogger(Update.class.getName());

	public static void Compare_JSON(String response, String expected) throws IOException {
		System.out.println("RESPONSE: " + (Read_Response(response)));
		System.out.println("EXPECTED: " + (Read_Expected(expected)));
		Assert.assertEquals(Read_Response(response), Read_Expected(expected));
		log.info("*** RESPONSE ASSERTED ***");
	}
	
	public static String Read_Response(String fileName) throws IOException {
		log.info("*** RESPONSE FILE READ ***");
		String filePath = System.getProperty("user.dir") + "\\Resources\\Responses\\" + fileName;
		return new String(Files.readAllBytes(Paths.get(filePath)));
		
	}
	
	public static String Read_Expected(String fileName) throws IOException {
		log.info("*** EXPECTED FILE READ ***");
		String filePath = System.getProperty("user.dir") + "\\Resources\\Expected\\" + fileName;
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}
}