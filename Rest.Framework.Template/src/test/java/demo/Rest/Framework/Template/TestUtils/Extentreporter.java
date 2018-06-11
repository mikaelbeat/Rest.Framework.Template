package demo.Rest.Framework.Template.TestUtils;

import com.relevantcodes.extentreports.ExtentReports;

public class Extentreporter {
	
	public static ExtentReports reportResult() {
		ExtentReports extent;
		String Path = System.getProperty("user.dir")+"\\Reports\\Report.html";
		extent = new ExtentReports(Path, false);
		return extent;

	}

}