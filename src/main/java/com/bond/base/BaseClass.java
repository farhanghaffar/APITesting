package com.bond.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.bond.errorCollectors.ErrorCollector;
import com.bond.listeners.ExtentListeners;
import com.bond.utilities.APIClient;
import com.bond.utilities.ExcelReader;
import com.bond.utilities.StepsWithHeader;
import com.bond.utilities.TestSteps;
import com.bond.utilities.Utilities;
import freemarker.core.ParseException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static String PROJECT_ID;
	public static Long TestPlan_id;
	public static Long suite_id;
	public static String TestRail_AssignToID;

	public static String testRailUserName;
	public static String testRailPassword;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static String browser;
	public static String env;
	public static FileInputStream fis;
//	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExtentTest extentReport;
	public static SoftAssert softAssert;
	// public static ExtentReports rep = ExtentManager.getInstance();
	// This is to set default wait for every method
	public static Integer waitInSeconds = 5;
	
	public static Properties testRailConfig = new Properties();

	// This is the default path to data package
	public static final String excelFilePath = System.getProperty("user.dir") + ""+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"data"+File.separator+"";
	
	public static String configFilesPath = System.getProperty("user.dir") + ""+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"config";

	// This is the default path to imageUpload
	public static final String imagePath = System.getProperty("user.dir") + ""+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"images"+File.separator+"";

	// This is excel file name
	public static final String potentialClientExcel = "potentialClientTestData";
	// This is column name from which we need to get row
	public static final String colName = "env";
	// This is row index of environment column from which we need to get data
	public static int rowIndex = 0;

	 private static String OS = null;
	   public static String getOsName()
	   {
	      if(OS == null) { OS = System.getProperty("os.name"); }
	      return OS;
	   }
	   public static boolean isWindows()
	   {
	      return getOsName().startsWith("Windows");
	   }
	public static void initTestRail() {
		FileInputStream fis1;
		try {
			fis1 = new FileInputStream(configFilesPath + File.separator + "TestRailConfig.properties");
			testRailConfig.load(fis1);
			PROJECT_ID = testRailConfig.getProperty("TestRail_ProjectId").trim();
			Utilities.suite_id = Long.valueOf(testRailConfig.getProperty("TestRail_SuiteID").trim());
			// String testPlanID= testRailConfig.getProperty("TestRail_TestPlanId").trim();
			String testRunId = testRailConfig.getProperty("TestRail_TestRunId").trim();
			// TestPlan_id=Long.parseLong(testPlanID);
			suite_id = Long.parseLong(testRunId);
			testRailUserName = testRailConfig.getProperty("TestRail_Username").trim();
			testRailPassword = testRailConfig.getProperty("TestRail_Password").trim();
//			TestRail_AssignToID = testRailConfig.getProperty("TestRail_AssignToID").trim();
//			System.out.println("TestRail_AssignToID: " + TestRail_AssignToID);

			Utilities.client = new APIClient("https://osqo.testrail.io");
			Utilities.client.setUser(testRailUserName);
			Utilities.client.setPassword(testRailPassword);
		} catch (Exception e) {
		}
		
	}
	
	public static void initConfiguration() {
		
		
		initTestRail();
		
		Map data = new HashMap();
		
		
		extentReport = ExtentListeners.testReport.get();
		softAssert = new SoftAssert();

		// if (driver == null) {
		if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {
			browser = System.getenv("browser");
			System.out.println("Browser: " + browser);
		} else {
			browser = PropertiesReader.getPropertyValue("browser");
		}
		if (System.getenv("env") != null && !System.getenv("env").isEmpty()) {
			env = System.getenv("env");
			System.out.println("Env: " + env);
		} else {
			env = PropertiesReader.getPropertyValue("env");
		}
		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "gecko.exe");
			driver = new FirefoxDriver();
