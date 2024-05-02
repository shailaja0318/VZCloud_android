package com.verizon.appiumtests.localytics.livePhotos;
/*//https://jira.synchronoss.net:8443/jira/browse/VZNFT-323
package com.sncr.verizon.appiumtests.localytics;

import com.sncr.verizon.appiumtests.constants.vz_strings;
import com.sncr.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

*//**
 * Created by ssam0003 on 02/11/18.
 *//*
public class LocalyticsLivePhotosTagEventMediaDownloadAlbumPane extends BaseTestClass {
    @Test
    public void testLocalyticsLivePhotosTagEventMediaDownloadAlbumPane() throws Exception {
        try {
            deletePlaylists(PlaylistTypes.PHOTO_VIDEO);
            photosAndVideosView.uploadLivePhotoAndAddToAlbum();
            gridView.tapItemInSelectMode(vz_strings.DataType.LIVEPHOTO);
            baseControlsHelper.openContext(vz_strings.context_download);
            baseControlsHelper.waitForShow("1 file downloaded.");
            String logs = localyticsHelper.getLogs();
            localyticsHelper.print(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaDownload);
            TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaDownload + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaDownload) == 1);
            TestCase.assertTrue("Localytics of " + vz_strings.logs_count + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_count + " = " + "1") == 1);
            TestCase.assertTrue(vz_strings.logs_mediaType + " does not exist", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + "\"" + vz_strings.name_livePhoto + "\"") == 1);
        } finally {
            settingsView.tapOnBackButtonAndSetWhatToBackup(true, 1);
        }
    }
}
*/