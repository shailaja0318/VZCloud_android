package com.verizon.appiumtests.photosandvideos.actionBars;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * IV-287
 * @author leletsn
 *
 */
public class VideoFullViewInLandscapeMode extends BaseTestClass {
	@Test
	public void testVideoFullViewInLandscapeMode() throws Exception {
		baseControlsHelper.setOrientation(ScreenOrientation.LANDSCAPE);
		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_all);
		baseControlsHelper.clickOnElementByXpath(vz_strings.name_video);
		//baseControlsHelper.setOrientation(ScreenOrientation.LANDSCAPE);
		TestCase.assertTrue("Options missing ", baseControlsHelper.isVisible(vz_strings.actionBar_share));
		TestCase.assertTrue("Options missing ", baseControlsHelper.isVisible(vz_strings.actionBar_addToFavorite));
		TestCase.assertTrue("Options missing ", baseControlsHelper.isVisible(vz_strings.actionBar_download));
		TestCase.assertTrue("Options missing ", baseControlsHelper.isVisible(vz_strings.actionBar_Delete));


		baseControlsHelper.setOrientation(ScreenOrientation.PORTRAIT);




	}
}
