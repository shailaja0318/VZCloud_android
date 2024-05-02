package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.constants.vz_strings.DataType;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**
 * @author leletsn
 *VZNFT-558 #4 UnFavorite Photo
 */
public class ABSavedStoryUnFavorite extends BaseTestClass{
	@Test
	public void testABSavedStoryUnFavorite() throws Exception {
		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_albums);
		precondition.removeFavoritesAlbum();
		AddStoryToFavoriteAlbum();
		photosAndVideosView.selectTab(vz_strings.tab_all);
		baseControlsHelper.clickOnNameLike(vz_strings.name_savedStory);
		baseControlsHelper.clickOn(vz_strings.actionBar_RemoveFromFavorite);

		String logs = localyticsHelper.getLogs();
		localyticsHelper.print(logs, vz_strings.logs_favoriteItemRemoved );
		TestCase.assertTrue("Localytics of "+vz_strings.logs_tagEvent+" is not 1 in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent +": "+ vz_strings.logs_favoriteItemRemoved )>0);
		TestCase.assertTrue("Localytics of " + vz_strings.logs_count + "  is not in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_count + " = 1")>0);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_mediaType + "\" = " + vz_strings.logs_mediaTypeStory));
		TestCase.assertTrue("Localytics of "+vz_strings.logs_source+" does not exits", localyticsHelper.getPatternMatch(logs, vz_strings.logs_source +" = \"" + vz_strings.logs_storyDetail+ "\"")>0);
		TestCase.assertTrue("Localytics of "+vz_strings.logs_target+" does not exits", localyticsHelper.getPatternMatch(logs, vz_strings.logs_target +" = \""+ vz_strings.logs_NotApplicable+"\"")>0);	  


	}
	
	private void AddStoryToFavoriteAlbum() throws Exception {
		System.out.println("--Start Preconditions--");
		photosAndVideosView.selectFavoriteAlbum();
		if (!photosAndVideosView.isFavoriteAlbumExisted()) {
			baseControlsHelper.tapOnBackButton();
			photosAndVideosView.selectTab(vz_strings.tab_all);
			gridView.tapItemInSelectMode(DataType.STORY);
			baseControlsHelper.openContext(vz_strings.context_addFavorite);
		}else{
			baseControlsHelper.tapOnBackButton();
		}
		System.out.println("--End Preconditions--");
	}

}
