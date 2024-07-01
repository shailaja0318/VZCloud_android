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
		baseControlsHelper.openContext(vz_strings.context_createcollage);
		TestCase.assertTrue("Title missing",
				baseControlsHelper.getCountById(vz_strings.text_unsupportedMediaTitle) != 0);
		Thread.sleep(2000);
		baseControlsHelper.clickOn(vz_strings.button_ok);
	}
}
