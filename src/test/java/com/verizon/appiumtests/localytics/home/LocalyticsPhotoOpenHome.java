//VZNFT-109 #Step 3
package com.verizon.appiumtests.localytics.home;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;


public class LocalyticsPhotoOpenHome extends BaseTestClass {

    @Test
    public void testLocalyticsPhotoOpenHome() throws Exception{
        homeScreenView.navigateTo(vz_strings.navi_home);

        TestCase.assertTrue("No photo found on home view", preCondition_PhotoExists());
        String homePhoto = preCondition_GetPhotoLocation();

        homeScreenView.fromHomeClickAt(homePhoto);

        String logs = localyticsHelper.getLogs();
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaOpen + " is not in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaOpen) == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " is not in logs", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypePhoto) == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_page + " is not in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_page + " = " + "\"" + vz_strings.logs_homeScreen + "\"") == 1);

        localyticsHelper.print(logs, vz_strings.logs_mediaOpen);
    }

    public boolean preCondition_PhotoExists() throws Exception{
        return (baseControlsHelper.getCountByNameLike("PhotosGridCell") > 0);
    }

    public String preCondition_GetPhotoLocation() throws Exception{
        return baseControlsHelper.getTextByNameContains("PhotosGridCell");
    }
}
