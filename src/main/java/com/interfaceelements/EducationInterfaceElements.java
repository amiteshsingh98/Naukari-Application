package com.interfaceelements;

public interface EducationInterfaceElements {

	String addEducation_xpath = "//span[normalize-space()='Add education']";

	String highestEducation_id = "highEduFor";

	String institute_id = "institute";
	String instituteFirstOption_xpath = "(//div[contains(@id,'sugDrp_institute')]//div[normalize-space()])[1]";

	String course_id = "crsFor";

	String specialization_id = "specializationFor";
	String specializationOptions_xpath = "//div[@id='dp_specialization']//a[normalize-space()]";

	String startingYear_id = "yosFieldFor";
	String startingYearOptions_xpath = "//div[@id='dp_yosField']//a[normalize-space()]";

	String endingYear_id = "yopFieldFor";
	String endingYearOptions_xpath = "//div[@id='dp_yopField']//a[normalize-space()]";

	String gradingSystem_id = "gradeFieldFor";
	String gradingSystemOptions_xpath = "//div[@id='dp_gradeField']//a[normalize-space()]";

	String gradeMarks_id = "gradeMarks";

	String saveEducation_id = "saveEducation";
}
