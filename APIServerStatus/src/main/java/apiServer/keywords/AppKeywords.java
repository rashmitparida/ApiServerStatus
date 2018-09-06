package apiServer.keywords;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;



public class AppKeywords extends GenericKeywords{

	public void login() throws InterruptedException
	{
		test.log(Status.INFO, "Logging into Api Server using valid user credential"); 
		String username;
		String password;
				
		if(data.get("Username") == null){
			username=envProp.getProperty("defaultUsername");
			password=envProp.getProperty("defaultPass");
		}else{
			username=data.get("Username");
			password=data.get("Password");
		}
		getObject("userName_xpath").sendKeys(username);
		getObject("password_xpath").sendKeys(password);
		getObject("SubmitButton_xpath").click();
		test.log(Status.INFO, "Logging in with "+ data.get("Username")+"/"+data.get("Password"));
		
		test.log(Status.INFO, "Assertion of Response");	
		//boolean result = isElementPresent("");	
		String ExpectedMessage="";
		ExpectedMessage = driver.findElement(By.xpath("html/body")).getText();
		System.out.println("Print the response " +ExpectedMessage );
		
		if(ExpectedMessage.equals(data.get("ActualResponse")))
		{
			test.log(Status.INFO, "Api returns correct response");
		}
		else
			reportFailure("Got result "+ExpectedMessage );

		}
	
	}
