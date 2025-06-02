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


public class Leadspage extends Basepage {
	
	
 public Leadspage(WebDriver driver) {
		super(driver);
	}
 
 @FindBy(xpath = "//a[text()='Leads']")
 WebElement leadsTab;
 
 public WebElement getLeadTabelement() {
	 return leadsTab;
 }
 public void clickLeadsTab() {
 leadsTab.click();
 
 }
 
 @FindBy(xpath = "//h1[@class='pageType']")
 WebElement checkLeads;
 
 public String actualResult() {
	 return checkLeads.getText();
 }
 @FindBy(id = "fcf")
 WebElement viewDropdown;
 
 

 
 public List<String> selectViewDropdown() {
	 Select select = new Select(viewDropdown);
		List<WebElement> options = select.getOptions();
		List<String> actualoptions = new ArrayList<>();
		for(WebElement option : options) {
			
			actualoptions.add(option.getText());
		}
	return 	actualoptions;
 }
 
 public void viewDropdow() {
	 Select select = new Select(viewDropdown);
		select.selectByVisibleText("My Unread Leads");
 }
 @FindBy(xpath = "//input[@title='Go!']")
 WebElement goButton;
 
 public void clickGoButton() {
	 goButton.click();
 }
 public WebElement goButtonElement() {
	 return goButton;
 }
 
 @FindBy(xpath = "//select[@title='View:']" )
 WebElement actualdropdown;
 
 public String actualDropdown() {
	 Select select = new Select(actualdropdown);
		WebElement selectedoption = select.getFirstSelectedOption();
		String actual = selectedoption.getText();
		return actual;
 }

public void selectTodaysLeads() {
	 Select select = new Select(viewDropdown);
		select.selectByVisibleText("Today's Leads");	
}

@FindBy(name ="fcf" )
WebElement todaysLeadsDropdown;
public WebElement todaysLeadsDropdownElement() {
	return todaysLeadsDropdown;
}
public String getVisibleTodaysLeadsDropdown() {
	 Select select = new Select(todaysLeadsDropdown);
	 WebElement actualR = select.getFirstSelectedOption();
	  return actualR.getText();
}
@FindBy(xpath = "//input[@title='New']")
WebElement newButton;
public void clickNewButton() {
	newButton.click();
}

@FindBy(id = "name_lastlea2")
WebElement lastName;

public void typeLastName() {
	lastName.sendKeys("ABCD");
}
@FindBy(id = "lea3")
WebElement company;

public void typeCompany() {
	company.sendKeys("ABCD");
}
@FindBy(name = "save")
WebElement saveButton;
public void clickSaveButton() {
	saveButton.click();
}
@FindBy(xpath = "//h2[@class='pageDescription']") //changed from id = lea2_ilecell
WebElement checkName;
public WebElement checkNameElement() {
	return checkName;
}
public String getCheckName() {
	return checkName.getText();
}


}