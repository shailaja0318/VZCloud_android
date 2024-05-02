//https://jira.synchronoss.net:8443/jira/browse/IV-2343
package com.verizon.appiumtests.settings.whattobackup;

import com.verizon.appiumtests.constants.HelperUtilities;
import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class WhatToBackupScreen extends BaseTestClass {

    @Test
    public void testWhatToBackupScreen() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_settings);
        settingsView.setWhatToBackUp(HelperUtilities.setArguments("", vz_strings.settings_whatToBackUp_Photos));
        TestCase.assertEquals("Background photo backup option not displayed", true, baseControlsHelper.isVisible(vz_strings.settings_WhatToBackUp_BackGroundPhotoBackUp));
        TestCase.assertEquals("Toggle is not enabled", "1", baseControlsHelper.getValueByIndexfromClassName(3, "XCUIElementTypeSwitch"));
		/*
		 * TestCase.assertEquals(vz_strings.settings_WhatToBackUp_CloudBackupPhotosText
		 * + " not displayed", vz_strings.settings_WhatToBackUp_CloudBackupPhotosText,
		 * baseControlsHelper.getTextByNameContains("Let the Cloud"));
		 */
    }
}
