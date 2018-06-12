package demo.Rest.Framework.Template.TestUtils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class URL {
	
	private static Logger log = LogManager.getLogger(URL.class.getName());
	
	public static final String URI = "https://reqres.in/";
	
	public static String getURI() {
		log.info("*** BASE URI *** " + URI);
		return URI;
	}
	
	public static String getURI(String resource) {
		log.info("*** FULL URI *** " + URI + resource);
		return URI + resource;
	}

}