//IV-4708 steps 1,2,3 part 2/5, 4
package com.verizon.appiumtests.photosandvideos.real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class EditPhotosPVAllMultiSelectSingle extends BaseTestClass {

	@Test
	public void testEditPhotosPVAllMultiSelectSingle() throws Exception{

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_all);
		baseControlsHelper.openContext(vz_strings.context_select);
		gridView.tapItem(vz_strings.DataType.PHOTO);
		baseControlsHelper.waitForShow(vz_strings.actionBar_EditPhoto);
		baseControlsHelper.clickOn(vz_strings.actionBar_EditPhoto);
		baseControlsHelper.waitForShowByPredicate("Edit Photo", "XCUIElementTypeNavigationBar");
		String pageTitle = baseControlsHelper.getNameByIndexfromClassName(0, "XCUIElementTypeNavigationBar");
		TestCase.assertTrue("Edit Photo view is not open", pageTitle.equals("Edit Photo"));
	}
}
