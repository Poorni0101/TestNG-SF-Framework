package testcases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import base.Basepage;
import base.Basetest;
import log.Log;
import pages.UsermenuDropdownpage;
import pages.Loginpage;
import utilities.Screenshot;

public class UsermenuDropdowntest extends Basetest {
WebDriver driver;
Loginpage loginpage;
UsermenuDropdownpage usermenuDropdownpage;
Basepage basepage;
Screenshot screenshot;

@BeforeMethod

public void beforeMethod() {
	driver = launchapplication();
	loginpage = new Loginpage(driver);
	usermenuDropdownpage = new UsermenuDropdownpage(driver);
	basepage = new Basepage(driver);
	//screenshot= new Screenshot();
	DOMConfigurator.configure("log4j.xml");
	}

@Test
public void selectUsermenuDropdownTC5() {
	Log.startTestCase("(TC5)");
	loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
	loginpage.enterintoPassword("Poornitha123");
	loginpage.clickonLoginButton();
	//basepage.waitforElement(loginpage.getUsernameElement(), 20);
	basepage.waitforElement(usermenuDropdownpage.getUsernameDropdownElement(), 20);
	usermenuDropdownpage.clickUsermenuDropdown();
	
	//validation
	String expected1 = "My Profile" ;
	String expected2 = "My Settings" ;
	String expected3 = "Developer Console" ;
	String expected4 = "Switch to Lightning Experience" ;
	String expected5 = "Logout" ;
	
	Assert.assertTrue(usermenuDropdownpage.myProfile().equals(expected1)&&
			usermenuDropdownpage.mySettings().equals(expected2)&&
			usermenuDropdownpage.devConsole().equals(expected3)&&
			usermenuDropdownpage.lConsole().equals(expected4)&&
			usermenuDropdownpage.logout().equals(expected5),"options didnt match TC5 failed");
}

@Test (priority=1)
public void myProfileTC6() {
	Log.startTestCase("(TC6)");
	loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
	loginpage.enterintoPassword("Poornitha123");
	loginpage.clickonLoginButton();
	//basepage.waitforElement(loginpage.getUsernameElement(), 20);
	basepage.waitforElement(usermenuDropdownpage.getUsernameDropdownElement(), 20);
	usermenuDropdownpage.clickUsermenuDropdown();
	
	usermenuDropdownpage.clickMyProfile();
	usermenuDropdownpage.clickPencilIcon();
	driver.switchTo().frame(usermenuDropdownpage.getFrameElement());
	usermenuDropdownpage.clickAboutTab();
	usermenuDropdownpage.enterLastName();

	usermenuDropdownpage.clickSaveAllButton();
	
	//switching back to default content
	driver.switchTo().defaultContent();
	//basepage.waitforElement(usermenuDropdownpage.getUsernameDropdownElement(), 20);
	//usermenuDropdownpage.clickUsermenuDropdown();
	
	//usermenuDropdownpage.clickMyProfile();
	//basepage.waitForElementToBeClickable(usermenuDropdownpage.postButtonElement());
	//basepage.click(usermenuDropdownpage.postButtonElement());
	driver.navigate().refresh();
	//driver.switchTo().frame(usermenuDropdownpage.postiFrameElement());
	//usermenuDropdownpage.enterInfoToPost();
}

@Test (priority=2)
public void mySettingsOption7() {
	Log.startTestCase("(TC7)");
	loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
	loginpage.enterintoPassword("Poornitha123");
	loginpage.clickonLoginButton();
	//basepage.waitforElement(loginpage.getUsernameElement(), 20);
	basepage.waitforElement(usermenuDropdownpage.getUsernameDropdownElement(), 20);
	
	usermenuDropdownpage.clickUsermenuDropdown();
	usermenuDropdownpage.clickMysettings();
	usermenuDropdownpage.clickPersonal();
	usermenuDropdownpage.clickLoginHistory();
	String actual = usermenuDropdownpage.getLoginHistoryTitle();
	String expected = "Login History";
	Assert.assertEquals(actual, expected,"TC7 step2 failed");
	String actual1 = usermenuDropdownpage.getCsvLinkText();
	String expected1 = "Download login history for last six months, including logins from outside the website, such as API logins (Excel .csv file) »";
	Assert.assertEquals(actual1, expected1,"TC7 step2 failed");

	//DisplayLayout
basepage.waitforElement(usermenuDropdownpage.getUsernameDropdownElement(), 20);
	
	usermenuDropdownpage.clickUsermenuDropdown();
	usermenuDropdownpage.clickMysettings();
	usermenuDropdownpage.clickDisplayLayoutLink();
	usermenuDropdownpage.clickCustomizeTab();
	usermenuDropdownpage.clickCustomDropdown();
	usermenuDropdownpage.isSelectedAddedAlready();
	usermenuDropdownpage.clickAddButton();
	usermenuDropdownpage.clickSaveButton();
	
	//EmailLink
basepage.waitforElement(usermenuDropdownpage.getUsernameDropdownElement(), 20);
	
	usermenuDropdownpage.clickUsermenuDropdown();
	usermenuDropdownpage.clickMysettings();
	usermenuDropdownpage.clickEmail();
	usermenuDropdownpage.clickMyEmailSetting();
	
	//basepage.waitforElement(usermenuDropdownpage.emailNameElement(), 20);
	
	usermenuDropdownpage.enterEmailName();
	usermenuDropdownpage.enterEmailAddress();
	usermenuDropdownpage.clickAutomaticBcc();
	usermenuDropdownpage.clickSaveButtonEmail();
	
	// validation
	String actual2 = usermenuDropdownpage.getMessageDisplayed();
	String expected2 = "Your settings have been successfully saved.";
	Assert.assertEquals(actual2, expected2, "TC7 step4 is failed");

	
	
	//Calender Reminder
basepage.waitforElement(usermenuDropdownpage.getUsernameDropdownElement(), 20);
	
	usermenuDropdownpage.clickUsermenuDropdown();
	usermenuDropdownpage.clickMysettings();
	usermenuDropdownpage.clickCalenderReminderLink();
	usermenuDropdownpage.clickActivityReminder();
	usermenuDropdownpage.clickTestReminderButton();
	Assert.assertTrue(driver.getTitle().contains("Reminder"));
}

@Test(priority =3)
public void developerConsole8() {
	Log.startTestCase("Trying to login with no password(TC8)");
	loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
	loginpage.enterintoPassword("Poornitha123");
	loginpage.clickonLoginButton();
	//basepage.waitforElement(loginpage.getUsernameElement(), 20);
	basepage.waitforElement(usermenuDropdownpage.getUsernameDropdownElement(), 20);
	
	usermenuDropdownpage.clickUsermenuDropdown();
	usermenuDropdownpage.clickDeveloperConsole();
	String parentWindow = driver.getWindowHandle();
	System.out.println("Parent Window - "+driver.getTitle());
	basepage.switchToWindow();
	driver.close();
	driver.switchTo().window(parentWindow);
	String actual = basepage.getText(usermenuDropdownpage.homeTabElement());
	String expected = "Home";
	Assert.assertEquals(actual, expected);
}
@Test(priority =4)
public void logoutOption9() {
	Log.startTestCase("Trying to login with no password(TC9)");
loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
loginpage.enterintoPassword("Poornitha123");
loginpage.clickonLoginButton();
//basepage.waitforElement(loginpage.getUsernameElement(), 20);
basepage.waitforElement(usermenuDropdownpage.getUsernameDropdownElement(), 20);

usermenuDropdownpage.clickUsermenuDropdown();
loginpage.logoutButton();

basepage.waitforElement(loginpage.getUserName(), 20);
String actual = driver.getCurrentUrl();
String expected = "https://orgfarm-fc9d501789-dev-ed.develop.my.salesforce.com/";
Assert.assertEquals(actual, expected,"Test case 9 Failed");
}

@AfterMethod
public void teardown() {
	//screenshot.takeScreenShot(driver);
	closebrowser();
}
}
