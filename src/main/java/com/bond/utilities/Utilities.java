package com.bond.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.bond.base.BaseClass;
public class Utilities extends BaseClass {

	public static int count=-1;
	public static String screenshotPath;
	public static String screenshotName;
	public static ArrayList<String> testId = new ArrayList<>();
	public static ArrayList<String> statusCode = new ArrayList<>();
	public static ArrayList<String> comments = new ArrayList<>();
	public static String TestRail_AssignToID;
	public static Long suite_id;
	public static APIClient client = null;
	

	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));

	}

	
	public static boolean isTestRunnable(String testName, ExcelReader excel){
		
		String sheetName="test_suite";
		int rows = excel.getRowCount(sheetName);
		
		
		for(int rNum=2; rNum<=rows; rNum++){
			
			String testCase = excel.getCellData(sheetName, "TCID", rNum);
			
			if(testCase.equalsIgnoreCase(testName)){
				
				String runmode = excel.getCellData(sheetName, "Runmode", rNum);
				
				if(runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}
			
			
		}
		return false;
	}
	
	
	
	public static void updateTestCaseAndCloseDriverWithMultipleComments(WebDriver driver, ArrayList<String> caseId,
			ArrayList<String> statusCode, ArrayList<String> comments, String assignTo) {
		
		Map<String, String> data = new HashMap<String, String>();
		try {
			for (int i = 0; i < caseId.size(); i++) {
				data.put("status_id", statusCode.get(i));
				data.put("comment", comments.get(i));
				data.put("assignedto_id", assignTo);
				
					client.sendPost("add_result_for_case/" + suite_id + "/" + caseId.get(i), data);
				

			}
			caseId.clear();
			statusCode.clear();
			comments.clear();
			// driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	public static boolean validateString(String str) {
		boolean validate = false;
		try {
			if (!str.isEmpty() && str != null && !str.equalsIgnoreCase("") && !str.equalsIgnoreCase("null")
					&& !str.equalsIgnoreCase(" ") && !str.equalsIgnoreCase("NA")) {
				validate = true;
			}
		} catch (Exception e) {
			validate = false;
		}
		return validate;
	}
	
	public static void AddTest_IntoReportasd(String TestName, String TestDescription, String TestCatagory,
			ArrayList<String> test_steps) {

		//test = extent.startTest(TestName, TestDescription).assignCategory(TestCatagory).assignCategory("Regression");
		for (int i = 0; i < 1; i++) {

			if (test_steps.get(i).contains("Failed") || test_steps.get(i).contains("Assertion")) {
			//	test.log(LogStatus.FAIL, test_steps.get(i));
			} else {

				//test.log(LogStatus.PASS, test_steps.get(i));
			}
		}

	}


	
}
