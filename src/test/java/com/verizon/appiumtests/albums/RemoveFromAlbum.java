package com.verizon.appiumtests.albums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class RemoveFromAlbum extends BaseTestClass {

    @Test
    public void testRemoveFromAlbum() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.createAlbum();
        photosAndVideosView.openAlbum();
        precondition.addPhotoToExistingAlbum();
        baseControlsHelper.waitForContent();
        photosAndVideosView.openAlbum();
        photosAndVideosView.selectAllAction(vz_strings.context_removeFromAlbum);
        baseControlsHelper.waitForContent();
        int count = baseControlsHelper.getCountById(vz_strings.view_emptyAlbum);

        TestCase.assertTrue("Empty text is not found", count > 0);
    }
}