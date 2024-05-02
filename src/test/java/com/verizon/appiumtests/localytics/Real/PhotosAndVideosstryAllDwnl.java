//https://jira.synchronoss.net:8443/jira/browse/VZNFT-73/step-10

package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Updated by leletsn.
 */
public class PhotosAndVideosstryAllDwnl extends BaseTestClass {
    @Test
    public void photosAndVideosStoryAllDownload() throws Exception {
        homeScreenView.fromHomeClickAt(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        photosAndVideosView.openStory10();
        baseControlsHelper.waitForShow(vz_strings.story_HeroImage);
        baseControlsHelper.openContext(vz_strings.context_select);
        gridView.tapItems();
        baseControlsHelper.openContext(vz_strings.context_download);
        baseControlsHelper.waitForDismiss(vz_strings.progressbar);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_mediaDownload);
        List<String> mediaType = localyticsHelper.dynamicCount(logs, vz_strings.logs_mediaType);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaDownload + " is not 1 in logs", localyticsHelper.isExisted(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaDownload));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_count + "  is not 1 in logs", localyticsHelper.isExisted(logs, vz_strings.logs_count + " = 1"));
        for (String mediatypes : mediaType) {
            if ((mediatypes.contains("Video")) || (mediatypes.contains("Photo"))) {
                TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + "is not 1 in logs", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\" " + mediatypes) == 1);
            }
            else TestCase.assertFalse("Localytics of " + vz_strings.logs_mediaType + " not matches", true);
        }
    }
}
