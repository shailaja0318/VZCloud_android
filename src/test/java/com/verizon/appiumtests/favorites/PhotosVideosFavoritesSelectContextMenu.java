//IV-317
package com.verizon.appiumtests.favorites;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.constants.vz_strings.DataType;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class PhotosVideosFavoritesSelectContextMenu extends BaseTestClass {

	@Test
	public void testPhotosVideosFavoriteSelectContextMenu() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_albums);
		precondition.removeFavoritesAlbum();
		precondition.AddToFavoriteAlbum();
		photosAndVideosView.selectFavoriteAlbum();
		baseControlsHelper.waitForContent();
		gridView.tapItemInSelectMode(DataType.PHOTO);
		baseControlsHelper.openContext(null);

		TestCase.assertTrue("Options missing ", contextualMenu.verifyOptions(vz_strings.DataType.PHOTO, vz_strings.view_insideFavorite, true));
	}
}