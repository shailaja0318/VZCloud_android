package com.verizon.appiumtests.localytics.home;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;


public class LocalyticsHomeScreenBackupIcon extends BaseTestClass {

    //NOTPASSING@Test
    public void testLocalyticsHelp() throws Exception {


        baseControlsHelper.tapOnBackButton();

        String logs = localyticsHelper.getLogs();
        TestCase.assertTrue("Localytics of " + vz_strings.logs_homeScreenBackupIconClicked + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_homeScreenBackupIconClicked));
        localyticsHelper.print(logs, vz_strings.logs_homeScreenBackupIconClicked);
    }
}
