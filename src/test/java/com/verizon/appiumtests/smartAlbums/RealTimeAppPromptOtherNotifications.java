package com.verizon.appiumtests.smartAlbums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

public class RealTimeAppPromptOtherNotifications extends BaseTestClass {

    //Deprecated from 16.5.16
    public void testRealTimeAppPromptOtherNotifications() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);

        TestCase.assertTrue("Notifications missing", baseControlsHelper.getCountById("Enjoy your Stories even more with RealTimes! Tap here to download the free app that works with Cloud! ") != 0);

    }
}