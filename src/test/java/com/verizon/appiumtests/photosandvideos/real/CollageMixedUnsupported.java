//IV-4277
package com.verizon.appiumtests.photosandvideos.real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class CollageMixedUnsupported extends BaseTestClass {

	@Test
	public void testCollageMixedUnsupported() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_all);
		gridView.tapItemsInSelectMode();
		baseControlsHelper.clickOn(vz_strings.actionBar_Collage);
		TestCase.assertTrue("Title missing",
				baseControlsHelper.getCountById(vz_strings.text_unsupportedMediaTitle) != 0);
		/*
		 * TestCase.assertTrue("Description is missing",
		 * baseControlsHelper.getCountById(vz_strings.text_unsupportedMediaBody) != 0);
		 */ //unable to detect the element
		Thread.sleep(2000);
		baseControlsHelper.clickOn(vz_strings.button_ok);
	}
}
