//IV-834
package com.verizon.appiumtests.favorites;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.constants.vz_strings.DataType;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class UnFavoriteFromFullView extends BaseTestClass {
    @Test
    public void testUnFavoriteFromFullView() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.AddToFavoriteAlbum();

        photosAndVideosView.selectFavoriteAlbum();
        gridView.tapItem(DataType.PHOTO);
        baseControlsHelper.clickOn(vz_strings.actionBar_RemoveFromFavorite);
        baseControlsHelper.waitForDismiss(vz_strings.toast_removeFromFavorite);
        Thread.sleep(2000);
        if (!photosAndVideosView.isFavoriteAlbumExisted()) {
            TestCase.assertTrue("Fav album has no favorites", true);
        } else {
            TestCase.assertTrue("Fav album has favorites", false);
        }
    }
}