//https://jira.synchronoss.net:8443/jira/browse/IV-2483
package com.verizon.appiumtests.photosandvideos.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by kram0003 on 22/01/18.
 */
public class UnsupportedFiles extends BaseTestClass {


    @Test
    public void unSupportFiles() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        baseControlsHelper.openContext(vz_strings.context_select);
        gridView.tapItems();
        baseControlsHelper.clickOn(vz_strings.button_cartIcon);

        TestCase.assertTrue("Some of your ",
                baseControlsHelper.getCountById("Some of your selections cannot be printed") > 0);
        baseControlsHelper.clickOn(vz_strings.button_gotIt);

    }

}
