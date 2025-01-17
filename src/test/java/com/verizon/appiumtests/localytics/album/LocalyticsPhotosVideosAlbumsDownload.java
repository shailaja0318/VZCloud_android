package com.verizon.appiumtests.localytics.album;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LocalyticsPhotosVideosAlbumsDownload extends BaseTestClass {
    private final SoftAssert softAssert = new SoftAssert();

    @Test
    public void testLocalyticsPhotosVideosAlbumsDownload() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition();
        baseControlsHelper.openContext(vz_strings.context_select);
        //gridView.tapFolderInSelectMode10(vz_strings.album_photo_select);
        baseControlsHelper.openContext(vz_strings.context_download);
        //photosAndVideosView.cancelDownload();

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_mediaDownload);

        softAssert.assertEquals(localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaDownloadComplete),
                3,
                vz_strings.logs_tagEvent + " does not exists ");

        softAssert.assertEquals(localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypeAlbum),
                2,
                vz_strings.logs_mediaType + " does not exist");

        photosAndVideosView.checkDownload();
        softAssert.assertAll();
    }

    private void precondition() throws Exception {

        if (baseControlsHelper.getCountById(vz_strings.no_albumTitle) > 0) {
            photosAndVideosView.createAlbum("Album 1");
        }
    }
}
