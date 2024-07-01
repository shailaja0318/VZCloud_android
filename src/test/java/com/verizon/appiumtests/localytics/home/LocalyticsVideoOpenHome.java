//VZNFT-109 #Step 4
package com.verizon.appiumtests.localytics.home;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;


public class LocalyticsVideoOpenHome extends BaseTestClass {

    @Test
    public void testLocalyticsVideoOpen() throws Exception{
        homeScreenView.navigateTo(vz_strings.navi_home);

        TestCase.assertTrue("No Video found on home view", preCondition_VideoExists());
        String videoLocation = preCondition_getVideoLocation();
        homeScreenView.fromHomeClickAt(videoLocation);

        String logs = localyticsHelper.getLogs();
        TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaOpen + " is not in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaOpen));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaType + " is not in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypeVideo));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_page + " is not in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_page + " = " + "\"" + vz_strings.logs_homeScreen + "\""));

        localyticsHelper.print(logs, vz_strings.logs_mediaOpen);
    }

    public boolean preCondition_VideoExists() throws Exception{
        return (baseControlsHelper.getCountByNameLike("VideosGridCell") > 0);
    }

    public String preCondition_getVideoLocation() throws Exception{
        return (baseControlsHelper.getTextByNameContains("VideosGridCell"));
    }
}
