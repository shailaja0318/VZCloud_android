package com.verizon.appiumtests.controls;

import com.relevantcodes.extentreports.LogStatus;
import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.driver.BaseDriver;
import com.verizon.appiumtests.listenersReport.ExtentTestReportManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSStartScreenRecordingOptions;
import io.appium.java_client.ios.IOSStopScreenRecordingOptions;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.screenrecording.ScreenRecordingUploadOptions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseControlsHelper {

	private WebElement element;
	private List<WebElement> elements;
	AppiumDriver driver = BaseDriver.getDriver();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	//element = new WebDriverWait(driver, Duration.ofSeconds(60));

	public BaseControlsHelper(AppiumDriver driver) {
		this.driver = driver;
	}
	
	public static void ReportLog(final String message) {
		Reporter.log(Thread.currentThread().getId() + "> " + message, true);
		ExtentTestReportManager.getTest().log(LogStatus.INFO, message + "<br>");
	}

	public void clickOn(Keys keys) throws Exception {
		element.sendKeys(keys);
		Thread.sleep(1000);
	}

	public void clickOn(String elementName) throws Exception {
		boolean flag = true;
		int count=0;
		while (flag) {
			try {
				waitForShow(elementName);
				//	ReportLog("Click on " + elementName);
				//System.out.println();
				System.out.println("Appium Helper Click on " + elementName);
				driver.findElement(AppiumBy.accessibilityId(elementName)).click();
				flag=false;
			} catch (Exception e) {
				swipe("up");
				count++;
				if(count==5){
					break;
				}

			}
		}
	}

	public void clickOnWithouScroll(String elementName) throws Exception {

				waitForShow(elementName);
				//	ReportLog("Click on " + elementName);
				//System.out.println();
				System.out.println("Appium Helper Click on " + elementName);
				driver.findElement(AppiumBy.accessibilityId(elementName)).click();
	}

	public void clickOnLabelBeginswith(String elementLabel) throws Exception {
		System.out.println("Appium Helper Click on " + elementLabel);
		driver.findElement(AppiumBy.iOSNsPredicateString("label BEGINSWITH '" + elementLabel + "'")).click();
	}

	public void clickOnType(String type) throws Exception {
		System.out.println("Appium Helper Click on " + type);
		driver.findElement(AppiumBy.iOSNsPredicateString("wdType == '" + type + "'")).click();
	}

	public void clickOnElementByXpath(String locator) throws Exception {
		waitForShowByXpath(locator);
		System.out.println("Appium Helper Click on " + locator);
		driver.findElement(AppiumBy.xpath(locator)).click();
	}

	public void clickOnElementByDynamicXpath(String locator, int index){

		System.out.println("Appium Helper Click on " + locator);
		driver.findElement(AppiumBy.xpath(
				"//XCUIElementTypeCell[contains(@name,'photoIndex_"+index+"')]/XCUIElementTypeOther/XCUIElementTypeImage[1]")).click();
	}


	/**
	 * Name is Accessibility Id
	 **/
	public void clickOnNameBeginswith(String elementName) throws Exception {
		System.out.println("Appium Helper Click on " + elementName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.iOSNsPredicateString("name BEGINSWITH '" + elementName + "'")));
		driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH '" + elementName + "'")).click();
	}

	public void clickOnNameContains(String elementName) throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.iOSNsPredicateString("name CONTAINS '" + elementName + "'")));
		System.out.println("Appium Helper Click on " + elementName);
		driver.findElement(AppiumBy.iOSNsPredicateString("name CONTAINS '" + elementName + "'")).click();
	}

	public void clickOnLabelContains(String elementLabel) throws Exception {
		System.out.println("Appium Helper Click on " + elementLabel);
		driver.findElement(AppiumBy.iOSNsPredicateString("label CONTAINS '" + elementLabel + "'")).click();
	}

	public void tapOnBackButton() throws Exception {
		System.out.println("Appium Helper Click on back");
		Thread.sleep(1000);
		driver.navigate().back();
	}
	
	public void tapOnBackButton_PhotosAndVideos() throws Exception {
		System.out.println("Appium Helper Click on back");
		Thread.sleep(1000);
		clickOnElementByXpath(vz_strings.text_photosAndVideos);
	}
	public void clickOnNameLike(String elementName) throws Exception {
		System.out.println("Appium Helper Click on " + elementName);
		driver.findElement(AppiumBy.iOSNsPredicateString("wdName LIKE '" + elementName + " ?' OR wdName LIKE '" + elementName + " ??'")).click();
	}
	public void clickOnLabelLike(String elementName) throws Exception {
		System.out.println("Appium Helper Click on " + elementName);
		int count=0;
		while(true){
			try{
				driver.findElement(AppiumBy.iOSNsPredicateString
						("wdLabel LIKE '" + elementName + " ?' OR wdLabel LIKE '" + elementName + " ??'")).click();
				break;
			}catch (Exception e){
				scroll(elementName, "up");
				count++;
				if(count==3){
					break;
				}

			}
		}

	}

	public void clickOnNameBeginswithAndType(String elementName, String className) throws Exception {
		System.out.println("Appium Helper Click on " + elementName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.iOSNsPredicateString("name BEGINSWITH '" + elementName + "' AND wdType == '" + className + "'")));
		driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH '" + elementName + "' AND wdType == '" + className + "'")).click();
	}

	public void clickOnLabelContainsAndType(String elementName, String className) throws Exception {
		System.out.println("Appium Helper Click on " + elementName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.iOSNsPredicateString("label CONTAINS '" + elementName + "' AND wdType == '" + className + "'")));
		driver.findElement(AppiumBy.iOSNsPredicateString("label CONTAINS '" + elementName + "' AND wdType == '" + className + "'")).click();
	}

	public void clickOnLabelBeginsWithAndType(String elementName, String className) throws Exception {
		System.out.println("Appium Helper Click on " + elementName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.iOSNsPredicateString("label BEGINSWITH '" + elementName + "' AND wdType == '" + className + "'")));
		driver.findElement(AppiumBy.iOSNsPredicateString("label BEGINSWITH '" + elementName + "' AND wdType == '" + className + "'")).click();
	}

	public void clickOnNameContainsAndVisibile(String elementName) throws Exception {
		System.out.println("Appium Helper Click on " + elementName);
		driver.findElement(AppiumBy.iOSNsPredicateString("wdName CONTAINS '" + elementName + "' AND wdVisible == 1")).click();
	}

	public int getCountByNameContains(String elementName) throws Exception {
		Thread.sleep(1000);
		elements = driver.findElements(AppiumBy.iOSNsPredicateString("wdName CONTAINS '" + elementName + "'"));
		return elements.size();
	}

	public void clickOnClassChain(String cChain) throws Exception {

		System.out.println("Appium Helper Click on " + cChain);
		driver.findElement(AppiumBy.iOSClassChain(cChain)).click();
	}

	/**
	 * Below method names to be renamed
	 * after using correct strategy i.e iOSNsPredicateString
	 * listview xpath is not working as well
	 * going to get AL ids for it https://jira.synchronoss.net:8443/jira/browse/VPCIOS-817
	 */
	public int getCountInViewByPredicate(String view) throws Exception {
		//wait not working here for no reason
		//waitForShow(view);
		boolean isGridview = false;
		for (int i = 0; i < vz_strings.GridViews.length; i++) {
			if (vz_strings.GridViews[i].contentEquals(view)) {
				isGridview = true;
				break;
			}
		}
		if (isGridview) {
			elements = driver.findElements(AppiumBy.iOSNsPredicateString("wdType == 'XCUIElementTypeCell' AND wdLabel CONTAINS 'Photo' OR wdLabel CONTAINS 'Video'"));
			//have to do -3 because there are three more cell which has photos or videos
			return elements.size() - 3;
		} else {
			return driver.findElements(AppiumBy.iOSNsPredicateString("wdType == 'XCUIElementTypeCell' AND wdName CONTAINS 'MUSIC: View - Playlist'")).size();
		}
	}

	// We cant use wait here becuase we are trying to detect things on home screen.
	public int getCountById(String elementName) throws Exception {
		Thread.sleep(1000);
		//return driver.findElementsByAccessibilityId(elementName).size();
		return driver.findElements(AppiumBy.accessibilityId(elementName)).size();
	}

	public int getCountByClassName(String className) throws Exception {
		Thread.sleep(1000);
		return driver.findElements(AppiumBy.className(className)).size();
	}

	public int getCountByNameLike(String elementName) throws Exception {
		Thread.sleep(1000);
		elements = driver.findElements(AppiumBy.iOSNsPredicateString("wdName LIKE '" + elementName + " ?' OR wdName LIKE '" + elementName + " ??'"));
		return elements.size();
	}
	
	public int getCountByLabelLike(String elementName) throws Exception {
		Thread.sleep(1000);
		elements = driver.findElements(AppiumBy.iOSNsPredicateString("wdLabel LIKE '" + elementName + " ?' OR wdLabel LIKE '" + elementName + " ??'"));
		return elements.size();
	}

	public int getCountByLabelContainsAndType(String label) throws Exception {
		elements = driver.findElements(AppiumBy.iOSNsPredicateString
				("wdLabel CONTAINS '" + label + "' && wdType == 'XCUIElementTypeCell'"));
		return elements.size();
	}

	public int getCountByXpath(String xpath) throws Exception {
		Thread.sleep(1000);
		return driver.findElements(AppiumBy.xpath(xpath)).size();
	}
	public int getCountByClassChain(String classChain) throws Exception {
		Thread.sleep(1000);
		return driver.findElements(AppiumBy.iOSClassChain(classChain)).size();
	}
	public String getAttrByContainsLabelAndType(String label) throws Exception {
		element = driver.findElement(AppiumBy.iOSNsPredicateString
				("wdLabel CONTAINS '" + label + "' && wdType == 'XCUIElementTypeCell'"));
		return element.getAttribute("label");
	}

	public List<WebElement> getListByLabelContainsAndType(String label, String type) throws Exception {
		return driver.findElements(AppiumBy.iOSNsPredicateString("wdLabel CONTAINS '" + label + "' && wdType == '" + type + "'"));
	}

	public List<WebElement> getListByNameLikeOrType(String name){
		return elements = driver.findElements(AppiumBy.iOSNsPredicateString
				("wdName LIKE '" + name + " ?' OR wdName LIKE '" + name + " ??'"));
	}

	public List<WebElement> getListByLabelLikeOrType(String name){
		return elements = driver.findElements(AppiumBy.iOSNsPredicateString("wdLabel LIKE '" + name + " ?' OR wdLabel LIKE '" + name + " ??'"));
	}

	public int getListByType(String type){
		int count = driver.findElements(AppiumBy.xpath(type)).size();
		System.out.println(count);
		return count;
			//	("type == \'"+type+"\'"));
	}

	public String getValueByIndexfromClassName(int index, String className) throws Exception {
		waitForShowByClassName(className);
		return driver.findElements(AppiumBy.className(className)).get(index).getAttribute("value");
	}

	public String getValueByIndexfromXpath(int index, String xpath) throws Exception {
		waitForShowByXpath(xpath);
		return driver.findElements(AppiumBy.xpath(xpath)).get(index).getAttribute("value");
	}

	public String getNameByIndexfromClassName(int index, String className) throws Exception {
		waitForShowByClassName(className);
		return driver.findElements(AppiumBy.className(className)).get(index).getAttribute("name");
	}

	public String getTypeByIndexfromXpath(int index, String xpath) throws Exception {
		waitForShowByXpath(xpath);
		return driver.findElements(AppiumBy.xpath(xpath)).get(index).getAttribute("type");
	}
	public String getTextById(String name) { System.out.println("GET TEXT IS..."
			+(driver.findElement(AppiumBy.accessibilityId(name)).getText())); return
					driver.findElement(AppiumBy.accessibilityId(name)).getText(); }


	public String getTextByNameContains(String name) {
		return driver.findElement(AppiumBy.iOSNsPredicateString("name CONTAINS '" + name + "'")).getText();
	}

	public String getTextByType(String name) {
		return driver.findElement(AppiumBy.iOSNsPredicateString("wdType == '" + name + "'")).getText();
	}

	public String getTextByTypeCell(String name) {
		System.out.println(driver.findElement(AppiumBy.iOSNsPredicateString("name CONTAINS '" + name + "' AND wdType == 'XCUIElementTypeCell'")).getText());
		return driver.findElement(AppiumBy.iOSNsPredicateString("name CONTAINS '" + name + "' AND wdType == 'XCUIElementTypeCell'")).getText();
	}

	public List<WebElement> getTextByTypeCell10(String name) {
		System.out.println(driver.findElement(AppiumBy.iOSNsPredicateString("name CONTAINS '" + name + "' AND wdType == 'XCUIElementTypeCell'")).getText());
		return driver.findElements(AppiumBy.iOSNsPredicateString("name CONTAINS '" + name + "' AND wdType == 'XCUIElementTypeCell'"));
	}
	public ArrayList<String> getAllCellElement() throws Exception {
		ArrayList<String> arrayListlist = new ArrayList<>();
		elements = driver.findElements(AppiumBy.iOSNsPredicateString("wdType LIKE 'XCUIElementTypeCell'" +
				" AND wdName LIKE 'Date Uploaded ?' OR wdName Date Taken 'Photo ??'" +
				" OR wdName LIKE 'Video ?' OR wdName LIKE 'Video ??'" +
				" OR wdName LIKE 'Live Photos ?' OR wdName LIKE 'Live Photos ??'" +
				" OR wdName LIKE 'Saved Story ?' OR wdName LIKE 'Saved Story ??'"));

		for (int i = 0; i < elements.size(); i++) {
			arrayListlist.add(elements.get(i).getAttribute("name"));
		}
		return arrayListlist;
	}
	public void setPickerValue(String value) throws Exception {
		//driver.findElement(AppiumBy.className("XCUIElementTypePickerWheel")).setValue(value);
		driver.findElement(AppiumBy.className("XCUIElementTypePickerWheel")).sendKeys(value);
		System.out.println("Appium Helper Click " + value);
		Thread.sleep(4000);
		clickOn(vz_strings.button_ok);
	}

	public String getPickerText() throws Exception {
		return driver.findElement(AppiumBy.className("XCUIElementTypePickerWheel")).getText();
	}

	public void setByValue(String value) throws Exception {
		driver.findElement(AppiumBy.accessibilityId(value)).click();
		System.out.println("Appium Helper Click " + value);
		Thread.sleep(1000);
	}

	public void setValuetoTextFieldByName(String value, String textField) throws Exception {
		waitForShow(textField);
		driver.findElement(AppiumBy.accessibilityId(textField)).sendKeys(value);
		Thread.sleep(2000);
		//  driver.findElement("-custom", "ai:Search").setValue(value);
		//   driver.findElement("-custom" , "search").setValue(value);;
	}

	public void clearValueOnTextfieldByName(String textField) throws Exception {
		waitForShow(textField);
		driver.findElement(AppiumBy.accessibilityId(textField)).clear();
	}

	public void setValuetoTextFieldByClassName(String value, String textField) throws Exception {
		waitForShow(textField);
		driver.findElement(AppiumBy.className(textField)).sendKeys(value);
		Thread.sleep(2000);
	}

	/**
	 * Using Class chain because dealing with web view
	 * */
	public void setValuetoTextFieldByClassChain(String value, String cchain) throws Exception {
		driver.findElement(AppiumBy.iOSClassChain(cchain)).sendKeys(value);
	}

	
	  public void setOrientation(ScreenOrientation screenOrientation) throws Exception { 
		  ((IOSDriver) driver).rotate(screenOrientation);
	  
	  }
	 

	/**
	 * invisibilityOfElementLocated
	 * Check if element is not present or invisible
	 */
	public void waitForDismiss(String elementName) throws Exception {
		System.out.println("Appium Helper waiting for dismiss " + elementName);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(AppiumBy.accessibilityId(elementName)));
	}

	/**
	 * visibilityOfElementLocated
	 * Check if element is present on DOM & visible
	 * also check it has a height and width greater than 0
	 */
	public void waitForShow(String elementName) throws Exception {
		System.out.println("Appium Helper waiting for show " + elementName);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId(elementName)));
	}

	public void waitForShowByXpath(String xpath) throws Exception {
		System.out.println("Appium Helper waiting for show " + xpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(xpath)));
	}


	public void waitForShowByPredicate(String elementName, String elementType) throws Exception {
		System.out.println("Appium Helper waiting for show " + elementName + " and " + elementType);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.iOSNsPredicateString
				("wdName == '" + elementName + "' AND wdType == '" + elementType + "'")));
	}

	public void waitForShowByTypeAndLabel(String elementType, String elementLabel) throws Exception {
		System.out.println("Appium Helper waiting for show " + elementType + " and " + elementLabel);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(AppiumBy.iOSNsPredicateString("wdType == '" + elementType + "' AND wdLabel == '" + elementLabel + "'")));
	}

	public void waitForShowByClassName(String className) throws Exception {
		System.out.println("Appium Helper waiting for show " + className);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
	}

	public boolean isVisible(String elementName) throws Exception {
		System.out.println("Appium Helper checking for visibility " + elementName);
		waitForShow(elementName);
		return driver.findElement(AppiumBy.accessibilityId(elementName)).isDisplayed();
	}

	public boolean isVisible1(String element) throws Exception {
		System.out.println("Appium Helper checking for visibility " + element);
		waitForShow(element);
		return driver.findElement(AppiumBy.xpath(element)).isDisplayed();
	}


	public boolean elementIsVisible(String elementName) throws Exception {
		waitForShowByXpath(elementName);
		System.out.println("Appium Helper checking for visibility " + elementName);
		return driver.findElement(AppiumBy.xpath(elementName)).isDisplayed();
	}


	public boolean isEnabled(String elementName) throws Exception {
		System.out.println("Appium Helper checking if " + elementName + " is Enabled");
		return driver.findElement(AppiumBy.accessibilityId(elementName)).isEnabled();
	}

	public void  openContext(String option) throws Exception {
		dismissCampaign();
		clickOn(vz_strings.context_menu);
		dismissCampaign();
		Thread.sleep(2000);
		if (option != null) {
			clickOn(option);
			if (option.equals(vz_strings.context_share) || option.equals(vz_strings.context_copyShareLink)) {
				if (getCountById(" Copyright Notice") > 0)
					clickOn(vz_strings.button_ok);
			} else if (option.equals(vz_strings.context_createStory)||option.equals(vz_strings.context_topActionBarcreateStory)) {
				Thread.sleep(2000);
				if (getCountById("rpai_got_it_button") > 0)
					clickOn("rpai_got_it_button");
			}

		}
	}
	
	 public void dismissCampaign() throws Exception {
	        if (getCountById(vz_strings.view_campaign) != 0) {
	            System.out.println("Dismiss the campaign");
	            clickOn(vz_strings.button_close);
	            Thread.sleep(3000);
	        }
	    }

	/**
	 * Gets the value from the element that is found by the name.
	 */
	public String getValue(String elementName) throws Exception {
		waitForShow(elementName);
		System.out.println("Appium Helper Click on " + elementName);
		return driver.findElement(AppiumBy.accessibilityId(elementName)).getAttribute("value");
	}

	public boolean isVisibleByLabelAndType(String elementType, String elementLabel) throws Exception {
		int count = driver.findElements(AppiumBy.iOSNsPredicateString(" wdLabel == '" + elementLabel + "'" +
				" AND wdType== '" + elementType + "'")).size();
		return count > 0;
	}

	/**
	 * Default isSelected is not working at the moment so using this below
	 */
	public boolean isSelected(String elementName) throws Exception {
		waitForShow(elementName);
		return driver.findElement(AppiumBy.accessibilityId(elementName)).getAttribute("name") != null;
	}

	public boolean isSelectedByTypeAndName(String elementType, String elementLabel) throws Exception {
		waitForShowByTypeAndLabel(elementType, elementLabel);
		return driver.findElement(AppiumBy.iOSNsPredicateString("wdType == '" + elementType + "'" +
				" AND wdName == '" + elementLabel + "'")).getAttribute("value") != null;
	}

	public int getCountByNameUntilElementDisplay(String elementName) throws Exception {
		waitForShow(elementName);
		return driver.findElements(AppiumBy.accessibilityId(elementName)).size();
	}

	/**
	 * Restricting to traverse otherwise it can take very long
	 * Since we usually select at most 2-3
	 */
	public ArrayList<String> getListOfAttrLabel(int index, String dataType) throws Exception {
		ArrayList<String> arrayListlist = new ArrayList<>();
		List<WebElement> WebElementList = getListByLabelLikeOrType(dataType);
		for (int i = 0; i < index; i++) {
			arrayListlist.add(WebElementList.get(i).getAttribute("label"));
		}
		return arrayListlist;
	}

	/**
	 *Scroll : If you want to scroll untill a particular element is visible
	 *  Takes in few arguments
	 *  element
	 *  direction : up will scroll up and down will scroll down
	 *  name : Accessbility id
	 *  predicateString :
	 *  toVisible: true or false
	 * */

	public void scroll(String name, String direction) {
		try {
			System.out.println("Appium Helper Scrolling " + direction);
			JavascriptExecutor js = driver;
			HashMap<Object, Object> args = new HashMap();
			element = driver.findElement(AppiumBy.iOSNsPredicateString("wdLabel CONTAINS '" + name + "'"));
			args.put("direction", direction);
			args.put("predicateString", element);
			args.put("isVisible", "true");
			js.executeScript("mobile: scroll", args);
		}catch (Exception e){
			System.out.println("Scrolling");
		}
	}

	public void scrollUtillAnElement(String elementName, String direction) throws Exception {
		System.out.println("Appium Helper scrolling on " + elementName);
		int count=0;
		while(true){
			try{
				element = driver.findElement(AppiumBy.iOSNsPredicateString("wdLabel CONTAINS '" + elementName + "'"));
				break;
			}catch (Exception e){
				scroll(elementName, direction);
				count++;
				if(count==15){
					break;
				}

			}
		}

	}

	public void scrollByLabel(String name, String direction) {
		System.out.println("Appium Helper Scrolling " + direction);
		JavascriptExecutor js = driver;
		HashMap<Object, Object> args = new HashMap();
		element = driver.findElement(AppiumBy.iOSNsPredicateString("wdLabel CONTAINS '" + name + "'"));
		args.put("direction", direction);
		args.put("predicateString", element);
		args.put("isVisible", "true");
		js.executeScript("mobile: scroll", args);
	}
	/**
	 * Swipe
	 * element
	 * direction : opposite of how direction is used in mobile
	 * "up" will scroll view down and vis versa.
	 */

	public void swipe(String direction) {
		System.out.println("Appium Helper Swiping " + direction);
		JavascriptExecutor js = driver;
		HashMap<Object, Object> args = new HashMap();
		args.put("direction", direction);
		js.executeScript("mobile: swipe", args);
	}
	

	public void swipe1(String name, String direction) {
		System.out.println("Appium Helper Swiping " + direction);
		element = driver.findElement(AppiumBy.accessibilityId(name));
		//JavascriptExecutor js = driver;
		HashMap<String, String> args = new HashMap<String, String>();
		args.put("direction", direction);
		args.put("element", name);
		driver.executeScript("mobile: scroll", args);
	}

	public ArrayList<String> getAllAlbumElementsInGrid() throws Exception {
		ArrayList<String> arrayListlist = new ArrayList<>();
		elements = driver.findElements(AppiumBy.iOSNsPredicateString("wdType LIKE 'XCUIElementTypeCell'" +
				" AND wdLabel LIKE 'Photo ?' OR wdLabel LIKE 'Photo ??'" +
				" OR wdLabel LIKE 'Video ?' OR wdLabel LIKE 'Video ??'" +
				" OR wdLabel LIKE 'Live Photos ?' OR wdLabel LIKE 'Live Photos ??'" +
				" OR wdLabel LIKE 'Saved Story ?' OR wdLabel LIKE 'Saved Story ??'"));

		for (int i = 0; i < elements.size(); i++) {
			arrayListlist.add(elements.get(i).getAttribute("label"));
		}
		return arrayListlist;
	}

	private WebElement lastElement() throws Exception {
		ArrayList<String> list = getAllAlbumElementsInGrid();
		return element = driver.findElement(AppiumBy.accessibilityId(list.get(list.size() - 1)));
	}
	


	public WebElement firstElement() throws Exception {
		ArrayList<String> list = getAllAlbumElementsInGrid();
		return element = driver.findElement(AppiumBy.accessibilityId(list.get(0)));
	}

	public void waitForContent() throws Exception {
		System.out.println("== Waiting for content to appear ==");
		String query = "wdType == 'XCUIElementTypeCell' AND wdLabel CONTAINS 'Photo ' OR wdLabel CONTAINS 'Video ' OR wdLabel CONTAINS 'Photos albums folder'";
		elements = driver.findElements(AppiumBy.iOSNsPredicateString(query));
		int maxWait = 2000; //ms
		int currentTime = 0;

		while (elements.size() == 0) {
			if (currentTime >= maxWait)
				return;

			Thread.sleep(500);
			currentTime += 500;
			elements = driver.findElements(AppiumBy.iOSNsPredicateString(query));
		}
	}

	public String infoItems(String infotype) {
		List<WebElement> list;
		String value = null;
		list = driver.findElements(By.xpath("//XCUIElementTypeTable[1]/XCUIElementTypeCell"));
		for (int i = 0; i < list.size(); i++) {
			String expected = list.get(i).findElement(By.xpath("//XCUIElementTypeStaticText")).getText();
			if (expected.contains(infotype)) {
				value = list.get(i).findElement(By.xpath("//XCUIElementTypeStaticText[2]")).getText();
				break;
			}
		}
		return value;
	}

	public String getPhotoVideoCount() {
		return driver.findElement(By.xpath("//XCUIElementTypeTable[1]/XCUIElementTypeCell[3]/XCUIElementTypeStaticText[1]")).getText();

	}


	/**
	 * PresenceOfElementLocated
	 * Check if element is present on DOM
	 */
	public void waitForPresent(String elementName) throws Exception {
		System.out.println("Appium Helper waiting for present " + elementName);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId(elementName)));
	}

	public void clickOnByIndexFromClassName(int index, String className) throws Exception {
		driver.findElements(AppiumBy.className(className)).get(index).click();
	}

	public void clickOnByIndexFromXpath(int index, String xpath) throws Exception {
		driver.findElements(AppiumBy.className(xpath)).get(index).click();
	}

	public boolean clickOnByIndexFromXpath(String xpath) throws Exception {
		return driver.findElement(AppiumBy.className(xpath)).isDisplayed();
	}

	public boolean isDisplayedByNameAndType(String elementName, String className) {
		return driver.findElement(AppiumBy.iOSNsPredicateString
				("name == '" + elementName + "' AND wdType == '" + className + "'")).isDisplayed();
	}

	public void turnOnSwitch(String elementName) {

		driver.findElement(AppiumBy.iOSNsPredicateString("name == '" + elementName + "' AND wdType == 'XCUIElementTypeSwitch'")).click();

	}

	public String getindexofSwitch(String elementName) {
		return driver.findElement(AppiumBy.iOSNsPredicateString("name == '" + elementName + "' AND wdType == 'XCUIElementTypeSwitch'")).getAttribute("value");
	}

	public void switchONandOFF(String elementName) throws Exception { //created BY SL
		System.out.println("Appium Helper Click on " + elementName);
		element = driver.findElement(AppiumBy.iOSNsPredicateString("label CONTAINS '" + elementName + "' && wdType == 'XCUIElementTypeSwitch'"));
		element.click();
	}
	public void setDateTimePickerValue(int index, String value) {
		driver.findElements(AppiumBy.className(vz_strings.class_PickerWheel)).get(index).sendKeys(value);
	}


	public void touchAndHoldOnElement(org.openqa.selenium.WebElement element) throws Exception {
		JavascriptExecutor js = driver;
		Map<String, Object> params = new HashMap<>();
		params.put("element", element);
		params.put("duration", 2.0);
		js.executeScript("mobile: touchAndHold", params);
	}

	public org.openqa.selenium.WebElement getLivePhotoElement(){
		return driver.findElement(AppiumBy.iOSNsPredicateString("wdLabel CONTAINS 'Live Photos'"));
	}

	/*
	 * public void aiElement(){ //driver.findElement("-custom", "ai:add").click();
	 * //driver.findElement("-custom", "ai:story").click();
	 * //driver.findElement(AppiumBy)("-custom", "ai:story").clickOn(); }
	 */


	public void delete(String deleteOptions) throws Exception {
		openContext(vz_strings.context_delete);
		if (deleteOptions.equals("Move to Trash")) {
			clickOn(vz_strings.del_moveToTrash);
		}
	}

	public void del_moveToTrash() throws Exception {
		openContext(vz_strings.context_delete);
		clickOn(vz_strings.del_moveToTrash);

	}

	public void startRecording() {
		((CanRecordScreen)driver).startRecordingScreen(new IOSStartScreenRecordingOptions());
	}

	public void stopRecording() {
		((CanRecordScreen)driver).stopRecordingScreen(new IOSStopScreenRecordingOptions().withUploadOptions(ScreenRecordingUploadOptions.uploadOptions()));
	}
}