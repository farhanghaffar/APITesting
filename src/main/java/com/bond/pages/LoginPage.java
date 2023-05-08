package com.bond.pages;

import org.openqa.selenium.support.Color;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.bond.base.BaseClass;
import com.bond.base.EmailUtils;
import com.bond.base.PropertiesReader;
import com.bond.errorCollectors.ErrorCollector;
import com.bond.utilities.TestSteps;
import com.bond.utilities.Utilities;

public class LoginPage extends EmailUtils {

	@FindBy(xpath = ("//button[@type='submit'] | //button[contains(text(),'Log In')][1]"))
	WebElement btnLogin;

	@FindBy(xpath = ("//input[@name='email']"))
	WebElement authAngularSampleEmailTxt;

	@FindBy(xpath = ("//button[@name='submit']"))
	WebElement authAngularSampleSubmitBtn;

	@FindBy(xpath = ("//input[@name='vcode']"))
	WebElement authAngularSampleYourCodeTxt;

	@FindBy(xpath = ("//*[contains(text(),'Home')]"))
	WebElement userDashboard;

	@FindBy(xpath = ("//input[@type='email']"))
	WebElement inputName;

	@FindBy(xpath = ("//input[@type='password']"))
	WebElement inputPass;

	@FindBy(xpath = "//*[contains(text(),'Login Success')]")
	WebElement loginSuccessMessage;

	@FindBy(xpath = "//div[text()='Email field is required.'] | //div[@id='error-message']")
	WebElement loginEmailNotFoundMessage;

	@FindBy(xpath = "//div[text()='Password field is required.'] | //div[text()='Wrong email or password.'] | //div[@id='error-message']")
	WebElement loginPasswordNotFoundMessage;

	@FindBy(xpath = "//div[@aria-label='Incorrect password']")
	WebElement loginIncorrectPasswordMessage;

	@FindBy(xpath = "//input[contains(@class,'ng-star-inserted is-invalid') and @placeholder='Email']")
	WebElement inputNameError;

	@FindBy(xpath = "//input[contains(@class,'ng-star-inserted is-invalid') and @placeholder='Password']")
	WebElement inputPassError;

	@FindBy(xpath = "//*[local-name()='svg' and @data-icon='user']")
	WebElement inputNameIcon;

	@FindBy(xpath = "//*[local-name()='svg' and @data-icon='lock']")
	WebElement inputPassIcon;

	@FindBy(xpath = "//div[@aria-label='Success']")
	WebElement LoggedInSuccessPopup;

	@FindBy(xpath = "//*[contains(text(),'Login Success')]")
	WebElement LoggedInSuccessPopup2;

	@FindBy(xpath = "//a[text()='OSQO - (Bond Creation Platform)']")
	WebElement dashboardTitle;

	@FindBy(xpath = ("//button[contains(text(),'Home')]"))
	WebElement menuHomeBtn;

	@FindBy(xpath = ("//*[local-name()='svg' and @data-icon='house-chimney']"))
	WebElement menuHomeBtnIcon;

	@FindBy(xpath = ("//button[contains(text(),'Sync Submissions')]"))
	WebElement menuSyncSubmissionsBtn;

	@FindBy(xpath = ("//button[contains(text(),'Scenarios')]"))
	WebElement menuScenariosBtn;

	@FindBy(xpath = ("//button[contains(text(),'Bond Buyer')]"))
	WebElement menuBondBuyerBtn;

	@FindBy(xpath = ("//button[contains(text(),'Sync Personal Data')]"))
	WebElement menuSyncPersonalDataBtn;

	@FindBy(xpath = ("//button[contains(text(),'Sync Settlement Data')]"))
	WebElement menuSyncSettlementDataBtn;

	@FindBy(xpath = ("//button[contains(text(),'Sync Post Purchase')]"))
	WebElement menuSyncPostPurchaseBtn;

	@FindBy(xpath = ("//*[contains(text(),'Logout')]"))
	WebElement menuLogoutBtn;

