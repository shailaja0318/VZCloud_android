package com.verizon.appiumtests.albums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * https://jira.synchronoss.net:8443/jira/browse/IV-103
 *
 * @author asdr0001
 */
public class RemoveFromAlbumNoCheckDialog extends BaseTestClass {

	@Test
    public void testRemoveFromAlbumNoCheckDialog() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_albums);
		precondition.createAlbum();
        int count = gridView.getAlbumContentCount();
        gridView.tapFolderInSelectMode10(vz_strings.album_photo_select);
        gridView.tapContextDelete();

        TestCase.assertEquals("There is no Delete album Label", vz_strings.dialog_delete_question, baseControlsHelper.getTextById(vz_strings.dialog_delete_question));
        TestCase.assertEquals("Text label does not match", vz_strings.dialog_message_question, baseControlsHelper.getTextById(vz_strings.dialog_message_question));

        baseControlsHelper.clickOn(vz_strings.dialog_no);
        int count1 = gridView.getAlbumCount();
        TestCase.assertTrue("Photo count is increasing", count != count1);

	}

}
