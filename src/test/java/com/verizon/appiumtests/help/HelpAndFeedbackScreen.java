package com.verizon.appiumtests.help;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HelpAndFeedbackScreen extends BaseTestClass {

    @Test
    public void testHelpAndFeedbackScreen() throws Exception {

        homeScreenView.moreMenu_navigateTo(vz_strings.more_helpFeedback);
        
        SoftAssert softAssert = new SoftAssert();
        
      //  softAssert.assertTrue(baseControlsHelper.getCountById(vz_strings.helpAndFeedbackView)!=0, "Not taken to Help and Feedback page");
        softAssert.assertTrue(baseControlsHelper.getCountById(vz_strings.helpFeedBk_sendFeedback)!=0, "Send Feedback option is not available in the help");
        softAssert.assertTrue(baseControlsHelper.getCountById(vz_strings.helpFeedBk_howToVideos)!=0, "How to videos option is not available in the help");
        softAssert.assertTrue(baseControlsHelper.getCountById(vz_strings.helpFeedBk_faqs)!=0, "FAQ's option is not available in the help");
        softAssert.assertAll();
        
    }
}
