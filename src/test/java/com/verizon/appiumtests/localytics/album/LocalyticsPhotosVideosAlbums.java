package com.verizon.appiumtests.localytics.album;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsPhotosVideosAlbums extends BaseTestClass {

    @Test
    public void testLocalyticsPhotosVideosAlbums() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);

        String logs = localyticsHelper.getLogs();
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photosVideosAlbums + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_photosVideosAlbums));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_photosVideosAlbums + " is not 1 in logs", 1, localyticsHelper.getCountOf(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_photosVideosAlbums));
        localyticsHelper.print(logs, vz_strings.logs_photosVideosAlbums);
    }
}
