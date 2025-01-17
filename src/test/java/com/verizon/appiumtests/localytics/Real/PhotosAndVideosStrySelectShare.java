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
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        baseControlsHelper.openContext(vz_strings.context_select);
        photosAndVideosView.openStory10();
        baseControlsHelper.openContext(vz_strings.context_share);
        baseControlsHelper.clickOn(vz_strings.button_yesRemindMeNextTime);
        baseControlsHelper.waitForDismiss(vz_strings.toast_creatingSocialShareLink);
        String logs = localyticsHelper.getLogs();

    }
}

