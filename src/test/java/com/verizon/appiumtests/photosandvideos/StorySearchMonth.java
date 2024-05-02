//https://jira.synchronoss.net:8443/jira/browse/IV-2386
package com.verizon.appiumtests.photosandvideos;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

/**
 * Created by kram0003 on 29/01/18.
 */
public class StorySearchMonth extends BaseTestClass {
  //  @Test
    public void storySearchMonth_IV_2386() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        if (baseControlsHelper.getCountById(vz_strings.emptyPhotosViewIcon) == 0) {
            TestCase.assertTrue("Stories are not displaying proper", photosAndVideosView.search("Month"));
        } else
            TestCase.assertTrue("No Stories are avaliable", baseControlsHelper.getCountById(vz_strings.emptyPhotosViewIcon) != 0);
    }
}
