//IV-335
package com.verizon.appiumtests.albums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class AddPVFromExistingAlbumToNewAlbum extends BaseTestClass {

    @Test
    public void testAddPVFromExistingAlbumToNewAlbum() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.deleteAllAlbums();
        baseControlsHelper.waitForContent();
        preconditionCreateAlbums();
        baseControlsHelper.waitForContent();
        photosAndVideosView.openAlbum();
        baseControlsHelper.waitForContent();
        addToAlbum();

        TestCase.assertTrue("Appium Album To , doesnt Exist ?", baseControlsHelper.getCountById("Photo/Video 1") > 0);
    }

    private void preconditionCreateAlbums() throws Exception {
        System.out.println("--Start Preconditions--");
        if (!photosAndVideosView.ifAnyAlbumExists()) {
            photosAndVideosView.createAlbumWithMultipleItems("Appium Album From");
        }
        System.out.println("--End Preconditions--");
    }

    private void addToAlbum() throws Exception {
        gridView.tapItemInSelectMode(vz_strings.DataType.PHOTO);
        baseControlsHelper.openContext(vz_strings.context_addToAlbum);
        baseControlsHelper.clickOn(vz_strings.button_pickerNew);
        baseControlsHelper.setValuetoTextFieldByName("Appium Album To", vz_strings.alertTextField);
        baseControlsHelper.clickOn(vz_strings.button_save);
        baseControlsHelper.waitForShow(vz_strings.context_menu);
        baseControlsHelper.tapOnBackButton();
    }
}
