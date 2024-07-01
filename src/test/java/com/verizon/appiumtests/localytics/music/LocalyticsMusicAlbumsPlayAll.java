//VZNFT-21 - Step2
//https://jira.synchronoss.net:8443/jira/browse/VPCIOS-5634
package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsMusicAlbumsPlayAll extends BaseTestClass {

    @Test
    public void testLocalyticsMusicAlbumsPlayAll() throws Exception {

    	homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_albums);
        baseControlsHelper.openContext(vz_strings.context_playAll);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_mediaPlay);

        TestCase.assertEquals(vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaPlay));
        TestCase.assertEquals(vz_strings.logs_mediaTypeSong + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\" = " + vz_strings.logs_mediaTypeSong));
    }
}
