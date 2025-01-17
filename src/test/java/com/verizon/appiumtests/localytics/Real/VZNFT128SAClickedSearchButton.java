//https://jira.synchronoss.net:8443/jira/browse/VZNFT-128
package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class VZNFT128SAClickedSearchButton extends BaseTestClass {

    @Test
    public void testVZNFT128SAClickedSearchButton() throws Exception {
        //unable to find date time ...Failing

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        baseControlsHelper.clickOn(vz_strings.view_searchStoriesBar);
        baseControlsHelper.setValuetoTextFieldByName("St", vz_strings.view_searchStoriesBar);
        baseControlsHelper.clickOn(vz_strings.button_search);
        Thread.sleep(4000);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_storiesSearch);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_storiesSearch + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_storiesSearch));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_storiesSearch + " is not in logs", localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_storiesSearch)>0);
        TestCase.assertTrue(vz_strings.logs_step + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_step + " = " + "\"" + vz_strings.logs_clickedSearchButton));
    }
}
