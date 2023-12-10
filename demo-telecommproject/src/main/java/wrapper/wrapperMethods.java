package wrapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class wrapperMethods {
	
	protected Logger log = LogManager.getLogger();
	
	public void clickElementByLinktest(WebElement ele) {
		
		ele.click();
		
	}
	
	public void switchToFrame(WebDriver driver,WebElement ele) {
		
		driver.switchTo().frame(ele);
	}
	
	
	public void clickRadiobutton(WebElement ele) {
		
		if(!ele.isSelected()) {
			
			if(ele.isEnabled()) {
				
				ele.click();
			}
		}
	}
	
	

	public void clickbutton(WebElement ele) {
			
			if(ele.isEnabled()) {
				
				ele.click();
			}
		}
	
	
	public void enterText(WebElement ele,String val) {
		
		ele.sendKeys(val);
		
	}
	
	
public  String takeScreenshot(WebDriver driver, String Filename) {
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"\\Screenshots\\"+ Filename+".png";
		
		
		try {
		
			FileUtils.copyFile(src, new File(dest));
			log.info("Screenshot captured sucessfully");
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		return dest;
		
	}
	
	
	public static LocalDateTime getCurrentDate() {
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		 LocalDateTime date = LocalDateTime.now();  
		 return date;
	}
	

}
