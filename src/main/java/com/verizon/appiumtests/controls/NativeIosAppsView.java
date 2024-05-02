package com.verizon.appiumtests.controls;

//import com.sncr.verizon.appiumtests.constants.EmailAndMessageUtils;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.driver.BaseDriver;
import io.appium.java_client.AppiumDriver;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NativeIosAppsView {
    AppiumDriver driver = BaseDriver.getDriver();
    BaseControlsHelper baseControlsHelper = new BaseControlsHelper(driver);

    public NativeIosAppsView(AppiumDriver driver) {
        this.driver = driver;
    }

    public void resetSettingsApp() {
        BaseDriver.activateApp(vz_strings.BundleIds.APL_SETTINGS);
        BaseDriver.terminateApp(vz_strings.BundleIds.APL_SETTINGS);
    }

    public void turnOnAndOffAirplaneMode() throws Exception {
        BaseDriver.lanuchApp(vz_strings.BundleIds.APL_SETTINGS);
        baseControlsHelper.clickOnNameBeginswith(vz_strings.NativeApps.AIRPLANE_MODE);
    }

    public int isLocationServiceEnabled() throws Exception {
        resetSettingsApp();
        BaseDriver.lanuchApp(vz_strings.BundleIds.APL_SETTINGS);
        baseControlsHelper.scroll(vz_strings.settings_Privacy, "down");
        baseControlsHelper.clickOn(vz_strings.settings_Privacy);
        baseControlsHelper.clickOn(vz_strings.logs_location_services);
        return Integer.parseInt(baseControlsHelper.getValueByIndexfromClassName(0, vz_strings.XCUITypes.XCUI_SWITCH));
    }

    public void toggleLocationServices(String status) throws Exception {
        if (status.equalsIgnoreCase("Off")) {
            baseControlsHelper.clickOnByIndexFromClassName(0, vz_strings.XCUITypes.XCUI_SWITCH);
            baseControlsHelper.clickOn(vz_strings.turnOff_Button);
        } else baseControlsHelper.clickOnByIndexFromClassName(0, vz_strings.XCUITypes.XCUI_SWITCH);
    }

    public String getDeviceEmailAccount() throws Exception {
        BaseDriver.lanuchApp(vz_strings.BundleIds.APL_SETTINGS);
        baseControlsHelper.clickOn(vz_strings.settings_appleid);
        System.out.println("******EMAIL ID IS ***********" +(baseControlsHelper.getTextByNameContains("@gmail.com")));
        return baseControlsHelper.getTextByNameContains("@gmail.com");
    }

	
	  public void generateSMS(String message) throws Exception {
	  BaseDriver.terminateApp(vz_strings.BundleIds.APL_SMS);
	  BaseDriver.lanuchApp(vz_strings.BundleIds.APL_SMS);
	  baseControlsHelper.clickOn(vz_strings.native_message_compose_button);
	  //baseControlsHelper.setValuetoTextFieldByName(EmailAndMessageUtils.randomMobileNumber(), vz_strings.native_message_receiver);
	  baseControlsHelper.setValuetoTextFieldByName(message,
	  vz_strings.native_message_body);
	  baseControlsHelper.clickOn(vz_strings.native_message_sendButton);
	  baseControlsHelper.tapOnBackButton(); }
	 
    public void resetLaunchSMSApp() throws Exception {
        BaseDriver.lanuchApp(vz_strings.BundleIds.APL_SMS);
    }

    public String getCodeFromSMS() throws Exception {
        resetLaunchSMSApp();
        baseControlsHelper.clickOnLabelContainsAndType(vz_strings.NativeApps.VERIZON_MSG, vz_strings.XCUITypes.XCUI_CELL);
        String code = retrieveSecurityCode();
        return code;
    }

    public String retrieveSecurityCode() throws Exception {
        String sms = baseControlsHelper.getAttrByContainsLabelAndType(vz_strings.NativeApps.VERIZON_PHONE_NUMBER);
        System.out.println(sms);
        Pattern pat = Pattern.compile("\\d{6}(?=\\.)");
        System.out.println(pat);
        Matcher mat = pat.matcher(sms);
        return mat.find() ? mat.group(0) : null;
    }

    public void deleteAllSMS() throws Exception {
        resetLaunchSMSApp();
        clickEditButton();

        if (baseControlsHelper.getCountById(vz_strings.context_delete) > 0) {
            baseControlsHelper.clickOn(vz_strings.context_delete);
        }
    }

    public void clickEditButton() throws Exception {

        Thread.sleep(2000);
        if (baseControlsHelper.getCountById(vz_strings.NativeApps.CKCHAT_BACKBUTTON_SMS) > 0) {
            baseControlsHelper.tapOnBackButton();
        }
        Thread.sleep(2000);
        if (baseControlsHelper.getCountById(vz_strings.NativeApps.EDIT_NUMBER) > 0) {
            baseControlsHelper.clickOn(vz_strings.NativeApps.EDIT_NUMBER);
        }

        Thread.sleep(2000);
        if (baseControlsHelper.getCountByClassName(vz_strings.XCUITypes.XCUI_SWITCH) > 0) {
            selectAllUnselectedSwitches();
        }
    }

    public void selectAllUnselectedSwitches() throws Exception {
        for (int i = 0; i < baseControlsHelper.getCountByClassName(vz_strings.XCUITypes.XCUI_SWITCH); i++) {
            if (Integer.parseInt(baseControlsHelper.getValueByIndexfromClassName(i, vz_strings.XCUITypes.XCUI_SWITCH)) != 1) {
                baseControlsHelper.clickOnByIndexFromClassName(i, vz_strings.XCUITypes.XCUI_SWITCH);
            }
        }
    }

    public void generateLivePhoto(int photoCount) throws Exception {
        BaseDriver.terminateApp(vz_strings.BundleIds.APL_CAM);
        BaseDriver.lanuchApp(vz_strings.BundleIds.APL_CAM);
        if (!baseControlsHelper.getValue(vz_strings.native_Camera_LivePhoto).equalsIgnoreCase("On")) {
            baseControlsHelper.clickOn(vz_strings.native_Camera_LivePhoto);
        }
        for (int i = 0; i < photoCount; i++) {
            baseControlsHelper.clickOn(vz_strings.native_Camera_Capture_Icon);
            Thread.sleep(5000);
        }
        BaseDriver.lanuchApp(vz_strings.BundleIds.APL_CAM);
        //BaseDriver.getDriver().launchApp();
    }
    
    public void generatePhotos(int photoCount) throws Exception {
    	BaseDriver.terminateApp(vz_strings.BundleIds.APL_CAM);
        BaseDriver.lanuchApp(vz_strings.BundleIds.APL_CAM);
        if (baseControlsHelper.getValue(vz_strings.native_Camera_LivePhoto).equalsIgnoreCase("On")) {
            baseControlsHelper.clickOn(vz_strings.native_Camera_LivePhoto); // to off Live Photos
        }
        for (int i = 0; i < photoCount; i++) {
            baseControlsHelper.clickOn(vz_strings.native_Camera_Capture_Icon);
            Thread.sleep(5000);
        }
        BaseDriver.lanuchApp(vz_strings.BundleIds.APL_CAM); // BaseDriver.getDriver().launchApp();
    }
    public void toggle3DTouch(String action) throws Exception {
        if (action.equalsIgnoreCase("off")) {
            BaseDriver.terminateApp(vz_strings.BundleIds.APL_SETTINGS);
            BaseDriver.lanuchApp(vz_strings.BundleIds.APL_SETTINGS);
            if (!baseControlsHelper.isVisible(vz_strings.settings_General))
                baseControlsHelper.scroll(vz_strings.settings_General, "down");
            baseControlsHelper.clickOn(vz_strings.settings_General);
            baseControlsHelper.clickOn(vz_strings.native_Accessibility_Button);
            baseControlsHelper.scroll(vz_strings.native_3DTouch_Button, "down");
            baseControlsHelper.clickOn(vz_strings.native_3DTouch_Button);
            if (Integer.parseInt(baseControlsHelper.getValueByIndexfromClassName(0, vz_strings.class_Switch)) != 0)
                baseControlsHelper.clickOnNameBeginswithAndType(vz_strings.native_3DTouch_Button, vz_strings.class_Switch);
        } else {
            BaseDriver.lanuchApp(vz_strings.BundleIds.APL_SETTINGS);
            if (Integer.parseInt(baseControlsHelper.getValueByIndexfromClassName(0, vz_strings.class_Switch)) != 1)
                baseControlsHelper.clickOnNameBeginswithAndType(vz_strings.native_3DTouch_Button, vz_strings.class_Switch);
        }
        BaseDriver.lanuchApp(vz_strings.BundleIds.APL_CAM); // BaseDriver.getDriver().launchApp();
    }

    public void resetContactsApp() {
        BaseDriver.activateApp(vz_strings.BundleIds.APL_CONTACTS);
        BaseDriver.terminateApp(vz_strings.BundleIds.APL_CONTACTS);
    }

    public void addContacts(int count, String firstName, String number) throws Exception {
        resetContactsApp();
        BaseDriver.lanuchApp(vz_strings.BundleIds.APL_CONTACTS);
        for (int i = 0; i < count; i++) {
            baseControlsHelper.clickOn(vz_strings.native_Contacts_AddButton);
            baseControlsHelper.setValuetoTextFieldByName(firstName, vz_strings.native_Contacts_FirstName);
            baseControlsHelper.clickOn(vz_strings.native_Contacts_AddPhone);
            baseControlsHelper.setValuetoTextFieldByName(number, vz_strings.native_Contacts_Phone);
            baseControlsHelper.clickOn(vz_strings.button_done);
            baseControlsHelper.tapOnBackButton();
            Thread.sleep(2000);
        }
    }
    
    public String currentTime() {
    	  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    	  LocalTime localTime = LocalTime.now();
    	  System.out.println(dtf.format(localTime));
    	  return dtf.format(localTime);
    }

    /*public void navigateToFujiCanvasFromMail() throws Exception {
        BaseDriver.runAppInBackground(-1);
        resetSettingsApp();
        Thread.sleep(2000);
        String receiver = getDeviceEmailAccount();
        EmailAndMessageUtils.sendEmail("vz", vz_strings.Deeplinks.PRINTS_AND_GIFTS_CANVAS, receiver);
        BaseDriver.terminateApp(vz_strings.BundleIds.APL_MAIL);
        BaseDriver.lanuchApp(vz_strings.BundleIds.APL_MAIL);
        Thread.sleep(5000);
        baseControlsHelper.clickOnNameContains(vz_strings.Deeplinks.PRINTS_AND_GIFTS_CANVAS);
        baseControlsHelper.clickOnNameContains(vz_strings.Deeplinks.PRINTS_AND_GIFTS_CANVAS);
    }*/
    
    public void generateVideo(int photoCount) throws Exception {
        BaseDriver.terminateApp(vz_strings.BundleIds.APL_CAM);
        BaseDriver.lanuchApp(vz_strings.BundleIds.APL_CAM);
        Thread.sleep(2000);
        baseControlsHelper.clickOn("Video");
        Thread.sleep(5000);
        if (!baseControlsHelper.getValue(vz_strings.native_Camera_LivePhoto).equalsIgnoreCase("On")) {
            baseControlsHelper.clickOn(vz_strings.native_Camera_LivePhoto);
        }
        for (int i = 0; i < photoCount; i++) {
            baseControlsHelper.clickOn(vz_strings.native_Camera_Capture_Icon);
            Thread.sleep(5000);
        }
        BaseDriver.lanuchApp(vz_strings.BundleIds.APL_CAM); //BaseDriver.getDriver().launchApp();
    }

}
