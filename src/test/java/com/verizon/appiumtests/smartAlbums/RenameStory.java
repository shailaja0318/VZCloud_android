//IV-152
package com.verizon.appiumtests.smartAlbums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class RenameStory extends BaseTestClass {

    @Test
    public void testRenameStory() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        gridView.tapFolderInSelectMode10("Story-0");
        baseControlsHelper.waitForShow(vz_strings.context_menu);
        baseControlsHelper.openContext(vz_strings.context_renameStory);
        baseControlsHelper.setValuetoTextFieldByName("Renamed Story", vz_strings.alertTextField);
        baseControlsHelper.clickOn(vz_strings.button_ok);
        TestCase.assertTrue("Renamed story not found", baseControlsHelper.getCountByNameContains("Renamed Story") > 0);
        baseControlsHelper.tapOnBackButton();

    }

}