	@FindBy(xpath = ("//h6[text()='Welcome Admin'] | //h6[contains(text(),'Welcome')]"))
	WebElement homePageMsg;

	String MBWEmail = PropertiesReader.getPropertyValue(env + "_MBWEmailId");
	String MBWPassword = PropertiesReader.getPropertyValue(env + "_MBWPassword");
	String bcpEmail = PropertiesReader.getPropertyValue(env + "_BcpEmailId");
	String bcpPass = PropertiesReader.getPropertyValue(env + "_BcpPassword");
	String espEmail = PropertiesReader.getPropertyValue(env + "_ESPEmail");
	String espPass = PropertiesReader.getPropertyValue(env + "_ESPPassword");
	LogoutPage logout = new LogoutPage();
	String yellowColor = "#ffc107";

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public Status clickOnLoginButton() {
		try {
			waitForElementClickable(btnLogin, "10");
			click(btnLogin);
			waitTime(1000);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterEmail(String email) {
		try {
			waitForElementVisibility(authAngularSampleEmailTxt, "10");
			type(authAngularSampleEmailTxt, email);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterYourCode(String code) {
		try {
			waitForElementVisibility(authAngularSampleYourCodeTxt, "30");
			type(authAngularSampleYourCodeTxt, code);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickOnSubmitButton() {
		try {
			waitForElementClickable(authAngularSampleSubmitBtn, "10");
			click(authAngularSampleSubmitBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterPassword(String pass) {
		try {
			waitForElementVisibility(inputPass, "30");
			type(inputPass, pass);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public boolean isUserDashboardDisplaying() {
		try {
			waitForElementVisibility(userDashboard, "80");
			return isElementDisplayed(userDashboard);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isDisplayingOnUserDashboard(String value) {
		return isElementDisplayed(driver.findElement(By.xpath("//*[contains(text(),'" + value + "')]")));
	}

	public boolean isLoginEmailNotFoundMessageDisplaying() {
		try {
			waitForElementVisibility(loginEmailNotFoundMessage, "20");
			return isElementDisplayed(loginEmailNotFoundMessage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isLoginPasswordNotFoundMessageDisplaying() {
		try {
			waitForElementVisibility(loginPasswordNotFoundMessage, "20");
			return isElementDisplayed(loginPasswordNotFoundMessage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isLoginIncorrectPasswordMessageDisplaying() {
		waitForElementVisibility(loginIncorrectPasswordMessage, "20");
		return isElementDisplayed(loginIncorrectPasswordMessage);
	}

	public boolean isEmailInputErrorDisplaying() {
		waitForElementVisibility(inputNameError, "20");
		return isElementDisplayed(inputNameError);
	}

	public boolean isPasswordInputErrorDisplaying() {
		waitForElementVisibility(inputNameError, "20");
		return isElementDisplayed(inputPassError);
	}

	public boolean isInputNameFiledDisplaying() {
		try {
			waitForElementVisibility(inputName, "20");
			return isElementDisplayed(inputName);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isInputPassFiledDisplaying() {
		try {
			waitForElementVisibility(inputPass, "20");
			return isElementDisplayed(inputPass);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isInputNameIconDisplaying() {
		try {
			waitForElementVisibility(inputNameIcon, "20");
			return isElementDisplayed(inputNameIcon);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isInputPassIconDisplaying() {
		try {
			waitForElementVisibility(inputPassIcon, "20");
			return isElementDisplayed(inputPassIcon);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isLoginBtnYellowColor() {
		try {
			String color = btnLogin.getCssValue("background-color");
			String colorHex = Color.fromString(color).asHex();
			System.out.println(colorHex);
			ErrorCollector.assertEquals(colorHex, yellowColor, "Verify login button background color is yellow");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isDashboardTitleDisplaying() {
		try {
			waitForElementVisibility(dashboardTitle, "20");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isMenuHomeButtonDisplaying() {
		try {
			waitForElementVisibility(menuHomeBtn, "20");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isMenuHomeButtonIconDisplaying() {
		try {
			waitForElementVisibility(menuHomeBtnIcon, "20");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isMenuSyncSubmissionsButtonDisplaying() {
		try {
			waitForElementVisibility(menuSyncSubmissionsBtn, "20");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isMenuScenariosButtonDisplaying() {
		try {
			waitForElementVisibility(menuScenariosBtn, "20");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isMenuBondBuyerButtonDisplaying() {
		try {
			waitForElementVisibility(menuBondBuyerBtn, "20");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isMenuSyncPersonalDataButtonDisplaying() {
		try {
			waitForElementVisibility(menuSyncPersonalDataBtn, "20");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isMenuSyncSettlementDataButtonDisplaying() {
		try {
			waitForElementVisibility(menuSyncSettlementDataBtn, "20");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isLoggedInSuccessPopupDisplaying() {
		try {
			return isElementDisplayed(LoggedInSuccessPopup);

		} catch (Exception e) {
			return false;
		}
	}

	public String getLoginSuccessMessage() {
		return getElementText(LoggedInSuccessPopup2);
	}

	public boolean isMenuSyncPostPurchaseButtonDisplaying() {

		return isElementDisplayed(menuSyncPostPurchaseBtn);
	}

	public boolean isMenuLogoutButtonDisplaying() {
		waitForElementVisibility(menuLogoutBtn, "30");
		return isElementDisplayed(menuLogoutBtn);
	}

	public boolean isHomePageMessageDisplaying() {
		waitForElementVisibility(homePageMsg, "20");
		return isElementDisplayed(homePageMsg);
	}

	public Status loginToOSQOAccount(String OSQOEmail, String OSQOPassword) {
		try {
			enterEmail(OSQOEmail);
			enterPassword(OSQOPassword);
			clickOnLoginButton();
			try {
				Parameters params = new Parameters();
				FileBasedConfigurationBuilder<FileBasedConfiguration> builder = new FileBasedConfigurationBuilder<FileBasedConfiguration>(
						PropertiesConfiguration.class)
								.configure(params.properties().setFileName(System.getProperty("user.dir")
										+ "/src/test/resources/config/Config.properties"));
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				String token = (String) js
						.executeScript(String.format("return window.localStorage.getItem('%s');", "_bt"));

				Configuration config = builder.getConfiguration();
				config.setProperty("token", token);
				builder.save();
			} catch (Exception e) {
				e.printStackTrace();
			}

			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public ArrayList<TestSteps> loginWithOTPVerificationCode() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		Status status = null;
		String mailFolderName = "INBOX";
		String emailSubjectContent = "auth0 Angular Sample";
		String emailContent = "Your verification code is:";
		int OTPLength = 7;
		String yourCode;
		try {

			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = enterEmail(bcpEmail);
			addSubStep(subSteps, "Enter Email : " + bcpEmail, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnSubmitButton();
			addSubStep(subSteps, "click On Submit Button", status);

			yourCode = mailOTPReader(mailFolderName, emailSubjectContent, emailContent, OTPLength);

			status = enterYourCode(yourCode);
			addSubStep(subSteps, "Enter OTP Code : " + yourCode, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnSubmitButton();
			addSubStep(subSteps, "click On Submit Button", status);

			status = ErrorCollector.verifyTrue(isUserDashboardDisplaying(),
					" :Verify User Login Successfully message is displaying");
			addSubStep(subSteps, "Verify User Login Successfully message is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

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

	public ArrayList<TestSteps> loginWithValidCradintials() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		Status status = null;
		try {

//			mailReader();
//			gmailReader("INBOX","auth0 Angular Sample","Your verification code is:",7);

//			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
//			openURL("AppURL");
//
//			status = loginToOSQOAccount(bcpEmail, bcpPass);
//			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
//			if (status.equals(Status.FAIL))
//				Assert.assertFalse(true);
//			
//			status = ErrorCollector.verifyTrue(isUserDashboardDisplaying(), " :Verify User Login Successfully message is displaying");
//			addSubStep(subSteps, "Verify User Login Successfully message is displaying", status);
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

	public ArrayList<TestSteps> loginWithInvalidUsernameAndValidPassword() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			String InvalidEmail = PropertiesReader.getPropertyValue(env + "_InvalidEmailId");
			status = enterEmail(InvalidEmail + randomNumberString(3));
			addSubStep(subSteps, "Enter Invalid Email : " + InvalidEmail, status);

			String pass = PropertiesReader.getPropertyValue(env + "_BcpPassword");
			status = enterPassword(pass);
			addSubStep(subSteps, "Enter Password : " + pass, status);

			status = clickOnLoginButton();
			addSubStep(subSteps, "click On Login Button", status);

			status = ErrorCollector.verifyTrue(isLoginEmailNotFoundMessageDisplaying(),
					" :Verify is login email not found message displaying");
			addSubStep(subSteps, "Verify is login email not found message displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

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

	public ArrayList<TestSteps> LoginwithValidUsernameAndInvalidPassword() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			String validEmail = PropertiesReader.getPropertyValue(env + "_BcpEmailId");
			status = enterEmail(validEmail);
			addSubStep(subSteps, "Enter valid Email : " + validEmail, status);

			String pass = PropertiesReader.getPropertyValue(env + "_InvalidPassword");
			status = enterPassword(pass);
			addSubStep(subSteps, "Enter Password : " + pass, status);

			status = clickOnLoginButton();
			addSubStep(subSteps, "click On Login Button", status);

			status = ErrorCollector.verifyTrue(isLoginEmailNotFoundMessageDisplaying(),
					" :Verify is login email not found message displaying");
			addSubStep(subSteps, "Verify is login email not found message displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

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

	public ArrayList<TestSteps> loginWithInvalidUsernameAndInvalidPassword() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			String InvalidEmail = PropertiesReader.getPropertyValue(env + "_InvalidEmailId");
			status = enterEmail(InvalidEmail + randomNumberString(3));
			addSubStep(subSteps, "Enter Invalid Email : " + InvalidEmail, status);

			String pass = PropertiesReader.getPropertyValue(env + "_InvalidPassword");
			status = enterPassword(pass);
			addSubStep(subSteps, "Enter Password : " + pass, status);

			status = clickOnLoginButton();
			addSubStep(subSteps, "click On Login Button", status);

			status = ErrorCollector.verifyTrue(isLoginEmailNotFoundMessageDisplaying(),
					" :Verify is login email not found message displaying");
			addSubStep(subSteps, "Verify is login email not found message displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			Utilities.statusCode.set(0, "1");
			Utilities.comments.set(0, "Passed");

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

	public ArrayList<TestSteps> loginWithEmptyUsernameAndEmptyPasswordFields() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = clickOnLoginButton();
			addSubStep(subSteps, "click On Login Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isLoginEmailNotFoundMessageDisplaying(),
					" :Verify is login email not found message displaying");
			addSubStep(subSteps, "Verify is login email not found message displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

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

	public ArrayList<TestSteps> whileLoggedOutVerifyLoginScreenPage() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isUserDashboardDisplaying(),
					" :Verify User Login Successfully message is displaying");
			addSubStep(subSteps, "Verify User Login Successfully message is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = logout.clickOnLogoutButton();
			addSubStep(subSteps, "click on Logout button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(logout.isLoginPageTitleDisplaying(),
					" :Verify Login Page Title is displaying");
			addSubStep(subSteps, "Verify Login Page Title is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isInputNameFiledDisplaying(), " :Verify Login Name Field is displaying");
			addSubStep(subSteps, "Verify Login Name Field is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isInputPassFiledDisplaying(),
					" :Verify Login Password Field is displaying");
			addSubStep(subSteps, "Verify Login Password Field is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

//			status = ErrorCollector.verifyTrue(isLoginBtnYellowColor(), " :Verify login button background color is yellow");
//			addSubStep(subSteps, "Verify login button background color is yellow", status);
//			if (status.equals(Status.FAIL))
//				Assert.assertFalse(true);

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

	public ArrayList<TestSteps> whileUsernameIsBlankVerifyUsernameField() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = clickOnLoginButton();
			addSubStep(subSteps, "click On Login Button", status);

			status = ErrorCollector.verifyTrue(isLoginEmailNotFoundMessageDisplaying(),
					" :Verify email field is required message displaying");
			addSubStep(subSteps, "Verify email field is required message displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

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

	public ArrayList<TestSteps> whilePasswordIsBlankVerifyPasswordField() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			String email = PropertiesReader.getPropertyValue(env + "_BcpEmailId");
			status = enterEmail(email);
			addSubStep(subSteps, "Enter Email : " + email, status);

			status = clickOnLoginButton();
			addSubStep(subSteps, "click On Login Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isLoginPasswordNotFoundMessageDisplaying(),
					" :Verify password field is required message displaying");
			addSubStep(subSteps, "Verify password field is required message displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

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

	public ArrayList<TestSteps> whileLoggedInVerifySuccessMessagePopup() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isLoggedInSuccessPopupDisplaying(),
					" :Verify User Login Successfully Popup is displaying");
			addSubStep(subSteps, "Verify User Login Successfully Popup is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

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

	public ArrayList<TestSteps> whileLoggedinSuccessfullyVerifyTheDashboardScreen() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

//			status = ErrorCollector.verifyTrue(isLoggedInSuccessPopupDisplaying(), " :Verify User Login Successfully Popup is displaying");
//			addSubStep(subSteps, "Verify User Login Successfully Popup is displaying", status);
//			if (status.equals(Status.FAIL))
//				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isDashboardTitleDisplaying(),
					" :Verify Dashboard Title 'OSQO - (Bond Creation Platform)' is displaying");
			addSubStep(subSteps, "Verify Dashboard Title 'OSQO - (Bond Creation Platform)' is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isMenuHomeButtonDisplaying(),
					" :Verify 'Menu Home Button' is displaying");
			addSubStep(subSteps, "Verify 'Menu Home Button' is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isMenuHomeButtonIconDisplaying(),
					" :Verify 'Menu Home Button Icon' is displaying");
			addSubStep(subSteps, "Verify 'Menu Home Button Icon' is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isMenuSyncSubmissionsButtonDisplaying(),
					" :Verify 'Menu Sync Submissions Button' is displaying");
			addSubStep(subSteps, "Verify 'Menu Sync Submissions Button' is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isMenuScenariosButtonDisplaying(),
					" :Verify 'Menu Scenarios Button' is displaying");
			addSubStep(subSteps, "Verify 'Menu Scenarios Button' is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isMenuBondBuyerButtonDisplaying(),
					" :Verify 'Menu Bond Buyer Button' is displaying");
			addSubStep(subSteps, "Verify 'Menu Bond Buyer Button' is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isMenuSyncPersonalDataButtonDisplaying(),
					" :Verify 'Menu Sync Personal Data Button' is displaying");
			addSubStep(subSteps, "Verify 'Menu Sync Personal Data Button' is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isMenuSyncSettlementDataButtonDisplaying(),
					" :Verify 'Menu Sync Settlement Data Button' is displaying");
			addSubStep(subSteps, "Verify 'Menu Sync Settlement Data Button' is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isMenuSyncPostPurchaseButtonDisplaying(),
					" :Verify 'Menu Sync Post Purchase Button' is displaying");
			addSubStep(subSteps, "Verify 'Menu Sync Post Purchase Button' is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isMenuLogoutButtonDisplaying(),
					" :Verify 'Logout Button' is displaying");
			addSubStep(subSteps, "Verify 'Logout Button' is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

//			status = logout.clickOnLogoutButton();
//			addSubStep(subSteps, "click On Logout Button", status);
//			if (status.equals(Status.FAIL))
//				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isHomePageMessageDisplaying(),
					" :Verify on Home Page 'Welcome Admin' is displaying");
			addSubStep(subSteps, "Verify on Home Page 'Welcome Admin' is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

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

	public Status loginToEspAccount(String espEmail, String espPassword) {
		try {
			enterEmail(espEmail);
			enterPassword(espPassword);
			clickOnLoginButton();
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
}
