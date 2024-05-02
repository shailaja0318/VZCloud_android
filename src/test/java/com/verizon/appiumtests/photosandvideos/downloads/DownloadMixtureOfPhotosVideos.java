package com.verizon.appiumtests.photosandvideos.downloads;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/** @author leletsn
 * IV-860: DownloadMixtureOfPhotosVideos
 */
public class DownloadMixtureOfPhotosVideos extends BaseTestClass{
	   @Test
	   public void testDownloadMixtureOfPhotosVideos() throws Exception {
		   homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		   photosAndVideosView.selectTab(vz_strings.tab_all);
		   baseControlsHelper.openContext(vz_strings.context_select);
		   gridView.tapItems();
		   baseControlsHelper.clickOn(vz_strings.actionBar_selectView_download);
		   photosAndVideosView.checkDownload();
		   Thread.sleep(1000);
		   TestCase.assertTrue("Download still in progress", baseControlsHelper.getCountById(vz_strings.progressbar)==0);
		   }
	   }