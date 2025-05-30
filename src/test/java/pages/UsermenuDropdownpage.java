package pages;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.Basepage;

public class UsermenuDropdownpage extends Basepage {

	public UsermenuDropdownpage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "userNavLabel") 
	WebElement usermenudropdown;
	
	//get usermenu drop down element for wait
	public WebElement getUsernameDropdownElement() {
		 return usermenudropdown;
		 }
	public void clickUsermenuDropdown () {
		 usermenudropdown.click();
	 }
	 public WebElement userNameDropdownPresent() {
		 return usermenudropdown;
	 }
	 
	 @FindBy(xpath = "//a[@title='My Profile']")
	 WebElement myprofile;
	 
	 @FindBy(xpath = "//a[@title='My Settings']")
	 WebElement mysettings;
	 
	 @FindBy(xpath = "//a[@title='Developer Console (New Window)']")
	 WebElement devconsole;
	 
	 @FindBy(xpath = "//a[@title='Switch to Lightning Experience']")
	 WebElement lconsole;

	 @FindBy(xpath = "//a[@title='Logout']")
	 WebElement logout;
	 
	 public String myProfile() {
		 return myprofile.getText();
	 }
	 public String mySettings() {
		 return mysettings.getText();
	 }
	 public String devConsole() {
		 return devconsole.getText();
	 }
	 public String lConsole() {
		 return lconsole.getText();
	 }
	 public String logout() {
		 return logout.getText();
	 }
	 
@FindBy(xpath ="//a[@title='Feed']")
WebElement myProfilePage; //to validate if we are in my profile page

public void clickMyProfile() {
	myprofile.click();
}
@FindBy(xpath="//a[@class='contactInfoLaunch editLink']")
WebElement pencilIcon;
public WebElement pencilIconElement() {
	return pencilIcon;
}

public void clickPencilIcon() {
	pencilIcon.click();
}

//elements and action for iframe
@FindBy(id="contactInfoContentId")
WebElement iframe;

public WebElement getFrameElement() {
	return iframe;
}

// elements inside iframe 
@FindBy(id="aboutTab")
WebElement aboutTab;

public void clickAboutTab() {
	aboutTab.click();
}

@FindBy(id="lastName")
WebElement lastName;

public void enterLastName() {
	lastName.clear();
	lastName.sendKeys("XYZ");
}
public void enterLastNameR() {
	
	String name = "Abcd";
	String lname = lastName.getAttribute("value");
	if(lname.equals(name)) {
		lastName.clear();
	lastName.sendKeys("XYZ");}
	else {
		lastName.clear();
		lastName.sendKeys("Abcd");}
}
@FindBy(xpath="//input[@value='Save All']")
WebElement saveAllButton;

public void clickSaveAllButton() {
	saveAllButton.click();
}

@FindBy(xpath="//span[@id='tailBreadcrumbNode']")
WebElement username;

public String getUsernametoCheck() {
	return username.getText();
}
//Post elements and action
@FindBy(xpath="//span[text()='Post']")
WebElement postTab;
public WebElement postTabElement() {
	return postTab;
}

public void clickPost() {
 postTab.click();
}

//finiding post iframe
@FindBy(tagName = "iframe" )
WebElement postIframe;

@FindBy(xpath = "//body[text()='Share an update, @mention someone...']")
WebElement enterPost;

public void enterInfoToPost() {
	enterPost.sendKeys("Entering through automation TestNG framework");
}

@FindBy(id="publishersharebutton")
WebElement postShareButton;

public void clickPostShareButton() {
	postShareButton.click();
}




