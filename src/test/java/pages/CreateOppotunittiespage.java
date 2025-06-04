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


public class CreateOppotunittiespage extends Basepage {
	
	
 public CreateOppotunittiespage(WebDriver driver) {
		super(driver);
	}
 
 @FindBy(id = "Opportunity_Tab")
 WebElement opportunities;
 
public void clickOpportunities() {
	opportunities.click();
}
public WebElement opportunitiesTab() {
	return opportunities;
}
 
 @FindBy(id ="fcf")
 WebElement dropdown;
 
 public List<String> actualListOption() {
	 Select select = new Select(dropdown);
		
		List<WebElement> options = select.getOptions();
		List<String> actualoptions = new ArrayList<>();
		for(WebElement option : options) {
			
			actualoptions.add(option.getText());
		}
	return 	actualoptions;
 }
 public List<String>  expectedListOption() {
	 
		List<String> expectedOptions = Arrays.asList("All Opportunities",
				"Closing Next Month","Closing This Month","My Opportunities",
				"New This Week","Recently Viewed Opportunities","Won");
return expectedOptions;
 }
 
 @FindBy(name = "new")
 WebElement newButton;
 
 public void clickNewButton() {
	 newButton.click();
 }
 
 @FindBy(id="opp3")
 WebElement oppName;
 
 public void typeOppoName() {
	 oppName.sendKeys("newautoopp");
 }
 @FindBy(id="opp4")
 WebElement accountName;
 
 public void typeAccountName() {
	 accountName.sendKeys("Marshalls");
 }
 @FindBy(id="opp9")
 WebElement closedate;
 
 public void clickCloseDate() {
	 closedate.click();
 }
 @FindBy(xpath = "//a[@class='calToday']")
 WebElement todayDate;
 
 public void clickTodayDate() {
	 todayDate.click();
 }
 @FindBy(id="opp7")
 WebElement changefocus;
 
 public void clickChangeFocus() {
	 changefocus.click();
 }
 @FindBy(id="opp11")
 WebElement stageDropdown;
 
 public void selectStageDropdown() {
	 Select select = new Select(stageDropdown);
		select.selectByVisibleText("Needs Analysis");
}
 @FindBy(id="opp6")
 WebElement leadsrcDropdown;
 
 public void selectLeadSourceDropdown() {
	 Select	 select = new Select(leadsrcDropdown);
		select.selectByVisibleText("Phone Inquiry");
}
 @FindBy(name = "save")
 WebElement saveButton;
 
 public void clickSaveButton() {
	 saveButton.click();
	
}
 @FindBy(id = "opp3_ileinner")
 WebElement actual;
 public WebElement actualResultElement() {
	 return actual;
 }
 
 public String actualResult() {
	return actual.getText();
}
 @FindBy(xpath = "//a[text()='Opportunity Pipeline']")
 WebElement oPipeline;
 
 public void clickOppoPipeLine() {
	 oPipeline.click();
	
}
 @FindBy(xpath ="//h2[text()='Report Generation Status:']" )
 WebElement actualResult;
 
 public String actualReportName() {
	 return actualResult.getText();
 }
 @FindBy(xpath = "//a[text()='Stuck Opportunities']")
 WebElement stuckOpportunities;
 
 public void clickStuckOppo() {
	 stuckOpportunities.click();
	 
 }
 @FindBy(xpath= "//h1[text()='Stuck Opportunities']")
 WebElement stuckReport;
 
 public String getStuckReport() {
	 return stuckReport.getText();
 }
 @FindBy(id ="quarter_q")
 WebElement intervalDropdown;
 
 public void selectIntervalDropdown() {
	 Select select = new Select(intervalDropdown);
		select.selectByVisibleText("Next FQ");
 }
 @FindBy(id ="open")
 WebElement includeDropdown;
 
 public WebElement getIncludeDropdownElement() {
	 return includeDropdown;
 }
 
 public void selectIncludeDropdown() {
	 Select select = new Select(includeDropdown);
	 select.selectByVisibleText("All Opportunities");
 }
 @FindBy(xpath = "//input[@title='Run Report']")
 WebElement runReport;
 public void clickRunReport() {
	 runReport.click();
 }
	 @FindBy(xpath = "//h1[text()='Opportunity Report']")
	WebElement report;
	
public String getActualReport() {
	return report.getText();
}

 
}
