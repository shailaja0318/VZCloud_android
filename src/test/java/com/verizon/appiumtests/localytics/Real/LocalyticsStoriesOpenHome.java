//VZNFT-109 #Step 5
package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;


public class LocalyticsStoriesOpenHome extends BaseTestClass {

    @Test
    public void testLocalyticsStoriesOpenHome() throws  Exception{
        homeScreenView.navigateTo(vz_strings.navi_home);
        homeScreenView.clickOnStory(vz_strings.carousel_story);
        Thread.sleep(5000);
        baseControlsHelper.clickOnNameLike(vz_strings.name_photo);
        
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_mediaOpen);

        TestCase.assertEquals("Localytics of " + vz_strings.logs_storyDetail + " is not in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_storyDetail));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaOpen+ " is not in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaOpen)>0);
        TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaType + " is not in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypePhoto));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_page + " is not in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_page + " = " + "\"" + vz_strings.logs_photosVideosStories + "\""));
        homeScreenView.backToHome();
    }
}
