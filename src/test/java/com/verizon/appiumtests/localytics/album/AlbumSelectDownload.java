//https://jira.synchronoss.net:8443/jira/browse/VZNFT-72/step-11
package com.verizon.appiumtests.localytics.album;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by kram0003 on 23/02/18.
 */
public class AlbumSelectDownload extends BaseTestClass {
    @Test
    public void albumSelectDownload() throws Exception {
    	homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        gridView.tapFolderInSelectMode10(vz_strings.album_photo_select);
        photosAndVideosView.clickOnShareAndCopyShare(vz_strings.context_download);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaDownload + " is not 1 in logs", localyticsHelper.isExisted(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaDownload));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_count + "  is not 1 in logs", localyticsHelper.isExisted(logs, vz_strings.logs_count + " = 1"));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " Media type is not 1 in logs", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\" = " + vz_strings.logs_album) == 1);
       
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaDownload + " is not 1 in logs", localyticsHelper.isExisted(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaDownload));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_count + "  is not 1 in logs", localyticsHelper.isExisted(logs, vz_strings.logs_count + " = 1"));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " Media type is not 1 in logs", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\" = " + vz_strings.logs_photos) == 1);

    }
}