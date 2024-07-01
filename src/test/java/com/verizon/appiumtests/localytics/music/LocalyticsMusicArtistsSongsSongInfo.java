//VZNFT-20 - Step 6
package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**
 * Created by anlin.tang on 10/02/16.
 */
public class LocalyticsMusicArtistsSongsSongInfo extends BaseTestClass {

    @Test
    public void testLocalyticsMusicArtistsSongsSongInfo() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_artists);
        //Select First Artist
        listView.selectFirstItem10();
        Thread.sleep(3000);
        //Select Song
        baseControlsHelper.clickOn(vz_strings.tab_songs);
        //Select First Song
        listView.selectFirstItemInSelectMode10();
        baseControlsHelper.openContext(vz_strings.context_info);

        String logs = localyticsHelper.getLogs();
        TestCase.assertTrue("Localytics of " + vz_strings.logs_musicInfo + " does not exist",
                localyticsHelper.isExisted(logs, vz_strings.logs_musicInfo));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_musicInfo + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_musicInfo));
        localyticsHelper.print(logs, vz_strings.logs_musicInfo);
    }
}
