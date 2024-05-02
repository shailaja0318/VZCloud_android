//IV-332
package com.verizon.appiumtests.albums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;


public class AddPhotoVideoToNewAlbum extends BaseTestClass {

    @Test
    public void testAddPhotoVideoToNewAlbum() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.deleteAllAlbums();
        baseControlsHelper.waitForShow(vz_strings.button_newAlbum);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        gridView.tapItemsInSelectMode();
        baseControlsHelper.clickOn(vz_strings.actionBar_selectView_AddToAlbum);
        photosAndVideosView.createAlbumFromAllView(vz_strings.create_newAlbumName);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        baseControlsHelper.waitForContent();
        photosAndVideosView.openAlbum();

        int count1 = gridView.getAlbumContentCount();
        TestCase.assertTrue("PV count not increasing, before count: " + 2 + ", after count:" + count1, count1 == 2);
    }
}