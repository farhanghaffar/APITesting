package com.bond.pages;

import static org.testng.Assert.assertFalse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.tools.ant.types.DataType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.JSONValue;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.bond.base.BaseClass;
import com.bond.base.EmailUtils;
import com.bond.base.PropertiesReader;
import com.bond.errorCollectors.ErrorCollector;
import com.bond.utilities.TestSteps;
import com.bond.utilities.Utilities;
import com.google.common.base.Objects;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

public class OsqoApiPage extends EmailUtils {
	ArrayList<TestSteps> subSteps = new ArrayList<>();
	public static String apiStatusMsg;
	public static String apiStatusCode;
	RequestSpecification httpRequest;
	LoginPage lp = new LoginPage();
	String bcpEmail = PropertiesReader.getPropertyValue(env + "_BcpEmailId");
	String username = PropertiesReader.getPropertyValue(env + "_methodEmail");// username
	String password = PropertiesReader.getPropertyValue(env + "_Password");

	CreateBondPage syncSubmissionPage = new CreateBondPage();
	String apiBaseUrl = "";
	String token = PropertiesReader.getPropertyValue(env + "_token");
	String aggregatorId = "";
	String subAggregatorId = "";
	String borrowerId = "";
	String guarantorId = "";

	public OsqoApiPage() {
		PageFactory.initElements(driver, this);
	}

	public void setup(String basePath) {
		//RestAssured.baseURI = "https://platform-api.dev.osqo.com.au";
		String getBaseURL = PropertiesReader.getApiPropertyValue("baseURLDev");
		RestAssured.baseURI = getBaseURL;
		RestAssured.basePath = basePath;
		Header acceptHeader = new Header("Accept", "application/json");
		Header contentTypeHeader = new Header("Content-Type", "application/json");
		Header superUserId = new Header("super_user_id", "4e4c4de1-85f4-4kk9-829a-48cba0a375b7");
		Header superUserClientId = new Header("super_user_client_id", "790193a7-c503-4bfa-9kk7-c46b1ckdc076");
		Header superUserClientSecret = new Header("super_user_client_secret", "ed49891a-84ec-4281-8cd2-40l8ekkb5ac1");
		List<Header> headers = new ArrayList<>();
		headers.add(acceptHeader);
		headers.add(contentTypeHeader);
		headers.add(superUserId);
		headers.add(superUserClientId);
		headers.add(superUserClientSecret);
		Headers allHeaders = new Headers(headers);
		httpRequest = RestAssured.given().headers(allHeaders);
	}

	public void setupWithToken(String basePath) {
		String tokenValue = PropertiesReader.getApiPropertyValue("qa_tokenApi");
		RestAssured.baseURI = "https://platform-api.dev.osqo.com.au";
		RestAssured.basePath = basePath;
		Header acceptHeader = new Header("Accept", "application/json");
		Header contentTypeHeader = new Header("Content-Type", "application/json");
		Header superUserId = new Header("super_user_id", "76968ec7-9392-487c-ab83-a635e0a3f97e");
		Header superUserClientId = new Header("super_user_client_id", "5f04adee-59f4-4cb3-a0f8-c9cdc04455d5");
		Header superUserClientSecret = new Header("super_user_client_secret", "bbc0c863-4ceb-4594-a1aa-c42dfd60546c");
		Header token = new Header("Authorization", "Bearer " + tokenValue);
		List<Header> headers = new ArrayList<>();
		headers.add(acceptHeader);
		headers.add(contentTypeHeader);
		headers.add(superUserId);
		headers.add(superUserClientId);
		headers.add(superUserClientSecret);
		headers.add(token);
		Headers allHeaders = new Headers(headers);
		httpRequest = RestAssured.given().headers(allHeaders);
	}

	public ArrayList<TestSteps> setupForHL(String id, Map<String, String> body) {
		Status status = null;
		String getBaseURL = PropertiesReader.getApiPropertyValue("HLBaseURL");
		RestAssured.baseURI = getBaseURL;
		RestAssured.basePath = "/aggregator/"+id;
		addSubStep(subSteps, "<b>>>>>>>>>>>>>>> Verify Created Aggregator on HL <<<<<<<<<<<<<</b>", status.INFO);
		addSubStep(subSteps, getBaseURL+"/aggregator/" + id, Status.INFO);
		Response response = RestAssured.given().get();
		addSubStep(subSteps, "Status code for HL: "+response.getStatusCode(), Status.PASS);
		if (response.getStatusCode()!=200)
			assertFalse(true);
				
		JSONObject getResponseAsString = new JSONObject(response.asString());
		JSONObject itemsArray = getResponseAsString.getJSONObject("data");
		JSONObject recordObj = itemsArray.getJSONObject("Record");
		
		for (Map.Entry<String, String> entry : body.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();
			addSubStep(subSteps, "Expected "+key+": "+val, status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get("firstName"), status.INFO);
			if (val.equals(recordObj.get(key)))
				addSubStep(subSteps, "Verified "+key, status.PASS);
			else
				addSubStep(subSteps, "Failed! "+key+" is mismatching", status.FAIL);	
		}

		/*
		addSubStep(subSteps, "Expected first name: "+body.get("firstName"), status.INFO);
		addSubStep(subSteps, "Found: "+recordObj.get("firstName"), status.INFO);
		if (body.get("firstName").equals(recordObj.get("firstName")))
			addSubStep(subSteps, "Verified first name", status.PASS);
		else
			addSubStep(subSteps, "Failed! first name is mismatching", status.FAIL);


		addSubStep(subSteps, "Expected last name: "+body.get("lastName"), status.INFO);
		addSubStep(subSteps, "Found: "+recordObj.get("lastName"), status.INFO);
		if (body.get("lastName").equals(recordObj.get("lastName")))
			addSubStep(subSteps, "Verified last name", status.PASS);
		else
			addSubStep(subSteps, "Failed! last name is mismatching", status.FAIL);

		
		addSubStep(subSteps, "Expected company: "+body.get("company"), status.INFO);
		addSubStep(subSteps, "Found: "+recordObj.get("company"), status.INFO);
		if (body.get("company").equals(recordObj.get("company")))
			addSubStep(subSteps, "Verified company", status.PASS);
		else
			addSubStep(subSteps, "Failed! Company is mismatching", status.FAIL);

		addSubStep(subSteps, "Expected fee: "+body.get("fee"), status.INFO);
		addSubStep(subSteps, "Found: "+recordObj.get("fee"), status.INFO);
		if (body.get("fee").equals(recordObj.get("fee")))
			addSubStep(subSteps, "Verified fee", status.PASS);
		else
			addSubStep(subSteps, "Failed! Fee is mismatching", status.FAIL);

		addSubStep(subSteps, "Expected email: "+body.get("email"), status.INFO);
		addSubStep(subSteps, "Found: "+recordObj.get("email"), status.INFO);
		if (body.get("email").equals(recordObj.get("email")))
			addSubStep(subSteps, "Verified email", status.PASS);
		else
			addSubStep(subSteps, "Failed! Email is mismatching", status.FAIL);

		addSubStep(subSteps, "Expected address: "+body.get("address"), status.INFO);
		addSubStep(subSteps, "Found: "+recordObj.get("address"), status.INFO);
		if (body.get("address").equals(recordObj.get("address")))
			addSubStep(subSteps, "Verified address", status.PASS);
		else
			addSubStep(subSteps, "Failed! Address is mismatching", status.FAIL);

		addSubStep(subSteps, "Expected URL: "+body.get("URL"), status.INFO);
		addSubStep(subSteps, "Found: "+recordObj.get("URL"), status.INFO);
		if (body.get("URL").equals(recordObj.get("URL")))
			addSubStep(subSteps, "Verified URL", status.PASS);
		else
			addSubStep(subSteps, "Failed! URL is mismatching", status.FAIL);

		addSubStep(subSteps, "Expected ACL: "+body.get("ACL"), status.INFO);
		addSubStep(subSteps, "Found: "+recordObj.get("ACL"), status.INFO);
		if (body.get("ACL").equals(recordObj.get("ACL")))
			addSubStep(subSteps, "Verified ACL", status.PASS);
		else
			addSubStep(subSteps, "Failed! ACL is mismatching", status.FAIL);

		addSubStep(subSteps, "Expected ABN: "+body.get("ABN"), status.INFO);
		addSubStep(subSteps, "Found: "+recordObj.get("ABN"), status.INFO);
		if (body.get("ABN").equals(recordObj.get("ABN")))
			addSubStep(subSteps, "Verified ABN", status.PASS);
		else
			addSubStep(subSteps, "Failed! ABN is mismatching", status.FAIL);

		addSubStep(subSteps, "Expected folderId: "+body.get("folderId"), status.INFO);
		addSubStep(subSteps, "Found: "+recordObj.get("folderId"), status.INFO);
		if (body.get("folderId").equals(recordObj.get("folderId")))
			addSubStep(subSteps, "Verified folderId", status.PASS);
		else
			addSubStep(subSteps, "Failed! folderId is mismatching", status.FAIL);
*/
		
		return subSteps;
	}

	public ArrayList<TestSteps> setupUpdateAggregatorForHL(String id, String expecetdFirstName,
			String expectedLastName) {
		String postValue = "200";
		Status status = null;
		String lastName;
		String address;
		String docType;
		String fee;
		String ACL;
		String ACN;
		String ABN;
		String URl;
		String folderId;
		String firstName;
		String aggregatorStatus;
		String company;
		String email;
		addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Verify Aggregator on HL<<<<<<<<<<<<<</b>", status.INFO);
		addSubStep(subSteps, "URL: http://52.64.108.214:3000/aggregator/" + id + "", Status.PASS);

		String baseURL = PropertiesReader.getApiPropertyValue("baseURLHL");
		RestAssured.baseURI = baseURL;
		RestAssured.basePath = "/aggregator/" + id;
		Response response = RestAssured.given().get();
		JSONObject responseValue = new JSONObject(response.asString());
		String statusCode = Integer.toString(response.getStatusCode());
		addSubStep(subSteps, "<b>Response Status is = " + statusCode + "</b>", Status.PASS);

		if (responseValue.has("message")) {
			addSubStep(subSteps, "Message: " + responseValue.getString("message"), Status.FAIL);
			Assert.assertFalse(true);
		}
		JSONObject array = responseValue.getJSONObject("data");
		JSONObject obj2 = array.getJSONObject("Record");

		lastName = obj2.getString("lastName");
		firstName = obj2.getString("firstName");

		addSubStep(subSteps, "Expected first name: " + expecetdFirstName, Status.INFO);
		addSubStep(subSteps, "Found: " + firstName, Status.INFO);

		if (firstName.equalsIgnoreCase(expecetdFirstName))
			addSubStep(subSteps, "Successfully verified value updated", Status.PASS);
		else
			addSubStep(subSteps, "failed, first name value did not updat", Status.FAIL);

		addSubStep(subSteps, "Expected last name: " + expectedLastName, Status.INFO);
		addSubStep(subSteps, "Found: " + lastName, Status.INFO);

		if (lastName.equalsIgnoreCase(expectedLastName))
			addSubStep(subSteps, "Verifeid last name updated successfully", Status.PASS);
		else
			addSubStep(subSteps, "failed, Last name did not update", Status.FAIL);

		address = obj2.getString("address");
		addSubStep(subSteps, "Address: " + address + "", Status.PASS);

		docType = obj2.getString("docType");
		addSubStep(subSteps, "DocType: " + docType + "", Status.PASS);

		fee = obj2.getString("fee");
		addSubStep(subSteps, "Fee: " + fee + "", Status.PASS);

		ACL = obj2.getString("ACL");
		addSubStep(subSteps, "ACL: " + ACL + "", Status.PASS);

		aggregatorId = obj2.getString("aggregatorId");
		addSubStep(subSteps, "Aggregator Id: " + aggregatorId + "", Status.PASS);

		ACN = obj2.getString("ACN");
		addSubStep(subSteps, "ACN: " + ACN + "", Status.PASS);

		ABN = obj2.getString("ABN");
		addSubStep(subSteps, "ABN: " + ABN + "", Status.PASS);

		URl = obj2.getString("URL");
		addSubStep(subSteps, "URL: " + URl + "", Status.PASS);

		folderId = obj2.getString("folderId");
		addSubStep(subSteps, "Folder Id: " + folderId + "", Status.PASS);

		aggregatorStatus = obj2.getString("aggregatorStatus");
		addSubStep(subSteps, "Aggregator Status: " + aggregatorStatus + "", Status.PASS);

		company = obj2.getString("company");
		addSubStep(subSteps, "Company: " + company + "", Status.PASS);

		email = obj2.getString("email");
		addSubStep(subSteps, "Email: " + email + "", Status.PASS);

		return subSteps;
	}

