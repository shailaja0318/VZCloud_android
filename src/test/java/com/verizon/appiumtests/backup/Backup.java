/*package com.sncr.verizon.appiumtests.backup;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sncr.verizon.appiumtests.constants.vz_strings;
import com.sncr.verizon.appiumtests.controls.AllFilesView;
import com.sncr.verizon.appiumtests.controls.BackupPhotos;
import com.sncr.verizon.appiumtests.controls.BaseControlsHelper;
import com.sncr.verizon.appiumtests.controls.HomeScreenView;
import com.sncr.verizon.appiumtests.controls.PhotosAndVideosView;
import com.sncr.verizon.appiumtests.controls.SettingsView;
import com.sncr.verizon.appiumtests.driver.BaseDriver;

import static org.junit.Assert.*;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;

public class Backup extends BackupPhotos {
	static AppiumDriver adriver;
	static WebDriver wdriver;
	
	static final int import_photos = 2;
	BackupPhotos backupdriver = new BackupPhotos();
	
	
	
	@BeforeClass
	public void setUp() throws Exception{
		
		wdriver = backupdriver.wdsetUp();
		//downloading and saving photos
		backupdriver.saveImage(import_photos);
		
		wdriver.quit();
		
	}
	
	@Test (priority=0)
	public void countPhotos() throws Exception{
		
		int precount = 0;
		int postcount = 0;
		
		HomeScreenView homeScreenView = new HomeScreenView(adriver);
		BaseControlsHelper controlshelper = new BaseControlsHelper(adriver);
		PhotosAndVideosView photosAndVideosView = new PhotosAndVideosView(adriver);
		SettingsView settingsView = new SettingsView(adriver);
		//go to settings and check if photos enabled or not
		homeScreenView.navigateTo(vz_strings.navi_settings);
		//click on backup
		settingsView.clickOn(vz_strings.settings_whatToBackUp);
		//waiting for What to back up screen appears
		WebDriverWait wait = new WebDriverWait(adriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(vz_strings.settings_whatToBackUp)));
		
		boolean isPhotosSelected = adriver.findElement(By.xpath(vz_strings.settings_whatToBackUp_Photos_Switch)).isSelected();
				
		if(!isPhotosSelected){
			System.out.println("Photos back up not Enabled, enabling!");
			adriver.findElement(By.xpath(vz_strings.settings_whatToBackUp_Photos_Switch)).click();
			System.out.println(isPhotosSelected);
			Thread.sleep(1000);
			adriver.findElement(By.xpath(vz_strings.settings_whatToBackUp_BackGroundPhotoBackup_Switch)).click();
		}
		
		System.out.println("Photos back up already enabled");
		controlshelper.clickOnXpath(vz_strings.navi_back);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(vz_strings.settings_whatToBackUp)));
		//doing count before backup
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        Thread.sleep(2000);
        precount = controlshelper.getCountInViewByPredicate(vz_strings.view_photoAll);
		System.out.println("precount "+precount);
		
		//navigate to backup and click
		homeScreenView.navigateTo(vz_strings.navi_backUpNow);
		//navigate to side menu again
		controlshelper.clickOn(vz_strings.navi_icon);
						
		//wait untill backup is done
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(vz_strings.navi_backUpNow)));
		wait.ignoring(NoSuchElementException.class);
		adriver.findElement(By.name(vz_strings.navi_backUpNow));
		controlshelper.clickOn(vz_strings.navi_icon);
		
		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_all);
		Thread.sleep(2000);
		postcount = controlshelper.getCountInViewByPredicate(vz_strings.view_photoAll);
		System.out.println("postcount " + (postcount-2));
			
		TestCase.assertTrue ("Numbers of backup photos does not match",precount == postcount-2);			
		
		
				
	}
	//doing sim clean in diff test becuase it needs to get cleaned even though test fail for some reason
	@Test (priority=1)
	public void cleanSimulator() throws Exception{
		
		HomeScreenView homeScreenView = new HomeScreenView(adriver);
		AllFilesView allFilesView = new AllFilesView(adriver);
					
		//navigate to all files
		homeScreenView.navigateTo(vz_strings.navi_allFiles);
		//click on mobile
		allFilesView.clickOn(vz_strings.folder_mobile);
		//click on iphone simulator
		allFilesView.clickOn("iPhone Simulator");
		//click on context select all
		allFilesView.openContext(vz_strings.context_selectAll);
		//click on delete
		allFilesView.openContext(vz_strings.context_delete);
		//click on Yes
		allFilesView.clickOn(vz_strings.button_yes);
		//wait & confirm pictures gone
		WebDriverWait wait = new WebDriverWait(adriver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("You don't have any content in your Verizon Cloud yet.")));
		
		
	}
	
	@AfterClass
		public void tearDown() {
			adriver.quit();
			
	}	
		
}*/