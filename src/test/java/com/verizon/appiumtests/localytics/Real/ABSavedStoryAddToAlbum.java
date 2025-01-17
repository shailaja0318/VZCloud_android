package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**
 * @author leletsn
 *VZNFT-559 #2 Add To Album
 */
public class ABSavedStoryAddToAlbum extends BaseTestClass{
    @Test
  public void testABSavedStoryAddToAlbum() throws Exception {
		String albumName = "new album";
		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_all);
		photosAndVideosView.selectTab(vz_strings.tab_stories);
		photosAndVideosView.openStory10();
		baseControlsHelper.openContext(vz_strings.context_select);

		baseControlsHelper.openContext(vz_strings.context_addToAlbum);
		baseControlsHelper.clickOn(vz_strings.button_newAlbum);
		//baseControlsHelper.clickOn(vz_strings.create_newAlbumName);
		//baseControlsHelper.openContext(vz_strings.context_newAlbum);
		baseControlsHelper.setValuetoTextFieldByName(albumName, vz_strings.alertTextField);
		//baseControlsHelper.clickOn(vz_strings.button_addItems);
		//baseControlsHelper.waitForShow("Save Album");
		baseControlsHelper.clickOn(vz_strings.button_save);

		String logs = localyticsHelper.getLogs();
		localyticsHelper.print(logs, vz_strings.logs_albumItemAdded );
        TestCase.assertEquals("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_albumItemAdded));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_source + " does not exits", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_source + " = \"" + vz_strings.logs_storyDetail + "\""));
		TestCase.assertTrue("Localytics of "+vz_strings.logs_target+" does not exits", localyticsHelper.getPatternMatch(logs, vz_strings.logs_target +" = \""+ vz_strings.logs_NotApplicable+"\"")>0);	  


  }
}
