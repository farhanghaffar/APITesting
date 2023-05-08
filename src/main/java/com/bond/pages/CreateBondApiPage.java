package com.bond.pages;

import org.json.JSONObject;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import com.bond.base.BaseClass;
import com.bond.base.PropertiesReader;
import com.bond.errorCollectors.ErrorCollector;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;


public class CreateBondApiPage extends BaseClass {
	
	 public static String apiStatusMsg;
	 public static String apiStatusCode;

	CreateBondPage syncSubmissionPage = new CreateBondPage();
	String apiBaseUrl = PropertiesReader.getPropertyValue(env + "_ApiBaseUrl");
	String token = PropertiesReader.getPropertyValue(env + "_token");

	public CreateBondApiPage() {
		PageFactory.initElements(driver, this);
	}

	public Status APPROVED_PREAPPROVAL(String id) {

		try {

			RestAssured.baseURI = apiBaseUrl;
			RequestSpecification requestSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
					.build();

			Header header = new Header("Authorization", "Bearer " + token);

			JSONObject payload = new JSONObject();
			payload.put("scenarioState", "APPROVED_PREAPPROVAL");

			JSONObject response = new JSONObject(
					RestAssured.given().given().log().all().spec(requestSpec).header(header).body(payload.toString())
							.patch("/scenario/" + id + "/state").andReturn().asString());

			System.out.println(response.getString("message"));
			
			apiStatusMsg = response.getString("message");	
			
			System.out.println(RestAssured.given().given().log().all().spec(requestSpec).header(header)
					.body(payload.toString()).patch("/scenario/" + id + "/state").andReturn().asString());

			
			ErrorCollector.verifyTrue(syncSubmissionPage.verifyMessageFromApi(response.getString("message")),
					" : Verify Sucessful <b>'Approved Pre Approval'</b>: " + response.getString("message"));
			
			System.out.println(apiStatusMsg);
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}catch (Error e) {
			return Status.FAIL;
		}

	}

	public Status APPROVED_PREAPPROVAL_SECOND(String id) {
		try {

			RestAssured.baseURI = apiBaseUrl;

			RequestSpecification requestSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
					.build();

			Header header = new Header("Authorization", "Bearer " + token);

			JSONObject payload = new JSONObject();
			payload.put("scenarioState", "APPROVED_PREAPPROVAL");

			JSONObject response = new JSONObject(
					RestAssured.given().given().log().all().spec(requestSpec).header(header).body(payload.toString())
							.patch("/scenario/" + id + "/state").andReturn().asString());

			System.out.println(response.getInt("statusCode"));
			
			apiStatusMsg = response.getString("message");	

			ErrorCollector.verifyTrue(syncSubmissionPage.verifyStatusCode(response.getInt("statusCode")),
					" : Verify the <b>'Status Code'</b>:" + response.getInt("statusCode"));

			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}catch (Error e) {
			return Status.FAIL;
		}

	}

	public Status PASSEDPRELIM_CONAPPROVAL(String id) {
		try {

			RestAssured.baseURI = apiBaseUrl;

			RequestSpecification requestSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
					.build();

			Header header = new Header("Authorization", "Bearer " + token);

			JSONObject payload = new JSONObject();
			payload.put("scenarioState", "PASSEDPRELIM_CONAPPROVAL");
			payload.put("notes", "");

			JSONObject response = new JSONObject(
					RestAssured.given().given().log().all().spec(requestSpec).header(header).body(payload.toString())
							.patch("/scenario/" + id + "/state").andReturn().asString());

			System.out.println(response.getString("message"));
			
			apiStatusMsg = response.getString("message");	
			
			System.out.println(RestAssured.given().given().log().all().spec(requestSpec).header(header)
					.body(payload.toString()).patch("/scenario/" + id + "/state").andReturn().asString());

			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}catch (Error e) {
			return Status.FAIL;
		}

	}

	public Status KYC_APPROVAL() {
		try {
			String HomeBuyerPartyId = syncSubmissionPage.homeBuyerPartyId();
			RestAssured.baseURI = apiBaseUrl;

			RequestSpecification requestSpec5 = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
					.build();

			Header header = new Header("Authorization", "Bearer " + token);

			JSONObject payload = new JSONObject();
//			payload.put("homeBuyerPartyId", HomeBuyerPartyId);
			payload.put("kycParameters", "test");
			payload.put("kycStatus", "Approve");
			JSONObject response = new JSONObject(
					RestAssured.given().given().log().all().spec(requestSpec5).header(header).body(payload.toString())
							.patch("/borrower-party/" + HomeBuyerPartyId + "/kyc").andReturn().asString());

			System.out.println(response.getString("message"));
			
			apiStatusMsg = response.getString("message");	
			
			System.out.println(
					RestAssured.given().given().log().all().spec(requestSpec5).header(header).body(payload.toString())
							.patch("/home-buyer-party/" + HomeBuyerPartyId + "/kyc").andReturn().asString());
			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}catch (Error e) {
			return Status.FAIL;
		}

	}

	public Status PASSEDKYC_CONAPPROVAL(String scenarioId) {

		try {

			RestAssured.baseURI = apiBaseUrl;

			RequestSpecification requestSpec4 = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
					.build();

			Header header = new Header("Authorization", "Bearer " + token);

			JSONObject payload4 = new JSONObject();
			payload4.put("scenarioState", "PASSEDKYC_CONAPPROVAL");
			payload4.put("notes", "");

			JSONObject response = new JSONObject(
					RestAssured.given().given().log().all().spec(requestSpec4).header(header).body(payload4.toString())
							.patch("/scenario/" + scenarioId + "/state").andReturn().asString());

			System.out.println(response.getString("message"));
			
			apiStatusMsg = response.getString("message");	
			
			System.out.println(RestAssured.given().given().log().all().spec(requestSpec4).header(header)
					.body(payload4.toString()).patch("/scenario/" + scenarioId + "/state").andReturn().asString());

			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}catch (Error e) {
			return Status.FAIL;
		}

	}
	
