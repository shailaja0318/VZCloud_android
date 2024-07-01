/**
 * VZNFT-177 Step 1
 * */
package com.verizon.appiumtests.localytics.album;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MediaGalleryOpenAlbums extends BaseTestClass{

    @Test
    public void testMediaGalleryOpenAlbums() throws Exception {

    	homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.createAlbum();
        photosAndVideosView.openAlbum();

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);

        TestCase.assertEquals("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaGalleryOpen));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_page + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_page + " = " + vz_strings.logs_album));
    }
}
