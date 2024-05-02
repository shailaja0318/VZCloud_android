package com.verizon.appiumtests.photosandvideos.real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CreateCollageMultiselectAlbum extends BaseTestClass {

	//IV-4276 5/5
	@Test
	public void testCreateCollageMultiselectAlbum() throws Exception{

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_albums);
		precondition.deleteAllAlbums();
		createAlbum();
		baseControlsHelper.waitForShow(vz_strings.tab_albums);
		photosAndVideosView.openAlbum();
		baseControlsHelper.waitForContent();
		gridView.tapItemsInMultiSelectMode(2, vz_strings.DataType.PHOTO);
		baseControlsHelper.openContext(vz_strings.context_createcollage);
		baseControlsHelper.waitForShowByPredicate("Collage", "XCUIElementTypeNavigationBar");
		String pageTitle = baseControlsHelper.getNameByIndexfromClassName(0, "XCUIElementTypeNavigationBar");
		//System.out.println(baseControlsHelper.getNameByIndexfromClassName(0, "XCUIElementTypeNavigationBar"));
		TestCase.assertTrue("Create Collage view is not open", pageTitle.equals("Collage"));
	}
	private void createAlbum() throws Exception {
		System.out.println("--Start Preconditions Create Album--");
		if (!photosAndVideosView.ifAnyAlbumExists())
			createAlbumWithMultipleItems(vz_strings.create_newAlbumName);
		System.out.println("--End Preconditions Create Album--");
	}
	private void createAlbumWithMultipleItems(String albumName) throws Exception {
		if (baseControlsHelper.getCountById(vz_strings.button_newAlbum) > 0)
			baseControlsHelper.clickOn(vz_strings.button_newAlbum);
		else
			baseControlsHelper.openContext(vz_strings.context_newAlbum);
		baseControlsHelper.setValuetoTextFieldByName(albumName, vz_strings.alertTextField);
		baseControlsHelper.waitForShow(vz_strings.button_addItems);
		baseControlsHelper.clickOn(vz_strings.button_addItems);
		Thread.sleep(2000);
		
		tapItemsInMultiSelectModeUniversal(3, vz_strings.DataType.PHOTO);
		
		baseControlsHelper.waitForShow("Save Album");
		baseControlsHelper.clickOn(vz_strings.button_done);
		baseControlsHelper.waitForDismiss(vz_strings.toast_photoAddtoAlbum);
	}
	public void tapItemsInMultiSelectModeUniversal(int index, vz_strings.DataType DataType) throws Exception {
		String type = gridView.selectDataTypeSwitch(DataType);

		ArrayList<String> list = baseControlsHelper.getListOfAttrLabel(index, type);
		System.out.println(list);
		for (int i = 0; i < index; i++) {
			Thread.sleep(2000);
			baseControlsHelper.clickOnLabelLike(list.get(i).toString());
			//baseControlsHelper.clickOnLabelLike(list.get(i));
			
		}
	}
	
}
