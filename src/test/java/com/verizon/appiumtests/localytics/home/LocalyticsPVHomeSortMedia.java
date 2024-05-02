/**
 * VZNFT-42 - Step 1
 */
package com.verizon.appiumtests.localytics.home;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsPVHomeSortMedia extends BaseTestClass {

    @Test
    public void testLocalyticsPVHomeSortMedia() throws Exception {

        homeScreenView.fromHomeClickAt(vz_strings.home_photsAndVideos);

        boolean dateTaken = true;
        baseControlsHelper.openContext(vz_strings.context_sort);
        if (baseControlsHelper.getCountById(vz_strings.sort_dateTaken) > 0) {
            baseControlsHelper.setPickerValue(vz_strings.sort_dateUploaded);
        } else {
            dateTaken = false;
            baseControlsHelper.setPickerValue(vz_strings.sort_dateTaken);
        }
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_sortMedia);

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