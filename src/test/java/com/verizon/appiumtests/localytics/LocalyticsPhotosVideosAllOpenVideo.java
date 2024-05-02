package com.verizon.appiumtests.localytics;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;


public class LocalyticsPhotosVideosAllOpenVideo extends BaseTestClass {

    @Test
    public void testLocalyticsPhotosVideosAllOpenVideo() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        gridView.tapItem(vz_strings.DataType.VIDEO);
        photosAndVideosView.playVideo();

        String logs = localyticsHelper.getLogs();
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaOpen + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_mediaOpen));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaOpen + " is not 1 in logs", localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaOpen) == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypeVideos)
                || localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypeStory));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_page + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_page + " = " + "\"" + vz_strings.logs_photosVideosAll + "\""));
        localyticsHelper.print(logs, vz_strings.logs_mediaOpen);
    }
}
