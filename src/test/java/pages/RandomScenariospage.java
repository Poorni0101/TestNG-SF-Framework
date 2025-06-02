package pages;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.Basepage;

public class RandomScenariospage extends Basepage {
	Basepage basepage;
		
	 public RandomScenariospage(WebDriver driver) {
				super(driver);
			}
	 
	 @FindBy(xpath = "//a[@title='Home Tab - Selected']")
	 WebElement homeTab;
	 
	 public WebElement homeTabElement() {
		 return homeTab;
	 }
	 
	 @FindBy(id = "userNavLabel")
	 WebElement userNameLink;
	 
	 public WebElement userNameLinkElement() {
		 return userNameLink;
	 }
	 
	 @FindBy(partialLinkText = "Poornitha")
	 WebElement poornithaLink;
	 public WebElement poornithaLinkElement() {
		 return poornithaLink;
	 }
	 
	 @FindBy(id = "tailBreadcrumbNode")
	 WebElement displayedHomeName;
	 public WebElement displayedHomeNameElement() {
		 return displayedHomeName;
	 }
	 
	 public String getDisplayedHomeName() {
		  return displayedHomeName.getText();
	 }
	 
	 @FindBy (id ="userNavLabel")
	 WebElement userNameDropdown;
	 
	 public WebElement userNameDropdownElement() {
		 return userNameDropdown;
	 }
	 
	 @FindBy(xpath = "//a[@title='My Profile']")
	 WebElement myProfile;
	 public WebElement myProfileElement() {
		 return myProfile;
	 }
	 @FindBy(id = "tailBreadcrumbNode")
	 WebElement displayedMyProfileName;
	 
	 public WebElement displayedMyProfileNameElement() {
		 return displayedMyProfileName;
	 }
	 
	 @FindBy(id = "tabBar")
	 WebElement tabBar;
	 public WebElement tabBarElement() {
		 return tabBar;
	 }
	 
	 @FindBy(xpath = "//ul[@id='tabBar']/li")
	 List<WebElement> tabBarBefore;
	 public int tabBarListBeforeSize() {
		 return tabBarBefore.size();
	 }
	 
	 @FindBy(xpath = "//img[@class='allTabsArrow']")
	 WebElement plusButton;
	 public WebElement plusButtonElement() {
		 return plusButton;
	 }
	 @FindBy(name = "customize")
	 WebElement customizeButton;
	 
