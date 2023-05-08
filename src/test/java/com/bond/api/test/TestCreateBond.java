package com.bond.api.test;

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
import com.bond.pages.CreateBondApiPage;
import com.bond.utilities.TestSteps;
import com.bond.utilities.Utilities;
import com.sun.mail.imap.Utility;


public class TestCreateBond extends BaseClass {
	CreateBondPage syncSubmissionPage;
	CreateBondApiPage syncSubmissionApi;
	LoginPage lp;
	DashboardPage dashboardPage;

	String testName = null;
	
	@Test(groups = { "UI" })
	public void CreateBondThroughAPI() {
		Status testStatus = Status.PASS;
		boolean flowUi = false;
		boolean flowApi = true;
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		try {
			initConfiguration();
			lp = new LoginPage();
			dashboardPage = new DashboardPage();
			syncSubmissionPage = new CreateBondPage();
			syncSubmissionApi = new CreateBondApiPage();

			map.put("<b>Step 1 :***************Creating Scenario MBW***************</b>",syncSubmissionPage.addDataIntoMBWBackend());

			map.put("<b>Step 2 :***************Verify data on 'Sync Submissions' Page, 'Scenarios' Page And 'Home Buyer' Page***************</b>",syncSubmissionPage.verifyDataOnSyncSubmissionsPage(flowUi, flowApi));

			map.put("<b>Step 3 :***************Update KYC***************</b>",syncSubmissionPage.verifyDataOnSyncPersonalPage(flowUi, flowApi));
			
			map.put("<b>Step 4 :***************Verify data on ESP***************</b>", syncSubmissionPage.espStep4(flowUi,flowApi));
			
			map.put("<b>Step 5 :***************Approve Prelim Con-Approval, And Adding Data Property Purchase Details***************</b>", syncSubmissionPage.addPropertyPurchaseDetailsStep5(flowUi,flowApi));

			Assert.assertTrue(IdentifyTestStatus(map));
			
			
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
				addTestStepsIntoReport(testStatus, map, "CreateBondThroughAPI","hello description");

			} catch (Exception e) {
				e.printStackTrace();

			} catch (Error e) {
				e.printStackTrace();

			}

		}

	}
	@AfterClass(alwaysRun = true)
	public void closeDriver() {
		driver.quit();
		for(String  ID : Utilities.testId) {
			printString("ID:   "+ID);
		}
		for(String  Status : Utilities.statusCode) {
			printString("Status:   "+Status);
		}
		for(String  COmment : Utilities.comments) {
			printString("Comment:   "+COmment);
		}
		Utilities.updateTestCaseAndCloseDriverWithMultipleComments(driver, Utilities.testId, Utilities.statusCode,
				Utilities.comments, Utilities.TestRail_AssignToID);
	}

}