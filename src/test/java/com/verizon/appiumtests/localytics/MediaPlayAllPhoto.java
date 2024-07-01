/**
 * VZNFT-111 Step 1
 */
package com.verizon.appiumtests.localytics;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MediaPlayAllPhoto extends BaseTestClass{

    @Test
    public void testMediaPlayAllPhoto() throws Exception {

    	 homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
         photosAndVideosView.selectTab(vz_strings.tab_all);
         baseControlsHelper.clickOnLabelLike(vz_strings.name_photo);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);

        TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaOpen + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaOpen));

        TestCase.assertEquals(vz_strings.logs_mediaType + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\" = " + vz_strings.logs_mediaTypePhotos));
        System.out.println(vz_strings.logs_page + "\" = \"" + vz_strings.logs_photosVideosAll + "\"");
        TestCase.assertEquals(vz_strings.logs_page + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_page + " = \"" + vz_strings.logs_photosVideosAll + "\""));
    }
}
