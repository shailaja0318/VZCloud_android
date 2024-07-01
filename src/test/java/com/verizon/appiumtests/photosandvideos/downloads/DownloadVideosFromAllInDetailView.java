package com.verizon.appiumtests.photosandvideos.downloads;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**
 * @author leletsn
 *  IV-849-DownloadVideosFromAll
 */
public class DownloadVideosFromAllInDetailView extends BaseTestClass {
	public void pre_condition() throws Exception{
		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_all);
		 photosAndVideosView.filterBy(vz_strings.filterByVideos);
		}
	
	@Test
	public void testDownloadVideosFromAllDetailView() throws Exception {
	//	pre_condition();
		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_all);
		baseControlsHelper.clickOnLabelLike(vz_strings.name_video);
		baseControlsHelper.clickOn(vz_strings.actionBar_download);
		photosAndVideosView.checkDownload();
		Thread.sleep(1000);
        TestCase.assertEquals("Download still in progress", 0, baseControlsHelper.getCountById(vz_strings.progressbar));
		}
	}
