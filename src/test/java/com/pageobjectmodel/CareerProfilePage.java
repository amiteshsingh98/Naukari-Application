package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.CareerProfileInterfaces;
import com.utility.ExcelUtility;

public class CareerProfilePage extends Base_Class implements CareerProfileInterfaces{
	@FindBy(xpath = editCareerProfile_xpath)
	WebElement editCareerProfile;
	
	@FindBy(id = department_id)
	WebElement department;
	
	@FindBy(id = roleCategory_id)
	WebElement roleCategory;
	
	@FindBy(id =jobRole_id)
	WebElement jobRole;
	
	@FindBy(xpath = desiredJobType_xpath)
	WebElement desiredJobType;
	
	@FindBy(xpath = desiredEmployementType_xpath)
	WebElement desiredEmployementType;
	
	@FindBy(xpath = preferredShift_xpath)
	WebElement preferredShift;
	
	@FindBy(xpath = expectedSalary_xpath)
	WebElement expectedSalary;
	
	@FindBy(xpath = save_xpath)
	WebElement save;
	
	public CareerProfilePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void careerProfileUpdate() throws IOException {
		explicitWait(editCareerProfile, 15, "element visible");
		clickOnElement(editCareerProfile);
		
		/*explicitWait(department, 15, "clickable");
		passInput(department, "QA");
		department.sendKeys(Keys.ENTER);
		
		explicitWait(roleCategory, 15, "element visible");
		passInput(roleCategory, "Quality Assurance and Testing");
		roleCategory.sendKeys(Keys.ENTER);
		
		explicitWait(jobRole, 15, "clickable");
		passInput(jobRole, "Auto");
		jobRole.sendKeys(Keys.ENTER);*/
		
		explicitWait(desiredJobType, 15, "clickable");
		clickOnElement(desiredJobType);
		
		clickOnElement(desiredEmployementType);
		
		clickOnElement(preferredShift);
		
		passInput(expectedSalary, ExcelUtility.getCellValue("Data", "ID", "ExpectedSalary"));
		
		clickOnElement(save);

	}

}
