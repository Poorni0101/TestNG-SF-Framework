package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.Basepage;


public class Loginpage extends Basepage {
	
	
 public Loginpage(WebDriver driver) {
		super(driver);
	}
 @FindBy(id="username")
	WebElement userName;
 public WebElement getUserNameElement() {
	 return userName;
 }

	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="Login") 
	WebElement loginButton;
	
	@FindBy(id="rememberUn")
	WebElement checkbox;
	
	
	
	@FindBy(xpath = "//a[@title='Logout']")
	WebElement logoutButton;
	
	@FindBy(id="idcard-identity")
	WebElement userNameRelocated;
	
	@FindBy(id="rememberUn")
	WebElement checkboxRelocated;
	
	@FindBy(id="error")
	WebElement errorMessage;
	
	@FindBy(id="forgot_password_link")
	WebElement forgotPasswordLink;
	
	@FindBy(id="un")
	WebElement enterUsername;
	
	@FindBy(id = "continue")
	WebElement continueButton;
	
	public void clickContinueButton() {
		continueButton.click();
	}
	
	@FindBy(id = "header")
	WebElement checkYourEmailMsg;
	
	public String checkYourEmailMsg() {
		return checkYourEmailMsg.getText();
	}
	
	public  void wrongUsername() {
		userName.sendKeys("123");
	}
	public void wrongPassword() {
		password.sendKeys("12345");
	}
	
	@FindBy(id="error")
	WebElement errormsg;
	
	public WebElement checkUsernamePswdMsg() {
		return errormsg;
	}
	
public void enterintoEmail(String strEmail)
{
	userName.sendKeys(strEmail);
	 }
 public WebElement enterintoEmailElement() {
	 return userName;
 }
 public void enterintoPassword(String strPassword)
{
	 password.sendKeys(strPassword);
	 }
 
 public void clickonLoginButton() {
	 loginButton.click();
	 
	
 }
 public WebElement loginButtonElement() {
	 return loginButton;
 }
 public void clickRememberCheckbox() {
	 checkbox.click();
 }
//get username element from loginpage for tc9
 public WebElement getUserName() {
	 return userName;
 }

//get username element from loginpage
public WebElement getUsernameElement() {
	return userNameRelocated;
}
 
 public void logoutButton () {
	 logoutButton.click();
	 
 }

 //check if username field is displayed
 public boolean usernameDisplayed() {
	 return userNameRelocated.isDisplayed();
 }
 //get the username value
 public String getUsernameValue() {
	 return userNameRelocated.getText();
 }
 public WebElement ischeckBoxChecked() {
	 return checkboxRelocated;
 }
 

 public WebElement errorMessageDisplayed() {
	 return errorMessage;
 }
 
 public void forgotPasswordLink() {
	 forgotPasswordLink.click();
 }
 public void enterUsernameForgotPassword() {
	 enterUsername.sendKeys("poornitha.rameshkumar594@agentforce.com");
 }
}
