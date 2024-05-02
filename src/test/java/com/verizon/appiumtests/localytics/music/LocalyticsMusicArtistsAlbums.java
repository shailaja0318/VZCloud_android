//VZNFT-23 - Step 1
package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsMusicArtistsAlbums extends BaseTestClass {

    @Test
    public void testLocalyticsMusicArtistsAlbums() throws Exception {

    	homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_artists);

        String logs = localyticsHelper.getLogs();
        TestCase.assertTrue("Localytics of " + vz_strings.logs_musicArtists + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_musicArtists) == 1);
        localyticsHelper.print(logs, vz_strings.logs_musicArtistAlbums);
    }
}
