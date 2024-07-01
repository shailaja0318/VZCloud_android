package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by anlin.tang on 02/02/16.
 */
public class LocalyticsPhotosVideosStories extends BaseTestClass {

    @Test
    public void testLocalyticsPhotosVideosStories() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);

        String logs = localyticsHelper.getLogs();
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photosVideosStories + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_photosVideosStories));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_photosVideosStories + " is not 1 in logs", 1, localyticsHelper.getCountOf(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_photosVideosStories));
        localyticsHelper.print(logs, vz_strings.logs_photosVideosStories);
    }
}
