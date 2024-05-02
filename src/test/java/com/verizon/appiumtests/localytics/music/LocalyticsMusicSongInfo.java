//VZNFT-20 - Step 1
package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**
 * Created by anlin.tang on 10/02/16.
 */
public class LocalyticsMusicSongInfo extends BaseTestClass {

    @Test
    public void testLocalyticsMusicSongInfo() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_songs);
        listView.selectFirstItem10();
        baseControlsHelper.openContext(vz_strings.context_info);

        String logs = localyticsHelper.getLogs();
        TestCase.assertTrue("Localytics of " + vz_strings.logs_musicSongs + " does not exist",
                localyticsHelper.isExisted(logs, vz_strings.logs_musicSongs));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_musicSongs + " is not 1 in logs",
                localyticsHelper.getCountOf(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_musicSongs) == 1);
        localyticsHelper.print(logs, vz_strings.logs_musicSongs);
    }
}