	 public WebElement customizeButtonElement() {
		return customizeButton;
	}
@FindBy(id = "duel_select_1")
WebElement selectedTab;

public WebElement selectedTabElement() {
	return selectedTab; 
	
}

@FindBy(xpath = "//img[@class ='leftArrowIcon']")
WebElement removeButton;

public WebElement removeButtonElement() {
	return removeButton;
}

@FindBy(name = "save")
WebElement saveButton;

public WebElement saveButtonElement() {
	return saveButton;
}
@FindBy(id = "userNavLabel")
WebElement userMenuDroprown;
public WebElement userMenuDropdownElement() {
	return userMenuDroprown;
}
@FindBy(xpath = "//a[@title='Logout']")
WebElement logout;
public WebElement logoutElement() {
	return logout;
}

@FindBy (xpath = "//span[@class='pageDescription']/a")
WebElement currentDatelink;
public WebElement currentDatelinkElement() {
	return currentDatelink;
}
@FindBy(xpath = "//h1[@class = 'pageType']" )
WebElement calenderFnameLnameOpened;
public WebElement calenderFnameLnameOpenedElement() {
	return calenderFnameLnameOpened;
}
@FindBy(xpath = "//a[contains(text(), '8:00 PM')]")
WebElement eightPMlink;
public WebElement eightPMlinkElement() {
	return eightPMlink;
}

@FindBy(xpath = "//img[@title='Subject Combo (New Window)']")
WebElement subjectComboIcon;

public void subjectComboIconClick() {
	subjectComboIcon.click();
}

@FindBy(xpath = "//li[@class = 'listItem4']/a")
WebElement otherLink;

public void otherLinkClick() {
	otherLink.click();
	
}

@FindBy(xpath = "//input[@name='EndDateTime_time' and @value='9:00 PM']")
WebElement endTime;
public void endTimeClick() {
	endTime.click();
	
}
@FindBy(id = "timePickerItem_42")
WebElement timePicker;
public void timePickerClick() {
	timePicker.click();
	
}

@FindBy(xpath = "//a[@title='Busy - Other']")
WebElement otherVisibleLink;
public void otherVisibleLinkClick() {
	otherVisibleLink.click();
	
}
@FindBy(xpath = "//h2[@class='pageDescription']")
WebElement actualCalenderEventTitle;

public String getActualCalenderEventTitle() {
	return actualCalenderEventTitle.getText();
}
@FindBy(id = "StartDateTime_ileinner" )
WebElement startDateTime;

public String getStartDateTime() {
	return startDateTime.getText();
}

@FindBy(id = "EndDateTime_ileinner")
WebElement endDateTime;

public String getEndDateTime() {
	return endDateTime.getText();
}
@FindBy(xpath = "//a[contains(text(), '4:00 PM')]")
WebElement fourPMlink;

public void clickFourPMLink() {
	fourPMlink.click();
}
@FindBy(xpath = "//input[@name='EndDateTime_time' and @value='5:00 PM']")
WebElement endTimeBox;
public void clickEndTimeBox() {
	endTimeBox.click();
}

@FindBy(id = "timePickerItem_38")
WebElement timePicker7PM;

public void clickTimePicker7PM() {
	timePicker7PM.click();
}

@FindBy(id = "IsRecurrence")
WebElement checkboxRecurrence;
public void clickCheckboxRecurrence() {
	checkboxRecurrence.click();
}

@FindBy(xpath = "//label[text()='Weekly'] ")
WebElement weeklyRadioButton;
public void clickWeeklyRadioButton() {
	weeklyRadioButton.click();
}
@FindBy(id ="wi")
WebElement recursEveryTextBox;

public String recursEveryTextBoxValue() {
	return  recursEveryTextBox.getAttribute("value");
}
@FindBy(id = "RecurrenceStartDateTime")
WebElement recursEveryStartDate;

public String recursEveryStartDateValue() {
	return  recursEveryStartDate.getAttribute("value");
}

public DateTimeFormatter toFormatTheDate() {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
	return formatter;
}

@FindBy(id ="RecurrenceEndDateOnly")
WebElement recurrenceEndDateOnly;

public void enterrecurrenceEndDateOnly(String endDateValue) {
	recurrenceEndDateOnly.sendKeys(endDateValue);
}
@FindBy (xpath = "//div[contains(@class, 'hourRowLabel')]//a[normalize-space(text())='4:00 PM']")
WebElement timeSlot;

public List<WebElement> recurrenceItemsList() {
	List<WebElement> recurrenceItems = timeSlot.findElements(By.xpath("//div[contains(@class, 'hourRowLabel')]//a[normalize-space(text())='4:00 PM']"));
	return recurrenceItems;
			
	
}

@FindBy(xpath = "//img[@title='Month View']")
WebElement monthViewIcon;
public void clickMonthViewIcon() {
	monthViewIcon.click();
}
@FindBy(xpath = "//h1[contains(text(), 'Poornitha') and contains(text(), 'Month View')]")
WebElement monthViewPageTitle;
public String getMonthViewPageTitle() {
	return  monthViewPageTitle.getText();
}

public List<WebElement> todayEvent(String partialStart) {
	basepage.explicitwaitlocator(By.xpath("//div[contains(@onmouseover, '"+partialStart+"') and .//a[normalize-space(text())='Other']]"),20);
	WebElement todayEvent = driver.findElement(By.xpath("//div[contains(@onmouseover, '"+partialStart+"') and .//a[normalize-space(text())='Other']]"));
	List<WebElement> events = todayEvent.findElements(By.xpath(".//a[contains(text(), 'Other')]"));
	return events;
}

}