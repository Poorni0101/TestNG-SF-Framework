package base;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Propertiesfile;

public class Basetest {
public WebDriver driver;
Propertiesfile property = new Propertiesfile();


	public WebDriver launchapplication() {
		if(driver==null) {
			
			String browser = property.getProperty("browser");
			
			System.out.println("B  "+browser);
			
			
		if(browser.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		System.out.println("Chrome launched");
		} else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		}
		String url = property.getProperty("url");
		System.out.println("url  "+url);
		driver.get(url);
		return driver;
	}
	public void closebrowser() {
		driver.close();
		driver=null;
	}
}

