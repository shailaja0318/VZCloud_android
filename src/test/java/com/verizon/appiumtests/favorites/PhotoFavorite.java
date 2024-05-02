package com.verizon.appiumtests.favorites;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;

public class PhotoFavorite extends BaseTestClass {

    @Test
    public void testFavoritePhoto() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.removeFavoritesAlbum();
        photosAndVideosView.selectTab(vz_strings.tab_all);
        gridView.tapItemInSelectMode(vz_strings.DataType.PHOTO);
        baseControlsHelper.clickOn(vz_strings.actionBar_selectView_addToFavorite);
        baseControlsHelper.waitForDismiss(vz_strings.toast_addtoFavorite);
        photosAndVideosView.selectFavoriteAlbum();
        gridView.tapItem(vz_strings.DataType.PHOTO);

    }
}