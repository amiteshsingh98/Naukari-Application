package com.interfaceelements;

public interface EmploymentInterfaceElements {

	String addEmployement_id = "add-employment";

	String currentCompanyName_id = "companySugg";
	String currentCompanySuggestion_xpath = "//div[@id='sugDrp_companySugg']//*[normalize-space()='Tata Consultancy Services']";

	String currentJobTitle_id = "designationSugg";
	String currentJobTitleSuggestion_xpath = "//div[@id='sugDrp_designationSugg']//*[normalize-space()='Quality Analyst']";

	String joiningYear_id = "startedYearFor";
	String joiningYearOptions_xpath = "//div[@id='dp_startedYear']//div[normalize-space()]";

	String joiningMonth_id = "startedMonthFor";
	String joiningMonthOptions_xpath = "//div[@id='dp_startedMonth']//div[normalize-space()]";

	String skillsUsed_id = "keySkillSugg";

	String jobProfile_xpath = "//textarea[@placeholder='Type here...']";

	String noticePeriod_id = "noticePeriodFor";
	String noticePeriodOptions_xpath = "//div[@id='dp_noticePeriod']//div[normalize-space()]";

	String saveEmployment_id = "submitEmployment";
}
