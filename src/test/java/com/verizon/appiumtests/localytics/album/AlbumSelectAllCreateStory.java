//https://jira.synchronoss.net:8443/jira/browse/VZNFT-72/step-2
package com.verizon.appiumtests.localytics.album;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by kram0003 on 22/02/18.
 */
public class AlbumSelectAllCreateStory extends BaseTestClass {
    @Test
    public void albumSelectAllCreateStory() throws Exception {
    	homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.createAlbum();
        photosAndVideosView.openAlbum();
        gridView.clickAllElements();
        baseControlsHelper.openContext(vz_strings.context_createStory);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);
        TestCase.assertEquals("Localytics of " + vz_strings.logs_realtimesLaunched + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_realtimesLaunched));
    }
}
