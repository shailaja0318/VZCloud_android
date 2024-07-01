package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class VZNFT128SAEnteredSearchText extends BaseTestClass {

    @Test
    public void testVZNFT128SAEnteredSearchText() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        baseControlsHelper.clickOn(vz_strings.view_searchStoriesBar);

        String logs = localyticsHelper.getLogs();
        TestCase.assertTrue("Localytics of " + vz_strings.logs_storiesSearch + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_storiesSearch));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_storiesSearch + " is not 1 in logs", 1, localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_storiesSearch));
        TestCase.assertTrue(vz_strings.logs_step + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_step + " = " + "\"" + vz_strings.logs_enteredSearchText));

        localyticsHelper.print(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_storiesSearch);

    }
}