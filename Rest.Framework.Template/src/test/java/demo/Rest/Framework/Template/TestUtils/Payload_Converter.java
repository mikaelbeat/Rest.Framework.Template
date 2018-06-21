package demo.Rest.Framework.Template.TestUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Payload_Converter {
	
	private static Logger log = LogManager.getLogger(Payload_Converter.class.getName());
	
	public static String Convert_Payload(String filename) {
		log.info("*** PAYLOAD CONVERTED TO STRING ***");
		String filePath = System.getProperty("user.dir")+"\\Resources\\Payloads\\"+filename;
		try {
			return new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			log.error(e);
			return null;
		}
	}

}