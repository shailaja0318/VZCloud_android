package com.verizon.appiumtests.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class ConnectedApps extends BaseTestClass {

    @Test
    public void testConnectedApps() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_settings);
        baseControlsHelper.clickOn(vz_strings.navi_appsUsingCloud);
        baseControlsHelper.waitForShow(vz_strings.auc_appsusingcloud);
        TestCase.assertTrue("Apps Using Cloud heading missing? ", baseControlsHelper.getCountById(vz_strings.auc_appsusingcloud) > 0);
    }
}
