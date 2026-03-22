package com.pageobjectmanager;

import com.pageobjectmodel.CareerProfilePage;
import com.pageobjectmodel.EducationPage;
import com.pageobjectmodel.EmploymentPage;
import com.pageobjectmodel.ITSkillsPage;
import com.pageobjectmodel.KeySkillsPage;
import com.pageobjectmodel.LoginPage;
import com.pageobjectmodel.LogoutPage;
import com.pageobjectmodel.ProfileSummaryPage;
import com.pageobjectmodel.ProfileUpdatePage;
import com.pageobjectmodel.ResumeHeadLinePage;
import com.pageobjectmodel.ResumeUploadPage;
import com.utility.FileReaderManager;

public class PageObjectManager {

	private LoginPage loginPage;
	private FileReaderManager fileReaderManager;
	private ProfileUpdatePage profileUpdatePage;
	private ResumeUploadPage resumeUpoadPage;
	private ResumeHeadLinePage resumeHeadLinePage;
	private KeySkillsPage keySkillsPage;
	private EmploymentPage employmentPage;
	private EducationPage educationPage;
	private ITSkillsPage iTSkillsPage;
	private ProfileSummaryPage profileSummaryPage;
	private CareerProfilePage careerProfilePage;
	private LogoutPage logoutPage;
	private static PageObjectManager pageObjectManager;
	
	
	public ProfileUpdatePage getProfileUpdatePage() {
		if (profileUpdatePage == null) {
			profileUpdatePage = new ProfileUpdatePage();
		}
		return profileUpdatePage;
	}
	
	public ProfileSummaryPage getProfileSummaryPage() {
		if (profileSummaryPage == null) {
			profileSummaryPage = new ProfileSummaryPage();
		}
		return profileSummaryPage;
	}
	
	public CareerProfilePage getCareerProfilePage() {
		if (careerProfilePage == null) {
			careerProfilePage = new CareerProfilePage();
		}
		return careerProfilePage;
	}
	
	public ResumeUploadPage getResumeUpoadPage() {
		if (resumeUpoadPage == null) {
			resumeUpoadPage = new ResumeUploadPage();
		}
		return resumeUpoadPage;
	}
	public ITSkillsPage getITSkillsPage() {
		if (iTSkillsPage == null) {
			iTSkillsPage = new ITSkillsPage();
		}
		return iTSkillsPage;
	}
	
	public ResumeHeadLinePage getResumeHeadLinePage() {
		if (resumeHeadLinePage == null) {
			resumeHeadLinePage = new ResumeHeadLinePage();
		}
		return resumeHeadLinePage;
	}
	
	public EducationPage getEducationPage() {
		if (educationPage == null) {
			educationPage = new EducationPage();
		}
		return educationPage;
	}
	public KeySkillsPage getKeySkillsPage() {
		if (keySkillsPage == null) {
			keySkillsPage = new KeySkillsPage();
		}
		return keySkillsPage;
	}
	
	public EmploymentPage getEmploymentPage() {
		if (employmentPage == null) {
			employmentPage = new EmploymentPage();
		}
		return employmentPage;
	}

	
	public LoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = new LoginPage();
		}
		return loginPage;
	}
	public LogoutPage getLogoutPage() {
		if (logoutPage == null) {
			logoutPage = new LogoutPage();
		}
		return logoutPage;
	}
	

	public FileReaderManager getFileReaderManager() {
		if (fileReaderManager == null) {
			fileReaderManager = new FileReaderManager();
		}
		return fileReaderManager;
	}

	public static PageObjectManager getPageObjectManager() {
		if (pageObjectManager == null) {
			pageObjectManager = new PageObjectManager();
		}

		return pageObjectManager;
	}

}
