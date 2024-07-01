//https://jira.synchronoss.net:8443/jira/browse/VZNFT-72/step-8
package com.verizon.appiumtests.localytics.album;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

import java.util.List;


/**
 * Created by kram0003 on 22/02/18.
 */
public class AlbumSelectAndShare extends BaseTestClass {
    @Test
    public void albumSelectAndShare() throws Exception {
    	homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        gridView.tapFolderInSelectMode10(vz_strings.album_photo_select);
        photosAndVideosView.clickOnShareAndCopyShare(vz_strings.context_share);
        baseControlsHelper.clickOn(vz_strings.share_ShareTo);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);
        List<String> contenttype = localyticsHelper.dynamicCount(logs, vz_strings.logs_shareContentType);
        TestCase.assertTrue("Localytics of " + vz_strings.LOGS_SHARE_SEND_CONTENT + " is not 2 in logs", localyticsHelper.isExisted(logs, vz_strings.logs_tagEvent + ": " + vz_strings.LOGS_SHARE_SEND_CONTENT));
        for (String contentstype : contenttype) {
            if ((contentstype.contains("Video")) || (contentstype.contains("Photo"))) {
                TestCase.assertEquals("Localytics of " + vz_strings.logs_shareContentType + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_shareContentType + "\" " + contentstype));
            }
            else TestCase.fail("Localytics of " + vz_strings.logs_shareContentType + " not matches");
        }
    }
}

