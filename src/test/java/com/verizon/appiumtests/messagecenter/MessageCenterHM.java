/**
 * IV-4742 - Step 1 and 2
 * */
package com.verizon.appiumtests.messagecenter;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MessageCenterHM extends BaseTestClass{

    @Test
    public void testMessageCenterHMPresent() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_messageCenter);
     	Thread.sleep(2000);
        TestCase.assertTrue("Message center text not present ",
                 baseControlsHelper.getCountById(vz_strings.navi_messageCenter) > 0);
    }
}
