package testcases;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	@Test(priority=2)
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
	
	@Test(priority=3)
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
	
	
	@Test(priority=4)
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
		//Assert.assertTrue(actualStartTime.startsWith(expectedStartTime),"Start time doesnt match"+actualStartTime);
		//Assert.assertTrue(actualEndTime.startsWith(expectedEndTime),"End time doesnt match"+actualEndTime);
	
	}
	
	@Test(priority =5)
	public void blockingAnEventWeeklyRecurrance37() {
		Log.startTestCase("(T37)");
		loginpage.enterintoEmail("poornitha.rameshkumar594@agentforce.com");
		loginpage.enterintoPassword("Poornitha123");
		loginpage.clickonLoginButton();
		basepage.waitforElement(randomScenariospage.homeTabElement(), 20);
		basepage.click(randomScenariospage.homeTabElement());
		basepage.click(randomScenariospage.currentDatelinkElement());
		System.out.println(randomScenariospage.calenderFnameLnameOpenedElement().getText()+" is opened");
		randomScenariospage.clickFourPMLink();
		String mainWindow = driver.getWindowHandle();
		randomScenariospage.subjectComboIconClick();
		basepage.switchToWindow();
		randomScenariospage.otherLinkClick();
		driver.switchTo().window(mainWindow);
		randomScenariospage.clickEndTimeBox();
		randomScenariospage.clickTimePicker7PM();
		randomScenariospage.clickCheckboxRecurrence();
		randomScenariospage.clickWeeklyRadioButton();
		String recursEveryValue = randomScenariospage.recursEveryTextBoxValue();
		String recursEveryStartDateValue = randomScenariospage.recursEveryStartDateValue();
		LocalDate startDate = LocalDate.parse(recursEveryStartDateValue, randomScenariospage.toFormatTheDate());
		LocalDate endDate = startDate.plusDays(14);
		System.out.println(endDate);
		String recursEveryEndDateValue = endDate.format(randomScenariospage.toFormatTheDate());
		System.out.println(recursEveryEndDateValue);
		randomScenariospage.enterrecurrenceEndDateOnly(recursEveryEndDateValue);
		basepage.click(randomScenariospage.saveButtonElement());
		String endTimeSelected = "7:00 PM";
		DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("h:mm a");
		LocalTime endTimeParse = LocalTime.parse(endTimeSelected,formatterTime);
		boolean foundWithinTimeRange = false;
		for(WebElement item : randomScenariospage.recurrenceItemsList()) {
			String href= item.getAttribute("href");
			System.out.println(href + "href link");
		if(href!= null && href.contains("evt13=")) // to avoid null pointer exception
		{
			String encodedTime = href.split("evt13=")[1].split("&")[0];// to get only "4%3A00+PM" from href
			System.out.println("encoded time "+encodedTime);
			String decodedTime = URLDecoder.decode(encodedTime,StandardCharsets.UTF_8); // to convert URL encoded time into readable format
			System.out.println("decoded time "+decodedTime);
			LocalTime eventTime = LocalTime.parse(decodedTime,formatterTime);
			
			//check if event is within the end time
			if(!eventTime.isAfter(endTimeParse)) {
				System.out.println(eventTime);
				System.out.println(endTimeParse);
				foundWithinTimeRange = true;
				System.out.println(foundWithinTimeRange);
				break;
			}
		}
		}
	Assert.assertTrue(foundWithinTimeRange,"No item found between 4 pm and 7 pm");
	
	randomScenariospage.clickMonthViewIcon();
	String actualmonthViewPagetitle = randomScenariospage.getMonthViewPageTitle();
	//String expectedmonthViewPageTitle = "Calendar for Poornitha Abcd - Month View";
	Assert.assertTrue(actualmonthViewPagetitle.startsWith("Calendar for Poornitha")&& actualmonthViewPagetitle.endsWith("Month View"), "Heading didnt match" );
	
	String todayFormatted = LocalDate.now().format(DateTimeFormatter.ofPattern("M/d/yyyy"));
	String encodedTodayDate = todayFormatted.replace("/", "%2F") + "%2C"; 
	String partialStart = "Start=" + encodedTodayDate;
	System.out.println(partialStart);
	//List<WebElement> events = randomScenariospage.todayEvent(partialStart);
	basepage.explicitwaitlocator(By.xpath("//div[contains(@onmouseover, '"+partialStart+"') and .//a[normalize-space(text())='Other']]"),20);
	WebElement todayEvent = driver.findElement(By.xpath("//div[contains(@onmouseover, '"+partialStart+"') and .//a[normalize-space(text())='Other']]"));
	List<WebElement> events = todayEvent.findElements(By.xpath(".//a[contains(text(), 'Other')]"));
	
	Assert.assertFalse(events.isEmpty(), "The list of events should not be empty");
	
	}
	@AfterMethod
	public void teardown() {
		//screenshot.takeScreenShot(driver);
	closebrowser();
		
	}
	
	
}
