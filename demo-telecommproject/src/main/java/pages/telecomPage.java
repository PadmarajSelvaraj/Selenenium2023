package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wrapper.wrapperMethods;

public class telecomPage extends wrapperMethods {
	
	WebDriver driver;
	
	@FindBy(linkText ="Add Customer")
	WebElement Customer;
	
	
	public telecomPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void Addcustomer() {
		
		clickElementByLinktest(Customer);
	}


	
}
