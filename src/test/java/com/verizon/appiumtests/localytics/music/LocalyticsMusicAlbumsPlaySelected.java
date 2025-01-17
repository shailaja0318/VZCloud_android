//VZNFT-21 - Step3
package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsMusicAlbumsPlaySelected extends BaseTestClass {

    @Test
    public void testLocalyticsMusicAlbumsPlaySelected() throws Exception {

    	homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_albums);
        listView.selectFirstItem10();
        baseControlsHelper.openContext(vz_strings.context_select);
        listView.selectItem10("section - 1, row - 0");
        baseControlsHelper.openContext(vz_strings.context_playSelected);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_mediaPlay);

        TestCase.assertEquals(vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaPlay));
        TestCase.assertEquals(vz_strings.logs_mediaType + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\" = " + vz_strings.logs_mediaTypeSong));
    }
}
