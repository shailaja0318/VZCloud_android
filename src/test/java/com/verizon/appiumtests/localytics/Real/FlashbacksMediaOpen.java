package com.verizon.appiumtests.localytics.Real;
/*//https://jira.synchronoss.net:8443/jira/browse/VZNFT-198
package com.sncr.verizon.appiumtests.localytics;

import com.sncr.verizon.appiumtests.constants.HelperUtilities;
import com.sncr.verizon.appiumtests.constants.vz_strings;
import com.sncr.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

import static com.sncr.verizon.appiumtests.constants.vz_serverConfigs.photoFileName;

*//**
 * Created by ssam0003 on 07/09/18.
 *//*
public class FlashbacksMediaOpen extends BaseTestClass {
    private final static Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testFlashbacksMediaOpen() throws Exception {
      homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_flashbacks);
        if (photosAndVideosView.isNoFlashBackTextPresent()) {
            logger.info("No flashbacks present on cloud need to create");
            if (Integer.parseInt(searchFile("name:" + photoFileName)) > 0)
                deleteRepoFile(photoFileName);
            precondition.generateFlashBack(HelperUtilities.setArguments(photoFileName), 0, 0, 1);
        } else logger.info("Flashbacks already present on cloud");
        photosAndVideosView.clickFlashBackThumnail(1, vz_strings.class_Cell);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_mediaOpen);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaOpen + " does not exist", localyticsHelper.getPatternMatch(logs, vz_strings.logs_mediaOpen) == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " is not in logs", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypePhotos) == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_page + " is not in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_page + " = " + "\"" + vz_strings.logs_photosVideosFlashBacks + "\"") == 1);
    }
}
*/