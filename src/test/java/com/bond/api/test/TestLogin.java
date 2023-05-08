package com.bond.api.test;

import org.jaxen.expr.Step;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.bond.base.BaseClass;
import com.bond.base.PropertiesReader;
import com.bond.errorCollectors.ErrorCollector;
import com.bond.pages.LoginPage;
import com.bond.pages.LogoutPage;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.velocity.util.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.hamcrest.Matchers.*;

import net.bytebuddy.asm.Advice.OnDefaultValue;

public class TestLogin extends BaseClass {
	LoginPage lp;
	LogoutPage logout;

	@Test (groups = {"API"})
	public void Test_Login_API() throws IOException {
		
		RestAssured.baseURI = "https://xmgf6lbi96.execute-api.ap-southeast-2.amazonaws.com/development";

	    RequestSpecification requestSpec = new RequestSpecBuilder()
	            .addHeader("Content-Type", "application/json").build();

	    JSONObject payload = new JSONObject();
	    payload.put("email", "adminbcp@osqo.com");
	    payload.put("password", "admin123");

//	    JSONObject response = new JSONObject(RestAssured.given().given().spec(requestSpec).body(payload.toString())
//	            .post("").andReturn().asString());
	    
	    JSONObject response = new JSONObject(RestAssured.given().given().log().all().spec(requestSpec).body(payload.toString())
	            .post("/user/login").andReturn().asString());
	    System.out.println(response.getString("message"));
	    System.out.println(RestAssured.given().given().log().all().spec(requestSpec).body(payload.toString())
	            .post("/user/login").andReturn().asString());
	    
	    initConfiguration();
		lp = new LoginPage();
		ErrorCollector.extentLogInfo("Step 1 : Visit web url");
		openURL("AppURL");

		ErrorCollector.extentLogInfo("Step 2 : Click on login button");
		lp.clickOnLoginButton();
		System.out.println(response.getString("message"));
		String email = PropertiesReader.getPropertyValue(env + "_EmailId");
		ErrorCollector.extentLogInfo("Step 3 : Enter Email : " + email);
		lp.enterEmail(email);

		String pass = PropertiesReader.getPropertyValue(env + "_Password");
		ErrorCollector.extentLogInfo("Step 4 : Enter Password : " + pass);
		lp.enterPassword(pass);

		ErrorCollector.extentLogInfo("Step 5 : Click on Login button");
		lp.clickOnLoginButton();

		ErrorCollector.extentLogInfo("Step 6 : Verify User Login Successfully Popup is displaying");
		ErrorCollector.verifyTrue(lp.isLoggedInSuccessPopupDisplaying(),
				"Verified User Login Successfully Popup is displaying");
		
		System.out.println(lp.getLoginSuccessMessage());
		System.out.println(response.getString("message"));
		
		ErrorCollector.extentLogInfo("Step 7 : Verify API response message and login messages are equal");
		ErrorCollector.verifyEquals(lp.getLoginSuccessMessage(),response.getString("message"),"Messages are not equal.");
	}
	
}
