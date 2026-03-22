package com.base;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class Base_Class {

	public static WebDriver driver;
	public static ExtentReports extentReports;
	private static File file;

	protected static WebDriver launchBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else {
				Assert.fail("ERROR : INVALID BROWSER NAME");
			}
			driver.manage().window().maximize();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING BROWSER LAUNCH");
		}
		return driver;
	}

	protected static void launchUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING URL LAUNCH");
		}
	}

	protected static void navigateTo(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING NAVIGATION TO URL");
		}
	}

	protected static void titleOfPage() {
		try {
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING GETTING PAGE TITLE OR URL");
		}
	}

	protected static void passInput(WebElement element, String value) {
		try {
			explicitWait(element, 10, "element visible");
			element.click();
			element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			element.sendKeys(Keys.DELETE);
			element.sendKeys(value);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURS DURING PASS INPUT ACTION");
		}
	}

	protected static String takeScreenShots() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File des = new File(".//Screenshots//" + "Screenshots_" + timeStamp + ".png");
		FileHandler.copy(src, des);
		return des.getAbsolutePath();
	}

	protected static void clickOnElement(WebElement element) {
		try {
			explicitWait(element, 10, "clickable");
			element.click();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING CLICK ACTION");
		}
	}

	protected static void navigation(String navigate) {
		try {
			if (navigate.equalsIgnoreCase("back")) {
				driver.navigate().back();
			} else if (navigate.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			} else if (navigate.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			} else {
				Assert.fail("ERROR : INVALID NAVIGATION TYPE");
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING NAVIGATION");
		}
	}

	protected static void closeOrQuit(String type) {
		try {
			if (type.equalsIgnoreCase("close")) {
				driver.close();
			} else if (type.equalsIgnoreCase("quit")) {
				driver.quit();
			} else {
				Assert.fail("ERROR : INVALID CLOSE/QUIT TYPE");
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURS DURING WINDOW CLOSE/QUIT");
		}
	}

	protected static void getText(WebElement element) {
		try {
			String text = element.getText();
			System.out.println(text);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURS DURING GETTING TEXT");
		}
	}

	protected static void simpleDismissAlert(String type) {
		try {
			explicitWait(null, 10, "Check Alert");
			Alert alert = driver.switchTo().alert();
			if (type.equalsIgnoreCase("accept")) {
				String text = alert.getText();
				System.out.println(text);
				alert.accept();
			} else if (type.equalsIgnoreCase("dismiss")) {
				String text = alert.getText();
				System.out.println(text);
				alert.dismiss();
			} else {
				Assert.fail("ERROR : INVALID ALERT ACTION");
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURS DURING SIMPLE ALERT");
		}
	}

	protected static void promptAlert(String value) {
		try {
			explicitWait(null, 10, "Check Alert");
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(value);
			alert.accept();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURS DURING PROMPT ALERT");
		}
	}

	protected static void actionMethod(WebElement element, String type) {
		try {
			Actions action = new Actions(driver);
			if (type.equalsIgnoreCase("click")) {
				action.click(element).perform();
			} else if (type.equalsIgnoreCase("right click")) {
				action.contextClick(element).perform();
			} else if (type.equalsIgnoreCase("double click")) {
				action.doubleClick(element).perform();
			} else if (type.equalsIgnoreCase("move to element")) {
				action.moveToElement(element).perform();
			} else {
				Assert.fail("ERROR : INVALID ACTION TYPE");
			}
		} catch (Exception e) {
			Assert.fail("ERROR : DURING ACTION CLASS");
		}
	}

	protected void robotMethod(int num) {
		try {
			Robot robot = new Robot();
			robot.keyPress(num);
			robot.keyRelease(num);
		} catch (Exception e) {
			Assert.fail("ERROR : DURING ROBOT CLASS");
		}
	}

	protected static void explicitWait(WebElement element, int seconds, String type) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			if (type.equalsIgnoreCase("element visible")) {
				wait.until(ExpectedConditions.visibilityOf(element));
			} else if (type.equalsIgnoreCase("clickable")) {
				wait.until(ExpectedConditions.elementToBeClickable(element));
			} else if (type.equalsIgnoreCase("selected")) {
				wait.until(ExpectedConditions.elementToBeSelected(element));
			} else if (type.equalsIgnoreCase("Check Alert")) {
				wait.until(ExpectedConditions.alertIsPresent());
			} else {
				Assert.fail("ERROR : INVALID WAIT TYPE");
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURS DURING WAIT");
		}
	}

	protected static boolean elementStatus(WebElement element, String type) {
		try {
			if (type.equalsIgnoreCase("displayed")) {
				return element.isDisplayed();
			} else if (type.equalsIgnoreCase("enabled")) {
				return element.isEnabled();
			} else if (type.equalsIgnoreCase("selected")) {
				return element.isSelected();
			} else {
				Assert.fail("ERROR : INVALID ELEMENT STATUS TYPE");
			}
		} catch (Exception e) {
			Assert.fail("ERROR : DURING ELEMENT STATUS CHECK");
		}
		return false;
	}

	protected static void isSelected(WebElement element) {
		try {
			boolean selected = element.isSelected();
			System.out.println(selected);
		} catch (Exception e) {
			Assert.fail("ERROR : DURING ISSELECTED CHECK");
		}
	}

	protected static void isEnabled(WebElement element) {
		try {
			boolean enabled = element.isEnabled();
			System.out.println(enabled);
		} catch (Exception e) {
			Assert.fail("ERROR : DURING ISENABLED CHECK");
		}
	}

	protected static void isDisplayed(WebElement element) {
		try {
			boolean displayed = element.isDisplayed();
			System.out.println(displayed);
		} catch (Exception e) {
			Assert.fail("ERROR : DURING ISDISPLAYED CHECK");
		}
	}


	protected void getFirstSelectedOption(WebElement element) {
		try {
			Select select = new Select(element);
			WebElement firstSelectedOption = select.getFirstSelectedOption();
			System.out.println(firstSelectedOption.getText());
		} catch (Exception e) {
			Assert.fail("ERROR : DURING FIRST SELECTED DROPDOWN OPTION");
		}
	}

	protected void allSelectedOption(WebElement element) {
		try {
			Select select = new Select(element);
			List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
			for (WebElement option : allSelectedOptions) {
				System.out.println(option.getText());
			}
		} catch (Exception e) {
			Assert.fail("ERROR : DURING CHECKING ALL SELECTED OPTION");
		}
	}

	protected static void isMultiple(WebElement element) {
		try {
			Select select = new Select(element);
			boolean multiple = select.isMultiple();
			System.out.println(multiple);
		} catch (Exception e) {
			Assert.fail("ERROR : DURING CHECKING SELECT OPTION HAVE MULTIPLE SELECT");
		}
	}

	protected static void javaScriptMethod(WebElement element, String action, String value) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			if (action.equalsIgnoreCase("scroll into view")) {
				js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
			} else if (action.equalsIgnoreCase("scroll down")) {
				js.executeScript("window.scrollBy(0, arguments[0]);", Integer.parseInt(value));
			} else if (action.equalsIgnoreCase("scroll up")) {
				js.executeScript("window.scrollBy(0, -arguments[0]);", Integer.parseInt(value));
			} else if (action.equalsIgnoreCase("sendKeys")) {
				js.executeScript("arguments[0].value = arguments[1];", element, value);
			} else if (action.equalsIgnoreCase("click")) {
				js.executeScript("arguments[0].click();", element);
			} else {
				Assert.fail("ERROR : INVALID JAVASCRIPT ACTION PASSED");
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURS DURING JAVASCRIPT ACTION");
		}
	}

	protected static void validation(WebElement element, String expected) {
		try {
			explicitWait(element, 10, "element visible");
			String text = element.getText().trim();
			System.out.println(text);
			Assert.assertEquals(text, expected);
		} catch (Exception e) {
			Assert.fail("ERROR : FAILED DURING VALIDATION");
		}
	}

	protected static void uploadFile(String location) throws AWTException {
		try {
			Robot robot = new Robot();
			robot.delay(2000);
			StringSelection ss = new StringSelection(location);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURS DURING FILE UPLOAD");
		}
	}

	protected static void selectRadioButton(WebElement element) {
		try {
			if (element.isDisplayed() && element.isEnabled()) {
				if (!element.isSelected()) {
					element.click();
				}
			} else {
				Assert.fail("ERROR : RADIO BUTTON IS NOT DISPLAYED OR NOT ENABLED");
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURS DURING RADIO BUTTON SELECTION");
		}
	}

	protected static void selectCustomDropdown(WebElement inputElement, List<WebElement> options, String value) {
		try {

			inputElement.click();
			inputElement.clear();
			inputElement.sendKeys(value);

			boolean isSelected = false;

			for (WebElement option : options) {
				if (option.getText().trim().equalsIgnoreCase(value)) {
					explicitWait(option, 10, "clickable");
					option.click();
					isSelected = true;
					break;
				}
			}

			if (!isSelected) {
				inputElement.sendKeys(Keys.ENTER);
			}

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING CUSTOM DROPDOWN SELECTION");
		}
	}

	protected static void extentReportStart(String location) {
		try {
			extentReports = new ExtentReports();
			file = new File(location);
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
			extentReports.attachReporter(sparkReporter);
			extentReports.setSystemInfo("os", System.getProperty("os.name"));
			extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURS DURING START OF EXTENT REPORT");
		}
	}

	protected static void extentReportTearsDown(String location) throws IOException {
		try {
			extentReports.flush();
			file = new File(location);
			Desktop.getDesktop().browse(file.toURI());
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURS DURING END OF EXTENT REPORT");
		}
	}
}
