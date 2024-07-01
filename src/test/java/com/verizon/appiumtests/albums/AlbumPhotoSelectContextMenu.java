package com.verizon.appiumtests.albums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.constants.vz_strings.DataType;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class AlbumPhotoSelectContextMenu extends BaseTestClass {

	@Test
	public void testAlbumPhotoSelectContextMenu() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_albums);
		precondition.createAlbum();
		photosAndVideosView.openAlbum();
       // gridView.tapItemInSelectMode(DataType.PHOTO);
		baseControlsHelper.openContext(null);

		TestCase.assertTrue("Options missing ",
				contextualMenu.verifyOptions(null, vz_strings.view_insideAlbum, true));
	}
}