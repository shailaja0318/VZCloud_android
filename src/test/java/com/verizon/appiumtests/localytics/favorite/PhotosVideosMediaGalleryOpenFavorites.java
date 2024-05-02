//https://jira.synchronoss.net:8443/jira/browse/VZNFT-177
package com.verizon.appiumtests.localytics.favorite;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class PhotosVideosMediaGalleryOpenFavorites extends BaseTestClass {

    @Test
    public void testPhotosVideosMediaGalleryOpenFavorites() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
       // precondition.removeFavoritesAlbum();
        photosAndVideosView.selectTab(vz_strings.tab_all);
        gridView.tapItemInSelectMode(vz_strings.DataType.PHOTO);
        baseControlsHelper.openContext(vz_strings.actionBar_selectView_addToFavorite);
       //baseControlsHelper.waitForDismiss(vz_strings.toast_addtoFavorite);
        photosAndVideosView.selectFavoriteAlbum();

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_mediaGalleryOpen);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaGalleryOpen + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_mediaGalleryOpen));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaGalleryOpen + " is not 1 in logs", localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaGalleryOpen) == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaGalleryOpen + " is not 1 in logs", localyticsHelper.isExisted(logs, vz_strings.logs_page + " = " + vz_strings.logs_album));

    }
}