package com.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.EducationInterfaceElements;

public class EducationPage extends Base_Class implements EducationInterfaceElements {

	@FindBy(xpath = addEducation_xpath)
	WebElement addEducationButton;

	@FindBy(id = highestEducation_id)
	WebElement highestEducationField;

	@FindBy(id = institute_id)
	WebElement instituteInput;

	@FindBy(xpath = instituteFirstOption_xpath)
	WebElement instituteFirstOption;

	@FindBy(id = course_id)
	WebElement courseInput;

	@FindBy(id = specialization_id)
	WebElement specializationDropdown;

	@FindBy(xpath = specializationOptions_xpath)
	List<WebElement> specializationOptions;

	@FindBy(id = startingYear_id)
	WebElement startingYearDropdown;

	@FindBy(xpath = startingYearOptions_xpath)
	List<WebElement> startingYearOptions;

	@FindBy(id = endingYear_id)
	WebElement endingYearDropdown;

	@FindBy(xpath = endingYearOptions_xpath)
	List<WebElement> endingYearOptions;

	@FindBy(id = gradingSystem_id)
	WebElement gradingSystemDropdown;

	@FindBy(xpath = gradingSystemOptions_xpath)
	List<WebElement> gradingSystemOptions;

	@FindBy(id = gradeMarks_id)
	WebElement gradeMarksInput;

	@FindBy(id = saveEducation_id)
	WebElement saveEducationButton;

	public EducationPage() {
		PageFactory.initElements(driver, this);
	}

	public void fillEducationDetails() throws InterruptedException {
		
        Thread.sleep(5000);
		explicitWait(addEducationButton, 10, "clickable");
		clickOnElement(addEducationButton);

		explicitWait(highestEducationField, 10, "clickable");
		passInput(highestEducationField, "Graduation/");
		highestEducationField.sendKeys(Keys.ENTER);

		explicitWait(instituteInput, 10, "clickable");
		passInput(instituteInput, "Saveetha Engineering College");

		explicitWait(instituteFirstOption, 10, "clickable");
		clickOnElement(instituteFirstOption);

		explicitWait(courseInput, 10, "clickable");
		passInput(courseInput, "B.Tech");	
		courseInput.sendKeys(Keys.ENTER);

		explicitWait(specializationDropdown, 10, "clickable");
		selectCustomDropdown(specializationDropdown, specializationOptions, "Mechanical Engineering");

		explicitWait(startingYearDropdown, 10, "clickable");
		selectCustomDropdown(startingYearDropdown, startingYearOptions, "2016");

		explicitWait(endingYearDropdown, 10, "clickable");
		selectCustomDropdown(endingYearDropdown, endingYearOptions, "2020");

		explicitWait(gradingSystemDropdown, 10, "clickable");
		selectCustomDropdown(gradingSystemDropdown, gradingSystemOptions, "Scale 10 Grading System");

		explicitWait(gradeMarksInput, 10, "clickable");
		passInput(gradeMarksInput, "6.97");

		explicitWait(saveEducationButton, 10, "clickable");
		clickOnElement(saveEducationButton);
	}
}
