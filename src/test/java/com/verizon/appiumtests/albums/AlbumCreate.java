package com.verizon.appiumtests.albums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class AlbumCreate extends BaseTestClass {

	@Test
	public void testAlbumCreate() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_albums);
        baseControlsHelper.waitForContent();
        precondition.deleteAllAlbums();
        int count = gridView.getAlbumCount();

        photosAndVideosView.createAlbum(vz_strings.create_newAlbumName);
        baseControlsHelper.waitForContent();
      //  baseControlsHelper.waitForShow("Albums");
        int count1 = gridView.getAlbumCount();

        TestCase.assertEquals("Album count not increasing", count1, count + 1);
    }
}