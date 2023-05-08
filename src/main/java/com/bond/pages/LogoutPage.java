package com.bond.pages;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.bond.base.BaseClass;
import com.bond.base.PropertiesReader;
import com.bond.errorCollectors.ErrorCollector;
import com.bond.utilities.TestSteps;

public class LogoutPage extends BaseClass {

	@FindBy(xpath = ("(//*[contains(text(),'Sign in')])[last()]"))
	WebElement loginPage;

	@FindBy(xpath = ("//*[contains(text(),'Logout')]"))
	WebElement logoutBtn;

	@FindBy(xpath = ("//h3[contains(text(),'Welcome')] | //div[@class='login-header']"))
	WebElement loginPageTitle;

	@FindBy(xpath = ("//div[text()='Login to your account']"))
	WebElement loginPageDescription;

	String MBWEmail = PropertiesReader.getPropertyValue(env + "_MBWEmailId");
	String MBWPassword = PropertiesReader.getPropertyValue(env + "_MBWPassword");
	String bcpEmail = PropertiesReader.getPropertyValue(env + "_BcpEmailId");
	String bcpPass = PropertiesReader.getPropertyValue(env + "_BcpPassword");
	String espEmail = PropertiesReader.getPropertyValue(env + "_ESPEmail");
	String espPass = PropertiesReader.getPropertyValue(env + "_ESPPassword");
	
//	LoginPage loginPg = new LoginPage();
	
	public LogoutPage() {
		PageFactory.initElements(driver, this);
	}

	public Status clickOnLogoutButton() {
		try {
			waitTime(9000);
			waitForElementClickable(logoutBtn, "10");
			click(logoutBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}

	}

	public boolean isLoginPageDisplaying() {
		waitTime(1000);
		waitForElementVisibility(loginPage, "20");
		return isElementDisplayed(loginPage);
	}

	public boolean isLoginPageTitleDisplaying() {
		waitTime(8000);
		try {
			waitForElementVisibility(loginPageTitle, "20");
			return isElementDisplayed(loginPageTitle);
		} catch (Exception e) {
			return false;
		}
	}
	

	public boolean isLoginPageDescriptionDisplaying() {
		waitTime(8000);
		try {
			waitForElementVisibility(loginPageDescription, "20");
			return isElementDisplayed(loginPageDescription);
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public ArrayList<TestSteps> WhileLoggedinSuccessfullyVerifyLogoutButton() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");
			
			status = loginPg.clickOnLoginButton();
			addSubStep(subSteps, "click On Login Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);			

			status = clickOnLogoutButton();
			addSubStep(subSteps, "click On Logout Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(isLoginPageTitleDisplaying(), " :Verify Login Page Title is displaying");
			addSubStep(subSteps, "Verify Login Page Title is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			
//			status = ErrorCollector.verifyTrue(isLoginPageTitleDisplaying(), " :Verify Verified Login Page Title is displaying");
//			addSubStep(subSteps, "Verify Verified Login Page Title is displaying", status);
//			if (status.equals(Status.FAIL))
//				Assert.assertFalse(true);
//				
			return subSteps;
		} catch (Exception e) {
			e.printStackTrace();
			waitTime(3000);
			addSubStep(subSteps, captureSS(), Status.FAIL);
			return subSteps;

		} catch (Error e) {
			e.printStackTrace();
			waitTime(3000);
			addSubStep(subSteps, captureSS(), Status.FAIL);
			return subSteps;
		}
}


}
