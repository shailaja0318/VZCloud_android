package com.verizon.appiumtests.photosandvideos.actionBars;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
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
		baseControlsHelper.clickOnLabelLike(vz_strings.name_video);
		//baseControlsHelper.setOrientation(ScreenOrientation.LANDSCAPE);

		SoftAssert sa = new SoftAssert();
		sa.assertTrue(baseControlsHelper.getCountById(vz_strings.actionBar_share) != 0, "Share Option is not present in Action Bar");
		sa.assertTrue(baseControlsHelper.getCountById(vz_strings.actionBar_Favorite) != 0, "Favorite Option is not present in Action Bar");
		sa.assertTrue(baseControlsHelper.getCountById(vz_strings.actionBar_download) != 0, "Download Option is not present in Action Bar");
		sa.assertTrue(baseControlsHelper.getCountById(vz_strings.actionBar_AddToAlbum) != 0, "Add To Album Option is not present in Action Bar");
		sa.assertTrue(baseControlsHelper.getCountById(vz_strings.actionBar_Delete) != 0, "Delete Option is not present in Action Bar");
		sa.assertAll();
		baseControlsHelper.setOrientation(ScreenOrientation.PORTRAIT);

	}
}
