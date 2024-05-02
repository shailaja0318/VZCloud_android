//https://jira.synchronoss.net:8443/jira/browse/VZNFT-73/step-3

package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Updated by leletsn.
 */
public class PhotosAndVideosStrySltAllCrtStry extends BaseTestClass {
    @Test
    public void PhotosAndVideosStySelectAllCrtStry() throws Exception {
        homeScreenView.fromHomeClickAt(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        photosAndVideosView.openStory10();
        baseControlsHelper.waitForShow(vz_strings.story_HeroImage);
        gridView.longPressAndDrag();
        baseControlsHelper.openContext(vz_strings.context_createStory);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_realtimesLaunched + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_realtimesLaunched) == 1);
    }
}
