package testcases;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
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
import pages.CreateOppotunittiespage;
import pages.Leadspage;
import pages.Loginpage;
import utilities.Screenshot;


public class Leadstest extends Basetest{
	WebDriver driver;
	Loginpage loginpage;
	Leadspage leadspage;
		//Screenshot screenshot;
	Basepage basepage;
	UsermenuDropdownpage usermenuDropdownpage;
	
	@BeforeMethod
	
	public void beforeMethod() {
		driver = launchapplication();
		loginpage = new Loginpage(driver);
		basepage = new Basepage(driver);
		leadspage = new Leadspage(driver);
		usermenuDropdownpage  = new UsermenuDropdownpage(driver);
		//screenshot= new Screenshot();
		DOMConfigurator.configure("log4j.xml");
	}

	@Test(priority=1)
	public void leadsTab20() {
		Log.startTestCase("(TC20)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		basepage.waitforElement(leadspage.getLeadTabelement(), 20);
		leadspage.clickLeadsTab();
		String expected = "Leads";
		String actual = leadspage.actualResult();
	Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 2)
	public void leadsSelectView21() {
		Log.startTestCase("(TC21)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		basepage.waitforElement(leadspage.getLeadTabelement(), 20);
		leadspage.clickLeadsTab();
		List<String> expected = Arrays.asList("All Open Leads",
				"My Unread Leads","Recently Viewed Leads","Today's Leads");
	
		List<String> actual = leadspage.selectViewDropdown();
		Assert.assertTrue(actual.containsAll(expected), "Dropdown does not contain all expected options.");
	}
	@Test(priority=3)
	public void defaultView22() {
		Log.startTestCase("(TC22)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		basepage.waitforElement(leadspage.getLeadTabelement(), 20);
		leadspage.clickLeadsTab();
		leadspage.viewDropdow();
			usermenuDropdownpage.clickUsermenuDropdown();
			
			loginpage.logoutButton();
			basepage.waitforElement(loginpage.getUserNameElement(), 20);
			
			loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
			loginpage.enterintoPassword("Poornitha123");
			loginpage.clickonLoginButton();
			basepage.waitforElement(leadspage.getLeadTabelement(), 20);
			leadspage.clickLeadsTab();
			leadspage.clickGoButton();
			String actual = leadspage.actualDropdown();
			String expected = "My Unread Leads";
			Assert.assertEquals(actual, expected);
	}
	@Test(priority=4)
	public void todaysLeads23() {
		Log.startTestCase("(TC23)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		basepage.waitforElement(leadspage.getLeadTabelement(), 20);
		leadspage.clickLeadsTab();
		leadspage.selectTodaysLeads();
		//basepage.waitforElement(leadspage.goButtonElement(), 20);
	
		//leadspage.clickGoButton();
		basepage.waitforElement(leadspage.todaysLeadsDropdownElement(), 20);
		String actualResult = leadspage.getVisibleTodaysLeadsDropdown();
		String ExpectedResult = "Today's Leads";
		Assert.assertEquals(ExpectedResult, actualResult);
	}
	
	@Test(priority =5)
	public void checkNewButton24() {
		Log.startTestCase("(TC24)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		basepage.waitforElement(leadspage.getLeadTabelement(), 20);
		leadspage.clickLeadsTab();
		leadspage.clickNewButton();
		leadspage.typeLastName();
		leadspage.typeCompany();
		leadspage.clickSaveButton();
		String actualResult = leadspage.getCheckName();
		String expectedResult24 = "ABCD";
		Assert.assertEquals(expectedResult24, actualResult);
	}
	@AfterMethod
	public void teardown() {
		//screenshot.takeScreenShot(driver);
		closebrowser();
		
	}
	
	
}
