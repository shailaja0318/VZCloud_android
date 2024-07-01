//IV-151
package com.verizon.appiumtests.smartAlbums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class RenameStoryWithinStory extends BaseTestClass {

    @Test
    public void testRenameStory() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        photosAndVideosView.openStory10();
        baseControlsHelper.waitForContent();
        baseControlsHelper.openContext(vz_strings.context_renameStory);
        baseControlsHelper.setValuetoTextFieldByName("Renamed Story Within", vz_strings.alertTextField);
        baseControlsHelper.clickOn(vz_strings.button_ok);
        TestCase.assertTrue("Renamed story not found", baseControlsHelper.getCountByNameContains("Renamed Story Within") > 0);
        baseControlsHelper.tapOnBackButton();

    }
}
