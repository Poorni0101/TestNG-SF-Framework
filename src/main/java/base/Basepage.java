package base;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basepage {
static WebDriver driver;
public Basepage(WebDriver driver) {
	this.driver=driver;
 PageFactory.initElements(driver,this);
}
public void waitforElement(WebElement element,int time) {
	WebDriverWait wait = new WebDriverWait(driver, time);
	wait.until(ExpectedConditions.visibilityOf(element));
}
public void click(WebElement element) {
	waitForElementToBeClickable(element);
	element.click();
}
public void waitForElementToBeClickable(WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.elementToBeClickable(element));
	
}
public void type(WebElement element, String text) {
	waitForElementToBeVisible(element);
	element.clear();
	element.sendKeys(text);
}
public void waitForElementToBeVisible(WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOf(element));
	
}
public String getText(WebElement element) {
	waitForElementToBeVisible(element);
	return element.getText();
}

public void selectByVisibleTex(WebElement element, String text) {
	Select dropdown = new Select(element);
	dropdown.selectByVisibleText(text);
}

public void selectByIndex(WebElement element, int i) {
	Select dropdown = new Select(element);
	dropdown.selectByIndex(i);
}

public String getFirstSelectedOption(WebElement element) {
	Select dropdown = new Select(element);
	return dropdown.getFirstSelectedOption().getText();
}
public void switchToWindow() {
	String orginalWindow = driver.getWindowHandle();
	new WebDriverWait(driver, 20).until(driver -> driver.getWindowHandles().size()>1);
	for(String handle:driver.getWindowHandles()) {
		if(!orginalWindow.equals(handle)) {
		driver.switchTo().window(handle);
		System.out.println("Child window - "+driver.getTitle());
					return;
		}
	}
}


public String generateTimeStamp() {
	String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	return timestamp;
}
}
