package com.interfaceelements;

public interface ProfileUpdateInterfaceElements {

	String closePopUp_xpath = "//div[@class='crossIcon chatBot chatBot-ic-cross']";
	String completeProfile_linkText = "Complete profile";
	String editProfileButton_xpath = "//em[contains(normalize-space(),'editOneTheme')]";

	String experiencedRadioButton_xpath = "//label[@for='exp-radio']";

	String totalExperienceYearDropdown_id = "exp-years-droopeFor";
	String totalExperienceYearOptions_xpath = "//div[@id='dp_exp-years-droope']//div";

	String totalExperienceMonthDropdown_id = "exp-months-droopeFor";
	String totalExperienceMonthOptions_xpath = "//div[@id='dp_exp-months-droope']//div";

	String currentSalary_css = "input#totalAbsCtc_id";

	String salaryBreakdownDropdown_xpath = "//input[@placeholder='Select salary components']";
	String salaryBreakdownOptions_xpath = "//div[contains(@class,'drop')]//div";

	String indiaRadioButton_xpath = "//label[text()='India']";

	String currentLocationInput_id = "locationSugg";
	String cityOptions_xpath = "//div[@id='sugDrp_locationSugg']//div";

	String stateInput_id = "location-droopeFor";
	String stateOptions_xpath = "//div[@id='dp_location-droope']//div";

	String availability15DaysOrLess_xpath = "//span[text()='15 Days or less']";
	String save_css = "button#saveBasicDetailsBtn";

	String profileUpdateSuccess_xpath = "//span[text()='Profile updated successfully']";
	String closeProfileUpdatedPopUp_xpath = "//div[contains(@class,'profileUpdatedProLayer')]//span[text()='CrossLayer']";
}
