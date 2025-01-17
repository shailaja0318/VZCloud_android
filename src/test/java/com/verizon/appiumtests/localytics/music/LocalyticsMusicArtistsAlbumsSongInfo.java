//VZNFT-20 - Step 5
package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsMusicArtistsAlbumsSongInfo extends BaseTestClass {

    @Test
    public void testLocalyticsMusicArtistsSongInfo() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_artists);
        Thread.sleep(3000);
        listView.selectItem10("section - 1, row - 0");
        musicView.selectTab(vz_strings.tab_songs);
        listView.selectFirstItemInSelectMode10();
        baseControlsHelper.openContext(vz_strings.context_info);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_musicInfo + " does not exist",
                localyticsHelper.isExisted(logs, vz_strings.logs_musicInfo));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_musicInfo + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_musicInfo));
        localyticsHelper.print(logs, vz_strings.logs_musicInfo);
    }
}
