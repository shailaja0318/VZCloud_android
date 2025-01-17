
package com.verizon.appiumtests.localytics;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MediaGalleryDetailVideo extends BaseTestClass {
	@Test
	public void testMediaGalleryDetailVideo() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_all);
		baseControlsHelper.clickOnElementByXpath(vz_strings.name_video);

		String logs = localyticsHelper.getLogs();
		localyticsHelper.print(logs, vz_strings.logs_galleryDetail);

		TestCase.assertTrue("Localytics of " + vz_strings.logs_galleryDetail + " does not exist",
				localyticsHelper.isExisted(logs, vz_strings.logs_galleryDetail));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_galleryDetail + " is not 1 in logs", 1, localyticsHelper
                .getCountOf(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_galleryDetail));

	}
}
