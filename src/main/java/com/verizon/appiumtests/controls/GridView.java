package com.verizon.appiumtests.controls;


import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.driver.BaseDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridView {
    AppiumDriver driver = BaseDriver.getDriver();
    BaseControlsHelper baseControlsHelper = new BaseControlsHelper(driver);

    public GridView(AppiumDriver driver) {
        this.driver = driver;
    }

    public void tapItems() throws Exception {
        List<String> type = new ArrayList<>();
        type.add("Photo");
        type.add("Video");
        type.add("Live Photos");
        for (String item : type) {
            if (baseControlsHelper.getCountByLabelLike(item) != 0)
                baseControlsHelper.clickOnLabelLike(item);
        }
    }

    public void tapItem(vz_strings.DataType DataType) throws Exception {
       // baseControlsHelper.clickOnNameLike(selectDataTypeSwitch(DataType));
        baseControlsHelper.clickOnElementByXpath(selectDataTypeSwitch(DataType));
        
    }

    public void tapMultipleItems(int index, vz_strings.DataType DataType) throws Exception {
        // baseControlsHelper.clickOnNameLike(selectDataTypeSwitch(DataType));
        try {
            for (int i = 0; i <= index; i++) {
                baseControlsHelper.clickOnElementByXpath(selectDataTypeSwitch(DataType));
            }
        }catch (Exception e){
            System.out.println(index + "Not available");
        }
       // baseControlsHelper.clickOnElementByXpath(selectDataTypeSwitch(DataType));

    }
    public void tapMultipleItemsContext(int index, String name) throws Exception {
        baseControlsHelper.waitForShow(vz_strings.context_menu);
        baseControlsHelper.clickOn(vz_strings.context_menu);
        baseControlsHelper.waitForShow(vz_strings.context_select);
        baseControlsHelper.clickOn(vz_strings.context_select);
        try {
            for (int i = 0; i <= index; i++) {
                baseControlsHelper.clickOnElementByXpath(name);
            }
        }catch (Exception e){
            System.out.println(index + "Not available");
        }


    }

    public void tapMultiplePhotoItems(int index) throws Exception {
        // baseControlsHelper.clickOnNameLike(selectDataTypeSwitch(DataType));
        for (int i = 0; i <= index; i++) {
            try {
                driver.findElement(By.xpath(
                        "//XCUIElementTypeCell[contains(@name,'photoIndex_" + i + "')]")).click();
            } catch (Exception e) {
                System.out.println(i + " Index Not available");
            }
        }
    }
        // baseControlsHelper.clickOnElementByXpath(selectDataTypeSwitch(DataType));



    public void tapItemInSelectMode(vz_strings.DataType DataType) throws Exception {
        baseControlsHelper.clickOn(vz_strings.context_menu);
        baseControlsHelper.clickOn(vz_strings.context_select);
        baseControlsHelper.waitForContent();
        baseControlsHelper.clickOnElementByXpath(selectDataTypeSwitch(DataType));
    }

    public void tapItemInSelectModeByXpath(vz_strings.DataType DataType) throws Exception {
        baseControlsHelper.clickOn(vz_strings.context_menu);
        baseControlsHelper.clickOn(vz_strings.context_select);
        baseControlsHelper.waitForContent();
        baseControlsHelper.clickOnElementByXpath(selectDataTypeSwitch(DataType));
    }

    public String selectDataTypeSwitch(vz_strings.DataType DataType) {
        String type = "";

        switch (DataType) {
            case PHOTO:
                type = vz_strings.name_photo_index;
                break;
            case VIDEO:
                type = vz_strings.name_video;
                break;
            case LIVEPHOTO:
                type = vz_strings.name_livePhoto_index;
                break;
            case STORY:
                type = vz_strings.name_savedStory;
                break;
        }
        System.out.println(type);
        return type;
    }

    public void tapItemsInSelectMode() throws Exception {
        List<String> type = new ArrayList<>();
        type.add("Photo");
        type.add("Video");
        baseControlsHelper.clickOn(vz_strings.context_menu);
        baseControlsHelper.clickOn(vz_strings.context_select);
        for (String item : type) {
            baseControlsHelper.clickOnLabelLike(item);
        }
    }

    /** This method only works where there are only same data type is available*/
    public void tapItemsInMultiSelectMode(int index, vz_strings.DataType DataType) throws Exception {
        String type = selectDataTypeSwitch(DataType);

        baseControlsHelper.clickOn(vz_strings.context_menu);
        baseControlsHelper.clickOn(vz_strings.context_select);
        for (int i = 1; i <= index; i++) {
            baseControlsHelper.clickOnElementByXpath(type );
        }
    }
    public void selectItemsInMultiSelectMode(int index, String name) throws Exception {

        baseControlsHelper.clickOn(vz_strings.context_menu);
        baseControlsHelper.clickOn(vz_strings.context_select);
        for (int i = 1; i <= index; i++) {
            baseControlsHelper.clickOnElementByXpath(name );
        }
    }

    /** This method works when all data types are available
     * This is little slow compared with above method*/
    public void tapItemsInMultiSelectModeUniversal(int index, vz_strings.DataType DataType) throws Exception {
        String type = selectDataTypeSwitch(DataType);

        baseControlsHelper.clickOn(vz_strings.context_menu);
        baseControlsHelper.clickOn(vz_strings.context_select);

        ArrayList<String> list = baseControlsHelper.getListOfAttrLabel(index, type);
        
        for (int i = 0; i <= index; i++) {
            baseControlsHelper.clickOnElementByXpath(list.get(i));
        }
    }

    public void tapFolderInSelectMode10(String folderName) throws Exception {
        baseControlsHelper.clickOn(vz_strings.context_menu);
        baseControlsHelper.clickOn(vz_strings.context_select);
        baseControlsHelper.clickOn(folderName);
    }

    /**
     * this will open contextual and delete once any data is selected
     * Alex
     */
    public void tapContextDelete() throws Exception {
        baseControlsHelper.clickOn(vz_strings.context_menu);
        baseControlsHelper.clickOn(vz_strings.context_delete);
    }

    public int getAlbumContentCount() throws Exception {
        int livePhotos = baseControlsHelper.getCountByLabelLike("Live Photos");
        int video = baseControlsHelper.getCountByLabelLike("Video");
        int photos  = baseControlsHelper.getCountByLabelLike("Photo");
        return livePhotos + video + photos;
    }

    public int getAlbumCount() throws Exception {
        return baseControlsHelper.getCountByNameLike(vz_strings.photo_video_album);
    }

    public void selectAllAlbums() throws Exception {
        int folders  = baseControlsHelper.getCountByLabelContainsAndType(vz_strings.album_photo_select);
        Thread.sleep(2000);
        baseControlsHelper.openContext(vz_strings.context_select);
        Thread.sleep(2000);
        for (int i = 0; i < folders; i++) {
            baseControlsHelper.clickOn(vz_strings.photo_video_album +" "+i);
        }
    }

    public void longPressAndDrag() throws Exception {
        baseControlsHelper.openContext(vz_strings.context_select);
        System.out.println("Appium Helper Long press ");
        JavascriptExecutor js = driver;

        Point collectionViewPointfe = baseControlsHelper.firstElement().getLocation();
        int fromy = collectionViewPointfe.getY();
        int fromx = collectionViewPointfe.getX();

        Map<String, Object> params = new HashMap<>();
        params.put("duration", 1.0);
        params.put("fromX", fromx);
        params.put("fromY", fromy);
        params.put("toX", fromx);
        //this will be like first three rows
        params.put("toY", 400);
        params.put("name", baseControlsHelper.firstElement());
        js.executeScript("mobile: dragFromToForDuration", params);
    }

    public void clickAllElements() throws Exception{
        baseControlsHelper.openContext(vz_strings.context_select);
        ArrayList<String> list = baseControlsHelper.getAllAlbumElementsInGrid();
        for (int i = 0; i < list.size(); i++) {
           // driver.findElementByAccessibilityId(list.get(i)).click();
            driver.findElement(MobileBy.iOSNsPredicateString("wdLabel CONTAINS '" + list.get(i) + "'")).click();
        }
    }
}

