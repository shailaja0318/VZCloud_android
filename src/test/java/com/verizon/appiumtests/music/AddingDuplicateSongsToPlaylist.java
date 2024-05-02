//package com.sncr.verizon.appiumtests.music;
//
//import com.sncr.verizon.appiumtests.constants.vz_strings;
//import com.sncr.verizon.appiumtests.controls.BaseTestClass;
//import junit.framework.TestCase;
//
//public class AddingDuplicateSongsToPlaylist extends BaseTestClass {
//
//    //NOTPASSING@Test(enabled=false)
//    public void testAddingDuplicateSongsToPlaylist() throws Exception {
//
//
//        homeScreenView.navigateTo(vz_strings.navi_music);
//        musicView.selectTab(vz_strings.tab_playlists);
//        baseControlsHelper.clickOn("Music Playlists");
//        preCondition();
//        String song_name = baseControlsHelper.getTextByXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[2]");
//
//        //verify music play list has one song
//        //TestCase.assertTrue("Number of the song in playlist at start ", baseControlsHelper.getCountByXpath(vz_strings.xpath_listview) == 1);
//
//        //back button
//        baseControlsHelper.clickOnXpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]");
//
//        //add same song again from tab_playlist
//        musicView.selectTab(vz_strings.tab_songs);
//        baseControlsHelper.openContext(vz_strings.context_select);
//        baseControlsHelper.clickOn(song_name);
//        baseControlsHelper.openContext(vz_strings.context_addToPlaylist);
//        //assuming Music Playlist is selected by default
//        baseControlsHelper.clickOn("OK");
//        musicView.selectTab(vz_strings.tab_playlists);
//        baseControlsHelper.clickOn("Music Playlists");
//        int count = 0;
//        //count = baseControlsHelper.getCountByXpath(vz_strings.xpath_listview);
//
//        //verifying only one song in playlist
//        TestCase.assertTrue("Number of song after adding up from songs", count == 1);
//
//    }
//
//    private void preCondition() throws Exception {
//
//
//        System.out.println("--Start Preconditions--");
//        if (baseControlsHelper.getCountByXpath(vz_strings.xpath_selectSongPlaylist) == 0) {
//            musicView.addSongToPlaylist();
//        }
//        System.out.println("--End Preconditions--");
//    }
//
//}
