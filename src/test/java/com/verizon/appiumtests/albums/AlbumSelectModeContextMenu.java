//IV-315
package com.verizon.appiumtests.albums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class AlbumSelectModeContextMenu extends BaseTestClass {

    @Test
    public void testAlbumSelectModeContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.createAlbum();
        gridView.tapFolderInSelectMode10("Photos albums folder");
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Options missing ",
                contextualMenu.verifyOptions(vz_strings.DataType.PHOTO, vz_strings.view_photoAlbum, true));
    }
}