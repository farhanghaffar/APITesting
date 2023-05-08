package com.bond.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.SecureRandom;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;

import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
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
import com.google.common.base.CharMatcher;

import freemarker.template.SimpleDate;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EmailUtils extends BaseClass {

	public static String mailOTPReader(String mailFolderName, String emailSubjectContent, String emailContent,
			int lengthOfOTP) {

		// mailFolderName(Eg- "INBOX"), emailSubjectContent(Eg- Mail for OTP),
//		emailContent(Eg- OTP is 111111), OTP length(Eg- 6)
		String hostName = PropertiesReader.getPropertyValue(env + "_hostName");
		String username = PropertiesReader.getPropertyValue(env + "_methodEmail");// username
		String password = PropertiesReader.getPropertyValue(env + "_Password");
		int messageCount;
		int unreadMsgCount;
		String emailSubject;
		Message emailMessage;
		String searchText = null;
		Properties sysProps = System.getProperties();
		sysProps.setProperty("mail.store.protocol", "imaps");

		try {

			Session session = Session.getInstance(sysProps, null);
			Store store = session.getStore();
			store.connect(hostName, username, password);
			Folder emailBox = store.getFolder(mailFolderName);
			emailBox.open(Folder.READ_WRITE);
			messageCount = emailBox.getMessageCount();
			System.out.println("Total Message Count: " + messageCount);
//		                unreadMsgCount = emailBox.getNewMessageCount();
			unreadMsgCount = 4;
			System.out.println("Unread Emails count:" + unreadMsgCount);
			for (int i = messageCount; i > (messageCount - unreadMsgCount); i--)
			{
				emailMessage = emailBox.getMessage(i);
				emailSubject = emailMessage.getSubject();
				if (emailSubject.contains(emailSubjectContent))
				{
					System.out.println("OTP mail found");
					String line;
					StringBuffer buffer = new StringBuffer();
					BufferedReader reader = new BufferedReader(new InputStreamReader(emailMessage.getInputStream()));
					System.out.println("reader: " + reader);
					while ((line = reader.readLine()) != null) {
						buffer.append(line);
					}
					String messageContent = emailContent;
//					System.out.println("buffer: " +buffer.toString().replaceAll("[^0-9]", ""));
					String result = buffer.toString().substring(buffer.toString().indexOf(messageContent));
					System.out.println("Text found : " + result);
					searchText = result.substring(messageContent.length(), messageContent.length() + lengthOfOTP);
					System.out.println("Text found : " + searchText);
					emailMessage.setFlag(Flags.Flag.SEEN, true);
					emailMessage = emailBox.getMessage(i);
					emailMessage.setFlag(Flags.Flag.DELETED, true);
					break;
				}
				emailMessage.setFlag(Flags.Flag.SEEN, true);
				
			}
			emailBox.close(true);
			store.close();
		} catch (Exception mex) {
			mex.printStackTrace();
			System.out.println("OTP Not found ");
		}
		return searchText.trim();
	}
	
	

	public String mailOTPReader(String username,String password) {
//		String hostName = PropertiesReader.getPropertyValue(env + "_hostName");
		String hostName = "smtp.gmail.com";
		
		int messageCount;
		int unreadMsgCount;
		String emailSubject;
		String emailBody;
		String otpCode="";
		Message emailMessage;		
		waitTime(20000);
	    Properties sysProps = System.getProperties();
	    sysProps.setProperty("mail.store.protocol", "imaps");

	    try {
	        Session session = Session.getInstance(sysProps, null);
	        Store store = session.getStore();
	        store.connect(hostName, username, password);
	        Folder emailInbox = store.getFolder("INBOX");
	        emailInbox.open(Folder.READ_WRITE);
	        messageCount = emailInbox.getMessageCount();
	        System.out.println("Total Message Count: " + messageCount);
	        unreadMsgCount = emailInbox.getNewMessageCount();
	        System.out.println("Unread Emails count:" + unreadMsgCount);
	        emailMessage = emailInbox.getMessage(messageCount);
	        emailSubject = emailMessage.getSubject();

	        emailBody = getTextFromMessage(emailMessage);
	        Pattern linkPattern = Pattern.compile("[0-9]{6}"); // here you need to define regex as per you need
	        Matcher pageMatcher =
	                linkPattern.matcher(emailBody);
	        
	        if(pageMatcher.find()) {
	            System.out.println("Found OTP " + pageMatcher.group(0));
	            otpCode =pageMatcher.group(0);
	        }
	        emailMessage.setFlag(Flags.Flag.SEEN, true);
	        emailMessage.setFlag(Flags.Flag.DELETED, true);
	        emailInbox.close(true);
	        store.close();
	    } catch (Exception mex) {
	        mex.printStackTrace();
	    }
	    return otpCode;
	}
	
	 private String getTextFromMessage(Message message) throws Exception {
		  String result = "";
		  if (message.isMimeType("text/plain")) {
		    result = message.getContent().toString();
		  } else if (message.isMimeType("multipart/*")) {
		    MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
		    result = getTextFromMimeMultipart(mimeMultipart);
//		    result =result.replaceAll("[^0-9]", "").trim();
		    result =result.trim().replaceAll("\\s{2,}", " ").replace(".", "").replace("?", "");
		    System.out.println(result);
		  }
		  return result;
		}
	 
	 private String getUrlFromMessage(Message message) throws Exception {
		  String result = "";
		  if (message.isMimeType("text/plain")) {
		    result = message.getContent().toString();
		  } else if (message.isMimeType("multipart/*")) {
		    MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
		    result = getTextFromMimeMultipart(mimeMultipart);
		    result = result.substring(result.indexOf("https"),result.indexOf(" © "));
		    System.out.println(result);
		  }
		  return result;
		}

		private String getTextFromMimeMultipart(
		    MimeMultipart mimeMultipart) throws Exception{
		  String result = "";
		  int count = mimeMultipart.getCount();
		  for (int i = 0; i < count; i++) {
		    BodyPart bodyPart = mimeMultipart.getBodyPart(i);
		    if (bodyPart.isMimeType("text/plain")) {
		      result = result + "\n" + bodyPart.getContent();
		      break; // without break same text appears twice in my tests
		    } else if (bodyPart.isMimeType("text/html")) {
		      String html = (String) bodyPart.getContent();
		      result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
		    } else if (bodyPart.getContent() instanceof MimeMultipart){
		      result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
		    }
		  }
		  return result;
		}
		
		public String mailUrlReader(String username,String password) {
//			String hostName = PropertiesReader.getPropertyValue(env + "_hostName");
			String hostName = "smtp.gmail.com";
			
			int messageCount;
			int unreadMsgCount;
			String emailSubject;
			String emailBody;
			String otpCode="";
			Message emailMessage;		
			waitTime(20000);
		    Properties sysProps = System.getProperties();
		    sysProps.setProperty("mail.store.protocol", "imaps");

		    try {
		        Session session = Session.getInstance(sysProps, null);
		        Store store = session.getStore();
		        store.connect(hostName, username, password);
		        Folder emailInbox = store.getFolder("INBOX");
		        emailInbox.open(Folder.READ_WRITE);
		        messageCount = emailInbox.getMessageCount();
		        System.out.println("Total Message Count: " + messageCount);
		        unreadMsgCount = emailInbox.getNewMessageCount();
		        System.out.println("Unread Emails count:" + unreadMsgCount);
		        emailMessage = emailInbox.getMessage(messageCount);
		        emailSubject = emailMessage.getSubject();

		        emailBody = getUrlFromMessage(emailMessage);
//		        Pattern linkPattern = Pattern.compile("[0-9]{6}"); // here you need to define regex as per you need
//		        Matcher pageMatcher =
//		                linkPattern.matcher(emailBody);
		        otpCode =emailBody;
//		        if(pageMatcher.find()) {
//		            System.out.println("Found OTP " + pageMatcher.group(0));
//		            otpCode =pageMatcher.group(0);
//		        }
		        emailMessage.setFlag(Flags.Flag.SEEN, true);
		        emailMessage.setFlag(Flags.Flag.DELETED, true);
		        emailInbox.close(true);
		        store.close();
		    } catch (Exception mex) {
		        mex.printStackTrace();
		    }
		    return otpCode;
		}

	
}
