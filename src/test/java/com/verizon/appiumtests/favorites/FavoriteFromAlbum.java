package com.verizon.appiumtests.favorites;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.constants.vz_strings.DataType;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;

public class FavoriteFromAlbum extends BaseTestClass {

    private void preCondition_Albums() throws Exception {

        System.out.println("--Start Preconditions--");
        if (!photosAndVideosView.ifAnyAlbumExists()) {
            photosAndVideosView.createAlbum("Temp album");
        }
        System.out.println("--End Preconditions--");
    }
    private void preCondition_Photos() throws Exception {

        System.out.println("--Start Preconditions photos--");
        if (baseControlsHelper.getCountInViewByPredicate(vz_strings.empty_albumTitle) == 0) {
            photosAndVideosView.addItemFromAlbum(DataType.PHOTO);
            photosAndVideosView.openAlbum();
        }
        System.out.println("--End Preconditions--");
    }

    @Test
    public void testFavoriteFromAlbum() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        preCondition_Albums();

        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.removeFavoritesAlbum();

        photosAndVideosView.openAlbum();
        preCondition_Photos();

        gridView.tapItemInSelectMode(DataType.PHOTO);
        baseControlsHelper.openContext(vz_strings.context_addFavorite);
        baseControlsHelper.tapOnBackButton();
        photosAndVideosView.selectTab(vz_strings.tab_all);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        photosAndVideosView.selectFavoriteAlbum();
        gridView.tapItem(vz_strings.DataType.PHOTO);

    }
}