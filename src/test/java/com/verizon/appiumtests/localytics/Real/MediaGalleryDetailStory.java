//TODO : Review
//https://jira.synchronoss.net:8443/jira/browse/VZNFT-146 #4
package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

public class MediaGalleryDetailStory extends BaseTestClass {

    public void testMediaGalleryDetailStory() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_timeline);
        baseControlsHelper.clickOnNameLike(vz_strings.name_savedStory);
        baseControlsHelper.clickOnNameLike(vz_strings.name_savedStory);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_galleryDetail);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_galleryDetail + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_galleryDetail));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_galleryDetail + " is not 1 in logs", localyticsHelper.getCountOf(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_galleryDetail) == 1);

    }
}
