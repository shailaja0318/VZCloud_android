package com.verizon.appiumtests.localytics.livePhotos;
/*
 * Step 4 VZNFT-482
 * bug logged https://jira.synchronoss.net:8443/jira/browse/VPCIOS-2783
*/

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LivePhotosMediaOpenAlbumsFavorites extends BaseTestClass {

    public void preCondition() throws Exception {
        System.out.println("--Start Preconditions--");
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.removeFavoritesAlbum();
        photosAndVideosView.selectTab(vz_strings.tab_all);
        gridView.tapItemInSelectMode(vz_strings.DataType.LIVEPHOTO);
        baseControlsHelper.clickOn(vz_strings.actionBar_selectView_addToFavorite);
        System.out.println("--End Preconditions--");
    }

    @Test
    public void testLivePhotosMediaOpenAlbumsFavorites() throws Exception {

        preCondition();
        photosAndVideosView.selectFavoriteAlbum();
        Thread.sleep(3000);
        gridView.tapItem(vz_strings.DataType.LIVEPHOTO);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaOpen);

        TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaOpen + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaOpen));
        TestCase.assertEquals(vz_strings.logs_mediaType + " does not exist", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + "\"" + vz_strings.logs_mediaTypeLivePhoto + "\""));
        TestCase.assertEquals(vz_strings.logs_page + " does not exist", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_page + " = " + "\"" + vz_strings.logs_photosVideosDetail + "\""));
    }

}

