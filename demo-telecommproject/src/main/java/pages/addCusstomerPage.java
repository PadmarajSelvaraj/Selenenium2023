package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.base;
import wrapper.wrapperMethods;

public class addCusstomerPage extends base {
	
	private static final Logger log = LogManager.getLogger(addCusstomerPage.class);
	
	WebDriver driver;
	
	@FindBy(xpath ="//*[@id='main']/div/form/div/div[1]/label")
	WebElement donebutton;
	
	@FindBy(xpath ="//*[@id='main']/div/form/div/div[2/label")
	WebElement pendingbutton;
	
	@FindBy(xpath ="//input[@id='fname']")
	WebElement firstName;
	
	@FindBy(xpath ="//input[@id='lname']")
	WebElement lastName;
	
	@FindBy(xpath ="//input[@id='email']")
	WebElement emailAddress;
	
	@FindBy(xpath ="//*[@class='12u$']/following::div[4]/textarea")
	WebElement homeAddress;
	
	@FindBy(xpath ="//*[@class='12u$']/following::div[5]/input")
	WebElement mobileNumber;
	
	
	@FindBy(xpath ="//*[@id='main']/div/form/div/div[9]/ul/li[1]/input")
	WebElement submitButton;
	
	
	@FindBy(xpath ="//*[@id='main']/div/form/div/div[9]/ul/li[2]/input")
	WebElement resetButton;
	
	
	public addCusstomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void selectBackgroundRadiobutton(String chboxValue) {
		
		if(chboxValue.equalsIgnoreCase("done")) {
			
			clickRadiobutton(donebutton);
		}
		else if(chboxValue.equalsIgnoreCase("pending")) {
			
			clickRadiobutton(pendingbutton);
		}
		
		
	}
	
    public void enterFirstName(String val) {
		
		enterText(firstName,val);
		
	}

	
	public void enterlastName(String val) {
		
		enterText(lastName,val);
		
	}
	
	public void enteremailAddress(String val) {
		
		enterText(emailAddress,val);
		
	}
	
	public void enterhomeAddress(String val) {
		
		enterText(homeAddress,val);
		
	}
	
	public void entermobileNumber(String val) {
		
		enterText(mobileNumber,val);
		
	}
	
	public void clickSubmitButton() {
		
		clickbutton(submitButton);
		
	}
	
	public void clickRestButton() {
		
		clickbutton(resetButton);
		
	}
	

	

	

	
}
