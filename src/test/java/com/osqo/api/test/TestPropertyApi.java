package com.osqo.api.test;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bond.base.BaseClass;
import com.bond.pages.DashboardPage;
import com.bond.pages.LoginPage;
import com.bond.pages.CreateBondPage;
import com.bond.pages.OsqoApiPage;
import com.bond.pages.CreateBondApiPage;
import com.bond.utilities.TestSteps;
import com.bond.utilities.Utilities;
import com.sun.mail.imap.Utility;


public class TestPropertyApi extends BaseClass {
	CreateBondPage syncSubmissionPage;
	CreateBondApiPage syncSubmissionApi;
	OsqoApiPage osqoApiPage;
		

	String testName = null;
	
	@Test(groups = { "UI" })
	public void VerifyAggregatorApiInHLApi() {
		Status testStatus = Status.PASS;
		boolean flowUi = false;
		boolean flowApi = true;
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		try {
			initConfiguration();
			osqoApiPage = new OsqoApiPage();
			syncSubmissionPage = new CreateBondPage();
			syncSubmissionApi = new CreateBondApiPage();
			
			map.put("<b>***************Property Request***************</b>",osqoApiPage.createProperty());
			
		} catch (Exception e) {
			e.printStackTrace();
			syncSubmissionPage.addSubStep(subSteps, captureSS(), Status.FAIL);
			map.put("Exception" + e.toString(), subSteps);
			testStatus = Status.FAIL;
			Assert.assertFalse(true);
		} catch (Error e) {
			e.printStackTrace();
			syncSubmissionPage.addSubStep(subSteps, captureSS(), Status.FAIL);
			map.put("Error" + e.toString(), subSteps);
			Assert.assertFalse(true);
		} finally {
			driver.close();
			try {
				addTestStepsIntoReport(testStatus, map, "Property Request And Verify On HL","");

			} catch (Exception e) {
				e.printStackTrace();

			} catch (Error e) {
				e.printStackTrace();

			}

		}

	}
	
//	@AfterClass(alwaysRun = true)
//	public void closeDriver() {
//		driver.quit();
//		for(String  ID : Utilities.testId) {
//			printString("ID:   "+ID);
//		}
//		for(String  Status : Utilities.statusCode) {
//			printString("Status:   "+Status);
//		}
//		for(String  COmment : Utilities.comments) {
//			printString("Comment:   "+COmment);
//		}
//		Utilities.updateTestCaseAndCloseDriverWithMultipleComments(driver, Utilities.testId, Utilities.statusCode,
//				Utilities.comments, Utilities.TestRail_AssignToID);
//	}

}