//VZNFT-232
package com.verizon.appiumtests.localytics.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsPhotosVideosStoriesPrintShopIcon extends BaseTestClass {

    @Test
    public void testLocalyticsPhotosVideosStoriesPrintShopIcon() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        photosAndVideosView.accessPrintShopFromIcon();

        String logs = localyticsHelper.getLogs();
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketEntry + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_photoBucketEntry));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_photoBucketEntry + " is not 1 in logs", 1, localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_photoBucketEntry));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketEntryPoint + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_photoBucketEntryPoint + "\" = \"" + vz_strings.logs_photosVideosStories + "\""));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketNumber + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_photoBucketNumber));
        localyticsHelper.print(logs, vz_strings.logs_photoBucketEntry);
    }
}