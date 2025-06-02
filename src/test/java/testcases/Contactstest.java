package testcases;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import pages.Contactspage;
import pages.CreateOppotunittiespage;
import pages.Leadspage;
import pages.Loginpage;
import utilities.Screenshot;


public class Contactstest extends Basetest{
	WebDriver driver;
	Loginpage loginpage;
	Contactspage contactspage;
		//Screenshot screenshot;
	Basepage basepage;
	Leadspage leadspage;
	
	@BeforeMethod
	
	public void beforeMethod() {
		driver = launchapplication();
		loginpage = new Loginpage(driver);
		basepage = new Basepage(driver);
		contactspage = new Contactspage(driver);
		leadspage = new Leadspage(driver);
				//screenshot= new Screenshot();
		DOMConfigurator.configure("log4j.xml");
	}

	
	@Test (priority = 1)
	public void createNewContact25() {
		Log.startTestCase("(TC25)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		basepage.waitforElement(contactspage.contactsTabElement(), 20);
		basepage.click(contactspage.contactsTabElement());
		basepage.waitforElement(contactspage.newButtonElement(), 20);
		basepage.click(contactspage.newButtonElement());
		String lastName = "autoLname"+basepage.generateTimeStamp();
		basepage.type(contactspage.lastNameTextboxElement(), lastName);
		basepage.type(contactspage.accountNameTextboxElement(), "Poorni");
		basepage.click(contactspage.saveButtonElement());
		String actual = basepage.getText(contactspage.pageDescriptionElement());
		String expected = lastName;
		Assert.assertEquals(actual, expected);
	
	}
	
	@Test(priority = 2)
	public void createNewViewContactPage26() {
		Log.startTestCase("(TC26)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		basepage.waitforElement(contactspage.contactsTabElement(), 20);
		basepage.click(contactspage.contactsTabElement());
		basepage.click(contactspage.createNewViewElement());
		String uniqueViewName = "Unique_"+basepage.generateTimeStamp();
		basepage.type(contactspage.viewNameElement(), uniqueViewName);
		basepage.click(contactspage.UniqueViewNameElement());
		basepage.click(contactspage.saveButtonElement());
		String actual = basepage.getFirstSelectedOption(contactspage.verifyNameDropdownElement());
		String expected = uniqueViewName;
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 3)
	public void createdContactIsInTheContactpage27() {
		Log.startTestCase("(TC27)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		basepage.waitforElement(contactspage.contactsTabElement(), 20);
		basepage.click(contactspage.contactsTabElement());
	//creating a contact
		basepage.waitforElement(contactspage.newButtonElement(), 20);
		basepage.click(contactspage.newButtonElement());
		String lastName = "autoLname"+basepage.generateTimeStamp();
		basepage.type(contactspage.lastNameTextboxElement(), lastName);
		basepage.type(contactspage.accountNameTextboxElement(), "Poorni");
		basepage.click(contactspage.saveButtonElement());
		//checking
		basepage.waitforElement(contactspage.contactsTabElement(), 20);
		basepage.click(contactspage.contactsTabElement());
		basepage.selectByIndex(contactspage.recentlyCreatedDropdownElement(), 0);
		String actual = basepage.getText(contactspage.firstNameElement());
		String expected = lastName;
		Assert.assertEquals(actual, expected);
	}
	
	@Test (priority = 4)
	public void checkMyContacts28() {
		Log.startTestCase("(TC28)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		basepage.waitforElement(contactspage.contactsTabElement(), 20);
		basepage.click(contactspage.contactsTabElement());
		
		basepage.selectByVisibleTex(contactspage.verifyNameDropdownElement(), "My Contacts");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean actual = contactspage.checkIfThereAreValues();
		//boolean expected = true;
		System.out.print(actual);
		//Assert.assertTrue(actual, "Expected contact name 'Indian' not found in My Contacts.");
		//Assert.assertEquals(actual, expected);
	}
	
	@Test (priority = 5)
	public void viewAContact29() {
		Log.startTestCase("(TC29)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		basepage.waitforElement(contactspage.contactsTabElement(), 20);
		basepage.click(contactspage.contactsTabElement());
		String expectedResult = basepage.getText(contactspage.firstAccountElement());
		basepage.click(contactspage.firstAccountElement());
		String actualResult = basepage.getText(contactspage.headingElement());
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test (priority = 6)
	public void viewAContact30() {
		Log.startTestCase("(TC30)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		basepage.waitforElement(contactspage.contactsTabElement(), 20);
		basepage.click(contactspage.contactsTabElement());
		basepage.click(contactspage.createNewViewLinkElement());
		basepage.type(contactspage.UniqueViewNameElement(), "EFGH");
		basepage.click(contactspage.saveButtonElement());
		String actual = basepage.getText(contactspage.errorMessageElement());
		String expected = "Error: You must enter a value";
		Assert.assertEquals(actual, expected);
	}
	@Test (priority = 7)
	public void cancelButtonInCreateNewView31() {
		Log.startTestCase("(TC31)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		basepage.waitforElement(contactspage.contactsTabElement(), 20);
		basepage.click(contactspage.contactsTabElement());
		basepage.click(contactspage.createNewViewLinkElement());
		basepage.type(contactspage.viewNameElement(), "QWER");
		basepage.click(contactspage.UniqueViewNameElement());
		basepage.click(contactspage.cancelButtonElement());
		String actual = basepage.getFirstSelectedOption(contactspage.verifyNameDropdownElement());
		
		String expected = "QWER";
		Assert.assertNotEquals(expected,actual);
	}
	@Test (priority = 7)
	public void saveAndNewButton32() {
		Log.startTestCase("(TC32)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		basepage.waitforElement(contactspage.contactsTabElement(), 20);
		basepage.click(contactspage.contactsTabElement());
		basepage.click(contactspage.newButtonElement());
		basepage.type(contactspage.lastNameTextboxElement(), "Indian");
		basepage.waitforElement(contactspage.searchAccountNameElement(), 20);
		basepage.click(contactspage.searchAccountNameElement());
		String mainwindow = driver.getWindowHandle();
		basepage.switchToWindow();
		driver.switchTo().frame("searchFrame");
		basepage.waitforElement(contactspage.textboxElement(), 20);
		basepage.type(contactspage.textboxElement(), "autoaccount");
		basepage.click(contactspage.goButtonElement());
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("resultsFrame");
		basepage.click(contactspage.accountNameDisplayedElement());
		driver.switchTo().window(mainwindow);
		basepage.click(contactspage.saveButtonElement());
		String actual = basepage.getText(contactspage.pageDescriptionElement());
		String expected = "Indian";
		Assert.assertEquals(actual, expected);
	}
	@AfterMethod
	public void teardown() {
		//screenshot.takeScreenShot(driver);
		closebrowser();
		
	}
	
	
}
