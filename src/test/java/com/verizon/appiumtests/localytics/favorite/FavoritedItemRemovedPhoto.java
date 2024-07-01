/**
 * VZNFT-174 - Step 1-2/2
 */
package com.verizon.appiumtests.localytics.favorite;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class FavoritedItemRemovedPhoto extends BaseTestClass {

    @Test
    public void testFavoritedItemRemovedPhoto() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.removeFavoritesAlbum();
        precondition.AddToFavoriteAlbum();
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        photosAndVideosView.selectFavoriteAlbum();
        Thread.sleep(2000);
        photosAndVideosView.selectAllAction(vz_strings.context_removeFavorite);
        baseControlsHelper.waitForDismiss(vz_strings.toast_removeFromFavorite);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_favItemRemoved);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_favItemRemoved + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_favItemRemoved));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_favItemRemoved));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_count + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_count + " = " + "1"));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypePhotos));

    }
}