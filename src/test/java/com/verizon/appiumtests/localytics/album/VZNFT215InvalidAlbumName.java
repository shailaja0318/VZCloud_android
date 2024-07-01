package com.verizon.appiumtests.localytics.album;
/*https://jira.synchronoss.net:8443/jira/browse/VZNFT-215
 */

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class VZNFT215InvalidAlbumName extends BaseTestClass {

    @Test
    public void testVZNFT215InvalidAlbumName() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);

        if (baseControlsHelper.getCountById(vz_strings.no_albumTitle) != 0) {
            baseControlsHelper.clickOn(vz_strings.context_newAlbum);
        } else {
            baseControlsHelper.openContext(vz_strings.context_newAlbum);
        }

        baseControlsHelper.setValuetoTextFieldByName(vz_strings.special_char[0], vz_strings.alertTextField);
        baseControlsHelper.clickOn(vz_strings.button_addItems);
        baseControlsHelper.clickOn(vz_strings.button_ok);

        String logs = localyticsHelper.getLogs();
        TestCase.assertTrue("Localytics of " + vz_strings.logs_appError + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_appError));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_appError + " is not 1 in logs", 1, localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_appError));
        localyticsHelper.print(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_appError);
    }
}