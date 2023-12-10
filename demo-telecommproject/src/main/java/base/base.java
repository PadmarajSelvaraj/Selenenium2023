package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import wrapper.wrapperMethods;


public class base extends wrapperMethods {

	protected static WebDriver driver;
	
	protected Logger log = LogManager.getLogger();
	
	
	@BeforeMethod()
	public void invokeBrowser() {
		String configPath = System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
		Properties pro = null;
		try {
			FileInputStream fis = new FileInputStream(configPath);
			
			pro = new Properties();
			try {
				pro.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String browser = pro.getProperty("browser");
			System.out.println(browser);
			log.info("the browser name is "+browser);
			
			switch (browser.toLowerCase()) {
			
			case "chrome":
				driver = new ChromeDriver();
				break;
			
			case "firefox":
				driver = new FirefoxDriver();
				break;
			
			case "edge":
				driver = new EdgeDriver();
				break;
				
			 default:
				 System.out.println("Invalid browser specified in the config file");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.get(pro.getProperty("url"));
		
		
		
	}
	
	
	  @AfterMethod public void teardown() {
	  
	  if(driver!=null) {
	  
	  driver.quit(); } }
	 
	
}
