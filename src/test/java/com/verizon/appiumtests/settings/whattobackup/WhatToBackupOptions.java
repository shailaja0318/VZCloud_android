//https://jira.synchronoss.net:8443/jira/browse/IV-93
package com.verizon.appiumtests.settings.whattobackup;

import com.verizon.appiumtests.constants.HelperUtilities;
import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

/**
 * Created by ssam0003 on 16/05/18.
 */
public class WhatToBackupOptions extends BaseTestClass {
    private final static Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testWhatToBackupOptions() throws Exception {
        logger.info("*****Start Test*****");
        homeScreenView.navigateTo(vz_strings.navi_settings);
        settingsView.setWhatToBackUp(HelperUtilities.setArguments("", vz_strings.settings_whatToBackUp_Photos));
        logger.info("Photo backup option enabled");
        TestCase.assertEquals("Backup options not displayed ", true, settingsView.verifyDisplayOfBackUpOptions());
        TestCase.assertEquals("Background photo backup option not displayed", true,
                baseControlsHelper.isVisible(vz_strings.settings_WhatToBackUp_BackGroundPhotoBackUp));
        logger.info("*****End Test*****");
    }
}
