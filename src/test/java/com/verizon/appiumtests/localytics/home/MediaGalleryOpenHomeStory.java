/**
 * VZNFT-177 Step 5
 * */
package com.verizon.appiumtests.localytics.home;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MediaGalleryOpenHomeStory extends BaseTestClass{

    @Test
    public void testMediaGalleryOpenHomeStory() throws Exception {

        homeScreenView.clickOnStory(vz_strings.carousel_story);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);

        TestCase.assertEquals("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaGalleryOpen));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_page + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_page + " = " + vz_strings.logs_story));
    }
}
