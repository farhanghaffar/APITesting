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
import com.bond.pages.LoginPage;
import com.bond.pages.LogoutPage;
import com.bond.utilities.TestSteps;
import com.bond.utilities.Utilities;

import net.bytebuddy.asm.Advice.OnDefaultValue;

public class TestLogin extends BaseClass {
	LoginPage loginPage;
	LogoutPage logout;

	@Test (groups = {"UI"}) 
	public void loginWithOTPVerification() throws IOException {
		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
		
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		Status testStatus = Status.PASS;
		
		try {
			initConfiguration();
			
			loginPage = new LoginPage();
			
			map.put("<b>Step 1 :***************Login With OTP Verification Code***************</b>",loginPage.loginWithOTPVerificationCode());
			
			Assert.assertTrue(IdentifyTestStatus(map));
//			Utilities.statusCode.set(Utilities.count, "1");
//			Utilities.comments.set(Utilities.count, "Passed");
		
	} catch (Exception e) {
		e.printStackTrace();
		loginPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Exception" + e.toString(), subSteps);
		testStatus = Status.FAIL;
		Assert.assertFalse(true);
	} catch (Error e) {
		e.printStackTrace();
		loginPage.addSubStep(subSteps, captureSS(), Status.FAIL);
		map.put("Error" + e.toString(), subSteps);
		Assert.assertFalse(true);
	} finally {
		driver.close();
		try {
			addTestStepsIntoReport(testStatus, map, "LoginWithOTPVerification","");
		} catch (Exception e) {
			e.printStackTrace();

		} catch (Error e) {
			e.printStackTrace();

		}

	}

	}
	
//	@Test (groups = {"UI"}) 
//	public void TC_ID_1_LoginWithValidUsernameAndValidPassword() throws IOException {
//		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
//		
//		ArrayList<TestSteps> subSteps = new ArrayList<>();
//		Status testStatus = Status.PASS;
//		String TestCaseID = "62";
//		String desc ="";
//		Utilities.count+=1;
//		
//		if (!Utilities.validateString(TestCaseID)) {
//			Utilities.testId.add(TestCaseID);
//			Utilities.statusCode.add("5");
//		} else {
//			String[] testcase = TestCaseID.split("\\|");
//			for (int i = 0; i < testcase.length; i++) {
//				Utilities.testId.add(testcase[i]);
//				Utilities.statusCode.add("5");
//				Utilities.comments.add("Failed");
//			}
//		}
//		try {
//			initConfiguration();
//			String testRail_URL = getProPertyVal("TestRailTestCaseURL");			
//			desc = "Description : <a href='"+testRail_URL+""+TestCaseID+"'> Login With Valid Username And Valid Password </a>";
//			loginPage = new LoginPage();
//			
//			map.put("<b>Step 1 :***************Login With Valid Username And Valid Password***************</b>",loginPage.loginWithValidCradintials());
//			
//			Assert.assertTrue(IdentifyTestStatus(map));
//			Utilities.statusCode.set(Utilities.count, "1");
//			Utilities.comments.set(Utilities.count, "Passed");
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//		loginPage.addSubStep(subSteps, captureSS(), Status.FAIL);
//		map.put("Exception" + e.toString(), subSteps);
//		testStatus = Status.FAIL;
//		Assert.assertFalse(true);
//	} catch (Error e) {
//		e.printStackTrace();
//		loginPage.addSubStep(subSteps, captureSS(), Status.FAIL);
//		map.put("Error" + e.toString(), subSteps);
//		Assert.assertFalse(true);
//	} finally {
//		driver.close();
//		try {
//			addTestStepsIntoReport(testStatus, map, "LoginWithValidUsernameAndValidPassword",desc);
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} catch (Error e) {
//			e.printStackTrace();
//
//		}
//
//	}
//
//	}
//
//	@Test (groups = {"UI"}) 
//	public void TC_ID_3_LoginWithInvalidUsernameAndValidPassword() throws IOException {
//		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
//		ArrayList<TestSteps> subSteps = new ArrayList<>();
//		Status testStatus = Status.PASS;
//		String TestCaseID = "63";
//		Utilities.count+=1;
//		String desc ="";
//		
//		if (!Utilities.validateString(TestCaseID)) {
//			Utilities.testId.add(TestCaseID);
//			Utilities.statusCode.add("5");
//		} else {
//			String[] testcase = TestCaseID.split("\\|");
//			for (int i = 0; i < testcase.length; i++) {
//				Utilities.testId.add(testcase[i]);
//				Utilities.statusCode.add("5");
//				Utilities.comments.add("Failed");
//			}
//		}
//		
//		try {
//			
//			initConfiguration();
//			String testRail_URL = getProPertyVal("TestRailTestCaseURL");			
//			desc = "Description : <a href='"+testRail_URL+""+TestCaseID+"'>Login With Invalid Username And Valid Password </a>";
//			loginPage = new LoginPage();
//			
//			
//			map.put("<b>Step 1 :***************Login With Invalid Username And Valid Password***************</b>",loginPage.loginWithInvalidUsernameAndValidPassword());
//		
//			Assert.assertTrue(IdentifyTestStatus(map));
//			Utilities.statusCode.set(Utilities.count, "1");
//			Utilities.comments.set(Utilities.count, "Passed");
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//		loginPage.addSubStep(subSteps, captureSS(), Status.FAIL);
//		map.put("Exception" + e.toString(), subSteps);
//		testStatus = Status.FAIL;
//		Assert.assertFalse(true);
//	} catch (Error e) {
//		e.printStackTrace();
//		loginPage.addSubStep(subSteps, captureSS(), Status.FAIL);
//		map.put("Error" + e.toString(), subSteps);
//		Assert.assertFalse(true);
//	} finally {
//		driver.close();
//		try {
//			addTestStepsIntoReport(testStatus, map, "LoginWithInvalidUsernameAndValidPassword",desc);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} catch (Error e) {
//			e.printStackTrace();
//
//		}
//
//	}
//
//	}
//	
//	@Test (groups = {"UI"}) 
//	public void TC_ID_2_LoginwithValidUsernameAndInvalidPassword() throws IOException {
//		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
//		ArrayList<TestSteps> subSteps = new ArrayList<>();
//		Status testStatus = Status.PASS;
//		String TestCaseID = "63";
//		Utilities.count+=1;
//		String desc = "";
//		
//		if (!Utilities.validateString(TestCaseID)) {
//			Utilities.testId.add(TestCaseID);
//			Utilities.statusCode.add("5");
//		} else {
//			String[] testcase = TestCaseID.split("\\|");
//			for (int i = 0; i < testcase.length; i++) {
//				Utilities.testId.add(testcase[i]);
//				Utilities.statusCode.add("5");
//				Utilities.comments.add("Failed");
//			}
//		}
//		
//		try {
//			
//			initConfiguration();
//			String testRail_URL = getProPertyVal("TestRailTestCaseURL");			
//			desc = "<a href='"+testRail_URL+""+TestCaseID+"'>Login With Valid Username And Invalid Password </a>";
//			loginPage = new LoginPage();
//			
//			map.put("<b>Step 1 :***************TC_ID_2_Login with Valid Username And Invalid Password***************</b>",loginPage.LoginwithValidUsernameAndInvalidPassword());
//		
//			Assert.assertTrue(IdentifyTestStatus(map));
//			Utilities.statusCode.set(Utilities.count, "1");
//			Utilities.comments.set(Utilities.count, "Passed");
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//		loginPage.addSubStep(subSteps, captureSS(), Status.FAIL);
//		map.put("Exception" + e.toString(), subSteps);
//		testStatus = Status.FAIL;
//		Assert.assertFalse(true);
//	} catch (Error e) {
//		e.printStackTrace();
//		loginPage.addSubStep(subSteps, captureSS(), Status.FAIL);
//		map.put("Error" + e.toString(), subSteps);
//		Assert.assertFalse(true);
//	} finally {
//		driver.close();
//		try {
//			addTestStepsIntoReport(testStatus, map, "LoginwithValidUsernameAndInvalidPassword",desc);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} catch (Error e) {
//			e.printStackTrace();
//
//		}
//
//	}
//
//	}
//
//	@Test (groups = {"UI"}) 
//	public void TC_ID_4_LoginWithInvalidUsernameAndInvalidPassword() throws IOException {
//		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
//		ArrayList<TestSteps> subSteps = new ArrayList<>();
//		Status testStatus = Status.PASS;
//		String TestCaseID = "64";
//		Utilities.count+=1;
//		String desc = "";
//		
//		if (!Utilities.validateString(TestCaseID)) {
//			Utilities.testId.add(TestCaseID);
//			Utilities.statusCode.add("5");
//		} else {
//			String[] testcase = TestCaseID.split("\\|");
//			for (int i = 0; i < testcase.length; i++) {
//				Utilities.testId.add(testcase[i]);
//				Utilities.statusCode.add("5");
//				Utilities.comments.add("Failed");
//			}
//		}
//		
//		try {			
//			initConfiguration();
//			String testRail_URL = getProPertyVal("TestRailTestCaseURL");			
//			desc = "<a href='"+testRail_URL+""+TestCaseID+"'>Login With Invalid Username And Invalid Password </a>";
//			loginPage = new LoginPage();
//			
//			map.put("<b>Step 1 :***************TC_ID_4_Login With Invalid Username And Invalid Password***************</b>",loginPage.loginWithInvalidUsernameAndInvalidPassword());
//		
//			Assert.assertTrue(IdentifyTestStatus(map));
//			Utilities.statusCode.set(Utilities.count, "1");
//			Utilities.comments.set(Utilities.count, "Passed");
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//		loginPage.addSubStep(subSteps, captureSS(), Status.FAIL);
//		map.put("Exception" + e.toString(), subSteps);
//		testStatus = Status.FAIL;
//		Assert.assertFalse(true);
//	} catch (Error e) {
//		e.printStackTrace();
//		loginPage.addSubStep(subSteps, captureSS(), Status.FAIL);
//		map.put("Error" + e.toString(), subSteps);
//		Assert.assertFalse(true);
//	} finally {
//		driver.close();
//		try {
//			addTestStepsIntoReport(testStatus, map, "LoginWithInvalidUsernameAndInvalidPassword",desc);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} catch (Error e) {
//			e.printStackTrace();
//
//		}
//
//	}
//
//	}
//
//	@Test (groups = {"UI"}) 
//	public void TC_ID_5_LoginWithEmptyUsernameAndEmptyPasswordFields() throws IOException {
//		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
//		ArrayList<TestSteps> subSteps = new ArrayList<>();
//		Status testStatus = Status.PASS;
//		String TestCaseID = "65";
//		Utilities.count+=1;
//		String desc = "";
//		
//		if (!Utilities.validateString(TestCaseID)) {
//			Utilities.testId.add(TestCaseID);
//			Utilities.statusCode.add("5");
//		} else {
//			String[] testcase = TestCaseID.split("\\|");
//			for (int i = 0; i < testcase.length; i++) {
//				Utilities.testId.add(testcase[i]);
//				Utilities.statusCode.add("5");
//				Utilities.comments.add("Failed");
//			}
//		}
//		
//		try {			
//			initConfiguration();
//			String testRail_URL = getProPertyVal("TestRailTestCaseURL");			
//			desc = "<a href='"+testRail_URL+""+TestCaseID+"'>Login With Invalid Username And Invalid Password </a>";
//			loginPage = new LoginPage();
//			
//			map.put("<b>Step 1 :***************Login With Empty Username And Empty Password Fields***************</b>",loginPage.loginWithEmptyUsernameAndEmptyPasswordFields());
//		
//		
//			Assert.assertTrue(IdentifyTestStatus(map));
//			Utilities.statusCode.set(Utilities.count, "1");
//			Utilities.comments.set(Utilities.count, "Passed");
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//		loginPage.addSubStep(subSteps, captureSS(), Status.FAIL);
//		map.put("Exception" + e.toString(), subSteps);
//		testStatus = Status.FAIL;
//		Assert.assertFalse(true);
//	} catch (Error e) {
//		e.printStackTrace();
//		loginPage.addSubStep(subSteps, captureSS(), Status.FAIL);
//		map.put("Error" + e.toString(), subSteps);
//		Assert.assertFalse(true);
//	} finally {
//		driver.close();
//		try {
//			addTestStepsIntoReport(testStatus, map, "LoginWithEmptyUsernameAndEmptyPasswordFields",desc);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} catch (Error e) {
//			e.printStackTrace();
//
//		}
//
//	}
//}
//	
//	@Test (groups = {"UI"}) 
//	public void TC_ID_6_WhileLoggedOutVerifyLoginScreenPage() throws IOException {
//		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
//		ArrayList<TestSteps> subSteps = new ArrayList<>();
//		Status testStatus = Status.PASS;
//		String TestCaseID = "66";
//		Utilities.count+=1;
//		String desc = "";
//		
//		if (!Utilities.validateString(TestCaseID)) {
//			Utilities.testId.add(TestCaseID);
//			Utilities.statusCode.add("5");
//		} else {
//			String[] testcase = TestCaseID.split("\\|");
//			for (int i = 0; i < testcase.length; i++) {
//				Utilities.testId.add(testcase[i]);
//				Utilities.statusCode.add("5");
//				Utilities.comments.add("Failed");
//			}
//		}
//		
//		try {			
//			initConfiguration();
//			String testRail_URL = getProPertyVal("TestRailTestCaseURL");			
//			desc = "<a href='"+testRail_URL+""+TestCaseID+"'>While Logged Out Verify Login Screen Page </a>";
//			loginPage = new LoginPage();
//			
//			map.put("<b>Step 1 :***************While Logged Out Verify Login Screen Page***************</b>",loginPage.whileLoggedOutVerifyLoginScreenPage());
//		
//			Assert.assertTrue(IdentifyTestStatus(map));
//			Utilities.statusCode.set(Utilities.count, "1");
//			Utilities.comments.set(Utilities.count, "Passed");
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//		loginPage.addSubStep(subSteps, captureSS(), Status.FAIL);
//		map.put("Exception" + e.toString(), subSteps);
//		testStatus = Status.FAIL;
//		Assert.assertFalse(true);
//	} catch (Error e) {
//		e.printStackTrace();
//		loginPage.addSubStep(subSteps, captureSS(), Status.FAIL);
//		map.put("Error" + e.toString(), subSteps);
//		Assert.assertFalse(true);
//	} finally {
//		driver.close();
//		try {
//			addTestStepsIntoReport(testStatus, map, "WhileLoggedOutVerifyLoginScreenPage",desc);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} catch (Error e) {
//			e.printStackTrace();
//
//		}
//
//	}
//}
//	
//
//	@Test (groups = {"UI"}) 
//	public void TC_ID_7_WhileUsernameIsBlankVerifyUsernameField() throws IOException {
//		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
//		ArrayList<TestSteps> subSteps = new ArrayList<>();
//		Status testStatus = Status.PASS;
//		String TestCaseID = "67";
//		Utilities.count+=1;
//		String desc = "";
//		
//		if (!Utilities.validateString(TestCaseID)) {
//			Utilities.testId.add(TestCaseID);
//			Utilities.statusCode.add("5");
//		} else {
//			String[] testcase = TestCaseID.split("\\|");
//			for (int i = 0; i < testcase.length; i++) {
//				Utilities.testId.add(testcase[i]);
//				Utilities.statusCode.add("5");
//				Utilities.comments.add("Failed");
//			}
//		}
//		
//		try {
//			
//			initConfiguration();
//			String testRail_URL = getProPertyVal("TestRailTestCaseURL");			
//			desc = "<a href='"+testRail_URL+""+TestCaseID+"'>While Username Is Blank Verify Username Field </a>";
//			loginPage = new LoginPage();
//			
//			map.put("<b>Step 1 :***************While Username Is Blank Verify Username Field***************</b>",loginPage.whileUsernameIsBlankVerifyUsernameField());
//		
//			Assert.assertTrue(IdentifyTestStatus(map));
//			Utilities.statusCode.set(Utilities.count, "1");
//			Utilities.comments.set(Utilities.count, "Passed");
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//		loginPage.addSubStep(subSteps, captureSS(), Status.FAIL);
//		map.put("Exception" + e.toString(), subSteps);
//		testStatus = Status.FAIL;
//		Assert.assertFalse(true);
//	} catch (Error e) {
//		e.printStackTrace();
//		loginPage.addSubStep(subSteps, captureSS(), Status.FAIL);
//		map.put("Error" + e.toString(), subSteps);
//		Assert.assertFalse(true);
//	} finally {
//		driver.close();
//		try {
//			addTestStepsIntoReport(testStatus, map, "WhileUsernameIsBlankVerifyUsernameField",desc);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} catch (Error e) {
//			e.printStackTrace();
//
//		}
//
//	}
//}
//	
//	
//	@Test (groups = {"UI"}) 
//	public void TC_ID_8_WhilePasswordIsBlankVerifyPasswordField() throws IOException {
//		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
//		ArrayList<TestSteps> subSteps = new ArrayList<>();
//		Status testStatus = Status.PASS;
//		String TestCaseID = "68";
//		Utilities.count+=1;
//		String desc ="";
//		
//		if (!Utilities.validateString(TestCaseID)) {
//			Utilities.testId.add(TestCaseID);
//			Utilities.statusCode.add("5");
//		} else {
//			String[] testcase = TestCaseID.split("\\|");
//			for (int i = 0; i < testcase.length; i++) {
//				Utilities.testId.add(testcase[i]);
//				Utilities.statusCode.add("5");
//				Utilities.comments.add("Failed");
//			}
//		}
//		
//		try {			
//			initConfiguration();
//			String testRail_URL = getProPertyVal("TestRailTestCaseURL");			
//			desc = "<a href='"+testRail_URL+""+TestCaseID+"'>While Password Is Blank Verify Password Field </a>";
//			loginPage = new LoginPage();
//			
//			map.put("<b>Step 1 :***************While Password Is Blank Verify Password Field***************</b>",loginPage.whilePasswordIsBlankVerifyPasswordField());
//		
//			Assert.assertTrue(IdentifyTestStatus(map));
//			Utilities.statusCode.set(Utilities.count, "1");
//			Utilities.comments.set(Utilities.count, "Passed");
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//		loginPage.addSubStep(subSteps, captureSS(), Status.FAIL);
//		map.put("Exception" + e.toString(), subSteps);
//		testStatus = Status.FAIL;
//		Assert.assertFalse(true);
//	} catch (Error e) {
//		e.printStackTrace();
//		loginPage.addSubStep(subSteps, captureSS(), Status.FAIL);
//		map.put("Error" + e.toString(), subSteps);
//		Assert.assertFalse(true);
//	} finally {
//		driver.close();
//		try {
//			addTestStepsIntoReport(testStatus, map, "WhilePasswordIsBlankVerifyPasswordField",desc);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} catch (Error e) {
//			e.printStackTrace();
//
//		}
//
//	}
//}
//
//	
//	@Test (groups = {"UI"}) 
//	public void TC_ID_9_WhileLoggedInVerifySuccessMessagePopup() throws IOException {
//		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
//		ArrayList<TestSteps> subSteps = new ArrayList<>();
//		Status testStatus = Status.PASS;
//		String TestCaseID = "69";
//		Utilities.count+=1;
//		String desc = "";
//		
//		if (!Utilities.validateString(TestCaseID)) {
//			Utilities.testId.add(TestCaseID);
//			Utilities.statusCode.add("5");
//		} else {
//			String[] testcase = TestCaseID.split("\\|");
//			for (int i = 0; i < testcase.length; i++) {
//				Utilities.testId.add(testcase[i]);
//				Utilities.statusCode.add("5");
//				Utilities.comments.add("Failed");
//			}
//		}
//		
//		try {
//			
//			initConfiguration();
//			String testRail_URL = getProPertyVal("TestRailTestCaseURL");			
//			desc = "<a href='"+testRail_URL+""+TestCaseID+"'>While Logged In Verify Success Message Popup </a>";
//			loginPage = new LoginPage();
//			
//			map.put("<b>Step 1 :***************While Logged In Verify Success Message Popup***************</b>",loginPage.whileLoggedInVerifySuccessMessagePopup());
//		
//			Assert.assertTrue(IdentifyTestStatus(map));
//			Utilities.statusCode.set(Utilities.count, "1");
//			Utilities.comments.set(Utilities.count, "Passed");
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//		loginPage.addSubStep(subSteps, captureSS(), Status.FAIL);
//		map.put("Exception" + e.toString(), subSteps);
//		testStatus = Status.FAIL;
//		Assert.assertFalse(true);
//	} catch (Error e) {
//		e.printStackTrace();
//		loginPage.addSubStep(subSteps, captureSS(), Status.FAIL);
//		map.put("Error" + e.toString(), subSteps);
//		Assert.assertFalse(true);
//	} finally {
//		driver.close();
//		try {
//			addTestStepsIntoReport(testStatus, map, "WhileLoggedInVerifySuccessMessagePopup",desc);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} catch (Error e) {
//			e.printStackTrace();
//
//		}
//
//	}
//}
//
//	
//	@Test (groups = {"UI"}) 
//	public void TC_ID_10_WhileLoggedinSuccessfullyVerifyTheDashboardScreen() throws IOException {
//		HashMap<String, ArrayList<TestSteps>> map = new LinkedHashMap<>();
//		ArrayList<TestSteps> subSteps = new ArrayList<>();
//		Status testStatus = Status.PASS;
//		String TestCaseID = "70";
//		Utilities.count+=1;
//		String desc ="";
//		
//		if (!Utilities.validateString(TestCaseID)) {
//			Utilities.testId.add(TestCaseID);
//			Utilities.statusCode.add("5");
//		} else {
//			String[] testcase = TestCaseID.split("\\|");
//			for (int i = 0; i < testcase.length; i++) {
//				Utilities.testId.add(testcase[i]);
//				Utilities.statusCode.add("5");
//				Utilities.comments.add("Failed");
//			}
//		}
//		
//		try {			
//			initConfiguration();
//			String testRail_URL = getProPertyVal("TestRailTestCaseURL");			
//			desc = "<a href='"+testRail_URL+""+TestCaseID+"'>While Logged in Successfully Verify The Dashboard Screen </a>";
//			loginPage = new LoginPage();
//			
//			map.put("<b>Step 1 :***************While Loggedin Successfully Verify The Dashboard Screen***************</b>",loginPage.whileLoggedinSuccessfullyVerifyTheDashboardScreen());
//		
//			Assert.assertTrue(IdentifyTestStatus(map));
//			Utilities.statusCode.set(Utilities.count, "1");
//			Utilities.comments.set(Utilities.count, "Passed");
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//		loginPage.addSubStep(subSteps, captureSS(), Status.FAIL);
//		map.put("Exception" + e.toString(), subSteps);
//		testStatus = Status.FAIL;
//		Assert.assertFalse(true);
//	} catch (Error e) {
//		e.printStackTrace();
//		loginPage.addSubStep(subSteps, captureSS(), Status.FAIL);
//		map.put("Error" + e.toString(), subSteps);
//		Assert.assertFalse(true);
//	} finally {
//		driver.close();
//		try {
//			addTestStepsIntoReport(testStatus, map, "WhileLoggedinSuccessfullyVerifyTheDashboardScreen",desc);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} catch (Error e) {
//			e.printStackTrace();
//
//		}
//
//	}
//}

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
//	
}
