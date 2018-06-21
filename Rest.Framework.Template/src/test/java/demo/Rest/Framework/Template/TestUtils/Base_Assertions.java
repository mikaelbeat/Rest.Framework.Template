package demo.Rest.Framework.Template.TestUtils;

import org.testng.Assert;

import io.restassured.response.Response;

public class Base_Assertions {
	
	public static void Verify_True(boolean flag) {
		Assert.assertTrue(flag);
	}
	
	public static void Verify_False(boolean flag) {
		Assert.assertTrue(flag);
	}
	
	public static void Verify_Status_Code(Response response, int statusCode) {
		Assert.assertEquals(Test_Utils.Get_Status_Code(response), statusCode);
	}
	
	public static void Verify_Status_Code(Response response, String statusMessage) {
		Assert.assertEquals(Test_Utils.Get_Status_Code(response), statusMessage);
	}

}