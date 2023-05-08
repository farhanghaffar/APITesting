package com.bond.test;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.bond.base.BaseClass;
import com.bond.pages.CreateBondPage;
import com.bond.utilities.TestSteps;

public class TestCreateBond extends BaseClass {
	CreateBondPage syncSubmissionPage;
	
	@Test(groups = { "UI" })
	public void CreateBond() {
		Status testStatus = Status.PASS;
		boolean flowUi = true;
		boolean flowApi = false;
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		try {
			initConfiguration();
			syncSubmissionPage = new CreateBondPage();

			map.put("<b>Step 1 :***************Creating Scenario MBW***************</b>", syncSubmissionPage.addDataIntoMBWBackend());
			
			map.put("<b>Step 2 :***************Verify data on 'Sync Submissions' Page, 'Scenarios' Page And 'Home Buyer' Page***************</b>", syncSubmissionPage.verifyDataOnSyncSubmissionsPage(flowUi,flowApi));
			
			map.put("<b>Step 3 :***************Update KYC***************</b>", syncSubmissionPage.verifyDataOnSyncPersonalPage(flowUi,flowApi));
//		
//			map.put("<b>Step 4 :***************Verify data on ESP***************</b>", syncSubmissionPage.espStep4(flowUi,flowApi));
//			
//			map.put("<b>Step 5 :***************Approve Prelim Con-Approval, And Adding Data Property Purchase Details***************</b>", syncSubmissionPage.addPropertyPurchaseDetailsStep5(flowUi,flowApi));
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
				addTestStepsIntoReport(testStatus, map, "CreateBondThroughUI","Create Bond Through UI");
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}catch(Error e) {
				e.printStackTrace();
				
			}
			
		}
		
	}

	
}