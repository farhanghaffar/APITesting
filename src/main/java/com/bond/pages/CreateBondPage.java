package com.bond.pages;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.tools.ant.filters.TokenFilter.Trim;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.bond.base.BaseClass;
import com.bond.base.EmailUtils;
import com.bond.base.PropertiesReader;
import com.bond.errorCollectors.ErrorCollector;
import com.bond.utilities.StepsWithHeader;
import com.bond.utilities.TestSteps;

public class CreateBondPage extends EmailUtils {

	@FindBy(xpath = "//span[contains(text(),'Accept All')]")
	WebElement AcceptAllBtnOnPopup;

	@FindBy(xpath = "//span[contains(text(),'Sign in with Email')]")
	WebElement SignInWithEmailBtn;

	@FindBy(xpath = "//input[contains(@type,'email')]")
	WebElement EmailInputField;

	@FindBy(xpath = "//input[contains(@type,'password')]")
	WebElement PasswordInputField;

	@FindBy(xpath = "//button[contains(@id,'emailSignIn')] | //button[contains(@id,'start-login-submit-button')]")
	WebElement SignInBtn;

	@FindBy(xpath = "(//a[@class='text-inverse'])[2]")
	WebElement nextTabBtn;

	@FindBy(xpath = "//a[text()[contains(.,'Create Application')]]")
	WebElement CreateApplicationBtn;

	@FindBy(xpath = "(//input[contains(@placeholder,'Fill out first name')])[1]")
	WebElement primaryFirstNameInputField;

	@FindBy(xpath = "(//input[contains(@placeholder,'Fill out last name')])[1]")
	WebElement primaryLastNameInputField;

	@FindBy(xpath = "(//input[contains(@placeholder,'Fill phone number (+614)')])[1]")
	WebElement primaryPhoneNumberInputField;

	@FindBy(xpath = "(//input[contains(@placeholder,'Fill e-mail')])[1]")
	WebElement primaryEmailTxt;

	@FindBy(xpath = "(//input[contains(@placeholder,'Fill out first name')])[2]")
	WebElement secondaryFirstNameInputField;

	@FindBy(xpath = "(//input[contains(@placeholder,'Fill out last name')])[2]")
	WebElement secondaryLastNameInputField;

	@FindBy(xpath = "(//input[contains(@placeholder,'Fill phone number (+614)')])[2]")
	WebElement secondaryPhoneNumberInputField;

	@FindBy(xpath = "(//input[contains(@placeholder,'Fill e-mail')])[2]")
	WebElement secondaryEmailTxt;

	@FindBy(xpath = "(//textarea[contains(@class,'inputElement')])[2]")
	WebElement sendInfoInputField;

	@FindBy(xpath = "//span[contains(text(),'House')]//parent::label//following-sibling::div/input")
	WebElement houseTxt;

	@FindBy(xpath = "(//span[contains(text(),'Postcode(s)')]//parent::label//following-sibling::div/input)[1]")
	WebElement housePostCodeInputField;

	@FindBy(xpath = "(//span[contains(text(),'Unit')]//parent::label//following-sibling::div/input)[1]")
	WebElement unitTxt;

	@FindBy(xpath = "(//span[contains(text(),'Postcode(s)')]//parent::label//following-sibling::div/input)[2]")
	WebElement unitPostCodeInputField;

	@FindBy(xpath = "(//span[contains(text(),'Apartment')]//parent::label//following-sibling::div/input)[1]")
	WebElement apartmentTxt;

	@FindBy(xpath = "(//span[contains(text(),'Postcode(s)')]//parent::label//following-sibling::div/input)[3]")
	WebElement apartmentPostCodeInputField;

	@FindBy(xpath = "(//a[contains(text(),'Family')])[1]")
	WebElement FamilyBtn;

	@FindBy(xpath = "(//a[contains(text(),'Family')])[2]")
	WebElement FamilyBtn2;

	@FindBy(xpath = "//button[text()='Save Scenario']")
	WebElement saveScenarioBtn;

	@FindBy(xpath = "//input[contains(@id,'scenario-name')]")
	WebElement ScenarioNameInputField;

	@FindBy(xpath = "//a[contains(text(),'Save')]")
	WebElement SaveBtnOnPopup;

	@FindBy(xpath = "(//a[contains(text(),'OK')])[1]")
	WebElement OkBtnOnPopup;

	@FindBy(xpath = "(//button[contains(text(),'Apply for Pre-Conditional Approval')])[1]")
	WebElement applyForPreConditionalApproval;

	@FindBy(xpath = "//button[contains(text(),'View Home-Buyer Details')] | //button[contains(text(),'View Borrower Details')]")
	WebElement ViewBorrowerDetailsBtn;

	@FindBy(xpath = "//td[contains(text(),'Scenario ID')]/following-sibling::td")
	WebElement ScenarioId;

	@FindBy(xpath = "//button[contains(text(),'conditional approval (Step 3)')]")
	WebElement Step3ConditionalApprovalButton;

	@FindBy(xpath = "//button[contains(text(),'Submit Property Purchase Details (Step 5)')]")
	WebElement submitPropertyPurchaseDetailsBtn;

	@FindBy(xpath = "//input[@type='email']")
	WebElement GoogleEmailInputField;

	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement NextBtnOnGoogleSignIn;

	@FindBy(xpath = "//input[@type='password']")
	WebElement GooglePasswordInputField;

	@FindBy(xpath = "//span[contains(text(),'Confirm')]")
	WebElement ConfirmBtnOnGoogleSignIn;

	@FindBy(xpath = "(//span[contains(text(),'Continue')])[last()]")
	WebElement ContinueBtn;

	@FindBy(xpath = "//span[contains(text(),'Title/Role')]/../../../following-sibling::div[1]//span[contains(text(),'Choose')]")
	WebElement chooseDropDownForTileRole;

	@FindBy(xpath = "//span[contains(text(),'Bond Buyer Type')]/../../../following-sibling::div[1]//span[contains(text(),'Choose')]")
	WebElement chooseDropDownForBondBuyerType;

	@FindBy(xpath = "//span[contains(text(),'DOB')]//../../../../div[2]//div[@class='Xb9hP']/input")
	WebElement dobDropdown;

	@FindBy(xpath = "(//span[contains(text(),'SELF')])[last()]")
	WebElement selfTextInDropDown;

	@FindBy(xpath = "//span[contains(text(),'No')]/../../preceding-sibling::div//div[@class='vd3tt']")
	WebElement NoRadioBtn;

	@FindBy(xpath = "//span[contains(text(),'Yes')]/../../preceding-sibling::div//div[@class='vd3tt']")
	WebElement YesRadioBtn;

	@FindBy(xpath = "//span[contains(text(),'Submit')] | //button[contains(text(),'Submit')]")
	WebElement SubmitBtn;

	@FindBy(xpath = "//span[contains(text(),'Homebuyer ID')]/../../../following-sibling::div[1]//input")
	WebElement HomeBuyerIdOnGoogleForm;

	@FindBy(xpath = "//span[contains(text(),'Campaign ID')]/../../../following-sibling::div[1]//input")
	WebElement CompaignIdOnGoogleForm;

	@FindBy(xpath = "//td[contains(text(),'Scenario State')]/following-sibling::td")
	WebElement ScenarioStateText;

	@FindBy(xpath = "//td[contains(text(),'Home Buyer Party Id')]/following-sibling::td | //td[contains(text(),'Borrower ID')]/following-sibling::td")
	WebElement HomeBuyerPartyId;

	@FindBy(xpath = "//td[contains(text(),'Bondbuyer ID')]/following-sibling::td")
	WebElement bondbuyerId;

	@FindBy(xpath = "//input[@type='submit'] | //button[text()='Approve KYC']")
	WebElement approveKYCBtn;

	@FindBy(xpath = "//button[text()='Approve Pre-Approval']")
	WebElement approvePreApprovalBtn;

	@FindBy(xpath = "//button[text()='Reject Pre-Approval']")
	WebElement rejectPreApprovalBtn;

	@FindBy(xpath = "//div[@aria-label='Success'] | //div[text()[contains(.,'Success')]]")
	WebElement approvePreApprovalSuccessPopup;

	@FindBy(xpath = "//button[text()[contains(.,'Back')]]")
	WebElement backBtn;

	@FindBy(xpath = "//textarea[@placeholder='KYC Parameters']")
	WebElement kycParametersTxt;

	@FindBy(xpath = "//button[text()='Approve Prelim Con-approval'] | //button[text()='Approve Con-approval']")
	WebElement approvePrelimConApprovalBtn;

	@FindBy(xpath = "//td[text()='PASSEDKYC_CONAPPROVAL']")
	WebElement secnarioStatePassKycConapprovel;

	@FindBy(xpath = "//button[contains(text(),'Scenario')]")
	WebElement scenarioListmenuBtn;

	@FindBy(xpath = "//input[contains(@id,'PRE_APPROVAL_LETTER')]")
	WebElement chosefileUploadPreApproval;

	@FindBy(xpath = "//input[contains(@id,'PRE_APPROVAL_LETTER')]/following::button[text()='Upload']")
	WebElement preApprovalUploadbtn;

	@FindBy(xpath = "//input[contains(@id,'DEED_OF_GURANTEE')]")
	WebElement chosefileUploadDeedOfGurantee;

	@FindBy(xpath = "(//button[text()='Upload'])[2]")
	WebElement deedOfGuranteeUploadBtn;

	@FindBy(xpath = "//input[contains(@id,'F_AND_F_ODF_')]")
	WebElement chosefileUploadFAndFSupplementary;

	@FindBy(xpath = "(//button[text()='Upload'])[1]")
	WebElement fAndFSupplementaryUploadBtn;

	@FindBy(xpath = "//td[contains(text(),'Pre-Approval Letter')]/following-sibling::td/p[text()='Open File']")
	WebElement preApprovalOpenFileMsg;

	@FindBy(xpath = "//td[contains(text(),'Deed of Gurantee')]/following-sibling::td/a[text()='Open File']")
	WebElement deedOfGuranteeOpenFileMsg;

	@FindBy(xpath = "//td[contains(text(),'F&F ODF Supplementary')]/following-sibling::td/a[text()='Open File']")
	WebElement odfSupplementaryOpenFileMsg;

	@FindBy(xpath = "//button[text()='Submit']")
	WebElement submitBtn;

	@FindBy(xpath = "//button[text()[contains(.,'Logout')]]")
	WebElement logoutBtn;

	@FindBy(xpath = "//td[contains(text(),'ESP_STEP4_COMPLETED')]")
	WebElement ESP_STEP4_COMPLETED;

	@FindBy(xpath = "//span[contains(text(),'Property Type')]/../../../following-sibling::div[1]//span[contains(text(),'Choose')]")
	WebElement selectPropertyType;

	@FindBy(xpath = "//span[contains(text(),'Number of Bedrooms')]/../../../following-sibling::div[1]//span[contains(text(),'Choose')]")
	WebElement selectNumberofBedrooms;

	@FindBy(xpath = "//span[contains(text(),'Postcode')]/../../../following-sibling::div[1]//input")
	WebElement postcodeTxt;

	@FindBy(xpath = "//span[contains(text(),'Property Address')]/../../../following-sibling::div[1]//input")
	WebElement propertyAddressTxt;

	@FindBy(xpath = "//span[contains(text(),'Property Title Volume')]/../../../following-sibling::div[1]//input")
	WebElement propertyTitleVolumeTxt;

	@FindBy(xpath = "//span[contains(text(),'Property Folio#')]/../../../following-sibling::div[1]//input")
	WebElement propertyFolioTxt;

	@FindBy(xpath = "//span[contains(text(),'Mortgage Interest Rate')]/../../../following-sibling::div[1]//input")
	WebElement mortgageInterestateTxt;

	@FindBy(xpath = "//span[contains(text(),'Loan Amount Request')]/../../../following-sibling::div[1]//input")
	WebElement loanAmountRequestTxt;

	@FindBy(xpath = "//span[contains(text(),'PropertyPurchasePrice')]/../../../following-sibling::div[1]//input")
	WebElement propertyPurchasePriceTxt;

	@FindBy(xpath = "//div[contains(text(),'Property Title Details')]")
	WebElement propertyTitleDetailsSuccessPage;

	@FindBy(xpath = "(//span[text()='Continue'])[2]")
	WebElement continuePopupBtn;

	@FindBy(xpath = "//div[text()='Request has been submitted for pre-approval.']")
	WebElement requestHasBeenSubmittedPopup;

	@FindBy(xpath = "//input[@aria-label='Please enter verification code. Digit 1']")
	WebElement otpDigit1;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement OtpSubmitBtn;

	@FindBy(xpath = "//input[@id='password-field-input']")
	WebElement passwordField;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement passwordSubmit;

	@FindBy(xpath = "//iframe[contains(@class,'border-none relative')]")
	WebElement iframeOne;

	@FindBy(xpath = "//a[text()='Homebuyer Circumstances']")
	WebElement homebuyerCircumstancesBtn;

	@FindBy(xpath = "(//span[@class='glyphicon glyphicon-plus'])[1]")
	WebElement propertyPurchaseplusBtn;

	@FindBy(xpath = "//input[@id='in5']")
	WebElement propertyPurchaseplusTxt;

	@FindBy(xpath = "(//span[@class='irs-slider single'])[1]")
	WebElement eachMonthSpan;

	@FindBy(xpath = "//input[@id='ersdCheckbox']")
	WebElement docRadiobtn;

	@FindBy(xpath = "//button[@data-test-id='ersd-accept-and-continue-button']")
	WebElement docAcceptAndContinueBtn;

	@FindBy(xpath = "//button[@data-test-id='box-doc-header-begin-btn']")
	WebElement docBeginBtn;

	@FindBy(xpath = "//button[@title='Place Signature here']")
	WebElement docPlaceSignatureHereBtn;

	@FindBy(xpath = "//input[@placeholder='Type your name']")
	WebElement docTypeYourNameTxt;

	@FindBy(xpath = "//button[@data-test-id='submit']")
	WebElement docAdoptBtn;

	@FindBy(xpath = "//div[@title='Enter Text Input here, required']")
	WebElement docTextInputBtn;

