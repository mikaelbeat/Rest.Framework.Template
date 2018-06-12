package demo.Rest.Framework.Template.TestUtils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import demo.Rest.Framework.Template.Update;
import io.restassured.path.json.JsonPath;

public class JSON_Asserter {
	
	private static Logger log = LogManager.getLogger(Update.class.getName());
	
	public static void Assert_Field(JsonPath jsonRes, String field, String value) {
		log.info("*** FIELD ASSERTED *** " + field);
		Assert.assertEquals(jsonRes.getString(field), value);
	}

}