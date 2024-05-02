package com.verizon.appiumtests.albums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

import java.util.List;
/**
 * /IV-5191
 * @author slel0001
 *
 */
public class AlbumSortOptions extends BaseTestClass {

	@Test
	public void testAlbumSortOption() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_albums);
		precondition.createAlbum();
		List<String> actual = photosAndVideosView.getAlbumSortOptions();
		System.out.println(actual);
		List<String> current = documentsView.getTypePickerTextList();
		System.out.println(current);
		
		TestCase.assertTrue("Missing Options: ", documentsView.compareCollection(actual, current));
    }
}
