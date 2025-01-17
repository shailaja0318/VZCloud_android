//IV-294
package com.verizon.appiumtests.recents;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class RecentsContextMenu extends BaseTestClass {

    @Test
    public void testRecentsContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Recents);
        baseControlsHelper.clickOnElementByXpath(null);

        TestCase.assertTrue("Options missing ", baseControlsHelper.isVisible
                (vz_strings.context_printAndGifts));
    }
}
