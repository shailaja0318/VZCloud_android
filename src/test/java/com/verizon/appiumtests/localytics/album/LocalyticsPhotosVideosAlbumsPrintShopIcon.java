package com.verizon.appiumtests.localytics.album;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsPhotosVideosAlbumsPrintShopIcon extends BaseTestClass {

    @Test
    public void testLocalyticsPhotosVideosAlbumsPrintShopIcon() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        baseControlsHelper.openContext(vz_strings.context_printShop);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_photoBucketEntry);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketEntry + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_photoBucketEntry));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_photoBucketEntry + " is not 1 in logs", 1, localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_photoBucketEntry));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketEntryPoint + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_photoBucketEntryPoint + "\" = \"" + vz_strings.logs_photosVideosAlbums + "\""));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketNumber + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_photoBucketNumber));

    }
}
