//IV-2463 step 2
package com.verizon.appiumtests.home;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// need to update TC
public class HBMenuItemOrder extends BaseTestClass {

  //  @Test
    public void testHBMenuItemOrder() throws Exception{

        homeScreenView.navigateTo(vz_strings.navi_home);
        baseControlsHelper.clickOn(vz_strings.navi_icon);
        List<String> menuItemsOrdered = new ArrayList<>(Arrays.asList(vz_strings.menuItemsOrdered));
        TestCase.assertTrue(homeScreenView.menuOrder(menuItemsOrdered));
    }
}
