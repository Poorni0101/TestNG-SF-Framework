package testcases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import pages.CreateAccountPage;
import pages.Loginpage;
import utilities.Screenshot;


public class CreateAccounttest extends Basetest{
	WebDriver driver;
	Loginpage loginpage;
	UsermenuDropdownpage usermenuDropdownpage;
	//Screenshot screenshot;
	CreateAccountPage createAccountpage;
	Basepage basepage;
	
	
	@BeforeMethod
	
	public void beforeMethod() {
		driver = launchapplication();
		loginpage = new Loginpage(driver);
		basepage = new Basepage(driver);
		usermenuDropdownpage = new UsermenuDropdownpage(driver);
		createAccountpage = new CreateAccountPage(driver);
		//screenshot= new Screenshot();
		DOMConfigurator.configure("log4j.xml");
	}

	@Test(priority=1)
	public void createAccount10() {
		Log.startTestCase("Trying to login with no password(TC10)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		basepage.waitforElement(createAccountpage.accountTab(), 20);
		createAccountpage.clickAccountsTab();
		createAccountpage.clickNewButton();
		createAccountpage.enterAccountName();
		createAccountpage.selectTypeDropdown();
		createAccountpage.selectCusPriority();
		createAccountpage.clickSaveButton();
		String actual = createAccountpage.dropType();
		String expected = "Technology Partner";
		
		Assert.assertEquals(expected, actual,"Test case 10 failed");
	}
	
@Test (priority = 2)
public void createNewView11() {
	Log.startTestCase("Trying to login with no password(TC11)");
	loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
	loginpage.enterintoPassword("Poornitha123");
	loginpage.clickonLoginButton();
	basepage.waitforElement(createAccountpage.accountTab(), 20);
	createAccountpage.clickAccountsTab();
	createAccountpage.clickCreateNewViewLink();
	String expected = createAccountpage.enterViewName();
	createAccountpage.clickViewUniqueName();
	createAccountpage.clickSaveButton1();
	String actual = createAccountpage.selectViewDropdown();
	
	Assert.assertEquals(expected, actual, "Test case 11 failed");
}
@Test (priority =3)
public void editView12() {
	Log.startTestCase("Trying to login with no password(TC12)");
	loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
	loginpage.enterintoPassword("Poornitha123");
	loginpage.clickonLoginButton();
	driver.manage().window().maximize();
	basepage.waitforElement(createAccountpage.accountTab(), 20);
	createAccountpage.clickAccountsTab();
	basepage.waitforElement(createAccountpage.viewDropdownElement(), 20);
	createAccountpage.selectFromViewDropdown();
	createAccountpage.clickEditButton();
	String oldViewName = createAccountpage.storeoldViewName();
	String expectedViewDropdown = createAccountpage.changeViewname(oldViewName);
	createAccountpage.selectFilteredDropdown();
	
	createAccountpage.selectOperatorDropdown();
	createAccountpage.enterValue();
	
	createAccountpage.selectAvailableFieldDropDown();
		createAccountpage.clickAddButton();
	createAccountpage.clickSaveButton2();
	basepage.waitforElement(createAccountpage.lastActivityTitle(), 20);
	String actualLastActivity = createAccountpage.getLastActivityTitle();
	String expectedLastActivity = "Last Activity";

	String actualViewDropDown = createAccountpage.selectViewDropdown();
	Assert.assertEquals(actualLastActivity, expectedLastActivity); 
	Assert.assertEquals (actualViewDropDown,expectedViewDropdown);
}

@Test (priority = 4)
public void mergeAccount13() {
	Log.startTestCase("Trying to login with no password(TC13)");
loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
loginpage.enterintoPassword("Poornitha123");
loginpage.clickonLoginButton();
basepage.waitforElement(createAccountpage.accountTab(), 20);
createAccountpage.clickAccountsTab();
createAccountpage.clickMergeAccount();
basepage.waitforElement(createAccountpage.searchTextbox(), 20);
createAccountpage.enterInSearchTextBox();
createAccountpage.clickFindAccountButton();
createAccountpage.clickCheckbox1();
createAccountpage.clickCheckbox2();
String accountName1 = createAccountpage.verifyAccountName1();
String accountName2 = createAccountpage.verifyAccountName2();
createAccountpage.clickNextButton();
String actual = createAccountpage.verifyStep2Merging();
String expected = "Step 2. Select the values to retain";
//verify the account name selected is same from step2 page
String name1a = createAccountpage.getAccountname1a();
String name2a = createAccountpage.getAccountname2a();
Assert.assertEquals(actual, expected);
//Assert.assertEquals(accountName1, name1a);
//Assert.assertEquals(accountName2, name2a);
//clicking on Merge button
createAccountpage.clickMergeButton();
driver.switchTo().alert().accept();
String actualresult = createAccountpage.getAccountHomeLabel();
String expectedresult = "Accounts";
Assert.assertEquals(actualresult, expectedresult);
}

@Test(enabled = false)//not switching
public void createAccountReport14() {
	Log.startTestCase("Trying to login with no password(TC14)");
	loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
	loginpage.enterintoPassword("Poornitha123");
	loginpage.clickonLoginButton();
	basepage.waitforElement(createAccountpage.accountTab(), 20);
	createAccountpage.clickAccountsTab();
	createAccountpage.clickLastActivityLink();
	//clicking the date field since its a not a dropdown
	createAccountpage.clickDateField();
	createAccountpage.clickDateFieldDropdown();
	createAccountpage.clickFromDateIcon();
	createAccountpage.clickTodayButton1();
	createAccountpage.clickToDateIcon();
	createAccountpage.clickTodayButton2();
	createAccountpage.clickSaveButton3();
	
	basepage.switchToWindow();
	String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	createAccountpage.reportName(timestamp);
}


	@AfterMethod
	public void teardown() {
		//screenshot.takeScreenShot(driver);
		closebrowser();
		
	}
	
}
