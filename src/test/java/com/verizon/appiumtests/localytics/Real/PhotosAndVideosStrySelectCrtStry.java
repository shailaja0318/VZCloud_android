//https://jira.synchronoss.net:8443/jira/browse/VZNFT-73/step-2
//Bug https://jira.synchronoss.net:8443/jira/browse/VPCIOS-5635
package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by kram0003 on 06/03/18.
 */
public class PhotosAndVideosStrySelectCrtStry extends BaseTestClass{
    @Test
    public void photosAndVideosStorySelectCreateStory() throws Exception{
        homeScreenView.fromHomeClickAt(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        baseControlsHelper.waitForContent();
        gridView.tapFolderInSelectMode10("Story-0");
        baseControlsHelper.openContext(vz_strings.context_createStory);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);
        TestCase.assertEquals("Localytics of " + vz_strings.logs_realtimesLaunched + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_realtimesLaunched));
    }
}
