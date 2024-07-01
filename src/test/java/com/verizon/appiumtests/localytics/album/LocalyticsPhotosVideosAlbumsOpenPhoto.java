package com.verizon.appiumtests.localytics.album;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

import java.util.ArrayList;

//VZNFT-109 #step 8
public class LocalyticsPhotosVideosAlbumsOpenPhoto extends BaseTestClass {

	private void preCondition_Album() throws Exception {

		System.out.println("--Start Preconditions--");
		if (!photosAndVideosView.ifAnyAlbumExists()) {
			photosAndVideosView.createAlbum(vz_strings.create_newAlbumName);
		}
		System.out.println("--End Preconditions--");
	}

	private void preCondition_Photos() throws Exception {

		System.out.println("--Start Preconditions Photos--");
		ArrayList<String> items = baseControlsHelper.getAllAlbumElementsInGrid();
		boolean hasPhoto=false;
		for (String item : items) {
			if(item.contains("Photo")){
				hasPhoto=true;
				break;
			}
		}
		if (baseControlsHelper.getCountById(vz_strings.empty_albumTitle) != 0 || !hasPhoto) {
			System.out.println("-- No photo in album, adding photo --");
			photosAndVideosView.addItemFromAlbum(vz_strings.DataType.PHOTO);
			//Required to trigger correct localytics
			photosAndVideosView.selectTab(vz_strings.tab_all);
			photosAndVideosView.selectTab(vz_strings.tab_albums);
			photosAndVideosView.openAlbum();
		}
		System.out.println("--End Preconditions Photos--");
	}

	@Test
	public void testLocalyticsPhotosVideosAlbumsOpenPhoto() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_albums);
		preCondition_Album();
		photosAndVideosView.openAlbum();
		preCondition_Photos();
		gridView.tapItem(vz_strings.DataType.PHOTO);

		String logs = localyticsHelper.getLogs();
		localyticsHelper.print(logs, vz_strings.logs_mediaOpen);
		//TestCase.assertTrue("Localytics of " + vz_strings.logs_tagScreen + " does not exist", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_photosVideosAlbums) == 1);
        TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaOpen + " does not exist", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaOpen));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaType + " does not exist", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypePhotos));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_page + " does not exist", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_page + " = " + "\"" + vz_strings.logs_photosVideosAlbums + "\""));

	}
}
