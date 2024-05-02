package com.verizon.appiumtests.controls;

import com.verizon.appiumtests.constants.HelperUtilities;
import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.driver.BaseDriver;
import io.appium.java_client.AppiumDriver;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class Preconditions {
	AppiumDriver driver = BaseDriver.getDriver();
	PhotosAndVideosView photosAndVideosView = new PhotosAndVideosView(driver);
	HomeScreenView homeScreenView = new HomeScreenView(driver);
	DocumentsView documentsView = new DocumentsView(driver);
	BaseControlsHelper baseControlsHelper = new BaseControlsHelper(driver);
	GridView gridView = new GridView(driver);
	MusicView musicView = new MusicView(driver);
	ListView listView = new ListView(driver);
	NativeIosAppsView nativeIosAppsView=new NativeIosAppsView(driver);
	SettingsView settingsView=new SettingsView(driver);


	public Preconditions(AppiumDriver driver) throws Exception {
		this.driver = driver;
	}

	/*public void uploadImageAPI() throws Exception {
        System.out.println("--Start Preconditions Upload Photo API--");
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);

        if (baseControlsHelper.getCountByName(vz_strings.tab_all) > 0)
            photosAndVideosView.selectTab(vz_strings.tab_all);

        int count = baseControlsHelper.getCountByName(vz_strings.emptyPhotosViewIcon);
        if (count > 0) {
            photosAndVideosView.uploadPhoto();
        }

        System.out.println("--End Preconditions Upload Photo API--");
    }

    public void uploadDocumentAPI() throws Exception {
        System.out.println("--Start Preconditions Upload Document API--");
        documentsView.uploadSingleFile();
        System.out.println("--End Preconditions Upload Document API--");
    }

    public void uploadMusicAPI() throws Exception {
        System.out.println("--Start Preconditions Upload Music API--");
        musicView.uploadMusic(vz_serverConfigs.musicFileName);
        System.out.println("--End Preconditions Upload Music API--");
    }

    public void uploadPhotoAPI() throws Exception {
        System.out.println("--Start Preconditions Upload Video API--");
        photosAndVideosView.uploadPhoto();
        System.out.println("--End Preconditions Upload Video API--");
    }

    public void createAlbumAPI(String playListName, String playListType, String fileName) throws Exception {
        System.out.println("--Start Preconditions Create Album API--");
        if (!photosAndVideosView.isAlbumExisted()) {
            photosAndVideosView.createAlbumViaServerCall(playListName, playListType, fileName);
        }
        System.out.println("--End Preconditions Create Album API--");
    }*/

	public void createAlbum() throws Exception {
		System.out.println("--Start Preconditions Create Album--");
		if (!photosAndVideosView.ifAnyAlbumExists())
			photosAndVideosView.createAlbum(vz_strings.create_newAlbumName);
		System.out.println("--End Preconditions Create Album--");
	}

	/* public void deleteAllAlbumsAPI() throws Exception {
        System.out.println("--Start Preconditions Delete All Albums API--");
        if (photosAndVideosView.isAlbumExisted()) {
            homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
            photosAndVideosView.selectTab(vz_strings.tab_albums);
            gridView.selectAllAlbums();
            baseControlsHelper.openContext(vz_strings.context_delete);
            baseControlsHelper.clickOn(vz_strings.button_yes);
            baseControlsHelper.waitForDismiss(vz_strings.toast_albumDeletedSuccessfully);
        }
        System.out.println("--End Preconditions Delete All Album API--");
    }*/

	public void deleteAllAlbums() throws Exception {
		System.out.println("--Start Preconditions Delete All Albums--");
		photosAndVideosView.selectTab(vz_strings.tab_albums);
		if (photosAndVideosView.ifAnyAlbumExists()) {
			gridView.selectAllAlbums();
			baseControlsHelper.openContext(vz_strings.context_delete);
			baseControlsHelper.clickOn(vz_strings.button_yes);
			baseControlsHelper.waitForDismiss(vz_strings.toast_albumDeletedSuccessfully);
		}
		System.out.println("--End Preconditions Delete All Album--");
	}

	public void removeContentFromAlbum() throws Exception {
		System.out.println("--Start Preconditions Remove Content From Albums--");
		if(baseControlsHelper.getCountById(vz_strings.view_emptyAlbum) < 1)
			photosAndVideosView.selectAllAction(vz_strings.context_removeFromAlbum);
		baseControlsHelper.tapOnBackButton();
		System.out.println("--End Preconditions Remove Content From Album--");
	}

	/*	public void addPhotoToExistingAlbumAPI() throws Exception {
		System.out.println("--Start Preconditions Add Photo To Album--");

		if (photosAndVideosView.isAlbumEmptyAPI()) {
			homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
			photosAndVideosView.selectTab(vz_strings.tab_albums);
			photosAndVideosView.openAlbum();
			photosAndVideosView.addItemFromAlbum(DataType.PHOTO);
		}
		System.out.println("--End Preconditions Add Photo To Album--");
	}*/

	public void addPhotoToExistingAlbum() throws Exception {
		System.out.println("--Start Preconditions Add Photo To Album--");
		if (baseControlsHelper.getCountById(vz_strings.view_emptyAlbum) > 0) {
			photosAndVideosView.addItemFromAlbum(vz_strings.DataType.PHOTO);
		}
		baseControlsHelper.tapOnBackButton();
		System.out.println("--End Preconditions Add Photo To Album--");
	}

	public void clickOnCartIcon() throws Exception {
		String elementName = vz_strings.button_cartIcon;
		baseControlsHelper.clickOn(elementName);
	}

	/**
	 * Add Song to On The Go Playlist where there is none Pre condition
	 */
	public void addSongToOnTheGo() throws Exception {

		System.out.println("--Start Preconditions Add Song--");
		if (baseControlsHelper.getCountById(vz_strings.view_emptyPlaylist) != 0) {
			musicView.addSongToPlaylist();
		}
		System.out.println("--End Preconditions Add Song--");
	}

	public void clickMusicHeadFromHome() throws Exception {
		System.out.println("Appium Helper finding Music from home ");
		homeScreenView.fromHomeClickAt("Music");
		baseControlsHelper.waitForDismiss(vz_strings.refresh_music);
	}

	/**
	 * Add New Playlist where there is none Pre condition
	 */
	public void addNewPL() throws Exception {

		System.out.println("--Start Preconditions New Pl--");
		if (baseControlsHelper.getCountById(vz_strings.view_musicPlaylists) < 1) {
			musicView.newPl(vz_strings.view_musicPlaylists);
		}
		System.out.println("--End Preconditions New Pl--");
	}

	/**
	 * Add Song to Favorite if no Favorite Pre condition
	 */
	public void addSongToFavorite() throws Exception {

		if (baseControlsHelper.getCountById(vz_strings.view_musicFavorites) == 0) {
			System.out.println("--Start Preconditions Add Fav--");
			musicView.addSongToFavorites();
			System.out.println("--End Preconditions Add Fav--");
		}
	}

	/**
	 * Add Song to Favorite from Songs tab if no Favorite Pre condition
	 */
	public void addSongToFavoriteFromSongs() throws Exception {

		if (baseControlsHelper.getCountById(vz_strings.view_musicFavorites) == 0) {
			System.out.println("--Start Preconditions Add Song--");
			musicView.addSongToFavoritesFromSongs();
			System.out.println("--End Preconditions Add Song--");
		}
	}

	/**
	 * Add Song to Favorite from Music Playlist Pre condition
	 */
	public void addSongFromWithinMusicPlaylist() throws Exception {

		if (baseControlsHelper.getCountById(vz_strings.view_musicFavorites) == 0) {
			System.out.println("--Start Preconditions Add Song--");
			baseControlsHelper.clickOn(vz_strings.view_musicPlaylists);
			if (baseControlsHelper.getCountById(vz_strings.view_emptyPlaylist) > 0) {
				musicView.addSongToPlaylist();
				baseControlsHelper.tapOnBackButton();
			}
			System.out.println("--End Preconditions Add Song--");
		}
	}

	public void addSongToEmptyPlaylist() throws Exception{
		System.out.println("--Start Preconditions Empty Playlist--");
		musicView.openPlaylist(vz_strings.view_musicPlaylists);
		if (baseControlsHelper.getCountById(vz_strings.view_emptyPlaylist) != 0) {
			System.out.println("Playlist is empty, adding song...");
			musicView.addSongToPlaylist();
		}
		else
			System.out.println("Playlist contains song, no need to add");

		baseControlsHelper.tapOnBackButton();
		System.out.println("--End Preconditions Empty Playlist--");
	}

	public void removeAllFavorites(vz_strings.DataType DataType) throws Exception {
		System.out.println("--Start Preconditions UnFav--");
		switch (DataType) {
		case MUSIC:
			if (baseControlsHelper.getCountById(vz_strings.view_musicFavorites) > 0) {
				musicView.removeSongFromFavorites();
			}
			break;
		case DOCUMENT:
			while (baseControlsHelper.getCountById(vz_strings.group_favorites) != 0) {
				baseControlsHelper.openContext(vz_strings.context_select);
				baseControlsHelper.clickOnNameContains("section - 0, row - 0");
				baseControlsHelper.openContext(vz_strings.context_removeFavorite);
				baseControlsHelper.waitForDismiss(vz_strings.toast_removeFromFavorite);
			}
			break;
		}
		System.out.println("--End Preconditions UnFav--");
	}

	/**
	 * Generating Flashback
	 *
	 * @param fileName
	 * @param days
	 * @param months
	 * @param years
	 * @throws Exception
	 * @author Sarthak Samal
	 */
	/*
	 * public void generateFlashBack(ArrayList<String> fileName, int days, int
	 * months, int years) throws Exception { VZServerRequests vzServerRequests = new
	 * VZServerRequests(); vzServerRequests.setDate(days, months, years);
	 * vzServerRequests.uploadFiles(DataType.FLASHBACK, fileName); String
	 * currentDate =
	 * LocalDate.now(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("MMM dd"));
	 * String fbDate =
	 * getFlashBackTriggerDate().format(DateTimeFormatter.ofPattern("MMM dd")); if
	 * (!currentDate.equalsIgnoreCase(fbDate)) { triggerFlashBack(); }
	 * homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
	 * photosAndVideosView.selectTab(vz_strings.tab_flashbacks); }
	 */

	public LocalDate getFlashBackTriggerDate() {
		LocalDate date = LocalDate.now(ZoneOffset.UTC);
		DayOfWeek todayAsDayOfWeek = date.getDayOfWeek();
		LocalDate prevSun = todayAsDayOfWeek == DayOfWeek.SUNDAY ? date : date.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));
		return prevSun;
	}

	public void triggerFlashBack() throws Exception {
		String[] date;
		String setDate;
		navigateToDeviceDateTimeScreen();
		baseControlsHelper.clickOnByIndexFromClassName(baseControlsHelper.getCountByClassName(vz_strings.class_Cell) - 1, vz_strings.class_Cell);
		if(baseControlsHelper.getNameByIndexfromClassName(baseControlsHelper.getCountByClassName(vz_strings.class_Cell) - 2, vz_strings.class_Cell).contains("-")){
			date=baseControlsHelper.getNameByIndexfromClassName(baseControlsHelper.getCountByClassName(vz_strings.class_Cell) - 2, vz_strings.class_Cell).split("-");
		}
		else {
			date=baseControlsHelper.getNameByIndexfromClassName(baseControlsHelper.getCountByClassName(vz_strings.class_Cell) - 2, vz_strings.class_Cell).split(" ");
		}
		if (date[0].length() == 3) {
			setDate=getFlashBackTriggerDate().format(DateTimeFormatter.ofPattern("MMM d"));
		}
		else {
			setDate=getFlashBackTriggerDate().format(DateTimeFormatter.ofPattern("d MMM"));
		}
		for (int i = 0; i <= 3; i++) {
			if (i == 2) continue;
			baseControlsHelper.setDateTimePickerValue(i, HelperUtilities.setArguments(setDate, "12", "", "PM").get(i));
		}
		BaseDriver.launchApp();//driver.launchApp();
		Thread.sleep(2000);
		BaseDriver.lanuchApp(vz_strings.BundleIds.APL_SETTINGS);
		if (setDate.split(" ")[0].length() == 3){
			baseControlsHelper.setDateTimePickerValue(0, HelperUtilities.getCurrentDate()[0] + " " + HelperUtilities.getCurrentDate()[1]);
		}
		else
		{
			baseControlsHelper.setDateTimePickerValue(0, HelperUtilities.getCurrentDate()[1] + " " + HelperUtilities.getCurrentDate()[0]);
		}
		for (int i = 0; i <= 3; i++) {
			if (i == 0 || i == 2) continue;
			baseControlsHelper.setDateTimePickerValue(i, HelperUtilities.setArguments("", HelperUtilities.getCurrentDate()[2], "", HelperUtilities.getCurrentDate()[3]).get(i));
		}
		baseControlsHelper.clickOnNameBeginswithAndType(vz_strings.settings_SetAutomaticallyToggleButton, vz_strings.class_Switch);
		//BaseDriver.getDriver().launchApp();
		BaseDriver.launchApp();
	}

	public void navigateToDeviceDateTimeScreen() throws Exception {
		nativeIosAppsView.resetSettingsApp();
		BaseDriver.lanuchApp(vz_strings.BundleIds.APL_SETTINGS);
		if (!baseControlsHelper.isVisible(vz_strings.settings_General)) baseControlsHelper.scroll(vz_strings.settings_General, "down");
		baseControlsHelper.clickOn(vz_strings.settings_General);
		if (!baseControlsHelper.isVisible(vz_strings.settings_DateAndTime)) baseControlsHelper.scroll(vz_strings.settings_DateAndTime, "down");
		baseControlsHelper.clickOn(vz_strings.settings_DateAndTime);
		if (Integer.parseInt(baseControlsHelper.getValueByIndexfromClassName(0, vz_strings.class_Switch)) != 0) baseControlsHelper.clickOnNameBeginswithAndType(vz_strings.settings_24HourToggleButton, vz_strings.class_Switch);
		if (Integer.parseInt(baseControlsHelper.getValueByIndexfromClassName(1, vz_strings.class_Switch)) != 0) baseControlsHelper.clickOnNameBeginswithAndType(vz_strings.settings_SetAutomaticallyToggleButton, vz_strings.class_Switch);
	}

	public void uploadLivePhotos(int count) throws Exception {
		BaseDriver.lanuchApp(vz_strings.BundleIds.APL_SETTINGS);
		BaseDriver.terminateApp(vz_strings.BundleIds.APL_SETTINGS);
		nativeIosAppsView.toggle3DTouch("off");
		homeScreenView.navigateTo(vz_strings.navi_settings);
		//settingsView.setWhatToBackUp(HelperUtilities.setArguments("", vz_strings.settings_whatToBackUp_Photos));
		//settingsView.setWhatNotToBackUp(HelperUtilities.setArguments(vz_strings.settings_whatToBackUp_Contacts,"", vz_strings.settings_whatToBackUp_Videos));
		baseControlsHelper.tapOnBackButton();
		nativeIosAppsView.generateLivePhoto(count);
		homeScreenView.backUp();
	}

	public void removeFavoritesAlbum() throws Exception {
		System.out.println("--Start Preconditions--");
		photosAndVideosView.selectFavoriteAlbum();
		if (photosAndVideosView.isFavoriteAlbumExisted()) {
			photosAndVideosView.selectAllAction(vz_strings.context_removeFavorite);
			baseControlsHelper.waitForShow(vz_strings.no_favoriteTitle);
		}
		baseControlsHelper.tapOnBackButton();
		System.out.println("--End Preconditions--");
	}

	public void AddToFavoriteAlbum() throws Exception {
		System.out.println("--Start Preconditions--");
		photosAndVideosView.selectFavoriteAlbum();
		if (!photosAndVideosView.isFavoriteAlbumExisted()) {
			baseControlsHelper.tapOnBackButton();
			photosAndVideosView.selectTab(vz_strings.tab_all);
			gridView.tapItemInSelectMode(vz_strings.DataType.PHOTO);
		//	baseControlsHelper.waitForShow(vz_strings.actionBar_addToFavorite);
			baseControlsHelper.clickOn(vz_strings.actionBar_selectView_addToFavorite);
		}else{
			baseControlsHelper.tapOnBackButton();
		}
		System.out.println("--End Preconditions--");
	}

}