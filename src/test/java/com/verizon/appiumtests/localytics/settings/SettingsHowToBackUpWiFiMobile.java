//VZNFT-15 - Step 4
package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SettingsHowToBackUpWiFiMobile extends BaseTestClass {

    private final SoftAssert softAssert = new SoftAssert();

    @Test
    public void testSettingsHowToBackUpWiFiMobile() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_settings);
        baseControlsHelper.clickOn(vz_strings.settings_HowToBackUp);
        baseControlsHelper.clickOn(vz_strings.settings_HowToBackUp_Wifi_Mobile);
        baseControlsHelper.tapOnBackButton();

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_whatToBackupModification);

        softAssert.assertEquals(localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_whatToBackupModification) ,
                1,
                vz_strings.logs_whatToBackupModification + " does not exists ");

        softAssert.assertEquals(localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_whatToBackupContacts + "\"" + " = " + "\"" + vz_strings.logs_no_change + "\""),
                1,
                vz_strings.logs_whatToBackupContacts + " does not exist");

        softAssert.assertEquals(
                localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_whatToBackupPhotos + "\"" + " = " + "\"" + vz_strings.logs_no_change + "\""),
                1,
                vz_strings.logs_whatToBackupPhotos + " does not exist");

        softAssert.assertEquals(
                localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_whatToBackupPhotosBackground + "\"" + " = " + "\"" + vz_strings.logs_no_change + "\""),
                1,
                vz_strings.logs_whatToBackupPhotosBackground + " does not exist");

        softAssert.assertEquals(
                localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_whatToBackupVideos + "\"" + " = " + "\"" + vz_strings.logs_no_change + "\"") ,
                1,
                vz_strings.logs_whatToBackupVideos + " does not exist");

        softAssert.assertEquals(localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_whatToBackupHowToBackup + "\"" + " = " + "\"" + vz_strings.logs_Wifi_Mobile + "\""),
                1,
                vz_strings.logs_Wifi_Mobile + " does not exist");

        baseControlsHelper.clickOn(vz_strings.settings_HowToBackUp);
        baseControlsHelper.clickOn(vz_strings.settings_HowToBackUp_Wifi);
        baseControlsHelper.tapOnBackButton();
        softAssert.assertAll();
    }
}
