/*
 * //IV-832 package com.sncr.verizon.appiumtests.favorites;
 * 
 * import com.sncr.verizon.appiumtests.constants.vz_strings; import
 * com.sncr.verizon.appiumtests.constants.vz_strings.DataType; import
 * com.sncr.verizon.appiumtests.controls.BaseTestClass; import
 * junit.framework.TestCase; import org.testng.annotations.Test;
 * 
 * public class FavoritingMixedFavoritedItems extends BaseTestClass {
 * 
 * private void preCondition() throws Exception {
 * 
 * System.out.println("--Start Preconditions--");
 * photosAndVideosView.selectTab(vz_strings.tab_albums);
 * photosAndVideosView.selectFavoriteAlbum(); if
 * (photosAndVideosView.isFavoriteAlbumExisted()) {
 * photosAndVideosView.selectAllAction(vz_strings.context_removeFavorite); }
 * baseControlsHelper.tapOnBackButton();
 * photosAndVideosView.selectTab(vz_strings.tab_all);
 * gridView.tapItemInSelectMode(DataType.PHOTO);
 * baseControlsHelper.openContext(vz_strings.context_addFavorite);
 * System.out.println("--End Preconditions--"); }
 * 
 * @Test public void testFavoritingMixedFavoritedItems() throws Exception {
 * 
 * homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
 * photosAndVideosView.selectTab(vz_strings.tab_all);
 * 
 * preCondition();
 * 
 * gridView.tapItemInSelectMode(DataType.PHOTO);
 * gridView.tapItem(DataType.PHOTO); baseControlsHelper.openContext(null);
 * 
 * TestCase.assertTrue("Add to Favorites is not found",
 * baseControlsHelper.getCountById(vz_strings.context_addFavorite) >= 1); } }
 */