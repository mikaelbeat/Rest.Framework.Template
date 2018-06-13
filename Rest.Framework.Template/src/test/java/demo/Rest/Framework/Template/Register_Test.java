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
import demo.Rest.Framework.Template.TestUtils.JSON_Validator;
import demo.Rest.Framework.Template.TestUtils.Payload_Converter;
import demo.Rest.Framework.Template.TestUtils.REST_Calls;
import demo.Rest.Framework.Template.TestUtils.Test_Utils;
import demo.Rest.Framework.Template.TestUtils.URL;
import io.restassured.response.Response;

public class Register_Test {
	
	Response response;
	private static Logger log = LogManager.getLogger(Register_Test.class.getName());
	ExtentReports report;
	ExtentTest test;
	String testName = "Register.json";

	
	@Test(testName="Register")
	public void Login() throws IOException {
		
		report = Extentreporter.reportResult();
		test = report.startTest("Register");
		
		log.info("*** STARTING REGISTER TEST ***");
		test.log(LogStatus.INFO, "Getting payload");
		String payload = Payload_Converter.Convert_Payload("Register.json");
		String endpointURI = URL.getURI("api/register");
		test.log(LogStatus.INFO, "Sending POST request");
		response = REST_Calls.POST_Request(endpointURI, payload);
		log.info("*** RESPONSE *** " + response.getBody().asString());
		String strResponse = Test_Utils.Get_Response_String(response);
		test.log(LogStatus.INFO, "Response: " + strResponse);
		File_Handler.saveResponse(testName, strResponse);
		test.log(LogStatus.INFO, "Verifying response code");
		Base_Assertions.Verify_Status_Code(response, 201);
		test.log(LogStatus.INFO, "Verifying response");
		JSON_Validator.Compare_JSON("Register.json", "Register.json");
		report.endTest(test);
		report.flush();
	}

}