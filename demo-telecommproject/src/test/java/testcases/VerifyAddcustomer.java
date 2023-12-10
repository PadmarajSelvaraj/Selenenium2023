package testcases;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import base.base;
import pages.addCusstomerPage;
import pages.landingPage;
import pages.telecomPage;
import utils.readExcel;

public class VerifyAddcustomer extends base{
	Logger log = LogManager.getLogger();

	@Test(dataProvider = "exceldata", dataProviderClass = readExcel.class)
	public void addcustomer(Map<String,String> data) {
	
		landingPage landpage = new landingPage(driver);
		landpage.clickTelecomLink();
		landpage.closeAdvertiment();
		
		telecomPage tele = new telecomPage(driver);
		tele.Addcustomer();
		log.info("Navigated to add customer page");
		addCusstomerPage customeradd = new addCusstomerPage(driver);
		customeradd.selectBackgroundRadiobutton("done");
		customeradd.enterFirstName(data.get("firstName"));
		customeradd.enterlastName(data.get("lastName"));
		customeradd.enteremailAddress(data.get("emailAddress"));
		customeradd.entermobileNumber(data.get("mobileNumber"));
		customeradd.enterhomeAddress("homeAddress");
		customeradd.clickSubmitButton();
	}
	


}
