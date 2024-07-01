//https://jira.synchronoss.net:8443/jira/browse/VZNFT-73/step-6
package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by kram0003 on 06/03/18.
 */
public class PhotosAndVideosStrySelectShare extends BaseTestClass {
    @Test
    public void photosAndVideosStorySelectShare() throws Exception {
        homeScreenView.fromHomeClickAt(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        gridView.tapFolderInSelectMode10("Story-0");
        photosAndVideosView.clickOnShareAndCopyShare(vz_strings.context_share);
        baseControlsHelper.waitForDismiss(vz_strings.toast_creatingSocialShareLink);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.LOGS_SHARE_SEND_CONTENT);
        TestCase.assertTrue("Localytics of " + vz_strings.LOGS_SHARE_SEND_CONTENT + " is not 1 in logs", localyticsHelper.isExisted(logs, vz_strings.logs_tagEvent + ": " + vz_strings.LOGS_SHARE_SEND_CONTENT));
        List<String> contenttype = localyticsHelper.dynamicCount(logs, vz_strings.logs_shareContentType);
        for (String contentstype : contenttype) {
            if ((contentstype.contains("Video")) || (contentstype.contains("Photo"))) {
                TestCase.assertEquals("Localytics of " + vz_strings.logs_shareContentType + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_shareContentType + "\" " + contentstype));
            }
            else TestCase.fail("Localytics of " + vz_strings.logs_shareContentType + " not matches");
        }
    }
}

