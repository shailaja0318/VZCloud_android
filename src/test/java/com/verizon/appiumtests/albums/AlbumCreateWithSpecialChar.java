package com.verizon.appiumtests.albums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class AlbumCreateWithSpecialChar extends BaseTestClass {

	@Test
	public void testAlbumCreateWithSpecialChar() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_albums);

		for (int i = 0; i < vz_strings.special_char.length; i++) {
			if (baseControlsHelper.getCountById(vz_strings.no_albumTitle) != 0) {
				baseControlsHelper.clickOn(vz_strings.button_newAlbum);
			} else {
				baseControlsHelper.openContext(vz_strings.context_newAlbum);
			}

			baseControlsHelper.setValuetoTextFieldByName(vz_strings.special_char[i], vz_strings.alertTextField);
			baseControlsHelper.waitForShow(vz_strings.button_addItems);
			baseControlsHelper.clickOn(vz_strings.button_addItems);
			Thread.sleep(2000);
			/**
			 * Appium has an issue to read backslash
			 */
			TestCase.assertTrue("Album Name Alert not found at ",
					baseControlsHelper.getTextByNameContains(vz_strings.albumName_req).contains(vz_strings.albumName_req));
			baseControlsHelper.clickOn(vz_strings.button_ok);
		}
	}
}