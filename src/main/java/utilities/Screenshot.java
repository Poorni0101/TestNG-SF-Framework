package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public void takeScreenShot(WebDriver driver) {
		
		//creating a Takescreenshot object using the driver
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		
		//Converting Takescreenshot object to File object using the getScreenshotAs method
		
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		Date currentDate = new Date();
		String timestamp = new SimpleDateFormat("YYYY-MM-dd HH-mm-ss").format(currentDate);
		
		//create an img format -png
		String projectpath = System.getProperty("user.dir");
		String filePath = projectpath+"/screenshots/tekarch"+timestamp+".png";
		
		//Create an File object to store the screenshot
		File destfile = new File(filePath);
		
		try {
			FileUtils.copyFile(srcFile, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
