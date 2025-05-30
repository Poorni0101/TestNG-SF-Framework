package testcases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.w3c.dom.DOMConfiguration;

import base.Basepage;
import base.Basetest;
import log.Log;
import pages.UsermenuDropdownpage;
import pages.Loginpage;
import utilities.Screenshot;


public class Logintest extends Basetest{
	WebDriver driver;
	Loginpage loginpage;
	UsermenuDropdownpage usermenuDropdownpage;
	//Screenshot screenshot;
	Basepage basepage;
	
	
	@BeforeMethod
	
	public void beforeMethod() {
		driver = launchapplication();
		loginpage = new Loginpage(driver);
		basepage = new Basepage(driver);
		usermenuDropdownpage = new UsermenuDropdownpage(driver);
		//screenshot= new Screenshot();
		DOMConfigurator.configure("log4j.xml");
	}

	@Test(priority=1)
	public void loginwithValidusernameandInvalidpassword1 () {
		Log.startTestCase("Trying to login with no password(TC1)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		Log.info("Email is entered");
		loginpage.enterintoPassword("");
		loginpage.clickonLoginButton();
		Log.info("login button is clicked for test1");
		Log.endTestCase("Test case 1 is successful");
		basepage.waitforElement(loginpage.errorMessageDisplayed(), 20);
		Assert.assertEquals(loginpage.errorMessageDisplayed().getText(), "Please enter your password.");
		
	}

	
	@Test(priority=2)
	public void logwithvalidusernameandpassword2() {
		Log.startTestCase("Trying to login with valid password(TC2)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		Log.info("login button is clicked for test2");
		Log.endTestCase("Test case 2 is successful");
		basepage.waitforElement(usermenuDropdownpage.getUsernameDropdownElement(), 20);
		Assert.assertTrue(usermenuDropdownpage.userNameDropdownPresent().isDisplayed(),"no user name dropdown, TC2 failed");
	}
@Test(priority=3)
	
	public void checkRememberMe3(){
	Log.startTestCase("(TC3)");
	loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
	loginpage.enterintoPassword("Poornitha123");
	loginpage.clickRememberCheckbox();
	loginpage.clickonLoginButton();
	basepage.waitforElement(usermenuDropdownpage.getUsernameDropdownElement(), 20);
	usermenuDropdownpage.clickUsermenuDropdown();
	Log.info("Logged in successful");
	loginpage.logoutButton();
	
	basepage.waitforElement(loginpage.getUsernameElement(), 20);
	
	String expectedUsername = "poornitha.rameshkumar594@agentforce.com";
	String actualUsername = loginpage.getUsernameValue();
	
	//validating if  the user name is displayed
	Assert.assertEquals(actualUsername, expectedUsername,"username doesnt match");
	Assert.assertTrue(loginpage.ischeckBoxChecked().isSelected(),"Checkbox not checked, so TC failed");    

}

@Test (priority =4)
public void forgotpswd4a() {
	Log.startTestCase("(TC4a)");
	loginpage.forgotPasswordLink();
	loginpage.enterUsernameForgotPassword();
	loginpage.clickContinueButton();
	//validation
	Assert.assertEquals(loginpage.checkYourEmailMsg(),"Check Your Email");
	
}
	
@Test(priority =5)
public void forgotpswd4b() {
	Log.startTestCase("(TC4b)");
	loginpage.wrongUsername();
	loginpage.wrongPassword();
	loginpage.clickonLoginButton();
	basepage.waitforElement(loginpage.checkUsernamePswdMsg(), 20);
	Assert.assertEquals(loginpage.checkUsernamePswdMsg().getText(), "Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
	
}
	
	@AfterMethod
	public void teardown() {
		//screenshot.takeScreenShot(driver);
		closebrowser();
		
	}
	
}