	public Status KYC_APPROVAL_BondBuyer() {
		try {

			String bondbuyerId = syncSubmissionPage.bondbuyerId();
			RestAssured.baseURI = apiBaseUrl;

			RequestSpecification requestSpec5 = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
					.build();

			Header header = new Header("Authorization", "Bearer " + token);

			JSONObject payload5 = new JSONObject();
			payload5.put("bondBuyerId", bondbuyerId);
			payload5.put("kycParameters", "test");
			payload5.put("kycStatus", "Approve");
			JSONObject response = new JSONObject(
					RestAssured.given().given().log().all().spec(requestSpec5).header(header).body(payload5.toString())
							.patch("/bond-buyer/" + bondbuyerId + "/kyc").andReturn().asString());

			System.out.println(response.getString("message"));
			
			apiStatusMsg = response.getString("message");	
			
			System.out.println(
					RestAssured.given().given().log().all().spec(requestSpec5).header(header).body(payload5.toString())
							.patch("/bond-buyer/" + bondbuyerId + "/kyc").andReturn().asString());

			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}catch (Error e) {
			return Status.FAIL;
		}

	}
	
	public Status APPROVED_CONAPPROVAL(String id) {
		try {

			RestAssured.baseURI = apiBaseUrl;

			RequestSpecification requestSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
					.build();

			Header header = new Header("Authorization", "Bearer " + token);

			JSONObject payload = new JSONObject();
			payload.put("scenarioState", "APPROVED_CONAPPROVAL");

			JSONObject response = new JSONObject(
					RestAssured.given().given().log().all().spec(requestSpec).header(header).body(payload.toString())
							.patch("/scenario/" + id + "/state").andReturn().asString());

			System.out.println(response.getString("message"));
			
			apiStatusMsg = response.getString("message");	
			
			System.out.println(RestAssured.given().given().log().all().spec(requestSpec).header(header)
					.body(payload.toString()).patch("/scenario/" + id + "/state").andReturn().asString());

			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}catch (Error e) {
			return Status.FAIL;
		}

	}
	
	public Status PRE_APPROVAL_LETTER_Upload(String scenarioId) {

		try {

			RestAssured.baseURI = apiBaseUrl;

			RequestSpecification requestSpec4 = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
					.build();

			Header header = new Header("Authorization", "Bearer " + token);

			JSONObject payload4 = new JSONObject();
			payload4.put("PRE_APPROVAL_LETTER", "(binary)");
			payload4.put("scenarioId", scenarioId);

			JSONObject response = new JSONObject(
					RestAssured.given().given().log().all().spec(requestSpec4).header(header).body(payload4.toString())
							.patch("/development/" + scenarioId + "/upload-documents").andReturn().asString());

			System.out.println(response.getString("message"));
			
			apiStatusMsg = response.getString("message");	
			
			System.out.println(RestAssured.given().given().log().all().spec(requestSpec4).header(header)
					.body(payload4.toString()).patch("/development/" + scenarioId + "/upload-documents").andReturn().asString());

			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}catch (Error e) {
			return Status.FAIL;
		}

	}

	
	public Status ESP_STEP4_COMPLETED_SubmitButton(String scenarioId) {

		try {

			RestAssured.baseURI = apiBaseUrl;

			RequestSpecification requestSpec4 = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
					.build();

			Header header = new Header("Authorization", "Bearer " + token);

			JSONObject payload4 = new JSONObject();
			payload4.put("scenarioState", "ESP_STEP4_COMPLETED");

			JSONObject response = new JSONObject(
					RestAssured.given().given().log().all().spec(requestSpec4).header(header).body(payload4.toString())
							.patch("/scenario/" + scenarioId + "/state").andReturn().asString());

			System.out.println(response.getString("message"));
			
			apiStatusMsg = response.getString("message");	
			
			System.out.println(RestAssured.given().given().log().all().spec(requestSpec4).header(header)
					.body(payload4.toString()).patch("/scenario/" + scenarioId + "/state").andReturn().asString());

			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}catch (Error e) {
			return Status.FAIL;
		}

	}

	public Status GET_BCP_TOKEN() {

		try {

			RestAssured.baseURI = apiBaseUrl;

			RequestSpecification requestSpec4 = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
					.build();
//
//			Header header = new Header("Authorization", "Bearer " + token);

			JSONObject payload4 = new JSONObject();
			payload4.put("scenarioState", "PASSEDKYC_CONAPPROVAL");
			payload4.put("notes", "");

//			JSONObject response = new JSONObject(
//					RestAssured.given().given().log().all().spec(requestSpec4).body(payload4.toString())
//							.patch("/scenario/" + scenarioId + "/state").andReturn().asString());
//
//			System.out.println(response.getString("message"));
//			
//			apiStatusMsg = response.getString("message");	
//			
//			System.out.println(RestAssured.given().given().log().all().spec(requestSpec4).header(header)
//					.body(payload4.toString()).patch("/scenario/" + scenarioId + "/state").andReturn().asString());

			return Status.PASS;
		} catch (Exception e) {
			return Status.FAIL;
		}catch (Error e) {
			return Status.FAIL;
		}

	}


}
