package com.verizon.appiumtests.albums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class AlbumViewEmptyAlbumContextMenu extends BaseTestClass {

    @Test
    public void testAlbumViewEmptyAlbumContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.createAlbum();
        photosAndVideosView.openAlbum();
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Delete Album not found", baseControlsHelper.getCountById(vz_strings.context_deleteAlbum) != 0);
    }
}
