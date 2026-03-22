package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.LogoutInterfaceElements;

public class LogoutPage extends Base_Class implements LogoutInterfaceElements {
	@FindBy(xpath = userProfile_xpath)
	WebElement userProfile;
	
	@FindBy(xpath = logout_xpath)
	WebElement logout;
	
	public LogoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void logout() {
		explicitWait(userProfile, 15, "clickable");
		clickOnElement(userProfile);
		
		explicitWait(logout, 15, "element visible");
		clickOnElement(logout);
	}

}
