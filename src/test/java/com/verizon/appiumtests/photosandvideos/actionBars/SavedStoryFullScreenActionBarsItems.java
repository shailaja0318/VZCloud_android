package com.verizon.appiumtests.photosandvideos.actionBars;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**
 * //IV-2575
 * @author leletsn
 *
 */
public class SavedStoryFullScreenActionBarsItems extends BaseTestClass {
  @Test
      public void testSavedStoryFullScreenActionBarsItems() throws Exception {
      int count=0;
	  homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
      photosAndVideosView.selectTab(vz_strings.tab_all);
      while(true) {
          try {
              baseControlsHelper.clickOnElementByXpath(vz_strings.allTab_savedStory);
              TestCase.assertTrue("Add to Album option is not present in Action Bar", baseControlsHelper.getCountById(vz_strings.actionBar_AddToAlbum) != 0);
              TestCase.assertTrue("Share option is not present in Action Bar", baseControlsHelper.getCountById(vz_strings.actionBar_share) != 0);
              TestCase.assertTrue("Download option is not present in Action Bar", baseControlsHelper.getCountById(vz_strings.actionBar_download) != 0);
              break;
          } catch (Exception e) {
              baseControlsHelper.swipe("up");
              count++;
              if(count==10) break;

          }
      }

     }
}