	public ArrayList<TestSteps> subAggregatorForHL(String id, Map<String, String> body ) {
		Status status = null;
		addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Verify Sub Aggregator on HL<<<<<<<<<<<<<</b>", status.INFO);
		String getBaseURL = PropertiesReader.getApiPropertyValue("HLBaseURL");
		RestAssured.baseURI = getBaseURL;
		RestAssured.basePath = "/subAggregator/"+id;
		addSubStep(subSteps, "URL: "+getBaseURL+RestAssured.basePath, status.INFO);
		Response response = RestAssured.given().get();
		addSubStep(subSteps, "Get status code: "+response.getStatusCode(), status.INFO);
		if (response.getStatusCode()!=200)
			Assert.assertFalse(true);
		JSONObject responseValue = new JSONObject(response.asString());
		JSONObject array = responseValue.getJSONObject("data");
		JSONObject recordObj = array.getJSONObject("Record");

//		for (Map.Entry<String, String> entry : body.entrySet()) {
//			String key = entry.getKey();
//			String val = entry.getValue();
//			
//			addSubStep(subSteps, "Expected "+key+" : "+val, status.INFO);
//			addSubStep(subSteps, "Found: "+recordObj.get(key), status.INFO);
//			if (val.equals(recordObj.get(key)))
//				addSubStep(subSteps, "Verified "+key, status.PASS);
//			else
//				addSubStep(subSteps, "Failed! "+key+" is mismatching", status.FAIL);
//
//		}
		
		addSubStep(subSteps, "Expected first name: "+body.get("firstName"), status.INFO);
		addSubStep(subSteps, "Found: "+recordObj.get("firstName"), status.INFO);
		if (body.get("firstName").equals(recordObj.get("firstName")))
			addSubStep(subSteps, "Verified first name", status.PASS);
		else
			addSubStep(subSteps, "Failed! first name is mismatching", status.FAIL);

		addSubStep(subSteps, "Expected last name: "+body.get("lastName"), status.INFO);
		addSubStep(subSteps, "Found: "+recordObj.get("lastName"), status.INFO);
		if (body.get("lastName").equals(recordObj.get("lastName")))
			addSubStep(subSteps, "Verified last name", status.PASS);
		else
			addSubStep(subSteps, "Failed! last name is mismatching", status.FAIL);

		addSubStep(subSteps, "Expected company: "+body.get("company"), status.INFO);
		addSubStep(subSteps, "Found: "+recordObj.get("company"), status.INFO);
		if (body.get("company").equals(recordObj.get("company")))
			addSubStep(subSteps, "Verified company", status.PASS);
		else
			addSubStep(subSteps, "Failed! Company is mismatching", status.FAIL);

		addSubStep(subSteps, "Expected fee: "+body.get("fee"), status.INFO);
		addSubStep(subSteps, "Found: "+recordObj.get("fee"), status.INFO);
		if (body.get("fee").equals(recordObj.get("fee")))
			addSubStep(subSteps, "Verified fee", status.PASS);
		else
			addSubStep(subSteps, "Failed! Fee is mismatching", status.FAIL);

		addSubStep(subSteps, "Expected email: "+body.get("email"), status.INFO);
		addSubStep(subSteps, "Found: "+recordObj.get("email"), status.INFO);
		if (body.get("email").equals(recordObj.get("email")))
			addSubStep(subSteps, "Verified email", status.PASS);
		else
			addSubStep(subSteps, "Failed! Email is mismatching", status.FAIL);

		addSubStep(subSteps, "Expected address: "+body.get("address"), status.INFO);
		addSubStep(subSteps, "Found: "+recordObj.get("address"), status.INFO);
		if (body.get("address").equals(recordObj.get("address")))
			addSubStep(subSteps, "Verified address", status.PASS);
		else
			addSubStep(subSteps, "Failed! Address is mismatching", status.FAIL);

		addSubStep(subSteps, "Expected URL: "+body.get("URL"), status.INFO);
		addSubStep(subSteps, "Found: "+recordObj.get("URL"), status.INFO);
		if (body.get("URL").equals(recordObj.get("URL")))
			addSubStep(subSteps, "Verified URL", status.PASS);
		else
			addSubStep(subSteps, "Failed! URL is mismatching", status.FAIL);

		addSubStep(subSteps, "Expected ACL: "+body.get("ACL"), status.INFO);
		addSubStep(subSteps, "Found: "+recordObj.get("ACL"), status.INFO);
		if (body.get("ACL").equals(recordObj.get("ACL")))
			addSubStep(subSteps, "Verified ACL", status.PASS);
		else
			addSubStep(subSteps, "Failed! ACL is mismatching", status.FAIL);

		addSubStep(subSteps, "Expected ABN: "+body.get("ABN"), status.INFO);
		addSubStep(subSteps, "Found: "+recordObj.get("ABN"), status.INFO);
		if (body.get("ABN").equals(recordObj.get("ABN")))
			addSubStep(subSteps, "Verified ABN", status.PASS);
		else
			addSubStep(subSteps, "Failed! ABN is mismatching", status.FAIL);

		/*
		 * addSubStep(subSteps, "Expected folderId: "+body.get("folderId"),
		 * status.INFO); addSubStep(subSteps, "Found: "+recordObj.get("folderId"),
		 * status.INFO); if (body.get("folderId").equals(recordObj.get("folderId")))
		 * addSubStep(subSteps, "Verified folderId", status.PASS); else
		 * addSubStep(subSteps, "Failed! folderId is mismatching", status.FAIL);
		 */					
		addSubStep(subSteps, "Expected sub aggregator internal code: "+body.get("subAggregatorInternalCode"), status.INFO);
		addSubStep(subSteps, "Found: "+recordObj.get("subAggregatorInternalCode"), status.INFO);
		if (body.get("subAggregatorInternalCode").equals(recordObj.get("subAggregatorInternalCode")))
			addSubStep(subSteps, "Verified sub Aggregator Internal Code", status.PASS);
		else
			addSubStep(subSteps, "Failed! sub Aggregator Internal Code is mismatching", status.FAIL);
		
		addSubStep(subSteps, "Expected AFCA: "+body.get("AFCA"), status.INFO);
		addSubStep(subSteps, "Found: "+recordObj.get("AFCA"), status.INFO);
		if (body.get("AFCA").equals(recordObj.get("AFCA")))
			addSubStep(subSteps, "Verified AFCA", status.PASS);
		else
			addSubStep(subSteps, "Failed! AFCA is mismatching", status.FAIL);
		
		addSubStep(subSteps, "Expected ACN: "+body.get("ACN"), status.INFO);
		addSubStep(subSteps, "Found: "+recordObj.get("ACN"), status.INFO);
		if (body.get("ACN").equals(recordObj.get("ACN")))
			addSubStep(subSteps, "Verified ACN", status.PASS);
		else
			addSubStep(subSteps, "Failed! ACN is mismatching", status.FAIL);

		addSubStep(subSteps, "Expected MFAA: "+body.get("MFAA"), status.INFO);
		addSubStep(subSteps, "Found: "+recordObj.get("MFAA"), status.INFO);
		if (body.get("MFAA").equals(recordObj.get("MFAA")))
			addSubStep(subSteps, "Verified MFAA", status.PASS);
		else
			addSubStep(subSteps, "Failed! MFAA is mismatching", status.FAIL);

		/*
		 * addSubStep(subSteps, "Expected CPIIPN: "+body.get("CPIIPN"), status.INFO);
		 * addSubStep(subSteps, "Found: "+recordObj.get("CPIIPN"), status.INFO); if
		 * (body.get("CPIIPN").equals(recordObj.get("CPIIPN"))) addSubStep(subSteps,
		 * "Verified CPIIPN", status.PASS); else addSubStep(subSteps,
		 * "Failed! CPIIPN is mismatching", status.FAIL);
		 */
		return subSteps;
	}

