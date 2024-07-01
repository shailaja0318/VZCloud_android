//https://jira.synchronoss.net:8443/jira/browse/VZNFT-256
package com.verizon.appiumtests.localytics.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by ssam0003 on 06/11/18.
 */
public class LocalyticsCloudPrintPhotoEditedEditPrints extends BaseTestClass {
    @Test
    public void testLocalyticsCloudPrintItemComposedEditPrintsProduct() throws Exception {
        photosAndVideosView.EditAndSavePhotosInPrintsAndGifts(1);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);
        TestCase.assertEquals("Localytics of " + vz_strings.logs_CloudPrintPhotoEdited + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_CloudPrintPhotoEdited));
    }
}
