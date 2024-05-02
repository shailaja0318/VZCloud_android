/*//IV-4275 step 3 - part 3/5
package com.sncr.verizon.appiumtests.photosandvideos.real;

import com.sncr.verizon.appiumtests.constants.HelperUtilities;
import com.sncr.verizon.appiumtests.constants.vz_strings;
import com.sncr.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

import static com.sncr.verizon.appiumtests.constants.vz_serverConfigs.photoFileName;

public class EditPhotosFullScreenDetailViewFB extends BaseTestClass {
    private final static Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testEditPhotosFullScreenDetailViewFB() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_flashbacks);
        if (photosAndVideosView.isNoFlashBackTextPresent()) {
            logger.info("No flashbacks present on cloud need to create");
            if (Integer.parseInt(searchFile("name:" + photoFileName)) > 0)
                deleteRepoFile(photoFileName);
            precondition.generateFlashBack(HelperUtilities.setArguments(photoFileName), 0, 0, 1);
        } else logger.info("Flashbacks already present on cloud");
        gridView.tapItem(vz_strings.DataType.PHOTO);
        baseControlsHelper.openContext(vz_strings.context_editPhoto);
        String pageTitle = baseControlsHelper.getNameByIndexfromClassName(0, "XCUIElementTypeNavigationBar");
        TestCase.assertTrue("Edit Photo view is not open", pageTitle.equals("Edit Photo"));
    }
}
*/