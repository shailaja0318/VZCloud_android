/**
 * VZNFT - 109 Step 8
 */
package com.verizon.appiumtests.localytics;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MediaOpenPVAlbum extends BaseTestClass {

	@Test
	public void testMediaOpenPVAlbum() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);

		photosAndVideosView.selectTab(vz_strings.tab_albums);
		precondition.createAlbum();
		photosAndVideosView.openAlbum();
		gridView.tapItem(vz_strings.DataType.PHOTO);

		String logs = localyticsHelper.getLogs();
		localyticsHelper.print(logs, vz_strings.logs_tagEvent);

		TestCase.assertTrue(vz_strings.logs_mediaOpen + " is not 1 in logs",
				localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaOpen) == 1);

		TestCase.assertTrue(vz_strings.logs_mediaTypePhoto + " is not 1 in logs",
				localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypePhotos) == 1);

		TestCase.assertTrue(vz_strings.logs_photosVideosAll + " is not 1 in logs",
				localyticsHelper.getPatternMatch(logs, vz_strings.logs_page + " = \"" + vz_strings.logs_photosVideosAlbums + "\"") == 1);
	}
}
