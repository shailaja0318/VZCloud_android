//VZNFT-11 Step 8 ER
package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.HelperUtilities;
import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class BackUpPhotosVideosYesBackGroundPhotoNo extends BaseTestClass {
    @Test
    public void testBackUpPhotosVideosYesBackGroundPhotoNo() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_settings);
        settingsView.setWhatNotToBackUp(HelperUtilities.setArguments("", vz_strings.settings_whatToBackUp_Photos, vz_strings.settings_whatToBackUp_Videos));
        baseControlsHelper.tapOnBackButton();
        settingsView.setWhatToBackUp(HelperUtilities.setArguments("", vz_strings.settings_whatToBackUp_Photos, vz_strings.settings_whatToBackUp_Videos));
        settingsView.alterBackGroundPhotoBackUp("off");
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_whatToBackupModification);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_whatToBackupModification + " does not exist", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_whatToBackupModification) >= 1 && localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_whatToBackupModification) <= 3);
        TestCase.assertEquals(vz_strings.logs_whatToBackupPhotosBackground + " does not exist", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_whatToBackupPhotosBackground + "\"" + " = " + vz_strings.logs_no));
    }
}
