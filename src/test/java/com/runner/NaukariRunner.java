package com.runner;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.Base_Class;
import com.listener.ExtentReport_Test;
import com.listener.ITestListenerClass;
import com.pageobjectmanager.PageObjectManager;

@Listeners(ITestListenerClass.class)
public class NaukariRunner extends Base_Class {

	@BeforeTest
	public void propertySetup() throws IOException {
		launchBrowser(PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("browser"));
		launchUrl(PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("url"));
	}

	@Test(priority = 1)
	private void loginPage() throws IOException {
		ExtentReport_Test.extenttest = extentReports
				.createTest("LoginTest" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Naukari Web Application Testing");
		PageObjectManager.getPageObjectManager().getLoginPage().validLogin();

	}

	@Test(priority = 2)
	private void profileUpdate() throws IOException {
		PageObjectManager.getPageObjectManager().getProfileUpdatePage().updateProfile();

	}

	@Test(priority = 3)
	private void resumeUploadPage() throws AWTException, IOException {

		PageObjectManager.getPageObjectManager().getResumeUpoadPage().resumeUpload();

	}

	@Test(priority = 4)
	private void resumeHeadlinePage() throws IOException {

		PageObjectManager.getPageObjectManager().getResumeHeadLinePage().resumeHeadlineUpdate();

	}

	@Test(priority = 5)
	private void keySkillsPage() throws IOException {

		PageObjectManager.getPageObjectManager().getKeySkillsPage().keySkillsUpdate();

	}

	@Test(priority = 6)
	private void employementPage() throws IOException, InterruptedException {

		PageObjectManager.getPageObjectManager().getEmploymentPage().fillEmploymentDetails();

	}

	@Test(priority = 7)
	private void educationPage() throws IOException, InterruptedException {

		PageObjectManager.getPageObjectManager().getEducationPage().fillEducationDetails();

	}

	@Test(priority = 8)
	private void itSkillsPage() throws IOException {

		PageObjectManager.getPageObjectManager().getITSkillsPage().addITSkills();

	}

	@Test(priority = 9)
	private void profileSummaryPage() throws IOException {

		PageObjectManager.getPageObjectManager().getProfileSummaryPage().profileSummaryUpdate();

	}

	@Test(priority = 10)
	private void careeProfilePage() throws IOException {

		PageObjectManager.getPageObjectManager().getCareerProfilePage().careerProfileUpdate();

	}
	
	@Test(priority = 11)
	private void logoutPage() throws IOException {
		
		PageObjectManager.getPageObjectManager().getLogoutPage().logout();
		
	}

	@AfterTest
	private void terminateBrowser() {

		closeOrQuit("quit");
	}

	@BeforeSuite
	public void extentReportStartUp() throws IOException {
		extentReportStart(
				PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("startReport"));
	}

	@AfterSuite
	public void extendReportEnd() throws IOException {
		extentReportTearsDown(
				PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("endReport"));

	}

}
