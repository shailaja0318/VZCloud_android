		//VZNFT-18
package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.asserts.SoftAssert;


public class VZNFT18LocalyticsMergeContent extends BaseTestClass {
    private SoftAssert softAssert = new SoftAssert();

  //  @Test
    public void testLocalyticsMergeContent() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_settings);
        baseControlsHelper.clickOn(vz_strings.navi_tools);
        baseControlsHelper.clickOn(vz_strings.tools_merge);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tools);
        localyticsHelper.print(logs, vz_strings.logs_mergeAccounts);

        softAssert.assertEquals(localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_mergeAccounts),
                1,
                vz_strings.logs_mergeAccounts + " is not 1 in logs");
    }
}
