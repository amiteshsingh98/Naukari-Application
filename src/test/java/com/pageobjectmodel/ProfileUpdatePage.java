package com.pageobjectmodel;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.ProfileUpdateInterfaceElements;
import com.utility.ExcelUtility;

public class ProfileUpdatePage extends Base_Class implements ProfileUpdateInterfaceElements {

	@FindBy(xpath = closePopUp_xpath)
	WebElement closePopUp;

	@FindBy(linkText = completeProfile_linkText)
	WebElement completeProfile;

	@FindBy(xpath = editProfileButton_xpath)
	WebElement updateProfileButton;

	@FindBy(xpath = experiencedRadioButton_xpath)
	WebElement experiencedRadioButton;

	@FindBy(id = totalExperienceYearDropdown_id)
	WebElement totalExperienceYearDropdown;

	@FindBy(xpath = totalExperienceYearOptions_xpath)
	List<WebElement> yearOptions;

	@FindBy(id = totalExperienceMonthDropdown_id)
	WebElement totalExperienceMonthDropdown;

	@FindBy(xpath = totalExperienceMonthOptions_xpath)
	List<WebElement> monthOptions;

	@FindBy(css = currentSalary_css)
	WebElement currentSalary;

	@FindBy(xpath = salaryBreakdownDropdown_xpath)
	WebElement salaryBreakdownDropdown;

	@FindBy(xpath = salaryBreakdownOptions_xpath)
	List<WebElement> salaryBreakdownOptions;

	@FindBy(xpath = indiaRadioButton_xpath)
	WebElement indiaRadioButton;

	@FindBy(id = currentLocationInput_id)
	WebElement currentLocationInput;

	@FindBy(xpath = cityOptions_xpath)
	List<WebElement> cityOptions;

	@FindBy(id = stateInput_id)
	WebElement stateInput;

	@FindBy(xpath = stateOptions_xpath)
	List<WebElement> stateOptions;

	@FindBy(xpath = availability15DaysOrLess_xpath)
	WebElement availability15DaysOrLess;

	@FindBy(css = save_css)
	WebElement saveButton;

	@FindBy(xpath = profileUpdateSuccess_xpath)
	WebElement profileUpdatedSuccessfully;

	@FindBy(xpath = closeProfileUpdatedPopUp_xpath)
	WebElement closeProfileUpdatedPopUp;

	public ProfileUpdatePage() {
		PageFactory.initElements(driver, this);
	}

	public void openProfileUpdate() {
//		clickOnElement(closePopUp);

		explicitWait(completeProfile, 20, "clickable");
		clickOnElement(completeProfile);

		explicitWait(updateProfileButton, 30, "clickable");
		clickOnElement(updateProfileButton);
	}

	public void fillProfileDetails() throws IOException {

		explicitWait(experiencedRadioButton, 10, "clickable");
		selectRadioButton(experiencedRadioButton);

		explicitWait(totalExperienceYearDropdown, 10, "clickable");
		selectCustomDropdown(totalExperienceYearDropdown, yearOptions, "4 Years");

		explicitWait(totalExperienceMonthDropdown, 10, "clickable");
		selectCustomDropdown(totalExperienceMonthDropdown, monthOptions, "6 Months");

		explicitWait(currentSalary, 10, "element visible");
		passInput(currentSalary, ExcelUtility.getCellValue("Data", "ID", "ActualSalary"));

		explicitWait(salaryBreakdownDropdown, 10, "clickable");
		selectCustomDropdown(salaryBreakdownDropdown, salaryBreakdownOptions, "Fixed");

		explicitWait(indiaRadioButton, 10, "clickable");
		clickOnElement(indiaRadioButton);

		explicitWait(currentLocationInput, 10, "clickable");
		selectCustomDropdown(currentLocationInput, cityOptions, "Chennai");

		explicitWait(availability15DaysOrLess, 10, "clickable");
		clickOnElement(availability15DaysOrLess);

		explicitWait(saveButton, 10, "clickable");
		clickOnElement(saveButton);

		explicitWait(stateInput, 10, "clickable");
		selectCustomDropdown(stateInput, stateOptions, "Tamil Nadu");

		explicitWait(saveButton, 10, "clickable");
		clickOnElement(saveButton);

		explicitWait(profileUpdatedSuccessfully, 15, "element visible");
		validation(profileUpdatedSuccessfully, ExcelUtility.getCellValue("Data", "ID", "Profile Update Success"));

		try {
			explicitWait(closeProfileUpdatedPopUp, 5, "clickable");
			clickOnElement(closeProfileUpdatedPopUp);
		} catch (Exception e) {

		}

	}

	public void updateProfile() throws IOException {
		openProfileUpdate();
		fillProfileDetails();
	}
}
