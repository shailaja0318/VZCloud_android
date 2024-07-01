//IV-4275 step 3 - part 2/5
package com.verizon.appiumtests.photosandvideos.real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class EditPhotosFullScreenDetailViewPVAll extends BaseTestClass {

	@Test
	public void testEditPhotosFullScreenDetailViewPVAll() throws Exception{

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		baseControlsHelper.openContext(vz_strings.context_select);
		gridView.tapItem(vz_strings.DataType.PHOTO);
		baseControlsHelper.openContext(vz_strings.context_editPhoto);
        baseControlsHelper.clickOn(vz_strings.context_editPhoto);
		baseControlsHelper.waitForShowByPredicate("Edit Photo", "XCUIElementTypeNavigationBar");
		String pageTitle = baseControlsHelper.getNameByIndexfromClassName(0, "XCUIElementTypeNavigationBar");
        TestCase.assertEquals("Edit Photo view is not open", "Edit Photo", pageTitle);
	}
}
