
package com.verizon.appiumtests.favorites;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;

public class AddToFavoriteFromSaveStoreisView extends BaseTestClass {
    @Test
    public void testAddToFavoriteFromSaveStoreisView() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.removeFavoritesAlbum();
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        photosAndVideosView.addToFavAlbum10(); //refer PhotosAndVideosView
        baseControlsHelper.tapOnBackButton();
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        //go to fav to check if fav is added
        photosAndVideosView.selectFavoriteAlbum();
        baseControlsHelper.waitForContent();
        gridView.tapItem(vz_strings.DataType.PHOTO);
    }
}
