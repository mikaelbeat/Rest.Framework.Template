package demo.Rest.Framework.Template;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import demo.Rest.Framework.Template.TestUtils.Base_Assertions;
import demo.Rest.Framework.Template.TestUtils.Extentreporter;
import demo.Rest.Framework.Template.TestUtils.File_Handler;
import demo.Rest.Framework.Template.TestUtils.JSON_Asserter;
import demo.Rest.Framework.Template.TestUtils.Payload_Converter;
import demo.Rest.Framework.Template.TestUtils.REST_Calls;
import demo.Rest.Framework.Template.TestUtils.Test_Utils;
import demo.Rest.Framework.Template.TestUtils.URL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Update {
	
	Response response;
	private static Logger log = LogManager.getLogger(Update.class.getName());
	ExtentReports report;
	ExtentTest test;
	String testName = "Update.json";

	
	@Test(testName="Register")
	public void Login() throws IOException {
		
		report = Extentreporter.reportResult();
		test = report.startTest("Login");
		
		log.info("*** STARTING UPDATE TEST ***");
		test.log(LogStatus.INFO, "Getting payload");
		String loginPayload = Payload_Converter.Convert_Payload("Update.json");
		String endpointURI = URL.getURI("api/users/2");
		test.log(LogStatus.INFO, "Sending PUT request");
		response = REST_Calls.PUT_Request(endpointURI, loginPayload);
		log.info("*** RESPONSE *** " + response.getBody().asString());
		String strResponse = Test_Utils.Get_Response_String(response);
		test.log(LogStatus.INFO, "Response: " + strResponse);
		File_Handler.saveResponse(testName, strResponse);
		test.log(LogStatus.INFO, "Verifying response code");
		Base_Assertions.Verify_Status_Code(response, 200);
		test.log(LogStatus.INFO, "Verifying response");
		JsonPath jsonRes = new JsonPath(strResponse);
		JSON_Asserter.Assert_Field(jsonRes, "name.value","morpheus");
		JSON_Asserter.Assert_Field(jsonRes, "job.value","zion resident");
		report.endTest(test);
		report.flush();
	}

}