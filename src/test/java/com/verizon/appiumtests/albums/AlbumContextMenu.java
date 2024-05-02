//IV-316
package com.verizon.appiumtests.albums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class AlbumContextMenu extends BaseTestClass {

    @Test
    public void testAlbumContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        baseControlsHelper.waitForContent();
        precondition.createAlbum();
        baseControlsHelper.waitForContent();
        photosAndVideosView.openAlbum();
        precondition.addPhotoToExistingAlbum();
        photosAndVideosView.openAlbum();
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Options missing ", contextualMenu.verifyOptions(null, vz_strings.view_insideAlbum, false));
    }
}