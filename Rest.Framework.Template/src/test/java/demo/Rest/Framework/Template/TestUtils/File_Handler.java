package demo.Rest.Framework.Template.TestUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



public class File_Handler {
	
	static String location = System.getProperty("user.dir") + "\\Resources\\Responses\\";

	public static String getRequest(String fileName) throws IOException {
		String filePath = System.getProperty("user.dir") + "\\Resources\\Payloads\\" + fileName;
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}
	
	public static String getResponse(String fileName) throws IOException {
		String filePath = System.getProperty("user.dir") + "\\Resources\\Responses\\" + fileName;
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}
	
	public static String getExpected(String fileName) throws IOException {
		String filePath = System.getProperty("user.dir") + "\\Resources\\Expected\\" + fileName;
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}
	
	public static void saveResponse(String filename, String response) throws IOException {
		File file = new File(location+filename);
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(response);
		bw.close();
	}
	
	
}
