package com.verizon.appiumtests.albums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class AlbumCreateCancel extends BaseTestClass {

	@Test
	public void testAlbumCreateCancel() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_albums);
        int count = gridView.getAlbumContentCount();
        photosAndVideosView.cancelCreateAlbum(vz_strings.create_newAlbumName);
        int count1 = gridView.getAlbumContentCount();

        TestCase.assertEquals("Photo count not increasing", count1, count);
    }
}
