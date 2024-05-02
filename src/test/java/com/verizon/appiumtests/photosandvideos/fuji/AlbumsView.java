//https://jira.synchronoss.net:8443/jira/browse/IV-2451
package com.verizon.appiumtests.photosandvideos.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;

public class AlbumsView extends BaseTestClass {

    @Test
    public void testAlbumsView() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        preCondition();
        gridView.tapFolderInSelectMode10("Photos albums folder");
        photosAndVideosView.clickPrintsAndGift(vz_strings.context_printAndGifts, vz_strings.context_icon_printShop);
        baseControlsHelper.waitForDismiss(vz_strings.spinner);
        baseControlsHelper.clickOn(vz_strings.button_exit);
        baseControlsHelper.clickOn(vz_strings.button_yes);
        baseControlsHelper.waitForShow(vz_strings.tab_albums);
    }

    private void preCondition() throws Exception {
        System.out.println("--Start Preconditions--");
        if (!photosAndVideosView.ifAnyAlbumExists()) {
            photosAndVideosView.createAlbum(vz_strings.create_newAlbumName);
        }
        System.out.println("--End Preconditions--");
    }
}