	@FindBy(xpath = "//input[@placeholder='Add text here']")
	WebElement docInputTextTxt;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement docInputTextSaveBtn;

	@FindBy(xpath = "//button[@data-test-id='box-doc-header-finalize-btn']")
	WebElement docSignAndFinishBtn;

	@FindBy(xpath = "//h1[text()='Thank you for signing the document!']")
	WebElement docThankYouForSigningTheDocumentMsg;

	@FindBy(xpath = "//input[@name='search-scenario']")
	WebElement ScenarioSearchName;

	@FindBy(xpath = "//div[contains(text(),' Request is processed successfully and the data will update shortly. ')]")
	WebElement scenarioSuccessMessage;

	@FindBy(xpath = "//td[contains(text(),'Scenario Hash')]//following-sibling::td")
	WebElement scenarioHashElement;
	
	@FindBy(xpath = "//td[contains(text(),'Borrower Hash')]//following-sibling::td")
	WebElement borrowerHashElement;

	@FindBy(xpath = "//td[contains(text(),'Scenario ID')]//following-sibling::td")
	WebElement scenarioIdElement;

	@FindBy(xpath = "//td[contains(text(),'Scenario State')]//following-sibling::td")
	WebElement scenarioStateElement;

	@FindBy(xpath = "//td[contains(text(),'Broker ID')]//following-sibling::td")
	WebElement brokerIdElement;

	@FindBy(xpath = "//td[contains(text(),'Loan Amount Offer')]//following-sibling::td")
	WebElement loanAmountOfferElement;

	@FindBy(xpath = "//span[contains(text(),'Scenario Hash')]//../following-sibling::div/input")
	WebElement scenarioHashOnBroker;

	@FindBy(xpath = "//span[contains(text(),'Homebuyer Hash')]//../following-sibling::div/input")
	WebElement homebuyerHashOnBroker;

	@FindBy(xpath = "//span[contains(text(),'Broker ID')]//../following-sibling::div/input")
	WebElement brokerIdOnBroker;

	@FindBy(xpath = "//h4[text()='Loan Facility Amount']/following-sibling::p")
	WebElement loanFacilityAmountOnBroker;

	@FindBy(xpath = "//span[@id='select2-scenario-chooser-container']")
	WebElement senarioTxt;

	@FindBy(xpath = "//input[@placeholder='Borrower ID']")
	WebElement borrowerIdOnHomeBuyerForm;

	@FindBy(xpath = "(//label[text()='Salutation '])[1]/..//div/mat-select")
	WebElement salutationDropDownOnHomeBuyerForm;

	@FindBy(xpath = "(//span[@class='mat-option-text'])[last()]")
	WebElement salutationOption;

	@FindBy(xpath = "//input[@placeholder='Phone Number']")
	WebElement phoneNumberTxtOnHomeBuyerForm;

	@FindBy(xpath = "(//span[text()='Next'])[1]")
	WebElement naxtBtnOnHomeBuyerForm;

	@FindBy(xpath = "//div[text()=' Guarantor ']")
	WebElement guarantorTitleOnHomeBuyerForm;

	@FindBy(xpath = "(//span[text()='Next'])[2]")
	WebElement naxtSecBtnOnHomeBuyerForm;

	@FindBy(xpath = "//div[text()=' Investor ']")
	WebElement investorTitleOnHomeBuyerForm;

	@FindBy(xpath = "//h3[text()=\"Investor's Details\"]")
	WebElement investorsDetailsTitleOnHomeBuyerForm;

	@FindBy(xpath = "//input[@placeholder='Placement Amount']")
	WebElement placementAmountTxtOnHomeBuyerForm;

	@FindBy(xpath = "(//input[@placeholder='First Name'])[last()]")
	WebElement firstNameTxtOnHomeBuyerForm;

	@FindBy(xpath = "(//input[@placeholder='Last Name'])[last()]")
	WebElement lastNameTxtOnHomeBuyerForm;

	@FindBy(xpath = "(//label[text()='Title/Role '])[2]/..//div/mat-select")
	WebElement titleRoleDropdownOnHomeBuyerForm;

	@FindBy(xpath = "(//span[@class='mat-option-text'])[last()]")
	WebElement titleRoleOption;

	@FindBy(xpath = "(//input[@placeholder='Address'])[last()]")
	WebElement addressTxtOnHomeBuyerForm;

	@FindBy(xpath = "(//input[@placeholder='City'])[last()]")
	WebElement cityTxtOnHomeBuyerForm;

	@FindBy(xpath = "(//input[@placeholder='Postcode'])[last()]")
	WebElement postcodeTxtOnHomeBuyerForm;

	@FindBy(xpath = "(//input[@formcontrolname='DOB'])[last()]")
	WebElement dobTxtOnHomeBuyerForm;

	@FindBy(xpath = "//div[text()=' Additional Investor ']")
	WebElement additionalInvestorTitleOnHomeBuyerForm;

	@FindBy(xpath = "//span[text()=' Preview']")
	WebElement previewBtnOnHomeBuyerForm;

	@FindBy(xpath = "//span[text()='Submit']")
	WebElement submitBtnOnHomeBuyerForm;
	
	@FindBy(xpath = "//div[text()=' Guarantor ']")
	WebElement guarantorTitle;	
	
	@FindBy(xpath = "(//input[@value='yes'])[1]")
	WebElement gurantorYesRadioButton;
	
	@FindBy(xpath = "(//label[text()='Relationship '])[1]/..//div/mat-select")
	WebElement relationshipDropdown;
	
	@FindBy(xpath = "(//label[text()='Salutation '])[2]/..//div/mat-select")
	WebElement salutationDropdown;
	
	@FindBy(xpath = "(//label[text()='First Name '])[2]/..//div/div/input")
	WebElement gurantorFirstNameTxt;
	
	@FindBy(xpath = "(//label[text()='Last Name '])[2]/..//div/div/input")
	WebElement gurantorLastNameTxt;
	
	@FindBy(xpath = "(//label[text()='Title/Role '])[2]/..//div/mat-select")
	WebElement gurantorTitleRoleDropdown;
	
	@FindBy(xpath = "(//label[text()='Title/Role '])[2]/..//div/mat-select")
	WebElement titleRoleDropdown;
	
	@FindBy(xpath = "(//label[text()='Address '])[1]/..//div/div/input")
	WebElement gurantorAddressTxt;
	
	@FindBy(xpath = "(//label[text()='City '])[1]/..//div/div/input")
	WebElement gurantorCityTxt;
	
	@FindBy(xpath = "(//label[text()='Postcode '])[1]/..//div/div/input")
	WebElement gurantorPostcodeTxt;
	
	@FindBy(xpath = "(//label[text()='State/Province/Territory '])[1]/..//div/mat-select")
	WebElement stateProvinceTerritoryDropdown;
	
	@FindBy(xpath = "(//label[text()='DOB '])[1]/..//div/div/input")
	WebElement DOBTxt;
	
	@FindBy(xpath = "//div[text()=' Investor ']")
	WebElement pageInvestorTitle;
	
	@FindBy(xpath = "(//input[@value='yes'])[2]")
	WebElement investorYesRadioButton;
	
	@FindBy(xpath = "(//label[text()='Investor Type '])[1]/..//div/mat-select")
	WebElement investorTypeDropdown;
	
	@FindBy(xpath = "(//label[text()='Placement Amount '])[1]/..//div/div/input")
	WebElement placementAmountTxt;
	
	@FindBy(xpath = "(//label[text()='Salutation '])[3]/..//div/mat-select")
	WebElement investorSalutationDropdown;
	
	@FindBy(xpath = "(//label[text()='First Name '])[3]/..//div/div/input")
	WebElement investorFirstNameTxt;
	
	@FindBy(xpath = "(//label[text()='Last Name '])[3]/..//div/div/input")
	WebElement investorLastNameTxt;
	
	@FindBy(xpath = "(//label[text()='Title/Role '])[3]/..//div/mat-select")
	WebElement investorTitleRoleDropdown;
	
	@FindBy(xpath = "(//label[text()='Address '])[2]/..//div/div/input")
	WebElement investorAddressTxt;
	
	@FindBy(xpath = "(//label[text()='City '])[2]/..//div/div/input")
	WebElement investorCityTxt;
	
	@FindBy(xpath = "(//label[text()='State/Province/Territory '])[2]/..//div/mat-select")
	WebElement investorStateProvinceTerritoryDropdown;
	
	@FindBy(xpath = "(//label[text()='Postcode '])[2]/..//div/div/input")
	WebElement investorPostcodeTxt;
	
	@FindBy(xpath = "(//label[text()='DOB '])[2]/..//div/div/input")
	WebElement investorDOBTxt;

	@FindBy(xpath = "//div[text()=' Additional Investor ']")
	WebElement additionalInvestorTitle;
	
	@FindBy(xpath = "//span[text()=' Preview']")
	WebElement previewBtn;
	
	@FindBy(xpath = "//tr[@class='odd'][1]/td[4]")
	WebElement senarioName;
	
	@FindBy(xpath = ("//div[text()='Main Front End Application']"))
	WebElement loginPageTitle;
	
	
	
	
	String primaryFirstName;
	String primaryLastName;
	String primaryPhoneNumber;
	String primaryMail;
	String secondaryFirstName;
	String secondaryLastName;
	String secondaryPhoneNumber;
	String secondaryMail;
	String postalCode;
	String houseNumber;
	String unitNumber;
	String apartmentNumber;
	String scenarioName;
	String scenarioId;
	String scenarioHash="SC_6b76e51344767ca5a58e1c0bb2d435e8";
	String homebuyerHash="BO_49d30d3bcc1f5e6eb3de738bff1ec029";
	String brokerId;
	String loanFacilityAmount;
	String newScenarioId;
	String scenarioState = "AWAITING_PREAPPROVAL";
	public String HB;
	public String CP;
	public String salutation;
	public String FirstName;
	public String LastName;
	public String city;
	public String province;
	public String postcode;
	public String Phone_Number = "499099980";
	public String passportId;
	public String driversLicenseId;
	public String swiftId;
	public String placement_ammount;
	public String address;
	LoginPage lp = new LoginPage();
	DashboardPage dashboardPage = new DashboardPage();

	String MBWEmail = PropertiesReader.getPropertyValue(env + "_MBWEmailId");
	String MBWPassword = PropertiesReader.getPropertyValue(env + "_MBWPassword");
	String MBWPasswordSecond = PropertiesReader.getPropertyValue(env + "_MBWPasswordSecond");
	String bcpEmail = PropertiesReader.getPropertyValue(env + "_BcpEmailId");
	String bcpPass = PropertiesReader.getPropertyValue(env + "_BcpPassword");
	String espEmail = PropertiesReader.getPropertyValue(env + "_ESPEmail");
	String espPass = PropertiesReader.getPropertyValue(env + "_ESPPassword");
	String primaryEmail = PropertiesReader.getPropertyValue(env + "_PrimaryEmailId");
	String secondaryEmailId = PropertiesReader.getPropertyValue(env + "_SecondaryEmailId");
	String phoneNumber = PropertiesReader.getPropertyValue(env + "_PhoneNumber");

	public CreateBondPage() {
		PageFactory.initElements(driver, this);
	}

