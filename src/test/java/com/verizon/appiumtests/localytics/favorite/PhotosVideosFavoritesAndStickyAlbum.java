//https://jira.synchronoss.net:8443/jira/browse/VZNFT-144
package com.verizon.appiumtests.localytics.favorite;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class PhotosVideosFavoritesAndStickyAlbum extends BaseTestClass {

    @Test
    public void testPhotosVideosFavoritesAndStickyAlbum() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        precondition.removeFavoritesAlbum();
        photosAndVideosView.selectTab(vz_strings.tab_all);
        gridView.tapItemInSelectMode(vz_strings.DataType.PHOTO);
        baseControlsHelper.waitForShow(vz_strings.actionBar_selectView_addToFavorite);
		baseControlsHelper.clickOn(vz_strings.actionBar_selectView_addToFavorite);
        photosAndVideosView.selectFavoriteAlbum();

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_Fav_stickyAlbum);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_Fav_stickyAlbum + " is not 1 in logs", localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_Fav_stickyAlbum) == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaGalleryOpen + " is not 1 in logs", localyticsHelper.isExisted(logs, vz_strings.logs_type + " = " + vz_strings.logs_Favorites));
  
        localyticsHelper.print(logs, vz_strings.logs_pvFavorites);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_pvFavorites + " is not 1 in logs", localyticsHelper.getCountOf(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_pvFavorites) == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaGalleryOpen + " is not 1 in logs", localyticsHelper.isExisted(logs, vz_strings.logs_page + " = " + vz_strings.logs_album));

    }
}
