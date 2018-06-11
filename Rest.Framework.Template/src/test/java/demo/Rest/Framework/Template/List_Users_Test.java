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
import demo.Rest.Framework.Template.TestUtils.REST_Calls;
import demo.Rest.Framework.Template.TestUtils.Test_Utils;
import io.restassured.response.Response;

public class List_Users_Test {
	
	Response response;
	private static Logger log = LogManager.getLogger(List_Users_Test.class.getName());
	ExtentReports report;
	ExtentTest test;
	String testName = "List_Users_Test.json";

	
	@Test(testName="List Users")
	public void Login() throws IOException {
		
		report = Extentreporter.reportResult();
		test = report.startTest("Login");
		
		log.info("*** STARTING LIST USERS TEST ***");
		test.log(LogStatus.INFO, "Sending GET request");
		response = REST_Calls.GET_Request("https://reqres.in/api/users?page=2");
		log.info("*** RESPONSE *** " + response.getBody().asString());
		String strResponse = Test_Utils.Get_Response_String(response);
		test.log(LogStatus.INFO, "Response: " + strResponse);
		File_Handler.saveResponse(testName, strResponse);
		test.log(LogStatus.INFO, "Verifying response code");
		Base_Assertions.Verify_Status_Code(response, 200);
		JSON_Validator.Compare_JSON("List_Users_Test.json", "List_Users_Test.json");
		
		report.endTest(test);
		report.flush();
	}

}