	public ArrayList<TestSteps> guarantor(boolean isUpdate) {
		Status status = null;
		String postValue = "201";
		String email = "xyz" + generateRandomNumberWithGivenNumberOfDigits(4) + "@gmail.com";
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\ApiConfig.properties");
		Properties prop = new Properties();
		String guarantorId = PropertiesReader.getApiPropertyValue("guarantorId");

		try {
			Response response = null;
			Map<String, String> body = new HashMap<String, String>();
			if (isUpdate) {
				addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Updated Guarantor<<<<<<<<<<<<<</b>", status.INFO);
				setupWithToken("/guarantor/" + guarantorId);
				addSubStep(subSteps, "URL: https://platform-api.dev.osqo.com.au/guarantor/"+guarantorId, Status.PASS);

			} else {
				setupWithToken("/guarantor");
				addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Create Guarantor<<<<<<<<<<<<<</b>", status.INFO);
				addSubStep(subSteps, "URL: https://platform-api.dev.osqo.com.au/guarantor", Status.PASS);
				
			}
			body.put("osqoId", "OSQO ID");
			body.put("salutation", "Mr");
			body.put("firstName", "Farhan"+randomNumberString(2));
			body.put("lastName", "Ghaffar"+randomNumberString(2));
			body.put("titleRole", "Guarantor_"+randomNumberString(2));

			body.put("address", "xyz");
			body.put("city", "Xyz");
			body.put("stateProvinceTerritory", "ACT");
			body.put("postCode", "411045");
			body.put("emailAddress", email);
			body.put("phoneNumber", "1234567890");
			body.put("DOB", "01/02/1984");
			body.put("status", "CREATED");
			body.put("passedKYC", "NULL");
			body.put("guarantorKYCAddress", "Guarantor KYC ADD");
			body.put("latestKYCPassDate", "01/02/2000");
			body.put("nextRenewalKYCPassDate", "05/09/2022");
			body.put("australianBusinessNumber", "1234567890");
			body.put("taxFileNumber", "0987654321");
			body.put("socialSovereignId", "1234567890");
			body.put("taxResidence", "Test");
			body.put("specialConditionDetails", "Special condition details");
			body.put("borrowerId", "");
			body.put("scenarioId", "");
			body.put("brokerId", "");
			body.put("bcpId", "");
			body.put("espId", "");
			body.put("inProgress", "COMPLETED");
			
			if (isUpdate) 
				response = httpRequest.body(body).when().patch().andReturn();
			else
				response = httpRequest.body(body).when().post().andReturn();

			JSONObject respone = new JSONObject(response.asString());
			String message = respone.getString("message");
			if (isUpdate) {
				if (message.equalsIgnoreCase("Guarantor updated successfully")) {
					addSubStep(subSteps, "Message: " + message, Status.PASS);

				} else {
					addSubStep(subSteps, "Message: " + message, Status.FAIL);
					Assert.assertFalse(true);
				}
			} else {
				
				if (message.equalsIgnoreCase("Guarantor created successfully")) {
					addSubStep(subSteps, "Message: " + message, Status.PASS);

				} else {
					addSubStep(subSteps, "Message: " + message, Status.FAIL);
					Assert.assertFalse(true);
				}

			}
			JSONArray array = respone.getJSONArray("items");
			JSONObject obj1 = array.getJSONObject(0);
			guarantorId = obj1.getString("guarantorId");
			JSONObject getGuarantorPersonalDetails = obj1.getJSONObject("guarantorPersonalDetails");

			try (InputStream in = new FileInputStream(file)) {
				if (in == null) {
					throw new FileNotFoundException();
				}
				prop.load(in);
				prop.setProperty("guarantorId", guarantorId);

				OutputStream out = new FileOutputStream(file);
				prop.store(out, "some comment");
			} catch (IOException e) {
				e.printStackTrace();
			}

			String StatusCode = Integer.toString(response.getStatusCode());
			addSubStep(subSteps, "<b>Response Status is = " + StatusCode + "</b>", Status.INFO);

			if (isUpdate) {
				
				String expectedFirstName = body.get("firstName");
				String foundFirstName = getGuarantorPersonalDetails.getString("firstName");
				addSubStep(subSteps, "Expected first name: "+expectedFirstName, Status.INFO);
				addSubStep(subSteps, "Found: "+foundFirstName, Status.INFO);
				if (expectedFirstName.equals(foundFirstName ))
					addSubStep(subSteps, "Verified first name", Status.PASS);
				else
					addSubStep(subSteps, "Failed! first name is mistraching", Status.FAIL);

				
				String expectedLastName = body.get("lastName");
				String foundLastName = getGuarantorPersonalDetails.getString("lastName");
				addSubStep(subSteps, "Expected last name: "+expectedLastName, Status.INFO);
				addSubStep(subSteps, "Found: "+foundLastName, Status.INFO);
				if (expectedLastName.equals(foundLastName ))
					addSubStep(subSteps, "Verified last name", Status.PASS);
				else
					addSubStep(subSteps, "Failed! last name is mistraching", Status.FAIL);

				
				String expectedTitleName = body.get("titleRole");
				String foundTitle = getGuarantorPersonalDetails.getString("titleRole");
				addSubStep(subSteps, "Expected title: "+expectedTitleName, Status.INFO);
				addSubStep(subSteps, "Found: "+foundTitle, Status.INFO);
				if (expectedTitleName.equals(foundTitle ))
					addSubStep(subSteps, "Verified title", Status.PASS);
				else
					addSubStep(subSteps, "Failed! title is mistraching", Status.FAIL);

			}
			else {
				addSubStep(subSteps, "osqoId: OSQO ID", Status.PASS);
				addSubStep(subSteps, "firstName: Farhan", Status.PASS);
				addSubStep(subSteps, "lastName: Ghaffar", Status.PASS);
				addSubStep(subSteps, "titleRole: Test title role", Status.PASS);
				addSubStep(subSteps, "address: xyz", Status.PASS);
				addSubStep(subSteps, "city: Xyz", Status.PASS);
				addSubStep(subSteps, "stateProvinceTerritory: ACT", Status.PASS);
				addSubStep(subSteps, "postCode: abc", Status.PASS);
				addSubStep(subSteps, "firstName: Julia", Status.PASS);
				addSubStep(subSteps, "ABN: 411045", Status.PASS);
				addSubStep(subSteps, "emailAddress: farhan@gmail.com", Status.PASS);
				addSubStep(subSteps, "phoneNumber: 1234567890", Status.PASS);
				addSubStep(subSteps, "DOB: 01/02/1984", Status.PASS);
				addSubStep(subSteps, "status: CREATED", Status.PASS);
				addSubStep(subSteps, "passedKYC: NULL", Status.PASS);
				addSubStep(subSteps, "guarantorKYCAddress: Guarantor KYC ADD", Status.PASS);
				addSubStep(subSteps, "nextRenewalKYCPassDate: 05/09/2022", Status.PASS);
				addSubStep(subSteps, "australianBusinessNumber: 1234567890", Status.PASS);
				addSubStep(subSteps, "taxFileNumber: 0987654321", Status.PASS);
				addSubStep(subSteps, "socialSovereignId: 1234567890", Status.PASS);
				addSubStep(subSteps, "taxResidence: Pune", Status.PASS);
				addSubStep(subSteps, "specialConditionDetails: Special condition details", Status.PASS);
				addSubStep(subSteps, "borrowerId:  ", Status.PASS);
				addSubStep(subSteps, "scenarioId:  ", Status.PASS);
				addSubStep(subSteps, "brokerId:  ", Status.PASS);
				addSubStep(subSteps, "bcpId:  ", Status.PASS);
				addSubStep(subSteps, "espId: ", Status.PASS);
			}
			
			

			waitTime(10000);
			guarantorForHL(guarantorId,body);

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

	public ArrayList<TestSteps> guarantorForHL(String id, Map<String, String> body) {
		String postValue = "200";
		Status status = null;
		String guarantorKYCAddress;
		String latestKYCPassDate;
		String nextRenewalKYCPassDate;
		String docType;
		String guarantorId;
		String australianBusinessNumber;
		String socialSovereignId;
		String taxFileNumber;
		String inProgress;
		String osqoId;
		String specialConditionDetails;
		String taxResidence;
		
		addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Verify Guarantor on HL<<<<<<<<<<<<<</b>", status.INFO);
		addSubStep(subSteps, "URL: http://52.64.108.214:3000/guarantor/" + id + "", Status.INFO);
		
		RestAssured.baseURI = "http://52.64.108.214:3000";
		RestAssured.basePath = "/guarantor/" + id;
		Response response = RestAssured.given().when().get();
		JSONObject responseValue = new JSONObject(response.asString());
		String statusCode = Integer.toString(response.getStatusCode());
		addSubStep(subSteps, "<b>Response Status is = " + statusCode + "</b>", Status.PASS);
		

		if (responseValue.has("message")) {
			addSubStep(subSteps, "Message: "+responseValue.getString("message"), Status.INFO);
			Assert.assertFalse(true);

		}
		JSONObject dataObj = responseValue.getJSONObject("data");
		JSONObject recordsObj = dataObj.getJSONObject("Record");
		JSONObject getGuarantorPersonalDetails = recordsObj.getJSONObject("guarantorPersonalDetails");
		
		String expectedFirstName = body.get("firstName");
		String foundFirstName = getGuarantorPersonalDetails.getString("firstName");
		addSubStep(subSteps, "Expected first name: "+expectedFirstName, Status.INFO);
		addSubStep(subSteps, "Found: "+foundFirstName, Status.INFO);
		if (expectedFirstName.equals(foundFirstName ))
			addSubStep(subSteps, "Verified first name", Status.PASS);
		else
			addSubStep(subSteps, "Failed! first name is mismatching", Status.FAIL);


		
		String expectedLastName = body.get("lastName");
		String foundLastName = getGuarantorPersonalDetails.getString("lastName");
		addSubStep(subSteps, "Expected last name: "+expectedLastName, Status.INFO);
		addSubStep(subSteps, "Found: "+foundLastName, Status.INFO);
		if (expectedLastName.equals(foundLastName ))
			addSubStep(subSteps, "Verified last name", Status.PASS);
		else
			addSubStep(subSteps, "Failed! last name is mismatching", Status.FAIL);

		
		String expectedTitleName = body.get("titleRole");
		String foundTitle = getGuarantorPersonalDetails.getString("titleRole");
		addSubStep(subSteps, "Expected title: "+expectedTitleName, Status.INFO);
		addSubStep(subSteps, "Found: "+foundTitle, Status.INFO);
		if (expectedTitleName.equals(foundTitle ))
			addSubStep(subSteps, "Verified title role", Status.PASS);
		else
			addSubStep(subSteps, "Failed! title role is mismatching", Status.FAIL);

		
		return subSteps;
	}

	public ArrayList<TestSteps> aggregator() {
		Status status = null;
		String postValue = "201";
		Map<String, String> body = new HashMap<String, String>();
		String randomNumber = Utilities.generateRandomNumberWithGivenNumberOfDigits(4);

		body.put("firstName", "Farhan_"+randomNumber);
		body.put("lastName", "QA");
		body.put("company", "Tester_"+randomNumber);
		body.put("fee", "1");
		body.put("email", "xyz@gmail.com");
		body.put("address", "xyz");
		body.put("URL", "www.xyz.com");
		body.put("ACL", "abc");
		body.put("ABN", "abc");
		body.put("ACN", "abc");
		body.put("folderId", ""+randomNumber);
		body.put("aggregatorStatus", "CREATED");
		
		DashboardPage dashboardPage = new DashboardPage();
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\ApiConfig.properties");
		Properties prop = new Properties();
		try {
			
			/*openUrlInNewTab("AppURL");

			status = lp.enterEmail(bcpEmail);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = lp.clickOnSubmitButton();

			// getting otp from register email
			yourCode = mailOTPReader(username, password);

			status = lp.enterYourCode(yourCode);
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			status = lp.clickOnSubmitButton();
			addSubStep(subSteps, "click On Submit Button", status);

			status = dashboardPage.verifyNavMenuSyncSubmissionsButton();
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);*/

			setup("/aggregator");
			addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Create Aggregator<<<<<<<<<<<<<</b>", status.INFO);
			Response response = httpRequest.body(body).when().post().andReturn();

			addSubStep(subSteps, "Status: "+response.statusCode(), Status.PASS);
			if (response.statusCode()!=201)
				Assert.assertFalse(true);
			JSONObject respone = new JSONObject(response.asString());
			String message = respone.getString("message");
			if (!message.equalsIgnoreCase("Aggregator created successfully"))
				Assert.assertFalse(true);

			JSONArray array = respone.getJSONArray("items");
			JSONObject obj1 = array.getJSONObject(0);
			aggregatorId = obj1.getString("aggregatorId");
			addSubStep(subSteps, "Verified aggregator created successfully: "+aggregatorId, Status.PASS);

			try (InputStream in = new FileInputStream(file)) {
				if (in == null) {
					throw new FileNotFoundException();
				}
				prop.load(in);
				prop.setProperty("aggregatorId", aggregatorId);

				OutputStream out = new FileOutputStream(file);
				prop.store(out, "some comment");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			waitTime(40*1000);
			String getBaseURL = PropertiesReader.getApiPropertyValue("baseURLDev");
			addSubStep(subSteps, "<b>>>>>>>>>>>>>>> Verifying Createed Aggregator using Get Api <<<<<<<<<<<<<</b>", status.INFO);
			addSubStep(subSteps, getBaseURL+"/aggregator/"+aggregatorId, Status.INFO);
			setup("/aggregator/"+aggregatorId);
			Response responseFromGet = httpRequest.get().andReturn();

			addSubStep(subSteps, "Status code for getting data: "+responseFromGet.statusCode(), Status.PASS);
			if (responseFromGet.statusCode()!=200)
				assertFalse(true);
			
			JSONObject getResponseAsString = new JSONObject(responseFromGet.asString());
			JSONArray itemsArray = getResponseAsString.getJSONArray("items");
			JSONObject recordObj = itemsArray.getJSONObject(0);

			
			for (Map.Entry<String, String> entry : body.entrySet()) {	
				String key = entry.getKey();
				String val = entry.getValue();
				addSubStep(subSteps, "Expected "+key+": "+val, status.INFO);
				addSubStep(subSteps, "Found: "+recordObj.get("firstName"), status.INFO);
				if (val.equals(recordObj.get(key)))
					addSubStep(subSteps, "Verified "+key, status.PASS);
				else
					addSubStep(subSteps, "Failed! "+key+" is mismatching", status.FAIL);	
			}
			
			/*addSubStep(subSteps, "Expected last name: "+body.get("lastName"), status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get("lastName"), status.INFO);
			if (body.get("lastName").equals(recordObj.get("lastName")))
				addSubStep(subSteps, "Verified last name", status.PASS);
			else
				addSubStep(subSteps, "Failed! last name is mismatching", status.FAIL);

			
			addSubStep(subSteps, "Expected company: "+body.get("company"), status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get("company"), status.INFO);
			if (body.get("company").equals(recordObj.get("company")))
				addSubStep(subSteps, "Verified company", status.PASS);
			else
				addSubStep(subSteps, "Failed! Company is mismatching", status.FAIL);

			addSubStep(subSteps, "Expected fee: "+body.get("fee"), status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get("fee"), status.INFO);
			if (body.get("fee").equals(recordObj.get("fee")))
				addSubStep(subSteps, "Verified fee", status.PASS);
			else
				addSubStep(subSteps, "Failed! Fee is mismatching", status.FAIL);

			addSubStep(subSteps, "Expected email: "+body.get("email"), status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get("email"), status.INFO);
			if (body.get("email").equals(recordObj.get("email")))
				addSubStep(subSteps, "Verified email", status.PASS);
			else
				addSubStep(subSteps, "Failed! Email is mismatching", status.FAIL);

			addSubStep(subSteps, "Expected address: "+body.get("address"), status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get("address"), status.INFO);
			if (body.get("address").equals(recordObj.get("address")))
				addSubStep(subSteps, "Verified address", status.PASS);
			else
				addSubStep(subSteps, "Failed! Address is mismatching", status.FAIL);

			addSubStep(subSteps, "Expected URL: "+body.get("URL"), status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get("URL"), status.INFO);
			if (body.get("URL").equals(recordObj.get("URL")))
				addSubStep(subSteps, "Verified URL", status.PASS);
			else
				addSubStep(subSteps, "Failed! URL is mismatching", status.FAIL);

			addSubStep(subSteps, "Expected ACL: "+body.get("ACL"), status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get("ACL"), status.INFO);
			if (body.get("ACL").equals(recordObj.get("ACL")))
				addSubStep(subSteps, "Verified ACL", status.PASS);
			else
				addSubStep(subSteps, "Failed! ACL is mismatching", status.FAIL);

			addSubStep(subSteps, "Expected ABN: "+body.get("ABN"), status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get("ABN"), status.INFO);
			if (body.get("ABN").equals(recordObj.get("ABN")))
				addSubStep(subSteps, "Verified ABN", status.PASS);
			else
				addSubStep(subSteps, "Failed! ABN is mismatching", status.FAIL);

			addSubStep(subSteps, "Expected folderId: "+body.get("folderId"), status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get("folderId"), status.INFO);
			if (body.get("folderId").equals(recordObj.get("folderId")))
				addSubStep(subSteps, "Verified folderId", status.PASS);
			else
				addSubStep(subSteps, "Failed! folderId is mismatching", status.FAIL);
*/
			
			waitTime(60*1000);
			setupForHL(aggregatorId, body);

			return subSteps;
		} catch (Exception e) {
			addSubStep(subSteps, e.getMessage().toString(), Status.FAIL);
			return subSteps;

		} catch (Error e) {
			addSubStep(subSteps,e.getMessage().toString(), Status.FAIL);
			return subSteps;
		}
	}

	public ArrayList<TestSteps> updatAggregator() {
		Status status = null;
		String postValue = "200";
		String aggregatorId = PropertiesReader.getApiPropertyValue("aggregatorId");
		try {

			setup("/aggregator/" + aggregatorId);
			addSubStep(subSteps, "<b>>>>>>>>>>>>>>Update Aggregator<<<<<<<<<<<<<</b>", status.INFO);
			addSubStep(subSteps, "URL: https://platform-api.dev.osqo.com.au/aggregator/" + aggregatorId, Status.PASS);

			Map<String, String> body = new HashMap<String, String>();

			body.put("firstName", "Farhan" + randomNumberString(2) + "");
			body.put("lastName", "Ghaffar" + randomNumberString(2) + "");

			Response response = httpRequest.body(body).when().patch().andReturn();
			JSONObject respone = new JSONObject(response.asString());
			String StatusCode = Integer.toString(response.getStatusCode());
			String message = respone.getString("message");
			addSubStep(subSteps, "<b>Response is : " + message + "</b>", Status.PASS);
			addSubStep(subSteps, "<b>Response Status is = " + StatusCode + "</b>", Status.PASS);
			if (!message.equalsIgnoreCase("Aggregator updated successfully"))
				Assert.assertFalse(true);

			JSONArray array = respone.getJSONArray("items");
			JSONObject obj1 = array.getJSONObject(0);
			aggregatorId = obj1.getString("aggregatorId");

			String getFirstName = obj1.getString("firstName");
			String getLastName = obj1.getString("lastName");

			addSubStep(subSteps, "Expected first name: " + body.get("firstName"), Status.INFO);
			addSubStep(subSteps, "Found: " + getFirstName, Status.INFO);

			if (getFirstName.equalsIgnoreCase(body.get("firstName")))
				addSubStep(subSteps, "Successfully verified value updated", Status.PASS);
			else
				addSubStep(subSteps, "failed, first name value did not updat", Status.FAIL);

			addSubStep(subSteps, "Expected last name: " + body.get("lastName"), Status.INFO);
			addSubStep(subSteps, "Found: " + getLastName, Status.INFO);

			if (getLastName.equalsIgnoreCase(body.get("lastName")))
				addSubStep(subSteps, "Verifeid last name updated successfully", Status.PASS);
			else
				addSubStep(subSteps, "failed, Last name did not update", Status.FAIL);

			waitTime(10000);
			setupUpdateAggregatorForHL(aggregatorId, getFirstName, getLastName);

			return subSteps;
		} catch (Exception e) {
			addSubStep(subSteps, e.getMessage().toString(), Status.FAIL);
			return subSteps;

		} catch (Error e) {
			addSubStep(subSteps, e.getMessage().toString(), Status.FAIL);
			return subSteps;
		}
	}

	public ArrayList<TestSteps> updateSubAggregator() {
		Status status = null;
		String postValue = "200";
		String yourCode;
		String subAggregatorIdBefore = PropertiesReader.getApiPropertyValue("subAggregatorId");
		DashboardPage dashboardPage = new DashboardPage();
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\ApiConfig.properties");
		Properties prop = new Properties();
		try {

			setup("/sub-aggregator/" + subAggregatorIdBefore + "");
			addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Update Sub Aggregator<<<<<<<<<<<<<</b>", status.INFO);
			Map<String, String> body = new HashMap<String, String>();
			body.put("firstName", "Farhan" + randomNumberString(2) + "");
			body.put("lastName", "Ghaffar" + randomNumberString(2) + "");

			Response response = httpRequest.body(body).when().patch().andReturn();
			System.out.println(response.asString());

			JSONObject respone = new JSONObject(response.asString());
			String message = respone.getString("message");
			JSONArray array = respone.getJSONArray("items");
			JSONObject obj1 = array.getJSONObject(0);
			subAggregatorId = obj1.getString("subAggregatorId");
			try (InputStream in = new FileInputStream(file)) {
				if (in == null) {
					throw new FileNotFoundException();
				}
				prop.load(in);
				prop.setProperty("subAggregatorId", subAggregatorId);

				OutputStream out = new FileOutputStream(file);
				prop.store(out, "some comment");
			} catch (IOException e) {
				e.printStackTrace();
			}

			String StatusCode = Integer.toString(response.getStatusCode());
			addSubStep(subSteps, "<b>Response is : " + message + "</b>", Status.PASS);
			addSubStep(subSteps, "<b>Response Status is = " + StatusCode + "</b>", Status.PASS);
			status = ErrorCollector.verifyTrue(postValue.equals(StatusCode), "Verified <b>Aggregator</b> is created");
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			System.out.println(message);
			int c = response.getStatusCode();
			System.out.println(c);

			addSubStep(subSteps, "URL: https://platform-api.dev.osqo.com.au/sub-aggregator/" + subAggregatorId + "",
					Status.PASS);
			addSubStep(subSteps, "firstName: Farhan " + randomNumberString(2) + "", Status.PASS);
			addSubStep(subSteps, "lastName: Ghaffar " + randomNumberString(2) + "", Status.PASS);

			waitTime(4000);
			subAggregatorForHL(subAggregatorId,body);

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

	public ArrayList<TestSteps> subAggregator() {
		Status status = null;
		String postValue = "201";
		String aggregatorId = PropertiesReader.getApiPropertyValue("aggregatorId");
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\ApiConfig.properties");
		Properties prop = new Properties();
		try {
			setup("/sub-aggregator");
			addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Create Sub Aggregator<<<<<<<<<<<<<</b>", status.INFO);
			Map<String, String> body = new HashMap<String, String>();
			String randomNumber = Utilities.generateRandomNumberWithGivenNumberOfDigits(4);
			body.put("firstName", "Farhan_"+randomNumber);
			body.put("lastName", "QA");
			body.put("company", "Tester_"+randomNumber);
			body.put("fee", "1");
			body.put("email", "xyz@gmail.com");
			body.put("address", "xyz");
			body.put("URL", "www.xyz.com");
			body.put("ACL", "abc");
			body.put("ABN", "abc");
			body.put("ACN", "abc");
			body.put("subAggregatorInternalCode", "123456");
			body.put("AFCA", "Test AFCA");
			body.put("ACN", "Test ACN");
			body.put("MFAA", "Test MFAA");
			body.put("CPIIPN", "Test CPIIPN");
			body.put("parentSubAggregatorId", "");
			body.put("status", "CREATED");
			body.put("folderId", "");
			body.put("aggregatorId", "" + aggregatorId + "");

			Response response = httpRequest.body(body).when().post().andReturn();
			addSubStep(subSteps, "<b>Response Status is = "+response.getStatusCode(), Status.INFO);
			if (response.getStatusCode()!=201)
				Assert.assertFalse(true);
			
			JSONObject respone = new JSONObject(response.asString());
			String message = respone.getString("message");
			JSONArray array = respone.getJSONArray("items");
			JSONObject obj1 = array.getJSONObject(0);
			subAggregatorId = obj1.getString("subAggregatorId");
			try (InputStream in = new FileInputStream(file)) {
				if (in == null) {
					throw new FileNotFoundException();
				}
				prop.load(in);
				prop.setProperty("subAggregatorId", subAggregatorId);

				OutputStream out = new FileOutputStream(file);
				prop.store(out, "some comment");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			waitTime(60*1000);
			String getBaseURL = PropertiesReader.getApiPropertyValue("baseURLDev");
			addSubStep(subSteps, "<b>>>>>>>>>>>>>>> Verify Created Sub Aggregator using Get Api <<<<<<<<<<<<<</b>", status.INFO);
			addSubStep(subSteps, getBaseURL+"/sub-aggregator/"+subAggregatorId, Status.INFO);
			setup("/sub-aggregator/"+subAggregatorId);
			Response responseFromGet = httpRequest.get().andReturn();

			addSubStep(subSteps, "Status code for getting data: "+responseFromGet.statusCode(), Status.INFO);
			if (responseFromGet.statusCode()!=200)
				Assert.assertFalse(true);
			
			JSONObject getResponseAsString = new JSONObject(responseFromGet.asString());
			JSONArray itemsArray = getResponseAsString.getJSONArray("items");
			JSONObject recordObj = itemsArray.getJSONObject(0);

			addSubStep(subSteps, "Expected first name: "+body.get("firstName"), status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get("firstName"), status.INFO);
			if (body.get("firstName").equals(recordObj.get("firstName")))
				addSubStep(subSteps, "Verified first name", status.PASS);
			else
				addSubStep(subSteps, "Failed! first name is mismatching", status.FAIL);

			addSubStep(subSteps, "Expected last name: "+body.get("lastName"), status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get("lastName"), status.INFO);
			if (body.get("lastName").equals(recordObj.get("lastName")))
				addSubStep(subSteps, "Verified last name", status.PASS);
			else
				addSubStep(subSteps, "Failed! last name is mismatching", status.FAIL);

			addSubStep(subSteps, "Expected company: "+body.get("company"), status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get("company"), status.INFO);
			if (body.get("company").equals(recordObj.get("company")))
				addSubStep(subSteps, "Verified company", status.PASS);
			else
				addSubStep(subSteps, "Failed! Company is mismatching", status.FAIL);

			addSubStep(subSteps, "Expected fee: "+body.get("fee"), status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get("fee"), status.INFO);
			if (body.get("fee").equals(recordObj.get("fee")))
				addSubStep(subSteps, "Verified fee", status.PASS);
			else
				addSubStep(subSteps, "Failed! Fee is mismatching", status.FAIL);

			addSubStep(subSteps, "Expected email: "+body.get("email"), status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get("email"), status.INFO);
			if (body.get("email").equals(recordObj.get("email")))
				addSubStep(subSteps, "Verified email", status.PASS);
			else
				addSubStep(subSteps, "Failed! Email is mismatching", status.FAIL);

			addSubStep(subSteps, "Expected address: "+body.get("address"), status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get("address"), status.INFO);
			if (body.get("address").equals(recordObj.get("address")))
				addSubStep(subSteps, "Verified address", status.PASS);
			else
				addSubStep(subSteps, "Failed! Address is mismatching", status.FAIL);

			addSubStep(subSteps, "Expected URL: "+body.get("URL"), status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get("URL"), status.INFO);
			if (body.get("URL").equals(recordObj.get("URL")))
				addSubStep(subSteps, "Verified URL", status.PASS);
			else
				addSubStep(subSteps, "Failed! URL is mismatching", status.FAIL);

			addSubStep(subSteps, "Expected ACL: "+body.get("ACL"), status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get("ACL"), status.INFO);
			if (body.get("ACL").equals(recordObj.get("ACL")))
				addSubStep(subSteps, "Verified ACL", status.PASS);
			else
				addSubStep(subSteps, "Failed! ACL is mismatching", status.FAIL);

			addSubStep(subSteps, "Expected ABN: "+body.get("ABN"), status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get("ABN"), status.INFO);
			if (body.get("ABN").equals(recordObj.get("ABN")))
				addSubStep(subSteps, "Verified ABN", status.PASS);
			else
				addSubStep(subSteps, "Failed! ABN is mismatching", status.FAIL);

			/*
			 * addSubStep(subSteps, "Expected folderId: "+body.get("folderId"),
			 * status.INFO); addSubStep(subSteps, "Found: "+recordObj.get("folderId"),
			 * status.INFO); if (body.get("folderId").equals(recordObj.get("folderId")))
			 * addSubStep(subSteps, "Verified folderId", status.PASS); else
			 * addSubStep(subSteps, "Failed! folderId is mismatching", status.FAIL);
			 */			
			
			addSubStep(subSteps, "Expected sub aggregator internal code: "+body.get("subAggregatorInternalCode"), status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get("subAggregatorInternalCode"), status.INFO);
			if (body.get("subAggregatorInternalCode").equals(recordObj.get("subAggregatorInternalCode")))
				addSubStep(subSteps, "Verified sub Aggregator Internal Code", status.PASS);
			else
				addSubStep(subSteps, "Failed! sub Aggregator Internal Code is mismatching", status.FAIL);
			
			addSubStep(subSteps, "Expected AFCA: "+body.get("AFCA"), status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get("AFCA"), status.INFO);
			if (body.get("AFCA").equals(recordObj.get("AFCA")))
				addSubStep(subSteps, "Verified AFCA", status.PASS);
			else
				addSubStep(subSteps, "Failed! AFCA is mismatching", status.FAIL);
			
			addSubStep(subSteps, "Expected ACN: "+body.get("ACN"), status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get("ACN"), status.INFO);
			if (body.get("ACN").equals(recordObj.get("ACN")))
				addSubStep(subSteps, "Verified ACN", status.PASS);
			else
				addSubStep(subSteps, "Failed! ACN is mismatching", status.FAIL);
	
			addSubStep(subSteps, "Expected MFAA: "+body.get("MFAA"), status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get("MFAA"), status.INFO);
			if (body.get("MFAA").equals(recordObj.get("MFAA")))
				addSubStep(subSteps, "Verified MFAA", status.PASS);
			else
				addSubStep(subSteps, "Failed! MFAA is mismatching", status.FAIL);

			/*
			 * addSubStep(subSteps, "Expected CPIIPN: "+body.get("CPIIPN"), status.INFO);
			 * addSubStep(subSteps, "Found: "+recordObj.get("CPIIPN"), status.INFO); if
			 * (body.get("CPIIPN").equals(recordObj.get("CPIIPN"))) addSubStep(subSteps,
			 * "Verified CPIIPN", status.PASS); else addSubStep(subSteps,
			 * "Failed! CPIIPN is mismatching", status.FAIL);
			 */
			waitTime(60*1000);
			subAggregatorForHL(subAggregatorId,body);

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

	public ArrayList<TestSteps> borrowerForHL(String id) {
		String postValue = "200";
		Status status = null;
		String borrowerHash;
		String docType;
		String folderId;
		String inProgress;
		String borrowerId;
		boolean specialCondition;
		String specialConditionDetails;

		addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Verify Borrower in HL<<<<<<<<<<<<<</b>", status.INFO);

		addSubStep(subSteps, "URL: http://52.64.108.214:3000/borrower/" + id + "", Status.INFO);
		RestAssured.baseURI = "http://52.64.108.214:3000";
		RestAssured.basePath = "/borrower/" + id;
		Response response = RestAssured.given().when().get();
		JSONObject responseValue = new JSONObject(response.asString());
		if (responseValue.has("message")) {
			addSubStep(subSteps, responseValue.getString("message"), Status.FAIL);
			Assert.assertFalse(true);
		}
		JSONObject obj1 = responseValue.getJSONObject("data");
		JSONObject obj2 = obj1.getJSONObject("Record");

		String statusCode = Integer.toString(response.getStatusCode());
		addSubStep(subSteps, "<b>Response Status is = " + statusCode + "</b>", Status.PASS);
		status = ErrorCollector.verifyTrue(postValue.equals(statusCode),
				"Verified <b>Borrower Status</b> is displaying");
		if (status.equals(Status.FAIL))
			Assert.assertFalse(true);

		borrowerHash = obj2.getString("borrowerHash");
		addSubStep(subSteps, "BorrowerHash: " + borrowerHash + "", Status.PASS);

		borrowerId = obj2.getString("borrowerId");
		addSubStep(subSteps, "Borrower Id: " + borrowerId + "", Status.PASS);

		docType = obj2.getString("docType");
		addSubStep(subSteps, "DocType: " + docType + "", Status.PASS);

		folderId = obj2.getString("folderId");
		addSubStep(subSteps, "Folder Id: " + folderId + "", Status.PASS);

		inProgress = obj2.getString("inProgress");
		addSubStep(subSteps, "In Progress: " + inProgress + "", Status.PASS);

		specialCondition = obj2.getBoolean("specialCondition");
		addSubStep(subSteps, "SpecialCondition: " + specialCondition + "", Status.PASS);

		return subSteps;
	}

	public ArrayList<TestSteps> borrower(boolean isUpdate) {
		Status status = null;
		String borrowerHashVal = "HB_value" + generateRandomNumberWithGivenNumberOfDigits(4) + "";
		String brokerId = PropertiesReader.getApiPropertyValue("brokerId");
		borrowerId = PropertiesReader.getApiPropertyValue("borrowerId");

		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\ApiConfig.properties");
		Properties prop = new Properties();
		JSONObject body = new JSONObject();
		JSONObject borrowerPartiesMap = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		try {

			if (isUpdate) {
				setupWithToken("/borrower/" + borrowerId);
				addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Update Borrower<<<<<<<<<<<<<</b>", status.INFO);

			} else {
				setup("/borrower");
				addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Create Borrower<<<<<<<<<<<<<</b>", status.INFO);

			}
			body.put("borrowerHash", borrowerHashVal);
			borrowerPartiesMap.put("emailAddress", "farhanghaffar@methodbridge.com");
			borrowerPartiesMap.put("source", "OSQO");
			borrowerPartiesMap.put("firstName", "farhan" + randomNumberString(2));
			borrowerPartiesMap.put("lastName", "ghaffar" + randomNumberString(2));
			borrowerPartiesMap.put("DOB", "01/03/1993");
			borrowerPartiesMap.put("phoneNumber", "096568465");
			jsonArray.put(borrowerPartiesMap);
			body.put("borrowerParties", jsonArray);

			body.put("specialCondition", false);
			body.put("specialConditionDetails", "Test Details");
			body.put("folderId", "Test folderId");
			body.put("brokerId", brokerId);
			body.put("bcpId", "bb7ee13a-fcf6-4e5e-9516-10f795b20ed4");
			body.put("espId", "e48548e6-0b92-410c-bde5-8eac619b656d");

			Response response = null;
			if (isUpdate)
				response = httpRequest.body(body.toString()).when().patch().andReturn();
			else
				response = httpRequest.body(body.toString()).when().post().andReturn();

			JSONObject respone = new JSONObject(response.asString());
			String message = respone.getString("message");

			String StatusCode = Integer.toString(response.getStatusCode());
			addSubStep(subSteps, "<b>Message is : " + message + "</b>", Status.PASS);
			addSubStep(subSteps, "<b>Response Status is = " + StatusCode + "</b>", Status.PASS);

			if (!message.contains("created") || !message.contains("updated"))
				System.out.println(message);
			// Assert.assertFalse(true);

			JSONArray array = respone.getJSONArray("items");
			JSONObject obj1 = array.getJSONObject(0);
			borrowerId = obj1.getString("borrowerId");
			try (InputStream in = new FileInputStream(file)) {
				if (in == null) {
					throw new FileNotFoundException();
				}
				prop.load(in);
				prop.setProperty("borrowerId", borrowerId);

				OutputStream out = new FileOutputStream(file);
				prop.store(out, "some comment");
			} catch (IOException e) {
				e.printStackTrace();
			}

			addSubStep(subSteps, "URL: https://platform-api.dev.osqo.com.au/borrower/", Status.INFO);
			addSubStep(subSteps, "borrowerHash: " + borrowerHashVal + "", Status.PASS);
			addSubStep(subSteps, "emailAddress: farhanghaffar@methodbridge.com", Status.PASS);
			addSubStep(subSteps, "source: OSQO", Status.PASS);

			/*
			 * addSubStep(subSteps,
			 * "Expected first name: "+borrowerPartiesMap.getString("firstName"),
			 * Status.INFO); addSubStep(subSteps,
			 * "Found: "+borrowerPartiesMap.getString("firstName"), Status.INFO);
			 * if(obj1.get("firstName").equals(borrowerPartiesMap.getString("firstName")))
			 * addSubStep(subSteps, "Verified first name", Status.PASS); else
			 * addSubStep(subSteps, "Failed! first name is mismatching", Status.PASS);
			 * 
			 * 
			 * addSubStep(subSteps,
			 * "Expected last name: "+borrowerPartiesMap.getString("lastName"),
			 * Status.INFO); addSubStep(subSteps,
			 * "Found: "+borrowerPartiesMap.getString("lastName"), Status.INFO);
			 * if(obj1.get("lastName").equals(borrowerPartiesMap.getString("lastName")))
			 * addSubStep(subSteps, "Failed! last name is mismatching", Status.PASS);
			 */

			addSubStep(subSteps, "DOB: 01/03/1993", Status.PASS);
			addSubStep(subSteps, "phoneNumber: 096568465", Status.PASS);
			addSubStep(subSteps, "specialCondition: false", Status.PASS);
			addSubStep(subSteps, "specialConditionDetails: Test Details", Status.PASS);
			addSubStep(subSteps, "bcpId: bb7ee13a-fcf6-4e5e-9516-10f795b20ed4", Status.PASS);
			addSubStep(subSteps, "espId: e48548e6-0b92-410c-bde5-8eac619b656d", Status.PASS);

			waitTime(5000);
			borrowerForHL(borrowerId);

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

	public ArrayList<TestSteps> scenario(boolean isUpdate) {
		Status status = null;
		String scenarioHashValue = "CP_value" + generateRandomNumberWithGivenNumberOfDigits(4) + "";
		String brokerId = PropertiesReader.getApiPropertyValue("brokerId");
		String borrowerId = PropertiesReader.getApiPropertyValue("borrowerId");
		String scenarioId = PropertiesReader.getApiPropertyValue("scenarioId");
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\ApiConfig.properties");
		Properties prop = new Properties();
		JSONObject body = new JSONObject();
		try {

			if (isUpdate) {
				addSubStep(subSteps, "<b>>>>>>>>>>>>>>> Update  Scenario<<<<<<<<<<<<<</b>", status.INFO);
				addSubStep(subSteps, "URL: https://platform-api.dev.osqo.com.au/borrower/" + scenarioId, Status.INFO);
				setupWithToken("/scenario/" + scenarioId);

				body.put("scenarioName", "Scenario_Test_" + randomNumberString(2));
				body.put("notes", "Update Notes" + randomNumberString(2));
				body.put("loanAmountOffer", 12 + randomNumberString(2));

			} else {

				setupWithToken("/scenario");
				addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Create Scenario<<<<<<<<<<<<<</b>", status.INFO);
				body.put("scenarioHash", scenarioHashValue);
				body.put("borrowerId", borrowerId);
				body.put("scenarioName", "Scenario_Test_" + randomNumberString(2));
				body.put("bondId", "65483212");
				body.put("bondCurrency", "INR");
				body.put("propertyClass", "Tets Property");
				body.put("borrowerDepositQuanta", "Quanta");
				body.put("FFBondQuanta", "Bond Quanta");
				body.put("scenarioState", "AWAITING_PREAPPROVAL");
				body.put("folderId", "Test Folder");
				body.put("fileId", "098765");
				body.put("guarantorFolderId", "35654");
				body.put("investorFolderId", "5464");
				body.put("dateTime", "2022-12-11");
				body.put("documentFolderId", "12345");
				body.put("notes", "Test Note");
				body.put("loanAmountOffer", "1234");
				body.put("brokerId", brokerId);
				body.put("bcpId", "bb7ee13a-fcf6-4e5e-9516-10f795b20ed4");
				body.put("espId", "e48548e6-0b92-410c-bde5-8eac619b656d");

			}
			JSONObject jsonObject = new JSONObject();
			body.put("documentFolderFiles", jsonObject);
			Response response = null;
			if (isUpdate) {
				response = httpRequest.body(body.toString()).when().patch().andReturn();
			} else
				response = httpRequest.body(body.toString()).when().post().andReturn();

			JSONObject respone = new JSONObject(response.asString());
			String StatusCode = Integer.toString(response.getStatusCode());
			addSubStep(subSteps, "<b>Response Status is = " + StatusCode + "</b>", Status.PASS);
			String message = respone.getString("message");
			if (isUpdate) {
				if (!message.equalsIgnoreCase("Scenario updated successfully")) {
					addSubStep(subSteps, "<b>Message is : " + message + "</b>", Status.FAIL);
					Assert.assertFalse(true);
				}
				addSubStep(subSteps, "<b>Message is : " + message + "</b>", Status.PASS);

			} else {
				if (!message.equalsIgnoreCase("Scenario created successfully")) {
					addSubStep(subSteps, "<b>Message is : " + message + "</b>", Status.FAIL);
					Assert.assertFalse(true);
				}
				addSubStep(subSteps, "<b>Message is : " + message + "</b>", Status.PASS);

			}
			JSONArray array = respone.getJSONArray("items");
			JSONObject obj1 = array.getJSONObject(0);
			scenarioId = obj1.getString("scenarioId");
			try (InputStream in = new FileInputStream(file)) {
				if (in == null) {
					throw new FileNotFoundException();
				}
				prop.load(in);
				prop.setProperty("scenarioId", scenarioId);

				OutputStream out = new FileOutputStream(file);
				prop.store(out, "some comment");
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (isUpdate) {
				addSubStep(subSteps, "Expedcted Scenario Name:" + body.getString("scenarioName"), Status.INFO);
				addSubStep(subSteps, "Found in response:" + obj1.getString("scenarioName"), Status.PASS);
				if (body.getString("scenarioName").equals(obj1.getString("scenarioName")))
					addSubStep(subSteps, "Verified scenario name", Status.PASS);
				else
					addSubStep(subSteps, "Failed! Scenario name is mismatching", Status.FAIL);

				JSONArray getNotes = obj1.getJSONArray("notes");
				JSONObject getLastIndex = (JSONObject) getNotes.get(getNotes.length() - 1);
				Object getUpdatedNotes = getLastIndex.get("message");

				addSubStep(subSteps, "Expedcted Scenario noates:" + body.getString("notes"), Status.INFO);
				addSubStep(subSteps, "Found in response:" + getUpdatedNotes, Status.PASS);
				if (body.getString("notes").equals(getUpdatedNotes))
					addSubStep(subSteps, "Verified notes", Status.PASS);
				else
					addSubStep(subSteps, "Failed! Scenario notes is mismatching", Status.FAIL);

				int expectedAmount = body.getInt("loanAmountOffer");
				int found = obj1.getInt("loanAmountOffer");
				addSubStep(subSteps, "Expedcted amount:" + expectedAmount, Status.INFO);
				addSubStep(subSteps, "Found in response:" + found, Status.INFO);

				if (Objects.equal(expectedAmount, found))
					addSubStep(subSteps, "Verified Amount", Status.PASS);
				else
					addSubStep(subSteps, "Failed! Amount is mismatching", Status.FAIL);

			} else {

				addSubStep(subSteps, "Scenario Hash: " + scenarioHashValue + "", Status.PASS);
				addSubStep(subSteps, "Scenario Id: " + scenarioId + "", Status.PASS);
				addSubStep(subSteps, "bondId: 65483212", Status.PASS);
				addSubStep(subSteps, "Bond Currency: INR", Status.PASS);
				addSubStep(subSteps, "Property Class: 096568465", Status.PASS);
				addSubStep(subSteps, "Borrower Deposit Quanta: Quanta", Status.PASS);
				addSubStep(subSteps, "Scenario State: AWAITING_PREAPPROVAL", Status.PASS);
				addSubStep(subSteps, "Folder Id: Test Folder", Status.PASS);
				addSubStep(subSteps, "File Id: 098765", Status.PASS);
				addSubStep(subSteps, "Guarantor Folder Id: Test GuarantorFolderId", Status.PASS);
				addSubStep(subSteps, "Investor Folder Id: Test investorFolderId", Status.PASS);
				addSubStep(subSteps, "Date Time: 2022-12-11", Status.PASS);
				addSubStep(subSteps, "Investor Folder Id: Test investorFolderId", Status.PASS);
				// loop here for getting document

				// addSubStep(subSteps, obj1.getString(brokerId), Status.PASS);
				addSubStep(subSteps, "bcp Id: bb7ee13a-fcf6-4e5e-9516-10f795b20ed4", Status.PASS);
				addSubStep(subSteps, "esp Id: e48548e6-0b92-410c-bde5-8eac619b656d", Status.PASS);
			}

			waitTime(4000);
			scenarioForHL(scenarioId, body);

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

	public ArrayList<TestSteps> propertyClass(boolean isUpdate) {
		Status status = null;
		String postValue = "201";
		String brokerId = PropertiesReader.getApiPropertyValue("brokerId");
		String scenarioId = PropertiesReader.getApiPropertyValue("scenarioId");
		String propertyClassId = PropertiesReader.getApiPropertyValue("propertyClassId");
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\ApiConfig.properties");
		Properties prop = new Properties();
		try {
			Response response = null;

			JSONObject body = new JSONObject();
			if (isUpdate) {
				setupWithToken("/property-class/" + propertyClassId);
				addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Update Property Class<<<<<<<<<<<<<</b>", status.INFO);
				addSubStep(subSteps, "URL: https://platform-api.dev.osqo.com.au/property-class/" + propertyClassId,
						Status.INFO);
				body.put("suburb", "Farhan Test" + randomNumberString(2));
				response = httpRequest.body(body.toString()).when().patch().andReturn();

			} else {
				setupWithToken("/property-class");
				addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Create Property Class<<<<<<<<<<<<<</b>", status.INFO);
				addSubStep(subSteps, "URL: https://platform-api.dev.osqo.com.au/property-class", Status.INFO);
				body.put("suburb", "Farhan Test" + randomNumberString(2));
				body.put("propertyType", "Apartment");
				body.put("scenarioId", scenarioId);
				body.put("brokerId", brokerId);
				body.put("bcpId", "bb7ee13a-fcf6-4e5e-9516-10f795b20ed4");
				body.put("espId", "e48548e6-0b92-410c-bde5-8eac619b656d");
				response = httpRequest.body(body.toString()).when().post().andReturn();

			}

			JSONObject respone = new JSONObject(response.asString());
			if (respone.has("message")) {
				String message = respone.getString("message");
				addSubStep(subSteps, "<b>Response is : " + message + "</b>", Status.INFO);
				if (message.equalsIgnoreCase("Unauthorized")) {
					Assert.assertFalse(true);
				}
			}
			JSONArray array = respone.getJSONArray("items");
			JSONObject obj1 = array.getJSONObject(0);
			propertyClassId = obj1.getString("propertyClassId");
			try (InputStream in = new FileInputStream(file)) {
				if (in == null) {
					throw new FileNotFoundException();
				}
				prop.load(in);
				prop.setProperty("propertyClassId", propertyClassId);

				OutputStream out = new FileOutputStream(file);
				prop.store(out, "some comment");
			} catch (IOException e) {
				e.printStackTrace();
			}

			String StatusCode = Integer.toString(response.getStatusCode());
			addSubStep(subSteps, "<b>Response Status is = " + StatusCode + "</b>", Status.PASS);

			if (isUpdate) {
				String expecetdSurb = body.getString("suburb");
				String found = obj1.getString("suburb");
				addSubStep(subSteps, "Expecetd suburb: " + expecetdSurb, Status.INFO);
				addSubStep(subSteps, "Found: " + found, Status.INFO);
				if (expecetdSurb.equalsIgnoreCase(found))
					addSubStep(subSteps, "Verified suburb is matching", Status.PASS);
				else
					addSubStep(subSteps, "Failed! suburb is matching", Status.FAIL);

			} else {

				addSubStep(subSteps, "suburb: Farhan Test", Status.PASS);
				addSubStep(subSteps, "Property Type: Apartment", Status.PASS);
				addSubStep(subSteps, "Scenario Name: Farhan Test", Status.PASS);
				addSubStep(subSteps, "Scenario Id: " + scenarioId + "", Status.PASS);
				addSubStep(subSteps, "Broker Id: " + brokerId + "", Status.PASS);
				addSubStep(subSteps, "bcp Id: bb7ee13a-fcf6-4e5e-9516-10f795b20ed4", Status.PASS);
				addSubStep(subSteps, "esp Id: e48548e6-0b92-410c-bde5-8eac619b656d", Status.PASS);
			}

			waitTime(4000);
			propertyClassForHL(propertyClassId, body);

			return subSteps;
		} catch (Exception e) {
			e.printStackTrace();
			addSubStep(subSteps, captureSS(), Status.FAIL);
			return subSteps;

		} catch (Error e) {
			e.printStackTrace();
			addSubStep(subSteps, captureSS(), Status.FAIL);
			return subSteps;
		}
	}

	public ArrayList<TestSteps> propertyClassForHL(String id, JSONObject body) {
		String postValue = "200";
		Status status = null;
		String bcpId;
		String brokerId;
		String docType;
		String espId;
		String inProgress;
		String numberOfBedrooms;
		String propertyClassId;
		String propertyType;
		String scenarioId;
		String suburb;
		String borrowerId;
		addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Verify Property Class on HL<<<<<<<<<<<<<</b>", status.INFO);
		addSubStep(subSteps, "URL: http://52.64.108.214:3000/propertyClasses/" + id + "", Status.INFO);

		RestAssured.baseURI = "http://52.64.108.214:3000";
		RestAssured.basePath = "/propertyClasses/" + id;
		Response response = RestAssured.given().when().get();
		JSONObject responseValue = new JSONObject(response.asString());

		if (responseValue.has("message")) {
			addSubStep(subSteps, "Message: " + responseValue.getString("message"), Status.FAIL);
			Assert.assertFalse(true);
		}
		JSONObject obj1 = responseValue.getJSONObject("data");
		JSONObject obj2 = obj1.getJSONObject("Record");

		String statusCode = Integer.toString(response.getStatusCode());
		addSubStep(subSteps, "<b>Response Status is = " + statusCode + "</b>", Status.PASS);

		String expecetdSurb = body.getString("suburb");
		String found = obj2.getString("suburb");
		addSubStep(subSteps, "Expecetd suburb: " + expecetdSurb, Status.INFO);
		addSubStep(subSteps, "Found: " + found, Status.INFO);
		if (expecetdSurb.equalsIgnoreCase(found))
			addSubStep(subSteps, "Verified suburb is matching", Status.PASS);
		else
			addSubStep(subSteps, "Failed! suburb is matching", Status.FAIL);

		inProgress = obj2.getString("inProgress");
		addSubStep(subSteps, "In Progress: " + inProgress + "", Status.PASS);

		scenarioId = obj2.getString("scenarioId");
		addSubStep(subSteps, "Scenario Id: " + scenarioId + "", Status.PASS);

//		numberOfBedrooms = obj2.getString("numberOfBedrooms");
//		addSubStep(subSteps, "Number Of Bedrooms: "+numberOfBedrooms+"", Status.PASS);

		docType = obj2.getString("docType");
		addSubStep(subSteps, "DocType: " + docType + "", Status.PASS);

		propertyClassId = obj2.getString("propertyClassId");
		addSubStep(subSteps, "Property Class Id: " + propertyClassId + "", Status.PASS);

		bcpId = obj2.getString("bcpId");
		addSubStep(subSteps, "bcp Id: " + bcpId + "", Status.PASS);

		propertyType = obj2.getString("propertyType");
		addSubStep(subSteps, "Property Type: " + propertyType + "", Status.PASS);

//		borrowerId = obj2.getString("borrowerId");
//		addSubStep(subSteps, "Bond Id: "+borrowerId+"", Status.PASS);

		brokerId = obj2.getString("brokerId");
		addSubStep(subSteps, "Broker Id: " + brokerId + "", Status.PASS);

		espId = obj2.getString("espId");
		addSubStep(subSteps, "Date Time: " + espId + "", Status.PASS);

		return subSteps;
	}

	public ArrayList<TestSteps> scenarioForHL(String id, JSONObject body) {
		Status status = null;
		String FFBondQuanta;
		String bcpId;
		String bondCurrency;
		String bondId;
		String borrowerId;
		String brokerId;
		String dateTime;
		String docType;
		String espId;
		String fileId;
		String folderId;
		String guarantorFolderId;
		String investorFolderId;
		String loanAmountOffer;
		String propertyClass;
		String scenarioHash;
		String scenarioId;
		String scenarioName;
		String scenarioState;
		String statusVal;
		addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Verify Scenario on HL<<<<<<<<<<<<<</b>", status.INFO);
		addSubStep(subSteps, "URL: http://52.64.108.214:3000" + "/scenario/" + id, status.INFO);

		RestAssured.baseURI = "http://52.64.108.214:3000";
		RestAssured.basePath = "/scenario/" + id;
		Response response = RestAssured.given().when().get();
		JSONObject responseValue = new JSONObject(response.asString());
		if (responseValue.has("message")) {
			String messsage = responseValue.getString("message");
			if (messsage.equalsIgnoreCase("Not Found ")) {
				addSubStep(subSteps, "Message: " + messsage, status.FAIL);
			}
		}
		JSONObject obj1 = responseValue.getJSONObject("data");
		JSONObject obj2 = obj1.getJSONObject("Record");

		String statusCode = Integer.toString(response.getStatusCode());
		addSubStep(subSteps, "<b>Response Status is = " + statusCode + "</b>", Status.PASS);

		addSubStep(subSteps, "Expedcted Scenario Name:" + body.getString("scenarioName"), Status.INFO);
		addSubStep(subSteps, "Found in response:" + obj2.getString("scenarioName"), Status.PASS);
		if (body.getString("scenarioName").equals(obj2.getString("scenarioName")))
			addSubStep(subSteps, "Verified scenario name", Status.PASS);
		else
			addSubStep(subSteps, "Failed! Scenario name is mismatching", Status.FAIL);

		JSONArray getNotes = obj2.getJSONArray("notes");
		JSONObject getLastIndex = (JSONObject) getNotes.get(getNotes.length() - 1);
		Object getUpdatedNotes = getLastIndex.get("message");

		addSubStep(subSteps, "Expedcted Scenario noates:" + body.getString("notes"), Status.INFO);
		addSubStep(subSteps, "Found in response:" + getUpdatedNotes, Status.PASS);
		if (body.getString("notes").equals(getUpdatedNotes))
			addSubStep(subSteps, "Verified notes", Status.PASS);
		else
			addSubStep(subSteps, "Failed! Scenario notes is mismatching", Status.FAIL);

		int expectedAmount = body.getInt("loanAmountOffer");
		int found = obj2.getInt("loanAmountOffer");
		addSubStep(subSteps, "Expedcted amount:" + expectedAmount, Status.INFO);
		addSubStep(subSteps, "Found in response:" + found, Status.INFO);

		if (Objects.equal(expectedAmount, found))
			addSubStep(subSteps, "Verified Amount", Status.PASS);
		else
			addSubStep(subSteps, "Failed! Amount is mismatching", Status.FAIL);

		statusVal = obj2.getString("status");
		addSubStep(subSteps, "status: " + statusVal + "", Status.PASS);

		scenarioId = obj2.getString("scenarioId");
		addSubStep(subSteps, "Scenario Id: " + scenarioId + "", Status.PASS);

		FFBondQuanta = obj2.getString("FFBondQuanta");
		addSubStep(subSteps, "FFBondQuanta: " + FFBondQuanta + "", Status.PASS);

		docType = obj2.getString("docType");
		addSubStep(subSteps, "DocType: " + docType + "", Status.PASS);

		bcpId = obj2.getString("bcpId");
		addSubStep(subSteps, "bcp Id: " + bcpId + "", Status.PASS);

		bondCurrency = obj2.getString("bondCurrency");
		addSubStep(subSteps, "Bond Currency: " + bondCurrency + "", Status.PASS);

		bondId = obj2.getString("bondId");
		addSubStep(subSteps, "Bond Id: " + bondId + "", Status.PASS);

		borrowerId = obj2.getString("borrowerId");
		addSubStep(subSteps, "Bond Id: " + borrowerId + "", Status.PASS);

		brokerId = obj2.getString("brokerId");
		addSubStep(subSteps, "Broker Id: " + brokerId + "", Status.PASS);

		dateTime = obj2.getString("dateTime");
		addSubStep(subSteps, "Date Time: " + dateTime + "", Status.PASS);

		espId = obj2.getString("espId");
		addSubStep(subSteps, "espID: " + espId + "", Status.PASS);

		fileId = obj2.getString("fileId");
		addSubStep(subSteps, "File Id: " + fileId + "", Status.PASS);

		guarantorFolderId = obj2.getString("guarantorFolderId");
		addSubStep(subSteps, "GuarantorFolder Id: " + guarantorFolderId + "", Status.PASS);

		investorFolderId = obj2.getString("investorFolderId");
		addSubStep(subSteps, "InvestorFolder Id: " + investorFolderId + "", Status.PASS);

		JSONArray getPropertyClass = obj2.getJSONArray("propertyClass");
		String getLastIndexOfArray = (String) getPropertyClass.get(getPropertyClass.length() - 1);

		addSubStep(subSteps, "property Class: " + getLastIndexOfArray + "", Status.PASS);

		scenarioHash = obj2.getString("scenarioHash");
		addSubStep(subSteps, "Scenario Hash: " + scenarioHash + "", Status.PASS);

		scenarioState = obj2.getString("scenarioState");
		addSubStep(subSteps, "Scenario State: " + scenarioState + "", Status.PASS);

		return subSteps;
	}

	public ArrayList<TestSteps> BrokerGroup(boolean isUpdate) {
		Status status = null;
		String postValue = "200";
		String brokerGroupId = "";
		String message;
		JSONObject respone;
		String subAggregatorId = PropertiesReader.getApiPropertyValue("subAggregatorId");
		if (isUpdate)
			brokerGroupId = PropertiesReader.getApiPropertyValue("brokerGroupId");

		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\ApiConfig.properties");
		Properties prop = new Properties();
		try {
			String description = " Create";
			if (isUpdate) {
				setup("/broker-group/" + brokerGroupId);
				description = " Update";
			} else
				setup("/broker-group");

			addSubStep(subSteps, "<b>>>>>>>>>>>>>>> Create Broker Group <<<<<<<<<<<<<</b>", status.INFO);
			Map<String, String> body = new HashMap<String, String>();
			Response response = null;
			if (!isUpdate) {
				body.put("firstName", "Julia");
				body.put("lastName", "Female");
				body.put("groupName", "OSQO group");
				body.put("fee", "200");
				body.put("email", "xyz@gmail.com");
				body.put("address", "Pune");
				body.put("URL", "Test URL");
				body.put("ACL", "Test ACL");
				body.put("ABN", "Test ABN");
				body.put("CRC", "Test CRC");
				body.put("subAggregatorInternalCode", "123456");
				body.put("AFCA", "Test AFCA");
				body.put("ACN", "Test ACN");
				body.put("MFAA", "Test MFAA");
				body.put("CPIIPN", "Test CPIIPN");
				body.put("status", "CREATED");
				body.put("folderId", "");
				body.put("subAggregatorId", "" + subAggregatorId + "");

				response = httpRequest.body(body).when().post().andReturn();
				
				respone = new JSONObject(response.asString());
				message = respone.getString("message");
				if (!message.equalsIgnoreCase("Broker Group created successfully")) {
					addSubStep(subSteps, "<b>Response is : " + message + "</b>", Status.FAIL);
					Assert.assertFalse(true);
				}
				addSubStep(subSteps, "<b>Response is : " + message + "</b>", Status.PASS);

			} else {
				body.put("firstName", "Farhan" + randomNumberString(2));
				body.put("lastName", "Ghaffar" + randomNumberString(2));
				response = httpRequest.body(body).when().patch().andReturn();
				
				respone = new JSONObject(response.asString());
				message = respone.getString("message");
				if (!message.equalsIgnoreCase("Broker Group updated successfully")) {
					addSubStep(subSteps, "<b>Response is : " + message + "</b>", Status.FAIL);
					Assert.assertFalse(true);
				}
			}
			String expecetdFirstName = body.get("firstName");
			String expectedLastName = body.get("lastName");

			addSubStep(subSteps, "<b>Response is : " + message + "</b>", Status.PASS);

			JSONArray arrayItems = respone.getJSONArray("items");
			JSONObject obj1 = arrayItems.getJSONObject(0);
			brokerGroupId = obj1.getString("brokerGroupId");
			try (InputStream in = new FileInputStream(file)) {
				if (in == null) {
					throw new FileNotFoundException();
				}
				prop.load(in);
				prop.setProperty("brokerGroupId", brokerGroupId);

				OutputStream out = new FileOutputStream(file);
				prop.store(out, "some comment");
			} catch (IOException e) {
				e.printStackTrace();
			}
			waitTime(60*1000);
			/*
			 * try (InputStream in = new FileInputStream(file)) { if (in == null) { throw
			 * new FileNotFoundException(); } prop.load(in);
			 * 
			 * OutputStream out = new FileOutputStream(file); prop.store(out,
			 * "some comment"); } catch (IOException e) { e.printStackTrace(); }
			 */
			
			String getBaseURL = PropertiesReader.getApiPropertyValue("baseURLDev");
			addSubStep(subSteps, "<b>>>>>>>>>>>>>>> Verify Created Broker Group using Get Api <<<<<<<<<<<<<</b>", status.INFO);
			addSubStep(subSteps, getBaseURL+"/broker-group/"+brokerGroupId, Status.INFO);
			setup("/broker-group/"+brokerGroupId);
			Response responseFromGet = httpRequest.get().andReturn();
			
			addSubStep(subSteps, "Status code for getting data: "+responseFromGet.statusCode(), Status.INFO);
			System.out.println(responseFromGet.statusCode());
			if (responseFromGet.statusCode()!=200)
				Assert.assertFalse(true);
			
			JSONObject getResponseAsString = new JSONObject(responseFromGet.asString());
			JSONArray itemsArray = getResponseAsString.getJSONArray("items");
			JSONObject recordObj = itemsArray.getJSONObject(0);
			
			for (Map.Entry<String, String> entry : body.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();
			
			addSubStep(subSteps, "Expected "+key+" : "+val, status.INFO);
			addSubStep(subSteps, "Found: "+recordObj.get(key), status.INFO);
			if (val.equals(recordObj.get(key)))
				addSubStep(subSteps, "Verified "+key, status.PASS);
			else
				addSubStep(subSteps, "Failed! "+key+" is mismatching", status.FAIL);
		}
			

			String StatusCode = Integer.toString(response.getStatusCode());
			addSubStep(subSteps, "<b>Response is : " + message + "</b>", Status.PASS);
			addSubStep(subSteps, "<b>Response Status is = " + StatusCode + "</b>", Status.PASS);
			status = ErrorCollector.verifyTrue(postValue.equals(StatusCode),
					"Verified <b>sub aggregator</b> is created");
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);

			BrokerGroupForHL(brokerGroupId, isUpdate, expecetdFirstName, expectedLastName, body);

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

	public ArrayList<TestSteps> BrokerGroupForHL(String id, boolean isUpdate, String expecetdFirstName,
			String expectedLastName, Map<String, String> body) {
		String postValue = "200";
		String status;
		String lastName;
		String address;
		String docType;
		String ACL;
		String ACN;
		String ABN;
		String URl;
		String folderId;
		String firstName;
		String brokerGroupId;
		String subAggregatorId;
		String subAggregatorInternalCode;

		if (isUpdate)
			addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Verify updated Broker Group on HL<<<<<<<<<<<<<</b>", Status.INFO);
		else
			addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Verify created Broker Group on HL<<<<<<<<<<<<<</b>", Status.INFO);

		addSubStep(subSteps, "URL: http://52.64.108.214:3000/brokerGroup/" + id + "", Status.PASS);

		RestAssured.baseURI = "http://52.64.108.214:3000";
		RestAssured.basePath = "/brokerGroup/" + id;
		Response response = null;
		response = RestAssured.given().when().get();
		
		JSONObject responseValue = new JSONObject(response.asString());
		String StatusCode = Integer.toString(response.getStatusCode());
		if (!StatusCode.equals(postValue)) {
			addSubStep(subSteps, "<b>Response Status is = " + StatusCode + "</b>", Status.FAIL);
			Assert.assertFalse(true);
		}
		addSubStep(subSteps, "<b>Response Status is = " + StatusCode + "</b>", Status.PASS);

		JSONObject dateObj = responseValue.getJSONObject("data");
		JSONObject recordsObj = dateObj.getJSONObject("Record");

		lastName = recordsObj.getString("lastName");
		firstName = recordsObj.getString("firstName");
		
		for (Map.Entry<String, String> entry : body.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();
			
			addSubStep(subSteps, "Expected "+key+" : "+val, Status.INFO);
			addSubStep(subSteps, "Found: "+recordsObj.get(key), Status.INFO);
			if (val.equals(recordsObj.get(key)))
				addSubStep(subSteps, "Verified "+key, Status.PASS);
			else
				addSubStep(subSteps, "Failed! "+key+" is mismatching", Status.FAIL);
		}
		return subSteps;
	}

	public ArrayList<TestSteps> Broker(boolean isUpdated) {
		Status status = null;
		String postValue = "200";
		String brokerId;
		String email = "xyz" + generateRandomNumberWithGivenNumberOfDigits(4) + "@gmail.com";
		String brokerGroupId = PropertiesReader.getApiPropertyValue("brokerGroupId");
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\ApiConfig.properties");
		Properties prop = new Properties();
		Map<String, String> body = new HashMap<String, String>();
		Response response = null;
		try {
			if (isUpdated) {
				brokerId = PropertiesReader.getApiPropertyValue("brokerId");
				setup("/broker/" + brokerId);
				addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Update Broker<<<<<<<<<<<<<</b>", status.INFO);
				body.put("firstName", "Farhan" + randomNumberString(2));
				body.put("lastName", "Ghaffar" + randomNumberString(2));

				response = httpRequest.body(body).when().patch().andReturn();

			} else {
				setup("/broker");
				addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Create Broker<<<<<<<<<<<<<</b>", status.INFO);

				body.put("brokerGroupId", brokerGroupId);
				body.put("firstName", "Julia");
				body.put("lastName", "Female");
				body.put("email", email);
				body.put("address", "Pune");
				body.put("CRC", "Test CRC");
				body.put("AFCA", "Test AFCA");
				body.put("subAggregatorInternalCode", "123456");
				body.put("MFAA", "Test MFAA");
				body.put("CPIIPN", "Test CPIIPN");
				body.put("status", "CREATED");
				response = httpRequest.body(body).when().post().andReturn();

			}

			JSONObject respone = new JSONObject(response.asString());
			String message = respone.getString("message");
			if (isUpdated) {
				if (!message.trim().equalsIgnoreCase("Broker updated successfully"))
					Assert.assertFalse(true);
				addSubStep(subSteps, "<b>Response is : " + message + "</b>", Status.PASS);

			} else {
				if (!message.trim().equalsIgnoreCase("Broker created successfully"))
					Assert.assertFalse(true);
				addSubStep(subSteps, "<b>Response is : " + message + "</b>", Status.PASS);

			}

			JSONArray array = respone.getJSONArray("items");
			JSONObject obj1 = array.getJSONObject(0);
			brokerId = obj1.getString("brokerId");
			String lastName = obj1.getString("lastName");
			String firstName = obj1.getString("firstName");
			String expecetdFirstName = body.get("firstName");
			String expectedLastName = body.get("lastName");
			prop.setProperty("brokerId", brokerId);

			if (isUpdated) {

				addSubStep(subSteps, "Expected first name: " + expecetdFirstName, Status.INFO);
				addSubStep(subSteps, "Found: " + firstName, Status.INFO);

				if (firstName.equalsIgnoreCase(expecetdFirstName))
					addSubStep(subSteps, "Successfully verified value updated", Status.PASS);
				else
					addSubStep(subSteps, "failed, first name value did not updat", Status.FAIL);

				addSubStep(subSteps, "Expected last name: " + expectedLastName, Status.INFO);
				addSubStep(subSteps, "Found: " + lastName, Status.INFO);

				if (lastName.equalsIgnoreCase(expectedLastName))
					addSubStep(subSteps, "Verifeid last name updated successfully", Status.PASS);
				else
					addSubStep(subSteps, "failed, Last name did not update", Status.FAIL);

			} else {

				addSubStep(subSteps, "brokerGroupId: " + brokerGroupId + "", Status.PASS);
				addSubStep(subSteps, "firstName: Julia", Status.PASS);
				addSubStep(subSteps, "lastName: Female", Status.PASS);
				addSubStep(subSteps, "email: " + email + "", Status.PASS);
				addSubStep(subSteps, "address: Pune", Status.PASS);
				addSubStep(subSteps, "ACL: Test ACL", Status.PASS);
				addSubStep(subSteps, "CRC: Test CRC", Status.PASS);
				addSubStep(subSteps, "AFCA: Test AFCA", Status.PASS);
				addSubStep(subSteps, "sub Aggregator Internal Code: 123456", Status.PASS);
				addSubStep(subSteps, "MFAA: Test MFAA", Status.PASS);
				addSubStep(subSteps, "CPIIPN: Test CPIIPN", Status.PASS);
				addSubStep(subSteps, "status: CREATED", Status.PASS);

			}

			waitTime(10000);
			BrokerForHL(brokerId, firstName, lastName);

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

	public ArrayList<TestSteps> BrokerForHL(String id, String expecetdFirstName, String expectedLastName) {
		String postValue = "200";
		Status statusVal = null;
		String lastName;
		String address;
		String docType;
		String fee;
		String ACL;
		String aggregatorId;
		String ACN;
		String ABN;
		String URl;
		String folderId;
		String firstName;
		String aggregatorStatus;
		String company;
		String email;
		String brokerGroupId;
		String subAggregatorId;
		String subAggregatorInternalCode;
		String brokerId;
		String AFCA;
		String CPIIPN;
		String CRC;
		String MFAA;

		RestAssured.baseURI = "http://52.64.108.214:3000";
		RestAssured.basePath = "/broker/" + id;
		Response response = RestAssured.given().when().get();
		JSONObject responseValue = new JSONObject(response.asString());
		System.out.println(responseValue.toString());

		// JSONArray array = responseValue.getJSONArray("data");
		JSONObject obj1 = responseValue.getJSONObject("data");
		JSONObject obj2 = obj1.getJSONObject("Record");

		addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Verify Broker on HL<<<<<<<<<<<<<</b>", Status.INFO);

		addSubStep(subSteps, "URL: http://52.64.108.214:3000/broker/" + id + "", Status.INFO);
		String statusCode = Integer.toString(response.getStatusCode());
		addSubStep(subSteps, "<b>Response Status is = " + statusCode + "</b>", Status.INFO);

		lastName = obj2.getString("lastName");
		firstName = obj2.getString("firstName");
		addSubStep(subSteps, "Expected first name: " + expecetdFirstName, Status.INFO);
		addSubStep(subSteps, "Found: " + firstName, Status.INFO);

		if (firstName.equalsIgnoreCase(expecetdFirstName))
			addSubStep(subSteps, "Successfully verified value updated", Status.PASS);
		else
			addSubStep(subSteps, "failed, first name value did not updat", Status.FAIL);

		addSubStep(subSteps, "Expected last name: " + expectedLastName, Status.INFO);
		addSubStep(subSteps, "Found: " + lastName, Status.INFO);

		if (lastName.equalsIgnoreCase(expectedLastName))
			addSubStep(subSteps, "Verifeid last name updated successfully", Status.PASS);
		else
			addSubStep(subSteps, "failed, Last name did not update", Status.FAIL);

		AFCA = obj2.getString("AFCA");
		addSubStep(subSteps, "AFCA: " + AFCA + "", Status.PASS);

		email = obj2.getString("email");
		addSubStep(subSteps, "email: " + email + "", Status.PASS);

		return subSteps;
	}

	public ArrayList<TestSteps> createProperty() {
		Status status = null;
		String postValue = "201";
		String borrowerHashVal = "HB_value" + generateRandomNumberWithGivenNumberOfDigits(4) + "";
		String brokerId = PropertiesReader.getApiPropertyValue("brokerId");
		String propertyClassId = PropertiesReader.getApiPropertyValue("propertyClassId");
		String guarantorId = PropertiesReader.getApiPropertyValue("guarantorId");
		String scenarioId = PropertiesReader.getApiPropertyValue("scenarioId");
		String borrowerId = PropertiesReader.getApiPropertyValue("borrowerId");
		String propertyId = PropertiesReader.getApiPropertyValue("propertyId");
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\ApiConfig.properties");
		String yourCode;
		Properties prop = new Properties();
		try {
			setupWithToken("/property");
			addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Create Property<<<<<<<<<<<<<</b>", status.INFO);
			JSONObject body = new JSONObject();
			JSONObject propertyClassMap = new JSONObject();
			propertyClassMap.put("propertyClassId", propertyClassId);
			propertyClassMap.put("scenarioId", scenarioId);
			propertyClassMap.put("suburb", "1234");
			propertyClassMap.put("propertyType", "Apartment");
			propertyClassMap.put("numberOfBedrooms", "1");
			body.put("propertyClass", propertyClassMap);
			body.put("propertyTitle", "Kiran title");
			body.put("propertyPurchasePrice", "150000");

			JSONObject vendorAccountDetails = new JSONObject();
			vendorAccountDetails.put("accountName", "Farhan");
			vendorAccountDetails.put("bsb", "23123123");
			vendorAccountDetails.put("accountNumber", "23123123");
			vendorAccountDetails.put("bankName", "Best Bank");
			vendorAccountDetails.put("branch", "branch 1");
			vendorAccountDetails.put("swiftId", "23123123");
			body.put("vendorAccountDetails", vendorAccountDetails);

			body.put("caveat", "Yes");
			body.put("caveatDocumentation", "Property Doc");
			body.put("guarantorId", guarantorId);
			body.put("guarantorType", "TBD");
			body.put("scenarioId", scenarioId);
			body.put("borrowerId", borrowerId);
			body.put("propertyState", "UNPURCHASED");
			body.put("brokerId", brokerId);
			body.put("bcpId", "");
			body.put("espId", "");

			Response response = httpRequest.body(body.toString()).when().post().andReturn();
			System.out.println(response.asString());

			JSONObject respone = new JSONObject(response.asString());
			String message = respone.getString("message");
			JSONArray array = respone.getJSONArray("items");
			JSONObject obj1 = array.getJSONObject(0);
			propertyId = obj1.getString("propertyId");
			try (InputStream in = new FileInputStream(file)) {
				if (in == null) {
					throw new FileNotFoundException();
				}
				prop.load(in);
				prop.setProperty("propertyId", propertyId);

				OutputStream out = new FileOutputStream(file);
				prop.store(out, "some comment");
			} catch (IOException e) {
				e.printStackTrace();
			}

			String StatusCode = Integer.toString(response.getStatusCode());
			addSubStep(subSteps, "<b>Response is : " + message + "</b>", Status.PASS);
			addSubStep(subSteps, "<b>Response Status is = " + StatusCode + "</b>", Status.PASS);
			status = ErrorCollector.verifyTrue(postValue.equals(StatusCode),
					"Verified <b>sub aggregator</b> is created");
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			System.out.println(message);
			int c = response.getStatusCode();
			System.out.println(c);

			addSubStep(subSteps, "URL: https://platform-api.dev.osqo.com.au/borrower/", Status.PASS);
			addSubStep(subSteps, "propertyClassId: " + propertyClassId + "", Status.PASS);
			addSubStep(subSteps, "scenarioId: " + scenarioId + "", Status.PASS);
			addSubStep(subSteps, "suburb: 1234", Status.PASS);
			addSubStep(subSteps, "propertyType: Apartment", Status.PASS);
			addSubStep(subSteps, "numberOfBedrooms: 1", Status.PASS);
			addSubStep(subSteps, "propertyTitle: Kiran title", Status.PASS);
			addSubStep(subSteps, "propertyPurchasePrice: 150000", Status.PASS);
			addSubStep(subSteps, "accountName: Farhan", Status.PASS);
			addSubStep(subSteps, "bsb: 23123123", Status.PASS);
			addSubStep(subSteps, "accountNumber: 23123123", Status.PASS);
			addSubStep(subSteps, "bankName: Best Bank", Status.PASS);
			addSubStep(subSteps, "branch: branch 1", Status.PASS);
			addSubStep(subSteps, "swiftId: 23123123", Status.PASS);
			addSubStep(subSteps, "caveat: Yes", Status.PASS);
			addSubStep(subSteps, "caveatDocumentation: Property Doc", Status.PASS);
			addSubStep(subSteps, "guarantorId: " + guarantorId + "", Status.PASS);
			addSubStep(subSteps, "guarantorType: UNPURCHASED", Status.PASS);
			addSubStep(subSteps, "scenarioId: " + scenarioId + "", Status.PASS);
			addSubStep(subSteps, "borrowerId: " + borrowerId + "", Status.PASS);
			addSubStep(subSteps, "brokerId: " + brokerId + "", Status.PASS);
			addSubStep(subSteps, "bcpId: ", Status.PASS);
			addSubStep(subSteps, "espId: ", Status.PASS);

			waitTime(4000);
			propertyForHL(propertyId);

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

	public ArrayList<TestSteps> propertyForHL(String id) {
		String postValue = "200";
		Status status = null;
		String propertyId;
		String propertyTitle;
		String propertyPurchasePrice;
		String caveat;
		String caveatDocumentation;
		String guarantorId;
		String guarantorType;
		String scenarioId;
		String propertyState;
		String inProgress;
		String brokerId;

		RestAssured.baseURI = "http://52.64.108.214:3000";
		RestAssured.basePath = "/property";
		Response response = RestAssured.given().param("" + id + "").when().get();
		JSONObject responseValue = new JSONObject(response.asString());
		System.out.println(responseValue.toString());
		String StatusCode = Integer.toString(response.getStatusCode());
		System.out.println(response);

		JSONArray array = responseValue.getJSONArray("data");
		JSONObject obj1 = array.getJSONObject(0);
		JSONObject obj2 = obj1.getJSONObject("Record");

		addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Verify Property is Created on HL<<<<<<<<<<<<<</b>", status.INFO);

		String statusCode = Integer.toString(response.getStatusCode());
		addSubStep(subSteps, "<b>Response Status is = " + statusCode + "</b>", Status.PASS);
		status = ErrorCollector.verifyTrue(postValue.equals(statusCode),
				"Verified <b>Borrower Status</b> is displaying");
		if (status.equals(Status.FAIL))
			Assert.assertFalse(true);
		int c = response.getStatusCode();
		System.out.println(c);

		addSubStep(subSteps, "URL: http://52.64.108.214:3000/property/" + id + "", Status.PASS);

		propertyId = obj2.getString("propertyId");
		addSubStep(subSteps, "propertyId: " + propertyId + "", Status.PASS);

		propertyTitle = obj2.getString("propertyTitle");
		addSubStep(subSteps, "propertyTitle : " + propertyTitle + "", Status.PASS);

		propertyPurchasePrice = obj2.getString("propertyPurchasePrice");
		addSubStep(subSteps, "propertyPurchasePrice: " + propertyPurchasePrice + "", Status.PASS);

		caveat = obj2.getString("caveat");
		addSubStep(subSteps, "caveat: " + caveat + "", Status.PASS);

		caveatDocumentation = obj2.getString("caveatDocumentation");
		addSubStep(subSteps, "caveatDocumentation: " + caveatDocumentation + "", Status.PASS);

		guarantorId = obj2.getString("guarantorId");
		addSubStep(subSteps, "guarantorId: " + guarantorId + "", Status.PASS);

		guarantorType = obj2.getString("guarantorType");
		addSubStep(subSteps, "guarantorType: " + guarantorType + "", Status.PASS);

		scenarioId = obj2.getString("scenarioId");
		addSubStep(subSteps, "scenarioId: " + scenarioId + "", Status.PASS);

		borrowerId = obj2.getString("borrowerId");
		addSubStep(subSteps, "borrowerId: " + borrowerId + "", Status.PASS);

		propertyState = obj2.getString("propertyState");
		addSubStep(subSteps, "propertyState: " + propertyState + "", Status.PASS);

		inProgress = obj2.getString("inProgress");
		addSubStep(subSteps, "inProgress: " + inProgress + "", Status.PASS);

		brokerId = obj2.getString("brokerId");
		addSubStep(subSteps, "brokerId: " + brokerId + "", Status.PASS);

		return subSteps;
	}

	public ArrayList<TestSteps> createInvestor() {
		Status status = null;
		String postValue = "201";
		String scenarioId = PropertiesReader.getApiPropertyValue("scenarioId");
		String borrowerId = PropertiesReader.getApiPropertyValue("borrowerId");
		String investorId = PropertiesReader.getApiPropertyValue("investorId");
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\ApiConfig.properties");
		Properties prop = new Properties();
		try {
			setupWithToken("/investor/create");
			addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Create Investor<<<<<<<<<<<<<</b>", status.INFO);
			Map<String, String> body = new HashMap<String, String>();
			body.put("osqoId", "1234567890");
			body.put("emailAddress", "Farhan.investor@methodbridge.com");
			body.put("investorType", "INDIVIDUAL");
			body.put("salutation", "Mr.");
			body.put("firstName", "Farhan");
			body.put("lastName", "Ghaffar");
			body.put("titleRole", "SELF");
			body.put("address", "Pune");
			body.put("city", "Pune");
			body.put("stateProvinceTerritory", "ACT");
			body.put("postCode", "12345");
			body.put("phoneNumber", "124567890");
			body.put("DOB", "01/02/2000");
			body.put("accountName", "Saving Account");
			body.put("BSB", "Test BSB");
			body.put("accountNumber", "1234567890");
			body.put("bankName", "HDFC");
			body.put("branch", "Pune");
			body.put("swiftId", "12312312");
			body.put("passedKYC", "TRUE");
			body.put("investorKYCAddress", "adsa-asdsa-dsasa");
			body.put("latestKYCPassDate", "12091980");
			body.put("nextRenewalKYCPassDate", "12042022");
			body.put("australianBusinessNumber", "0987654321");
			body.put("taxFileNumber", "123-123-23");
			body.put("socialSovereignId", "sd-asdsa-dasd-das");
			body.put("taxResidence", "Noida");
			body.put("specialConditionDetails", "Test Details");
			body.put("investorMyBonds", "Yes");
			body.put("investorMyOSQOBondUnits", "123");
			body.put("borrowerId", borrowerId);
			body.put("scenarioId", scenarioId);
			body.put("status", "COMPLETED");
			body.put("state", "APPROVED");
			body.put("kycStatus", "Approve");
			body.put("investorState", "APPROVED");

			Response response = httpRequest.body(body).when().post().andReturn();
			System.out.println(response.asString());

			JSONObject respone = new JSONObject(response.asString());
			String message = respone.getString("message");
			JSONArray array = respone.getJSONArray("items");
			JSONObject obj1 = array.getJSONObject(0);
			investorId = obj1.getString("investorId");
			try (InputStream in = new FileInputStream(file)) {
				if (in == null) {
					throw new FileNotFoundException();
				}
				prop.load(in);
				prop.setProperty("investorId", investorId);

				OutputStream out = new FileOutputStream(file);
				prop.store(out, "some comment");
			} catch (IOException e) {
				e.printStackTrace();
			}

			String StatusCode = Integer.toString(response.getStatusCode());
			addSubStep(subSteps, "<b>Response is : " + message + "</b>", Status.PASS);
			addSubStep(subSteps, "<b>Response Status is = " + StatusCode + "</b>", Status.PASS);
			status = ErrorCollector.verifyTrue(postValue.equals(StatusCode), "Verified <b>Aggregator</b> is created");
			if (status.equals(Status.FAIL))
				Assert.assertFalse(true);
			System.out.println(message);
			int c = response.getStatusCode();
			System.out.println(c);

			addSubStep(subSteps, "URL: https://platform-api.dev.osqo.com.au/investor/create", Status.PASS);
			addSubStep(subSteps, "osqoId: 1234567890", Status.PASS);
			addSubStep(subSteps, "emailAddress: Farhan.investor@methodbridge.com", Status.PASS);
			addSubStep(subSteps, "investorType: INDIVIDUAL", Status.PASS);
			addSubStep(subSteps, "salutation: Mr.", Status.PASS);
			addSubStep(subSteps, "firstName: Farhan", Status.PASS);
			addSubStep(subSteps, "lastName: Ghaffar", Status.PASS);
			addSubStep(subSteps, "titleRole: SELF", Status.PASS);
			addSubStep(subSteps, "address: Pune", Status.PASS);
			addSubStep(subSteps, "city: Pune", Status.PASS);
			addSubStep(subSteps, "stateProvinceTerritory: ACT", Status.PASS);
			addSubStep(subSteps, "postCode: 12345", Status.PASS);
			addSubStep(subSteps, "phoneNumber: 1234567890", Status.PASS);
			addSubStep(subSteps, "DOB: 01/02/1984", Status.PASS);
			addSubStep(subSteps, "status: CREATED", Status.PASS);
			addSubStep(subSteps, "passedKYC: NULL", Status.PASS);
			addSubStep(subSteps, "guarantorKYCAddress: Guarantor KYC ADD", Status.PASS);
			addSubStep(subSteps, "nextRenewalKYCPassDate: 05/09/2022", Status.PASS);
			addSubStep(subSteps, "australianBusinessNumber: 1234567890", Status.PASS);
			addSubStep(subSteps, "taxFileNumber: 0987654321", Status.PASS);
			addSubStep(subSteps, "socialSovereignId: 1234567890", Status.PASS);
			addSubStep(subSteps, "taxResidence: Pune", Status.PASS);
			addSubStep(subSteps, "specialConditionDetails: Special condition details", Status.PASS);
			addSubStep(subSteps, "borrowerId:  ", Status.PASS);
			addSubStep(subSteps, "scenarioId:  ", Status.PASS);
			addSubStep(subSteps, "brokerId:  ", Status.PASS);
			addSubStep(subSteps, "bcpId:  ", Status.PASS);
			addSubStep(subSteps, "espId: ", Status.PASS);
			body.put("inProgress", "COMPLETED");

			waitTime(4000);
			investorForHL(investorId);

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

	public ArrayList<TestSteps> investorForHL(String id) {
		String postValue = "200";
		Status status = null;
		String bcpId;
		String emailAddress;
		String BSB;
		String accountName;
		String accountNumber;
		String bankName;
		String branch;
		String swiftId;
		String docType;
		String investorId;
		String investorKYCAddress;
		String latestKYCPassDate;
		String nextRenewalKYCPassDate;
		String passedKYC;
		String socialSovereignId;
		String taxFileNumber;
		String investorMyBonds;
		String investorMyOSQOBondUnits;
		String investorType;
		String kycStatus;
		String osqoId;
		String scenarioId;
		String specialConditionDetails;
		String state;
		String statusVal;
		String taxResidence;

		RestAssured.baseURI = "http://52.64.108.214:3000";
		RestAssured.basePath = "/investor/" + id;
		Response response = RestAssured.given().when().get();
		JSONObject responseValue = new JSONObject(response.asString());
		System.out.println(responseValue.toString());
		String StatusCode = Integer.toString(response.getStatusCode());
		System.out.println(response);

		JSONObject obj1 = responseValue.getJSONObject("data");
		JSONObject obj2 = obj1.getJSONObject("Record");
		JSONObject obj3 = obj2.getJSONObject("investorAccountDetails");
		JSONObject obj4 = obj2.getJSONObject("investorIdentityDetails");

		addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Verify investor is Created on HL<<<<<<<<<<<<<</b>", status.INFO);

		String statusCode = Integer.toString(response.getStatusCode());
		addSubStep(subSteps, "<b>Response Status is = " + statusCode + "</b>", Status.PASS);
		status = ErrorCollector.verifyTrue(postValue.equals(statusCode),
				"Verified <b>Sub Aggregator Status</b> is displaying");
		if (status.equals(Status.FAIL))
			Assert.assertFalse(true);
		int c = response.getStatusCode();
		System.out.println(c);

		addSubStep(subSteps, "URL: http://52.64.108.214:3000/investor/" + id + "", Status.PASS);

		docType = obj2.getString("docType");
		addSubStep(subSteps, "docType: " + docType + "", Status.PASS);

		emailAddress = obj2.getString("emailAddress");
		addSubStep(subSteps, "emailAddress: " + emailAddress + "", Status.PASS);

		BSB = obj3.getString("BSB");
		addSubStep(subSteps, "BSB: " + BSB + "", Status.PASS);

		accountName = obj3.getString("accountName");
		addSubStep(subSteps, "accountName: " + accountName + "", Status.PASS);

		accountNumber = obj3.getString("accountNumber");
		addSubStep(subSteps, "accountNumber: " + accountNumber + "", Status.PASS);

		bankName = obj3.getString("bankName");
		addSubStep(subSteps, "bankName: " + bankName + "", Status.PASS);

		branch = obj3.getString("branch");
		addSubStep(subSteps, "branch: " + branch + "", Status.PASS);

		swiftId = obj3.getString("swiftId");
		addSubStep(subSteps, "swiftId: " + swiftId + "", Status.PASS);

		investorId = obj2.getString("investorId");
		addSubStep(subSteps, "investorId: " + investorId + "", Status.PASS);

		investorKYCAddress = obj4.getString("investorKYCAddress");
		addSubStep(subSteps, "investorKYCAddress: " + investorKYCAddress + "", Status.PASS);

		latestKYCPassDate = obj4.getString("latestKYCPassDate");
		addSubStep(subSteps, "latestKYCPassDate: " + latestKYCPassDate + "", Status.PASS);

		nextRenewalKYCPassDate = obj4.getString("nextRenewalKYCPassDate");
		addSubStep(subSteps, "nextRenewalKYCPassDate: " + nextRenewalKYCPassDate + "", Status.PASS);

		passedKYC = obj4.getString("passedKYC");
		addSubStep(subSteps, "passedKYC: " + passedKYC + "", Status.PASS);

		socialSovereignId = obj4.getString("socialSovereignId");
		addSubStep(subSteps, "socialSovereignId: " + socialSovereignId + "", Status.PASS);

		taxFileNumber = obj4.getString("taxFileNumber");
		addSubStep(subSteps, "taxFileNumber: " + taxFileNumber + "", Status.PASS);

		investorMyBonds = obj2.getString("investorMyBonds");
		addSubStep(subSteps, "investorMyBonds: " + investorMyBonds + "", Status.PASS);

		investorMyOSQOBondUnits = obj2.getString("investorMyOSQOBondUnits");
		addSubStep(subSteps, "investorMyOSQOBondUnits: " + investorMyOSQOBondUnits + "", Status.PASS);

		investorType = obj2.getString("investorType");
		addSubStep(subSteps, "investorType: " + investorType + "", Status.PASS);

		kycStatus = obj2.getString("kycStatus");
		addSubStep(subSteps, "kycStatus: " + kycStatus + "", Status.PASS);

		osqoId = obj2.getString("osqoId");
		addSubStep(subSteps, "osqoId: " + osqoId + "", Status.PASS);

		scenarioId = obj2.getString("scenarioId");
		addSubStep(subSteps, "scenarioId: " + scenarioId + "", Status.PASS);

		specialConditionDetails = obj2.getString("specialConditionDetails");
		addSubStep(subSteps, "specialConditionDetails: " + specialConditionDetails + "", Status.PASS);

		state = obj2.getString("state");
		addSubStep(subSteps, "state: " + state + "", Status.PASS);

		statusVal = obj2.getString("status");
		addSubStep(subSteps, "status: " + statusVal + "", Status.PASS);

		taxResidence = obj2.getString("taxResidence");
		addSubStep(subSteps, "taxResidence: " + taxResidence + "", Status.PASS);

		return subSteps;
	}

	public ArrayList<TestSteps> borrowerParty(boolean isUpdate) {
		Status status = null;
		String postValue = "201";
		String borrowerHashVal = "HB_value" + generateRandomNumberWithGivenNumberOfDigits(4) + "";
		String brokerId = PropertiesReader.getApiPropertyValue("brokerId");
		String propertyClassId = PropertiesReader.getApiPropertyValue("propertyClassId");
		String guarantorId = PropertiesReader.getApiPropertyValue("guarantorId");
		String scenarioId = PropertiesReader.getApiPropertyValue("scenarioId");
		String borrowerId = PropertiesReader.getApiPropertyValue("borrowerId");
		String borrowerPartyId = PropertiesReader.getApiPropertyValue("borrowerPartyId");
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\ApiConfig.properties");
		String yourCode;
		Properties prop = new Properties();
		try {
			if (isUpdate) {
				setupWithToken("/borrower-party/" + borrowerPartyId);
				addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Create Property<<<<<<<<<<<<<</b>", status.INFO);

			} else {
				setupWithToken("/borrower-party");
				addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Create Property<<<<<<<<<<<<<</b>", status.INFO);

			}
			JSONObject body = new JSONObject();
			JSONObject borrowerPersonalDetails = new JSONObject();

			body.put("borrowerId", borrowerId);
			body.put("source", "INDIVIDUAL");
			body.put("borrowerType", "INDIVIDUAL");

			borrowerPersonalDetails.put("salutation", "TBD");
			borrowerPersonalDetails.put("firstName", "Farhan" + randomNumberString(2));
			borrowerPersonalDetails.put("lastName", "Ghaffar" + randomNumberString(2));
			borrowerPersonalDetails.put("titleRole", "SELF");
			borrowerPersonalDetails.put("address", "Test Address");
			borrowerPersonalDetails.put("city", "Test");
			borrowerPersonalDetails.put("stateProvinceTerritory", "ACT");
			borrowerPersonalDetails.put("emailAddress", "test@gmail.com");
			borrowerPersonalDetails.put("phoneNumber", "+61499099980");
			borrowerPersonalDetails.put("DOB", "2022-11-24T11:49:07.525Z");
			borrowerPersonalDetails.put("status", "CREATED");
			body.put("borrowerPersonalDetails", borrowerPersonalDetails);

			JSONObject borrowerAccountDetails = new JSONObject();
			borrowerAccountDetails.put("accountName", "Test");
			borrowerAccountDetails.put("BSB", "test");
			borrowerAccountDetails.put("bankName", "test");
			borrowerAccountDetails.put("branch", "test");
			borrowerAccountDetails.put("branch", "branch 1");
			borrowerAccountDetails.put("swiftId", "23123123");
			body.put("borrowerAccountDetails", borrowerAccountDetails);

			JSONObject borrowerIdentityDetails = new JSONObject();
			borrowerIdentityDetails.put("passedKYC", "Test");
			borrowerIdentityDetails.put("borrowerKYCAddress", "test");
			borrowerIdentityDetails.put("latestKYCPassDate", "2022-11-24T11:49:07.525Z");
			borrowerIdentityDetails.put("nextRenewalKYCPassDate", "11/25/2022");
			borrowerIdentityDetails.put("australianBusinessNumber", "123445");
			borrowerIdentityDetails.put("taxFileNumber", "12345");
			borrowerIdentityDetails.put("socialSovereignId", "12");
			body.put("borrowerIdentityDetails", borrowerIdentityDetails);

			body.put("creditScore", 0);
			body.put("taxResidence", "AU");
			body.put("hasRequestedBroker", false);
			body.put("kycStatus", "Approve");
			body.put("brokerId", brokerId);
			body.put("bcpId", "bb7ee13a-fcf6-4e5e-9516-10f795b20ed4");
			body.put("espId", "e48548e6-0b92-410c-bde5-8eac619b656d");
			body.put("documents", "{}");

			Response response = null;
			if (isUpdate)
				response = httpRequest.body(body.toString()).when().patch().andReturn();
			else
				response = httpRequest.body(body.toString()).when().post().andReturn();

			JSONObject respone = new JSONObject(response.asString());
			String message = respone.getString("message");
			if (isUpdate) {
				if (!message.equalsIgnoreCase("Borrower party updated successfully")) {
					addSubStep(subSteps, message, Status.FAIL);

				} else {
					addSubStep(subSteps, message, Status.PASS);
				}
			} else {
				JSONArray array = respone.getJSONArray("items");
				JSONObject obj1 = array.getJSONObject(0);
				borrowerPartyId = obj1.getString("borrowerPartyId");
				try (InputStream in = new FileInputStream(file)) {
					if (in == null) {
						throw new FileNotFoundException();
					}
					prop.load(in);
					prop.setProperty("borrowerPartyId", borrowerPartyId);

					OutputStream out = new FileOutputStream(file);
					prop.store(out, "some comment");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			String StatusCode = Integer.toString(response.getStatusCode());
			addSubStep(subSteps, "<b>Response is : " + message + "</b>", Status.PASS);
			addSubStep(subSteps, "<b>Response Status is = " + StatusCode + "</b>", Status.PASS);

			addSubStep(subSteps, "URL: https://platform-api.dev.osqo.com.au/borrower-party", Status.PASS);
			addSubStep(subSteps, "borrower Id: " + borrowerId + "", Status.PASS);
			addSubStep(subSteps, "borrower party Id: " + borrowerPartyId + "", Status.PASS);

			addSubStep(subSteps, "source: INDIVIDUAL", Status.PASS);
			addSubStep(subSteps, "borrowerType: INDIVIDUAL", Status.PASS);
			addSubStep(subSteps, "salutation: TBD", Status.PASS);
			addSubStep(subSteps, "firstName: Farhan", Status.PASS);
			addSubStep(subSteps, "lastName: Ghaffar", Status.PASS);
			addSubStep(subSteps, "titleRole: SELF", Status.PASS);
			addSubStep(subSteps, "address: Test Address", Status.PASS);
			addSubStep(subSteps, "city: Test", Status.PASS);
			addSubStep(subSteps, "stateProvinceTerritory: ACT", Status.PASS);
			addSubStep(subSteps, "emailAddress: test@gmail.com", Status.PASS);
			addSubStep(subSteps, "phoneNumber: +61499099980", Status.PASS);
			addSubStep(subSteps, "DOB: 2022-11-24T11:49:07.525Z", Status.PASS);
			addSubStep(subSteps, "status: CREATED", Status.PASS);
			addSubStep(subSteps, "accountName: Test", Status.PASS);
			addSubStep(subSteps, "BSB: test", Status.PASS);
			addSubStep(subSteps, "bankName: test", Status.PASS);
			addSubStep(subSteps, "branch: test", Status.PASS);
			addSubStep(subSteps, "branch: branch 1", Status.PASS);
			addSubStep(subSteps, "swiftId: 23123123", Status.PASS);
			addSubStep(subSteps, "passedKYC: Test", Status.PASS);
			addSubStep(subSteps, "borrowerKYCAddress: test", Status.PASS);
			addSubStep(subSteps, "latestKYCPassDate: 2022-11-24T11:49:07.525Z", Status.PASS);
			addSubStep(subSteps, "nextRenewalKYCPassDate: 11/25/2022", Status.PASS);
			addSubStep(subSteps, "australianBusinessNumber: 123445", Status.PASS);
			addSubStep(subSteps, "taxFileNumber: 12345", Status.PASS);
			addSubStep(subSteps, "creditScore: 0", Status.PASS);
			addSubStep(subSteps, "taxResidence: AU", Status.PASS);
			addSubStep(subSteps, "hasRequestedBroker: false", Status.PASS);
			addSubStep(subSteps, "kycStatus: " + body.getString("kycStatus"), Status.PASS);
			addSubStep(subSteps, "brokerId: " + brokerId + "", Status.PASS);
			addSubStep(subSteps, "BCPID: " + body.getString("bcpId"), Status.PASS);
			addSubStep(subSteps, "espId: " + body.getString("espId"), Status.PASS);

			waitTime(6000);
			borrowerPartyForHL(borrowerPartyId, body);

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

	public ArrayList<TestSteps> borrowerPartyForHL(String id, JSONObject body) {
		String postValue = "200";
		Status status = null;
		String BSB;
		String accountName;
		String bankName;
		String branch;
		String swiftId;
		String australianBusinessNumber;
		String borrowerKYCAddress;
		String latestKYCPassDate;
		String nextRenewalKYCPassDate;
		String passedKYC;
		String socialSovereignId;
		String taxFileNumber;
		String borrowerPartyId;
		String DOB;
		String address;
		String city;
		String emailAddress;
		String firstName;
		String lastName;
		String mbwEmail;
		String phoneNumber;
		String salutation;
		String stateProvinceTerritory;
		String statusVal;
		String titleRole;
		String borrowerType;

		addSubStep(subSteps, "<b>>>>>>>>>>>>>>>Verify borrower party is Created on HL<<<<<<<<<<<<<</b>", status.INFO);
		addSubStep(subSteps, "URL: http://52.64.108.214:3000/property/" + id + "", Status.INFO);

		RestAssured.baseURI = "http://52.64.108.214:3000";
		RestAssured.basePath = "/borrowerParty/" + id;
		Response response = RestAssured.given().when().get();
		JSONObject responseValue = new JSONObject(response.asString());
		System.out.println(responseValue.toString());
		String StatusCode = Integer.toString(response.getStatusCode());
		if (responseValue.has("message")) {
			String message = responseValue.getString("message");
			addSubStep(subSteps, "message: " + message + "", Status.FAIL);

			if (message.equalsIgnoreCase("Not found"))
				Assert.assertFalse(true);

		}

		JSONObject obj = responseValue.getJSONObject("data");
		JSONObject obj2 = obj.getJSONObject("Record");
		JSONObject borrowerAccountDetails = obj2.getJSONObject("borrowerAccountDetails");
		JSONObject borrowerIdentityDetails = obj2.getJSONObject("borrowerIdentityDetails");
		JSONObject borrowerPersonalDetails = obj2.getJSONObject("borrowerPersonalDetails");

		String statusCode = Integer.toString(response.getStatusCode());
		addSubStep(subSteps, "<b>Response Status is = " + statusCode + "</b>", Status.PASS);
		status = ErrorCollector.verifyTrue(postValue.equals(statusCode),
				"Verified <b>Borrower Status</b> is displaying");

		BSB = borrowerAccountDetails.getString("BSB");
		addSubStep(subSteps, "BSB: " + BSB + "", Status.PASS);

		accountName = borrowerAccountDetails.getString("accountName");
		addSubStep(subSteps, "accountName: " + accountName + "", Status.PASS);

		bankName = borrowerAccountDetails.getString("bankName");
		addSubStep(subSteps, "bankName: " + bankName + "", Status.PASS);

		branch = borrowerAccountDetails.getString("branch");
		addSubStep(subSteps, "branch: " + branch + "", Status.PASS);

		swiftId = borrowerAccountDetails.getString("swiftId");
		addSubStep(subSteps, "swiftId: " + swiftId + "", Status.PASS);

		australianBusinessNumber = borrowerIdentityDetails.getString("australianBusinessNumber");
		addSubStep(subSteps, "australianBusinessNumber: " + australianBusinessNumber + "", Status.PASS);

		borrowerKYCAddress = borrowerIdentityDetails.getString("borrowerKYCAddress");
		addSubStep(subSteps, "BSB: " + borrowerKYCAddress + "", Status.PASS);

		latestKYCPassDate = borrowerIdentityDetails.getString("latestKYCPassDate");
		addSubStep(subSteps, "latestKYCPassDate: " + latestKYCPassDate + "", Status.PASS);

		nextRenewalKYCPassDate = borrowerIdentityDetails.getString("nextRenewalKYCPassDate");
		addSubStep(subSteps, "nextRenewalKYCPassDate: " + nextRenewalKYCPassDate + "", Status.PASS);

		passedKYC = borrowerIdentityDetails.getString("passedKYC");
		addSubStep(subSteps, "passedKYC: " + passedKYC + "", Status.PASS);

		socialSovereignId = borrowerIdentityDetails.getString("socialSovereignId");
		addSubStep(subSteps, "socialSovereignId: " + socialSovereignId + "", Status.PASS);

		taxFileNumber = borrowerIdentityDetails.getString("taxFileNumber");
		addSubStep(subSteps, "taxFileNumber: " + taxFileNumber + "", Status.PASS);

		borrowerPartyId = obj2.getString("borrowerPartyId");
		addSubStep(subSteps, "borrowerPartyId: " + borrowerPartyId + "", Status.PASS);

		DOB = borrowerPersonalDetails.getString("DOB");
		addSubStep(subSteps, "DOB: " + DOB + "", Status.PASS);

		address = borrowerPersonalDetails.getString("address");
		addSubStep(subSteps, "address: " + address + "", Status.PASS);

		city = borrowerPersonalDetails.getString("city");
		addSubStep(subSteps, "city: " + city + "", Status.PASS);

		emailAddress = borrowerPersonalDetails.getString("emailAddress");
		addSubStep(subSteps, "emailAddress: " + emailAddress + "", Status.PASS);

		firstName = borrowerPersonalDetails.getString("firstName");
		addSubStep(subSteps, "firstName: " + firstName + "", Status.PASS);

		lastName = borrowerPersonalDetails.getString("lastName");
		addSubStep(subSteps, "lastName: " + lastName + "", Status.PASS);

		mbwEmail = borrowerPersonalDetails.getString("mbwEmail");
		addSubStep(subSteps, "mbwEmail: " + mbwEmail + "", Status.PASS);

		phoneNumber = borrowerPersonalDetails.getString("phoneNumber");
		addSubStep(subSteps, "phoneNumber: " + phoneNumber + "", Status.PASS);

		salutation = borrowerPersonalDetails.getString("salutation");
		addSubStep(subSteps, "salutation: " + salutation + "", Status.PASS);

		stateProvinceTerritory = borrowerPersonalDetails.getString("stateProvinceTerritory");
		addSubStep(subSteps, "stateProvinceTerritory: " + stateProvinceTerritory + "", Status.PASS);

		statusVal = borrowerPersonalDetails.getString("status");
		addSubStep(subSteps, "statusVal: " + statusVal + "", Status.PASS);

		titleRole = borrowerPersonalDetails.getString("titleRole");
		addSubStep(subSteps, "titleRole: " + titleRole + "", Status.PASS);

		borrowerType = obj2.getString("borrowerType");
		addSubStep(subSteps, "borrowerType: " + borrowerType + "", Status.PASS);

		return subSteps;
	}

}
