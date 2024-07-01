package com.verizon.appiumtests.controls;

import com.verizon.appiumtests.constants.HelperUtilities;
import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.driver.BaseDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Keys;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SettingsView {

    AppiumDriver driver = BaseDriver.getDriver();
    BaseControlsHelper baseControlsHelper = new BaseControlsHelper(driver);

    public SettingsView(AppiumDriver driver) {
        this.driver = driver;
    }


    public void setWhatToBackUp(List<String> options) throws Exception {
    	Thread.sleep(2000);
      //  baseControlsHelper.clickOn(vz_strings.settings_whatToBackUp);
        System.out.println(options);
        System.out.println(baseControlsHelper.getCountByXpath("//*[@type='XCUIElementTypeSwitch']"));
        System.out.println("***** i Options SIZE*****" +options.size());
        for (int i = 0; i < options.size(); i++) {
            for (int j = 0; j < baseControlsHelper.getCountByXpath("//*[@type='XCUIElementTypeSwitch']"); j++) {
                if (options.get(i).contentEquals(baseControlsHelper.getTypeByIndexfromXpath
                        (j, "//*[@type='XCUIElementTypeSwitch']"))) {
                    if (Integer.parseInt(baseControlsHelper.getValueByIndexfromXpath
                            (j, "//*[@type='XCUIElementTypeSwitch']")) != 1) {
                        baseControlsHelper.clickOnByIndexFromXpath(i, "//*[@type='XCUIElementTypeSwitch']");
                    }
                }
            }
        }
    }

    public void setWhatNotToBackUp(List<String> options) throws Exception {
        baseControlsHelper.clickOnElementByXpath(vz_strings.setting_uploadSettings);
        for (int i = 0; i < options.size(); i++) {
            for (int j = 0; j < baseControlsHelper.getCountByXpath("//*[@type='XCUIElementTypeSwitch']"); j++) {
                if (options.get(i).contentEquals(baseControlsHelper.
                        getTypeByIndexfromXpath(j, "//*[@type='XCUIElementTypeSwitch']"))) {
                    if (Integer.parseInt(baseControlsHelper.getValueByIndexfromXpath(j, "//*[@type='XCUIElementTypeSwitch']")) != 0)
                        baseControlsHelper.clickOnByIndexFromXpath(i, "//*[@type='XCUIElementTypeSwitch']");
                }
            }
        }
    }


    public void disableAllOptions() throws Exception {
        baseControlsHelper.clickOn(vz_strings.settings_whatToBackUp);
        for (int i = 0; i < baseControlsHelper.getCountByClassName("XCUIElementTypeSwitch"); i++) {
            if (Integer.parseInt(baseControlsHelper.getValueByIndexfromClassName(i, "XCUIElementTypeSwitch")) != 0) {
                baseControlsHelper.clickOnByIndexFromClassName(i, "XCUIElementTypeSwitch");
            }
        }
    }

    public void alterBackGroundPhotoBackUp(String state) throws Exception {
        if (state.equalsIgnoreCase("off")) {
            if (Integer.parseInt(baseControlsHelper.getValue(vz_strings.settings_WhatToBackUp_BackGroundPhotoBackUp_Button)) != 0)
                baseControlsHelper.clickOn(vz_strings.settings_WhatToBackUp_BackGroundPhotoBackUp_Button);
        } else {
            if (Integer.parseInt(baseControlsHelper.getValue(vz_strings.settings_WhatToBackUp_BackGroundPhotoBackUp_Button)) != 1)
                baseControlsHelper.clickOn(vz_strings.settings_WhatToBackUp_BackGroundPhotoBackUp_Button);
        }
    }

    /**
     * Changes the email address in the email field
     *
     * @param email An <code>email address</code> to set
     * @throws Exception
     * @author Alen Kalac
     */
    public void updateEmail(String email) throws Exception {
        System.out.println("Updating email address to: " + email);
        String email_field = vz_strings.settings_emailField;
        baseControlsHelper.clearValueOnTextfieldByName(email_field);
        baseControlsHelper.setValuetoTextFieldByName(email, email_field);
        baseControlsHelper.setValuetoTextFieldByName(email, email_field);
        driver.findElement(AppiumBy.accessibilityId(email_field)).sendKeys(Keys.ENTER);
       
       //driver.getKeyboard().pressKey(Keys.ENTER);
        
  
    }

    public List<String> settingMyAccountItems = Arrays.asList(
            vz_strings.settings_email,
            vz_strings.settings_My_Profile,
            vz_strings.delete_My_Account);

    public List<String> settingItem = Arrays.asList(
            vz_strings.settings_whatToBackUp,
            vz_strings.settings_HowToBackUp,
            vz_strings.my_Account,
            vz_strings.settings_manageStorage,
            vz_strings.logs_tools,
            vz_strings.settings_about);


    public boolean elementVisibleSettings(String settingType) throws Exception {
        switch (settingType) {
            case vz_strings.my_Account: {
                for (String items : settingMyAccountItems) {
                    if (baseControlsHelper.getCountById(items) == 0) return false;
                }
                break;
            }
            case vz_strings.navi_settings: {
                for (String items : settingItem) {
                    if (baseControlsHelper.getCountById(items) == 0) return false;
                }
                break;
            }
        }
        return true;
    }

    public String generateRandomEmailAddress() {
        String alphabets = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder mail = new StringBuilder();
        Random rnd = new Random();
        while (mail.length() < 10) {
            int index = (int) (rnd.nextFloat() * alphabets.length());
            mail.append(alphabets.charAt(index));
        }
        String mailID = mail.toString();
        return mailID;
    }

    public boolean verifyDisplayOfBackUpOptions() throws Exception {
        return baseControlsHelper.isDisplayedByNameAndType
                ("Contacts","XCUIElementTypeSwitch") &&
                baseControlsHelper.isDisplayedByNameAndType
                        ("Photos","XCUIElementTypeSwitch") &&
                baseControlsHelper.isDisplayedByNameAndType
                        ("Videos","XCUIElementTypeSwitch");
    }

    public boolean verifyDisplayOfBackUpOptionsByIndex() throws Exception {
        return baseControlsHelper.clickOnByIndexFromXpath("XCUIElementTypeSwitch") &&
                baseControlsHelper.clickOnByIndexFromXpath
                        ("XCUIElementTypeSwitch") &&
                baseControlsHelper.clickOnByIndexFromXpath
                        ("XCUIElementTypeSwitch");
    }


    public String getCurrentStoragePlan() throws Exception {
        String plan=null;
        baseControlsHelper.clickOn(vz_strings.settings_manageStorage_oneTB_plan);
        if (baseControlsHelper.getCountById(vz_strings.settings_manageStorage_confirm_popup) == 0) {
            plan = baseControlsHelper.getTextById(vz_strings.settings_manageStorage_oneTB_plan);
        }
        else {
            baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.button_cancel);
            plan= baseControlsHelper.getTextById(vz_strings.settings_manageStorage_500GB_plan);
            baseControlsHelper.waitForShow(vz_strings.navi_icon);
            baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage);
            baseControlsHelper.waitForPresent(vz_strings.settings_manageStorage_oneTB_plan);
        }
        return plan;
    }

    public void upgradeStorageToOneTB() throws Exception {
        if (getCurrentStoragePlan().equalsIgnoreCase(vz_strings.settings_manageStorage_oneTB_plan)) {
            System.out.println("Storage plan already upgraded to 1 TB");
        } else {
            System.out.println("Storage plan upgrading to 1 TB");
            baseControlsHelper.waitForPresent(vz_strings.settings_manageStorage_oneTB_plan);
            baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage_oneTB_plan);
            baseControlsHelper.isVisible(vz_strings.settings_manageStorage_confirm_popup);
            baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage_upgrade);
            baseControlsHelper.isVisibleByLabelAndType("XCUIElementTypeStaticText", vz_strings.settings_manageStorage_storageUpgraded_popup);
            baseControlsHelper.waitForPresent(vz_strings.settings_manageStorage_1TB_upgrade_popupText);
            baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.button_ok);
            baseControlsHelper.waitForPresent(vz_strings.navi_icon);
            baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage);
            baseControlsHelper.waitForPresent(vz_strings.settings_manageStorage_oneTB_plan);
        }
    }

    public void downgradeStorageTo500GB() throws Exception {
        if (getCurrentStoragePlan().equalsIgnoreCase(vz_strings.settings_manageStorage_500GB_plan)) {
            System.out.println("Storage plan already downgraded to 500 GB");
        } else {
            System.out.println("Storage plan downgrading to 500 GB");
            baseControlsHelper.waitForPresent(vz_strings.settings_manageStorage_500GB_plan);
            baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage_500GB_plan);
            baseControlsHelper.isVisible(vz_strings.settings_manageStorage_confirm_popup);
            baseControlsHelper.clickOn(vz_strings.settings_manageStorage_confirm_popup);
            baseControlsHelper.isVisibleByLabelAndType("XCUIElementTypeStaticText", vz_strings.settings_manageStorage_storageDowngraded_popup);
            baseControlsHelper.waitForPresent(vz_strings.settings_manageStorage_500GB_downgrade_popupText);
            baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.button_ok);
            baseControlsHelper.waitForPresent(vz_strings.settings_manageStorage);
        }
    }

    public boolean cancelStoragePlanChange() throws Exception {
        boolean status = false;
        if (getCurrentStoragePlan().equalsIgnoreCase("500 GB")) {
            baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage_oneTB_plan);
            if (baseControlsHelper.isVisible(vz_strings.button_cancel) &&
                    baseControlsHelper.isVisible(vz_strings.settings_manageStorage_upgrade))
                status = true;
            baseControlsHelper.clickOn(vz_strings.button_cancel);
        } else {
            baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage_500GB_plan);
            if (baseControlsHelper.isVisible(vz_strings.button_cancel) &&
                    baseControlsHelper.isVisible(vz_strings.settings_manageStorage_confirm_popup))
                status = true;
            baseControlsHelper.clickOn(vz_strings.button_cancel);
        }
        return status;
    }

    public void tapOnBackButtonAndSetWhatToBackup(boolean flag,int number) throws Exception {
        HomeScreenView homeScreenView=new HomeScreenView(driver);
        if (flag) {
            for (int i = 0; i < number; i++) {
                baseControlsHelper.tapOnBackButton();
            }
            homeScreenView.navigateTo(vz_strings.navi_settings);
            setWhatToBackUp(HelperUtilities.setArguments(vz_strings.settings_whatToBackUp_Contacts, vz_strings.settings_whatToBackUp_Photos, vz_strings.settings_whatToBackUp_Videos));
        }
    }
}
