//https://jira.synchronoss.net:8443/jira/browse/VZNFT-69/step-2
package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by kram0003 on 26/02/18.
 */
public class PhotosAndVideosAllCreateStory extends BaseTestClass {
    @Test
    public void photosAndVideosCreateStory() throws Exception{
        homeScreenView.fromHomeClickAt(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        baseControlsHelper.waitForContent();
        gridView.tapItemsInMultiSelectModeUniversal(3, vz_strings.DataType.PHOTO);
        baseControlsHelper.openContext(vz_strings.context_createStory);
        baseControlsHelper.waitForShow("Edit scenes");

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_realtimesLaunched + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_realtimesLaunched)==1);
    }
}
