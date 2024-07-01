//https://jira.synchronoss.net:8443/jira/browse/VZNFT-234
//https://jira.synchronoss.net:8443/jira/browse/VZNFT-72/step-6/7

package com.verizon.appiumtests.localytics.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by kram0003 on 07/02/18.
 */
public class CloudPrintAlbumTab extends BaseTestClass {
    @Test
    public void cloudPrintAlbum() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        photosAndVideosView.clickPrintsAndGift(vz_strings.context_printAndGifts, vz_strings.context_icon_printShop);
        baseControlsHelper.waitForDismiss(vz_strings.spinner);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_photoBucketEntry);
        TestCase.assertEquals("Localytics of " + vz_strings.logs_photoBucketEntry + " does not exist", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_photoBucketEntry));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_photoBucketEntry));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_photoBucketEntryPoint + " does not exist", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_photoBucketEntryPoint + "\" = \"" + vz_strings.logs_photosVideosAlbums + "\""));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_photoBucketNumber + " does not exist", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_photoBucketNumber + "\" = 0"));
    }
}
