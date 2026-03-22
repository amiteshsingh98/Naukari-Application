package com.pageobjectmodel;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.ResumeUploadInterfaceElements;
import com.pageobjectmanager.PageObjectManager;

public class ResumeUploadPage extends Base_Class implements ResumeUploadInterfaceElements {

    @FindBy(xpath = resumeButton_xpath)
    WebElement resumeButton;

    @FindBy(xpath = popUpCancel_xpath)
    WebElement popUpCancel;

    public ResumeUploadPage() {
        PageFactory.initElements(driver, this);
    }

    public void resumeUpload() throws AWTException, IOException {

        explicitWait(resumeButton, 10, "clickable");
        clickOnElement(resumeButton);

        uploadFile(PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("resumePath"));

       // try {
         //   explicitWait(popUpCancel, 5, "clickable");
           // clickOnElement(popUpCancel);
      //  } catch (Exception e) {

     //   }
    }
}
