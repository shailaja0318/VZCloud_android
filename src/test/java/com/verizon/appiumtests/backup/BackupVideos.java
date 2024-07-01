package com.verizon.appiumtests.backup;

import com.verizon.appiumtests.constants.HelperUtilities;
import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import com.verizon.appiumtests.driver.BaseDriver;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class BackupVideos extends BaseTestClass {
	@Test
	public void testBackupVideos() throws Exception {
		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		baseControlsHelper.startRecording();
		int pvCount = photosAndVideosView.getTotalPhotosAndVideosCount();
		System.out.println("***** BEFORE BACKUP **** " + pvCount);
		baseControlsHelper.stopRecording();
		int nVideos = 1;
		uploadVideos(nVideos);
		Thread.sleep(2000);

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		int pvCountAfterBackup = photosAndVideosView.getTotalPhotosAndVideosCount();
		System.out.println("***** AFTER BACKUP COMPLETE **** " + pvCountAfterBackup);
        TestCase.assertEquals("Photo count not increasing, before backup: " + pvCount + ", after backup:" + pvCountAfterBackup, pvCountAfterBackup, pvCount + nVideos);

	}

	public void uploadVideos(int count) throws Exception {
		baseControlsHelper.tapOnBackButton();
		BaseDriver.terminateApp(vz_strings.BundleIds.VZ_ID);
		nativeIosAppsView.generateVideo(count);

		BaseDriver.lanuchApp(vz_strings.BundleIds.VZ_ID);
		Thread.sleep(2000);
		homeScreenView.backUp();

	}
	
	public void changeBackupSettings() throws Exception {
		homeScreenView.navigateTo(vz_strings.navi_settings);
		Thread.sleep(3000);
		settingsView.setWhatToBackUp(HelperUtilities.setArguments("", vz_strings.settings_whatToBackUp_Videos));
		baseControlsHelper.clickOn(vz_strings.settings_BackButton);
		settingsView.setWhatNotToBackUp(HelperUtilities.setArguments(vz_strings.settings_whatToBackUp_Contacts,"", vz_strings.settings_whatToBackUp_Photos));


	}
}
