package com.verizon.appiumtests.controls;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.driver.BaseDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileBy;
//import io.appium.java_client.MobileElement;

public class MusicView {

    AppiumDriver driver = BaseDriver.getDriver();
    BaseControlsHelper baseControlsHelper = new BaseControlsHelper(driver);
    ListView listView = new ListView(driver);

    public MusicView(AppiumDriver driver) {
        this.driver = driver;
    }

    public void selectTab(String tabName) throws Exception {

        if (tabName.equals(vz_strings.tab_genres)) {
           // baseControlsHelper.clickOn(vz_strings.tab_more);
           // baseControlsHelper.waitForDismiss(vz_strings.refresh_music);
            baseControlsHelper.clickOn(vz_strings.tab_genres);
        } else if (tabName.equals(vz_strings.tab_playlists)) {
           // baseControlsHelper.clickOn(vz_strings.tab_more);
           // baseControlsHelper.waitForDismiss(vz_strings.refresh_music);
            baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.tab_playlists);
        } else {
            baseControlsHelper.clickOn(tabName);
        }
    }

    public void addSongToPlaylist() throws Exception {
        if (baseControlsHelper.getCountById(vz_strings.view_emptyPlaylist) != 0) {
            baseControlsHelper.clickOn(vz_strings.context_addPlaylist);
        }
        listView.selectFirstItem10();
        baseControlsHelper.clickOn(vz_strings.button_done);
        baseControlsHelper.waitForDismiss(vz_strings.spinner);
    }

    public void addSongToFavorites() throws Exception {
        if (baseControlsHelper.getCountById(vz_strings.view_musicFavorites) < 1) {
            //going in to playlist to select a song
            baseControlsHelper.clickOn(vz_strings.view_musicPlaylists);
            if(baseControlsHelper.getCountById(vz_strings.view_emptyPlaylist) != 0)
                addSongToPlaylist();
            listView.clickOnAllElementsInMusicList(vz_strings.MusicView.Favorites);
            baseControlsHelper.openContext(vz_strings.context_addFavorite);
            baseControlsHelper.waitForDismiss(vz_strings.toast_addtoFavorite);
            baseControlsHelper.tapOnBackButton();
        }
    }

    public void addSongToFavoritesFromSongs() throws Exception {
        if (baseControlsHelper.getCountById(vz_strings.view_musicFavorites) < 1) {
        	baseControlsHelper.waitForShow(vz_strings.tab_songs);
            baseControlsHelper.clickOn(vz_strings.tab_songs);
            listView.selectFirstItemInSelectMode10();
            baseControlsHelper.openContext(vz_strings.context_addFavorite);
            baseControlsHelper.waitForDismiss(vz_strings.toast_addtoFavorite);
            baseControlsHelper.waitForShow(vz_strings.tab_more);
            selectTab(vz_strings.tab_playlists);
        }
    }

    public void removeSongFromFavorites() throws Exception {
        if (baseControlsHelper.getCountById(vz_strings.view_musicFavorites) != 0) {
            //going in to playlist to select a song
            baseControlsHelper.clickOn(vz_strings.view_musicFavorites);
         //   listView.clickOnAllElementsInMusicList(vz_strings.MusicView.Favorites);
            baseControlsHelper.openContext(vz_strings.context_select);
            baseControlsHelper.openContext("");
            Thread.sleep(3000);
            baseControlsHelper.clickOnElementByXpath(vz_strings.context_removeFavourite);
        }
    }

    public void deletePlaylist(String playlist) throws Exception {
        if (baseControlsHelper.getCountById(playlist) != 0) {
            baseControlsHelper.openContext(vz_strings.context_select);
            baseControlsHelper.clickOn(playlist);
            baseControlsHelper.openContext(vz_strings.context_delete);
            baseControlsHelper.clickOn(vz_strings.button_yes);
            baseControlsHelper.waitForDismiss(vz_strings.toast_deletePlaylist);
        }
    }

    public void newPl(String playlistName) throws Exception {
        if (baseControlsHelper.getCountById(playlistName) == 0) {
            baseControlsHelper.openContext(vz_strings.context_newPlaylist);
            baseControlsHelper.setValuetoTextFieldByName(playlistName, vz_strings.alertTextField);
            baseControlsHelper.clickOn(vz_strings.context_addPlaylist);
            listView.selectItem10("section - 0, row - 0");
            baseControlsHelper.clickOn(vz_strings.button_done);
           // selectTab(vz_strings.tab_playlists);
            Thread.sleep(2000);
        }
    }

    public void deletePlFromWithin(String playlist) throws Exception {
        if (baseControlsHelper.getCountById(playlist) != 0) {
            baseControlsHelper.clickOn(playlist);
            baseControlsHelper.openContext(vz_strings.context_delete);
            baseControlsHelper.clickOn(vz_strings.button_ok);
            baseControlsHelper.waitForDismiss(vz_strings.toast_deletePlaylist);
        }
    }

    public void openPlaylist(String playList) throws Exception {
        //baseControlsHelper.clickOn(vz_strings.tab_more);
        baseControlsHelper.waitForDismiss(vz_strings.refresh_music);
        baseControlsHelper.clickOn(vz_strings.tab_playlists);
        Thread.sleep(2000);
        baseControlsHelper.clickOnNameContains(playList);
    }

   /* public int getPlaylistCount() throws Exception {
        *//** Only checking at the first album since automation only working with the first album at this moment *//*
        VZServerRequests vzServerRequests = new VZServerRequests();
        return vzServerRequests.getPlaylistCount(vz_strings.DataType.MUSIC);
    }

    public int getCountInPlaylist() throws Exception {
        *//** Only checking at the first album since automation only working with the first album at this moment *//*
        VZServerRequests vzServerRequests = new VZServerRequests();
        return vzServerRequests.getItemCountInPlaylist(vz_strings.DataType.MUSIC);
    }*/

    public boolean isTabSelectedByPredicate(String elementType, String elementLabel) throws Exception {
        baseControlsHelper.waitForShowByTypeAndLabel(elementType, elementLabel);
        System.out.println("Appium Helper Checking from music at " + elementType + " and " + elementLabel);
        String value = driver.findElement(AppiumBy.iOSNsPredicateString("wdType CONTAINS '" + elementType + "' AND wdLabel == '" + elementLabel + "'")).getAttribute("value");
        return value.equals("true");
    }

/*    public void uploadMusic(String fileName) throws Exception {
        VZServerRequests server = new VZServerRequests();
        server.uploadFile(vz_strings.DataType.MUSIC, fileName);
    }
*/
    public void removeSongFromPlaylist() throws Exception{
        if (baseControlsHelper.getCountById(vz_strings.view_emptyPlaylist) < 1) {
            listView.clickOnAllElementsInMusicList(vz_strings.MusicView.Any_Playlist);
            baseControlsHelper.openContext(vz_strings.context_removeFromPlaylist);
        }
    }
}
