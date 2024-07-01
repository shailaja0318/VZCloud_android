//https://jira.synchronoss.net:8443/jira/browse/VZNFT-335 - Step-3
package com.verizon.appiumtests.localytics.livePhotos;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**
 * @author leletsn
 *
 */
public class LocalyticsLivePhotosMediaPlayFavorites extends BaseTestClass {

	@Test
	public void testLocalyticsLivePhotosMediaPlayFavorites() throws Exception {
		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_albums);
		precondition.removeFavoritesAlbum();
		photosAndVideosView.selectTab(vz_strings.tab_all);
		photosAndVideosView.addLivePhotoToFavoritesAndPlay();
		String logs = localyticsHelper.getLogs();
		localyticsHelper.print(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaPlay);
        TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaPlay + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaPlay));
		TestCase.assertTrue(vz_strings.logs_mediaType + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + "\"" + vz_strings.logs_mediaTypeLivePhoto + "\""));

	}
}
