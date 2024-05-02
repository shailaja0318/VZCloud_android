package com.verizon.appiumtests.emptyContent;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class PhotoVideoAlbumsEmpty extends BaseTestClass {

	@Test
	public void testPhotoVideoAlbumsEmpty() throws Exception {
		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_albums);
		precondition.deleteAllAlbums();
		baseControlsHelper.waitForShow(vz_strings.tab_all);
		photosAndVideosView.selectTab(vz_strings.tab_all);
		photosAndVideosView.selectTab(vz_strings.tab_albums);

		TestCase.assertTrue("Button not found", baseControlsHelper.getCountById("New Album") != 0);
	}
}
