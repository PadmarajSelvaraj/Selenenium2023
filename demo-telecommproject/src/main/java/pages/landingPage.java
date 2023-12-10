package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wrapper.wrapperMethods;

public class landingPage extends wrapperMethods {
	
	WebDriver driver;
	
	@FindBy(linkText ="Telecom Project")
	WebElement Telecomlink;
	

	@FindBy(xpath ="//div[@id='dismiss-button']")
	WebElement dismissbutton;
	
	@FindBy(xpath ="//iframe[contains(@id,'google_ads')]")
	WebElement parentAddFrame;
	
	@FindBy(xpath ="//iframe[contains(@id,'ad_iframe')]")
	WebElement AddiFrame;
	
	
	
	
	public landingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void clickTelecomLink() {
		
		clickElementByLinktest(Telecomlink);
	}

	public void closeAdvertiment() {
		
		if(parentAddFrame.isDisplayed()) {
		
		switchToFrame(driver, parentAddFrame);
		
		switchToFrame(driver, AddiFrame);
		
		dismissbutton.click();
		 
		driver.switchTo().defaultContent();
	}
	}
	
}