	public Status clickAcceptAllBtnOnPopup() {
		try {
			click(AcceptAllBtnOnPopup);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickSignInWithEmailBtn() {
		try {
			waitForElementVisibility(SignInWithEmailBtn, "20");
			click(SignInWithEmailBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickContinuePopupButton() {
		try {
			waitForElementVisibility(continuePopupBtn, "20");
			click(continuePopupBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public void enterEmail(String keys) {
		waitForElementVisibility(EmailInputField, "20");
		EmailInputField.sendKeys(keys);
	}

	public void enterPassword(String keys) {
		waitForElementVisibility(PasswordInputField, "20");
		PasswordInputField.sendKeys(keys);
	}

	public void clickSignInBtn() {
		waitForElementVisibility(SignInBtn, "20");
		click(SignInBtn);
	}

	public Status clickCreateApplicationBtn() {
		try {
//			waitForElementVisibility(nextTabBtn, "20");
//			click(nextTabBtn);
			waitForElementVisibility(CreateApplicationBtn, "20");
			click(CreateApplicationBtn);
//			clickUsingJavascriptExecutor(CreateApplicationBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickHomebuyerCircumstancesButton() {
		try {
			waitForElementVisibility(homebuyerCircumstancesBtn, "20");
			click(homebuyerCircumstancesBtn);
			enterPropertyPurchaseInputField("1" + randomNumberString(3));
//			clickPropertyPurchaseplusButton();
//			Actions action = new Actions(driver);
//			action.dragAndDropBy(eachMonthSpan, Integer.parseInt(randomNumberString(2)), 0).perform();

//			click(eachMonthSpan);

			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickPropertyPurchaseplusButton() {
		try {
			waitForElementVisibility(propertyPurchaseplusBtn, "20");
			click(propertyPurchaseplusBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterSecondaryFirstNameInputField(String keys) {
		try {
			waitForElementVisibility(secondaryFirstNameInputField, "30");
			secondaryFirstNameInputField.sendKeys(keys);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}

	}

	public Status enterSecondaryLastNameInputField(String keys) {
		try {
			waitForElementVisibility(secondaryLastNameInputField, "20");
			secondaryLastNameInputField.sendKeys(keys);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterPrimaryFirstNameInputField(String keys) {
		try {
			waitForElementVisibility(primaryFirstNameInputField, "30");
			primaryFirstNameInputField.sendKeys(keys);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}

	}

	public Status enterPrimaryLastNameInputField(String keys) {
		try {
			waitForElementVisibility(primaryLastNameInputField, "20");
			primaryLastNameInputField.sendKeys(keys);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status chosefileUploadPreApproval() {
		try {
			waitForElementVisibility(chosefileUploadPreApproval, "20");
			chosefileUploadPreApproval.sendKeys(imagePath + "//file.png");
			waitTime(5000);
			click(preApprovalUploadbtn);
			waitTime(10000);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status preApprovalUploadButton() {
		try {
			waitTime(1000);
			click(preApprovalUploadbtn);
			waitTime(10000);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status chosefileUploadDeedOfGurantee() {
		try {
			waitForElementVisibility(chosefileUploadDeedOfGurantee, "20");
			chosefileUploadDeedOfGurantee.sendKeys(imagePath + "//file.png");
			waitTime(5000);
			click(deedOfGuranteeUploadBtn);
			waitTime(10000);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status chosefileUploadFAndFODFSupplementary() {
		try {
			waitForElementVisibility(chosefileUploadFAndFSupplementary, "20");
			chosefileUploadFAndFSupplementary.sendKeys(imagePath + "//file.png");
			waitTime(5000);
			click(fAndFSupplementaryUploadBtn);
			waitTime(10000);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterPrimaryPhoneNumberInputField(String keys) {
		try {
			waitForElementVisibility(primaryPhoneNumberInputField, "20");
			primaryPhoneNumberInputField.sendKeys(keys);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterSecondaryPhoneNumberInputField(String keys) {
		try {
			waitForElementVisibility(secondaryPhoneNumberInputField, "20");
			secondaryPhoneNumberInputField.sendKeys(keys);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterPrimaryEmailInputField(String keys) {
		try {
			waitForElementVisibility(primaryEmailTxt, "20");
			primaryEmailTxt.sendKeys(keys);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterSecondaryEmailInputField(String keys) {
		try {
			waitForElementVisibility(secondaryEmailTxt, "20");
			secondaryEmailTxt.sendKeys(keys);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

//	public Status EnterInSendInfoInputField(String keys) {
//		try {
//			waitForElementVisibility(sendInfoInputField, "20");
//			sendInfoInputField.sendKeys(keys);
//			return Status.PASS;
//		} catch (Exception e) {
//			return Status.FAIL;
//		}
//
//	}

	public Status enterHouseNumber(String keys) {
		try {
			waitForElementVisibility(houseTxt, "20");
			houseTxt.sendKeys(keys);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterHousePostCodeInputField(String keys) {
		try {
			waitForElementVisibility(housePostCodeInputField, "20");
			housePostCodeInputField.sendKeys(keys);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterUnitNumber(String keys) {
		try {
			waitForElementVisibility(unitTxt, "20");
			unitTxt.sendKeys(keys);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterUnitPostCodeInputField(String keys) {
		try {
			waitForElementVisibility(unitPostCodeInputField, "20");
			unitPostCodeInputField.sendKeys(keys);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterApartmentNumber(String keys) {
		try {
			waitForElementVisibility(apartmentTxt, "20");
			apartmentTxt.sendKeys(keys);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterApartmentPostCodeInputField(String keys) {
		try {
			waitForElementVisibility(apartmentPostCodeInputField, "20");
			apartmentPostCodeInputField.sendKeys(keys);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterInScenarioNameInputField(String keys) {
		try {
			waitForElementVisibility(ScenarioNameInputField, "20");
			ScenarioNameInputField.sendKeys(keys);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickFamilyBtn() {
		try {
			waitForElementVisibility(FamilyBtn, "20");
			click(FamilyBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickFamilyBtn2() {
		try {
			waitForElementVisibility(FamilyBtn2, "20");
			click(FamilyBtn2);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickSaveScenarioButton() {
		try {
			waitForElementVisibility(saveScenarioBtn, "20");
			scrollIntoSpecificView(saveScenarioBtn);
			click(saveScenarioBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickSaveBtnOnPopup() {
		try {
			try {
				Thread.sleep(1000 * 5);
				waitForElementVisibility(SaveBtnOnPopup, "20");
				click(SaveBtnOnPopup);

			} catch (Exception e) {
				click(SaveBtnOnPopup);
				waitForElementVisibility(OkBtnOnPopup, "20");
			}
			return Status.PASS;
		} catch (Exception e) {

			return Status.FAIL;
		}
	}

	public Status clickOkBtnOnPopup() {
		try {
			waitForElementVisibility(OkBtnOnPopup, "20");
			click(OkBtnOnPopup);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickApplyForPreConditionalApprovalButton() {
		try {
			waitForElementVisibility(applyForPreConditionalApproval, "20");
			click(applyForPreConditionalApproval);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public boolean isNewSyncSubmissionIsDisplaying(String value) {
		WebElement sSubmission = driver.findElement(By.xpath("//td[contains(text(),'" + value + "')]"));
		waitForElementVisibility(sSubmission, "20");
		return isElementDisplayed(sSubmission);
	}

	public Status enterSearchScenario(String keys) {
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			// This will scroll the page till the element is found
			js.executeScript("arguments[0].scrollIntoView();", ScenarioSearchName);
			waitTime(2000);
			ScenarioSearchName.click();
			waitTime(1000);
			ScenarioSearchName.sendKeys(keys);
			waitTime(1000);

			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickOnSyncButton(String val) {
		waitTime(8000);
		WebElement syncBtn;

		try {
			try {

				syncBtn = driver
						.findElement(By.xpath("//td[contains(text(),'" + val + "')]/following-sibling::td[1]/button"));
				scrollIntoViewSmoothly(syncBtn);
				waitForElementVisibility(syncBtn, "20");
				click(syncBtn);

			} catch (Exception e) {
				syncBtn = driver
						.findElement(By.xpath("//td[contains(text(),'" + val + "')]/following-sibling::td[2]/button"));
				scrollIntoViewSmoothly(syncBtn);
				waitForElementVisibility(syncBtn, "20");
				click(syncBtn);
			}
			waitTime(5000);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickOnDetailsButton(String val) {
		try {
			try {
				waitTime(10000);
				WebElement syncBtn = driver
						.findElement(By.xpath("//td[contains(text(),'" + val + "')]//following-sibling::td/button "));
				scrollIntoViewSmoothly(syncBtn);
				waitForElementVisibility(syncBtn, "20");
				click(syncBtn);
				waitTime(5000);
			} catch (Exception e) {
				waitTime(10000);
				WebElement syncBtn = driver
						.findElement(By.xpath("//td[contains(text(),'" + val + "')]/following-sibling::td[3]/button"));
				scrollIntoViewSmoothly(syncBtn);
				waitForElementVisibility(syncBtn, "20");
				click(syncBtn);
				waitTime(5000);
			}

			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickOnDetailButton(String val) {
		try {
			waitTime(10000);
			WebElement syncBtn = driver
					.findElement(By.xpath("(//td[contains(text(),'" + val + "')]/following::td/button)[1]"));
			scrollIntoViewSmoothly(syncBtn);
			waitForElementVisibility(syncBtn, "20");
			click(syncBtn);
			waitTime(5000);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public boolean verifyOnSynchronizedScenariosIsPurchased(String val) {
		try {
			WebElement purchasd = driver
					.findElement(By.xpath("//td[contains(text(),'" + val + "')]/../td[text()='PURCHASED']"));
			waitForElementVisibility(purchasd, "20");
			isElementDisplayed(purchasd);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Status clickOnSyncButtonAgainstHomeBuyer(String val) {
		try {
			waitTime(10000);
			WebElement syncBtn = driver
					.findElement(By.xpath("//td[contains(text(),'" + val + "')]/../td[last()]/button"));
			scrollIntoView(syncBtn);
			waitForElementVisibility(syncBtn, "20");
			click(syncBtn);
			waitTime(5000);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickOnDetialsButton(String val) {
		try {
			WebElement syncBtn = driver
					.findElement(By.xpath("//td[contains(text(),'" + val + "')]/../td[last()]/button"));
			scrollIntoView(syncBtn);
			waitForElementVisibility(syncBtn, "20");
			click(syncBtn);
			waitTime(5000);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickSyncButton(String val) {
		try {
			WebElement syncBtn = driver
					.findElement(By.xpath("//td[contains(text(),'" + val + "')]/../td[last()]/button"));
			scrollIntoView(syncBtn);
			waitForElementVisibility(syncBtn, "20");
			click(syncBtn);
			waitTime(5000);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickOnViewBorrowerDetailsButton() {
		try {
			waitForElementVisibility(ViewBorrowerDetailsBtn, "20");
			click(ViewBorrowerDetailsBtn);
			waitTime(3000);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickOnLogoutButton() {
		try {
			waitTime(30000);
			scrollIntoViewSmoothly(logoutBtn);
			waitForElementVisibility(logoutBtn, "20");
			click(logoutBtn);
			waitTime(3000);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public String homeBuyerPartyId() {
		return getElementText(HomeBuyerPartyId);
	}

	public String bondbuyerId() {
		return getElementText(bondbuyerId);
	}

	public boolean verifyDataIsDisplaying(String value) {
		waitTime(10000);
		try {
			WebElement element = driver.findElement(By.xpath("//td[contains(text(),'" + value + "')]"));
			scrollIntoViewSmoothly(element);
			waitForElementVisibility(element, "20");
			return isElementDisplayed(element);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyPreApprovalOpenFileMessage() {
		waitTime(10000);
		try {
			scrollIntoViewSmoothly(preApprovalOpenFileMsg);
			waitForElementVisibility(preApprovalOpenFileMsg, "20");
			isElementDisplayed(preApprovalOpenFileMsg);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyRequestHasBeenSubmittedPopup() {
		try {
			waitForElementVisibility(requestHasBeenSubmittedPopup, "30");
			isElementDisplayed(requestHasBeenSubmittedPopup);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyEspStep4Completed() {
		waitTime(10000);
		try {
			scrollIntoViewSmoothly(ESP_STEP4_COMPLETED);
			waitForElementVisibility(ESP_STEP4_COMPLETED, "20");
			isElementDisplayed(ESP_STEP4_COMPLETED);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyPropertyTitleDetailsSuccessPage() {
		waitTime(10000);
		try {
			scrollIntoViewSmoothly(propertyTitleDetailsSuccessPage);
			waitForElementVisibility(propertyTitleDetailsSuccessPage, "20");
			isElementDisplayed(propertyTitleDetailsSuccessPage);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyFAndFSupplementaryOpenFileMessage() {
		waitTime(10000);
		try {
			scrollIntoViewSmoothly(odfSupplementaryOpenFileMsg);
			waitForElementVisibility(odfSupplementaryOpenFileMsg, "20");
			isElementDisplayed(odfSupplementaryOpenFileMsg);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyDeedOfGuranteeOpenFileMessage() {
		waitTime(10000);
		try {
			scrollIntoViewSmoothly(deedOfGuranteeOpenFileMsg);
			waitForElementVisibility(deedOfGuranteeOpenFileMsg, "20");
			isElementDisplayed(deedOfGuranteeOpenFileMsg);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void waitForDataToDisplaying(String value) {
		int count = 0;
		waitTime(10000);
		while (true) {
			try {
				if (count == 20) {
					break;
				}
				WebElement element = driver.findElement(By.xpath("//td[contains(text(),'" + value + "')]"));
				scrollIntoViewSmoothly(element);
				waitForElementVisibility(element, "90");
				isElementDisplayed(element);
				waitTime(8000);
				break;

			} catch (Exception e) {
				getRefreshWebPage();
				count++;
			} catch (Error e) {
				getRefreshWebPage();
				count++;
			}
		}

	}

	public boolean verifyApprovePreApprovalSuccessPopupIsDisplaying() {
		try {
			waitForElementVisibility(approvePreApprovalSuccessPopup, "20");
			isElementDisplayed(approvePreApprovalSuccessPopup);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifySecnarioStatePassKycConapprovelIsDisplaying() {
		try {
			scrollIntoViewSmoothly(secnarioStatePassKycConapprovel);
			waitForElementVisibility(secnarioStatePassKycConapprovel, "20");
			isElementDisplayed(secnarioStatePassKycConapprovel);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyDataIsNotDisplaying(String value) {
		try {
			WebElement element = driver.findElement(By.xpath("//td[contains(text(),'" + value + "')]"));
			scrollIntoViewSmoothly(element);
			return isElementDisplayed(element);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyFirstNameDataIsDisplaying() {
		waitTime(10000);
		try {
			WebElement element = driver.findElement(By.xpath("//td[contains(text(),'" + primaryFirstName + "')]"));
			scrollIntoViewSmoothly(element);
			waitForElementVisibility(element, "20");
			return isElementDisplayed(element);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyScenarioNameDataIsDisplaying() {
		waitTime(10000);
		try {
			WebElement element = driver.findElement(By.xpath("//td[contains(text(),'" + scenarioName + "')]"));
			scrollIntoViewSmoothly(element);
			waitForElementVisibility(element, "20");
			return isElementDisplayed(element);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyMailDataIsDisplaying() {
		waitTime(10000);
		try {
			WebElement element = driver.findElement(By.xpath("//td[contains(text(),'" + primaryMail + "')]"));
			waitForElementVisibility(element, "20");
			return isElementDisplayed(element);
		} catch (Exception e) {
			return false;
		}
	}

	public String getScenarioIdText() {
		return getElementText(ScenarioId);
	}

	public boolean verifyMessageFromApi(String text) {
		String message = "Request is processed successfully and the data will update shortly.";
		return message.equals(text);
	}

	public boolean verifyMessageFromSyncPersonalDataApi(String text) {
		String message = "Your sync request received and is processed!!.";
		return message.equals(text);
	}

	public boolean verifyStatusCode(int code) {
		int text = 404;
		if (text == code) {
			return true;
		} else {
			return false;
		}
	}

	public Status clickStep3ConditionalApprovalButton() {
		try {
			waitForElementVisibility(Step3ConditionalApprovalButton, "30");
			click(Step3ConditionalApprovalButton);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickOnSubmitPropertyPurchaseDetailsButton() {
		try {
			waitForElementVisibility(submitPropertyPurchaseDetailsBtn, "30");
			click(submitPropertyPurchaseDetailsBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickApproveKYCButton() {
		try {
			scrollIntoView(approveKYCBtn);
			waitForElementVisibility(approveKYCBtn, "30");
			click(approveKYCBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickOnApprovePreApprovalButton() {
		try {
			scrollIntoViewSmoothly(approvePreApprovalBtn);
			waitForElementVisibility(approvePreApprovalBtn, "10");
			click(approvePreApprovalBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickOnApprovePrelimConApprovalButton() {
		try {
			waitTime(10000);
			scrollIntoViewSmoothly(approvePrelimConApprovalBtn);
			waitForElementVisibility(approvePrelimConApprovalBtn, "10");
			click(approvePrelimConApprovalBtn);
			waitTime(10000);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickOnBackButton() {
		try {
			scrollIntoViewSmoothly(backBtn);
			waitForElementVisibility(backBtn, "10");
			click(backBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickOnScenarioListMenuButton() {
		try {
			waitForElementVisibility(scenarioListmenuBtn, "40");
			scrollIntoViewSmoothly(scenarioListmenuBtn);
			click(scenarioListmenuBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status googleSingIn(String email, String pass) {
		try {
			waitForElementVisibility(GoogleEmailInputField, "20");
			waitTime(2000);
			GoogleEmailInputField.sendKeys(email);
			click(NextBtnOnGoogleSignIn);

			waitTime(2000);
			waitForElementVisibility(GooglePasswordInputField, "20");
			waitTime(5000);
			GooglePasswordInputField.sendKeys(pass);
			click(NextBtnOnGoogleSignIn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public String getHomeBuyerIdFromGoogleForm() {
		waitTime(10000);
		String data = getElementAttributeValue(HomeBuyerIdOnGoogleForm, "data-initial-value");
		System.out.println(data);
		waitTime(6000);
		return data;
	}

	public String getCompaignIdFromGoogleForm() {
		String data = getElementAttributeValue(CompaignIdOnGoogleForm, "data-initial-value");
		return data;
	}

	public Status FillFieldsInGoogleForm(String fieldName, String data) {
		try {
			WebElement element = driver.findElement(
					By.xpath("//span[contains(text(),'" + fieldName + "')]/../../../following-sibling::div[1]//input"));
			scrollIntoView(element);
			waitForElementVisibility(element, "20");
			element.sendKeys(data);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterInKycParameters() {
		try {
			scrollIntoView(kycParametersTxt);
			waitForElementVisibility(kycParametersTxt, "20");
			kycParametersTxt.sendKeys("test");
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status FillAddressFieldInGoogleForm(String data) {
		try {
			WebElement element = driver
					.findElement(By.xpath("//span[text()='Address']/../../../following-sibling::div[1]//textarea"));
			scrollIntoView(element);
			waitForElementVisibility(element, "20");
			element.sendKeys(data);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status selectSelfFieldInDropdownGoogleForm() {
		try {
			scrollIntoView(chooseDropDownForTileRole);
			waitForElementVisibility(chooseDropDownForTileRole, "20");
			click(chooseDropDownForTileRole);
			waitTime(2000);
			List<WebElement> element = driver.findElements(By.xpath("(//span[@class='vRMGwf oJeWuf'])"));
			String self = "SELF";
			selectValueFromDropdown(element, self);
			waitTime(1000);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status selectBondBuyerDropdownGoogleForm() {
		try {
			scrollIntoView(chooseDropDownForBondBuyerType);
			waitForElementVisibility(chooseDropDownForBondBuyerType, "20");
			click(chooseDropDownForBondBuyerType);
			waitTime(2000);
			List<WebElement> element = driver.findElements(By.xpath(
					"//span[contains(text(),'Bond Buyer Type')]/../../../following-sibling::div[1]//span[@class='vRMGwf oJeWuf']"));
			String self = "RTP - Related Third Party (Friends & Family)";
			selectValueFromDropdown(element, self);
			waitTime(1000);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status selectDobDropdownGoogleForm() {
		try {
			scrollIntoView(dobDropdown);
			waitForElementVisibility(dobDropdown, "20");
			waitTime(2000);
			dobDropdown.sendKeys("02-02-1992");
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickNextBtnOnGoogleSignIn() {
		try {
			scrollToElement(NextBtnOnGoogleSignIn);
			waitForElementVisibility(NextBtnOnGoogleSignIn, "20");
			waitTime(2000);
			click(NextBtnOnGoogleSignIn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickGuarantorNoRadioBtn() {
		try {
			waitForElementVisibility(NoRadioBtn, "20");
			waitTime(2000);
			click(NoRadioBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public void clickBondBuyerNoRadioBtn() {
		waitForElementVisibility(NoRadioBtn, "20");
		waitTime(2000);
		click(NoRadioBtn);
	}

	public Status clickBondBuyerYesRadioBtn() {
		try {
			waitForElementVisibility(YesRadioBtn, "20");
			waitTime(2000);
			click(YesRadioBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickSubmitBtn() {
		try {
			waitTime(7000);
			scrollToElement(SubmitBtn);
			waitTime(5000);
			click(SubmitBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public String getScenarioStateText() {
		String val = getElementText(ScenarioStateText);
		return val;
	}

	public Status loginToMBWBackendAccount(String OSQOEmail, String OSQOPassword) {
		try {
			enterEmail(OSQOEmail);
			// enterPassword(OSQOPassword);
			clickSignInBtn();
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status selectProPertyTypeGoogleForm() {
		try {
			scrollIntoView(selectPropertyType);
			waitForElementVisibility(selectPropertyType, "20");
			click(selectPropertyType);
			waitTime(4000);
			List<WebElement> element = driver.findElements(By.xpath(
					"//span[contains(text(),'Property Type')]/../../../following-sibling::div[1]//span[@class='vRMGwf oJeWuf']"));
			String self = "House";
			selectValueFromDropdown(element, self);
			waitTime(1000);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status selectNumberOfBedroomGoogleForm() {
		try {
			scrollIntoView(selectNumberofBedrooms);
			waitForElementVisibility(selectNumberofBedrooms, "20");
			click(selectNumberofBedrooms);
			waitTime(2000);
			List<WebElement> element = driver.findElements(By.xpath(
					"//span[contains(text(),'Number of Bedrooms')]/../../../following-sibling::div[1]//span[@class='vRMGwf oJeWuf']"));
			String self = "1";
			selectValueFromDropdown(element, self);
			waitTime(1000);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterPostcodeGoogleForm() {
		try {
			scrollIntoView(postcodeTxt);
			waitForElementVisibility(postcodeTxt, "20");
			postcodeTxt.sendKeys("123");
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterPropertyAddressGoogleForm() {
		try {
			scrollIntoView(propertyAddressTxt);
			waitForElementVisibility(propertyAddressTxt, "20");
			propertyAddressTxt.sendKeys("test");
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterPropertyTitleVolumeGoogleForm() {
		try {
			scrollIntoView(propertyTitleVolumeTxt);
			waitForElementVisibility(propertyTitleVolumeTxt, "20");
			propertyTitleVolumeTxt.sendKeys("test");
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterPropertyFolioGoogleForm() {
		try {
			scrollIntoView(propertyFolioTxt);
			waitForElementVisibility(propertyFolioTxt, "20");
			propertyFolioTxt.sendKeys("test");
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterMortgageInterestateGoogleForm() {
		try {
			scrollIntoView(mortgageInterestateTxt);
			waitForElementVisibility(mortgageInterestateTxt, "20");
			mortgageInterestateTxt.sendKeys("test");
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterLoanAmountRequestGoogleForm() {
		try {
			scrollIntoView(loanAmountRequestTxt);
			waitForElementVisibility(loanAmountRequestTxt, "20");
			loanAmountRequestTxt.sendKeys("123321");
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterPropertyPurchasePriceGoogleForm() {
		try {
			scrollIntoView(propertyPurchasePriceTxt);
			waitForElementVisibility(propertyPurchasePriceTxt, "20");
			propertyPurchasePriceTxt.sendKeys("123321");
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public void addDataIntoMBWBackend(ArrayList<StepsWithHeader> testStep, ArrayList<TestSteps> subSteps) {
		try {

			subSteps.add(new TestSteps("Visit MBW Backend Url", Status.PASS));
			openURL("MBWUrl");

			subSteps.add(new TestSteps("Click on 'Accept All' button", clickAcceptAllBtnOnPopup()));

			subSteps.add(new TestSteps("Click on 'Sign in with Email", clickSignInWithEmailBtn()));

			subSteps.add(new TestSteps("Enter Email : " + MBWEmail + " And Password : " + MBWPassword,
					loginToMBWBackendAccount(MBWEmail, MBWPassword)));

			subSteps.add(new TestSteps("Click on Create Application button", clickCreateApplicationBtn()));

		} catch (Exception e) {
			testStep.add(new StepsWithHeader("Exception"));
			testStep.add(new StepsWithHeader(captureSS()));
			Assert.assertFalse(true);
		} catch (Error e) {
			testStep.add(new StepsWithHeader("Error"));
			testStep.add(new StepsWithHeader(captureSS()));
			Assert.assertFalse(true);
		}
	}

	public ArrayList<TestSteps> addDataIntoMBWBackend() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		String username = PropertiesReader.getPropertyValue(env + "_methodEmail");// username
		String password = PropertiesReader.getPropertyValue(env + "_Password");
		String secUsername = PropertiesReader.getPropertyValue(env + "_methodSecEmail");// username
		String secPassword = PropertiesReader.getPropertyValue(env + "_AppPassword");
		Status status = null;
		String OTP;
		try {

			addSubStep(subSteps, "Login to MBW Account", Status.PASS);
			openURL("MBWUrl");

			submitPassword("osqo");

			status = loginToMBWBackendAccount(MBWEmail, MBWPassword);
			addSubStep(subSteps, "Enter Email : " + MBWEmail + " And Password : " + MBWPassword, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			OTP = mailOTPReader(username, password);

			submitOtp(OTP);

			switchToIfram(iframeOne);
			int wait = 1000 * 2;
			status = clickCreateApplicationBtn();
			addSubStep(subSteps, "Click on Create Application button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			primaryFirstName = getUniqueData("first");
			status = enterPrimaryFirstNameInputField(primaryFirstName);
			addSubStep(subSteps, "Enter Primary First Name :" + primaryFirstName, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			waitTime(wait);
			primaryLastName = getUniqueData("last");
			status = enterPrimaryLastNameInputField(primaryLastName);
			addSubStep(subSteps, "Enter Primary Last Name :" + primaryLastName, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			waitTime(wait);

			primaryPhoneNumber = phoneNumber;
			status = enterPrimaryPhoneNumberInputField(primaryPhoneNumber);
			addSubStep(subSteps, "Enter Primary Phone Number : " + primaryPhoneNumber, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			waitTime(wait);

			primaryMail = secondaryEmailId;
			Random rand = new SecureRandom();

			int number = rand.nextInt(100);
			String email = "farhanghaffer+" + number + "@methodbridge.com";
			status = enterPrimaryEmailInputField(email);
			waitTime(wait);

			addSubStep(subSteps, "Enter Primary Email : " + primaryMail, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			secondaryFirstName = getUniqueData("first12");
			status = enterSecondaryFirstNameInputField(secondaryFirstName);
			addSubStep(subSteps, "Enter Secondary First Name :" + secondaryFirstName, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			waitTime(wait);

			secondaryLastName = getUniqueData("last12");
			status = enterSecondaryLastNameInputField(secondaryLastName);
			addSubStep(subSteps, "Enter Secondary Last Name :" + secondaryLastName, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			waitTime(wait);

			secondaryPhoneNumber = phoneNumber;
			status = enterSecondaryPhoneNumberInputField(secondaryPhoneNumber);
			addSubStep(subSteps, "Enter Secondary Phone Number : " + secondaryPhoneNumber, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			waitTime(wait);

			secondaryMail = primaryEmail;
			number = rand.nextInt(100);
			email = "farhanghaffer+" + number + "@methodbridge.com";

			status = enterSecondaryEmailInputField(email);
			addSubStep(subSteps, "Enter Secondary Email : " + secondaryMail, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			waitTime(wait);

			houseNumber = "1";
			status = enterHouseNumber(houseNumber);
			addSubStep(subSteps, "Enter house Number:" + houseNumber + "", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			waitTime(wait);

			postalCode = "3000";
			status = enterHousePostCodeInputField(postalCode);
			addSubStep(subSteps, "Enter Postal Code : " + postalCode, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			waitTime(wait);

			unitNumber = generateRandomNumberWithGivenNumberOfDigits(3);
			unitNumber = "2";
			status = enterUnitNumber(unitNumber);
			addSubStep(subSteps, "Enter Unit Number:" + unitNumber + "", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			waitTime(wait);

			postalCode = generateRandomNumberWithGivenNumberOfDigits(5);
			postalCode = "3001";
			status = enterUnitPostCodeInputField(postalCode);
			addSubStep(subSteps, "Enter Unit Postal Code : " + postalCode, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			waitTime(wait);

			apartmentNumber = "3";
			status = enterApartmentNumber(apartmentNumber);
			addSubStep(subSteps, "Enter Apartment Number:" + apartmentNumber + "", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			waitTime(wait);

			postalCode = generateRandomNumberWithGivenNumberOfDigits(5);
			postalCode = "3002";
			status = enterApartmentPostCodeInputField(postalCode);
			addSubStep(subSteps, "Enter Apartment Postal Code : " + postalCode, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			waitTime(wait);

			clickHomebuyerCircumstancesButton();
			waitTime(5000);

			status = clickCreateApplicationBtn();
			addSubStep(subSteps, "Click on Create Application button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			waitTime(wait);

			status = clickSaveScenarioButton();
			addSubStep(subSteps, "Click on <b>'Save Scenario'</b> button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			waitTime(5000);

			scenarioName = getUniqueData("Scenario");
			status = enterInScenarioNameInputField(scenarioName);
			addSubStep(subSteps, "Enter Scenario Name : " + scenarioName, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			waitTime(wait);
			status = clickSaveBtnOnPopup();
			addSubStep(subSteps, "Click on Save button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			waitTime(30000);

			status = clickOkBtnOnPopup();
			addSubStep(subSteps, "Click on OK button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			

			scenarioHash = getElementTextThroughAttribute(scenarioHashOnBroker);

			homebuyerHash = getElementTextThroughAttribute(homebuyerHashOnBroker);

			brokerId = getElementTextThroughAttribute(brokerIdOnBroker);

			status = clickApplyForPreConditionalApprovalButton();
			addSubStep(subSteps, "Click on <b>'ApplyForPreConditionalApproval'</b> button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

//			status = ErrorCollector.verifyTrue(verifyRequestHasBeenSubmittedPopup(), " : Verify 'Request Has Been Submitted' Popup is displaying");
//			addSubStep(subSteps, "Verify 'Request Has Been Submitted' Popup is displaying", status);
//			if (status.equals(Status.FAIL))
//				Assert.assertFalse(true);

			status = clickOkBtnOnPopup();
			addSubStep(subSteps, "Click on OK button", status);
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

	private void submitPassword(String keys) {
		waitForElementVisibility(passwordField, "20");
		passwordField.sendKeys(keys);

		click(passwordSubmit);
	}

	public ArrayList<TestSteps> addDataIntoMBWBackendz() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		Status status = null;
		try {
			addSubStep(subSteps, "Visit MBW Backend Url", Status.PASS);
			openURL("MBWUrl");
			status = clickAcceptAllBtnOnPopup();
			addSubStep(subSteps, "Click on 'Accept All' button", status);
			if (status.equals(Status.FAIL)) {
				Assert.assertFalse(true);
			}

			status = clickSignInWithEmailBtn();
			addSubStep(subSteps, "Click on 'Sign in with Email", status);
			if (status.equals(Status.FAIL)) {
				Assert.assertFalse(true);
			}

			status = loginToMBWBackendAccount(MBWEmail, MBWPassword);
			addSubStep(subSteps, "Enter Email : " + MBWEmail + " And Password : " + MBWPassword, status);
			if (status.equals(Status.FAIL)) {
				status = null;
			}

			return subSteps;
		} catch (Exception e) {
			e.printStackTrace();
			addSubStep(subSteps, captureSS(), Status.FAIL);
			return subSteps;
		} catch (Error e) {
			e.printStackTrace();
			return subSteps;
		}
	}

	public void verifyDataOnSyncSubmissionsPage(ArrayList<StepsWithHeader> testStep, ArrayList<TestSteps> subSteps) {
		try {
			subSteps.add(new TestSteps("Visit web url", Status.PASS));
			openURL("AppURLSecond");

			subSteps.add(new TestSteps("Click on login button", lp.clickOnLoginButton()));

		} catch (Exception e) {
			testStep.add(new StepsWithHeader("Exception"));
			testStep.add(new StepsWithHeader(captureSS()));
			Assert.assertFalse(true);
		} catch (Error e) {
			testStep.add(new StepsWithHeader("Error"));
			testStep.add(new StepsWithHeader(captureSS()));
			Assert.assertFalse(true);
		}
	}

	public ArrayList<TestSteps> verifyDataOnSyncSubmissionsPage(boolean flowUi, boolean flowApi) {
		CreateBondApiPage createBondApi = new CreateBondApiPage();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		String username = PropertiesReader.getPropertyValue(env + "_methodEmail");// username
		String password = PropertiesReader.getPropertyValue(env + "_Password");
		String secUsername = PropertiesReader.getPropertyValue(env + "_methodSecEmail");// username
		String secPassword = PropertiesReader.getPropertyValue(env + "_AppPassword");

		Status status = null;
		String mailFolderName = "INBOX";
		String emailSubjectContent = "OSQO - Deposit Gap Loans";
		String emailContent = "Please enter this in the DGL Portal and we�ll show you ";
		int OTPLength = 7;
		String yourCode;

		try {

			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openUrlInNewTab("AppURL");

			status = lp.enterEmail(bcpEmail);
			addSubStep(subSteps, "Enter Email : " + bcpEmail, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = lp.clickOnSubmitButton();
			addSubStep(subSteps, "click On Submit Button", status);

			// getting otp from register email
			yourCode = mailOTPReader(username, password);

			status = lp.enterYourCode(yourCode);
			addSubStep(subSteps, "Enter OTP Code : " + yourCode, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = lp.clickOnSubmitButton();
			addSubStep(subSteps, "click On Submit Button", status);

			addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Verify data on 'Sync Submissions' Page<<<<<<<<<<<<<</b>",
					status.INFO);

			status = dashboardPage.clickOnNavMenuSyncSubmissionsButton();
			addSubStep(subSteps, "Click on Navigation Menu 'Sync Submissions' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = enterSearchScenario(scenarioName);
			addSubStep(subSteps, "Enter Search Scenario : " + scenarioName, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(verifyDataIsDisplaying(scenarioName),
					" : Verify 'Scenario Name' is displaying");
			addSubStep(subSteps, "Verify Scenario Name '" + scenarioName + " is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnSyncButton(scenarioName);
			addSubStep(subSteps, "Click on 'Sync' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			waitTime(8000);
			getRefreshWebPage();

			waitTime(55000);
			// verify document on broker
			addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Sign document for broker<<<<<<<<<<<<<</b>", status.INFO);
			verifyDocument(subSteps, status, username, password);

			closeBrowser();
			shiftWindowHandle(1);

			waitTime(55000);
			// Primary
			addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Sign document for primary<<<<<<<<<<<<<</b>", status.INFO);
			verifyDocument(subSteps, status, username, password);

			closeBrowser();
			shiftWindowHandle(1);

			waitTime(55000);
			// secondary
			addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Sign document for secondary<<<<<<<<<<<<<</b>", status.INFO);
			verifyDocument(subSteps, status, username, password);

			closeBrowser();
			shiftWindowHandle(1);

			addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Verify data on 'Scenario' Page<<<<<<<<<<<<<</b>", status.INFO);

			status = clickOnScenarioListMenuButton();
			addSubStep(subSteps, "Click on Scenario List Menu button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = enterSearchScenario(scenarioName);
			addSubStep(subSteps, "Enter Search Scenario : " + scenarioName, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnDetailsButton(scenarioName);
			addSubStep(subSteps, "Click on 'Details' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(verifyHomebuyerHash(homebuyerHash),
					" : Verify <b>'Homebuyer Hash :'" + getElementText(borrowerHashElement) + "'</b> is displaying");
			addSubStep(subSteps,
					"Verify <b>'Homebuyer Hash '" + getElementText(borrowerHashElement) + "'</b> is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyScenarioHash(scenarioHash),
					" : Verify <b>'Scenario Hash :'" + getElementText(scenarioHashElement) + "'</b> is displaying");
			addSubStep(subSteps,
					"Verify <b>'Scenario Hash '" + getElementText(scenarioHashElement) + "'</b> is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(verifyApprovePreApprovalBtn(),
					" : Verify 'Approve Pre Approval' button is displaying");
			addSubStep(subSteps, "Verify 'Approve Pre Approval' button is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(verifyRejectPreApprovalBtn(),
					" : Verify 'Reject Pre Approval' button is displaying");
			addSubStep(subSteps, "Verify 'Reject Pre Approval' button is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnApprovePreApprovalButton();
			addSubStep(subSteps, "Click On<b>'Approve Pre Approval'</b> Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(verifySuccessScenarioMessage(), " : Verify Success Message is displaying");
			addSubStep(subSteps, "Verify 'Success Message is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);			

			status = ErrorCollector.verifyFalse(verifyApprovePreApprovalBtn(),
					" : Verify 'Approve Pre Approval' button is not displaying");
			addSubStep(subSteps, "Verify 'Approve Pre Approval' button is not displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyFalse(verifyRejectPreApprovalBtn(),
					" : Verify 'Reject Pre Approval' button is not displaying");
			addSubStep(subSteps, "Verify 'Reject Pre Approval' button is not displaying", status);
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

	public ArrayList<TestSteps> verifyLoginAndLogout(boolean flowUi, boolean flowApi) {
		CreateBondApiPage createBondApi = new CreateBondApiPage();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		String username = PropertiesReader.getPropertyValue(env + "_methodEmail");// username
		String password = PropertiesReader.getPropertyValue(env + "_Password");
		String secUsername = PropertiesReader.getPropertyValue(env + "_methodSecEmail");// username
		String secPassword = PropertiesReader.getPropertyValue(env + "_AppPassword");

		Status status = null;
		String mailFolderName = "INBOX";
		String emailSubjectContent = "OSQO - Deposit Gap Loans";
		String emailContent = "Please enter this in the DGL Portal and we�ll show you ";
		int OTPLength = 7;
		String yourCode;
		String senarioName;

		try {

			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			navigateToURL("AppURL");

			status = lp.enterEmail(bcpEmail);
			addSubStep(subSteps, "Enter Email : " + bcpEmail, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = lp.clickOnSubmitButton();
			addSubStep(subSteps, "click On Submit Button", status);

			// getting otp from register email
			yourCode = mailOTPReader(username, password);

			status = lp.enterYourCode(yourCode);
			addSubStep(subSteps, "Enter OTP Code : " + yourCode, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = lp.clickOnSubmitButton();
			addSubStep(subSteps, "click On Submit Button", status);

			addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Verify data on 'Sync Submissions' Page<<<<<<<<<<<<<</b>",
					status.INFO);

			status = dashboardPage.clickOnSyncSubmissionsButton();
			addSubStep(subSteps, "Click on Navigation Menu 'Sync Submissions' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			senarioName = getSenarioName();
			status = enterSearchScenario(senarioName);
			addSubStep(subSteps, "Enter Search Scenario : " + senarioName, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(verifyDataIsDisplaying(senarioName),
					" : Verify 'Scenario Name' is displaying");
			addSubStep(subSteps, "Verify Scenario Name '" + senarioName + " is displaying", status);
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

			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			return subSteps;
		} catch (Exception e) {
			waitTime(3000);
			addSubStep(subSteps, captureSS(), Status.FAIL);
			return subSteps;

		} catch (Error e) {
			waitTime(3000);
			addSubStep(subSteps, captureSS(), Status.FAIL);
			return subSteps;
		}
	}

	
	public ArrayList<TestSteps> verifyDocument(ArrayList<TestSteps> subSteps, Status status, String username,
			String password) {
		try {

			String docUrl;
			docUrl = mailUrlReader(username, password);
			subSteps.add(new TestSteps("open review document url", Status.PASS));
			openUrlInNewTabWithTabNumber(docUrl, 2);

			status = clickDocAcceptAndContinueButton();
			addSubStep(subSteps, "Click on Document 'Accept And Continue' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnDocBeginButton();
			addSubStep(subSteps, "Click on Document 'Begin' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			String name = getUniqueData("Test");
			status = enterDocTypeYourNameInputField(name);
			addSubStep(subSteps, "Enter Your Name :" + name, status);

			status = clickOnDocAdoptButton();
			addSubStep(subSteps, "Click on Document 'Adopt' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			String testInput = getUniqueData("Test");
			status = enterDocInputTextInputField(testInput);
			addSubStep(subSteps, "Enter Input text :" + testInput, status);

			status = clickOnDocInputTextSaveButton();
			addSubStep(subSteps, "Click on Document Input Text Popup 'Save' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnDocSignAndFinishButton();
			addSubStep(subSteps, "Click on Document 'Sign And Finish' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(verifyDocThankYouForSigningTheDocument(),
					" : Verify 'Thank You For Signing The Document' Message is displaying");
			addSubStep(subSteps, "Verify 'Thank You For Signing The Document' Message is displaying", status);
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

//	public void verifyDataOnSyncSubmissionsPageNotDisplaying(ArrayList<StepsWithHeader> testStep) {
//		testStep.add(new StepsWithHeader("Verify Name <b>'" + primaryFirstName + "'</b> is not displaying"));
//		ErrorCollector.verifyFalse(verifyDataIsDisplaying(primaryFirstName), " : Verify ' Name' is not displaying");
//
//		testStep.add(new StepsWithHeader("Verify Scanrio Name '" + scenarioName + "' is not displaying"));
//		ErrorCollector.verifyFalse(verifyDataIsDisplaying(scenarioName), " : Verify 'Scanrio Name' is not displaying");
//
//		testStep.add(new StepsWithHeader("Verify Primary Email '" + primaryMail + " is not displaying"));
//		ErrorCollector.verifyFalse(verifyDataIsDisplaying(primaryMail), " : Verify 'Primary Email' is not displaying");
//
//	}

	public ArrayList<TestSteps> verifyDataOnScenariosPage() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		Status status = null;

		try {
			status = dashboardPage.clickOnMenuScenariosButton();
			addSubStep(subSteps, "Click on 'Scenario' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			waitTime(8000);
			getRefreshWebPage();

			status = ErrorCollector.verifyTrue(verifyDataIsDisplaying(primaryMail), " : Verify 'Email' is displaying");
			addSubStep(subSteps, "Verify 'Email' is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnDetailsButton(primaryMail);
			addSubStep(subSteps, "Click on 'Details' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			scenarioId = getScenarioIdText();

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

	public ArrayList<TestSteps> verifyDataOnHomeBuyersPage(boolean flowUi, boolean flowApi) {
		CreateBondApiPage createBondApi = new CreateBondApiPage();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		Status status = null;
		try {

			status = clickOnViewBorrowerDetailsButton();
			addSubStep(subSteps, "Click on 'View Home Buyer Details' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(verifyDataIsDisplaying(primaryFirstName),
					" : Verify ' Name' is displaying");
			addSubStep(subSteps, "Verify First Name <b>'" + primaryFirstName + "'</b> is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(verifyDataIsDisplaying(primaryLastName),
					" : Verify 'Scanrio Name' is displaying");
			addSubStep(subSteps, "Verify Last Name '" + primaryLastName + "' is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(verifyDataIsDisplaying(primaryPhoneNumber),
					" : Verify 'Email' is displaying");
			addSubStep(subSteps, "Verify Primary Phone Number '" + primaryPhoneNumber + "' is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			if (flowUi == true) {
				status = clickOnBackButton();
				addSubStep(subSteps, "Click On<b>'Back'</b> Button", status);
				if (status.equals(Status.FAIL))
					Assert.assertFalse(true);

				status = clickOnSyncButton(primaryMail);
				addSubStep(subSteps, "Click on 'Details' button", status);
				if (status.equals(Status.FAIL))
					Assert.assertFalse(true);

				status = clickOnApprovePreApprovalButton();
				addSubStep(subSteps, "Click On<b>'Approve Pre Approval'</b> Button", status);
				if (status.equals(Status.FAIL))
					Assert.assertFalse(true);

				waitTime(3000);

			} else if (flowApi == true) {
				status = createBondApi.APPROVED_PREAPPROVAL_SECOND(scenarioId);
				addSubStep(subSteps, " Again sending request to <b>API</b> for <b>'Approved Pre Approval'</b>", status);
				if (status.equals(Status.FAIL))
					Assert.assertFalse(true);
			}

			closeBrowser();
			shiftWindowHandle(0);

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

	public ArrayList<TestSteps> verifyDataOnHomeBuyersPageApi() {
		CreateBondApiPage createBondApi = new CreateBondApiPage();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		Status status = null;
		try {

			status = clickOnViewBorrowerDetailsButton();
			addSubStep(subSteps, "Click on 'View Home Buyer Details' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(verifyDataIsDisplaying(primaryFirstName),
					" : Verify ' Name' is displaying");
			addSubStep(subSteps, "Verify First Name <b>'" + primaryFirstName + "'</b> is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(verifyDataIsDisplaying(primaryLastName),
					" : Verify 'Scanrio Name' is displaying");
			addSubStep(subSteps, "Verify Last Name '" + primaryLastName + "' is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(verifyDataIsDisplaying(primaryPhoneNumber),
					" : Verify 'Email' is displaying");
			addSubStep(subSteps, "Verify Primary Phone Number '" + primaryPhoneNumber + "' is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = createBondApi.APPROVED_PREAPPROVAL(scenarioId);
			addSubStep(subSteps, "Sending request to <b>API</b> for <b>'Approved Pre Approval'</b>", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = createBondApi.APPROVED_PREAPPROVAL_SECOND(scenarioId);
			addSubStep(subSteps, " Again sending request to <b>API</b> for <b>'Approved Pre Approval'</b>", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			closeBrowser();
			shiftWindowHandle(0);

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

	public void verifyDataOnHomeBuyerDetailsPage(ArrayList<StepsWithHeader> testStep) {
		testStep.add(
				new StepsWithHeader("Step 33 : Verify First Name <b>'" + primaryFirstName + "'</b> is displaying"));
		ErrorCollector.verifyTrue(verifyDataIsDisplaying(primaryFirstName),
				" : Verify Primary 'First Name' is displaying");

		testStep.add(new StepsWithHeader("Step 34 : Verify primary Last Name '" + primaryLastName + "' is displaying"));
		ErrorCollector.verifyTrue(verifyDataIsDisplaying(primaryLastName),
				" : Verify Primary 'Last Name' is displaying");

		testStep.add(new StepsWithHeader(
				"Step 35 : Verify Primary Phone Number '" + primaryPhoneNumber + "' is displaying"));
		ErrorCollector.verifyTrue(verifyDataIsDisplaying(primaryPhoneNumber), " : Verify 'Email' is displaying");

	}

	public void verifyDataOnSyncPersonalDataPage(ArrayList<StepsWithHeader> testStep) {
		testStep.add(new StepsWithHeader("Step 63 : Verify 'Home Buyer ID' is displaying"));
		ErrorCollector.verifyTrue(verifyDataIsDisplaying(HB), " : Verify 'Home Buyer ID' is displaying");

		testStep.add(new StepsWithHeader("Step 64 : Verify 'Compaign ID' is displaying"));
		ErrorCollector.verifyTrue(verifyDataIsDisplaying(CP), " : Verify 'Compaign ID' is displaying");

		testStep.add(new StepsWithHeader("Step 29 : Click on 'Sync' button."));
		clickOnSyncButtonAgainstHomeBuyer(HB);

	}

	public ArrayList<TestSteps> addDataIntoGoogleForm() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		Status status = null;
		try {

			status = clickStep3ConditionalApprovalButton();
			addSubStep(subSteps, "Click on 'Submit for conditional approval' button.", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			shiftWindowHandle(1);

			status = googleSingIn(MBWEmail, MBWPassword);
			addSubStep(subSteps, "Signing In to Google Account", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			HB = getHomeBuyerIdFromGoogleForm();
			if (HB == null || HB.trim().length() == 0) {
				status = Status.FAIL;
			}
			status = Status.PASS;
			addSubStep(subSteps, "HomeBuyer ID on googleform: " + HB, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			CP = getCompaignIdFromGoogleForm();
			if (CP == null || CP.trim().length() == 0) {
				status = Status.FAIL;
			}
			status = Status.PASS;
			addSubStep(subSteps, "Compaign ID on google form", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			salutation = getUniqueData("salutation");
			status = FillFieldsInGoogleForm("Salutation", salutation);
			addSubStep(subSteps, "Entered 'Salutation': " + salutation, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			FirstName = getUniqueData("first");
			status = FillFieldsInGoogleForm("First Name", FirstName);
			addSubStep(subSteps, "Entered 'First Name': " + FirstName, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			LastName = getUniqueData("last");
			status = FillFieldsInGoogleForm("Last Name", LastName);
			addSubStep(subSteps, "Entered 'Last Name': " + FirstName, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = selectSelfFieldInDropdownGoogleForm();
			addSubStep(subSteps, "Selecting 'Tile/Role': Self", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = FillFieldsInGoogleForm("Email Address", MBWEmail);
			addSubStep(subSteps, "Entered 'Email': " + MBWEmail, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			city = getUniqueData("city");
			status = FillFieldsInGoogleForm("City", city);
			addSubStep(subSteps, "Entered 'City': " + city, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			province = getUniqueData("State/Province/Territory");
			status = FillFieldsInGoogleForm("State/Province/Territory", province);
			addSubStep(subSteps, "Entered 'State/Province/Territory': " + province, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			postcode = getUniqueData("Postcode");
			status = FillFieldsInGoogleForm("Postcode", postcode);
			addSubStep(subSteps, "Entered 'Postcode': " + postcode, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			Phone_Number = generateRandomNumberWithGivenNumberOfDigits(13);
			status = FillFieldsInGoogleForm("Phone Number", Phone_Number);
			addSubStep(subSteps, "Entered 'Phone Number': " + Phone_Number, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			passportId = getUniqueData("Passport ID");
			status = FillFieldsInGoogleForm("Passport ID", passportId);
			addSubStep(subSteps, "Entered 'Passport ID': " + passportId, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			driversLicenseId = getUniqueData("Drivers License ID");
			status = FillFieldsInGoogleForm("Drivers License ID", driversLicenseId);
			addSubStep(subSteps, "Entered 'Drivers License ID': " + driversLicenseId, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			swiftId = getUniqueData("SwiftID");
			status = FillFieldsInGoogleForm("SwiftID", swiftId);
			addSubStep(subSteps, "Entered 'SwiftID': " + swiftId, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickNextBtnOnGoogleSignIn();
			addSubStep(subSteps, "Click on 'Next' button ", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickGuarantorNoRadioBtn();
			addSubStep(subSteps, "Click on 'No' under Guarantor", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickNextBtnOnGoogleSignIn();
			addSubStep(subSteps, "Click on 'Next' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickBondBuyerYesRadioBtn();
			addSubStep(subSteps, "Click on 'Yes' under Bond Buyer", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickNextBtnOnGoogleSignIn();
			addSubStep(subSteps, "Click on 'Next' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = selectBondBuyerDropdownGoogleForm();
			addSubStep(subSteps, "Selecting 'Bond Buyer Type': RTP - Related Third Party (Friends & Family)", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			placement_ammount = generateRandomNumberWithGivenNumberOfDigits(8);
			status = FillFieldsInGoogleForm("Placement Amount", placement_ammount);
			addSubStep(subSteps, "Entered 'Placement Amount': " + placement_ammount, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = FillFieldsInGoogleForm("Salutation", salutation);
			addSubStep(subSteps, "Entered 'Salutation': " + salutation, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = FillFieldsInGoogleForm("First Name", FirstName);
			addSubStep(subSteps, "Entered 'First Name': " + FirstName, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = FillFieldsInGoogleForm("Last Name", LastName);
			addSubStep(subSteps, "Entered 'Last Name': " + LastName, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = selectSelfFieldInDropdownGoogleForm();
			addSubStep(subSteps, "Selecting 'Tile/Role': Self", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			address = getUniqueData("address");
			status = FillAddressFieldInGoogleForm(address);
			addSubStep(subSteps, "Entered 'Address': " + address, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = FillFieldsInGoogleForm("City", city);
			addSubStep(subSteps, "Entered 'City': " + city, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = FillFieldsInGoogleForm("State/Province/Territory", province);
			addSubStep(subSteps, "Entered 'State/Province/Territory': " + province, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = FillFieldsInGoogleForm("Postcode", postcode);
			addSubStep(subSteps, "Entered 'Postcode': " + postcode, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = selectDobDropdownGoogleForm();
			addSubStep(subSteps, "Entered 'Date of Birth': 1992-02-02", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickNextBtnOnGoogleSignIn();
			addSubStep(subSteps, "Click on 'Next' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickGuarantorNoRadioBtn();
			addSubStep(subSteps, "Click on 'No' under Guarantor", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickNextBtnOnGoogleSignIn();
			addSubStep(subSteps, "Click on 'Next' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickSubmitBtn();
			addSubStep(subSteps, "Click on 'Submit' button", status);
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

	public ArrayList<TestSteps> verifyDataOnSyncPersonalPage(boolean flowUi, boolean flowApi) {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		CreateBondApiPage createBondApi = new CreateBondApiPage();
		String username = PropertiesReader.getPropertyValue(env + "_methodEmail");// username
		String password = PropertiesReader.getPropertyValue(env + "_Password");
		String step3Url = "https://step3.dev.osqo.com.au/?b_hash=" + homebuyerHash + "&s_hash=" + scenarioHash + "";
		Status status = null;
		String yourCode;
		String firstName = "Test";
		String lastName = "User";
		String address = "XYZ";
		String gurantorCity = "XYZ";
		String gurantorPostcode = "5000";
		String gurantorDOB = "11/11/1990";
		String amount = "5000";
		
		
		
		
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURLInSameTab(step3Url);
//			openUrlNewTab(step3Url);

//			try {
//				status = lp.enterEmail(bcpEmail);
//				addSubStep(subSteps, "Enter Email : " + bcpEmail, status);
//				if (status.equals(Status.FAIL))
//					Assert.assertFalse(true);
//
//				status = lp.clickOnSubmitButton();
//				addSubStep(subSteps, "click On Submit Button", status);
//
//				// getting otp from register email
//				yourCode = mailOTPReader(username, password);
//
//				status = lp.enterYourCode(yourCode);
//				addSubStep(subSteps, "Enter OTP Code : " + yourCode, status);
//				if (status.equals(Status.FAIL))
//					Assert.assertFalse(true);
//
//				status = lp.clickOnSubmitButton();
//				addSubStep(subSteps, "click On Submit Button", status);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}

			status = selectSalutationOption();
			addSubStep(subSteps, "Selected Salutation Option From Dropdown", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = enterPhoneNumber(Phone_Number);
			addSubStep(subSteps, "Enter Phone Number :" + Phone_Number + "", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnNextButton(1);
			addSubStep(subSteps, "click on <b>'Next'</b> button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = selectSalutationOption();
			addSubStep(subSteps, "Selected Salutation Option From Dropdown", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = enterPhoneNumber(Phone_Number);
			addSubStep(subSteps, "Enter Phone Number :" + Phone_Number + "", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnNextButton(1);
			addSubStep(subSteps, "click on <b>'Next'</b> button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(verifyGuarantorTitleOnHomeBuyerForm(),
					" : Verified <b>'Guarantor'</b> Title is displaying");
			addSubStep(subSteps, "Verified <b>'Guaranto'</b> Title is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = clickOnGurantorYesRadioButton();
			addSubStep(subSteps, "click on <b>'Yes'</b> radio button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = clickOnNextButton(2);
			addSubStep(subSteps, "click on <b>'Next'</b> button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = selectRelationshipOption();
			addSubStep(subSteps, "select <b>'Relationship'</b> Option", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = selectSalutationOnGurantorOption();
			addSubStep(subSteps, "select <b>'Salutation'</b> Option", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = enterGurantorFirstName(firstName);
			addSubStep(subSteps, "Enter first Name:" + firstName + "", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = enterGurantorLastName(lastName);
			addSubStep(subSteps, "Enter last Name:" + lastName + "", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = selectGurantorTitleRoleOption();
			addSubStep(subSteps, "select <b>'TitleRole'</b> Option", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = enterGurantorAddress(address);
			addSubStep(subSteps, "Enter address:" + address + "", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = enterGurantorCity(gurantorCity);
			addSubStep(subSteps, "Enter city:" + gurantorCity + "", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = enterGurantorPostcode(gurantorPostcode);
			addSubStep(subSteps, "Enter postcode:" + gurantorPostcode + "", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = selectGurantorStateProvinceTerritoryOption();
			addSubStep(subSteps, "select <b>'State/Province/Territory'</b> Option", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = enterGurantorDOB(gurantorDOB);
			addSubStep(subSteps, "Enter DOB:" + gurantorDOB + "", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = clickOnNextButton(3);
			addSubStep(subSteps, "click on <b>'Next'</b> button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyInvestorTitleOnHomeBuyerForm(),
					" : Verified <b>'Investor'</b> Title is displaying");
			addSubStep(subSteps, "Verified <b>'Investor'</b> Title is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = clickInvestorYesRadioButton();
			addSubStep(subSteps, "click on <b>'Yes'</b> radio button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = clickOnNextButton(4);
			addSubStep(subSteps, "click on <b>'Next'</b> button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = selectInvestorTypeOption();
			addSubStep(subSteps, "select <b>'Type'</b> Option", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = enterInvestorPlacementAmount(amount);
			addSubStep(subSteps, "Enter Placement amount:" + amount + "", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = selectInvestorSalutationOption();
			addSubStep(subSteps, "select <b>'Salutation'</b> Option", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = enterInvestorFirstName(firstName);
			addSubStep(subSteps, "Enter first name:" + firstName + "", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = enterInvestorLastName(lastName);
			addSubStep(subSteps, "Enter last name:" + lastName + "", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = selectInvestorTitleRoleOption();
			addSubStep(subSteps, "select <b>'Title/Role'</b> Option", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = enterInvestorAddress(address);
			addSubStep(subSteps, "Enter address:" + address + "", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = enterInvestorCity(gurantorCity);
			addSubStep(subSteps, "Enter city:" + gurantorCity + "", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = selectInvestorStateProvinceTerritoryOption();
			addSubStep(subSteps, "select <b>'State/Province/Territory'</b> Option", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = enterInvestorPostcode(gurantorPostcode);
			addSubStep(subSteps, "Enter postcode:" + gurantorPostcode + "", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = enterInvestorDOB(gurantorDOB);
			addSubStep(subSteps, "Enter DOB:" + gurantorDOB + "", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnNextButton(5);
			addSubStep(subSteps, "click on <b>'Next'</b> button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyAdditionalInvestorTitle(),
					" : Verified <b>'Additional Investor'</b> Title is displaying");
			addSubStep(subSteps, "Verified <b>'Additional Investor'</b> Title is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);	
						
			status = clickPreviewButton();
			addSubStep(subSteps, "click on <b>'Preview'</b> button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
//			status = clickSubmitBtn();
//			addSubStep(subSteps, "click on <b>'Submit'</b> button", status);
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

	public ArrayList<TestSteps> verifyHomeBuyerPartyUpdatekyc(boolean flowUi, boolean flowApi) {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		CreateBondApiPage createBondApi = new CreateBondApiPage();
		Status status = null;
		try {
			status = clickOnViewBorrowerDetailsButton();
			addSubStep(subSteps, "Click on 'View Home Buyer Details' button.", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = enterInKycParameters();
			addSubStep(subSteps, "Enter In Kyc Parameters: test", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			if (flowUi == true) {
				status = clickApproveKYCButton();
				addSubStep(subSteps, "Click On<b>'Approve KYC'</b> Button", status);
				if (status.equals(Status.FAIL))
					Assert.assertFalse(true);
			} else if (flowApi == true) {
				status = createBondApi.KYC_APPROVAL();
				addSubStep(subSteps, " Sending request to <b>API</b> for <b>'KYC_Approval'</b>", status);
				if (status.equals(Status.FAIL))
					Assert.assertFalse(true);
			}

			try {
				status = ErrorCollector.verifyTrue(verifyDataIsDisplaying(salutation),
						" : Verify 'Salutation' is displaying");
				if (status.equals(Status.FAIL))
					Assert.assertFalse(true);
				addSubStep(subSteps, "Verify 'Salutation' is displaying", status);

			} catch (Exception e) {
				addSubStep(subSteps, "Verified 'Salutation' is not displaying", status);
			} catch (Error e) {
				addSubStep(subSteps, "Verified 'Salutation' is not displaying", status);
			}

			try {
				status = ErrorCollector.verifyTrue(verifyDataIsDisplaying(FirstName),
						" : Verify 'First Name' is displaying");
				if (status.equals(Status.FAIL))
					Assert.assertFalse(true);
				addSubStep(subSteps, "Verify 'First Name' is displaying", status);

			} catch (Exception e) {
				addSubStep(subSteps, "Verified 'First Name' is not displaying", status);
			} catch (Error e) {
				addSubStep(subSteps, "Verified 'First Name' is not displaying", status);
			}

			try {
				status = ErrorCollector.verifyTrue(verifyDataIsDisplaying(LastName),
						" : Verify 'Last Name' is displaying");
				if (status.equals(Status.FAIL))
					Assert.assertFalse(true);
				addSubStep(subSteps, "Verify 'Last Name' is displaying", status);

			} catch (Exception e) {
				addSubStep(subSteps, "Verified 'Last Name' is not displaying", status);
			} catch (Error e) {
				addSubStep(subSteps, "Verified 'Last Name' is not displaying", status);
			}

			try {
				status = ErrorCollector.verifyTrue(verifyDataIsDisplaying(MBWEmail),
						" : Verify 'Email Address' is displaying");
				if (status.equals(Status.FAIL))
					Assert.assertFalse(true);
				addSubStep(subSteps, "Verify 'Email Address' is displaying", status);

			} catch (Exception e) {
				addSubStep(subSteps, "Verify 'Email Address' is not displaying", status);
			} catch (Error e) {
				addSubStep(subSteps, "Verify 'Email Address' is not displaying", status);
			}

			try {
				status = ErrorCollector.verifyTrue(verifyDataIsDisplaying(city), " : Verify 'City' is displaying");
				if (status.equals(Status.FAIL))
					Assert.assertFalse(true);
				addSubStep(subSteps, "Verify 'City' is displaying", status);

			} catch (Exception e) {
				addSubStep(subSteps, "Verify 'City' is not displaying", status);
			} catch (Error e) {
				addSubStep(subSteps, "Verify 'City' is not displaying", status);
			}

			try {
				status = ErrorCollector.verifyTrue(verifyDataIsDisplaying(province),
						" : Verify 'Province' is displaying");
				if (status.equals(Status.FAIL))
					Assert.assertFalse(true);
				addSubStep(subSteps, "Verify 'Province' is displaying", status);

			} catch (Exception e) {
				addSubStep(subSteps, "Verify 'Province' is not displaying", status);
			} catch (Error e) {
				addSubStep(subSteps, "Verify 'Province' is not displaying", status);
			}

			try {
				status = ErrorCollector.verifyTrue(verifyDataIsDisplaying(postcode),
						" : Verify 'Post Code' is displaying");
				if (status.equals(Status.FAIL))
					Assert.assertFalse(true);
				addSubStep(subSteps, "Verify 'Post Code' is displaying", status);

			} catch (Exception e) {
				addSubStep(subSteps, "Verify 'Post Code' is not displaying", status);
			} catch (Error e) {
				addSubStep(subSteps, "Verify 'Post Code' is not displaying", status);
			}

			try {
				status = ErrorCollector.verifyTrue(verifyDataIsDisplaying(Phone_Number),
						" : Verify 'Phone Number' is displaying");
				if (status.equals(Status.FAIL))
					Assert.assertFalse(true);
				addSubStep(subSteps, "Verify 'Phone Number' is displaying", status);

			} catch (Exception e) {
				addSubStep(subSteps, "Verify 'Phone Number' is not displaying", status);
			} catch (Error e) {
				addSubStep(subSteps, "Verify 'Phone Number' is not displaying", status);
			}

			try {
				status = ErrorCollector.verifyTrue(verifyDataIsDisplaying(passportId),
						" : Verify 'Passport Id' is displaying");
				if (status.equals(Status.FAIL))
					Assert.assertFalse(true);
				addSubStep(subSteps, "Verify 'Passport Id' is displaying", status);

			} catch (Exception e) {
				addSubStep(subSteps, "Verify 'Passport Id' is not displaying", status);
			} catch (Error e) {
				addSubStep(subSteps, "Verify 'Passport Id' is not displaying", status);
			}

			try {
				status = ErrorCollector.verifyTrue(verifyDataIsDisplaying(driversLicenseId),
						" : Verify 'Driver License ID' is displaying");
				if (status.equals(Status.FAIL))
					Assert.assertFalse(true);
				addSubStep(subSteps, "Verify 'Driver License ID' is displaying", status);

			} catch (Exception e) {
				addSubStep(subSteps, "Verify 'Driver License ID' is not displaying", status);
			} catch (Error e) {
				addSubStep(subSteps, "Verify 'Driver License ID' is not displaying", status);
			}

			try {
				status = ErrorCollector.verifyTrue(verifyDataIsDisplaying(swiftId),
						" : Verify 'Swift ID' is displaying");
				if (status.equals(Status.FAIL))
					Assert.assertFalse(true);
				addSubStep(subSteps, "Verify 'Swift ID' is displaying", status);

			} catch (Exception e) {
				addSubStep(subSteps, "Verify 'Swift ID' is not displaying", status);
			} catch (Error e) {
				addSubStep(subSteps, "Verify 'Swift ID' is not displaying", status);
			}

			if (flowApi == true) {
				status = createBondApi.PASSEDKYC_CONAPPROVAL(scenarioId);
				addSubStep(subSteps, " Sending request to <b>API</b> for <b>'PASSEDKYC_CONAPPROVAL'</b> ", status);
				if (status.equals(Status.FAIL))
					Assert.assertFalse(true);
			}
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

	public ArrayList<TestSteps> approveKYCOnBondBuyersPage() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		Status status = null;

		try {
			status = dashboardPage.clickOnMenuBondBuyersButton();
			addSubStep(subSteps, "Click on Navigation Menu 'Bond Buyers' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnSyncButtonAgainstHomeBuyer(HB);
			addSubStep(subSteps, "Click on 'Details' button.", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = enterInKycParameters();
			addSubStep(subSteps, "Enter In Kyc Parameters: test", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickApproveKYCButton();
			addSubStep(subSteps, "Click On<b>'Approve KYC'</b> Button", status);
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

	public ArrayList<TestSteps> approveKYCOnScenariosDetialsPage() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		Status status = null;

		try {
			waitTime(2000);
			status = dashboardPage.clickOnMenuScenariosButton();
			addSubStep(subSteps, "Click on Navigation Menu 'Scenarios' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(dashboardPage.isTitleSynchronizedScenariosDisplaying(),
					"Verified <b>Synchronized Scenario</b> is displaying");
			addSubStep(subSteps, "Verify <b>Synchronized Scenario</b> is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			waitTime(10000);
			getRefreshWebPage();

			status = dashboardPage.select100Entries();
			addSubStep(subSteps, "select '100' Entries to show", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			waitTime(3000);

			status = clickOnDetailsButton(HB);
			addSubStep(subSteps, "Click on 'Details' button.", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			waitTime(3000);

			status = clickApproveKYCButton();
			addSubStep(subSteps, "Click On<b>'Approve KYC'</b> Button", status);
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

	public ArrayList<TestSteps> espStep4(boolean flowUi, boolean flowApi) {
		CreateBondApiPage createBondApi = new CreateBondApiPage();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		Status status = null;

		try {

			subSteps.add(new TestSteps("Login to ESP Account", Status.PASS));
			openURL("AppURL");

//			status = lp.loginToOSQOAccount(espEmail, espPass);
//			addSubStep(subSteps, "Enter ESP Email : " + espEmail + " And Password : " + espPass, status);
//			if (status.equals(Status.FAIL))
//				Assert.assertFalse(true);

			status = clickOnScenarioListMenuButton();
			addSubStep(subSteps, "Click on Scenario List Menu button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnDetialsButton(HB);
			addSubStep(subSteps, "Click on 'Details' button.", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = chosefileUploadPreApproval();
			addSubStep(subSteps, "Chose File Upload Pre Approval", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = chosefileUploadDeedOfGurantee();
			addSubStep(subSteps, "Chose File Upload 'Deed Of Gurantee'", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = chosefileUploadFAndFODFSupplementary();
			addSubStep(subSteps, "Chose File Upload 'F&F ODF Supplementary IM (SIM)'", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(verifyPreApprovalOpenFileMessage(),
					"Verified Pre Approval <b>Open File</b> Message is displaying");
			addSubStep(subSteps, "Verified Pre Approval <b>Open File</b> Message is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(verifyDeedOfGuranteeOpenFileMessage(),
					"Verified Deed Of Gurantee <b>Open File</b> Message is displaying");
			addSubStep(subSteps, "Verified Deed Of Gurantee <b>Open File</b> Message is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(verifyFAndFSupplementaryOpenFileMessage(),
					"Verified F&F ODF Supplementary IM (SIM) <b>Open File</b> Message is displaying");
			addSubStep(subSteps, "Verified F&F ODF Supplementary IM (SIM) <b>Open File</b> Message is displaying",
					status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			if (flowUi == true) {
				status = clickSubmitBtn();
				addSubStep(subSteps, "Click on 'Submit' button", status);
				if (status.equals(Status.FAIL))
					Assert.assertFalse(true);
			} else if (flowApi == true) {

				status = createBondApi.ESP_STEP4_COMPLETED_SubmitButton(scenarioId);
				addSubStep(subSteps, " Sending request to <b>API</b> for <b>'ESP_STEP4_COMPLETED Submit Button'</b>",
						status);
				addSubStep(subSteps, "<b>ESP_STEP4_COMPLETED Submit Button API Response :</b> <b>'"
						+ CreateBondApiPage.apiStatusMsg + "'</b>", status);
				if (status.equals(Status.FAIL))
					Assert.assertFalse(true);
			}
			status = clickOnLogoutButton();
			addSubStep(subSteps, "Click on 'Logout' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			waitTime(10000);
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

	public ArrayList<TestSteps> addPropertyPurchaseDetailsStep5(boolean flowUi, boolean flowApi) {
		CreateBondApiPage createBondApi = new CreateBondApiPage();
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		Status status = null;

		try {

			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));

			status = lp.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = dashboardPage.clickOnMenuScenariosButton();
			addSubStep(subSteps, "Click on Navigation Menu 'Scenarios' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			waitTime(10000);
			getRefreshWebPage();

			status = dashboardPage.select100Entries();
			waitTime(3000);

			status = ErrorCollector.verifyTrue(verifyEspStep4Completed(),
					"Verified <b>Esp Step4 Completed</b> is displaying");
			addSubStep(subSteps, "Verified <b>Esp Step4 Completed</b> is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnDetialsButton(HB);
			addSubStep(subSteps, "Click on 'Details' button.", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Approve Prelim Con-Approval Button<<<<<<<<<<<<<</b>", status.INFO);

			if (flowUi == true) {
				status = clickOnApprovePrelimConApprovalButton();
				addSubStep(subSteps, "Click On<b>'Approve Prelim Con-Approval'</b> Button", status);
				if (status.equals(Status.FAIL))
					Assert.assertFalse(true);

			} else if (flowApi == true) {
				status = createBondApi.APPROVED_CONAPPROVAL(scenarioId);
				addSubStep(subSteps, " Sending request to <b>API</b> for <b>'APPROVED_CONAPPROVAL'</b>", status);
				addSubStep(subSteps,
						"<b>APPROVED_CONAPPROVAL API Response :</b> <b>'" + CreateBondApiPage.apiStatusMsg + "'</b>",
						status);
				if (status.equals(Status.FAIL))
					Assert.assertFalse(true);
			}
			waitTime(10000);

			status = clickOnBackButton();

			waitTime(10000);
			getRefreshWebPage();

			closeBrowser();
			shiftWindowHandle(0);

			addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Adding data 'Property Purchase Details'<<<<<<<<<<<<<</b>",
					status.INFO);

			status = clickOnSubmitPropertyPurchaseDetailsButton();
			addSubStep(subSteps, "Click on 'Submit Property Purchase Details (Step5)' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			shiftWindowHandle(1);

			try {
				clickContinuePopupButton();
			} catch (Exception e) {
				// TODO: handle exception
			} catch (Error e) {

			}

			status = selectProPertyTypeGoogleForm();
			addSubStep(subSteps, "Selecting 'Property Type': House", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = enterPostcodeGoogleForm();
			addSubStep(subSteps, "enter Post Code: 123 ", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = selectNumberOfBedroomGoogleForm();
			addSubStep(subSteps, "Selecting 'Number Of Bedroom': 1", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = enterPropertyAddressGoogleForm();
			addSubStep(subSteps, "Enter Property Address: test ", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = enterPropertyTitleVolumeGoogleForm();
			addSubStep(subSteps, "Enter Property Title Volume: test ", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = enterPropertyFolioGoogleForm();
			addSubStep(subSteps, "Enter Property Folio: test ", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = enterMortgageInterestateGoogleForm();
			addSubStep(subSteps, "Enter Mortgage Intere Rate: test ", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = enterLoanAmountRequestGoogleForm();
			addSubStep(subSteps, "Enter Loan Amount Request: 123321 ", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = enterPropertyPurchasePriceGoogleForm();
			addSubStep(subSteps, "Enter Property Purchase Price: 123321 ", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickNextBtnOnGoogleSignIn();
			addSubStep(subSteps, "Click on 'Next' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickSubmitBtn();
			addSubStep(subSteps, "Click on 'Submit' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(verifyPropertyTitleDetailsSuccessPage(),
					"Verified <b>Property Title Details Success</b> Page is displaying");
			addSubStep(subSteps, "Verified <b>Property Title Details Success</b> Page is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			subSteps.add(new TestSteps("Login to BCP", Status.PASS));
			openURL("AppURL");

			addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Verify data on 'Sync Property Data' Page<<<<<<<<<<<<<</b>",
					status.INFO);

			status = dashboardPage.clickOnSyncPropertyDataMenuButton();
			addSubStep(subSteps, "Click on Navigation Menu 'Sync Property Data Menu' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			getRefreshWebPage();
			waitForDataToDisplaying(HB);

			status = ErrorCollector.verifyTrue(verifyDataIsDisplaying(HB), " : Verify 'Home Buyer ID' is displaying");
			addSubStep(subSteps, "Verify 'Home Buyer ID' is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(verifyDataIsDisplaying(CP), " : Verify 'Compaign ID' is displaying");
			addSubStep(subSteps, "Verify 'Compaign ID' is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickSyncButton(HB);
			addSubStep(subSteps, " Click on 'Sync' button.", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			waitTime(10000);
			getRefreshWebPage();

			status = dashboardPage.clickOnMenuScenariosButton();
			addSubStep(subSteps, "Click on Navigation Menu 'Scenarios' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(verifyOnSynchronizedScenariosIsPurchased(HB),
					"Verified Synchronized Scenarios is <b>Purchased</b>");
			addSubStep(subSteps, "Verified Synchronized Scenarios is <b>Purchased</b>", status);
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

	public void submitOtp(String keys) {
		waitForElementVisibility(otpDigit1, "20");
		otpDigit1.sendKeys(keys);
	}

	public void clickOtpSubmitBtn() {
		waitForElementVisibility(OtpSubmitBtn, "20");
		click(OtpSubmitBtn);
	}

	public void clickDocRadioButton() {
		waitForElementVisibility(docRadiobtn, "20");
		click(docRadiobtn);
	}

	public Status clickDocAcceptAndContinueButton() {
		try {
			clickDocRadioButton();
			waitForElementVisibility(docRadiobtn, "20");
			click(docAcceptAndContinueBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickOnDocBeginButton() {
		try {
			waitForElementVisibility(docBeginBtn, "20");
			click(docBeginBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public void clickOnDocPlaceSignatureHereButton() {
		waitForElementVisibility(docPlaceSignatureHereBtn, "20");
		click(docPlaceSignatureHereBtn);
	}

	public Status enterDocTypeYourNameInputField(String name) {
		try {
			clickOnDocPlaceSignatureHereButton();
			waitForElementVisibility(docTypeYourNameTxt, "30");
			docTypeYourNameTxt.sendKeys(name);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickOnDocAdoptButton() {
		try {
			waitForElementVisibility(docAdoptBtn, "20");
			click(docAdoptBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public void clickOnDocTextInputButton() {
		waitForElementVisibility(docTextInputBtn, "20");
		click(docTextInputBtn);
	}

	public Status enterDocInputTextInputField(String text) {
		try {
			clickOnDocTextInputButton();
			waitForElementVisibility(docInputTextTxt, "30");
			docInputTextTxt.sendKeys(text);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickOnDocInputTextSaveButton() {
		try {
			waitForElementVisibility(docInputTextSaveBtn, "20");
			click(docInputTextSaveBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickOnDocSignAndFinishButton() {
		try {
			waitForElementVisibility(docSignAndFinishBtn, "20");
			click(docSignAndFinishBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public boolean verifyDocThankYouForSigningTheDocument() {
		try {
			waitForElementVisibility(docThankYouForSigningTheDocumentMsg, "20");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void enterPropertyPurchaseInputField(String number) {
		waitForElementVisibility(propertyPurchaseplusTxt, "30");
		propertyPurchaseplusTxt.clear();
		propertyPurchaseplusTxt.sendKeys("80" + number);

	}

	public boolean verifyApprovePreApprovalBtn() {
		waitTime(5000);
		try {
			scrollIntoViewSmoothly(approvePreApprovalBtn);
			waitForElementVisibility(approvePreApprovalBtn, "20");
			isElementDisplayed(approvePreApprovalBtn);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyRejectPreApprovalBtn() {
		waitTime(5000);
		try {
			scrollIntoViewSmoothly(rejectPreApprovalBtn);
			waitForElementVisibility(rejectPreApprovalBtn, "20");
			isElementDisplayed(rejectPreApprovalBtn);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifySuccessScenarioMessage() {
		try {
			waitForElementVisibility(scenarioSuccessMessage, "20");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyHomebuyerHash(String str) {
		try {
			String value = getElementText(borrowerHashElement);
			return str.equals(value);
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean verifyScenarioHash(String str) {
		try {
			String value = getElementText(scenarioHashElement);
			return str.equals(value);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyScenarioId(String str) {
		try {
			String value = getElementText(scenarioIdElement);
			return str.equals(value);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyScenarioState(String str) {
		try {
			String value = getElementText(scenarioIdElement);
			return str.equals(value);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyBrokerId(String str) {
		try {
			String value = getElementText(scenarioIdElement);
			return str.equals(value);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyLoanAmountOffer(String str) {
		try {
			String value = getElementText(scenarioIdElement);
			return str.equals(value);
		} catch (Exception e) {
			return false;
		}
	}

	public Status selectSalutationOption() {
		try {
			waitTime(9000);
			waitForElementVisibility(salutationDropDownOnHomeBuyerForm, "20");
			click(salutationDropDownOnHomeBuyerForm);
			waitForElementVisibility(salutationOption, "20");
			click(salutationOption);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status enterPhoneNumber(String phoneNumber) {
		try {
			scrollIntoView(phoneNumberTxtOnHomeBuyerForm);
			waitForElementVisibility(phoneNumberTxtOnHomeBuyerForm, "20");
			phoneNumberTxtOnHomeBuyerForm.sendKeys(phoneNumber);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickOnNextButton(int nextNumber) {
		try {
			scrollIntoView(phoneNumberTxtOnHomeBuyerForm);
			WebElement element = driver.findElement(By.xpath("(//span[text()='Next'])[" + nextNumber + "]"));
			waitForElementVisibility(element, "20");
			click(element);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public boolean verifyGuarantorTitleOnHomeBuyerForm() {
		try {
			waitForElementVisibility(guarantorTitleOnHomeBuyerForm, "20");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyInvestorTitleOnHomeBuyerForm() {
		try {
			waitForElementVisibility(investorTitleOnHomeBuyerForm, "20");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyInvestorsDetailsTitleOnHomeBuyerForm() {
		try {
			waitForElementVisibility(investorsDetailsTitleOnHomeBuyerForm, "20");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Status clickOnGurantorYesRadioButton() {
		try {
			waitForElementVisibility(gurantorYesRadioButton, "20");
			click(gurantorYesRadioButton);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public Status selectRelationshipOption() {
		try {
			waitForElementVisibility(relationshipDropdown, "20");
			click(relationshipDropdown);
			waitForElementVisibility(salutationOption, "20");
			click(salutationOption);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public Status selectSalutationOnGurantorOption() {
		try {
			waitForElementVisibility(salutationDropdown, "20");
			click(salutationDropdown);
			waitForElementVisibility(salutationOption, "20");
			click(salutationOption);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public Status enterGurantorFirstName(String firstName) {
		try {
			scrollIntoView(gurantorFirstNameTxt);
			waitForElementVisibility(gurantorFirstNameTxt, "20");
			gurantorFirstNameTxt.sendKeys(firstName);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public Status enterGurantorLastName(String lastName) {
		try {
			scrollIntoView(gurantorLastNameTxt);
			waitForElementVisibility(gurantorLastNameTxt, "20");
			gurantorLastNameTxt.sendKeys(lastName);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public Status selectGurantorTitleRoleOption() {
		try {
			waitForElementVisibility(titleRoleDropdown, "20");
			click(titleRoleDropdown);
			waitForElementVisibility(salutationOption, "20");
			click(salutationOption);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public Status enterGurantorAddress(String address) {
		try {
			scrollIntoView(gurantorAddressTxt);
			waitForElementVisibility(gurantorAddressTxt, "20");
			gurantorAddressTxt.sendKeys(address);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public Status enterGurantorCity(String city) {
		try {
			scrollIntoView(gurantorCityTxt);
			waitForElementVisibility(gurantorCityTxt, "20");
			gurantorCityTxt.sendKeys(city);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public Status enterGurantorPostcode(String postcode) {
		try {
			scrollIntoView(gurantorPostcodeTxt);
			waitForElementVisibility(gurantorPostcodeTxt, "20");
			gurantorPostcodeTxt.sendKeys(postcode);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}	
	
	public Status selectGurantorStateProvinceTerritoryOption() {
		try {
			waitForElementVisibility(stateProvinceTerritoryDropdown, "20");
			click(stateProvinceTerritoryDropdown);
			waitForElementVisibility(salutationOption, "20");
			click(salutationOption);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	
	public Status enterGurantorDOB(String DOB) {
		try {
			scrollIntoView(DOBTxt);
			waitForElementVisibility(DOBTxt, "20");
			DOBTxt.sendKeys(DOB);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public boolean verifyInvestorPageTitle() {
		try {
			waitForElementVisibility(pageInvestorTitle, "20");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Status clickInvestorYesRadioButton() {
		try {
			waitForElementVisibility(investorYesRadioButton, "20");
			click(investorYesRadioButton);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public Status selectInvestorTypeOption() {
		try {
			waitForElementVisibility(investorTypeDropdown, "20");
			click(investorTypeDropdown);
			waitForElementVisibility(salutationOption, "20");
			click(salutationOption);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public Status enterInvestorPlacementAmount(String amount) {
		try {
			scrollIntoView(placementAmountTxt);
			waitForElementVisibility(placementAmountTxt, "20");
			placementAmountTxt.sendKeys(amount);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public Status selectInvestorSalutationOption() {
		try {
			waitForElementVisibility(investorSalutationDropdown, "20");
			click(investorSalutationDropdown);
			waitForElementVisibility(salutationOption, "20");
			click(salutationOption);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public Status enterInvestorFirstName(String firstName) {
		try {
			scrollIntoView(investorFirstNameTxt);
			waitForElementVisibility(investorFirstNameTxt, "20");
			investorFirstNameTxt.sendKeys(firstName);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public Status enterInvestorLastName(String lastName) {
		try {
			scrollIntoView(investorLastNameTxt);
			waitForElementVisibility(investorLastNameTxt, "20");
			investorLastNameTxt.sendKeys(lastName);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public Status selectInvestorTitleRoleOption() {
		try {
			waitForElementVisibility(investorTitleRoleDropdown, "20");
			click(investorTitleRoleDropdown);
			waitForElementVisibility(salutationOption, "20");
			click(salutationOption);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public Status enterInvestorAddress(String address) {
		try {
			scrollIntoView(investorAddressTxt);
			waitForElementVisibility(investorAddressTxt, "20");
			investorAddressTxt.sendKeys(address);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public Status enterInvestorCity(String city) {
		try {
			scrollIntoView(investorCityTxt);
			waitForElementVisibility(investorCityTxt, "20");
			investorCityTxt.sendKeys(city);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public Status selectInvestorStateProvinceTerritoryOption() {
		try {
			waitForElementVisibility(investorStateProvinceTerritoryDropdown, "20");
			click(investorStateProvinceTerritoryDropdown);
			waitForElementVisibility(salutationOption, "20");
			click(salutationOption);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public Status enterInvestorPostcode(String postcode) {
		try {
			scrollIntoView(investorPostcodeTxt);
			waitForElementVisibility(investorPostcodeTxt, "20");
			investorPostcodeTxt.sendKeys(postcode);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public Status enterInvestorDOB(String DOB) {
		try {
			scrollIntoView(investorDOBTxt);
			waitForElementVisibility(investorDOBTxt, "20");
			investorDOBTxt.sendKeys(DOB);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public boolean verifyAdditionalInvestorTitle() {
		try {
			waitForElementVisibility(additionalInvestorTitle, "20");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Status clickPreviewButton() {
		try {
			waitForElementVisibility(previewBtn, "20");
			click(previewBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public String getSenarioName() {
		return senarioName.getText().trim();
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
	
}
