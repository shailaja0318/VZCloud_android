package com.verizon.appiumtests.photosandvideos;

/**
 * https://jira.synchronoss.net:8443/jira/browse/IV-284
 *
 * @author Alen Kalac
 */

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.openqa.selenium.Rectangle;
import org.testng.annotations.Test;

public class PhotoPinchZoom extends BaseTestClass {

    @Test
    public void testPhotoPinchZoom() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);

        gridView.tapItem(vz_strings.DataType.PHOTO);
        Rectangle beforeRect = photosAndVideosView.getPhotoRect();
        photosAndVideosView.pinchZoomInPhoto();
        Thread.sleep(2000);
        Rectangle afterRect = photosAndVideosView.getPhotoRect();
        boolean heightCheck = afterRect.getHeight() > beforeRect.getHeight();
        boolean widthCheck = afterRect.getWidth() > beforeRect.getWidth();
        TestCase.assertTrue("Picture Zoom Fail: ", heightCheck && widthCheck);

    }

}
