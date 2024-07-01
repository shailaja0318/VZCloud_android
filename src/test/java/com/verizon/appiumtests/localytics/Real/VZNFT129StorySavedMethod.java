/**
 * VZNFT-129
 * */
package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class VZNFT129StorySavedMethod extends BaseTestClass {

    @Test
    public void testVZNFT129StorySavedMethod() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        photosAndVideosView.openStory10();
        baseControlsHelper.waitForShow(vz_strings.story_HeroImage);
        baseControlsHelper.openContext(vz_strings.context_saveAsAlbum);

        String logs = localyticsHelper.getLogs();
        TestCase.assertEquals("Localytics of " + vz_strings.logs_storySaved + " does not exist", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_storySaved));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_storySaved + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_storySaved));

        TestCase.assertEquals(vz_strings.logs_method + " does not exist", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_method + " = " + "\"" + vz_strings.logs_cloudContextualMenu));

        localyticsHelper.print(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_storySaved);

    }
}