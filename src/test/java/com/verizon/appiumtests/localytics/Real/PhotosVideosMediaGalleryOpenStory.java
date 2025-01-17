//https://jira.synchronoss.net:8443/jira/browse/VZNFT-177
package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class PhotosVideosMediaGalleryOpenStory extends BaseTestClass {

    @Test
    public void testPhotosVideosMediaGalleryOpenStory() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        photosAndVideosView.openStory10();

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_mediaGalleryOpen);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaGalleryOpen + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_mediaGalleryOpen));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaGalleryOpen));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaTypeStory + " is not 1 in logs", localyticsHelper.isExisted(logs, vz_strings.logs_page + " = " + vz_strings.logs_mediaTypeStory));

    }
}
