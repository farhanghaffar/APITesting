package com.bond.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.jaxen.expr.Step;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bond.base.BaseClass;
import com.bond.base.PropertiesReader;
import com.bond.errorCollectors.ErrorCollector;
import com.bond.pages.DashboardPage;
import com.bond.pages.LoginPage;
import com.bond.pages.LogoutPage;
import com.bond.utilities.TestSteps;
import com.bond.utilities.Utilities;

import net.bytebuddy.asm.Advice.OnDefaultValue;

public class TestLogout extends BaseClass {
	LoginPage lp;
	DashboardPage homePage;
	LogoutPage logoutPage;

	@Test(groups = { "UI" })
	public void TC_ID_11_WhileLoggedinSuccessfullyVerifyLogoutButton() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();

		Status testStatus = Status.PASS;
		String TestCaseID = "75";
		Utilities.count += 1;
		String desc = "";
		if (!Utilities.validateString(TestCaseID)) {
			Utilities.testId.add(TestCaseID);
			Utilities.statusCode.add("5");
		} else {
			String[] testcase = TestCaseID.split("\\|");
			for (int i = 0; i < testcase.length; i++) {
				Utilities.testId.add(testcase[i]);
				Utilities.statusCode.add("5");
				Utilities.comments.add("Failed");
			}
		}

		try {
			initConfiguration();
			String testRail_URL = getProPertyVal("TestRailTestCaseURL");			
			desc = "<a href='"+testRail_URL+""+TestCaseID+"'>While Loggedin Successfully Verify Logout Button</a>";
			logoutPage = new LogoutPage();

			map.put("<b>Step 1 :***************While Loggedin Successfully Verify Logout Button***************</b>",logoutPage.WhileLoggedinSuccessfullyVerifyLogoutButton());

			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");

		} catch (Exception e) {
			e.printStackTrace();
			logoutPage.addSubStep(subSteps, captureSS(), Status.FAIL);
			map.put("Exception" + e.toString(), subSteps);
			testStatus = Status.FAIL;
			Assert.assertFalse(true);
		} catch (Error e) {
			e.printStackTrace();
			logoutPage.addSubStep(subSteps, captureSS(), Status.FAIL);
			map.put("Error" + e.toString(), subSteps);
			Assert.assertFalse(true);
		} finally {
			driver.close();
			try {
				addTestStepsIntoReport(testStatus, map, "WhileLoggedinSuccessfullyVerifyLogoutButton", desc);
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
