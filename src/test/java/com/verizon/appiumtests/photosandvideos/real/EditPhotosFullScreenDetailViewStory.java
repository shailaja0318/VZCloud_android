//IV-4275 step 3 - part 4/5
package com.verizon.appiumtests.photosandvideos.real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class EditPhotosFullScreenDetailViewStory extends BaseTestClass {

	@Test
	public void testEditPhotosFullScreenDetailViewStory() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_stories);
		photosAndVideosView.openStory10();
		baseControlsHelper.waitForContent();
		gridView.tapItem(vz_strings.DataType.PHOTO);
		baseControlsHelper.waitForShow(vz_strings.actionBar_EditPhoto);
		baseControlsHelper.clickOn(vz_strings.actionBar_EditPhoto);
		baseControlsHelper.waitForShowByPredicate("Edit Photo", "XCUIElementTypeNavigationBar");
		String pageTitle = baseControlsHelper.getNameByIndexfromClassName(0, "XCUIElementTypeNavigationBar");
		TestCase.assertTrue("Edit Photo view is not open", pageTitle.equals("Edit Photo"));
	}
}
