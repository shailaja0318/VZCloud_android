/**
 * VZNFT - 109 Step 5
 */
package com.verizon.appiumtests.localytics.home;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MediaOpenHomeStory extends BaseTestClass {

    @Test
    public void testMediaOpenHomeStory() throws Exception {
    	homeScreenView.navigateTo(vz_strings.navi_home);
        homeScreenView.clickOnStory(vz_strings.carousel_story);
        gridView.tapItem(vz_strings.DataType.PHOTO);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_mediaOpen);

        TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaOpen + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaOpen));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaTypePhotos + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypePhotos));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_photosVideosStories + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_page + " = \"" + vz_strings.logs_photosVideosStories + "\""));
    }
}