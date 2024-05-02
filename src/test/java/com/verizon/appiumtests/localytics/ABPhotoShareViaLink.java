package com.verizon.appiumtests.localytics;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * @author leletsn
 *VZNFT-557 #6 Photo Share
 */
public class ABPhotoShareViaLink extends BaseTestClass{
	@Test
	public void testABPhotoShareViaLink() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_all);
		baseControlsHelper.clickOnLabelLike(vz_strings.name_photo);
		baseControlsHelper.clickOn(vz_strings.actionBar_share);
		baseControlsHelper.clickOn(vz_strings.button_yesRemindMeNextTime);
		baseControlsHelper.clickOn(vz_strings.share_ShareViaLink);


		String logs = localyticsHelper.getLogs();
		localyticsHelper.print(logs, vz_strings.LOGS_SHARE_SEND_CONTENT);

		TestCase.assertTrue(vz_strings.LOGS_SHARE_SEND_CONTENT + " is not 1 in logs",
				localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.LOGS_SHARE_SEND_CONTENT) == 1);

		TestCase.assertTrue("Localytics of " + vz_strings.logs_shareContentSize + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_shareContentSize));
		TestCase.assertTrue("Localytics of " + vz_strings.logs_shareContentType + " does not exist", localyticsHelper.getCountOf(logs, "\"" + vz_strings.logs_shareContentType + "\"" + " = " + vz_strings.logs_mediaTypePhotos) == 1);
		TestCase.assertTrue("Localytics of " + vz_strings.logs_shareItemShared + " does not exist", localyticsHelper.getCountOf(logs, "\"" + vz_strings.logs_shareItemShared + "\"" + " = " + "1") == 1);
		TestCase.assertTrue("Localytics of "+vz_strings.logs_source+" does not exits", localyticsHelper.getPatternMatch(logs, vz_strings.logs_source +" = \"" + vz_strings.logs_photoDetail+ "\"")==1);
		TestCase.assertTrue("Localytics of "+vz_strings.logs_target+" does not exits", localyticsHelper.getPatternMatch(logs, vz_strings.logs_target +" = \""+ vz_strings.logs_NotApplicable+"\"")>0);	  



	}
}
