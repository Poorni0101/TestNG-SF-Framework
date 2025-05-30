package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.Basepage;

public class Contactspage extends Basepage {

	public Contactspage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[text()='Contacts']")
	WebElement contactsTab;

	public WebElement contactsTabElement() {
		return contactsTab;
	}

	@FindBy(name = "new")
	WebElement newButton;

	public WebElement newButtonElement() {
		return newButton;
	}

	@FindBy(id = "name_lastcon2")
	WebElement lastName;

	public WebElement lastNameTextboxElement() {
		return lastName;
	}

	@FindBy(id = "con4")
	WebElement accountName;

	public WebElement accountNameTextboxElement() {
		return accountName;
	}

	@FindBy(name = "save")
	WebElement saveButton;

	public WebElement saveButtonElement() {
		return saveButton;
	}

	@FindBy(xpath = "//h2[@class='pageDescription']")
	WebElement pageDescription;

	public WebElement pageDescriptionElement() {
		return pageDescription;
	}

	@FindBy(xpath = "//a[@href ='/ui/list/FilterEditPage?ftype=c&retURL=%2F003&cancelURL=%2F003%2Fo']")
	WebElement createNewView;

	public WebElement createNewViewElement() {
		return createNewView;
	}

	@FindBy(id = "fname")
	WebElement viewName;

	public WebElement viewNameElement() {
		return viewName;
	}

	@FindBy(id = "devname")
	WebElement viewUniqueName;

	public WebElement UniqueViewNameElement() {
		return viewUniqueName;
	}

	@FindBy(xpath = "//select[@name='fcf']")
	WebElement verifyNameDropdown;

	public WebElement verifyNameDropdownElement() {
		return verifyNameDropdown;
	}

	@FindBy(xpath = "//select[@name='hotlist_mode']")
	WebElement recentlyCreated;

	public WebElement recentlyCreatedDropdownElement() {
		return recentlyCreated;
	}

	@FindBy(xpath = "//table[@class='list']//tr[contains(@class, 'dataRow')][1]/th/a")
	WebElement firstName;

	public WebElement firstNameElement() {
		return firstName;
	}

	@FindBy(xpath = "//table[@class=\"list\"]//tr/td/preceding-sibling::th[a[text()=\"Indian\"]]")
	List<WebElement> columnName;

	public boolean checkIfThereAreValues() {
		return !columnName.isEmpty();

	}

	@FindBy(xpath = "(//tr[contains(@class,'dataRow')]//th/a)[1]" )
	WebElement firstAccount;
	
	public WebElement firstAccountElement() {
		return firstAccount;
	}
	
	@FindBy(xpath = "//h2[@class ='pageDescription']")
	WebElement heading;
	
	public WebElement headingElement() {
		return heading;
	}
	
	@FindBy(xpath = "//a[text()='Create New View']")
	WebElement createNewViewLink;


public WebElement createNewViewLinkElement() {
	return createNewViewLink;
}

@FindBy(xpath = "//div[@class='errorMsg']")
WebElement errorMessage;

public WebElement errorMessageElement() {
	return errorMessage;
}

@FindBy(name = "cancel")
WebElement cancelButton;
public WebElement cancelButtonElement() {
	return cancelButton;
}
@FindBy(xpath = "//a[@href='/003gK000002BbzC']")
WebElement checkValue;
public WebElement checkValueElement() {
	return checkValue;
}
@FindBy(xpath = "//img[@title='Account Name Lookup (New Window)']")
WebElement searchAccountName;
public WebElement searchAccountNameElement() {
	return searchAccountName;
}
@FindBy(xpath ="//input[@placeholder='Search...']" )
WebElement textbox;
public WebElement textboxElement() {
	return textbox;
}
@FindBy(xpath = "//input[@name='go']")
WebElement goButton;
public WebElement goButtonElement() {
	return goButton;
}
@FindBy(xpath = "//tr[contains(@class,'dataRow')]//a")
WebElement accountNameDisplayed;
public WebElement accountNameDisplayedElement() {
	return accountNameDisplayed;
}

}