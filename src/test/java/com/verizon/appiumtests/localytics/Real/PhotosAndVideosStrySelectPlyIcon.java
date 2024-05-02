//https://jira.synchronoss.net:8443/jira/browse/VZNFT-73/step-4

package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;


public class PhotosAndVideosStrySelectPlyIcon extends BaseTestClass {
    @Test
    public void photosAndVideosStrySelectPlayIcon() throws Exception {
        homeScreenView.fromHomeClickAt(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        photosAndVideosView.openStory10();
        baseControlsHelper.waitForShow(vz_strings.story_HeroImage);
        baseControlsHelper.clickOn(vz_strings.button_smartAlbumPlay);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_realtimesLaunched + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_realtimesLaunched)==1);
    }
}
