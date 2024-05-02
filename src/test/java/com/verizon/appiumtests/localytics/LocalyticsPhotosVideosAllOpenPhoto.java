package com.verizon.appiumtests.localytics;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;


//VZNFT-109 #Step 6
public class LocalyticsPhotosVideosAllOpenPhoto extends BaseTestClass {

    @Test
    public void testLocalyticsPhotosVideosAllOpenPhoto() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        gridView.tapItem(vz_strings.DataType.PHOTO);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_mediaOpen);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_tagScreen + " does not exist", localyticsHelper.getPatternMatch(logs,vz_strings.logs_tagScreen + ": " + vz_strings.logs_photosVideosAll) == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaOpen + " does not exist", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaOpen) == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " does not exist", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypePhotos) == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_page + " does not exist", localyticsHelper.getPatternMatch(logs, vz_strings.logs_page + " = " + "\"" + vz_strings.logs_photosVideosAll + "\"") == 1);
    }
}
