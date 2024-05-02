//IV-316
package com.verizon.appiumtests.favorites;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class PhotosVideosFavoriteContextMenu extends BaseTestClass {
    @Test
    public void testPhotosVideosFavoriteContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.AddToFavoriteAlbum();
        photosAndVideosView.selectFavoriteAlbum();
        baseControlsHelper.waitForContent();
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Options missing ", contextualMenu.verifyOptions(null, vz_strings.view_insideFavorite, true));
    }
}