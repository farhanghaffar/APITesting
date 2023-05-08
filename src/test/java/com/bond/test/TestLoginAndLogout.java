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

public class TestLoginAndLogout extends BaseClass {
	CreateBondPage syncSubmissionPage;
	
	@Test(groups = { "UI" })
	public void LoginAndLogout() {
		Status testStatus = Status.PASS;
		boolean flowUi = true;
		boolean flowApi = false;
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		String testName = "LoginAndLogout";
		try {
			initConfiguration();
			syncSubmissionPage = new CreateBondPage();

			map.put("<b>***************Verify Login And Logout***************</b>", syncSubmissionPage.verifyLoginAndLogout(flowUi,flowApi));

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
				addTestStepsIntoReport(testStatus, map, testName,"Login And Logout from BCP");
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}catch(Error e) {
				e.printStackTrace();
				
			}
			
		}
		
	}

	
}