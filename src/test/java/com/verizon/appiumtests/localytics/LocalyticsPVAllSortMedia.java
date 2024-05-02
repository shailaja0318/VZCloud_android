/**
 * VZNFT-42 - Step 2
 */
package com.verizon.appiumtests.localytics;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

public class LocalyticsPVAllSortMedia extends BaseTestClass {

  //  @Test
    public void testVZNFT42PVAllSortMedia() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        baseControlsHelper.openContext(vz_strings.context_sort);
        boolean dateTaken = false;
        Thread.sleep(3000);
        if (baseControlsHelper.getCountById(vz_strings.sort_dateUploaded) > 0) {
            baseControlsHelper.setPickerValue(vz_strings.sort_dateTaken);
        } else {
            dateTaken = true;
            baseControlsHelper.setPickerValue(vz_strings.sort_dateUploaded);
        }
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_sortMedia);
        localyticsHelper.print(logs, vz_strings.logs_sortOption);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " does not exist",
                localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + "\"" + vz_strings.logs_mediaTypePhotosAndVideos + "\"") == 1);
        if (!dateTaken) {
            TestCase.assertTrue("Localytics of " + vz_strings.logs_sortOption + " does not exist",
                    localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_sortOption + "\"" + " = " + "\"" + vz_strings.sort_dateTaken + "\"") == 1);
        } else
            TestCase.assertTrue("Localytics of " + vz_strings.logs_sortOption + " does not exist",
                    localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_sortOption + "\"" + " = " + "\"" + vz_strings.sort_dateUploaded + "\"") == 1);
    }
}