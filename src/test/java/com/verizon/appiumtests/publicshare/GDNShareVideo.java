package com.verizon.appiumtests.publicshare;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**
 * IV-2627
 * @author leletsn
 *
 */
public class GDNShareVideo extends BaseTestClass {

    int count=0;

    @Test
    public void testGDNShareVideo() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        while(true){
            try {
                baseControlsHelper.clickOnElementByXpath(vz_strings.name_video_open);
                break;
            }catch (Exception e){
                baseControlsHelper.swipe("up");
                count++;
                if(count==10) break;
            }
        }
        baseControlsHelper.clickOn(vz_strings.actionBar_share);

        TestCase.assertTrue("OK to Share Location? , not present", baseControlsHelper.getCountById(vz_strings.text_OkToShareLocation) != 0);
        TestCase.assertTrue("Some of these photos... , not present", baseControlsHelper.getCountByNameContains(vz_strings.text_SomeOfThesePhotos) != 0);
        TestCase.assertTrue("Yes, Don't Remind Me Again", baseControlsHelper.getCountById(vz_strings.button_shareAndDontWarnMeAgain) != 0);
        TestCase.assertTrue("Yes, Remind Me Next Time", baseControlsHelper.getCountById(vz_strings.button_yesRemindMeNextTime) != 0);
        TestCase.assertTrue("No, Cancel My Share", baseControlsHelper.getCountById(vz_strings.button_noCancelMyShare) != 0);

        baseControlsHelper.clickOn(vz_strings.button_yesRemindMeNextTime);
        baseControlsHelper.waitForDismiss(vz_strings.toast_creatingSocialShareLink);


    }
}