package com.verizon.appiumtests.localytics.livePhotos;
/*//https://jira.synchronoss.net:8443/jira/browse/VZNFT-335 - Step-2
package com.sncr.verizon.appiumtests.localytics;

import com.sncr.verizon.appiumtests.constants.vz_strings;
import com.sncr.verizon.appiumtests.controls.BaseMediaTest;
import com.sncr.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

*//**
 * Created by ssam0003 on 17/10/2018.
 *//*
public class LocalyticsLivePhotosMediaPlayAlbums extends BaseTestClass {
    boolean flag = false;

    @Test
    public void testLocalyticsLivePhotosMediaPlayAlbums() throws Exception {
        try {
            deletePlaylists(BaseMediaTest.PlaylistTypes.PHOTO_VIDEO);
            flag = photosAndVideosView.uploadLivePhotoAndAddToAlbum();
            baseControlsHelper.clickOnNameLike(vz_strings.name_livePhoto);
            Thread.sleep(1000);
            baseControlsHelper.touchAndHoldOnElement(baseControlsHelper.getLivePhotoElement());
            String logs = localyticsHelper.getLogs();
            localyticsHelper.print(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaPlay);
            TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaPlay + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaPlay) == 1);
            TestCase.assertTrue(vz_strings.logs_mediaType + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + "\"" + vz_strings.logs_mediaTypeLivePhoto + "\""));
        } finally {
            settingsView.tapOnBackButtonAndSetWhatToBackup(flag, 2);
        }
    }
}
*/