package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * @author asdr0001 Alex
 * https://jira.synchronoss.net:8443/jira/browse/IV-709
 * Test case completed until If user selects "No" will dismisses the dialog
 */

public class MusicAlbumsContextDismissesDialog extends BaseTestClass {

    @Test
    public void testAlbumViewMultiselectDelete() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_albums);

        listView.selectFirstItemInSelectMode10();
        baseControlsHelper.openContext(vz_strings.context_delete);
        Thread.sleep(3000);

        TestCase.assertTrue(vz_strings.dialog_delete_AreYouSure, baseControlsHelper.getCountByNameContains(vz_strings.dialog_delete_AreYouSure) != 0);
        TestCase.assertTrue("Are you sure you want ... ", baseControlsHelper.getCountByNameContains(vz_strings.dialog_message) != 0);

        TestCase.assertTrue("Verify cancel button ", baseControlsHelper.getCountByNameContains(vz_strings.button_cancel) != 0);
        TestCase.assertTrue("Verify Move to Trash button ", baseControlsHelper.getCountById(vz_strings.del_moveToTrash) != 0);
        baseControlsHelper.clickOnLabelBeginswith(vz_strings.button_cancel);


    }

}
