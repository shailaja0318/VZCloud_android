/**
 * VZNFT-109 - Step 6
 */
package com.verizon.appiumtests.localytics;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MediaOpenPVAll extends BaseTestClass {

	@Test
	public void testMediaOpenPVAll() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_all);
		gridView.tapItem(vz_strings.DataType.PHOTO);

		String logs = localyticsHelper.getLogs();
		localyticsHelper.print(logs, vz_strings.logs_tagEvent);

        TestCase.assertEquals(vz_strings.logs_mediaOpen + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs,
                vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaOpen));

        TestCase.assertEquals(vz_strings.logs_mediaTypePhoto + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs,
                "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypePhotos));

        TestCase.assertEquals(vz_strings.logs_photosVideosAll + " is not 1 in logs", 1, localyticsHelper
                .getPatternMatch(logs, vz_strings.logs_page + " = \"" + vz_strings.logs_photosVideosAll + "\""));
	}
}
