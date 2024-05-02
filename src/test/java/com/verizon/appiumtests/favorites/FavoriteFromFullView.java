//IV-831
package com.verizon.appiumtests.favorites;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.constants.vz_strings.DataType;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;

public class FavoriteFromFullView extends BaseTestClass {
    @Test
    public void testFavoriteFromFullView() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.removeFavoritesAlbum();
        photosAndVideosView.selectTab(vz_strings.tab_all);
        gridView.tapItem(DataType.PHOTO);
      //  baseControlsHelper.waitForShow(vz_strings.actionBar_addToFavorite);
        baseControlsHelper.clickOn(vz_strings.actionBar_addToFavorite);
        Thread.sleep(2000);
        baseControlsHelper.tapOnBackButton();
        photosAndVideosView.selectFavoriteAlbum();
        gridView.tapItem(vz_strings.DataType.PHOTO);
    }
}
