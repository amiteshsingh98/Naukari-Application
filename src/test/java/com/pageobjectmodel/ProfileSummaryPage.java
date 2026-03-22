package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.ProfileSummaryInterfaceElements;
import com.utility.ExcelUtility;

public class ProfileSummaryPage extends Base_Class implements ProfileSummaryInterfaceElements{
	@FindBy(xpath = addProfileSummary_xpath)
	WebElement addProfileSummary;
	
	@FindBy(id = profileSummary_id)
	WebElement profileSummary;
	
	@FindBy(xpath = save_xpath)
	WebElement save;
	
	public ProfileSummaryPage() {
		PageFactory.initElements(driver, this);
				
	}
	
	public void profileSummaryUpdate() throws IOException {
		explicitWait(addProfileSummary, 15, "clickable");
		clickOnElement(addProfileSummary);
		
		passInput(profileSummary, ExcelUtility.getCellValue("Data", "ID", "Profile summary"));
		
		explicitWait(save, 15, "clickable");
		clickOnElement(save);

	}

}
