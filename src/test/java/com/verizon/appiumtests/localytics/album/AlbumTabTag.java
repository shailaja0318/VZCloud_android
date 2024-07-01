//https://jira.synchronoss.net:8443/jira/browse/VZNFT-72/step-1

package com.verizon.appiumtests.localytics.album;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;


public class AlbumTabTag extends BaseTestClass {
    @Test
    public void photosAndVideoAlbumTag() throws Exception {
    	homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_photosVideosAlbums);
        TestCase.assertEquals("Localytics of " + vz_strings.logs_photosVideosAlbums + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_photosVideosAlbums));
    }
}
