package com.verizon.appiumtests.photosandvideos;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
//IV-297
public class FullScreenVideoContextMenu extends BaseTestClass {

    int count;
    @Test
    public void testFullScreenVideoContextMenu() throws Exception {

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
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Options missing ",
                baseControlsHelper.isVisible(vz_strings.context_createStory));
    }
}