//			log.debug("Firefox Driver initialized");
		} else if (browser.equals("chrome")) {
			if(isWindows()) {
				WebDriverManager.chromedriver().setup();
//				System.setProperty("webdriver.chrome.driver",
//						System.getProperty("user.dir") + ""+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"executables"+File.separator+"chromedriver.exe");
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");
				//options.addArguments("--headless");
				options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
				LoggingPreferences logPrefs = new LoggingPreferences();
				logPrefs.enable( LogType.PERFORMANCE, Level.ALL );
				options.setCapability( "goog:loggingPrefs", logPrefs );
				driver = new ChromeDriver(options);
//				log.debug("Chrome driver intialized");
			}else {
				WebDriverManager.chromedriver().setup();
				try {
					URL url = new URL("http://127.0.0.1:4444/wd/hub");
					Map<String, Object> prefs = new HashMap<String, Object>();
					prefs.put("profile.default_content_setting_values.notifications", 2);
					prefs.put("credentials_enable_service", false);
					prefs.put("profile.password_manager_enabled", false);
					ChromeOptions options = new ChromeOptions();
					options.setExperimentalOption("prefs", prefs);
					options.addArguments("--disable-extensions");
					options.addArguments("--disable-infobars");
					options.addArguments("--headless");
					options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
					LoggingPreferences logPrefs = new LoggingPreferences();
					logPrefs.enable( LogType.PERFORMANCE, Level.ALL );
					options.setCapability( "goog:loggingPrefs", logPrefs );
					driver = new RemoteWebDriver(options);//new ChromeDriver(options);
//					log.debug("Chrome driver intialized");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
//				System.setProperty("webdriver.chrome.driver",
//						System.getProperty("user.dir") + ""+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"executables"+File.separator+"chromedriver.exe");
				
			}
			
		} else if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + ""+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"executables"+File.separator+"IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	}

	public static void openURL(String key) {
		String testRail_URL = PropertiesReader.getPropertyValue(env + "_" +"TestRailTestCaseURL");
		driver.get(PropertiesReader.getPropertyValue(env + "_" + key));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertiesReader.getPropertyValue("implicit.wait")),
				TimeUnit.SECONDS);

	}
	
	public static void openURLInSameTab(String val) {
		driver.get(val);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertiesReader.getPropertyValue("implicit.wait")),
				TimeUnit.SECONDS);

	}
	
	public static String getProPertyVal(String key) {
		String testRail_URL = PropertiesReader.getPropertyValue(env + "_" + key);
		
		return testRail_URL;
	}

	public static void navigateToURL(String value) {
		//driver.get(value);
		driver.get(PropertiesReader.getPropertyValue(env + "_" + value));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertiesReader.getPropertyValue("implicit.wait")),
				TimeUnit.SECONDS);
	}

	public static void openUrlInNewTab(String value) {
		
		JavascriptExecutor esp = (JavascriptExecutor) driver;
		esp.executeScript("window.open()");
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		navigateToURL(value);
	}
	
