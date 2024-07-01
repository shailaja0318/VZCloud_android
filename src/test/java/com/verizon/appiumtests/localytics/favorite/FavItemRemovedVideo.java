/**
 * VZNFT-174 - Step 1-2/1
 * TODO Need improvement if more than one item like video and photo there will multiple localytics.
 */
package com.verizon.appiumtests.localytics.favorite;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.constants.vz_strings.DataType;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class FavItemRemovedVideo extends BaseTestClass {
	private int numVideos, numPhotos, numStories, mediaType;
	private boolean mediaTypePhoto, mediaTypeVideo, mediaTypeStories;

	private void AddVideoToFavoriteAlbum() throws Exception {
		System.out.println("--Start Preconditions--");
		photosAndVideosView.selectTab(vz_strings.tab_all);
		gridView.tapItemInSelectMode(DataType.VIDEO);
		baseControlsHelper.waitForShow(vz_strings.actionBar_selectView_addToFavorite);
		baseControlsHelper.clickOn(vz_strings.actionBar_selectView_addToFavorite);
		System.out.println("--End Preconditions--");
	}

	@Test
	public void testFavItemRemovedVideo() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		//photosAndVideosView.selectTab(vz_strings.tab_albums);
		//precondition.removeFavoritesAlbum();
		AddVideoToFavoriteAlbum();
		photosAndVideosView.selectFavoriteAlbum();
		ArrayList<String> items = baseControlsHelper.getAllAlbumElementsInGrid();
		for(String s : items) {
			if(s.contains("Photo")){
				mediaTypePhoto=true;
				numPhotos++;
			}

			else if (s.contains("Video ")){
				mediaTypeVideo=true;
				numVideos++;
			}
			else if(s.contains("Story ")){
				mediaTypeStories=true;
				numStories++;
			}
		}
		photosAndVideosView.selectAllAction(vz_strings.context_removeFavorite);
		String logs = localyticsHelper.getLogs();
		localyticsHelper.print(logs, vz_strings.logs_favItemRemoved);

		if(mediaTypePhoto) {
			TestCase.assertTrue("Localytics of " + vz_strings.logs_count + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_count + " = " + numPhotos));
			TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypePhotos));
			mediaType++;
		}
		if(mediaTypeVideo){
			TestCase.assertTrue("Localytics of " + vz_strings.logs_count + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_count + " = " + numVideos));
			TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypeVideos));
			mediaType++;
		}
		if(mediaTypeStories){
			TestCase.assertTrue("Localytics of " + vz_strings.logs_count + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_count + " = " + numStories));
			TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypeStories));
			mediaType++;
		}

		TestCase.assertTrue("Localytics of " + vz_strings.logs_favItemRemoved + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_favItemRemoved));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_tagEvent + " is not " + mediaType + " in logs", localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_favItemRemoved), mediaType);

	}
}

