package com.verizon.appiumtests.localytics;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**
 * @author leletsn
 *VZNFT-557 #5 UnFavorite Photo
 */
public class ABPhotoUnFavorite extends BaseTestClass{
	@Test
	public void testABPhotoUnFavorite() throws Exception {
		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_albums);
		precondition.removeFavoritesAlbum();
		precondition.AddToFavoriteAlbum();
		Thread.sleep(2000);
		photosAndVideosView.selectTab(vz_strings.tab_all);
		baseControlsHelper.clickOnLabelLike(vz_strings.name_photo);
		baseControlsHelper.clickOn(vz_strings.actionBar_RemoveFromFavorite);

		String logs = localyticsHelper.getLogs();
		localyticsHelper.print(logs, vz_strings.logs_favoriteItemRemoved );
		TestCase.assertTrue("Localytics of "+vz_strings.logs_tagEvent+" is not 1 in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent +": "+ vz_strings.logs_favoriteItemRemoved )>0);
		TestCase.assertTrue("Localytics of " + vz_strings.logs_count + "  is not in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_count + " = 1")>0);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_mediaType + "\" = " + vz_strings.logs_mediaTypePhotos));
		TestCase.assertTrue("Localytics of "+vz_strings.logs_source+" does not exits", localyticsHelper.getPatternMatch(logs, vz_strings.logs_source +" = \"" + vz_strings.logs_photoDetail+ "\"")>0);
		TestCase.assertTrue("Localytics of "+vz_strings.logs_target+" does not exits", localyticsHelper.getPatternMatch(logs, vz_strings.logs_target +" = \""+ vz_strings.logs_NotApplicable+"\"")>0);	  


	}
}
