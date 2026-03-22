package com.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.ITSkillsInterfaceElements;

public class ITSkillsPage extends Base_Class implements ITSkillsInterfaceElements {
	
	@FindBy(xpath = addDeatils_xpath)
	WebElement addDeatils;
	
	@FindBy(id = skillsdropdown_id)
	WebElement skillsdropdown;

	@FindBy(css = skillsOptions_css)
	List<WebElement> skillsOptions;
	
	@FindBy(id = lastUsed_id)
	WebElement lastUsed;
	
	@FindBy(id = experienceYears_id)
	WebElement experienceYears;
	
	@FindBy(id = experienceMonths_id)
	WebElement experienceMonths;
	
	@FindBy(id = save_id)
	WebElement save;
	
	public ITSkillsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void addITSkills() {
		explicitWait(addDeatils, 10, "clickable");
		clickOnElement(addDeatils);
		
		explicitWait(skillsdropdown, 10, "clickable");
		selectCustomDropdown(skillsdropdown, skillsOptions, "Selenium");
		
		explicitWait(lastUsed, 10, "clickable");
		passInput(lastUsed, "2026");
		lastUsed.sendKeys(Keys.ENTER);
		
		explicitWait(experienceYears, 10, "clickable");
		passInput(experienceYears,"2 Years");
		experienceYears.sendKeys(Keys.ENTER);
		
		explicitWait(experienceMonths, 10, "clickable");
		passInput(experienceMonths, "3 Months");
		experienceMonths.sendKeys(Keys.ENTER);
		
		explicitWait(save, 10, "clickable");
		clickOnElement(save);
		
		
		
		

	}
	

}
