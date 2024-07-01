//https://jira.synchronoss.net:8443/jira/browse/VZNFT-72/step-12
package com.verizon.appiumtests.localytics.album;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class AlbumSelectAllDownload extends BaseTestClass {
	@Test
	public void albumSelectAllDownload() throws Exception {
		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_albums);
		precondition.deleteAllAlbums();
		precondition.createAlbum();
		gridView.selectAllAlbums();
		photosAndVideosView.clickOnShareAndCopyShare(vz_strings.context_download);
		photosAndVideosView.cancelDownload();

		String logs = localyticsHelper.getLogs();
		localyticsHelper.print(logs, vz_strings.logs_tagEvent);
        TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaDownload + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaDownload));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaType + " Media type is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\" = " + vz_strings.logs_album));
	}
}
