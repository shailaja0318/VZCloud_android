package com.verizon.appiumtests.delete;

public class PhotoDelete {
//
//    ActionHelper helper = new ActionHelper();
//
//    @AfterMethod
//    public void tearDown() throws Exception {
//        helper.tearDown();
//    }
//
//    public void testDeletePhoto() throws Exception {
//
//        helper.setUp();
//
//        Thread.sleep(10000);
//
//        helper.clickOn(vz_strings.navi_icon);
//        helper.clickOn(vz_strings.navi_Photosandvideos);
//        helper.clickOn(vz_strings.tab_all);
//
//        int photos_count = helper.getCountByXpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]//UIACollectionCell");
//
//        if (photos_count > 0) {
//
//            helper.clickOn(vz_strings.context_menu);
//            helper.clickOn(vz_strings.context_select);
//
//            String name="";
//            for (int i=0; i<photos_count; i++) {
//                if (helper.getTextByIndexfromXpath(i, "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]//UIACollectionCell").contains("Photo")) {
//                    name = helper.getTextByIndexfromXpath(i, "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]//UIACollectionCell");
//                    break;
//                }
//            }
//            helper.tapOn(name, 1, 1);
//
//            helper.clickOn(vz_strings.context_menu);
//            helper.clickOn(vz_strings.context_delete);
//            helper.clickOn(vz_strings.button_yes);
//
//            Thread.sleep(7000);
//
//            int photos_count1 = helper.getCountByXpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]//UIACollectionCell");
//            TestCase.assertTrue("Total photo count is not "+String.valueOf(photos_count-1), photos_count==photos_count1+1);
//        } else {
//            Thread.sleep(3000);
//            TestCase.assertTrue("No Photos", false);
//        }
//    }
}