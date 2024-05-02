package com.verizon.appiumtests.emptyContent;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class PhotoVideoFavoriteEmpty extends BaseTestClass {

    @Test
    public void testPhotoVideoFavoriteEmpty() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.removeFavoritesAlbum();
        photosAndVideosView.selectFavoriteAlbum();
  
        TestCase.assertTrue("Title not found", baseControlsHelper.getCountById(vz_strings.no_favoriteTitle) != 0);
      //  TestCase.assertTrue("Image not found", baseControlsHelper.getCountById("ic_empty_favorite.png") != 0); // image locator value is not available
        TestCase.assertTrue("Text not found", baseControlsHelper.getCountById("You have not favorited any photos or videos yet.") != 0);
    }
}