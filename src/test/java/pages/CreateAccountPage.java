package pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Basepage;


public class CreateAccountPage extends Basepage {
	

 public CreateAccountPage(WebDriver driver) {
		super(driver);
		//PageFactory.initElements(driver, this);
	}
 @FindBy(xpath = "//a[@title='Accounts Tab']")
 WebElement accountsTab;
 public WebElement accountTab() {
	 return accountsTab;
 }
 
 public void clickAccountsTab() {
	 accountsTab.click();
	
 }
 
 @FindBy(xpath = "//input[@name='new']")
 WebElement newButton;
 
 public void clickNewButton() {
	 newButton.click();
 }
 @FindBy(id = "acc2")
 WebElement accountName;
 
 String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	String accountnamewithdate = "autoaccount_"+timestamp;
 
	public void enterAccountName() {
		accountName.sendKeys(accountnamewithdate);
	}
 @FindBy(id="acc6")
 WebElement typeDropdown;
 
 public void selectTypeDropdown() {
	 Select type = new Select(typeDropdown);
		type.selectByValue("Technology Partner");
}
 
 @FindBy(id = "00NgK00000wxBNq")
 WebElement cusPriority;
 public void selectCusPriority() {
	 Select priority = new Select(cusPriority);
		priority.selectByValue("High");
	}
 @FindBy(name = "save")
 WebElement saveButton;
 public void clickSaveButton() {
	saveButton.click();
}
 //Validation
 
 @FindBy(id = "acc6_ileinner")
 WebElement droptype;
 
public String dropType() {
	String text = droptype.getText();
	return text;
}

@FindBy (xpath = "//a[@href='/ui/list/FilterEditPage?ftype=a&retURL=%2F001&cancelURL=%2F001%2Fo']")
 WebElement createNewViewLink;
public void clickCreateNewViewLink() {
	createNewViewLink.click();
}
@FindBy(id = "fname")
WebElement viewName;
public String enterViewName() {
	String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()); 
	String timestampViewName = "autoviewName"+timestamp;
	 viewName.sendKeys(timestampViewName);
	 String expected = timestampViewName;
	 return expected;
}

@FindBy(id="devname")
WebElement viewuniquename;
public void clickViewUniqueName() {
	viewuniquename.click();
}

@FindBy(name = "save")
WebElement saveButton1;

public void clickSaveButton1() {
	saveButton1.click();
	}

@FindBy(name ="fcf")
WebElement viewdropdown;

public String selectViewDropdown()
{
	Select select = new Select(viewdropdown);
	WebElement selectedoption = select.getFirstSelectedOption();
	 return selectedoption.getText();
}

@FindBy(name = "fcf")
WebElement viewDropdown1;
public void selectFromViewDropdown() {
	Select select = new Select(viewDropdown1);
	//explicitwait(viewdropdown, 30);
	select.selectByIndex(0);
}
public WebElement viewDropdownElement() {
	return viewDropdown1;
}
@FindBy(xpath = "//a[text()='Edit']")
WebElement editButton;
public void clickEditButton() {
	editButton.click();
}
@FindBy(id = "fname")
WebElement viewName1;
public String storeoldViewName() {
String newViewName = viewName1.getAttribute("value");
return newViewName;
}
public String changeViewname(String newViewName) {
	viewName1.clear();
	String newViewNameAdd = "new"+newViewName;
	viewName1.sendKeys(newViewNameAdd);
	return newViewNameAdd;
}
@FindBy(id ="fcol1" )
WebElement filterDropdown;

public void selectFilteredDropdown() {
	Select select0 = new Select(filterDropdown);
	select0.selectByVisibleText("Account Name");
}

@FindBy(id = "fop1" )
WebElement operatordrop;

public void selectOperatorDropdown() {
	Select select1 = new Select(operatordrop);
	select1.selectByVisibleText("contains");
	}

@FindBy(id = "fval1")
WebElement value;

public void enterValue() {
	value.clear();
	value.sendKeys("a");
}
@FindBy(id = "colselector_select_0")
WebElement availableFieldDropDown;

public void selectAvailableFieldDropDown() {
	Select select2 = new Select(availableFieldDropDown);
	boolean optionExists = false;
	for(WebElement option :select2.getOptions()) { // its not throwing exception if Last activity was already added
		if(option.getText().equals("Last Activity")) {
			optionExists = true;
			break;
		}}
		if(optionExists) {
		select2.selectByVisibleText("Last Activity");
		
		}
}

@FindBy(id = "colselector_select_0_right" )
WebElement addButton;
public void clickAddButton() {
	addButton.click();
}
@FindBy(xpath = "//input[@data-uidsfdc='3']")
WebElement saveButton2;

