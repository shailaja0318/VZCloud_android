package com.verizon.appiumtests.publicshare;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class Videos_shareViaLink extends BaseTestClass {

	@Test
	public void testVideos_shareViaLink() throws Exception {


		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_all);
		baseControlsHelper.clickOnLabelLike("Video");
		baseControlsHelper.clickOn(vz_strings.actionBar_share);

		TestCase.assertTrue("OK to Share Location? , not present", baseControlsHelper.getCountById(vz_strings.text_OkToShareLocation) != 0);
		TestCase.assertTrue("Some of these photos... , not present", baseControlsHelper.getCountByNameContains(vz_strings.text_SomeOfThesePhotos) != 0);
		TestCase.assertTrue("Yes, Don't Remind Me Again", baseControlsHelper.getCountById(vz_strings.button_shareAndDontWarnMeAgain) != 0);
		TestCase.assertTrue("Yes, Remind Me Next Time", baseControlsHelper.getCountById(vz_strings.button_yesRemindMeNextTime) != 0);
		TestCase.assertTrue("No, Cancel My Share", baseControlsHelper.getCountById(vz_strings.button_noCancelMyShare) != 0);

		baseControlsHelper.clickOn(vz_strings.button_yesRemindMeNextTime);

		TestCase.assertTrue("Share to option is not present ", baseControlsHelper.getCountById(vz_strings.share_ShareTo) != 0);
		TestCase.assertTrue("Share Via Link option is not present", baseControlsHelper.getCountById(vz_strings.share_ShareViaLink) != 0);

		baseControlsHelper.clickOn(vz_strings.share_ShareViaLink);
		Thread.sleep(2000);
		TestCase.assertTrue("Share Via Link activity list not present", baseControlsHelper.getCountById(vz_strings.share_ShareViaLinkActivityList) != 0);


	}
}