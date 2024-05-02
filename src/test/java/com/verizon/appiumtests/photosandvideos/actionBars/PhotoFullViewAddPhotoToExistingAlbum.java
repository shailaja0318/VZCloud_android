package com.verizon.appiumtests.photosandvideos.actionBars;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**
 * //IV-2429
 * @author leletsn
 *
 */
public class PhotoFullViewAddPhotoToExistingAlbum extends BaseTestClass {
	@Test
	public void testPhotoFullViewAddPhotoToExistingAlbum() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_albums);
		precondition.deleteAllAlbums();
		precondition.createAlbum();
		Thread.sleep(3000);
		photosAndVideosView.selectTab(vz_strings.tab_all);
		addToAlbumFromFullView();
		baseControlsHelper.tapOnBackButton();
		baseControlsHelper.waitForContent();
		photosAndVideosView.openAlbum();
		baseControlsHelper.waitForContent();

		int count1 = gridView.getAlbumContentCount();

		if (count1 > 0) {
			TestCase.assertTrue("Photo count not increasing ", count1 == 1);
		} else {
			TestCase.assertTrue("Album still empty", count1 != 0);
		}
	}

	public void addToAlbumFromFullView() throws Exception {
		photosAndVideosView.selectTab(vz_strings.tab_all);
		baseControlsHelper.clickOnLabelLike(vz_strings.name_photo);
		baseControlsHelper.clickOn(vz_strings.actionBar_AddToAlbum);
		baseControlsHelper.clickOn(vz_strings.button_addToAlbumPickerOk);
		baseControlsHelper.waitForDismiss(vz_strings.toast_photoAddtoAlbum);
	}

}
