//https://jira.synchronoss.net:8443/jira/browse/VZNFT-73/step-8

package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

import java.util.List;

public class PhotosAndVideosStrySelectCpyShrlnk extends BaseTestClass {
    @Test
    public void photosAndVidoesStorySelectCopyShareLink() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        photosAndVideosView.openStory10();
        baseControlsHelper.openContext(vz_strings.context_select);
        gridView.tapItems();
        baseControlsHelper.openContext(vz_strings.context_share);
        baseControlsHelper.clickOn(vz_strings.button_yesRemindMeNextTime);
        baseControlsHelper.clickOn(vz_strings.share_ShareTo);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);
        localyticsHelper.print(logs, vz_strings.logs_tagScreen);

        TestCase.assertEquals(vz_strings.logs_shareSheetAction + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_shareSheetAction));

        TestCase.assertEquals(vz_strings.logs_shareContentType + " does not exist", 2, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_shareContentType + "\""));
        //TestCase.assertEquals("Localytics of " + vz_strings.logs_source + " does not exits", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_source + " = \"" + vz_strings.logs_storyDetail + "\""));
        TestCase.assertTrue("Localytics of "+vz_strings.logs_target+" does not exits", localyticsHelper.getPatternMatch(logs, vz_strings.logs_target +" = \""+ vz_strings.logs_NotApplicable+"\"")>0);

    }
}
