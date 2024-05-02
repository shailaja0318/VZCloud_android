//https://jira.synchronoss.net:8443/jira/browse/VZNFT-146 #5
package com.verizon.appiumtests.localytics.documents;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MediaGalleryDetailDocument extends BaseTestClass {

    @Test
    public void testMediaGalleryDetailDocument() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_documents);
        listView.selectFirstItem10();

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_galleryDetail);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_galleryDetail + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_galleryDetail));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_galleryDetail + " is not 1 in logs", localyticsHelper.getCountOf(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_galleryDetail) == 1);

    }
}