public void clickSaveButton2() {
	saveButton2.click();
}

@FindBy(xpath = "//table//thead//tr[contains(@class, 'x-grid3-hd-row')]/td/div[@title='Last Activity']")
WebElement lastActivityTitle;

public WebElement lastActivityTitle() {
	return lastActivityTitle;
}

public String getLastActivityTitle() {
return 	lastActivityTitle.getText();
	
}

@FindBy(name = "fcf")
WebElement viewDropDown;
public String selectViewDropDown() {
	Select select3 = new Select(viewDropDown);
	WebElement selectedoption = select3.getFirstSelectedOption();
	String actualresult;
	return  actualresult = selectedoption.getText();
}

@FindBy(xpath = "//a[@href='/merge/accmergewizard.jsp?retURL=%2F001%2Fo']")
WebElement mergeAccount;
public void clickMergeAccount() {
	mergeAccount.click();
}

@FindBy(id = "srch")
WebElement searchTextbox;

public WebElement searchTextbox() {
	return searchTextbox;
}
public void enterInSearchTextBox() {
	searchTextbox.sendKeys("au");
	
}

@FindBy(name = "srchbutton")
	WebElement findAccountButton;
	
public void clickFindAccountButton() {
	findAccountButton.click();
}

@FindBy(id = "cid0")
WebElement checkbox1;

public void clickCheckbox1() {
	checkbox1.click();
	
}
@FindBy(id = "cid1")
WebElement checkbox2;
public void clickCheckbox2() {
	checkbox2.click();
}

//capturing table date to verify account name we selected is reflected
@FindBy(xpath = "//table[@class='list']/tbody/tr[2]/td[1]" )
WebElement accountname1;
public String verifyAccountName1() {
	return accountname1.getText();
	
}
@FindBy(xpath = "//table[@class='list']/tbody/tr[3]/td[1]" )
WebElement accountname2;
public String verifyAccountName2() {
	return accountname2.getText();
	
}
@FindBy(name = "goNext")
WebElement nextButton;
public void clickNextButton() {
	nextButton.click();
}
@FindBy(xpath = "//h2[normalize-space()='Step 2. Select the values to retain']")
WebElement step2merging;

public String verifyStep2Merging() {
	return step2merging.getText();
}
@FindBy(xpath = "//table[@class='mergeEntity']/tbody/tr[4]/td[1]")
WebElement accountname1a;

public String getAccountname1a() {
	return accountname1a.getText();
}
@FindBy(xpath = "//table[@class='mergeEntity']/tbody/tr[4]/td[2]")
WebElement accountname2a;
public String getAccountname2a() {
	return accountname1a.getText();
}
@FindBy(xpath = "//input[@title ='Merge']")
WebElement mergebutton;

public void clickMergeButton() {
	mergebutton.click();
}
@FindBy(xpath = "//h1[@class='pageType']")
WebElement accountHomeLabel;

public String getAccountHomeLabel() {
	return accountHomeLabel.getText();
}
@FindBy(xpath = "//a[text()='Accounts with last activity > 30 days']")
WebElement lastActivityLink;

public void clickLastActivityLink() {
	lastActivityLink.click();
	
}
@FindBy(xpath ="//input[@name='dateColumn']" )
WebElement dateField;

public void clickDateField() {
	dateField.click();
}
@FindBy(xpath ="//div[text()='Created Date']")
WebElement dateFieldDropdown;

public void clickDateFieldDropdown() {
	dateFieldDropdown.click();
}
@FindBy(xpath ="//img[@class='x-form-trigger x-form-date-trigger']")
WebElement fromdateicon;
public void clickFromDateIcon() {
	fromdateicon.click();
}
@FindBy(xpath = "//button[text()='Today']")
WebElement todayButton1;
public void clickTodayButton1() {
	todayButton1.click();
}
@FindBy(xpath = "(//img[contains(@class, 'x-form-date-trigger')])[2]")
WebElement toDateIcon;
public void clickToDateIcon() {
	toDateIcon.click();
}
@FindBy(xpath = "(//button[text()='Today'])[2]")
WebElement todayButton2;
public void clickTodayButton2() {
	todayButton2.click();}

@FindBy(xpath = "//table[@id='saveReportBtn']//button[text()='Save']")
WebElement saveButton3;
public void clickSaveButton3() {
	click(saveButton3);
	}
@FindBy(id = "saveReportDlg_reportNameField")
WebElement reportName;

public void reportName(String timestamp) {
	String reportNameTime = "autoReportName" +timestamp;
	reportName.sendKeys(reportNameTime);
}



}
