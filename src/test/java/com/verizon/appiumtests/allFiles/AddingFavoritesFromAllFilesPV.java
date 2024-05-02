//IV-830
package com.verizon.appiumtests.allFiles;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

public class AddingFavoritesFromAllFilesPV extends BaseTestClass {

	private void postCondition() throws Exception {
		System.out.println("--Start Preconditions--");
		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_albums);
		photosAndVideosView.selectFavoriteAlbum();
		System.out.println("--End Preconditions--");
	}

//	@Test
	public void testAddingFavoritesFromAllFilesPV() throws Exception {
		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		precondition.removeFavoritesAlbum();
		homeScreenView.navigateTo(vz_strings.navi_allFiles);
		String[] ext = {".HEIC", ".jpg", ".mov"};

		for (int i = 0; i < ext.length; i++) {
			allFilesView.search(ext[i]);
			if (i == 0) {
				listView.selectFirstItemInSelectMode10();
				baseControlsHelper.openContext(vz_strings.context_addFavorite);
				allFilesView.search("");
				baseControlsHelper.clickOn(vz_strings.clear_text);
				baseControlsHelper.clickOn(vz_strings.button_cancel);
			} else {
				listView.selectFirstItemInSelectMode10();
				baseControlsHelper.openContext(vz_strings.context_addFavorite);
			}
		}

		postCondition();
		int photoCount = baseControlsHelper.getCountByNameLike("Photo");
		int livePhotoCount = baseControlsHelper.getCountByNameLike("Live Photos");
		int savedStoryCount = baseControlsHelper.getCountByNameLike("Saved Story");
		int videoCount = baseControlsHelper.getCountByNameLike("Video");


		TestCase.assertTrue("Favorite Title not found", baseControlsHelper.getCountById(vz_strings.no_favoriteTitle) < 1);
		if (photoCount + livePhotoCount == 1) {
			TestCase.assertTrue("Photo found", true);
		} else if (savedStoryCount + videoCount == 1) {
			TestCase.assertTrue("Video found", true);
		} else {
			TestCase.assertTrue("Photo or Video not found", false);
		}
	}
}
