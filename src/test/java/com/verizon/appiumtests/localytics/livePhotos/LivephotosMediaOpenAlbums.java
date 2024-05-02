package com.verizon.appiumtests.localytics.livePhotos;
/*
 * Step 3 VZNFT-482
*/

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LivephotosMediaOpenAlbums extends BaseTestClass {

    @Test
    public void testLivephotosMediaOpenAlbums() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.deleteAllAlbums();
        System.out.println("--Create Live Photo Album--");
        baseControlsHelper.waitForShow(vz_strings.tab_all);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        photosAndVideosView.createAlbumByDataType(vz_strings.DataType.LIVEPHOTO, "AppiumLivePhotoAlbum");
        baseControlsHelper.waitForShow(vz_strings.tab_albums);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        photosAndVideosView.openAlbum();
        gridView.tapItem(vz_strings.DataType.LIVEPHOTO);

        String logs = localyticsHelper.getLogs();
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaOpen + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_mediaOpen));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaOpen + " is not 1 in logs", localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaOpen) == 1);
        TestCase.assertTrue(vz_strings.logs_mediaType + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + "\"" + vz_strings.logs_mediaTypeLivePhoto + "\""));
        TestCase.assertTrue(vz_strings.logs_page + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_page + " = " + "\"" + vz_strings.logs_photosVideosAlbums + "\""));
        localyticsHelper.print(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaOpen);
    }

}
