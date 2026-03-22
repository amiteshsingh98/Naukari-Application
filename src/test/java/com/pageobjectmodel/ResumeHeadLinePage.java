package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.ResumeHeadLineInterfaceElements;
import com.utility.ExcelUtility;

public class ResumeHeadLinePage extends Base_Class implements ResumeHeadLineInterfaceElements {

	@FindBy(xpath = addResumeHeadLine_xpath)
	WebElement addResumeHeadLine;
	@FindBy(css = headLineTextArea_css)
	WebElement headLineTextArea;
	@FindBy(xpath = save_xpath)
	WebElement save;
	
	public ResumeHeadLinePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void resumeHeadlineUpdate() throws IOException {
		
		explicitWait(addResumeHeadLine, 15, "element visible");
		clickOnElement(addResumeHeadLine);

		passInput(headLineTextArea, ExcelUtility.getCellValue("Data", "ID", "Resume headline"));
		
		clickOnElement(save);

	}

}
