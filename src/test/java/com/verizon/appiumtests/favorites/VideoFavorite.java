package com.verizon.appiumtests.favorites;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.constants.vz_strings.DataType;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;

public class VideoFavorite extends BaseTestClass {
    @Test
    public void testVideoFavorite() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.removeFavoritesAlbum();

        photosAndVideosView.selectTab(vz_strings.tab_all);
        gridView.tapItemInSelectMode(DataType.VIDEO);
        baseControlsHelper.waitForShow(vz_strings.actionBar_selectView_addToFavorite);
		baseControlsHelper.clickOn(vz_strings.actionBar_selectView_addToFavorite);
        photosAndVideosView.selectFavoriteAlbum();
        gridView.tapItem(DataType.VIDEO);
    }
}