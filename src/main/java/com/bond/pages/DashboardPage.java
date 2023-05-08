package com.bond.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.bond.base.BaseClass;
import com.bond.base.PropertiesReader;
import com.bond.errorCollectors.ErrorCollector;
import com.bond.utilities.TestSteps;

public class DashboardPage extends BaseClass {

	@FindBy(xpath = ("//button[text()='Home']"))
	WebElement navMenuHomeBtn;

	@FindBy(xpath = ("//h6[text()='Welcome Admin']"))
	WebElement homePageTitle;

	@FindBy(xpath = ("//button[contains(text(),'Campaigns')]"))
	WebElement navMenuCampaignsBtn;

	@FindBy(xpath = ("//h4[text()='Synchronized Campaigns']"))
	WebElement campaignsPageTitle;

	@FindBy(xpath = ("//button[contains(text(),'Sync Submissions')]"))
	WebElement navMenuSyncSubmissionsBtn;

	@FindBy(xpath = ("//h4[text()='Synchronise Submissions']"))
	WebElement syncSubmissionsPageTitle;

	@FindBy(xpath = ("//button[contains(text(),'Home')]"))
	WebElement menuHomeBtn;

	@FindBy(xpath = ("//*[local-name()='svg' and @data-icon='house-chimney']"))
	WebElement menuHomeBtnIcon;

	@FindBy(xpath = ("//button[contains(text(),'Sync Submissions')]"))
	WebElement menuSyncSubmissionsBtn;

	@FindBy(xpath = ("//button[contains(text(),'Scenarios')]"))
	WebElement menuScenariosBtn;

	@FindBy(xpath = ("//button[contains(text(),'Bond Buyer')] | //button[contains(text(),' Investor')]"))
	WebElement menuBondBuyerBtn;

	@FindBy(xpath = ("//button[contains(text(),'Sync Personal Data')]"))
	WebElement menuSyncPersonalDataBtn;

	@FindBy(xpath = ("//button[contains(text(),'Sync Settlement Data')]"))
	WebElement menuSyncSettlementDataBtn;

	@FindBy(xpath = ("//button[contains(text(),'Sync Post Purchase')]"))
	WebElement menuSyncPostPurchaseBtn;

	@FindBy(xpath = ("//*[contains(text(),'Logout')]"))
	WebElement menuLogoutBtn;

	@FindBy(xpath = ("//h6[text()='Welcome Admin']"))
	WebElement homePageMsg;

	@FindBy(xpath = ("//h4[text()='Synchronized Scenarios']"))
	WebElement titleSynchronizedScenarios;

	@FindBy(xpath = ("//th[text()='Scenario Hash']"))
	WebElement columnLblScenarioHash;

	@FindBy(xpath = ("//th[text()='HomeBuyer Hash'] | //th[text()='Home Buyer Hash']"))
	WebElement columnLblHomeBuyerHash;

	@FindBy(xpath = ("//th[text()='Home Buyer Name']"))
	WebElement columnLblHomeBuyerName;

	@FindBy(xpath = ("//th[text()='Home Buyer Email']"))
	WebElement columnLblHomeBuyerEmail;

	@FindBy(xpath = ("//th[text()='Status']"))
	WebElement columnLblStatus;

	@FindBy(xpath = ("//th[text()='Details']"))
	WebElement columnLblDetails;

	@FindBy(xpath = ("//th[text()='HomeBuyer Hash / Scenario Hash (Scenario ID)'] | //th[text()='Home Buyer Hash / Scenario Hash (Scenario ID)']"))
	WebElement columnLblHomebuyerHash;

	@FindBy(xpath = ("//th[text()='Scenario Name']"))
	WebElement columnLblScenarioName;

	@FindBy(xpath = ("//th[text()='Action']"))
	WebElement columnLblAction;

	@FindBy(xpath = ("//h4[text()='Synchronise Personal Data']"))
	WebElement synchroniePersonalDataTitle;

	@FindBy(xpath = ("//select[contains(@name,'DataTables_Table')]"))
	WebElement showEntries;

	@FindBy(xpath = ("//a[@class='paginate_button ']"))
	WebElement navScondPageBtn;

	@FindBy(xpath = ("//div[@id='DataTables_Table_1_info']"))
	WebElement totalEntriesLbl;

	@FindBy(xpath = ("//option[@value='50']"))
	WebElement dropdown50;

	@FindBy(xpath = ("//option[@value='30']"))
	WebElement dropdown30;

	@FindBy(xpath = ("//option[@value='100']"))
	WebElement dropdown100;

	@FindBy(xpath = "(//button[text()='Details'])[1]")
	WebElement firstDestailBtnOnScenarioPage;

	@FindBy(xpath = "//h5[text()='Home Buyer']")
	WebElement homebuyerTextOnScenariosDetailsPage;

	@FindBy(xpath = "//h5[text()='Home Buyer Party']")
	WebElement homeBuyerPartyTextOnScenariosDetailPage;

	@FindBy(xpath = "//h5[text()='Homebuyer Account Details'] | //h5[text()='Home Buyer Account Details']")
	WebElement homeBuyerAccountTextOnScenariosDetailPage;

	@FindBy(xpath = "//h5[text()='Homebuyer Personal Details'] | //h5[text()='Home Buyer Personal Details']")
	WebElement homeBuyerPersonalDetailsTextOnScenariosDetailPage;

	@FindBy(xpath = "//h5[text()='Property']")
	WebElement propertyTextOnScenariosDetailPage;

	@FindBy(xpath = "//h5[text()='Property Class']")
	WebElement propertyClassTextOnScenariosDetailPage;

