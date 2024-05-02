//package com.sncr.verizon.appiumtests.music;
//
//import com.sncr.verizon.appiumtests.constants.vz_strings;
//import com.sncr.verizon.appiumtests.controls.BaseTestClass;
//import junit.framework.TestCase;
//
//public class UserCreatedPlaylist extends BaseTestClass {
//
//    //need to rewrite this test case
//    public void testUserCreatedPlaylist() throws Exception {
//
//
//        homeScreenView.navigateTo(vz_strings.navi_music);
//        musicView.selectTab(vz_strings.tab_playlists);
//
//        String song = addSongToTempPlaylist();
//        baseControlsHelper.clickOn("TEMP");
//        TestCase.assertTrue("Same song Not found", baseControlsHelper.getCountByName(song) != 0);
//        baseControlsHelper.tapOnBackButton();
//        //clean up
//        musicView.deletePlaylist("TEMP");
//        TestCase.assertTrue("Playlist not deleted", baseControlsHelper.getCountByName("TEMP") == 0);
//    }
//
//    //rewriting this becuase need to store song name selected for temp playlist
//    public String addSongToTempPlaylist() throws Exception {
//
//
//        baseControlsHelper.openContext(vz_strings.context_newPlaylist);
//        //baseControlsHelper.setValuetoTextFieldByXpath("TEMP", vz_strings.albumNameXpath_ios9);
//        baseControlsHelper.clickOn(vz_strings.context_addPlaylist);
//        //String song_name = baseControlsHelper.getTextByXpath(vz_strings.xpath_songname);
//        listView.selectItem10(vz_strings.xpath_listview);
//        baseControlsHelper.clickOn(vz_strings.button_done);
//        Thread.sleep(2000);
//        musicView.selectTab(vz_strings.tab_playlists);
//        return song_name;
//    }
//}