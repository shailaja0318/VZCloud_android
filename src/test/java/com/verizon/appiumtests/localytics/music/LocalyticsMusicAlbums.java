//VZNFT-21 - Step1
package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsMusicAlbums extends BaseTestClass {

    @Test
    public void testLocalyticsMusicAlbums() throws Exception {

    	homeScreenView.navigateTo(vz_strings.navi_music);
    	 musicView.selectTab(vz_strings.tab_albums);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_musicAlbums);

        TestCase.assertTrue(vz_strings.logs_musicAlbums + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_musicAlbums) == 1);
    }
}
