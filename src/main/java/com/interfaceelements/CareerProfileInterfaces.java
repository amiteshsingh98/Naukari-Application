package com.interfaceelements;

public interface CareerProfileInterfaces {
	String editCareerProfile_xpath = "//span[text()='Career profile']//following-sibling::span[text()='editOneTheme']";
	String department_id = "fareaDroopeFor";
	String roleCategory_id = "roleCategoryDroopeFor";
	String jobRole_id = "roleDroopeFor";
	String desiredJobType_xpath = "//label[@for='permanent']";
	String desiredEmployementType_xpath = "//label[@for='fullTime']";
	String preferredShift_xpath = "//label[@for='day_shift']";
	String expectedSalary_xpath = "//input[@class='currency-input ']";
	String save_xpath = "//button[text()='Save']";

}