public void clickMysettings() {
	mysettings.click();
}
	@FindBy(id = "PersonalInfo_font")
	WebElement pesonal;

	
	public void clickPersonal() {
		pesonal.click();
	}
	
	@FindBy(id="LoginHistory_font")
	WebElement loginHistory;
	
	public void clickLoginHistory() {
		loginHistory.click();
	}
	
	@FindBy(xpath = "//h1[text()='Login History']")
	WebElement titleLoginHistory;
	
	public String getLoginHistoryTitle() {
		return titleLoginHistory.getText();
	}
	@FindBy(xpath = "//a[@href='/servlet/servlet.LoginHistory?id=005gK0000021qg9']")
	WebElement csvLink;
	
	public String getCsvLinkText() {
		return csvLink.getText();
	}
	
	@FindBy(xpath = "//span[text() = 'Display & Layout']")
	WebElement displayLayoutLink;
	
	public void clickDisplayLayoutLink() {
		displayLayoutLink.click();
	}
	
	@FindBy(id = "CustomizeTabs_font")
	WebElement customizeTab;
	
	public void clickCustomizeTab() {
		customizeTab.click();
	}
	
	@FindBy(id = "p4")
	WebElement customDropdown;
	
	public void clickCustomDropdown() {
		Select customDropdownOption = new Select(customDropdown);
		customDropdownOption.selectByVisibleText("Salesforce Chatter");
	}
	
	@FindBy(id ="duel_select_1")
	WebElement selectedDropdown;
	
	@FindBy(id = "duel_select_0")
	WebElement avaiableDropdown;
	
	@FindBy(xpath = "//img[@class ='rightArrowIcon']")
	WebElement addButton;
	
	public void isSelectedAddedAlready() {
		Select selectdrop = new Select(selectedDropdown);
		boolean alreadyAdded = false;
		for(WebElement option :selectdrop.getOptions()) {
			if(option.getText().equals("Reports")) {
				alreadyAdded = true;
				break;
			}
		}
		
		if(!alreadyAdded) {
			
			Select addDrop = new Select(avaiableDropdown);
			addDrop.selectByVisibleText("Reports");
		}
		
	}
		
		public void clickAddButton() {
			addButton.click();
		}
		
		@FindBy(name = "save")
		WebElement saveButton;
		
		public void clickSaveButton() {
			saveButton.click();
		}
	//elements and action for EmailLink
		@FindBy(id="EmailSetup_font")
		WebElement email;
		public void clickEmail() {
			email.click();
		}
		@FindBy(id ="EmailSettings_font")
		WebElement myEmailSetting;
		public void clickMyEmailSetting() {
			myEmailSetting.click();
		}
		
		
		@FindBy(id = "sender_name")
		WebElement emailName;
		public WebElement emailNameElement() {
			return emailName;
		}
		public void enterEmailName() {
			emailName.clear();
			emailName.sendKeys("Poorni R");
		}
		@FindBy(id = "sender_email")
		WebElement emailAddress;
		public void enterEmailAddress() {
			emailAddress.clear();
			emailAddress.sendKeys("poornir@gmail.com");
		}
		@FindBy(id = "auto_bcc1")
		WebElement automaticBcc;
		public void clickAutomaticBcc() {
			automaticBcc.click();
		}
		@FindBy(name= "save")
		WebElement saveButton1;
		public void clickSaveButtonEmail() {
			saveButton1.click();
		}
		//validate email
		@FindBy (xpath = "//div[text()='Your settings have been successfully saved.']")
		WebElement message;
		
		public String getMessageDisplayed() {
			return message.getText();
		}
		
		//calender Reminder Elements and action
		@FindBy(id = "CalendarAndReminders_font")
		
		WebElement calenderReminderLink;
		public void clickCalenderReminderLink() {
			calenderReminderLink.click();
		}
		@FindBy(id = "Reminders_font")
		WebElement activityReminder;
		
		public void clickActivityReminder() {
			activityReminder.click();
		}
		@FindBy(id = "testbtn")
		WebElement testReminderButton;
		
		public void clickTestReminderButton() {
			testReminderButton.click();
		}
		@FindBy(xpath = "//a[@title='Developer Console (New Window)']")
		WebElement developerConsole;
		
		public void clickDeveloperConsole() {
			developerConsole.click();
		}
		@FindBy(xpath = "//a[text()='Home']") 
		WebElement hometab;
		public WebElement homeTabElement() {
			return hometab;
		}
		
		@FindBy(xpath = "//span[text()='Post']")
		WebElement postButton;
		
		public WebElement postButtonElement() {
			return postButton;
		}
		
		@FindBy(tagName =  "iframe")
		WebElement postiFrame;
		
		public WebElement postiFrameElement() {
			return postiFrame;
		}
}

