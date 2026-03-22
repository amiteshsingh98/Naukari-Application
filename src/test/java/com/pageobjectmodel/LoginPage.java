package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.NaukariLoginPageInterfaceElements;
import com.pageobjectmanager.PageObjectManager;
import com.utility.ExcelUtility;

public class LoginPage extends Base_Class implements NaukariLoginPageInterfaceElements {

	@FindBy(id = username_id)
	private WebElement username;

	@FindBy(css = password_css)
	private WebElement password;

	@FindBy(xpath = login_xpath)
	private WebElement login;

	@FindBy(xpath = title_xpath)
	private WebElement title;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void validLogin() throws IOException {
		
		passInput(username, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("username"));
		passInput(password, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("password"));
		clickOnElement(login);
		explicitWait(title, 10, "element visible");
		validation(title, ExcelUtility.getCellValue("Data", "ID", "Title"));

	}

}
