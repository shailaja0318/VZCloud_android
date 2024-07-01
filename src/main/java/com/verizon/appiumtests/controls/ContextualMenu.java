package com.verizon.appiumtests.controls;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.driver.BaseDriver;
import io.appium.java_client.AppiumDriver;

import java.util.ArrayList;
import java.util.List;

public class ContextualMenu {
	AppiumDriver driver = BaseDriver.getDriver();
	BaseControlsHelper baseControlsHelper = new BaseControlsHelper(driver);

	public ContextualMenu(AppiumDriver driver) {
		this.driver = driver;
	}

	List<String> mList = new ArrayList<>();

	public List<String> displayList(vz_strings.DataType dataType, String view) throws Exception {

		/**
		 * Contextual menu when selecting in Photos & Videos section
		 */
		if (dataType == (vz_strings.DataType.PHOTO) || dataType == (vz_strings.DataType.VIDEO)) {
			if (view.equals(vz_strings.view_photoAll)) {

				mList.add(vz_strings.context_createStory);
				mList.add(vz_strings.context_editPhoto);
				mList.add(vz_strings.context_download);
				mList.add(vz_strings.context_addToAlbum);
				mList.add(vz_strings.context_addFavorite);
				mList.add(vz_strings.context_share);
				mList.add(vz_strings.context_info);
				mList.add(vz_strings.context_delete);

			} else if (view.equals(vz_strings.view_photoFull)) {

				mList.add(vz_strings.context_createStory);
				mList.add(vz_strings.context_makePrivate);
				mList.add(vz_strings.context_editPhoto);
				mList.add(vz_strings.context_printAndGifts);
				mList.add(vz_strings.context_info);


			} else if (view.equals(vz_strings.view_videoFull)) {

				mList.add(vz_strings.context_topActionBarcreateStory);
				mList.add(vz_strings.context_info);
				mList.add(vz_strings.context_makePrivate);

			} else if (view.equals(vz_strings.view_photoAlbum)) {

				mList.add(vz_strings.context_createStory);
				mList.add(vz_strings.context_createcollage);
				mList.add(vz_strings.context_download);
				mList.add(vz_strings.context_addToAlbum);
				mList.add(vz_strings.context_share);
				mList.add(vz_strings.context_delete);

			} else if (view.equals(vz_strings.view_insideAlbum)) {

				mList.add(vz_strings.context_createPhotoBook);
				mList.add(vz_strings.context_printAndGifts);
				mList.add(vz_strings.context_select);
				mList.add(vz_strings.context_addPhotoAndVideos);
				mList.add(vz_strings.context_share);
				mList.add(vz_strings.context_rename);
				mList.add(vz_strings.context_deleteAlbum);

			} else if (view.equals(vz_strings.view_insideFavorite)) {

				mList.add(vz_strings.context_createStory);
				mList.add(vz_strings.context_makePrivate);
				mList.add(vz_strings.context_editPhoto);
				mList.add(vz_strings.context_playPuzzleGame);
				mList.add(vz_strings.context_printAndGifts);
				mList.add(vz_strings.context_info);

			} else if (view.equals(vz_strings.view_emptyAlbum)) {
				mList.add(vz_strings.context_deleteAlbum);

			} else if (view.equals(vz_strings.view_Flashbacks)) {

				mList.add(vz_strings.context_createStory);
				mList.add(vz_strings.context_createcollage);
				mList.add(vz_strings.context_printAndGifts);
				mList.add(vz_strings.context_select);
				mList.add(vz_strings.context_share);
				mList.add(vz_strings.context_addToAlbum);
				mList.add(vz_strings.context_addToPrintAlbum);
				mList.add(vz_strings.context_download);

			}
		}
		/**
		 * Contextual menu when selecting in Music section
		 */
		else if (dataType == (vz_strings.DataType.MUSIC)) {

			if (view.equals(vz_strings.view_musicAlbums)) {

				mList.add(vz_strings.context_select);
				mList.add(vz_strings.context_sort);
				mList.add(vz_strings.context_share);

			} else if (view.equals(vz_strings.view_musicSongs) || view.equals(vz_strings.view_insideMusicGenres)) {

				mList.add(vz_strings.context_showQueue);
				mList.add(vz_strings.context_addToPlaylist);
				mList.add(vz_strings.context_addFavorite);
				mList.add(vz_strings.context_share);
				mList.add(vz_strings.context_info);
				mList.add(vz_strings.context_delete);
				mList.add(vz_strings.context_makePrivate);

			} else if (view.equals(vz_strings.view_musicPlaylists)) {

				mList.add(vz_strings.context_playSelected);
				mList.add(vz_strings.context_delete);

			} else if (view.equals(vz_strings.view_insideMusicAlbum)) { //updated 2021

				mList.add(vz_strings.context_select);
				mList.add(vz_strings.context_sort);
				mList.add(vz_strings.context_share); // mList.add(vz_strings.context_delete);

			} else if (view.equals(vz_strings.view_musicArtists)) {

				mList.add(vz_strings.context_playSelected);
				mList.add(vz_strings.context_addToPlaylist);
				mList.add(vz_strings.context_delete);

			} else if (view.equals(vz_strings.view_insideMusicFavorites)) {

				mList.add(vz_strings.context_playSelected);
				mList.add(vz_strings.context_addToPlaylist);
				mList.add(vz_strings.context_removeFavorite);
				mList.add(vz_strings.context_share);

				mList.add(vz_strings.context_info);
				mList.add(vz_strings.context_delete);

			} else if (view.equals(vz_strings.view_insideMusicPlaylist)) {

				mList.add(vz_strings.context_playSelected);
				mList.add(vz_strings.context_addToPlaylist);
				mList.add(vz_strings.context_removeFromPlaylist);
				mList.add(vz_strings.context_addFavorite);
				mList.add(vz_strings.context_share);

				mList.add(vz_strings.context_info);
				mList.add(vz_strings.context_delete);

			} else if (view.equals(vz_strings.view_musicPlayerQueue)) {

				// mList.add(vz_strings.context_connectToATV);
				mList.add(vz_strings.context_addToPlaylist);
				mList.add(vz_strings.context_removeFromQueue);
				mList.add(vz_strings.context_addFavorite);
				mList.add(vz_strings.context_share);

				mList.add(vz_strings.context_info);
				mList.add(vz_strings.context_delete);
			}
		}
		/**
		 * Contextual menu when selecting in Documents and All files section
		 */
		else if (dataType == (vz_strings.DataType.DOCUMENT) || dataType == (vz_strings.DataType.AllFiles)) {
			if (view.equals(vz_strings.view_documents) || view.equals(vz_strings.view_documentFull)
					|| view.equals(vz_strings.view_allFiles)) {

				mList.add(vz_strings.context_addFavorite);
				mList.add(vz_strings.context_share);

				mList.add(vz_strings.context_info);
				mList.add(vz_strings.context_delete);

			} else if (view.equals(vz_strings.view_documentsFavorite)) {

				mList.add(vz_strings.context_removeFavorite);
				mList.add(vz_strings.context_share);
				mList.add(vz_strings.context_info);
				mList.add(vz_strings.context_addToSharedFolder);
				mList.add(vz_strings.context_delete);
				mList.add(vz_strings.context_makePrivate);

			}
		} else if (dataType == null) {
			/**
			 * Contextual menu when NOT selecting in Photos & Videos section
			 */
			if (view.equals(vz_strings.view_photoAll)) {

				mList.add(vz_strings.context_connectToATV);
				mList.add(vz_strings.context_select);
				mList.add(vz_strings.context_sortAndFilter);

			} else if (view.equals(vz_strings.view_insideFavorite)) {

				mList.add(vz_strings.context_connectToATV);
				mList.add(vz_strings.context_photoBook);
				mList.add(vz_strings.context_select);
				mList.add(vz_strings.context_sort);

			} else if (view.equals(vz_strings.view_photoAlbum)) {

				mList.add(vz_strings.context_connectToATV);
				mList.add(vz_strings.context_select);
				mList.add(vz_strings.context_newAlbum);
				mList.add(vz_strings.context_sort);

			} else if (view.equals(vz_strings.view_insideAlbum)) {   //update24

				mList.add(vz_strings.context_createPhotoBook);
				//mList.add(vz_strings.context_printAndGifts);
				mList.add(vz_strings.context_select);
				mList.add(vz_strings.context_addPhotoAndVideos);
				mList.add(vz_strings.context_share);
				mList.add(vz_strings.context_rename);
				mList.add(vz_strings.context_deleteAlbum);
				
				

			}
			/**
			 * Contextual menu when NOT selecting in Documents , All Files and Music section
			 */
			else if (view.equals(vz_strings.view_documents) || view.equals(vz_strings.view_allFiles)
					|| (view.equals(vz_strings.view_musicGenres))) {

				mList.add(vz_strings.context_select);
				mList.add(vz_strings.context_sort);

			} else if (view.equals(vz_strings.view_musicAlbums)) {

				mList.add(vz_strings.context_connectToATV);
				mList.add(vz_strings.context_playAll);
				mList.add(vz_strings.context_select);
				mList.add(vz_strings.context_sort);

			} else if (view.equals(vz_strings.view_musicArtists) || view.equals(vz_strings.view_musicSongs)
					|| view.equals(vz_strings.view_insideMusicGenre)) {

				mList.add(vz_strings.context_select);
				mList.add(vz_strings.context_sort);

			} else if (view.equals(vz_strings.view_musicPlaylists)) {

				mList.add(vz_strings.context_connectToATV);
				mList.add(vz_strings.context_select);
				mList.add(vz_strings.context_newPlaylist);

			} else if (view.equals(vz_strings.view_insideMusicPlaylist)) {

				// mList.add(vz_strings.context_connectToATV);
				mList.add(vz_strings.context_playPlaylist);
				mList.add(vz_strings.context_select);
				mList.add(vz_strings.context_deletePlaylist);

			} else if (view.equals(vz_strings.view_musicPlayerFav)) {

				// mList.add(vz_strings.context_connectToATV);
				mList.add(vz_strings.context_playSelected);
				mList.add(vz_strings.context_addToPlaylist);
				mList.add(vz_strings.context_removeFavorite);
				mList.add(vz_strings.context_share);
				mList.add(vz_strings.context_info);
				mList.add(vz_strings.context_delete);
				mList.add(vz_strings.context_makePrivate);

			} else if (view.equals(vz_strings.view_musicPlayer)) {

				// mList.add(vz_strings.context_connectToATV);
				mList.add(vz_strings.context_playSelected);
				mList.add(vz_strings.context_showQueue);
				mList.add(vz_strings.context_addToPlaylist);
				mList.add(vz_strings.context_addFavorite);
				mList.add(vz_strings.context_share);
				mList.add(vz_strings.context_info);
				mList.add(vz_strings.context_delete);

			} else if (view.equals(vz_strings.view_musicPlayerQueue)) {

				// mList.add(vz_strings.context_connectToATV);
				mList.add(vz_strings.context_select);
			} else if (view.equals(vz_strings.view_Flashbacks)) {

				mList.add(vz_strings.context_createStory);
				mList.add(vz_strings.context_createcollage);
				mList.add(vz_strings.context_download);
				mList.add(vz_strings.context_addToAlbum);
				mList.add(vz_strings.context_addFavorite);
				mList.add(vz_strings.context_share);

				mList.add(vz_strings.context_delete);

			}
		}
		return mList;
	}

