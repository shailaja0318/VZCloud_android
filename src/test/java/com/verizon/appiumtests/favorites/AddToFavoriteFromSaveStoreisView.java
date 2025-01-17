
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
        photosAndVideosView.openStory10();
        baseControlsHelper.openContext(vz_strings.context_select);
        //baseControlsHelper.clickOn(vz_strings.name_photo_index); locator value not working
        baseControlsHelper.openContext(vz_strings.context_addFavorite);
        baseControlsHelper.waitForDismiss(vz_strings.toast_addtoFavorite);
        //photosAndVideosView.addToFavAlbum10(); //refer PhotosAndVideosView
        baseControlsHelper.tapOnBackButton();
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        //go to fav to check if fav is added
        photosAndVideosView.selectFavoriteAlbum();
        baseControlsHelper.waitForContent();
        gridView.tapItem(vz_strings.DataType.PHOTO);
    }
}
