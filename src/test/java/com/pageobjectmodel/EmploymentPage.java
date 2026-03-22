package com.pageobjectmodel;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.EmploymentInterfaceElements;
import com.utility.ExcelUtility;

public class EmploymentPage extends Base_Class implements EmploymentInterfaceElements {

	@FindBy(id = addEmployement_id)
	WebElement addEmployementButton;

	@FindBy(id = currentCompanyName_id)
	WebElement currentCompanyName;

	@FindBy(xpath = currentCompanySuggestion_xpath)
	WebElement currentCompanySuggestion;

	@FindBy(id = currentJobTitle_id)
	WebElement currentJobTitle;

	@FindBy(xpath = currentJobTitleSuggestion_xpath)
	WebElement currentJobTitleSuggestion;

	@FindBy(id = joiningYear_id)
	WebElement joiningYearDropdown;

	@FindBy(xpath = joiningYearOptions_xpath)
	List<WebElement> joiningYearOptions;

	@FindBy(id = joiningMonth_id)
	WebElement joiningMonthDropdown;

	@FindBy(xpath = joiningMonthOptions_xpath)
	List<WebElement> joiningMonthOptions;

	@FindBy(id = skillsUsed_id)
	WebElement skillsUsedInput;

	@FindBy(xpath = jobProfile_xpath)
	WebElement jobProfileTextArea;

	@FindBy(id = noticePeriod_id)
	WebElement noticePeriodDropdown;

	@FindBy(xpath = noticePeriodOptions_xpath)
	List<WebElement> noticePeriodOptions;

	@FindBy(id = saveEmployment_id)
	WebElement saveEmploymentButton;

	public EmploymentPage() {
		PageFactory.initElements(driver, this);
	}

	public void fillEmploymentDetails() throws InterruptedException, IOException {

		Thread.sleep(5000);

		explicitWait(addEmployementButton, 10, "clickable");
		clickOnElement(addEmployementButton);

		explicitWait(currentCompanyName, 10, "clickable");
		passInput(currentCompanyName, "Tata Consultancy Services");

		explicitWait(currentCompanySuggestion, 10, "clickable");
		clickOnElement(currentCompanySuggestion);

		explicitWait(currentJobTitle, 10, "clickable");
		passInput(currentJobTitle, "Quality Analyst");

		explicitWait(currentJobTitleSuggestion, 10, "clickable");
		clickOnElement(currentJobTitleSuggestion);

		explicitWait(joiningYearDropdown, 10, "clickable");
		selectCustomDropdown(joiningYearDropdown, joiningYearOptions, "2021");

		explicitWait(joiningMonthDropdown, 10, "clickable");
		selectCustomDropdown(joiningMonthDropdown, joiningMonthOptions, "Jun");

		explicitWait(skillsUsedInput, 10, "clickable");
		passInput(skillsUsedInput, ExcelUtility.getCellValue("Data", "ID", "Key Skills"));

		explicitWait(jobProfileTextArea, 10, "clickable");
		passInput(jobProfileTextArea, ExcelUtility.getCellValue("Data", "ID", "Resume headline"));

		explicitWait(noticePeriodDropdown, 10, "clickable");
		selectCustomDropdown(noticePeriodDropdown, noticePeriodOptions, "15 Days or less");

		explicitWait(saveEmploymentButton, 10, "clickable");
		clickOnElement(saveEmploymentButton);
	}
}