	public boolean verifyOptions(vz_strings.DataType dataType, String view, boolean multiSelect) throws Exception {

		List<String> list = displayList(dataType, view);
		/**
		 * When tv icon is visible then no connect to tv CM entry When tv icon not
		 * visible then connect to tv CM entry present
		 */
		if (baseControlsHelper.getCountById(vz_strings.button_tvListIcon) > 0) {
			list.remove(vz_strings.context_connectToATV);
		}

		if (multiSelect) {
			list.remove(vz_strings.context_info);
		}

		boolean isDisplayed = false;
		for (int i = 0; i < list.size(); i++) {
			isDisplayed = baseControlsHelper.getCountById(list.get(i)) > 0;
			if (!isDisplayed) {
				if (list.get(i).contentEquals(vz_strings.context_addFavorite)) {

					/**
					 * Add to favorite/Remove from favorite option will not be displayed in
					 * All/Timeline/Albums view If the item is already favorited. Remove from
					 * favorite option can only be seen in Favorite view or Full image view.
					 */

					if (view.equals(vz_strings.view_photoFull) || view.equals(vz_strings.view_videoFull)
							|| view.equals(vz_strings.view_musicSongs) || view.equals(vz_strings.view_insideMusicGenres)
							|| view.equals(vz_strings.view_documents)) {
						isDisplayed = baseControlsHelper.getCountById(vz_strings.context_removeFavorite) != 0;
					} else {
						isDisplayed = baseControlsHelper.getCountById(vz_strings.context_removeFavorite) == 0;
					}
					if (!isDisplayed) {
						System.out.println(list.get(i) + " is missing");
						break;
					}
				} else {
					System.out.println(list.get(i) + " is missing");
					break;
				}
			}
		}
		return isDisplayed;
	}
}