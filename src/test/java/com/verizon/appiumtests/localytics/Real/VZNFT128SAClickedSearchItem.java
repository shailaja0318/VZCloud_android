/**
 * VZNFT-128 All steps
 * */
package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class VZNFT128SAClickedSearchItem extends BaseTestClass {

    @Test
    public void testVZNFT128SAClickedSearchItem() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        baseControlsHelper.clickOn(vz_strings.view_searchStoriesBar);
        baseControlsHelper.setValuetoTextFieldByName("Story", vz_strings.view_searchStoriesBar);
        baseControlsHelper.clickOn(vz_strings.button_search);
        photosAndVideosView.openStory10();

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_storiesSearch + " does not exist",
                 localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_storiesSearch) == 3);

        TestCase.assertTrue("Localytics of " + "\"" + vz_strings.logs_enteredSearchText + "\"" + " is not 1 in logs",
                localyticsHelper.getCountOf(logs, vz_strings.logs_step + " = \"" + vz_strings.logs_enteredSearchText + "\"") == 1);

        TestCase.assertTrue("Localytics of " + "\"" + vz_strings.logs_clickedSearchButton + "\"" + " is not 1 in logs",
                localyticsHelper.getCountOf(logs, vz_strings.logs_step + " = \"" + vz_strings.logs_clickedSearchButton + "\"") == 1);

        TestCase.assertTrue(vz_strings.logs_clickedSearchItem + " does not exist",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_step + " = \"" + vz_strings.logs_clickedSearchItem + "\"") == 1);
    }
}