	@FindBy(xpath = "//h5[text()='Scenario']")
	WebElement scenarioTextOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'HomeBuyer Hash')]/following-sibling::td | //td[contains(text(),'Home Buyer Hash')]/following-sibling::td")
	WebElement homebuyerHashLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Homebuyer ID')]/following-sibling::td | //td[contains(text(),'Home Buyer ID')]/following-sibling::td")
	WebElement homebuyeIdLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'OSQO ID')]/following-sibling::td")
	WebElement osqoIdLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Special Condition')]/following-sibling::td")
	WebElement specialConditionLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Home Buyer Party Id')]/following-sibling::td")
	WebElement homebuyerPartyIdLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Account Name')]/following-sibling::td | //td[contains(text(),'Account Name')]")
	WebElement accountNameLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Account Number')]/following-sibling::td | //td[contains(text(),'Account Number')]")
	WebElement accountNumberLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'BSB')]/following-sibling::td | //td[contains(text(),'BSB')]")
	WebElement bsbLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Bank Name')]/following-sibling::td | //td[contains(text(),'Bank Name')]")
	WebElement bankNameLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Branch')]/following-sibling::td")
	WebElement branchLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Homebuyer Account Details ID')]/following-sibling::td | //td[contains(text(),'HomeBuyer Account Details ID')]/following-sibling::td")
	WebElement homebuyerAccountDetailsIdLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'SwiftID')]/following-sibling::td")
	WebElement swiftIdLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Address')]/following-sibling::td | //td[text()='Address']")
	WebElement addressLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'City')]/following-sibling::td")
	WebElement cityLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[(text()='DOB')]/following-sibling::td")
	WebElement dobLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'First Name')]/following-sibling::td")
	WebElement firstNameLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Last Name')]/following-sibling::td")
	WebElement lastNameLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Phone Number')]/following-sibling::td")
	WebElement phoneNumberLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'PostCode')]/following-sibling::td | //td[contains(text(),'Post Code')]/following-sibling::td")
	WebElement postCodeLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'State/Province/Territory')]/following-sibling::td")
	WebElement stateProvinceTerritoryLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Title Role')]/following-sibling::td")
	WebElement titleRoleLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Property ID')]/following-sibling::td")
	WebElement propertyIdLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Property Purchase Price')]/following-sibling::td")
	WebElement propertyPurchasePriceLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Property State')]/following-sibling::td")
	WebElement propertyStateLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Number Of Bedrooms')]/following-sibling::td")
	WebElement numberOfBedroomsLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Property Class ID')]/following-sibling::td")
	WebElement propertyClassIdLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Property Type')]/following-sibling::td")
	WebElement propertyTypeLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Suburb')]/following-sibling::td")
	WebElement suburbLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Broker ID')]/following-sibling::td")
	WebElement brokerIdLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Loan Amount Offer')]/following-sibling::td")
	WebElement loanAmountOfferLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Loan Amount Requested')]/following-sibling::td")
	WebElement loanAmountRequestedLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Notes')]/following-sibling::td")
	WebElement notesLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Scenario Hash')]/following-sibling::td")
	WebElement scenarioHashLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Scenario ID')]/following-sibling::td")
	WebElement scenarioIdLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Scenario State')]/following-sibling::td")
	WebElement scenarioStateLabelOnScenariosDetailPage;

	@FindBy(xpath = "//td[contains(text(),'Status')]/following-sibling::td | //td[contains(text(),'Scenario State')]/following-sibling::td")
	WebElement statusLabelOnScenariosDetailPage;

	@FindBy(xpath = "//button[text()='Back']")
	WebElement backBtnOnScenariosDetailPage;

	@FindBy(xpath = "(//tr[@class='odd']/td)[1]")
	WebElement FirstScenarioHash;

	@FindBy(xpath = "//input[@placeholder='Scenario Hash']")
	WebElement ScenarioHashSearchField;

	@FindBy(xpath = "//tr/td[1]")
	List<WebElement> AllScenarioHashAfterSearch;

	@FindBy(xpath = "(//tr/td[2])[1]")
	WebElement FirstHomeBuyerHash;

	@FindBy(xpath = "//input[@placeholder='HomeBuyer Hash']")
	WebElement HomeBuyerHashSearchField;

	@FindBy(xpath = "//tr/td[2]")
	List<WebElement> AllHomeBuyerHashAfterSearch;

	@FindBy(xpath = "(//tr/td[3])[1]")
	WebElement FirstHomeBuyerName;

	@FindBy(xpath = "//input[@placeholder='Name']")
	WebElement HomeBuyerNameSearchField;

	@FindBy(xpath = "//tr/td[3]")
	List<WebElement> AllHomeBuyerNamesAfterSearch;

	@FindBy(xpath = "(//tr/td[4])[1]")
	WebElement FirstHomeBuyerEmail;

	@FindBy(xpath = "//input[@placeholder='Email']")
	WebElement HomeBuyerEmailSearchField;

	@FindBy(xpath = "//tr/td[4]")
	List<WebElement> AllHomeBuyerEmailsAfterSearch;

	@FindBy(xpath = "(//tr/td[5])[1]")
	WebElement FirstStatus;

	@FindBy(xpath = "//input[@placeholder='Status']")
	WebElement StatusSearchField;

	@FindBy(xpath = "//tr/td[5]")
	List<WebElement> AllStatusAfterSearch;

	@FindBy(xpath = "//input[@placeholder='HomeBuyer/Scenario Hash']")
	WebElement HomeBuyerAndScenarioHashSearchFieldOnSyncSubmissionPage;

	@FindBy(xpath = "//input[@placeholder='Scenario Name']")
	WebElement ScenarioNameSearchFieldOnSyncSubmissionPage;

	@FindBy(xpath = "//button[contains(text(),'Sync Property Data')]")
	WebElement syncPropertyDataMenuBtn;

	@FindBy(xpath = "//h4[contains(text(),'Bond-Buyer Listing')]")
	WebElement bondBuyerPageTitel;
	
	@FindBy(xpath = "//button[contains(text(),'Sync Personal Data')]")
	WebElement syncPersonalDataButton;
	
	@FindBy(xpath = "//h4[text()='Synchronise Post Purchase Data']")
	WebElement synchronisePostPurchaseDataPageTitel;
	
	@FindBy(xpath = "//button[text()='View Home-Buyer Details']")
	WebElement viewHomeBuyerDetailsButton;
	

	
	
	String bcpEmail = PropertiesReader.getPropertyValue(env + "_BcpEmailId");
	String bcpPass = PropertiesReader.getPropertyValue(env + "_BcpPassword");

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnNavMenuHomeButton() {
		waitTime(1000);
		waitForElementClickable(navMenuHomeBtn, "10");
		click(navMenuHomeBtn);
	}

	public boolean isHomePageTitleDisplaying() {
		waitForElementVisibility(homePageTitle, "20");
		return isElementDisplayed(homePageTitle);
	}
	
	public boolean synchronisePostPurchaseDataPageTitelDisplaying(){
		try {
			waitForElementVisibility(synchronisePostPurchaseDataPageTitel, "90");
			return isElementDisplayed(synchronisePostPurchaseDataPageTitel);
		} catch (Exception e) {
			return false;
		}

	}
	

	public void clickOnNavMenuCampaignsButton() {
		waitTime(1000);
		waitForElementClickable(navMenuCampaignsBtn, "10");
		click(navMenuCampaignsBtn);
	}

	public boolean isCampaignsPageTitleDisplaying() {
		waitForElementVisibility(campaignsPageTitle, "20");
		return isElementDisplayed(campaignsPageTitle);
	}

	public Status clickOnNavMenuSyncSubmissionsButton() {
		try {
			driver.navigate().refresh();
			waitTime(4000);
			String scriptToExecute = "var performance = window.performance || {}; var network = performance.getEntries() || {}; return network;";
			String netData = ((JavascriptExecutor)driver).executeScript(scriptToExecute).toString();
			System.out.println(netData);

			List<LogEntry> entries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
			System.out.println(entries.size() + " " + LogType.PERFORMANCE + " log entries found");
			 for (LogEntry entry : entries) {
			  // System.out.println(entry.getMessage());
			   if(entry.getMessage().contains("\"authorization\":\"Bearer ")) {
				   String message = entry.getMessage();
				   String token = message.substring(message.indexOf("Bearer ")+7,message.indexOf("\",\"if-none-match\"")).trim();
				   System.out.println("Token: "+message);
				   printString("Token: "+message);
			   }
			 }
			
				waitForElementClickable(navMenuSyncSubmissionsBtn, "10");
				click(navMenuSyncSubmissionsBtn);

			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public Status clickOnSyncSubmissionsButton() {
		try {
						
				waitForElementClickable(navMenuSyncSubmissionsBtn, "10");
				click(navMenuSyncSubmissionsBtn);

			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickOnSyncPersonalDataButtonon() {
		try {
			waitTime(1000);
			waitForElementClickable(syncPersonalDataButton, "10");
			click(syncPersonalDataButton);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickOnSyncPropertyDataMenuButton() {
		try {
			waitTime(10000);
			waitForElementClickable(syncPropertyDataMenuBtn, "30");
			click(syncPropertyDataMenuBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public boolean isSyncSubmissionsPageTitleDisplaying() {
		try {
			waitForElementVisibility(syncSubmissionsPageTitle, "20");
			return isElementDisplayed(syncSubmissionsPageTitle);
		} catch (Exception e) {
			return false;
		}

	}

	public Status clickOnMenuScenariosButton() {
		try {
			scrollIntoView(menuScenariosBtn);
			waitForElementVisibility(menuScenariosBtn, "30");
			waitTime(20000);
			click(menuScenariosBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	public Status clickOnViewHomeBuyerDetailsButton() {
		try {
			scrollIntoView(viewHomeBuyerDetailsButton);
			waitForElementVisibility(viewHomeBuyerDetailsButton, "30");
			waitTime(20000);
			click(viewHomeBuyerDetailsButton);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
	

	public boolean isTitleSynchronizedScenariosDisplaying() {
		try {
			waitForElementVisibility(titleSynchronizedScenarios, "90");
			return isElementDisplayed(titleSynchronizedScenarios);
		} catch (Exception e) {
			return false;
		}

	}

	public boolean isBondBuyerPageTitelDisplaying() {
		try {
			waitForElementVisibility(bondBuyerPageTitel, "90");
			return isElementDisplayed(bondBuyerPageTitel);
		} catch (Exception e) {
			return false;
		}

	}

	public boolean isColumnLabelScenarioHashDisplaying() {
		try {
			waitForElementVisibility(columnLblScenarioHash, "90");
			return isElementDisplayed(columnLblScenarioHash);
		} catch (Exception e) {
			return false;
		}

	}

	public boolean isColumnLabelStatusDisplaying() {
		try {
			waitForElementVisibility(columnLblStatus, "90");
			return isElementDisplayed(columnLblStatus);
		} catch (Exception e) {
			return false;
		}

	}

	public boolean isColumnLabelHomeBuyerHashDisplaying() {
		try {
			waitForElementVisibility(columnLblHomeBuyerHash, "90");
			return isElementDisplayed(columnLblHomeBuyerHash);
		} catch (Exception e) {
			return false;
		}

	}

	public boolean isColumnLabelHomeBuyerNameDisplaying() {
		try {
			waitForElementVisibility(columnLblHomeBuyerName, "90");
			return isElementDisplayed(columnLblHomeBuyerName);
		} catch (Exception e) {
			return false;
		}

	}
	
	public boolean isMenuSyncSettlementDataButtonDisplaying() {
		try {
			waitForElementVisibility(menuSyncSettlementDataBtn, "90");
			return isElementDisplayed(menuSyncSettlementDataBtn);
		} catch (Exception e) {
			return false;
		}

	}
	
	public boolean isColumnLabelHomeBuyerEmailDisplaying() {
		try {
			waitForElementVisibility(columnLblHomeBuyerEmail, "90");
			return isElementDisplayed(columnLblHomeBuyerEmail);
		} catch (Exception e) {
			return false;
		}

	}

	public boolean isColumnLblHomebuyerHashDisplaying() {
		waitForElementVisibility(columnLblHomebuyerHash, "90");
		return isElementDisplayed(columnLblHomebuyerHash);
	}

	public boolean isColumnLabelScenarioNameDisplaying() {
		try {
			waitForElementVisibility(columnLblScenarioName, "90");
			return isElementDisplayed(columnLblScenarioName);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isColumnLabelActionDisplaying() {
		try {
			waitForElementVisibility(columnLblAction, "90");
			return isElementDisplayed(columnLblAction);
		} catch (Exception e) {
			return false;
		}

	}

	public boolean isColumnLabelDetailsDisplaying() {
		waitForElementVisibility(columnLblDetails, "90");
		return isElementDisplayed(columnLblDetails);
	}

	public Status clickOnMenuBondBuyerButton() {
		try {
			scrollIntoView(menuBondBuyerBtn);
			waitTime(1000);
			waitForElementClickable(menuBondBuyerBtn, "10");
			click(menuBondBuyerBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickOnMenuSyncPersonalDataButton() {
		try {
			waitTime(9000);
//		waitForElementClickable(menuSyncPersonalDataBtn, "10");
			click(menuSyncPersonalDataBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickOnMenuBondBuyersButton() {
		try {
			waitTime(1000);
			scrollIntoView(menuBondBuyerBtn);
			waitForElementClickable(menuBondBuyerBtn, "10");
			click(menuBondBuyerBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickOnMenuSyncPostPurchaseButton() {		
		try {
			waitTime(1000);
			waitForElementClickable(menuSyncPostPurchaseBtn, "10");
			click(menuSyncPostPurchaseBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status clickOnMenuSyncSettlementDataButton() {
		try {
			waitTime(1000);
			waitForElementClickable(menuSyncSettlementDataBtn, "10");
			click(menuSyncSettlementDataBtn);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public boolean isSynchroniePersonalDataTitleDisplaying() {
		try {
			waitForElementVisibility(synchroniePersonalDataTitle, "20");
			return isElementDisplayed(synchroniePersonalDataTitle);
		} catch (Exception e) {
			return false;
		}
	}

	public String getScenarioHashItem(int i) {
		waitTime(1000);
//		if(i>=19) {
//			int j=0;
//			String value="";
//			List<WebElement> scenarioHashItem = driver.findElements(By.xpath("(//tr)[position() >1]/td[1]"));
//			scrollToElement(scenarioHashItem.get(j));
//			value = scenarioHashItem.get(j).getText();
//			j++;
//			return value; 	
//		}else {
		List<WebElement> scenarioHashItem = driver.findElements(By.xpath("(//tr)[position() >1]/td[1]"));
		scrollToElement(scenarioHashItem.get(i));
		return scenarioHashItem.get(i).getText();
	}

//	}

	public String getHomeBuyerHash(int i) {
		waitTime(1000);
//		if(i>=19) {
//			int j=0;
//			String value="";
//			List<WebElement> homeBuyerHash = driver.findElements(By.xpath("(//tr)[position() >1]/td[2]"));
//			scrollToElement(homeBuyerHash.get(j));
//			value = homeBuyerHash.get(j).getText();
//			j++;
//			return value; 	
//		}else {
		List<WebElement> homeBuyerHash = driver.findElements(By.xpath("(//tr)[position() >1]/td[2]"));
		scrollToElement(homeBuyerHash.get(i));
		return homeBuyerHash.get(i).getText();
	}

//	}

	public String getHomeBuyerName(int i) {
		waitTime(1000);
//		if(i>=19) {
//			int j=0;
//			List<WebElement> homeBuyerName = driver.findElements(By.xpath("(//tr)[position() >1]/td[3]"));
//			scrollToElement(homeBuyerName.get(j));
//			String getValue = homeBuyerName.get(j).getText();
//			getValue = getValue.replaceAll("-", "").trim();
//			j++;
//			return getValue;	
//		}else {
		List<WebElement> homeBuyerName = driver.findElements(By.xpath("(//tr)[position() >1]/td[3]"));
		scrollToElement(homeBuyerName.get(i));
		String value = homeBuyerName.get(i).getText();
//			value = value.replaceAll("-", "").trim();
		return value;
	}
//	}

	public String getHomeBuyerEmail(int i) {
		waitTime(1000);
//		if(i>=19) {
//			int j=0;
//			
//			List<WebElement> homeBuyerEmail = driver.findElements(By.xpath("(//tr)[position() >1]/td[4]"));
//			scrollToElement(homeBuyerEmail.get(j));
//			String value = homeBuyerEmail.get(j).getText();
//			value = value.replaceAll("-", "").trim();
//			j++;
//			return value;
//			
//		}else {
		List<WebElement> homeBuyerEmail = driver.findElements(By.xpath("(//tr)[position() >1]/td[4]"));
		scrollToElement(homeBuyerEmail.get(i));
		String value = homeBuyerEmail.get(i).getText();
		value = value.replaceAll("-", "").trim();
		return value;

	}
//	}

	public String getScenarioState(int i) {
		waitTime(1000);
//		if(i>=19) {
//			int j=0;
//			String value = "";
//			List<WebElement> scenarioState = driver.findElements(By.xpath("(//tr)[position() >1]/td[5]"));
//			scrollToElement(scenarioState.get(j));
//			value = scenarioState.get(j).getText();
//			j++;
//			return value; 	
//		}else {
		List<WebElement> scenarioState = driver.findElements(By.xpath("(//tr)[position() >1]/td[5]"));
		scrollToElement(scenarioState.get(i));
		String value = scenarioState.get(i).getText();
		value = value.replaceAll("-", "").trim();
		return value;
	}
//	}

	public void select50Entries() {
		waitTime(9000);
		waitForElementClickable(showEntries, "90");
		click(showEntries);
		waitTime(1000);
		waitForElementClickable(dropdown50, "90");
		click(dropdown50);
	}

	public Status select30Entries() {
		try {
			waitTime(9000);
			waitForElementClickable(showEntries, "90");
			click(showEntries);
			waitTime(1000);
			waitForElementClickable(dropdown30, "90");
			click(dropdown30);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public Status select100Entries() {
		try {
			waitTime(10000);
			waitForElementClickable(showEntries, "90");
			click(showEntries);
			waitTime(1000);
			waitForElementClickable(dropdown100, "90");
			click(dropdown100);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public void clickOnNavigationScondButton() {
		waitTime(1000);

		scrollToElement(navScondPageBtn);
		waitForElementClickable(navScondPageBtn, "10");
		click(navScondPageBtn);
	}

	public String totalEntries() {
		scrollIntoSpecificView(totalEntriesLbl);
		waitForElementClickable(totalEntriesLbl, "10");
		String value = totalEntriesLbl.getText();
		value = value.replace("Showing 1 to 20 of ", "").replace(" entries", "").trim();
		System.out.println("total entries: " + value);
		return value;
	}

	public String getHomeBuyHashItemInPersonalData(int i) {
		waitTime(1000);
		if (i >= 19) {
			int j = 0;
			String value = "";
			List<WebElement> scenarioHashItem = driver.findElements(By.xpath("//td[@class='sorting_1']"));
			scrollToElement(scenarioHashItem.get(j));
			value = scenarioHashItem.get(j).getText();
			j++;
			return value;
		} else {
			List<WebElement> scenarioHashItem = driver.findElements(By.xpath("//td[@class='sorting_1']"));
			scrollToElement(scenarioHashItem.get(i));
			return scenarioHashItem.get(i).getText();
		}

	}

	public String getScenarioHashInPersonalData(int i) {
		waitTime(1000);
		if (i >= 19) {
			int j = 0;
			String value = "";
			List<WebElement> homeBuyerHash = driver
					.findElements(By.xpath("//td[@class='sorting_1']/following-sibling::td[1]"));
			scrollToElement(homeBuyerHash.get(j));
			value = homeBuyerHash.get(j).getText();
			j++;
			return value;
		} else {
			List<WebElement> homeBuyerHash = driver
					.findElements(By.xpath("//td[@class='sorting_1']/following-sibling::td[1]"));
			scrollToElement(homeBuyerHash.get(i));
			return homeBuyerHash.get(i).getText();
		}

	}

	public Status clickFirstDestailBtnOnScenarioPage() {
		try {
			waitTime(20000);
			scrollIntoView(firstDestailBtnOnScenarioPage);
			waitForElementVisibility(firstDestailBtnOnScenarioPage, "30");
			waitTime(20000);
			click(firstDestailBtnOnScenarioPage);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public boolean verifyHomebuyerTextOnScenariosDetailsPageISDisplaying() {
//		scrollToElement(homebuyerTextOnScenariosDetailsPage);
		waitTime(1000);
		try {
			scrollToElement(homebuyerTextOnScenariosDetailsPage);
			waitForElementVisibility(homebuyerTextOnScenariosDetailsPage, "90");
			return isElementDisplayed(homebuyerTextOnScenariosDetailsPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyHomebuyerHashlabelOnScenariosDetailPage() {
		waitTime(1000);
		try {
			waitForElementVisibility(homebuyerHashLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(homebuyerHashLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyHomebuyeIdLabelOnScenariosDetailPage() {
		waitTime(1000);		
		try {
			waitForElementVisibility(homebuyeIdLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(homebuyeIdLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyOsqoIdLabelOnScenariosDetailPage() {
		waitTime(1000);		
		try {
			waitForElementVisibility(osqoIdLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(osqoIdLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifySpecialConditionLabelOnScenariosDetailPage() {
		waitTime(1000);		
		try {
			waitForElementVisibility(specialConditionLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(specialConditionLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyHomeBuyerPartyTextOnScenariosDetailPage() {
		waitTime(1000);
		try {
			waitForElementVisibility(homeBuyerPartyTextOnScenariosDetailPage, "90");
			return isElementDisplayed(homeBuyerPartyTextOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyHomebuyerPartyIdLabelOnScenariosDetailPage() {
		waitTime(1000);		
		try {
			waitForElementVisibility(homebuyerPartyIdLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(homebuyerPartyIdLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyHomeBuyerAccountDetailsTextOnScenariosDetailPage() {
		waitTime(1000);		
		try {
			scrollIntoViewSmoothly(homeBuyerAccountTextOnScenariosDetailPage);
			waitForElementVisibility(homeBuyerAccountTextOnScenariosDetailPage, "90");
			return isElementDisplayed(homeBuyerAccountTextOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAccountNameLabelOnScenariosDetailPage() {
		waitTime(1000);		
		try {
			waitForElementVisibility(accountNameLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(accountNameLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAccountNumberLabelOnScenariosDetailPage() {
		waitTime(1000);		
		try {
			waitForElementVisibility(accountNumberLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(accountNumberLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyBsbLabelOnScenariosDetailPage() {
		waitTime(1000);		
		try {
			scrollIntoViewSmoothly(bsbLabelOnScenariosDetailPage);
			waitForElementVisibility(bsbLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(bsbLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyBankNameLabelOnScenariosDetailPage() {
		waitTime(1000);		
		try {
			waitForElementVisibility(bankNameLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(bankNameLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyBranchLabelOnScenariosDetailPage() {
		waitTime(1000);		
		try {
			waitForElementVisibility(branchLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(branchLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyHomebuyerAccountDetailsIdLabelOnScenariosDetailPage() {
		waitTime(1000);		
		try {
			waitForElementVisibility(homebuyerAccountDetailsIdLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(homebuyerAccountDetailsIdLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifySwiftIdLabelOnScenariosDetailPage() {
		waitTime(1000);		
		try {
			waitForElementVisibility(swiftIdLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(swiftIdLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyHomeBuyerPersonalDetailsTextOnScenariosDetailPage() {
		waitTime(1000);		
		try {
			waitForElementVisibility(homeBuyerPersonalDetailsTextOnScenariosDetailPage, "90");
			scrollToElement(homeBuyerPersonalDetailsTextOnScenariosDetailPage);
			return isElementDisplayed(homeBuyerPersonalDetailsTextOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAddressLabelOnScenariosDetailPage() {
		waitTime(1000);		
		try {
			waitForElementVisibility(addressLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(addressLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyCityLabelOnScenariosDetailPage() {
		waitTime(1000);		
		try {
			waitForElementVisibility(cityLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(cityLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyDobLabelOnScenariosDetailPage() {
		waitTime(1000);		
		try {
			waitForElementVisibility(dobLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(dobLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyFirstNameLabelOnScenariosDetailPage() {
		waitTime(1000);
		
		try {
			waitForElementVisibility(firstNameLabelOnScenariosDetailPage, "90");
			scrollToElement(firstNameLabelOnScenariosDetailPage);
			return isElementDisplayed(firstNameLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyLastNameLabelOnScenariosDetailPage() {
		waitTime(1000);
		try {
			waitForElementVisibility(lastNameLabelOnScenariosDetailPage, "90");
			scrollToElement(lastNameLabelOnScenariosDetailPage);
			return isElementDisplayed(lastNameLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyPhoneNumberLabelOnScenariosDetailPage() {
		waitTime(1000);
		try {
			waitForElementVisibility(phoneNumberLabelOnScenariosDetailPage, "90");
			scrollToElement(phoneNumberLabelOnScenariosDetailPage);
			return isElementDisplayed(phoneNumberLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyPostCodeLabelOnScenariosDetailPage() {
		waitTime(1000);
		
		try {
			waitForElementVisibility(postCodeLabelOnScenariosDetailPage, "90");
			scrollToElement(postCodeLabelOnScenariosDetailPage);
			return isElementDisplayed(postCodeLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyStateProvinceTerritoryLabelOnScenariosDetailPage() {
		waitTime(1000);
		try {
			waitForElementVisibility(stateProvinceTerritoryLabelOnScenariosDetailPage, "90");
			scrollToElement(stateProvinceTerritoryLabelOnScenariosDetailPage);
			return isElementDisplayed(stateProvinceTerritoryLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyTitleRoleLabelOnScenariosDetailPage() {
		waitTime(1000);
		try {
			waitForElementVisibility(titleRoleLabelOnScenariosDetailPage, "90");
			scrollToElement(titleRoleLabelOnScenariosDetailPage);
			return isElementDisplayed(titleRoleLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyPropertyTextOnScenariosDetailPage() {
		waitTime(1000);
		try {
			waitForElementVisibility(propertyTextOnScenariosDetailPage, "90");
			scrollToElement(propertyTextOnScenariosDetailPage);
			return isElementDisplayed(propertyTextOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyNumberOfBedroomsLabelOnScenariosDetailPage() {
		waitTime(1000);
		try {
			waitForElementVisibility(numberOfBedroomsLabelOnScenariosDetailPage, "90");
			scrollToElement(numberOfBedroomsLabelOnScenariosDetailPage);
			return isElementDisplayed(numberOfBedroomsLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyPropertyClassIdLabelOnScenariosDetailPage() {
		waitTime(1000);
		try {
			scrollToElement(propertyClassIdLabelOnScenariosDetailPage);
			waitForElementVisibility(propertyClassIdLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(propertyClassIdLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyPropertyTypeLabelOnScenariosDetailPage() {
		waitTime(1000);
		try {
			waitForElementVisibility(propertyTypeLabelOnScenariosDetailPage, "90");
			scrollToElement(propertyTypeLabelOnScenariosDetailPage);
			return isElementDisplayed(propertyTypeLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyPropertyClassTextOnScenariosDetailPage() {
		waitTime(8000);
		try {
			scrollToElement(propertyClassTextOnScenariosDetailPage);
			waitForElementVisibility(propertyClassTextOnScenariosDetailPage, "90");
			return isElementDisplayed(propertyClassTextOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifySuburbLabelOnScenariosDetailPage() {
		waitTime(1000);
		try {
			scrollToElement(suburbLabelOnScenariosDetailPage);
			waitForElementVisibility(suburbLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(suburbLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyPropertyIdLabelOnScenariosDetailPage() {
		waitTime(1000);
		try {
			scrollToElement(propertyIdLabelOnScenariosDetailPage);
			waitForElementVisibility(propertyIdLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(propertyIdLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyPropertyPurchasePriceLabelOnScenariosDetailPage() {
		waitTime(1000);
		try {
			scrollToElement(propertyPurchasePriceLabelOnScenariosDetailPage);
			waitForElementVisibility(propertyPurchasePriceLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(propertyPurchasePriceLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyPropertyStateLabelOnScenariosDetailPage() {
		waitTime(1000);
		try {
			scrollToElement(propertyStateLabelOnScenariosDetailPage);
			waitForElementVisibility(propertyStateLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(propertyStateLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyScenarioTextOnScenariosDetailPage() {
		waitTime(1000);
		try {
			scrollToElement(scenarioTextOnScenariosDetailPage);
			waitForElementVisibility(scenarioTextOnScenariosDetailPage, "90");
			return isElementDisplayed(scenarioTextOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyBrokerIdLabelOnScenariosDetailPage() {
		waitTime(1000);
		try {
			scrollToElement(brokerIdLabelOnScenariosDetailPage);
			waitForElementVisibility(brokerIdLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(brokerIdLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyLoanAmountOfferLabelOnScenariosDetailPage() {
		waitTime(1000);
		try {
			scrollToElement(loanAmountOfferLabelOnScenariosDetailPage);
			waitForElementVisibility(loanAmountOfferLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(loanAmountOfferLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyLoanAmountRequestedLabelOnScenariosDetailPage() {
		waitTime(1000);
		try {
			scrollToElement(loanAmountRequestedLabelOnScenariosDetailPage);
			waitForElementVisibility(loanAmountRequestedLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(loanAmountRequestedLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyNotesLabelOnScenariosDetailPage() {
		waitTime(1000);
		try {
			scrollToElement(notesLabelOnScenariosDetailPage);
			waitForElementVisibility(notesLabelOnScenariosDetailPage, "90");
			return isElementDisplayed(notesLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyScenarioHashLabelOnScenariosDetailPage() {
		waitTime(1000);
		try {
			waitForElementVisibility(scenarioHashLabelOnScenariosDetailPage, "90");
			scrollToElement(scenarioHashLabelOnScenariosDetailPage);
			return isElementDisplayed(scenarioHashLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyScenarioIdLabelOnScenariosDetailPage() {
		waitTime(1000);
		try {
			waitForElementVisibility(scenarioIdLabelOnScenariosDetailPage, "90");
			scrollToElement(scenarioIdLabelOnScenariosDetailPage);
			return isElementDisplayed(scenarioIdLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyScenarioStateLabelOnScenariosDetailPage() {
		waitTime(1000);
		try {
			waitForElementVisibility(scenarioStateLabelOnScenariosDetailPage, "90");
			scrollToElement(scenarioStateLabelOnScenariosDetailPage);
			return isElementDisplayed(scenarioStateLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyStatusLabelOnScenariosDetailPage() {
		waitTime(1000);
		try {
			waitForElementVisibility(statusLabelOnScenariosDetailPage, "90");
			scrollToElement(statusLabelOnScenariosDetailPage);
			return isElementDisplayed(statusLabelOnScenariosDetailPage);
		} catch (Exception e) {
			return false;
		}
	}

	public Status clickBackButtonOnScenarioDetailsPage() {
		try {
			waitForElementVisibility(backBtnOnScenariosDetailPage, "20");
			waitTime(2000);
			click(backBtnOnScenariosDetailPage);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	public boolean verifyScenariosListSizeOnSynchronizedScenarios() {
		
		try {
			List<WebElement> listOfScenarios = driver.findElements(By.xpath("//tbody/tr"));
			System.out.println(listOfScenarios.size());
			if (listOfScenarios.size() <= 30) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
	}

	public String getFirstScenarioHash() {
		return getElementText(FirstScenarioHash);
	}

	public Status searchInScenarioHashSearchField(String value) {
		try {
			scrollToElement(ScenarioHashSearchField);
			type(ScenarioHashSearchField, 1, value);
			waitTime(10000);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public boolean verifyScenarioHashSearchResultsAreMatching(String value) {
		boolean val = true;
		if (AllScenarioHashAfterSearch.size() > 0) {

			for (int n = 0; n < AllScenarioHashAfterSearch.size(); n++) {

				String scenarioHash = getElementText(AllScenarioHashAfterSearch.get(n));

				if (!value.equals(scenarioHash)) {
					val = false;
				}
			}
		} else {
			val = false;
		}
		return val;
	}

	public String getFirstHomeBuyerHash() {
		return getElementText(FirstHomeBuyerHash);
	}

	public void searchInHomeBuyerHashSearchField(String value) {
		scrollToElement(HomeBuyerHashSearchField);
		type(HomeBuyerHashSearchField, 1, value);
		waitTime(7000);
	}

	public boolean verifyHomeBuyerHashSearchResultsAreMatching(String value) {
		boolean val = true;
		if (AllHomeBuyerHashAfterSearch.size() > 0) {

			for (int n = 0; n < AllHomeBuyerHashAfterSearch.size(); n++) {

				String BuyerHash = getElementText(AllHomeBuyerHashAfterSearch.get(n));

				if (!value.equals(BuyerHash)) {
					val = false;
				}
			}
		} else {
			val = false;
		}
		return val;
	}

	public String getFirstHomeBuyerName() {
		List<WebElement> elements = driver.findElements(By.xpath("//tr/td[3]"));
		String name = "";
		for (int i = 0; i < elements.size(); i++) {
			name = elements.get(i).getText();
			if (!name.contains("-")) {
				name = name;
			}
		}
		return name;
	}

	public void searchInHomeBuyerNameSearchField(String value) {
		scrollToElement(HomeBuyerNameSearchField);
		type(HomeBuyerNameSearchField, 1, value);
		waitTime(7000);
	}

	public boolean verifyHomeBuyerNameSearchResultsAreMatching(String value) {
		boolean val = true;
		if (AllHomeBuyerNamesAfterSearch.size() > 0) {

			for (int n = 0; n < AllHomeBuyerNamesAfterSearch.size(); n++) {

				String HomeBuyerName = getElementText(AllHomeBuyerNamesAfterSearch.get(n));

				if (!value.equals(HomeBuyerName)) {
					val = false;
				}
			}
		} else {
			val = false;
		}
		return val;
	}

	public String getFirstHomeBuyerEmail() {
		List<WebElement> elements = driver.findElements(By.xpath("//tr/td[4]"));
		String email = "";
		for (int i = 0; i < elements.size(); i++) {
			email = elements.get(i).getText();
			if (!email.contains("-")) {
				email = email;
			}
		}
		return email;
	}

	public Status searchInHomeBuyerEmailSearchField(String value) {
		try {
			scrollToElement(HomeBuyerEmailSearchField);
			type(HomeBuyerEmailSearchField, 1, value);
			waitTime(7000);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public boolean verifyHomeBuyerEmailSearchResultsAreMatching(String value) {
		boolean val = true;
		if (AllHomeBuyerEmailsAfterSearch.size() > 0) {
			try {
				for (int n = 0; n < AllHomeBuyerEmailsAfterSearch.size(); n++) {

					String HomeBuyerEmail = getElementText(AllHomeBuyerEmailsAfterSearch.get(n));

					if (!value.equals(HomeBuyerEmail)) {
						val = false;
					}
				}
			} catch (Exception e) {
				return false;
			}
		} else
			val = false;
		{

		}
		return val;
	}

	public String getFirstStatus() {
		List<WebElement> elements = driver.findElements(By.xpath("//tr/td[5]"));
		String status = "";
		for (int i = 0; i < elements.size(); i++) {
			status = elements.get(i).getText();
			if (!status.contains("-")) {
				status = status;
			}
		}
		return status;
	}

	public Status searchInStatusSearchField(String value) {
		try {
			scrollToElement(StatusSearchField);
			type(StatusSearchField, 1, value);
			waitTime(7000);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}

	public boolean verifyStatusSearchResultsAreMatching(String value) {
		boolean val = true;
		if (AllStatusAfterSearch.size() > 0) {
			for (int n = 0; n < AllStatusAfterSearch.size(); n++) {

				String status = getElementText(AllStatusAfterSearch.get(n));

				if (!value.equals(status)) {
					val = false;
				}
			}
		} else {
			val = false;
		}
		return val;
	}

	public boolean verifyScenarioHashSearchFilterPlaceholder() {
		try {
			String value = "Scenario Hash";
			String attribute = "placeholder";
			scrollToElement(ScenarioHashSearchField);
			return value.equals(getElementAttributeValue(ScenarioHashSearchField, attribute));
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyHomeBuyerHashSearchFilterPlaceholder() {		
		try {
			String value = "HomeBuyer Hash";
			String attribute = "placeholder";
			scrollToElement(HomeBuyerHashSearchField);
			return value.equals(getElementAttributeValue(HomeBuyerHashSearchField, attribute));
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyNameSearchFilterPlaceholder() {
		try {
			String value = "Name";
			String attribute = "placeholder";
			scrollToElement(HomeBuyerNameSearchField);
			return value.equals(getElementAttributeValue(HomeBuyerNameSearchField, attribute));
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyHomeBuyerEmailSearchFilterPlaceholder() {		
		try {
			String value = "Email";
			String attribute = "placeholder";
			scrollToElement(HomeBuyerEmailSearchField);
			return value.equals(getElementAttributeValue(HomeBuyerEmailSearchField, attribute));
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyStatusSearchFilterPlaceholder() {		
		try {
			String value = "Status";
			String attribute = "placeholder";
			scrollToElement(StatusSearchField);
			return value.equals(getElementAttributeValue(StatusSearchField, attribute));
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyHomeBuyerAndScenarioHashSearchFilterPlaceholder() {		
		try {
			String value = "HomeBuyer/Scenario Hash";
			String attribute = "placeholder";
			scrollToElement(HomeBuyerAndScenarioHashSearchFieldOnSyncSubmissionPage);
			return value
					.equals(getElementAttributeValue(HomeBuyerAndScenarioHashSearchFieldOnSyncSubmissionPage, attribute));
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyScenarioNameSearchFilterPlaceholder() {
		try {
			String value = "Scenario Name";
			String attribute = "placeholder";
			scrollToElement(ScenarioNameSearchFieldOnSyncSubmissionPage);
			return value.equals(getElementAttributeValue(ScenarioNameSearchFieldOnSyncSubmissionPage, attribute));
		} catch (Exception e) {
			return false;
		}

	}
	


	public ArrayList<TestSteps> WhileloggedinVerifyScenariosMenuButton() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnMenuScenariosButton();
			addSubStep(subSteps, "click On Menu Scenarios Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isTitleSynchronizedScenariosDisplaying(),
					" :Verify 'Synchronized Scenarios' Title is displaying");
			addSubStep(subSteps, "Verified 'Synchronized Scenarios' Title is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isColumnLabelScenarioHashDisplaying(),
					" :Verify Column Label 'Scenario Hash'is displaying");
			addSubStep(subSteps, "Verified Column Label 'Scenario Hash'is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isColumnLabelStatusDisplaying(),
					" :Verify Column Label 'Status'is displaying");
			addSubStep(subSteps, "Verified Column Label 'Status'is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isColumnLabelHomeBuyerHashDisplaying(),
					" :Verify Column Label 'Home Buyer Hash'is displaying");
			addSubStep(subSteps, "Verified Column Label 'Home Buyer Hash' is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isColumnLabelHomeBuyerNameDisplaying(),
					" :Verify Column Label 'Home Buyer Name'is displaying");
			addSubStep(subSteps, "Verified Column Label 'Home Buyer Name' is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isColumnLabelHomeBuyerEmailDisplaying(),
					" :Verify Column Label 'Home Buyer Email'is displaying");
			addSubStep(subSteps, "Verified Column Label 'Home Buyer Email'is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isColumnLabelActionDisplaying(),
					" : Verify Column Label 'Action'is displaying");
			addSubStep(subSteps, "Verified Column Label 'Action' is displaying", status);
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

	public ArrayList<TestSteps> WhileLoggedinVerifyBondBuyerMenuButton() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnMenuBondBuyerButton();
			addSubStep(subSteps, "click On Menu Bond Buyer Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isBondBuyerPageTitelDisplaying(),
					" :Verify 'bond buyer' Page Title is displaying");
			addSubStep(subSteps, "Verified 'bond buyer' Page Title is displaying", status);
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

	public ArrayList<TestSteps> WhileLoggedinVerifySynchroniseSubmissionsMenuButton() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnNavMenuSyncSubmissionsButton();
			addSubStep(subSteps, "click On Navigation Menu 'Sync Submissions' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isSyncSubmissionsPageTitleDisplaying(),
					" :Verify Sync Submissions Page Title is displaying");
			addSubStep(subSteps, "Verified  Sync Submissions Page Title is displaying", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isColumnLblHomebuyerHashDisplaying(),
					" :Verify Column Label 'Homebuyer Hash / Scenario Hash (Scneario ID)'is displaying");
			addSubStep(subSteps, "Verified Column Label 'Homebuyer Hash / Scenario Hash (Scneario ID)'is displaying",
					status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isColumnLabelHomeBuyerNameDisplaying()," :Verify Column Label 'Home Buyer Name'is displaying");
			addSubStep(subSteps, "Verified Column Label 'Home Buyer Name'is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isColumnLabelHomeBuyerEmailDisplaying()," :Verify Column Label 'Home Buyer Email'is displaying");
			addSubStep(subSteps, "Verified Column Label 'Home Buyer Email'is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isColumnLabelScenarioNameDisplaying()," :Verify Column Label 'Scenario Name'is displaying");
			addSubStep(subSteps, "Verified Column Label 'Scenario Name'is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isColumnLabelActionDisplaying()," :Verify Column Label 'Action'is displaying");
			addSubStep(subSteps, "Verified Column Label 'Action'is displaying",status);
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

	public ArrayList<TestSteps> WhileLoggedinVerifySyncPersonalDataMenuButton() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = clickOnSyncPersonalDataButtonon();
			addSubStep(subSteps, "click On Navigation Menu 'sync personal data' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isSynchroniePersonalDataTitleDisplaying()," :Verify 'Synchronie Personal Data' Page is displaying");
			addSubStep(subSteps, "Verified 'Synchronie Personal Data' Page is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isColumnLabelScenarioHashDisplaying()," :Verify Column Label 'Scenario Hash' is displaying");
			addSubStep(subSteps, "Verified Column Label 'Scenario Hash' is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(isColumnLabelActionDisplaying()," :Verify Column Label 'Action'is displaying");
			addSubStep(subSteps, "Verified Column Label 'Action'is displaying",status);
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

	public ArrayList<TestSteps> WhileLoggedinVerifySyncPostPurchaseMenuButton() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnMenuSyncPostPurchaseButton();
			addSubStep(subSteps, "click On Menu Scenarios Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(synchronisePostPurchaseDataPageTitelDisplaying()," :Verify Synchronise Post Purchase Data Page Titel is displaying");
			addSubStep(subSteps, "Verified Synchronise Post Purchase Data Page Titel is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
//			initConfiguration();
//			lp = new LoginPage();
//			dashboardPage = new DashboardPage();
//			ErrorCollector.extentLogInfo("Step 1 : Visit web url");
//			openURL("AppURL");
//
//			ErrorCollector.extentLogInfo("Step 2 : Click on login button");
//			lp.clickOnLoginButton();
//
//			String email = PropertiesReader.getPropertyValue(env + "_EmailId");
//			ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
//			lp.enterEmail(email);
//
//			String pass = PropertiesReader.getPropertyValue(env + "_Password");
//			ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
//			lp.enterPassword(pass);
//
//			ErrorCollector.extentLogInfo("Step 5 : Click on 'Login' button");
//			lp.clickOnLoginButton();
//
//			ErrorCollector.extentLogInfo("Step 6 : Verify User 'Login Successfully message' is displaying");
//			ErrorCollector.verifyTrue(lp.isUserDashboardDisplaying(),
//					"Verified User Login Successfully message is displaying");
//
//			ErrorCollector.extentLogInfo("Step 7 : Click on Menu 'Sync Post Purchase' button");
//			clickOnMenuSyncPostPurchaseButton();			

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

	public ArrayList<TestSteps> WhileLoggedinVerifySyncSettlementDataMenuButton() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(isMenuSyncSettlementDataButtonDisplaying()," :Verify Menu Sync Settlement Data Button is displaying");
			addSubStep(subSteps, "Verified Menu Sync Settlement Data Button is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = clickOnMenuSyncSettlementDataButton();
			addSubStep(subSteps, "click On Menu Sync Settlement Data Button", status);
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

	public ArrayList<TestSteps> VerifyTheHomeBuyerSectionFromDetailScreenOfScenarios() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnMenuScenariosButton();
			addSubStep(subSteps, "click On Menu Scenarios Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = clickFirstDestailBtnOnScenarioPage();
			addSubStep(subSteps, "Click on first 'Details' button on synchronized scenarios.", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyHomebuyerTextOnScenariosDetailsPageISDisplaying()," :Verify 'Home Buyer' text is displaying");
			addSubStep(subSteps, "Verified 'Home Buyer' text is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyHomebuyerHashlabelOnScenariosDetailPage()," :Verify 'Home Buyer Hash' label is displaying");
			addSubStep(subSteps, "Verified 'Home Buyer Hash' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyHomebuyeIdLabelOnScenariosDetailPage()," :Verify 'Home Buyer ID' label is displaying");
			addSubStep(subSteps, "Verified 'Home Buyer ID' label is displaying",status);
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

	public ArrayList<TestSteps> VerifyTheHomeBuyerPartySectionFromDetailScreenOfScenarios() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);			

			status = clickOnMenuScenariosButton();
			addSubStep(subSteps, "click On Menu Scenarios Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickFirstDestailBtnOnScenarioPage();
			addSubStep(subSteps, "Click on first 'Details' button on synchronized scenarios.", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyHomebuyerTextOnScenariosDetailsPageISDisplaying()," :Verify 'Home Buyer' text is displaying");
			addSubStep(subSteps, "Verified 'Home Buyer' text is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyHomebuyeIdLabelOnScenariosDetailPage()," :Verify 'Home Buyer ID' label is displaying");
			addSubStep(subSteps, "Verified 'Home Buyer ID' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
//			initConfiguration();
//			lp = new LoginPage();
//			dashboardPage = new DashboardPage();
//			
//			ErrorCollector.extentLogInfo("Step 1 : Visit web url");
//			openURL("AppURL");
//
//			ErrorCollector.extentLogInfo("Step 2 : Click on login button");
//			lp.clickOnLoginButton();
//
//			String email = PropertiesReader.getPropertyValue(env + "_EmailId");
//			ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
//			lp.enterEmail(email);
//
//			String pass = PropertiesReader.getPropertyValue(env + "_Password");
//			ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
//			lp.enterPassword(pass);
//
//			ErrorCollector.extentLogInfo("Step 5 : Click on Login button");
//			lp.clickOnLoginButton();
//			
//			ErrorCollector.extentLogInfo("Step 6 : Click on Navigation Menu 'Scenarios' button");
//			dashboardPage.clickOnMenuScenariosButton();
//			
//			ErrorCollector.extentLogInfo("Step 7 : Click on first 'Details' button on synchronized scenarios.");
//			clickFirstDestailBtnOnScenarioPage();
//			
//			ErrorCollector.extentLogInfo("Step 8 : Verify 'Home Buyer Party' text is displaying");
//			ErrorCollector.verifyTrue(verifyHomeBuyerPartyTextOnScenariosDetailPage() , "Verified 'Home Buyer Party' text is displaying");
////			
//			ErrorCollector.extentLogInfo("Step 9 : Verify 'Home Buyer Party ID' is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyHomebuyerPartyIdLabelOnScenariosDetailPage() , "Verified 'Home Buyer Party ID' is displaying");	
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

	public ArrayList<TestSteps> VerifyTheHomebuyerAccountDetailsSectionFromDetailScreenOfScenarios() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnMenuScenariosButton();
			addSubStep(subSteps, "click On Menu Scenarios Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickFirstDestailBtnOnScenarioPage();
			addSubStep(subSteps, "Click on first 'Details' button on synchronized scenarios.", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = clickOnViewHomeBuyerDetailsButton();
			addSubStep(subSteps, "click on view home buyer details button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);			
			
			
			status = ErrorCollector.verifyTrue(verifyHomeBuyerAccountDetailsTextOnScenariosDetailPage()," :verify 'Home Buyer Account Details' title is displaying");
			addSubStep(subSteps, "Verified 'Home Buyer Account Details' title is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyAccountNameLabelOnScenariosDetailPage()," :verify 'Account Name' label is displaying");
			addSubStep(subSteps, "Verified 'Account Name' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyAccountNumberLabelOnScenariosDetailPage() , "Verified 'Account Number' label is displaying");
			addSubStep(subSteps, "Verified 'Account Number' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyBsbLabelOnScenariosDetailPage() , "Verified 'BSB' label is displaying");
			addSubStep(subSteps, "Verified 'BSB' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyBankNameLabelOnScenariosDetailPage() , "Verified 'Bank Name' label is displaying");
			addSubStep(subSteps, "Verified 'Bank Name' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyBranchLabelOnScenariosDetailPage() , "Verified 'Branch' label is displaying");
			addSubStep(subSteps, "Verified 'Branch' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyHomebuyerAccountDetailsIdLabelOnScenariosDetailPage() , "Verified 'Home Buyer Account Details Id' label is displaying");
			addSubStep(subSteps, "Verified 'Home Buyer Account Details Id' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifySwiftIdLabelOnScenariosDetailPage() , "Verified 'Swift Id' label is displaying");
			addSubStep(subSteps, "Verified 'Swift Id' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
//			initConfiguration();
//			lp = new LoginPage();
//			dashboardPage = new DashboardPage();
//			
//			ErrorCollector.extentLogInfo("Step 1 : Visit web url");
//			openURL("AppURL");
//
//			ErrorCollector.extentLogInfo("Step 2 : Click on login button");
//			lp.clickOnLoginButton();
//
//			String email = PropertiesReader.getPropertyValue(env + "_EmailId");
//			ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
//			lp.enterEmail(email);
//
//			String pass = PropertiesReader.getPropertyValue(env + "_Password");
//			ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
//			lp.enterPassword(pass);
//
//			ErrorCollector.extentLogInfo("Step 5 : Click on Login button");
//			lp.clickOnLoginButton();
//			
//			ErrorCollector.extentLogInfo("Step 6 : Click on Navigation Menu 'Scenarios' button");
//			dashboardPage.clickOnMenuScenariosButton();
//			
//			ErrorCollector.extentLogInfo("Step 7 : Click on first 'Details' button on synchronized scenarios.");
//			dashboardPage.clickFirstDestailBtnOnScenarioPage();
//			
//			ErrorCollector.extentLogInfo("Step 8 : Verify 'Home Buyer Account Details' title is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyHomeBuyerAccountDetailsTextOnScenariosDetailPage() , "Verified 'Home Buyer Account Details' title is displaying");
//			
			
			
//			ErrorCollector.extentLogInfo("Step 9 : Verify 'Account Name' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyAccountNameLabelOnScenariosDetailPage() , "Verified 'Account Name' label is displaying");
//			
			
//			ErrorCollector.extentLogInfo("Step 10 : Verify 'Account Number' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyAccountNumberLabelOnScenariosDetailPage() , "Verified 'Account Number' label is displaying");
//			
			
			
			
//			ErrorCollector.extentLogInfo("Step 11 : Verify 'BSB' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyBsbLabelOnScenariosDetailPage() , "Verified 'BSB' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 12 : Verify 'Bank Name' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyBankNameLabelOnScenariosDetailPage() , "Verified 'Bank Name' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 13 : Verify 'Branch' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyBranchLabelOnScenariosDetailPage() , "Verified 'Branch' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 14 : Verify 'Home Buyer Account Details Id' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyHomebuyerAccountDetailsIdLabelOnScenariosDetailPage() , "Verified 'Home Buyer Account Details Id' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 15 : Verify 'Swift Id' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifySwiftIdLabelOnScenariosDetailPage() , "Verified 'Swift Id' label is displaying");

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

	public ArrayList<TestSteps> VerifyTheHomebuyerPersonalDetailsSectionFromDetailScreenOfScenarios() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = clickOnMenuScenariosButton();
			addSubStep(subSteps, "click On Menu Scenarios Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickFirstDestailBtnOnScenarioPage();
			addSubStep(subSteps, "Click on first 'Details' button on synchronized scenarios.", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = clickOnViewHomeBuyerDetailsButton();
			addSubStep(subSteps, "click on view home buyer details button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);			
			
			
			status = ErrorCollector.verifyTrue(verifyHomeBuyerPersonalDetailsTextOnScenariosDetailPage()," :verify 'Home Buyer Personal Details' title is displaying");
			addSubStep(subSteps, "Verified 'Home Buyer Personal Details' title is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyAddressLabelOnScenariosDetailPage() , "Verified 'Address' label is displaying");
			addSubStep(subSteps, "Verified 'Address' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyCityLabelOnScenariosDetailPage() , "Verified 'City' label is displaying");
			addSubStep(subSteps, "Verified 'City' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyDobLabelOnScenariosDetailPage() , "Verified 'DOB' label is displaying");
			addSubStep(subSteps, "Verified 'DOB' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyFirstNameLabelOnScenariosDetailPage() , "Verified 'First Name' label is displaying");
			addSubStep(subSteps, "Verified 'First Name' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyLastNameLabelOnScenariosDetailPage() , "Verified 'Last Name' label is displaying");
			addSubStep(subSteps, "Verified 'Last Name' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyPhoneNumberLabelOnScenariosDetailPage() , "Verified 'Phone Number' label is displaying");
			addSubStep(subSteps, "Verified 'Phone Number' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyPostCodeLabelOnScenariosDetailPage() , "Verified 'Post Code' label is displaying");
			addSubStep(subSteps, "Verified 'Post Code' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyStateProvinceTerritoryLabelOnScenariosDetailPage() , "Verified 'State/Province/Territory' label is displaying");
			addSubStep(subSteps, "Verified 'State/Province/Territory' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyTitleRoleLabelOnScenariosDetailPage() , "Verified 'Title Role' label is displaying");
			addSubStep(subSteps, "Verified  'Title Role' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

//			initConfiguration();
//			lp = new LoginPage();
//			dashboardPage = new DashboardPage();
//			
//			ErrorCollector.extentLogInfo("Step 1 : Visit web url");
//			openURL("AppURL");
//
//			ErrorCollector.extentLogInfo("Step 2 : Click on login button");
//			lp.clickOnLoginButton();
//
//			String email = PropertiesReader.getPropertyValue(env + "_EmailId");
//			ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
//			lp.enterEmail(email);
//
//			String pass = PropertiesReader.getPropertyValue(env + "_Password");
//			ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
//			lp.enterPassword(pass);
//
//			ErrorCollector.extentLogInfo("Step 5 : Click on Login button");
//			lp.clickOnLoginButton();
//			
//			ErrorCollector.extentLogInfo("Step 6 : Click on Navigation Menu 'Scenarios' button");
//			dashboardPage.clickOnMenuScenariosButton();
//			
//			ErrorCollector.extentLogInfo("Step 7 : Click on first 'Details' button on synchronized scenarios.");
//			dashboardPage.clickFirstDestailBtnOnScenarioPage();
//			
//			ErrorCollector.extentLogInfo("Step 8 : Verify 'Home Buyer Personal Details' title is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyHomeBuyerPersonalDetailsTextOnScenariosDetailPage() , "Verified 'Home Buyer Personal Details' title is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 9 : Verify 'Address' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyAddressLabelOnScenariosDetailPage() , "Verified 'Address' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 10 : Verify 'City' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyCityLabelOnScenariosDetailPage() , "Verified 'City' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 11 : Verify 'DOB' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyDobLabelOnScenariosDetailPage() , "Verified 'DOB' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 12 : Verify 'First Name' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyFirstNameLabelOnScenariosDetailPage() , "Verified 'First Name' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 13 : Verify 'Last Name' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyLastNameLabelOnScenariosDetailPage() , "Verified 'Last Name' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 14 : Verify 'Phone Number' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyPhoneNumberLabelOnScenariosDetailPage() , "Verified 'Phone Number' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 15 : Verify 'Post Code' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyPostCodeLabelOnScenariosDetailPage() , "Verified 'Post Code' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 16 : Verify 'State/Province/Territory' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyStateProvinceTerritoryLabelOnScenariosDetailPage() , "Verified 'State/Province/Territory' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 17 : Verify 'Title Role' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyTitleRoleLabelOnScenariosDetailPage() , "Verified 'Title Role' label is displaying");

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

	public ArrayList<TestSteps> VerifyThePropertySectionFromDetailScreenOfScenarios() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = clickOnMenuScenariosButton();
			addSubStep(subSteps, "click On Menu Scenarios Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickFirstDestailBtnOnScenarioPage();
			addSubStep(subSteps, "Click on first 'Details' button on synchronized scenarios.", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(verifyPropertyTextOnScenariosDetailPage() , "Verified 'Property' title is displaying");
			addSubStep(subSteps, "Verified 'Property' title is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyPropertyIdLabelOnScenariosDetailPage() , "Verified 'Property Id' label is displaying");
			addSubStep(subSteps, "Verified 'Property Id' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyPropertyPurchasePriceLabelOnScenariosDetailPage() , "Verified 'Property Purchase Price' label is displayin");
			addSubStep(subSteps, "Verified 'Property Purchase Price' label is displayin",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyPropertyStateLabelOnScenariosDetailPage() , "Verified 'Property State' label is displaying");
			addSubStep(subSteps, "Verified 'Property State' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

//			initConfiguration();
//			lp = new LoginPage();
//			dashboardPage = new DashboardPage();
//			
//			ErrorCollector.extentLogInfo("Step 1 : Visit web url");
//			openURL("AppURL");
//
//			ErrorCollector.extentLogInfo("Step 2 : Click on login button");
//			lp.clickOnLoginButton();
//
//			String email = PropertiesReader.getPropertyValue(env + "_EmailId");
//			ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
//			lp.enterEmail(email);
//
//			String pass = PropertiesReader.getPropertyValue(env + "_Password");
//			ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
//			lp.enterPassword(pass);
//
//			ErrorCollector.extentLogInfo("Step 5 : Click on Login button");
//			lp.clickOnLoginButton();
//			
//			ErrorCollector.extentLogInfo("Step 6 : Click on Navigation Menu 'Scenarios' button");
//			dashboardPage.clickOnMenuScenariosButton();
//			
//			ErrorCollector.extentLogInfo("Step 7 : Click on first 'Details' button on synchronized scenarios.");
//			dashboardPage.clickFirstDestailBtnOnScenarioPage();
//			
//			ErrorCollector.extentLogInfo("Step 8 : Verify 'Property' title is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyPropertyTextOnScenariosDetailPage() , "Verified 'Property' title is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 9 : Verify 'Property Id' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyPropertyIdLabelOnScenariosDetailPage() , "Verified 'Property Id' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 10 : Verify 'Property Purchase Price' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyPropertyPurchasePriceLabelOnScenariosDetailPage() , "Verified 'Property Purchase Price' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 11 : Verify 'Property State' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyPropertyStateLabelOnScenariosDetailPage() , "Verified 'Property State' label is displaying");

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

	public ArrayList<TestSteps> VerifyThePropertyClassSectionFromDetailScreenOfScenarios() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnMenuScenariosButton();
			addSubStep(subSteps, "click On Menu Scenarios Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickFirstDestailBtnOnScenarioPage();
			addSubStep(subSteps, "Click on first 'Details' button on synchronized scenarios.", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(verifyPropertyClassTextOnScenariosDetailPage() , "Verified 'Property Class' title is displaying");
			addSubStep(subSteps, "Verified 'Property Class' title is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyNumberOfBedroomsLabelOnScenariosDetailPage() , "Verified 'Number of Bedrooms' label is displaying");
			addSubStep(subSteps, "Verified 'Number of Bedrooms' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyPropertyClassTextOnScenariosDetailPage() , "Verified 'Property Class' title is displaying");
			addSubStep(subSteps, "Verified 'Property Class' title is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
//			status = ErrorCollector.verifyTrue(verifyPropertyClassIdLabelOnScenariosDetailPage() , "Verified 'Property Class Id' label is displaying");
//			addSubStep(subSteps, "Verified 'Property Class Id' label is displaying",status);
//			if (status.equals(Status.FAIL))
//				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifySuburbLabelOnScenariosDetailPage() , "Verified 'Suburb' label is displaying");
			addSubStep(subSteps, "Verified 'Suburb' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
//			initConfiguration();
//			lp = new LoginPage();
//			dashboardPage = new DashboardPage();
//			
//			ErrorCollector.extentLogInfo("Step 1 : Visit web url");
//			openURL("AppURL");
//
//			ErrorCollector.extentLogInfo("Step 2 : Click on login button");
//			lp.clickOnLoginButton();
//
//			String email = PropertiesReader.getPropertyValue(env + "_EmailId");
//			ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
//			lp.enterEmail(email);
//
//			String pass = PropertiesReader.getPropertyValue(env + "_Password");
//			ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
//			lp.enterPassword(pass);
//
//			ErrorCollector.extentLogInfo("Step 5 : Click on Login button");
//			lp.clickOnLoginButton();
//			
//			ErrorCollector.extentLogInfo("Step 6 : Click on Navigation Menu 'Scenarios' button");
//			dashboardPage.clickOnMenuScenariosButton();
//			
//			ErrorCollector.extentLogInfo("Step 7 : Click on first 'Details' button on synchronized scenarios.");
//			dashboardPage.clickFirstDestailBtnOnScenarioPage();
//			
//			ErrorCollector.extentLogInfo("Step 8 : Verify 'Property Class' title is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyPropertyClassTextOnScenariosDetailPage() , "Verified 'Property Class' title is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 9 : Verify 'Number of Bedrooms' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyNumberOfBedroomsLabelOnScenariosDetailPage() , "Verified 'Number of Bedrooms' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 10 : Verify 'Property Class Id' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyPropertyClassIdLabelOnScenariosDetailPage() , "Verified 'Property Class Id' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 11 : Verify 'Property Type' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyPropertyTypeLabelOnScenariosDetailPage() , "Verified 'Property Type' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 12 : Verify 'Suburb' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifySuburbLabelOnScenariosDetailPage() , "Verified 'Suburb' label is displaying");

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

	public ArrayList<TestSteps> VerifyTheScenarioSectionFromDetailScreenOfScenarios() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			

			status = clickOnMenuScenariosButton();
			addSubStep(subSteps, "click On Menu Scenarios Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickFirstDestailBtnOnScenarioPage();
			addSubStep(subSteps, "Click on first 'Details' button on synchronized scenarios.", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(verifyScenarioTextOnScenariosDetailPage() , "Verified 'Scenario' title is displaying");
			addSubStep(subSteps, "Verified 'Scenario' title is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyBrokerIdLabelOnScenariosDetailPage() , "Verified 'Broker Id' label is displaying");
			addSubStep(subSteps, "Verified 'Broker Id' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyLoanAmountOfferLabelOnScenariosDetailPage() , "Verified 'Loan Amount Offer' label is displaying");
			addSubStep(subSteps, "Verified  'Loan Amount Offer' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyLoanAmountRequestedLabelOnScenariosDetailPage() , "Verified 'Loan Amount Requested' label is displaying");
			addSubStep(subSteps, "Verified 'Loan Amount Requested' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyNotesLabelOnScenariosDetailPage() , "Verified 'Notes' label is displaying");
			addSubStep(subSteps, "Verified 'Notes' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyScenarioHashLabelOnScenariosDetailPage() , "Verified 'Scenario Hash' label is displaying");
			addSubStep(subSteps, "Verified'Scenario Hash' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyScenarioIdLabelOnScenariosDetailPage() , "Verified 'Scenario Id' label is displaying");
			addSubStep(subSteps, "Verified 'Scenario Id' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyScenarioStateLabelOnScenariosDetailPage() , "Verified 'Scenario State' label is displaying");
			addSubStep(subSteps, "Verified 'Scenario State' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyStatusLabelOnScenariosDetailPage() , "Verified 'Status' label is displaying");
			addSubStep(subSteps, "Verified  'Status' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			


//			initConfiguration();
//			lp = new LoginPage();
//			dashboardPage = new DashboardPage();
//			
//			ErrorCollector.extentLogInfo("Step 1 : Visit web url");
//			openURL("AppURL");
//
//			ErrorCollector.extentLogInfo("Step 2 : Click on login button");
//			lp.clickOnLoginButton();
//
//			String email = PropertiesReader.getPropertyValue(env + "_EmailId");
//			ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
//			lp.enterEmail(email);
//
//			String pass = PropertiesReader.getPropertyValue(env + "_Password");
//			ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
//			lp.enterPassword(pass);
//
//			ErrorCollector.extentLogInfo("Step 5 : Click on Login button");
//			lp.clickOnLoginButton();
//			
//			ErrorCollector.extentLogInfo("Step 6 : Click on Navigation Menu 'Scenarios' button");
//			dashboardPage.clickOnMenuScenariosButton();
//			
//			ErrorCollector.extentLogInfo("Step 7 : Click on first 'Details' button on synchronized scenarios.");
//			dashboardPage.clickFirstDestailBtnOnScenarioPage();
//			
//			ErrorCollector.extentLogInfo("Step 8 : Verify 'Scenario' title is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyScenarioTextOnScenariosDetailPage() , "Verified 'Scenario' title is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 9 : Verify 'Broker Id' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyBrokerIdLabelOnScenariosDetailPage() , "Verified 'Broker Id' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 10 : Verify 'Loan Amount Offer' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyLoanAmountOfferLabelOnScenariosDetailPage() , "Verified 'Loan Amount Offer' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 11 : Verify 'Loan Amount Requested' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyLoanAmountRequestedLabelOnScenariosDetailPage() , "Verified 'Loan Amount Requested' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 12 : Verify 'Notes' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyNotesLabelOnScenariosDetailPage() , "Verified 'Notes' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 13 : Verify 'Scenario Hash' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyScenarioHashLabelOnScenariosDetailPage() , "Verified 'Scenario Hash' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 14 : Verify 'Scenario Id' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyScenarioIdLabelOnScenariosDetailPage() , "Verified 'Scenario Id' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 15 : Verify 'Scenario State' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyScenarioStateLabelOnScenariosDetailPage() , "Verified 'Scenario State' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 16 : Verify 'Status' label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyStatusLabelOnScenariosDetailPage() , "Verified 'Status' label is displaying");

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

	public ArrayList<TestSteps> VerifyTheBackButtonFromDetailScreenOfScenarios() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnMenuScenariosButton();
			addSubStep(subSteps, "click On Menu Scenarios Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickFirstDestailBtnOnScenarioPage();
			addSubStep(subSteps, "Click on first 'Details' button on synchronized scenarios.", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = clickBackButtonOnScenarioDetailsPage();
			addSubStep(subSteps, "Click on  'Back' button on scenarios details.", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = ErrorCollector.verifyTrue(isTitleSynchronizedScenariosDisplaying() , "Verified 'Synchronized Scenario' label is displaying");
			addSubStep(subSteps, "Verified'Synchronized Scenario' label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(isColumnLabelScenarioHashDisplaying() , "Verified 'Scenario Hash' column label is displaying");
			addSubStep(subSteps, "Verified 'Scenario Hash' column label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(isColumnLabelStatusDisplaying() , "Verified 'Status' column label is displaying");
			addSubStep(subSteps, "Verified 'Status' column label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(isColumnLabelHomeBuyerHashDisplaying() , "Verified 'Home Buyer Hash' column label is displaying");
			addSubStep(subSteps, "Verified 'Home Buyer Hash' column label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(isColumnLabelHomeBuyerNameDisplaying() , "Verified 'HomeBuyer Name' column label is displaying");
			addSubStep(subSteps, "Verified  'HomeBuyer Name' column label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(isColumnLabelHomeBuyerEmailDisplaying() , "Verified 'Home Buyer Email' column label is displaying");
			addSubStep(subSteps, "Verified  'Home Buyer Email' column label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(isColumnLabelActionDisplaying() , "Verified 'Action' column label is displaying");
			addSubStep(subSteps, "Verified  'Action' column label is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
//			initConfiguration();
//			lp = new LoginPage();
//			dashboardPage = new DashboardPage();
//			
//			ErrorCollector.extentLogInfo("Step 1 : Visit web url");
//			openURL("AppURL");
//
//			ErrorCollector.extentLogInfo("Step 2 : Click on login button");
//			lp.clickOnLoginButton();
//
//			String email = PropertiesReader.getPropertyValue(env + "_EmailId");
//			ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
//			lp.enterEmail(email);
//
//			String pass = PropertiesReader.getPropertyValue(env + "_Password");
//			ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
//			lp.enterPassword(pass);
//
//			ErrorCollector.extentLogInfo("Step 5 : Click on Login button");
//			lp.clickOnLoginButton();
//			
//			ErrorCollector.extentLogInfo("Step 6 : Click on Navigation Menu 'Scenarios' button");
//			dashboardPage.clickOnMenuScenariosButton();
//			
//			ErrorCollector.extentLogInfo("Step 7 : Click on first 'Details' button on synchronized scenarios.");
//			dashboardPage.clickFirstDestailBtnOnScenarioPage();
//			
//			ErrorCollector.extentLogInfo("Step 8 : Click 'Back' button on scenarios details.");
//			clickBackButtonOnScenarioDetailsPage();
//			
//			ErrorCollector.extentLogInfo("Step 9 : Verify 'Synchronized Scenario' is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.isTitleSynchronizedScenariosDisplaying() , "Verified 'Synchronized Scenario' label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 10 : Verify 'Scenario Hash' column label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.isColumnLabelScenarioHashDisplaying() , "Verified 'Scenario Hash' column label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 11 : Verify 'Status' column label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.isColumnLabelStatusDisplaying() , "Verified 'Status' column label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 12 : Verify 'Home Buyer Hash' column label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.isColumnLabelHomeBuyerHashDisplaying() , "Verified 'Home Buyer Hash' column label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 13 : Verify 'Home Buyer Name' column label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.isColumnLabelHomeBuyerNameDisplaying() , "Verified 'HomeBuyer Name' column label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 14 : Verify 'Home Buyer Email' column label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.isColumnLabelHomeBuyerEmailDisplaying() , "Verified 'Home Buyer Email' column label is displaying");
//			
//			ErrorCollector.extentLogInfo("Step 15 : Verify 'Action' column label is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.isColumnLabelActionDisplaying() , "Verified 'Action' column label is displaying");

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

	public ArrayList<TestSteps> VerifyThePaginationFromTheSynchronizedScenariosScreen() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = clickOnMenuScenariosButton();
			addSubStep(subSteps, "click On Menu Scenarios Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(isTitleSynchronizedScenariosDisplaying() , "Verified  <b>Synchronized Scenario</b> is displaying");
			addSubStep(subSteps, "Verified  <b>Synchronized Scenario</b> is displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			
			status = select30Entries();
			addSubStep(subSteps, "select '30' Entries to show", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
						
			status = ErrorCollector.verifyTrue(verifyScenariosListSizeOnSynchronizedScenarios() , "Verified <b>30</b> synchronized scenarios are displaying");
			addSubStep(subSteps, "Verified <b>30</b> synchronized scenarios are displaying",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);


//			initConfiguration();
//			lp = new LoginPage();
//			dashboardPage = new DashboardPage();
//			
//			ErrorCollector.extentLogInfo("Step 1 : Visit web url");
//			openURL("AppURL");
//
//			ErrorCollector.extentLogInfo("Step 2 : Click on login button");
//			lp.clickOnLoginButton();
//
//			String email = PropertiesReader.getPropertyValue(env + "_EmailId");
//			ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
//			lp.enterEmail(email);
//
//			String pass = PropertiesReader.getPropertyValue(env + "_Password");
//			ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
//			lp.enterPassword(pass);
//
//			ErrorCollector.extentLogInfo("Step 5 : Click on Login button");
//			lp.clickOnLoginButton();
//			
//			ErrorCollector.extentLogInfo("Step 6 : Click on Navigation Menu 'Scenarios' button");
//			dashboardPage.clickOnMenuScenariosButton();
//			
//			ErrorCollector.extentLogInfo("Step 7 : Verify <b>Synchronized Scenario</b> is displaying");
//			ErrorCollector.verifyTrue(dashboardPage.isTitleSynchronizedScenariosDisplaying() , "Verified <b>Synchronized Scenario</b> is displaying");
////			
//			ErrorCollector.extentLogInfo("Step 8 : select '30' Entries to show");
//			dashboardPage.select30Entries();
//			
//			ErrorCollector.extentLogInfo("Step 9 : Verify <b>30</b> synchronized scenarios are displaying");
//			ErrorCollector.verifyTrue(dashboardPage.verifyScenariosListSizeOnSynchronizedScenarios() , "Verified <b>30</b> synchronized scenarios are displaying");

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

	public ArrayList<TestSteps> VerifyTheScenarioHashSearchFilterFromTheSynchronizedScenariosScreen() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = clickOnMenuScenariosButton();
			addSubStep(subSteps, "click On Menu Scenarios Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);			

			String scenarioHash = getFirstScenarioHash();

			status =  searchInScenarioHashSearchField(scenarioHash);
			addSubStep(subSteps, "Search in 'Scenario Hash' search field", status);
	
			status = ErrorCollector.verifyTrue(verifyScenarioHashSearchResultsAreMatching(scenarioHash), "Verified results against <b>Scenario Hash</b> search");
			addSubStep(subSteps, "Verified results against <b>Scenario Hash</b> search",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

//			initConfiguration();
//			lp = new LoginPage();
//			dashboardPage = new DashboardPage();
//			
//			ErrorCollector.extentLogInfo("Step 1 : Visit web url");
//			openURL("AppURL");
//
//			ErrorCollector.extentLogInfo("Step 2 : Click on login button");
//			lp.clickOnLoginButton();
//
//			String email = PropertiesReader.getPropertyValue(env + "_EmailId");
//			ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
//			lp.enterEmail(email);
//
//			String pass = PropertiesReader.getPropertyValue(env + "_Password");
//			ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
//			lp.enterPassword(pass);
//
//			ErrorCollector.extentLogInfo("Step 5 : Click on Login button");
//			lp.clickOnLoginButton();
//			
//			ErrorCollector.extentLogInfo("Step 6 : Click on Navigation Menu 'Scenarios' button");
//			dashboardPage.clickOnMenuScenariosButton();

//			ErrorCollector.extentLogInfo("Step 9 : Verifying results against 'Scenario Hash' search");
//			ErrorCollector.assertTrue(dashboardPage.verifyScenarioHashSearchResultsAreMatching(scenarioHash), "Verified results against <b>Scenario Hash</b> search");

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

	public ArrayList<TestSteps> VerifyTheHomeBuyerHashSearchFilterFromTheSynchronizedScenariosScreen() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = clickOnMenuScenariosButton();
			addSubStep(subSteps, "click On Menu Scenarios Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);			

			String scenarioHash = getFirstScenarioHash();
			
			status =  searchInScenarioHashSearchField(scenarioHash);;
			addSubStep(subSteps, "Search in 'Scenario Hash' search field", status);
	
			status = ErrorCollector.verifyTrue(verifyScenarioHashSearchResultsAreMatching(scenarioHash), " Verifying results against 'Scenario Hash' search");
			addSubStep(subSteps, "Verified results against <b>Scenario Hash</b> search",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			

//			initConfiguration();
//			lp = new LoginPage();
//			dashboardPage = new DashboardPage();
//			
//			ErrorCollector.extentLogInfo("Step 1 : Visit web url");
//			openURL("AppURL");
//
//			ErrorCollector.extentLogInfo("Step 2 : Click on login button");
//			lp.clickOnLoginButton();
//
//			String email = PropertiesReader.getPropertyValue(env + "_EmailId");
//			ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
//			lp.enterEmail(email);
//
//			String pass = PropertiesReader.getPropertyValue(env + "_Password");
//			ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
//			lp.enterPassword(pass);
//
//			ErrorCollector.extentLogInfo("Step 5 : Click on Login button");
//			lp.clickOnLoginButton();
//			
//			ErrorCollector.extentLogInfo("Step 6 : Click on Navigation Menu 'Scenarios' button");
//			dashboardPage.clickOnMenuScenariosButton();
//			
//			ErrorCollector.extentLogInfo("Step 7 : Getting first 'Scenario Hash'.");
//			String scenarioHash = dashboardPage.getFirstScenarioHash();
//			
//			ErrorCollector.extentLogInfo("Step 8 : Search in 'Scenario Hash' search field");
//			dashboardPage.searchInScenarioHashSearchField(scenarioHash);
//			
//			ErrorCollector.extentLogInfo("Step 9 : Verifying results against 'Scenario Hash' search");
//			ErrorCollector.assertTrue(dashboardPage.verifyScenarioHashSearchResultsAreMatching(scenarioHash), "Verified results against <b>Scenario Hash</b> search");

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

	public ArrayList<TestSteps> VerifyTheNameSearchFilterFromTheSynchronizedScenariosScreen() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnMenuScenariosButton();
			addSubStep(subSteps, "click On Menu Scenarios Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			String scenarioHash = getFirstScenarioHash();
			
			status = searchInScenarioHashSearchField(scenarioHash);
			addSubStep(subSteps, "Search in 'Scenario Hash' search field", status);
	
			status = ErrorCollector.verifyTrue(verifyScenarioHashSearchResultsAreMatching(scenarioHash), " Verifying results against 'Scenario Hash' search");
			addSubStep(subSteps, "Verified results against <b>Scenario Hash</b> search",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
//			initConfiguration();
//			lp = new LoginPage();
//			dashboardPage = new DashboardPage();
//			
//			ErrorCollector.extentLogInfo("Step 1 : Visit web url");
//			openURL("AppURL");
//
//			ErrorCollector.extentLogInfo("Step 2 : Click on login button");
//			lp.clickOnLoginButton();
//
//			String email = PropertiesReader.getPropertyValue(env + "_EmailId");
//			ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
//			lp.enterEmail(email);
//
//			String pass = PropertiesReader.getPropertyValue(env + "_Password");
//			ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
//			lp.enterPassword(pass);
//
//			ErrorCollector.extentLogInfo("Step 5 : Click on Login button");
//			lp.clickOnLoginButton();
//			
//			ErrorCollector.extentLogInfo("Step 6 : Click on Navigation Menu 'Scenarios' button");
//			dashboardPage.clickOnMenuScenariosButton();
//			
//			ErrorCollector.extentLogInfo("Step 7 : Getting first 'Scenario Hash'.");
//			String scenarioHash = dashboardPage.getFirstScenarioHash();
//			
//			ErrorCollector.extentLogInfo("Step 8 : Search in 'Scenario Hash' search field");
//			dashboardPage.searchInScenarioHashSearchField(scenarioHash);
//			
//			ErrorCollector.extentLogInfo("Step 9 : Verifying results against 'Scenario Hash' search");
//			ErrorCollector.assertTrue(dashboardPage.verifyScenarioHashSearchResultsAreMatching(scenarioHash), "Verified results against <b>Scenario Hash</b> search");
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

	public ArrayList<TestSteps> VerifyTheHomeBuyerEmailSearchFilterFromTheSynchronizedScenariosScreen() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = clickOnMenuScenariosButton();
			addSubStep(subSteps, "click On Menu Scenarios Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			String HomeBuyerEmail = getFirstHomeBuyerEmail();
			
			status = searchInHomeBuyerEmailSearchField(HomeBuyerEmail);
			addSubStep(subSteps, "Search in 'Scenario Hash' search field", status);
	
			status = ErrorCollector.verifyTrue(verifyHomeBuyerEmailSearchResultsAreMatching(HomeBuyerEmail), "Verified results against <b>HomeBuyer Email</b> search");
			addSubStep(subSteps, "Verified results against <b>HomeBuyer Email</b> search",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

//			initConfiguration();
//			lp = new LoginPage();
//			dashboardPage = new DashboardPage();
//			
//			ErrorCollector.extentLogInfo("Step 1 : Visit web url");
//			openURL("AppURL");
//
//			ErrorCollector.extentLogInfo("Step 2 : Click on login button");
//			lp.clickOnLoginButton();
//
//			String email = PropertiesReader.getPropertyValue(env + "_EmailId");
//			ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
//			lp.enterEmail(email);
//
//			String pass = PropertiesReader.getPropertyValue(env + "_Password");
//			ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
//			lp.enterPassword(pass);
//
//			ErrorCollector.extentLogInfo("Step 5 : Click on Login button");
//			lp.clickOnLoginButton();
//			
//			ErrorCollector.extentLogInfo("Step 6 : Click on Navigation Menu 'Scenarios' button");
//			dashboardPage.clickOnMenuScenariosButton();
//			
//			ErrorCollector.extentLogInfo("Step 7 : Getting first 'HomeBuyer Email'.");
//			String HomeBuyerEmail = dashboardPage.getFirstHomeBuyerEmail();
//			
//			ErrorCollector.extentLogInfo("Step 8 : Search in 'HomeBuyer Email' search field");
//			dashboardPage.searchInHomeBuyerEmailSearchField(HomeBuyerEmail);
//			try {
//			ErrorCollector.extentLogInfo("Step 9 : Verifying results against 'HomeBuyer Email' search");
//			ErrorCollector.assertTrue(dashboardPage.verifyHomeBuyerEmailSearchResultsAreMatching(HomeBuyerEmail), "Verified results against <b>HomeBuyer Email</b> search");
//			}catch(Exception e) {
//				ErrorCollector.extentLogInfo("Step 10 : Verified results against <b>HomeBuyer Email</b> search");
//			}
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

	public ArrayList<TestSteps> VerifyTheStatusSearchFilterFromTheSynchronizedScenariosScreen() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			
			status = clickOnMenuScenariosButton();
			addSubStep(subSteps, "click On Menu Scenarios Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			String getStatus = getFirstStatus();
			
			status = searchInStatusSearchField(getStatus);
			addSubStep(subSteps, "Search in 'Status' search field", status);
	
			status = ErrorCollector.verifyTrue(verifyStatusSearchResultsAreMatching(getStatus), "Verified results against <b>Status</b> search");
			addSubStep(subSteps, "Verified  results against <b>Status</b> search",status);
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

	public ArrayList<TestSteps> VerifyTheScenarioHashPlaceholderFromTheSynchronizedScenariosScreen() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnMenuScenariosButton();
			addSubStep(subSteps, "click On Menu Scenarios Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyScenarioHashSearchFilterPlaceholder(), "Verified <b>Scenario Hash</b> placeholder in scenario hash search filter.");
			addSubStep(subSteps, "Verified  <b>Scenario Hash</b> placeholder in scenario hash search filter.",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
//			initConfiguration();
//			lp = new LoginPage();
//			dashboardPage = new DashboardPage();
//			
//			ErrorCollector.extentLogInfo("Step 1 : Visit web url");
//			openURL("AppURL");
//
//			ErrorCollector.extentLogInfo("Step 2 : Click on login button");
//			lp.clickOnLoginButton();
//
//			String email = PropertiesReader.getPropertyValue(env + "_EmailId");
//			ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
//			lp.enterEmail(email);
//
//			String pass = PropertiesReader.getPropertyValue(env + "_Password");
//			ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
//			lp.enterPassword(pass);
//
//			ErrorCollector.extentLogInfo("Step 5 : Click on Login button");
//			lp.clickOnLoginButton();
//			
//			ErrorCollector.extentLogInfo("Step 6 : Click on Navigation Menu 'Scenarios' button");
//			dashboardPage.clickOnMenuScenariosButton();
//			
//			ErrorCollector.extentLogInfo("Step 7 : Verifying <b>Scenario Hash</b> placeholder in scenario hash search filter.");
//			ErrorCollector.assertTrue(dashboardPage.verifyScenarioHashSearchFilterPlaceholder(), "Verified <b>Scenario Hash</b> placeholder in scenario hash search filter.");

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

	public ArrayList<TestSteps> VerifyTheHomeBuyerHashPlaceholderFromTheSynchronizedScenariosScreen() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnMenuScenariosButton();
			addSubStep(subSteps, "click On Menu Scenarios Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyHomeBuyerHashSearchFilterPlaceholder(), "Verified <b>HomeBuyer Hash</b> placeholder in HomeBuyer Hash search filter.");
			addSubStep(subSteps, "Verified <b>HomeBuyer Hash</b> placeholder in HomeBuyer Hash search filter.",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
//			initConfiguration();
//			lp = new LoginPage();
//			dashboardPage = new DashboardPage();
//			
//			ErrorCollector.extentLogInfo("Step 1 : Visit web url");
//			openURL("AppURL");
//
//			ErrorCollector.extentLogInfo("Step 2 : Click on login button");
//			lp.clickOnLoginButton();
//
//			String email = PropertiesReader.getPropertyValue(env + "_EmailId");
//			ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
//			lp.enterEmail(email);
//
//			String pass = PropertiesReader.getPropertyValue(env + "_Password");
//			ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
//			lp.enterPassword(pass);
//
//			ErrorCollector.extentLogInfo("Step 5 : Click on Login button");
//			lp.clickOnLoginButton();
//			
//			ErrorCollector.extentLogInfo("Step 6 : Click on Navigation Menu 'Scenarios' button");
//			dashboardPage.clickOnMenuScenariosButton();
//			
//			ErrorCollector.extentLogInfo("Step 7 : Verifying <b>HomeBuyer Hash</b> placeholder in HomeBuyer Hash search filter.");
//			ErrorCollector.assertTrue(dashboardPage.verifyHomeBuyerHashSearchFilterPlaceholder(), "Verified <b>HomeBuyer Hash</b> placeholder in HomeBuyer Hash search filter.");

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

	public ArrayList<TestSteps> VerifyTheNamePlaceholderFromTheSynchronizedScenariosScreen() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = clickOnMenuScenariosButton();
			addSubStep(subSteps, "click On Menu Scenarios Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyNameSearchFilterPlaceholder(), "Verified <b>Name</b> placeholder in Name search filter.");
			addSubStep(subSteps, "Verified <b>Name</b> placeholder in Name search filter.",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

//			initConfiguration();
//			lp = new LoginPage();
//			dashboardPage = new DashboardPage();
//			
//			ErrorCollector.extentLogInfo("Step 1 : Visit web url");
//			openURL("AppURL");
//
//			ErrorCollector.extentLogInfo("Step 2 : Click on login button");
//			lp.clickOnLoginButton();
//
//			String email = PropertiesReader.getPropertyValue(env + "_EmailId");
//			ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
//			lp.enterEmail(email);
//
//			String pass = PropertiesReader.getPropertyValue(env + "_Password");
//			ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
//			lp.enterPassword(pass);
//
//			ErrorCollector.extentLogInfo("Step 5 : Click on Login button");
//			lp.clickOnLoginButton();
//			
//			ErrorCollector.extentLogInfo("Step 6 : Click on Navigation Menu 'Scenarios' button");
//			dashboardPage.clickOnMenuScenariosButton();
//			
//			ErrorCollector.extentLogInfo("Step 7 : Verifying <b>Name</b> placeholder in Name search filter.");
//			ErrorCollector.assertTrue(dashboardPage.verifyNameSearchFilterPlaceholder(), "Verified <b>Name</b> placeholder in Name search filter.");

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

	public ArrayList<TestSteps> VerifyTheEmailPlaceholderFromTheSynchronizedScenariosScreen() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnMenuScenariosButton();
			addSubStep(subSteps, "click On Menu Scenarios Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyHomeBuyerEmailSearchFilterPlaceholder(), "Verified <b>Email</b> placeholder in Email search filter.");
			addSubStep(subSteps, "Verified <b>Email</b> placeholder in Email search filter.",status);
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

	public ArrayList<TestSteps> VerifyTheStatusPlaceholderFromTheSynchronizedScenariosScreen() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnMenuScenariosButton();
			addSubStep(subSteps, "click On Menu Scenarios Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyStatusSearchFilterPlaceholder(), "Verified <b>Status</b> placeholder in Status search filter.");
			addSubStep(subSteps, "Verified <b>Status</b> placeholder in Status search filter.",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

//			initConfiguration();
//			lp = new LoginPage();
//			dashboardPage = new DashboardPage();
//			
//			ErrorCollector.extentLogInfo("Step 1 : Visit web url");
//			openURL("AppURL");
//
//			ErrorCollector.extentLogInfo("Step 2 : Click on login button");
//			lp.clickOnLoginButton();
//
//			String email = PropertiesReader.getPropertyValue(env + "_EmailId");
//			ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
//			lp.enterEmail(email);
//
//			String pass = PropertiesReader.getPropertyValue(env + "_Password");
//			ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
//			lp.enterPassword(pass);
//
//			ErrorCollector.extentLogInfo("Step 5 : Click on Login button");
//			lp.clickOnLoginButton();
//			
//			ErrorCollector.extentLogInfo("Step 6 : Click on Navigation Menu 'Scenarios' button");
//			dashboardPage.clickOnMenuScenariosButton();
//			
//			ErrorCollector.extentLogInfo("Step 7 : Verifying <b>Status</b> placeholder in Status search filter.");
//			ErrorCollector.assertTrue(dashboardPage.verifyStatusSearchFilterPlaceholder(), "Verified <b>Status</b> placeholder in Status search filter.");

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

	public ArrayList<TestSteps> VerifyTheHomeBuyerAndScenarioHashPlaceholderFromThSynchroniseSubmissionsScreen() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnNavMenuSyncSubmissionsButton();;
			addSubStep(subSteps, "Click on Navigation Menu 'Sync Submissions' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyHomeBuyerAndScenarioHashSearchFilterPlaceholder(), "Verified <b>HomeBuyer/Scenario Hash</b> placeholder in HomeBuyer/Scenario Hash search filter.");
			addSubStep(subSteps, "Verified <b>HomeBuyer/Scenario Hash</b> placeholder in HomeBuyer/Scenario Hash search filter.",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
//			initConfiguration();
//			lp = new LoginPage();
//			dashboardPage = new DashboardPage();
//			
//			ErrorCollector.extentLogInfo("Step 1 : Visit web url");
//			openURL("AppURL");
//
//			ErrorCollector.extentLogInfo("Step 2 : Click on login button");
//			lp.clickOnLoginButton();
//
//			String email = PropertiesReader.getPropertyValue(env + "_EmailId");
//			ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
//			lp.enterEmail(email);
//
//			String pass = PropertiesReader.getPropertyValue(env + "_Password");
//			ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
//			lp.enterPassword(pass);
//
//			ErrorCollector.extentLogInfo("Step 5 : Click on Login button");
//			lp.clickOnLoginButton();
//			
//			ErrorCollector.extentLogInfo("Step 6 : Click on Navigation Menu 'Sync Submissions' button");
//			dashboardPage.clickOnNavMenuSyncSubmissionsButton();
//			
//			ErrorCollector.extentLogInfo("Step 7 : Verifying <b>HomeBuyer/Scenario Hash</b> placeholder in HomeBuyer/Scenario Hash search filter.");
//			ErrorCollector.assertTrue(dashboardPage.verifyHomeBuyerAndScenarioHashSearchFilterPlaceholder(), "Verified <b>HomeBuyer/Scenario Hash</b> placeholder in HomeBuyer/Scenario Hash search filter.");

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

	public ArrayList<TestSteps> VerifyTheHomeBuyerNamePlaceholderFromTheSynchroniseSubmissionsScreen() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			

			status = clickOnNavMenuSyncSubmissionsButton();;
			addSubStep(subSteps, "Click on Navigation Menu 'Sync Submissions' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
			status = ErrorCollector.verifyTrue(verifyNameSearchFilterPlaceholder(), "Verified <b>HomeBuyer Name</b> placeholder in HomeBuyer Name search filter.");
			addSubStep(subSteps, "Verified <b>HomeBuyer Name</b> placeholder in HomeBuyer Name search filter.",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

//			initConfiguration();
//			lp = new LoginPage();
//			dashboardPage = new DashboardPage();
//			
//			ErrorCollector.extentLogInfo("Step 1 : Visit web url");
//			openURL("AppURL");
//
//			ErrorCollector.extentLogInfo("Step 2 : Click on login button");
//			lp.clickOnLoginButton();
//
//			String email = PropertiesReader.getPropertyValue(env + "_EmailId");
//			ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
//			lp.enterEmail(email);
//
//			String pass = PropertiesReader.getPropertyValue(env + "_Password");
//			ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
//			lp.enterPassword(pass);
//
//			ErrorCollector.extentLogInfo("Step 5 : Click on Login button");
//			lp.clickOnLoginButton();
//			
//			ErrorCollector.extentLogInfo("Step 6 : Click on Navigation Menu 'Sync Submissions' button");
//			dashboardPage.clickOnNavMenuSyncSubmissionsButton();
//			
//			ErrorCollector.extentLogInfo("Step 7 : Verifying <b>HomeBuyer Name</b> placeholder in HomeBuyer Name search filter.");
//			ErrorCollector.assertTrue(dashboardPage.verifyNameSearchFilterPlaceholder(), "Verified <b>HomeBuyer Name</b> placeholder in HomeBuyer Name search filter.");

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

	public ArrayList<TestSteps> VerifyTheEmailPlaceholderFromTheSynchroniseSubmissionsScreen() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnNavMenuSyncSubmissionsButton();
			addSubStep(subSteps, "Click on Navigation Menu 'Sync Submissions' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);				

			status = ErrorCollector.verifyTrue(verifyHomeBuyerEmailSearchFilterPlaceholder(), "Verified <b>Email</b> placeholder in Email search filter.");
			addSubStep(subSteps, "Verified <b>Email</b> placeholder in Email search filter.",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

//			initConfiguration();
//			lp = new LoginPage();
//			dashboardPage = new DashboardPage();
//			
//			ErrorCollector.extentLogInfo("Step 1 : Visit web url");
//			openURL("AppURL");
//
//			ErrorCollector.extentLogInfo("Step 2 : Click on login button");
//			lp.clickOnLoginButton();
//
//			String email = PropertiesReader.getPropertyValue(env + "_EmailId");
//			ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
//			lp.enterEmail(email);
//
//			String pass = PropertiesReader.getPropertyValue(env + "_Password");
//			ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
//			lp.enterPassword(pass);
//
//			ErrorCollector.extentLogInfo("Step 5 : Click on Login button");
//			lp.clickOnLoginButton();
//			
//			ErrorCollector.extentLogInfo("Step 6 : Click on Navigation Menu 'Sync Submissions' button");
//			dashboardPage.clickOnNavMenuSyncSubmissionsButton();
//			
//			ErrorCollector.extentLogInfo("Step 7 : Verifying <b>Email</b> placeholder in Email search filter.");
//			ErrorCollector.assertTrue(dashboardPage.verifyHomeBuyerEmailSearchFilterPlaceholder(), "Verified <b>Email</b> placeholder in Email search filter.");

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

	public ArrayList<TestSteps> VerifyTheScenarioNamePlaceholderFromTheSynchroniseSubmissionsScreen() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnNavMenuSyncSubmissionsButton();
			addSubStep(subSteps, "Click on Navigation Menu 'Sync Submissions' button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);			

			status = ErrorCollector.verifyTrue(verifyScenarioNameSearchFilterPlaceholder(), "Verified <b>Scenario Name</b> placeholder in Scenario Name search filter.");
			addSubStep(subSteps, "Verified <b>Scenario Name</b> placeholder in Scenario Name search filter.",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			
//			initConfiguration();
//			lp = new LoginPage();
//			dashboardPage = new DashboardPage();
//			
//			ErrorCollector.extentLogInfo("Step 1 : Visit web url");
//			openURL("AppURL");
//
//			ErrorCollector.extentLogInfo("Step 2 : Click on login button");
//			lp.clickOnLoginButton();
//
//			String email = PropertiesReader.getPropertyValue(env + "_EmailId");
//			ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
//			lp.enterEmail(email);
//
//			String pass = PropertiesReader.getPropertyValue(env + "_Password");
//			ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
//			lp.enterPassword(pass);
//
//			ErrorCollector.extentLogInfo("Step 5 : Click on Login button");
//			lp.clickOnLoginButton();
//			
//			ErrorCollector.extentLogInfo("Step 6 : Click on Navigation Menu 'Sync Submissions' button");
//			dashboardPage.clickOnNavMenuSyncSubmissionsButton();
//			
//			ErrorCollector.extentLogInfo("Step 7 : Verifying <b>Scenario Name</b> placeholder in Scenario Name search filter.");
//			ErrorCollector.assertTrue(dashboardPage.verifyScenarioNameSearchFilterPlaceholder(), "Verified <b>Scenario Name</b> placeholder in Scenario Name search filter.");

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

	public ArrayList<TestSteps> VerifyTheScenarioHashPlaceholderFromTheSynchronisePersonalDataScreen() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnMenuSyncPersonalDataButton();
			addSubStep(subSteps, "click On Menu Scenarios Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);			

			status = ErrorCollector.verifyTrue(verifyScenarioNameSearchFilterPlaceholder(), "Verified <b>Scenario Name</b> placeholder in Scenario Name search filter.");
			addSubStep(subSteps, "Verified <b>Scenario Name</b> placeholder in Scenario Name search filter.",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

//			initConfiguration();
//			lp = new LoginPage();
//			dashboardPage = new DashboardPage();
//			
//			ErrorCollector.extentLogInfo("Step 1 : Visit web url");
//			openURL("AppURL");
//
//			ErrorCollector.extentLogInfo("Step 2 : Click on login button");
//			lp.clickOnLoginButton();
//
//			String email = PropertiesReader.getPropertyValue(env + "_EmailId");
//			ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
//			lp.enterEmail(email);
//
//			String pass = PropertiesReader.getPropertyValue(env + "_Password");
//			ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
//			lp.enterPassword(pass);
//
//			ErrorCollector.extentLogInfo("Step 5 : Click on Login button");
//			lp.clickOnLoginButton();
//			
//			ErrorCollector.extentLogInfo("Step 6 : Click on Navigation Menu 'Sync Personal Data' button");
//			dashboardPage.clickOnMenuSyncPersonalDataButton();
//			
//			ErrorCollector.extentLogInfo("Step 7 : Verifying <b>Scenario Hash</b> placeholder in scenario hash search filter.");
//			ErrorCollector.assertTrue(dashboardPage.verifyScenarioHashSearchFilterPlaceholder(), "Verified <b>Scenario Hash</b> placeholder in scenario hash search filter.");

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

	public ArrayList<TestSteps> VerifyTheHomeBuyerHashPlaceholderFromTheSynchronisePersonalDataScreen() {
		ArrayList<TestSteps> subSteps = new ArrayList<>();
		LoginPage loginPg = new LoginPage();
		Status status = null;
		try {
			subSteps.add(new TestSteps("Login to BCP Account", Status.PASS));
			openURL("AppURL");

			status = loginPg.loginToOSQOAccount(bcpEmail, bcpPass);
			addSubStep(subSteps, "Enter Email : " + bcpEmail + " And Password : " + bcpPass, status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = clickOnMenuSyncPersonalDataButton();
			addSubStep(subSteps, "click On Menu Scenarios Button", status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);			

			status = ErrorCollector.verifyTrue(verifyScenarioHashSearchFilterPlaceholder(), "Verified <b>Scenario Hash</b> placeholder in scenario hash search filter.");
			addSubStep(subSteps, "Verified <b>Scenario Hash</b> placeholder in scenario hash search filter.",status);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

//			initConfiguration();
//			lp = new LoginPage();
//			dashboardPage = new DashboardPage();
//			
//			ErrorCollector.extentLogInfo("Step 1 : Visit web url");
//			openURL("AppURL");
//
//			ErrorCollector.extentLogInfo("Step 2 : Click on login button");
//			lp.clickOnLoginButton();
//
//			String email = PropertiesReader.getPropertyValue(env + "_EmailId");
//			ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
//			lp.enterEmail(email);
//
//			String pass = PropertiesReader.getPropertyValue(env + "_Password");
//			ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
//			lp.enterPassword(pass);
//
//			ErrorCollector.extentLogInfo("Step 5 : Click on Login button");
//			lp.clickOnLoginButton();
//			
//			ErrorCollector.extentLogInfo("Step 6 : Click on Navigation Menu 'Sync Personal Data' button");
//			dashboardPage.clickOnMenuSyncPersonalDataButton();
//			
//			ErrorCollector.extentLogInfo("Step 7 : Verifying <b>Scenario Hash</b> placeholder in scenario hash search filter.");
//			ErrorCollector.assertTrue(dashboardPage.verifyScenarioHashSearchFilterPlaceholder(), "Verified <b>Scenario Hash</b> placeholder in scenario hash search filter.");

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

	public Status verifyNavMenuSyncSubmissionsButton() {
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\ApiConfig.properties"); 
        Properties prop = new Properties();
		String secPassword = PropertiesReader.getPropertyValue(env + "_AppPassword");		
		String token="";
		try {
			waitForElementClickable(navMenuSyncSubmissionsBtn, "10");
			driver.navigate().refresh();
			waitTime(6000);
			String scriptToExecute = "var performance = window.performance || {}; var network = performance.getEntries() || {}; return network;";
			String netData = ((JavascriptExecutor)driver).executeScript(scriptToExecute).toString();
			System.out.println(netData);

			List<LogEntry> entries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
			System.out.println(entries.size() + " " + LogType.PERFORMANCE + " log entries found");
			 for (LogEntry entry : entries) {
			  // System.out.println(entry.getMessage());
			   if(entry.getMessage().contains("\"authorization\":\"Bearer ")) {
				   waitTime(4000);
				   String message = entry.getMessage();
				   System.out.println("Token: "+message);
				   try {
				   token = message.substring(message.indexOf("Bearer ")+7,message.indexOf("\",\"if-none-match\"")).trim();					
				} catch (Exception e) {
					token = message.substring(message.indexOf("Bearer ")+7,message.indexOf("\",\"origin\":\"https")).trim();
				}
				   printString("Token: "+message);
			   }
			 }
			 
			 try (InputStream in = new FileInputStream(file))
		        {
		            if (in == null) {
		                throw new FileNotFoundException();
		            }
		            prop.load(in);
		            prop.setProperty("qa_tokenApi", token);
		 
		            OutputStream out = new FileOutputStream(file);
		            prop.store(out, "some comment");
		        }
		        catch (IOException e) {
		            e.printStackTrace();
		        }
			

			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}
	}
	
}
