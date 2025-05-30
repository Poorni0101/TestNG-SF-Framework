package testcases;

import java.util.List;

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
import pages.CreateOppotunittiespage;
import pages.Loginpage;
import utilities.Screenshot;


public class CreatOpportunitiestest extends Basetest{
	WebDriver driver;
	Loginpage loginpage;
	CreateOppotunittiespage createoppo;
		//Screenshot screenshot;
	Basepage basepage;
	
	
	@BeforeMethod
	
	public void beforeMethod() {
		driver = launchapplication();
		loginpage = new Loginpage(driver);
		basepage = new Basepage(driver);
		createoppo = new CreateOppotunittiespage(driver);
		//screenshot= new Screenshot();
		DOMConfigurator.configure("log4j.xml");
	}

	@Test(priority=1)
	public void opportunitiesDropdown15() {
		Log.startTestCase("(TC15)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		basepage.waitforElement(createoppo.opportunitiesTab(), 20);
		createoppo.clickOpportunities();
		List<String> elementInDropdown = createoppo.actualListOption();
		List<String> elementShouldBeInDropdown = createoppo.expectedListOption();
	Assert.assertTrue(elementInDropdown.containsAll(elementShouldBeInDropdown),"Dropdown doesnt contain all the options");
	}
	
	@Test (priority = 2)
	public void createNewOpty16() {
		Log.startTestCase("(TC16)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		basepage.waitforElement(createoppo.opportunitiesTab(), 20);
		createoppo.clickOpportunities();
		createoppo.clickNewButton();
		createoppo.typeOppoName();
		createoppo.typeAccountName();
		createoppo.clickCloseDate();
		createoppo.clickTodayDate();
		createoppo.clickChangeFocus();
		createoppo.selectStageDropdown();
		createoppo.selectLeadSourceDropdown();
		
		createoppo.clickSaveButton();
		String actualResult = createoppo.actualResult();
		String expectedResult = "newautoopp";
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test (priority = 3)
	public void oppoPipeLineReport17() {
		Log.startTestCase("(TC17)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		basepage.waitForElementToBeVisible(createoppo.opportunitiesTab());
		createoppo.clickOpportunities();
		createoppo.clickOppoPipeLine();
		String actualResult = createoppo.actualReportName();
		String expectedResult = "Report Generation Status:";
		Assert.assertEquals(actualResult, expectedResult);
	}
	@Test (priority = 4)
	public void stuckOpportunitiesReport18() {
		Log.startTestCase("(TC18)");
	loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
	loginpage.enterintoPassword("Poornitha123");
	loginpage.clickonLoginButton();
	basepage.waitforElement(createoppo.opportunitiesTab(), 20);
	createoppo.clickOpportunities();
	createoppo.clickStuckOppo();
	String actualResult = createoppo.getStuckReport();
	String expectedResult = "Stuck Opportunities";
	Assert.assertEquals(actualResult, expectedResult);
}
	@Test (priority = 5)
	public void quaterlySummaryReport19() {
		Log.startTestCase("(TC19)");
	loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
	loginpage.enterintoPassword("Poornitha123");
	loginpage.clickonLoginButton();
	basepage.waitforElement(createoppo.opportunitiesTab(), 20);
	createoppo.clickOpportunities();
	createoppo.selectIntervalDropdown();
	basepage.waitforElement(createoppo.getIncludeDropdownElement(), 20);
	createoppo.selectIncludeDropdown();
	createoppo.clickRunReport();
	String actualResult = createoppo.getActualReport();
	String expectedResult = "Opportunity Report";
	Assert.assertEquals(actualResult, expectedResult);
	}
	@AfterMethod
	public void teardown() {
		//screenshot.takeScreenShot(driver);
		closebrowser();
		
	}
	
	
}
