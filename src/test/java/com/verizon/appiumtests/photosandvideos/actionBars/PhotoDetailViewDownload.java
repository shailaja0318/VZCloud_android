package com.verizon.appiumtests.photosandvideos.actionBars;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**
 * @author leletsn
 *  IV-848-DownloadPhotosFromDetailedView
 */
public class PhotoDetailViewDownload extends BaseTestClass {
	
	@Test
	public void testDownloadVideosFromAllDetailView() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_all);
		baseControlsHelper.clickOnElementByXpath(vz_strings.name_photo);
		baseControlsHelper.clickOn(vz_strings.actionBar_download);
		photosAndVideosView.checkDownload();
		Thread.sleep(1000);
        TestCase.assertEquals("Download still in progress", 0, baseControlsHelper.getCountById(vz_strings.progressbar));
		}
	}

