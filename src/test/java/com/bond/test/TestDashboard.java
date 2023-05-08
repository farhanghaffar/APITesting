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

public class TestDashboard extends BaseClass {
	LoginPage lp;
	DashboardPage dashboardPage;
	@Test (groups = {"UI"}) 
	public void TC_ID_12_WhileloggedinVerifyScenariosMenuButton() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();		
		Status testStatus = Status.PASS;
		String TestCaseID = "76";
		Utilities.count+=1;
		String desc ="";
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
			desc = "<a href='"+testRail_URL+""+TestCaseID+"'>While loggedin Verify Scenarios Menu Button </a>";
			dashboardPage = new DashboardPage();
			
			map.put("<b>Step 1 :***************While loggedin Verify Scenarios Menu Button***************</b>",dashboardPage.WhileloggedinVerifyScenariosMenuButton());
			
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
		
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "WhileloggedinVerifyScenariosMenuButton",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}

	@Test (groups = {"UI"}) 
	public void TC_ID_13_WhileLoggedinVerifyBondBuyerMenuButton() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "77";
		Utilities.count+=1;
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
			desc  = "<a href='"+testRail_URL+""+TestCaseID+"'>While Loggedin Verify Bond Buyer Menu Button </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************While Loggedin Verify Bond Buyer Menu Button***************</b>",dashboardPage.WhileLoggedinVerifyBondBuyerMenuButton());
			
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
		
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "WhileLoggedinVerifyBondBuyerMenuButton",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}

	@Test (groups = {"UI"}) 
	public void TC_ID_14_WhileLoggedinVerifySynchroniseSubmissionsMenuButton() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "78";
		Utilities.count+=1;
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
			desc = "<a href='"+testRail_URL+""+TestCaseID+"'>While Loggedin Verify Synchronise Submissions Menu Button </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************While Logged in Verify Synchronise Submissions Menu Button***************</b>",dashboardPage.WhileLoggedinVerifySynchroniseSubmissionsMenuButton());

			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
		
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "WhileLoggedinVerifySynchroniseSubmissionsMenuButton",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}

	@Test (groups = {"UI"}) 
	public void TC_ID_15_WhileLoggedinVerifySyncPersonalDataMenuButton() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "79";
		Utilities.count+=1;
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
			desc = "<a href='"+testRail_URL+""+TestCaseID+"'>While Logged in Verify Sync Personal Data Menu Button </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************While Logged in Verify Sync Personal Data Menu Button***************</b>",dashboardPage.WhileLoggedinVerifySyncPersonalDataMenuButton());

			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
		
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "WhileLoggedinVerifySyncPersonalDataMenuButton",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}
	
	
	@Test (groups = {"UI"}) 
	public void TC_ID_16_WhileLoggedinVerifySyncPostPurchaseMenuButton() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "80";
		Utilities.count+=1;
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
			desc = "<a href='"+testRail_URL+""+TestCaseID+"'>While Logged in Verify Sync Post Purchase Menu Button </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************While Logged in Verify Sync Post Purchase Menu Button***************</b>",dashboardPage.WhileLoggedinVerifySyncPostPurchaseMenuButton());
		

			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
		
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "WhileLoggedinVerifySyncPostPurchaseMenuButton",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}	
	
	
	@Test (groups = {"UI"}) 
	public void TC_ID_17_WhileLoggedinVerifySyncSettlementDataMenuButton() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "81";
		Utilities.count+=1;
		String desc ="";
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
			desc = "<a href='"+testRail_URL+""+TestCaseID+"'>While Logged in Verify Sync Settlement Data Menu Button </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************While Logged in Verify Sync Settlement Data Menu Button***************</b>",dashboardPage.WhileLoggedinVerifySyncSettlementDataMenuButton());
		

			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
		
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "WhileLoggedinVerifySyncSettlementDataMenuButton",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}	

	@Test (groups = {"UI"}) 
	public void TC_ID_18_VerifyTheHomeBuyerSectionFromDetailScreenOfScenarios() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "82";
		Utilities.count+=1;
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
			desc = "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The Home Buyer Section From Detail Screen Of Scenarios </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The Home Buyer Section From Detail Screen Of Scenarios***************</b>",dashboardPage.VerifyTheHomeBuyerSectionFromDetailScreenOfScenarios());
		

		
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyTheHomeBuyerSectionFromDetailScreenOfScenarios",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}	

	@Test (groups = {"UI"}) 
	public void TC_ID_19_VerifyTheHomeBuyerPartySectionFromDetailScreenOfScenarios() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "83";
		Utilities.count+=1;
		String desc ="";
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
			desc = "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The Home Buyer Party Section From Detail Screen Of Scenarios </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The Home Buyer Party Section From Detail Screen Of Scenarios***************</b>",dashboardPage.VerifyTheHomeBuyerPartySectionFromDetailScreenOfScenarios());
		

			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyTheHomeBuyerPartySectionFromDetailScreenOfScenarios",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}	


	@Test (groups = {"UI"}) 
	public void TC_ID_20_VerifyTheHomebuyerAccountDetailsSectionFromDetailScreenOfScenarios() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "84";
		Utilities.count+=1;
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
			 desc = "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The Homebuyer Account Details Section From Detail Screen Of Scenarios </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The Homebuyer Account Details Section From Detail Screen Of Scenarios***************</b>",dashboardPage.VerifyTheHomebuyerAccountDetailsSectionFromDetailScreenOfScenarios());
		
			
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyTheHomebuyerAccountDetailsSectionFromDetailScreenOfScenarios",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}	


	@Test (groups = {"UI"}) 
	public void TC_ID_21_VerifyTheHomebuyerPersonalDetailsSectionFromDetailScreenOfScenarios() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "85";
		Utilities.count+=1;
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
			 desc = "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The Homebuyer Personal Details Section From Detail Screen Of Scenarios </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The Homebuyer Personal Details Section From Detail Screen Of Scenarios***************</b>",dashboardPage.VerifyTheHomebuyerPersonalDetailsSectionFromDetailScreenOfScenarios());
		

			
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyTheHomebuyerPersonalDetailsSectionFromDetailScreenOfScenarios",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}	
	

	@Test (groups = {"UI"}) 
	public void TC_ID_22_VerifyThePropertySectionFromDetailScreenOfScenarios() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "86";
		Utilities.count+=1;
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
			desc = "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The Property Section From Detail Screen Of Scenarios </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The Property Section From Detail Screen Of Scenarios***************</b>",dashboardPage.VerifyThePropertySectionFromDetailScreenOfScenarios());
		

			
			
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyThePropertySectionFromDetailScreenOfScenarios",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}	

	@Test (groups = {"UI"}) 
	public void TC_ID_23_VerifyThePropertyClassSectionFromDetailScreenOfScenarios() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "87";
		Utilities.count+=1;
		String desc ="";
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
			desc =  "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The Property Class Section From Detail Screen Of Scenarios </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The Property Class Section From Detail Screen Of Scenarios***************</b>",dashboardPage.VerifyThePropertyClassSectionFromDetailScreenOfScenarios());
		
			
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyThePropertyClassSectionFromDetailScreenOfScenarios",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}
	
	@Test (groups = {"UI"}) 
	public void TC_ID_24_VerifyTheScenarioSectionFromDetailScreenOfScenarios() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "88";
		Utilities.count+=1;
		String desc ="";
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
			desc =   "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The Scenario Section From Detail Screen Of Scenarios </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The Scenario Section From Detail Screen Of Scenarios***************</b>",dashboardPage.VerifyTheScenarioSectionFromDetailScreenOfScenarios());
		
			
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyTheScenarioSectionFromDetailScreenOfScenarios",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}

	@Test (groups = {"UI"}) 
	public void TC_ID_25_VerifyTheBackButtonFromDetailScreenOfScenarios() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "89";
		Utilities.count+=1;
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
			desc =  "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The Back Button From Detail Screen Of Scenarios </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The Back Button From Detail Screen Of Scenarios***************</b>",dashboardPage.VerifyTheBackButtonFromDetailScreenOfScenarios());
		
			
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyTheBackButtonFromDetailScreenOfScenarios",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}


	@Test (groups = {"UI"}) 
	public void TC_ID_26_VerifyThePaginationFromTheSynchronizedScenariosScreen() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "90";
		Utilities.count+=1;
		String desc ="";
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
			desc = "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The Pagination From The Synchronized Scenarios Screen </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The Pagination From The Synchronized Scenarios Screen***************</b>",dashboardPage.VerifyThePaginationFromTheSynchronizedScenariosScreen());
		
			
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyThePaginationFromTheSynchronizedScenariosScreen",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}


	@Test (groups = {"UI"}) 
	public void TC_ID_27_VerifyTheScenarioHashSearchFilterFromTheSynchronizedScenariosScreen() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "91";
		Utilities.count+=1;
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
			desc = "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The Scenario Hash Search Filter From The Synchronized Scenarios Screen </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The Scenario Hash Search Filter From The Synchronized Scenarios Screen***************</b>",dashboardPage.VerifyTheScenarioHashSearchFilterFromTheSynchronizedScenariosScreen());
		
			
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
//			
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyTheScenarioHashSearchFilterFromTheSynchronizedScenariosScreen",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}

	@Test (groups = {"UI"}) 
	public void TC_ID_28_VerifyTheHomeBuyerHashSearchFilterFromTheSynchronizedScenariosScreen() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "92";
		Utilities.count+=1;
		String desc ="";
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
			desc =  "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The HomeBuyer HashSearch Filter From The Synchronized Scenarios Screen </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The Home BuyerHash Search Filter From The Synchronized Scenarios Screen***************</b>",dashboardPage.VerifyTheHomeBuyerHashSearchFilterFromTheSynchronizedScenariosScreen());
		
			
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
//			
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyTheHomeBuyerHashSearchFilterFromTheSynchronizedScenariosScreen",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}


	@Test (groups = {"UI"}) 
	public void TC_ID_29_VerifyTheNameSearchFilterFromTheSynchronizedScenariosScreen() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "93";
		Utilities.count+=1;

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
			desc =  "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The 'Name' Search Filter From The Synchronized Scenarios Screen </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The Name Search Filter From The Synchronized Scenarios Screen***************</b>",dashboardPage.VerifyTheNameSearchFilterFromTheSynchronizedScenariosScreen());
		
			
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyTheHomeBuyerNameSearchFilterFromTheSynchronizedScenariosScreen",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}


	@Test (groups = {"UI"}) 
	public void TC_ID_30_VerifyTheHomeBuyerEmailSearchFilterFromTheSynchronizedScenariosScreen() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "94";
		Utilities.count+=1;

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
			desc =  "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The HomeBuyer Email Search Filter From The Synchronized Scenarios Screen </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The HomeBuyer Email Search Filter From The Synchronized Scenarios Screen***************</b>",dashboardPage.VerifyTheHomeBuyerEmailSearchFilterFromTheSynchronizedScenariosScreen());
		
			
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyTheHomeBuyerEmailSearchFilterFromTheSynchronizedScenariosScreen",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}


	@Test (groups = {"UI"}) 
	public void TC_ID_31_VerifyTheStatusSearchFilterFromTheSynchronizedScenariosScreen() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "95";
		Utilities.count+=1;

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
			desc =  "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The Status Search Filter From The Synchronized Scenarios Screen </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The Status Search Filter From The Synchronized Scenarios Screen***************</b>",dashboardPage.VerifyTheStatusSearchFilterFromTheSynchronizedScenariosScreen());
		

			
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyTheStatusSearchFilterFromTheSynchronizedScenariosScreen",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}



	@Test (groups = {"UI"}) 
	public void TC_ID_38_VerifyTheScenarioHashPlaceholderFromTheSynchronizedScenariosScreen() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "102";
		Utilities.count+=1;

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
			desc =  "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The Scenario Hash Placeholder From The Synchronized Scenarios Screen </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The Scenario Hash Placeholder From The Synchronized Scenarios Screen***************</b>",dashboardPage.VerifyTheScenarioHashPlaceholderFromTheSynchronizedScenariosScreen());
		
			
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyTheScenarioHashPlaceholderFromTheSynchronizedScenariosScreen",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}



	@Test (groups = {"UI"}) 
	public void TC_ID_39_VerifyTheHomeBuyerHashPlaceholderFromTheSynchronizedScenariosScreen() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "103";
		Utilities.count+=1;

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
			desc =  "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The Home Buyer Hash Placeholder From The Synchronized Scenarios Screen </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The Home Buyer Hash Placeholder From The Synchronized Scenarios Screen***************</b>",dashboardPage.VerifyTheHomeBuyerHashPlaceholderFromTheSynchronizedScenariosScreen());
		
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyTheHomeBuyerHashPlaceholderFromTheSynchronizedScenariosScreen",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}

	
	@Test (groups = {"UI"}) 
	public void TC_ID_40_VerifyTheNamePlaceholderFromTheSynchronizedScenariosScreen() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "104";
		Utilities.count+=1;

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
			desc =  "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The Name Placeholder From The Synchronized Scenarios Screen </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The Name Placeholder From The Synchronized Scenarios Screen***************</b>",dashboardPage.VerifyTheNamePlaceholderFromTheSynchronizedScenariosScreen());

			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyTheNamePlaceholderFromTheSynchronizedScenariosScreen",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}
	

	@Test (groups = {"UI"}) 
	public void TC_ID_41_VerifyTheEmailPlaceholderFromTheSynchronizedScenariosScreen() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "105";
		Utilities.count+=1;

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
			desc =  "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The Email Placeholder From The Synchronized Scenarios Screen </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The Email Placeholder From The Synchronized Scenarios Screen***************</b>",dashboardPage.VerifyTheEmailPlaceholderFromTheSynchronizedScenariosScreen());
		

			
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyTheEmailPlaceholderFromTheSynchronizedScenariosScreen",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}


	@Test (groups = {"UI"}) 
	public void TC_ID_42_VerifyTheStatusPlaceholderFromTheSynchronizedScenariosScreen() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "106";
		Utilities.count+=1;

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
			desc =  "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The Status Placeholder From The Synchronized Scenarios Screen </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The Status Placeholder From The Synchronized Scenarios Screen***************</b>",dashboardPage.VerifyTheStatusPlaceholderFromTheSynchronizedScenariosScreen());
		

			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyTheStatusPlaceholderFromTheSynchronizedScenariosScreen",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}
	

	@Test (groups = {"UI"}) 
	public void TC_ID_43_VerifyTheHomeBuyerAndScenarioHashPlaceholderFromThSynchroniseSubmissionsScreen() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "107";
		Utilities.count+=1;

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
			desc =  "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The HomeBuyer And Scenario Hash Placeholder From The Synchronise Submissions Screen </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The HomeBuyer And Scenario Hash Placeholder From The Synchronise Submissions Screen***************</b>",dashboardPage.VerifyTheHomeBuyerAndScenarioHashPlaceholderFromThSynchroniseSubmissionsScreen());
		
			
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyTheHomeBuyerAndScenarioHashPlaceholderFromThSynchroniseSubmissionsScreen",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}
	

	@Test (groups = {"UI"}) 
	public void TC_ID_44_VerifyTheHomeBuyerNamePlaceholderFromTheSynchroniseSubmissionsScreen() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "108";
		Utilities.count+=1;

		String desc ="";
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
			desc =  "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The HomeBuyer Name Placeholder From The Synchronise Submissions Screen </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The HomeBuyer Name Placeholder From The Synchronise Submissions Screen***************</b>",dashboardPage.VerifyTheHomeBuyerNamePlaceholderFromTheSynchroniseSubmissionsScreen());
		
			
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyTheHomeBuyerNamePlaceholderFromTheSynchroniseSubmissionsScreen",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}
	

	@Test (groups = {"UI"}) 
	public void TC_ID_45_VerifyTheEmailPlaceholderFromTheSynchroniseSubmissionsScreen() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "109";
		Utilities.count+=1;

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
			desc =  "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The Email Placeholder From The Synchronise Submissions Screen </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The Email Placeholder From The Synchronise Submissions Screen***************</b>",dashboardPage.VerifyTheEmailPlaceholderFromTheSynchroniseSubmissionsScreen());
		
	
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyTheEmailPlaceholderFromTheSynchroniseSubmissionsScreen",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}

	@Test (groups = {"UI"}) 
	public void TC_ID_46_VerifyTheScenarioNamePlaceholderFromTheSynchroniseSubmissionsScreen() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "110";
		Utilities.count+=1;

		String desc ="";
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
			desc =  "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The Scenario Name Placeholder From The Synchronise Submissions Screen </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The Scenario Name Placeholder From The Synchronise Submissions Screen***************</b>",dashboardPage.VerifyTheScenarioNamePlaceholderFromTheSynchroniseSubmissionsScreen());
		
			
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyTheScenarioNamePlaceholderFromTheSynchroniseSubmissionsScreen",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}

	@Test (groups = {"UI"}) 
	public void TC_ID_47_VerifyTheScenarioHashPlaceholderFromTheSynchronisePersonalDataScreen() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "111";
		Utilities.count+=1;

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
			desc =  "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The Scenario Hash Placeholder From The Synchronise Personal Data Screen </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The Scenario Hash Placeholder From The Synchronise Personal Data Screen***************</b>",dashboardPage.VerifyTheScenarioHashPlaceholderFromTheSynchronisePersonalDataScreen());
		
			
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyTheScenarioHashPlaceholderFromTheSynchronisePersonalDataScreen",desc);
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}

	@Test (groups = {"UI"}) 
	public void TC_ID_48_VerifyTheHomeBuyerHashPlaceholderFromTheSynchronisePersonalDataScreen() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		
		Status testStatus = Status.PASS;
		String TestCaseID = "112";
		Utilities.count+=1;

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
			desc =  "<a href='"+testRail_URL+""+TestCaseID+"'>Verify The HomeBuyer Hash Placeholder From The Synchronise Personal Data Screen </a>";
			dashboardPage = new DashboardPage();
			
			
			map.put("<b>Step 1 :***************Verify The HomeBuyer Hash Placeholder From The Synchronise Personal Data Screen***************</b>",dashboardPage.VerifyTheHomeBuyerHashPlaceholderFromTheSynchronisePersonalDataScreen());
		
			
			Assert.assertTrue(IdentifyTestStatus(map));
			Utilities.statusCode.set(Utilities.count, "1");
			Utilities.comments.set(Utilities.count, "Passed");
	} catch (Exception e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		dashboardPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "VerifyTheHomeBuyerHashPlaceholderFromTheSynchronisePersonalDataScreen",desc);
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
