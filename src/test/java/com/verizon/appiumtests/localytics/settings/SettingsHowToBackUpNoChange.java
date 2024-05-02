//VZNFT-15 - Step 6
package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SettingsHowToBackUpNoChange extends BaseTestClass {
    private SoftAssert softAssert = new SoftAssert();

    @Test
    public void testSettingsHowToBackUpNoChange() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_settings);
        baseControlsHelper.clickOn(vz_strings.settings_HowToBackUp);
        baseControlsHelper.tapOnBackButton();

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_whatToBackupModification);

        softAssert.assertEquals(localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_whatToBackupModification),
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
                localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_whatToBackupVideos + "\"" + " = " + "\"" + vz_strings.logs_no_change + "\""),
                1,
                vz_strings.logs_whatToBackupVideos + " does not exist");

        softAssert.assertEquals(localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_whatToBackupHowToBackup + "\"" + " = " + "\"" + vz_strings.logs_no_change + "\""),
                1,
                vz_strings.logs_no_change + " does not exist");
        softAssert.assertAll();
    }
}
