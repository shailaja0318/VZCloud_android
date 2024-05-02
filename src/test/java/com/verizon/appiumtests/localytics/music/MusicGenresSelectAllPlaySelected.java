package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MusicGenresSelectAllPlaySelected extends BaseTestClass {

	@Test
	public void testMusicGenresSelectAllPlaySelected() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_music);
		musicView.selectTab(vz_strings.tab_genres);
		listView.selectFirstItem10();
		listView.selectFirstItemInSelectMode10();
		baseControlsHelper.openContext(vz_strings.context_playSelected);
		// listView.clickOnAllElementsInMusicList(vz_strings.MusicView.Genre);
		// baseControlsHelper.openContext(vz_strings.context_playSelected);
		//baseControlsHelper.waitForShow("pauseButton");

		String logs = localyticsHelper.getLogs();
		localyticsHelper.print(logs, vz_strings.logs_tagScreen);
		localyticsHelper.print(logs, vz_strings.logs_tagEvent);
		TestCase.assertTrue("Localytics of " + vz_strings.logs_tagScreen + " does not exist", localyticsHelper.getCountOf(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_musicGenres)>0);
		TestCase.assertTrue("Localytics of " + vz_strings.logs_tagEvent + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_mediaPlay));
		TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_mediaTypeSong));
	}
}
