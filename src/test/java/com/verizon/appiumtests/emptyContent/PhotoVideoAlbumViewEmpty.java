package com.verizon.appiumtests.emptyContent;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class PhotoVideoAlbumViewEmpty extends BaseTestClass {

    private void preCondition_Albums() throws Exception {
        System.out.println("--Start Preconditions--");
        if (!photosAndVideosView.ifAnyAlbumExists()) {
            photosAndVideosView.createAlbum("Temp album");
        }
        System.out.println("--End Preconditions--");
    }

    private void preCondition_Photos() throws Exception {
        System.out.println("--Start Preconditions--");
        if (baseControlsHelper.getCountById(vz_strings.empty_albumTitle) < 1) {
            photosAndVideosView.selectAllAction(vz_strings.context_removeFromAlbum);
            baseControlsHelper.tapOnBackButton();
            photosAndVideosView.openAlbum();
        }
        System.out.println("--End Preconditions--");
    }

    @Test
    public void testPhotoVideoAlbumViewEmpty() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        preCondition_Albums();
        baseControlsHelper.waitForShow(vz_strings.tab_albums);
        photosAndVideosView.openAlbum();
        preCondition_Photos();

        TestCase.assertTrue("Title not found", baseControlsHelper.getCountById(vz_strings.empty_albumTitle) != 0);
      //  TestCase.assertTrue("Image not found", baseControlsHelper.getCountByName("photo_albums_empty_screen_icon.png") != 0);
        //no id available
        TestCase.assertTrue("Text not found", baseControlsHelper.getCountByNameContains("The album is empty - Tap Photos & Videos below to select content to add to this album.") != 0);
        TestCase.assertTrue("Button not found", baseControlsHelper.getCountById(vz_strings.button_addPhotosAndVideos) != 0);

        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Delete option not found", baseControlsHelper.getCountById(vz_strings.context_deleteAlbum) != 0);
    }
}