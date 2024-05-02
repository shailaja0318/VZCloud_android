package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

public class VZNFT14RestoreFlowStep extends BaseTestClass {

    public void reset() throws Exception {


        baseControlsHelper.clickOn(vz_strings.tools_restore);
        baseControlsHelper.clickOn(vz_strings.button_cancel);
        baseControlsHelper.clickOn(vz_strings.button_yes);
        baseControlsHelper.waitForShow(vz_strings.tools_restore);
    }

    //@Test we cant restore becuase we are not sure of time hence its better to do this tc manually
    public void testRestoreScanningMedia() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_tools);
        baseControlsHelper.clickOn(vz_strings.tools_restore);
        baseControlsHelper.clickOn(vz_strings.media_restore);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_restoreFlowStep);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_contentRestoreListItemClick + " is not 1 in logs", localyticsHelper.getCountOf(logs, vz_strings.logs_contentRestoreListItemClick) == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_contentRestoreButtonClick + " is not 1 in logs", localyticsHelper.getCountOf(logs, vz_strings.logs_contentRestoreButtonClick) == 1);
        reset();

    }
}
