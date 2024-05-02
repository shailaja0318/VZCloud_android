//VZNFT-33 - Step 1
package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsMusicQueue extends BaseTestClass {

    @Test
    public void testLocalyticsMusicQueue() throws Exception {

        precondition.clickMusicHeadFromHome();
        musicView.selectTab(vz_strings.tab_songs);
        listView.selectFirstItem10();
        baseControlsHelper.openContext(vz_strings.context_showQueue);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_mediaType);
        localyticsHelper.print(logs, vz_strings.logs_tagScreen);

        TestCase.assertTrue(vz_strings.logs_musicArtistSongs + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_musicQueue) == 1);
    }
}
