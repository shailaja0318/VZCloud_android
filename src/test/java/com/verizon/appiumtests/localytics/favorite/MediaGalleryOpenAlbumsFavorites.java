/**
 * VZNFT-177 Step 3
 * */
package com.verizon.appiumtests.localytics.favorite;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MediaGalleryOpenAlbumsFavorites extends BaseTestClass{

    @Test
    public void testMediaGalleryOpenAlbumsFavorites() throws Exception {

    	homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.AddToFavoriteAlbum();

        photosAndVideosView.selectFavoriteAlbum();

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_mediaGalleryOpen);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaGalleryOpen) > 0);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_page + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_page + " = " + vz_strings.logs_album) > 0);
    }
}
