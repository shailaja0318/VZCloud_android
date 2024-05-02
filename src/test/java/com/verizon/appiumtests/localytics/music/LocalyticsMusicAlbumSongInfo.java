//VZNFT-20 - Step 4
package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsMusicAlbumSongInfo extends BaseTestClass {

    @Test
    public void testLocalyticsMusicAlbumSongInfo() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_albums);
        listView.selectFirstItem10();
        listView.selectItem10("section - 1, row - 0");
        baseControlsHelper.openContext(vz_strings.context_info);

        String logs = localyticsHelper.getLogs();
        TestCase.assertTrue("Localytics of " + vz_strings.logs_musicInfo + " does not exist",
                localyticsHelper.isExisted(logs, vz_strings.logs_musicInfo));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_musicInfo + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_musicInfo) == 1);
        localyticsHelper.print(logs, vz_strings.logs_musicInfo);
    }
}