public static void openUrlNewTab(String value) {
		
		JavascriptExecutor esp = (JavascriptExecutor) driver;
		esp.executeScript("window.open()");
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		driver.get(value);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertiesReader.getPropertyValue("implicit.wait")),
				TimeUnit.SECONDS);
	}
	
	public static void openUrlInNewTabWithTabNumber(String value,int tabNum) {
		JavascriptExecutor esp = (JavascriptExecutor) driver;
		esp.executeScript("window.open()");
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(tabNum));
		driver.get(value);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertiesReader.getPropertyValue("implicit.wait")),
				TimeUnit.SECONDS);
	}

	public static void shiftWindowHandle(int val) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(val));
	}

	public static String loginDetails(String key) {
//		env = PropertiesReader.getPropertyValue("env");
		return PropertiesReader.getPropertyValue(env + "_" + key);
	}

	public static void click(WebElement element) {
		waitForElementVisibility(element, "30");
		waitForElementClickable(element, "20");
		element.click();
	}

	public void scrollIntoViewSmoothly(WebElement Element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'})",
				Element);
	}

	public static void click(WebElement element, String timeInSeconds) {
		waitForElementVisibility(element, timeInSeconds);
		waitForElementClickable(element, timeInSeconds);
		element.click();
	}

	public static void waitForElementVisibility(WebElement element, String timeoutInSeconds) {

		WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(timeoutInSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void waitForElementClickable(WebElement element, String timeoutInSeconds) {
		WebDriverWait waitClickable = new WebDriverWait(driver, Long.parseLong(timeoutInSeconds));
		waitClickable.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitUntilSearchLoadingShowing() {
		try {
			WebElement element = driver.findElement(By.xpath("//*[@class='css-1bg64dd']"));
			waitUntilElementDisplayed(element, driver);
		} catch (Exception e) {
		}
	}

	public static void waitUntilElementDisplayed(final WebElement webElement, WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		ExpectedCondition elementIsDisplayed = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver arg0) {
				try {
					webElement.isDisplayed();
					return true;
				} catch (NoSuchElementException e) {
					return false;
				} catch (StaleElementReferenceException f) {
					return false;
				}
			}
		};
		wait.until(elementIsDisplayed);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void type(WebElement element, String value) {
		waitForElementVisibility(element, "20");
		waitForElementClickable(element, "10");
		element.clear();
		System.out.println("Entered :" + value);
		element.sendKeys(value);
	}

	public static void type_old(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void selectValueFromDropdown(List<WebElement> dropdownValues, String value) {
		for (WebElement ele : dropdownValues) {
			System.out.println("Actual :" + ele.getText() + ":");
			System.out.println("Excepted :" + value + ":");
			if (ele.getText().trim().equals(value)) {
				click(ele);
				break;
			}
		}
	}

	public void multipleSelectFromDropDown(WebElement searchBox, List<WebElement> elementList, String... inputValues) {

		for (String inputValue : inputValues) {
			type(searchBox, inputValue);
			for (WebElement value : elementList) {
				if (value.getText().equals(inputValue)) {
					click(value);
					break;
				}
			}
		}
	}

	public void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,-250)");
	}

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,2500)");
	}

	public void scrollIntoView(WebElement Element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView();", Element);
	}

	public void clickUsingJavascriptExecutor(WebElement button) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);
	}

	public void mouseHoverAndClick(WebElement button) {
		Actions actions = new Actions(driver);
		actions.moveToElement(button);
		actions.click().build().perform();
	}

	public void mouseHover(WebElement button) {
		Actions actions = new Actions(driver);
		actions.moveToElement(button);
	}

	public static boolean isElementDisplayed(WebElement element) {
		try {
			waitForElementVisibility(element, "5");
			if (element.isDisplayed()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean isElementSelected(WebElement status) {
		if (status.isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isElementEnabled(WebElement status) {
		if (status.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	public Object[][] getData(String filename, String SheetName) {

		ExcelReader excel = new ExcelReader(
				System.getProperty("user.dir") + ""+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"data"+File.separator+"" + filename + ".xlsx");
		int rows = excel.getRowCount(SheetName);
		int columns = excel.getColumnCount(SheetName);

		Object[][] data = new Object[rows - 1][columns];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < columns; colNum++) {

				data[rowNum - 2][colNum] = excel.getCellData(SheetName, colNum, rowNum);
			}
		}
		return data;
	}

	public static void waitTime(int time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void quitBrowser() {
//		ErrorCollector.extentLogInfo("Quitting browser");
		// driver.quit();
	}

	public static void closeBrowser() {
		ErrorCollector.extentLogInfo("Closing browser");
		driver.close();
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static String getTitle() {
		return driver.getTitle();
	}

	public static String getUniqueData(String value) {
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyyHmm");
		Date date = new Date();
		String unique = formatter.format(date).toString();
		String uniqueValue = value + unique;
//		formatter.formatToCharacterIterator(uniqueValue);
		return uniqueValue;
	}

	public static String getUniqueEmailId(String value) {

		SimpleDateFormat formatter = new SimpleDateFormat("MMddyyHmm");
		Date date = new Date();
		String unique = formatter.format(date).toString();
		String uniqueEmailId = value + unique + "@test.com";
		return uniqueEmailId;
	}

	public static String getElementText(WebElement element) {
		waitForElementVisibility(element, "10");
		return element.getText().trim();
	}
	
	public String getElementTextThroughAttribute(WebElement element) {
		scrollIntoViewSmoothly(element);
		waitForElementVisibility(element, "10");
		return element.getAttribute("value").trim();
	}
	
	

	public static String getSystemDateInMMDDYYYYFormat() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Dater : " + dtf.format(now));
		return dtf.format(now);

	}

	public static void teardown() {
		closeBrowser();
	}

	public static void getRefreshWebPage() {
		waitTime(5000);
		driver.navigate().refresh();
		waitTime(5000);
	}

	// Scroll Into Specific view
	public void scrollIntoSpecificView(WebElement Element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("scroll(0,1000)");
	}

	// Scroll Into Specific view
	public void scrollIntoSpecificViewInvoicesAction(WebElement Element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("scroll(0,1600)");
	}

	@AfterTest
	public void tearDown() {

		BaseClass.quitBrowser();
	}

	public static void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor) driver).executeScript("window.scrollTo( 0, -150)");
		boolean isDisplay = isElementDisplayed(element);
		if (!isDisplay) {
			((JavascriptExecutor) driver).executeScript("window.scrollTo( 0, -100)");
		}
	}

	public void click(WebElement element, int timeInSecond, String message) {
		waitTime(5000);
		waitForElementVisibility(element, Integer.toString(timeInSecond));
		waitForElementClickable(element, Integer.toString(timeInSecond));
		scrollToElement(element);
		try {
			element.click();
		} catch (Exception e) {
			printString("Failed to Click through click method : " + e.toString());
			printString("Trying to Click through javascript");
			scrollIntoView(element);
			clickUsingJavascriptExecutor(element);
		}
		printString("Clicked " + message);
		ErrorCollector.extentLogInfo("Clicked " + message);
	}

	public static void printString(String message) {
		try {
			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getElementAttributeValue(WebElement element, String attribute) {
		waitTime(waitInSeconds);
		waitForElementVisibility(element, Integer.toString(waitInSeconds));
		scrollToElement(element);
		return element.getAttribute(attribute);
	}

	public void clear(WebElement element, int timeInSecond, String message) {

		waitForElementVisibility(element, Integer.toString(timeInSecond));
		scrollToElement(element);
		element.clear();
		printString("Clearing  " + message);
		ErrorCollector.extentLogInfo("Clearing  " + message);

	}

	public static void scrollToAddPaymentsElement(WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			((JavascriptExecutor) driver).executeScript("scrollBy(0, -350)");
		} catch (Exception e) {
			e.printStackTrace();
			boolean isDisplay = isElementDisplayed(element);
			if (!isDisplay) {
				// ((JavascriptExecutor) driver).executeScript("window.scrollTo( 0, 50)");
			}
		}
	}

	public int getCellRowNum(String fileName, String sheetName, String cellValue) {
		ExcelReader excelReader = new ExcelReader(excelFilePath + fileName + ".xlsx");

		for (int i = 2; i <= excelReader.getRowCount(sheetName); i++) {
			if (excelReader.getCellData(sheetName, colName, i).equalsIgnoreCase(cellValue)) {
				return i;
			}
		}
		return -1;
	}

	public Object[][] loadExcel(String fileName, String sheetName, String env) {
		int dataIndex = getCellRowNum(fileName, sheetName, env);
		printString("dataIndex : " + dataIndex);
		ErrorCollector.verifyTrue(dataIndex > -1,
				"Verified Excel sheet '" + sheetName + "' has data for '" + env + "' environment");
		rowIndex = dataIndex - 2;
		return getData(fileName, sheetName);
	}

	public static String generateRandomNumberWithGivenNumberOfDigits(int number) {
		String randomNumber = "123456789";
		StringBuilder sb = new StringBuilder(number);
		for (int i = 0; i < number; i++) {
			int index = (int) (randomNumber.length() * Math.random());
			sb.append(randomNumber.charAt(index));
		}
		return sb.toString();
	}

	public void click(WebElement element, int timeInSecond) {
		waitTime(5000);
		waitForElementVisibility(element, Integer.toString(timeInSecond));
		waitForElementClickable(element, Integer.toString(timeInSecond));
		scrollToElement(element);
		try {
			element.click();
		} catch (Exception e) {
			printString("Failed to Click through click method : " + e.toString());
			printString("Trying to Click through javascript");
			clickUsingJavascriptExecutor(element);
		}
	}

	public void type(WebElement element, int timeInSecond, String value) {
		waitForElementVisibility(element, Integer.toString(timeInSecond));
		waitForElementClickable(element, Integer.toString(timeInSecond));
		scrollToElement(element);
		element.clear();
		element.sendKeys(value);

	}

	public String getDate(int Day, String formateStr) {
		SimpleDateFormat format = new SimpleDateFormat(formateStr);
		final Date date = new Date();
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, Day);
		return format.format(calendar.getTime());
	}

	public void clear(WebElement element, int timeInSecond) {

		waitForElementVisibility(element, Integer.toString(timeInSecond));
		scrollToElement(element);
		element.clear();
	}

	public String getInputText(WebElement element) {
		waitTime(waitInSeconds);
		waitForElementVisibility(element, Integer.toString(waitInSeconds));
		scrollToElement(element);
		return element.getAttribute("value");
	}

	public void clearThroughRobot(WebElement element, String message) {
		click(element, waitInSeconds);
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyPress(KeyEvent.VK_DELETE);
		} catch (AWTException e) {
			ErrorCollector.addVerificationFailure(e);
		}

	}

	public void typeKeys(WebElement element, Keys Key) {
		waitForElementVisibility(element, Integer.toString(waitInSeconds));
		waitForElementClickable(element, Integer.toString(waitInSeconds));
		scrollToElement(element);
		element.clear();
		element.sendKeys(Key);
	}

//	public void addTestStepsIntoReport(ArrayList<String> steps) {
//		for(String step: steps) {
//			int i=0;
//			i++;
//			ErrorCollector.extentLogInfo("Step "+i+" : "+step);	
//		}
//	}

	public void addTestStepsIntoReport(Status testStatus, ArrayList<StepsWithHeader> steps, String testName) {
		ExtentTest test = ExtentListeners.extent.createTest(testName);

		for (StepsWithHeader step : steps) {
			printString("" + step.getHeader());
			if (step.getSteps() == null) {
				if (step.getHeader().contains("ScreenShot")) {
					try {
						test.log(Status.INFO, "<b>" + "<font color=" + "black>" + "Screenshot" + "</font>" + "</b>",
								MediaEntityBuilder.createScreenCaptureFromPath(step.getHeader()).build());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (step.getHeader().contains("Error") || step.getHeader().contains("Exception")) {
					test.log(Status.FAIL, step.getHeader());
				} else {
					test.log(Status.INFO, step.getHeader());
				}
			} else {
				ArrayList<TestSteps> subSteps = step.getSteps();
				boolean isFail = false;
				for (TestSteps stepsWithHeader : subSteps) {
					printString("stepsWithHeader.getStatus().toString() : " + stepsWithHeader.getStatus().toString());
					if (stepsWithHeader.getStatus().toString().toLowerCase().equals("Error")
							|| stepsWithHeader.getStatus().toString().toLowerCase().equals("fail")) {
						isFail = true;
					}
				}
				if (isFail) {
					test.log(Status.FAIL, "<b style=\"color:red;\">" + step.getHeader() + "</b>"); // Expandable view
																									// title

				} else {
					test.log(Status.PASS, "<b style=\"color:green;\">" + step.getHeader() + "</b>"); // Expandable view
																										// title

				}
				// Add expandable view here
				for (TestSteps subStep : subSteps) {
					test.log(subStep.getStatus(), subStep.getStep());

					printString("" + subStep.getStep());
//					if(subStep.getStep()==null) {
					if (subStep.getStep().contains("ScreenShot")) {
						try {
							test.log(Status.INFO, "<b>" + "<font color=" + "black>" + "Screenshot" + "</font>" + "</b>",
									MediaEntityBuilder.createScreenCaptureFromPath(step.getHeader()).build());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		if (testStatus.equals(Status.PASS)) {
			test.pass(testName);

		} else {
			test.fail(testName);
		}
	}
	
	public static void AddTest_IntoReport(String TestName, String TestDescription, String TestCatagory,
			ArrayList<String> test_steps) {

		ExtentTest test = ExtentListeners.extent.createTest(TestName,TestDescription);
		for (int i = 0; i < test_steps.size(); i++) {

			if (test_steps.get(i).contains("Failed") || test_steps.get(i).contains("Assertion")) {
				test.log(Status.FAIL, test_steps.get(i));
			} else {

				test.log(Status.PASS, test_steps.get(i));
			}
		}
		test_steps.clear();

	}


	public void addTestStepsIntoReport(Status testStatus, HashMap<String, ArrayList<TestSteps>> map, String testName, String Description) {
		
		ExtentTest test = ExtentListeners.extent.createTest(testName,Description);

		for (Entry<String, ArrayList<TestSteps>> step : map.entrySet()) {
			ArrayList<TestSteps> subSteps = map.get(step.getKey());
			boolean isFail = false;
			if (subSteps != null) {

				for (TestSteps childStep : subSteps) {
					printString("stepsWithHeader.getStatus().toString() : " + childStep.getStatus().toString());
					if (childStep.getStatus().toString().toLowerCase().equals("error")
							|| childStep.getStatus().toString().toLowerCase().equals("fail")) {
						isFail = true;
					}
				}

				if (isFail) {

					test.log(Status.FAIL, "<b style=\"color:red;\">" + step.getKey() + "</b>"); // Expandable view title

				} else {
					test.log(Status.PASS, "<b style=\"color:green;\">" + step.getKey() + "</b>"); // Expandable view
																									// title

				}

				for (TestSteps childStep : subSteps) {
					if (childStep.getStatus().toString().toLowerCase().equals("error")
							|| childStep.getStatus().toString().toLowerCase().equals("fail")) {
						if (childStep.getStep().contains("ScreenShot")) {
							try {
								test.log(Status.FAIL,
										"<b>" + "<font color=" + "black>" + "Screenshot" + "</font>" + "</b>",
										MediaEntityBuilder.createScreenCaptureFromPath(childStep.getStep()).build());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							test.log(Status.FAIL, childStep.getStep());

						}
					} else if (childStep.getStatus().toString().toLowerCase().equals("pass")) {
						if (childStep.getStep().contains("ScreenShot")) {
							try {
								test.log(Status.PASS,
										"<b>" + "<font color=" + "black>" + "Screenshot" + "</font>" + "</b>",
										MediaEntityBuilder.createScreenCaptureFromPath(childStep.getStep()).build());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						} else {
							test.log(Status.PASS, childStep.getStep());
						}

					} else {
						if (childStep.getStep().contains("ScreenShot")) {
							try {
								test.log(Status.INFO,
										"<b>" + "<font color=" + "black>" + "Screenshot" + "</font>" + "</b>",
										MediaEntityBuilder.createScreenCaptureFromPath(childStep.getStep()).build());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						} else {
							test.log(Status.INFO, childStep.getStep());
						}
					}

				}
			} else {
				test.log(Status.PASS, "<b style=\"color:green;\">" + step.getKey() + "</b>"); // Expandable view titles
			}
		}

	}

	public static String captureSS() {
		Date d = new Date();
		String screenshotNam = "";
		File scrFile = null;
		try {
			
			scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			screenshotNam = "ScreenShot_" + d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/reports/" + screenshotNam));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return screenshotNam;
	}

	public boolean identifyTestStatus(ArrayList<StepsWithHeader> testStep) {
		for (StepsWithHeader step : testStep) {
			if (step.getSteps() != null) {
				for (TestSteps subStep : step.getSteps()) {
					if (subStep.getStatus().equals(Status.FAIL)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public boolean IdentifyTestStatus(HashMap<String, ArrayList<TestSteps>> map) {
		for (Entry<String, ArrayList<TestSteps>> step : map.entrySet()) {
			ArrayList<TestSteps> subSteps = map.get(step.getKey());
			for (TestSteps subStep : subSteps) {
				if (subStep.getStatus().equals(Status.FAIL)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void addSubStep(ArrayList<TestSteps> subSteps, String step, Status isPass) {
		subSteps.add(new TestSteps(step, isPass));

	}
	
	public String randomNumberString(int len) {
		String AB = "123456789";
		SecureRandom rnd = new SecureRandom();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}
	
	public static String reformatDate(String DateToFormat, String preFormat, String postFormat) throws ParseException, java.text.ParseException {
		DateFormat srcDf = new SimpleDateFormat(preFormat);

		// parse the date string into Date object
		Date date = srcDf.parse(DateToFormat);

		DateFormat destDf = new SimpleDateFormat(postFormat);

		// format the date into another format
		DateToFormat = destDf.format(date);

		return DateToFormat;
	}
	
	public static void switchToIfram(WebElement iframXpath) {
		driver.switchTo().frame(iframXpath);
	}
	

	
}
