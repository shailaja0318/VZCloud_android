package com.verizon.appiumtests.localytics.livePhotos;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.constants.vz_strings.DataType;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**
 * @author leletsn
 *VZNFT-560 #5 UnFavorite live Photo
 */
public class ABLivePhotoUnFavorite extends BaseTestClass{
	@Test
	public void testABLivePhotoUnFavorite() throws Exception {
		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_albums);
		precondition.removeFavoritesAlbum();
		AddLivePhotoToFavoriteAlbum();
		photosAndVideosView.selectTab(vz_strings.tab_all);
		baseControlsHelper.clickOnLabelLike(vz_strings.name_livePhoto);
		baseControlsHelper.clickOn(vz_strings.actionBar_RemoveFromFavorite);

		String logs = localyticsHelper.getLogs();
		localyticsHelper.print(logs, vz_strings.logs_favoriteItemRemoved );
		TestCase.assertTrue("Localytics of "+vz_strings.logs_tagEvent+" is not 1 in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent +": "+ vz_strings.logs_favoriteItemRemoved )>0);
        TestCase.assertEquals("Localytics of " + vz_strings.logs_source + " does not exits", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_source + " = \"" + vz_strings.logs_photoDetail + "\""));
		TestCase.assertTrue("Localytics of "+vz_strings.logs_target+" does not exits", localyticsHelper.getPatternMatch(logs, vz_strings.logs_target +" = \""+ vz_strings.logs_NotApplicable+"\"")>0);	  


	}
	
	private void AddLivePhotoToFavoriteAlbum() throws Exception {
		System.out.println("--Start Preconditions--");
		photosAndVideosView.selectFavoriteAlbum();
		if (!photosAndVideosView.isFavoriteAlbumExisted()) {
			baseControlsHelper.tapOnBackButton();
			photosAndVideosView.selectTab(vz_strings.tab_all);
			gridView.tapItemInSelectMode(DataType.LIVEPHOTO);
			baseControlsHelper.clickOn(vz_strings.actionBar_addToFavorite);
		}else{
			baseControlsHelper.tapOnBackButton();
		}
		System.out.println("--End Preconditions--");
	}

}

