package testcases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
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
import pages.CreateOppotunittiespage;
import pages.Leadspage;
import pages.Loginpage;
import pages.RandomScenariospage;
import utilities.Screenshot;


public class RandomScenariostest extends Basetest{
	WebDriver driver;
	Loginpage loginpage;
	Leadspage leadspage;
		//Screenshot screenshot;
	Basepage basepage;
	UsermenuDropdownpage usermenuDropdownpage;
	RandomScenariospage randomScenariospage;
	@BeforeMethod
	
	public void beforeMethod() {
		driver = launchapplication();
		loginpage = new Loginpage(driver);
		basepage = new Basepage(driver);
		leadspage = new Leadspage(driver);
		randomScenariospage = new RandomScenariospage(driver);
		usermenuDropdownpage  = new UsermenuDropdownpage(driver);
		//screenshot= new Screenshot();
		DOMConfigurator.configure("log4j.xml");
	}

	@Test(priority=1)
	public void verifyFirstNameLastName33() {
		Log.startTestCase("(T33)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		basepage.waitforElement(randomScenariospage.homeTabElement(), 20);
		basepage.click(randomScenariospage.homeTabElement());
		
		basepage.click(randomScenariospage.userNameLinkElement());
			//	basepage.click(randomScenariospage.userNameDropdownElement());
		basepage.click(randomScenariospage.myProfileElement());
		String actual = randomScenariospage.getDisplayedHomeName();
		System.out.println(actual);
		System.out.println("i clicked my profile option for you :-)");
		basepage.waitforElement(randomScenariospage.displayedMyProfileNameElement(), 20);
		String expected = basepage.getText(randomScenariospage.displayedMyProfileNameElement());
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void verifyEditedLastNames34() {
		Log.startTestCase("(T34)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		basepage.waitforElement(randomScenariospage.homeTabElement(), 20);
		basepage.click(randomScenariospage.homeTabElement());
		basepage.click(randomScenariospage.userNameLinkElement());
		basepage.click(randomScenariospage.myProfileElement());
		System.out.println("Cliked my profile");
		basepage.waitForElementToBeVisible(randomScenariospage.displayedHomeNameElement());
		String homeName =  randomScenariospage.getDisplayedHomeName();
		System.out.println("Before"+homeName);
		basepage.waitforElement(usermenuDropdownpage.pencilIconElement(), 20);
		usermenuDropdownpage.clickPencilIcon();
		driver.switchTo().frame(usermenuDropdownpage.getFrameElement());
		usermenuDropdownpage.clickAboutTab();
		usermenuDropdownpage.enterLastNameR();

		usermenuDropdownpage.clickSaveAllButton();
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		String homeNameAfterChange =  randomScenariospage.getDisplayedHomeName();
		System.out.println("After"+homeNameAfterChange);
		Assert.assertNotEquals(homeName, homeNameAfterChange);
	}
	
	@Test
	public void verifyTabCustomization35() {
		Log.startTestCase("(T35)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		basepage.waitforElement(randomScenariospage.tabBarElement(), 20);
		int tabElementsBefore = randomScenariospage.tabBarListBeforeSize();
		System.out.println("Before"+tabElementsBefore);
		basepage.waitforElement(randomScenariospage.plusButtonElement(), 20);
		basepage.click(randomScenariospage.plusButtonElement());
		basepage.click(randomScenariospage.customizeButtonElement());
		basepage.waitForElementToBeVisible(randomScenariospage.selectedTabElement());
		basepage.selectByIndex(randomScenariospage.selectedTabElement(), 2);
		basepage.click(randomScenariospage.removeButtonElement());
		
		basepage.click(randomScenariospage.saveButtonElement());
		
		basepage.waitforElement(randomScenariospage.userMenuDropdownElement(), 20);
		basepage.click(randomScenariospage.userMenuDropdownElement());
		basepage.click(randomScenariospage.logoutElement());
		basepage.waitforElement(loginpage.enterintoEmailElement(), 20);
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		
		basepage.waitforElement(randomScenariospage.tabBarElement(), 20);
		int tabElementsAfter = randomScenariospage.tabBarListBeforeSize();
		System.out.println("After "+tabElementsAfter);
		Assert.assertNotEquals(tabElementsBefore,tabElementsAfter);
	}
	
	
	@Test
	public void blockingAnEventInTheCalender36() {
		Log.startTestCase("(T36)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		basepage.waitforElement(randomScenariospage.homeTabElement(), 20);
		basepage.click(randomScenariospage.homeTabElement());
		//String currentDate = basepage.getText(randomScenariospage.currentDatelinkElement());
		//String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE MMMM dd, yyyy"));
		//Assert.assertEquals(currentDate, expectedDate);
		
		basepage.click(randomScenariospage.currentDatelinkElement());
		System.out.println(randomScenariospage.calenderFnameLnameOpenedElement().getText()+" is opened");
		basepage.click(randomScenariospage.eightPMlinkElement());
		String mainWindow = driver.getWindowHandle();
		randomScenariospage.subjectComboIconClick();
		
		basepage.switchToWindow();
		randomScenariospage.otherLinkClick();
		
		driver.switchTo().window(mainWindow);
		randomScenariospage.endTimeClick();
		randomScenariospage.timePickerClick();
		basepage.click(randomScenariospage.saveButtonElement());
		randomScenariospage.otherVisibleLinkClick();
		//validation
		String actualTitle = randomScenariospage.getActualCalenderEventTitle();
		String actualStartTime = randomScenariospage.getStartDateTime().split(",")[1].trim();
		String actualEndTime = randomScenariospage.getEndDateTime().split(",")[1].trim();
		String expectedTitle ="Other";
		String expectedStartTime = "8:00 PM";
		String expectedEndTime = "9:00 PM";
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertTrue(actualStartTime.startsWith(expectedStartTime));
		Assert.assertTrue(actualEndTime.startsWith(expectedEndTime));
	
	}
	@AfterMethod
	public void teardown() {
		//screenshot.takeScreenShot(driver);
		closebrowser();
		
	}
	
	
}
