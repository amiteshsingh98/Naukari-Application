package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.keySkillsInterfaceElements;
import com.utility.ExcelUtility;

public class KeySkillsPage extends Base_Class implements keySkillsInterfaceElements{
	@FindBy(xpath = editKeySkills_xpath)
	WebElement editKeySkills;
	@FindBy(xpath = keySkillsTextArea_xpath)
	WebElement keySkillsTextArea;
	@FindBy(css = save_css)
	WebElement save;
	
	public KeySkillsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void keySkillsUpdate() throws IOException {
		
		explicitWait(editKeySkills, 15, "element visible");
		clickOnElement(editKeySkills);

		passInput(keySkillsTextArea, ExcelUtility.getCellValue("Data", "ID", "Key Skills"));
		
		clickOnElement(save);

	}

}
