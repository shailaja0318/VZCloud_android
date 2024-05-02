package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * @author leletsn
 *VZNFT-559 #5 SavedStory Share
 */
public class ABSavedStoryShare extends BaseTestClass{
	@Test
	public void testABSavedStoryShare() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_all);
		baseControlsHelper.clickOnNameLike(vz_strings.name_savedStory);
		baseControlsHelper.clickOn(vz_strings.actionBar_share);
		baseControlsHelper.clickOn(vz_strings.button_yesRemindMeNextTime);
		baseControlsHelper.waitForDismiss(vz_strings.toast_creatingSocialShareLink);

		String logs = localyticsHelper.getLogs();
		localyticsHelper.print(logs, vz_strings.LOGS_SHARE_SEND_CONTENT);

		TestCase.assertTrue(vz_strings.LOGS_SHARE_SEND_CONTENT + " is not 1 in logs",
				localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.LOGS_SHARE_SEND_CONTENT) == 1);

		TestCase.assertTrue(vz_strings.logs_shareContentSize + " does not exist",
				localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_shareContentSize + "\"") == 1);
		TestCase.assertTrue("Localytics of "+vz_strings.logs_source+" does not exits", localyticsHelper.getPatternMatch(logs, vz_strings.logs_source +" = \"" + vz_strings.logs_storyDetail+ "\"")==1);
		TestCase.assertTrue("Localytics of "+vz_strings.logs_target+" does not exits", localyticsHelper.getPatternMatch(logs, vz_strings.logs_target +" = \""+ vz_strings.logs_NotApplicable+"\"")>0);	  

	}
}
