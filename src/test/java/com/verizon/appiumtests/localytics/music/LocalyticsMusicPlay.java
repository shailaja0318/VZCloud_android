package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsMusicPlay extends BaseTestClass {

    @Test
    public void testLocalyticsMusicPlay() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_albums);
        listView.selectFirstItem10();
        listView.selectItem10("section - 1, row - 0");

        String logs = localyticsHelper.getLogs();
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaPlay + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_mediaPlay));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaPlay + " is not 1 in logs", localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaPlay) == 1);
        localyticsHelper.print(logs, vz_strings.logs_mediaPlay);
    }
}
