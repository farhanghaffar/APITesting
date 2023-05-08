package com.bond.api.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.jaxen.expr.Step;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.bond.base.BaseClass;
import com.bond.base.PropertiesReader;
import com.bond.errorCollectors.ErrorCollector;
import com.bond.pages.DashboardPage;
import com.bond.pages.LoginPage;
import com.bond.pages.LogoutPage;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import net.bytebuddy.asm.Advice.OnDefaultValue;

public class TestDashboard extends BaseClass {
	LoginPage lp;
	DashboardPage dashboardPage;

	@Test(groups = { "API" })
	public void Test_Scenarios_API() throws IOException {

		HashMap<Integer, String> scenarioHashMap = new HashMap<>();
		HashMap<Integer, String> homeBuyerHashMap = new HashMap<>();
		HashMap<Integer, String> homeBuyerNameMap = new HashMap<>();
		HashMap<Integer, String> homeBuyerEmailAddressMap = new HashMap<>();
		HashMap<Integer, String> scenarioStateMap = new HashMap<>();
		String totalEntriesList = "";

		RestAssured.baseURI = "https://xmgf6lbi96.execute-api.ap-southeast-2.amazonaws.com/development";

		RequestSpecification requestSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
				.build();

		Header header = new Header("Authorization",
				"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYyOGNlMmVjNzU1ZjE1ZTRlOTNjY2EzZCIsImVtYWlsIjoiYWRtaW5iY3BAb3Nxby5jb20iLCJyb2xlIjoiQkNQIiwiaWF0IjoxNjU0MDg0NTk3LCJleHAiOjE2NTQwODQ2NTd9.xyhdcGPhD0_w_om795a6oRBV7OqN61lszrHH3mGBPgY");

		JSONObject payload = new JSONObject();
		payload.put("length", 30);
		payload.put("start", 0);
		payload.put("searchd", new JSONArray("[string]"));
		payload.put("columns", new JSONArray("[string]"));
		payload.put("order", new JSONArray("[string]"));

		JSONObject response = new JSONObject(RestAssured.given().given().log().all().spec(requestSpec).header(header)
				.body(payload.toString()).post("/scenario/list").andReturn().asString());
		System.out.println(RestAssured.given().given().log().all().spec(requestSpec).header(header)
				.body(payload.toString()).post("/scenario/list").andReturn().asString());

		JSONArray itemsArray = response.getJSONArray("items");
		for (int i = 0; i < itemsArray.length(); i++) {
			JSONObject item = itemsArray.getJSONObject(i);
			scenarioHashMap.put(i, item.getString("scenarioHash"));
			System.out.println(scenarioHashMap.get(i));
			homeBuyerHashMap.put(i, item.getString("homeBuyerHash"));
			System.out.println(homeBuyerHashMap.get(i));
//	    	homeBuyerNameMap.values().remove(null);
			try {
				homeBuyerNameMap.put(i, item.getString("homeBuyerName"));
				System.out.println(homeBuyerNameMap.get(i));
			} catch (Exception e) {
				homeBuyerNameMap.put(i, "-");
				System.out.println(homeBuyerNameMap.get(i));
			}
			try {
				homeBuyerEmailAddressMap.put(i, item.getString("emailAddress"));
				System.out.println(homeBuyerEmailAddressMap.get(i));

			} catch (Exception e) {
				homeBuyerEmailAddressMap.put(i, "");
			}
			
			try {
			scenarioStateMap.put(i, item.getString("scenarioState"));
			System.out.println(scenarioStateMap.get(i));
			} catch (Exception e) {
				scenarioStateMap.put(i, "");
			}

//	    	totalEntriesList = item.getString("total");
//	    	System.out.println(totalEntriesList);
		}

		initConfiguration();
		lp = new LoginPage();
		dashboardPage = new DashboardPage();
		ErrorCollector.extentLogInfo("Step 1 : Visit web url");
		openURL("AppURL");

		ErrorCollector.extentLogInfo("Step 2 : Click on login button");
		lp.clickOnLoginButton();

		String email = PropertiesReader.getPropertyValue(env + "_EmailId");
		ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
		lp.enterEmail(email);

		String pass = PropertiesReader.getPropertyValue(env + "_Password");
		ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
		lp.enterPassword(pass);

		ErrorCollector.extentLogInfo("Step 5 : Click on 'Login' button");
		lp.clickOnLoginButton();

//		ErrorCollector.extentLogInfo("Step 6 : Verify User 'Login Successfully message' is displaying");
//		ErrorCollector.verifyTrue(lp.isUserDashboardDisplaying(),
//				"Verified User Login Successfully message is displaying");

		ErrorCollector.extentLogInfo("Step 7 : Click on Navigation Menu 'Scenarios' button");
		dashboardPage.clickOnMenuScenariosButton();

//		ErrorCollector.extentLogInfo("Step 8 : Verify 'Synchronized Scenarios' Title is displaying");
//		ErrorCollector.verifyTrue(dashboardPage.isTitleSynchronizedScenariosDisplaying(), "Verified 'Synchronized Scenarios' Title is displaying");

		ErrorCollector.extentLogInfo("Step 7 : select '50' Entries to show");
		dashboardPage.select50Entries();
		System.out.println(scenarioHashMap.size());
		for (int i = 0; i < scenarioHashMap.size(); i++) {
			ErrorCollector.extentLogInfo("<b>Row Number: "+ i+"</b>");
			System.out.println(scenarioHashMap.get(i));
			System.out.println(dashboardPage.getScenarioHashItem(i));
			ErrorCollector.extentLogInfo("Step 7 : Verify API response Scenario Hash <b>value:" + scenarioHashMap.get(i)
					+ "</b> and Scenario Hash <b>value:" + dashboardPage.getScenarioHashItem(i) + "</b> are equal");
			ErrorCollector.verifyEquals(dashboardPage.getScenarioHashItem(i), scenarioHashMap.get(i),
					"API response Scenario Hash value" + scenarioHashMap.get(i) + " and Scenario Hash value:"
							+ dashboardPage.getScenarioHashItem(i) + " are equal");
			
			
			
			System.out.println(homeBuyerHashMap.get(i));
			System.out.println(dashboardPage.getHomeBuyerHash(i));
			ErrorCollector.extentLogInfo("Step 7 : Verify API response Home Buyer Hash <b>value:"
					+ homeBuyerHashMap.get(i) + "</b> and Home Buyer Hash <b>value:" + dashboardPage.getHomeBuyerHash(i)
					+ "</b> are equal");
			ErrorCollector.verifyEquals(dashboardPage.getHomeBuyerHash(i), homeBuyerHashMap.get(i),
					"API response Home Buyer Hash <b>value:" + homeBuyerHashMap.get(i)
							+ "</b> and Home Buyer Hash <b>value:" + dashboardPage.getHomeBuyerHash(i)
							+ "</b> are equal");
			
			
			
			System.out.println(homeBuyerNameMap.get(i));
			System.out.println(dashboardPage.getHomeBuyerName(i));
			ErrorCollector.extentLogInfo("Step 7 : Verify API response Home Buyer Name <b>value:"
					+ homeBuyerNameMap.get(i) + "</b> and Home Buyer Name <b>value:" + dashboardPage.getHomeBuyerName(i)
					+ "</b> are equal");
			ErrorCollector.verifyEquals(dashboardPage.getHomeBuyerName(i), homeBuyerNameMap.get(i),
					"API response Home Buyer Name value" + homeBuyerNameMap.get(i) + " and Home Buyer Name value:"
							+ dashboardPage.getHomeBuyerName(i) + " are equal");
			
			System.out.println(homeBuyerEmailAddressMap.get(i));
			System.out.println(dashboardPage.getHomeBuyerEmail(i));
			ErrorCollector.extentLogInfo("Step 7 : Verify API response home Buyer <b>Email Address:"
					+ homeBuyerEmailAddressMap.get(i) + "</b> and home Buyer <b>Email Address :"
					+ dashboardPage.getHomeBuyerEmail(i) + "</b> are equal");
			ErrorCollector.verifyEquals(dashboardPage.getHomeBuyerEmail(i), homeBuyerEmailAddressMap.get(i),
					"API response home Buyer <b>Email Address" + homeBuyerEmailAddressMap.get(i)
							+ "</b> and home Buyer <b>Email Address:" + dashboardPage.getHomeBuyerEmail(i)
							+ "</b> are equal");
			
			System.out.println(scenarioStateMap.get(i));
			System.out.println(dashboardPage.getScenarioState(i));
			ErrorCollector.extentLogInfo("Step 7 : Verify API response Scenario State <b>value:"
					+ scenarioStateMap.get(i) + "</b> and Scenario State <b>value:" + dashboardPage.getScenarioState(i)
					+ "</b> are equal");
			ErrorCollector.verifyEquals(dashboardPage.getScenarioState(i), scenarioStateMap.get(i),
					"API response home Buyer <b>Scenario State" + scenarioStateMap.get(i)
							+ "</b> and Scenario State <b>value:" + dashboardPage.getScenarioState(i)
							+ "</b> are equal");
			System.out.println("count :" + i);
//			if (i == 19) {
//				dashboardPage.clickOnNavigationScondButton();
//				waitTime(14000);
//			}
		}
	}
	
	
	@Test(groups = { "API" })
	public void Test_Personal_Data_API() throws IOException {

		HashMap<Integer, String> scenarioHashMap = new HashMap<>();
		HashMap<Integer, String> homeBuyerHashMap = new HashMap<>();
		HashMap<Integer, String> homeBuyerNameMap = new HashMap<>();
		HashMap<Integer, String> homeBuyerEmailAddressMap = new HashMap<>();
		HashMap<Integer, String> scenarioStateMap = new HashMap<>();
		String totalEntriesList = "";

		RestAssured.baseURI = "https://xmgf6lbi96.execute-api.ap-southeast-2.amazonaws.com/development";

		RequestSpecification requestSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
				.build();

		Header header = new Header("Authorization",
				"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYyOGNlMmVjNzU1ZjE1ZTRlOTNjY2EzZCIsImVtYWlsIjoiYWRtaW5iY3BAb3Nxby5jb20iLCJyb2xlIjoiQkNQIiwiaWF0IjoxNjU0MDg0NTk3LCJleHAiOjE2NTQwODQ2NTd9.xyhdcGPhD0_w_om795a6oRBV7OqN61lszrHH3mGBPgY");

		JSONObject payload = new JSONObject();
		payload.put("length", 20);
		payload.put("start", 0);
		payload.put("searchd", new JSONArray("[string]"));
		payload.put("columns", new JSONArray("[string]"));
		payload.put("order", new JSONArray("[string]"));

		JSONObject response = new JSONObject(RestAssured.given().given().log().all().spec(requestSpec).header(header)
				.body(payload.toString()).post("/syc-personal-data/list").andReturn().asString());
		System.out.println(RestAssured.given().given().log().all().spec(requestSpec).header(header)
				.body(payload.toString()).post("/syc-personal-data/list").andReturn().asString());

		JSONArray itemsArray = response.getJSONArray("items");
		for (int i = 0; i < itemsArray.length(); i++) {
			JSONObject item = itemsArray.getJSONObject(i);
			scenarioHashMap.put(i, item.getString("scenarioHash"));
			System.out.println(scenarioHashMap.get(i));
			homeBuyerHashMap.put(i, item.getString("homeBuyerHash"));
			System.out.println(homeBuyerHashMap.get(i));

		}

		initConfiguration();
		lp = new LoginPage();
		dashboardPage = new DashboardPage();
		ErrorCollector.extentLogInfo("Step 1 : Visit web url");
		openURL("AppURL");

		ErrorCollector.extentLogInfo("Step 2 : Click on login button");
		lp.clickOnLoginButton();

		String email = PropertiesReader.getPropertyValue(env + "_EmailId");
		ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
		lp.enterEmail(email);

		String pass = PropertiesReader.getPropertyValue(env + "_Password");
		ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
		lp.enterPassword(pass);

		ErrorCollector.extentLogInfo("Step 5 : Click on 'Login' button");
		lp.clickOnLoginButton();

		ErrorCollector.extentLogInfo("Step 7 : Click on Navigation Menu 'Syc Personal Data' button");
		dashboardPage.clickOnMenuSyncPersonalDataButton();

		ErrorCollector.extentLogInfo("Step 7 : select '50' Entries to show");
		dashboardPage.select50Entries();
		System.out.println(scenarioHashMap.size());
		
		for (int i = 0; i < scenarioHashMap.size(); i++) {
			System.out.println(scenarioHashMap.get(i));
			System.out.println(dashboardPage.getScenarioHashInPersonalData(i));
			ErrorCollector.extentLogInfo("Step 7 : Verify API response Scenario Hash <b>value:" + scenarioHashMap.get(i)
					+ "</b> and Scenario Hash <b>value:" + dashboardPage.getScenarioHashInPersonalData(i) + "</b> are equal");
			ErrorCollector.verifyEquals(dashboardPage.getScenarioHashInPersonalData(i), scenarioHashMap.get(i),
					"API response Scenario Hash value" + scenarioHashMap.get(i) + " and Scenario Hash value:"
							+ dashboardPage.getScenarioHashInPersonalData(i) + " are equal");
			
			System.out.println(homeBuyerHashMap.get(i));
			System.out.println(dashboardPage.getHomeBuyHashItemInPersonalData(i));
			ErrorCollector.extentLogInfo("Step 7 : Verify API response Home Buyer Hash <b>value:"
					+ homeBuyerHashMap.get(i) + "</b> and Home Buyer Hash <b>value:" + dashboardPage.getHomeBuyHashItemInPersonalData(i)
					+ "</b> are equal");
			ErrorCollector.verifyEquals(dashboardPage.getHomeBuyHashItemInPersonalData(i), homeBuyerHashMap.get(i),
					"API response Home Buyer Hash <b>value:" + homeBuyerHashMap.get(i)
							+ "</b> and Home Buyer Hash <b>value:" + dashboardPage.getHomeBuyHashItemInPersonalData(i)
							+ "</b> are equal");
		}
	}
	
	

}
