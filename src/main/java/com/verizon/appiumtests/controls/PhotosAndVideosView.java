package com.verizon.appiumtests.controls;

import com.verizon.appiumtests.constants.vz_strings;

import com.verizon.appiumtests.driver.BaseDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.opencv.photo.Photo;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;

import java.text.DateFormatSymbols;
import java.time.Month;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PhotosAndVideosView {

    AppiumDriver driver = BaseDriver.getDriver();

    BaseControlsHelper baseControlsHelper = new BaseControlsHelper(driver);
    GridView gridView = new GridView(driver);

    public PhotosAndVideosView(AppiumDriver driver) throws Exception {
        this.driver = driver;
        dismissCampaign();
    }
    public void dismissCampaign() throws Exception {
        if (baseControlsHelper.getCountById(vz_strings.view_campaign) != 0) {
            System.out.println("Dismiss the campaign");
            baseControlsHelper.clickOn(vz_strings.button_close);
            Thread.sleep(3000);
        }
    }
    public void selectTab(String tabName) throws Exception {
    	
    	baseControlsHelper.clickOn(tabName);
		/*
		 * int i = 0; do { i++; baseControlsHelper.clickOn(tabName); } while
		 * (!baseControlsHelper.isSelected(tabName) & i <= 2);
		 */
    	
		/*
		 * if (tabName.equals(vz_strings.tab_all) ||
		 * tabName.equals(vz_strings.tab_timeline)) { if
		 * (baseControlsHelper.getCountById(vz_strings.filter_FilteredByPhotos) > 0 ||
		 * baseControlsHelper.getCountById(vz_strings.filter_FilteredByVideos) > 0 ||
		 * baseControlsHelper.getCountById(vz_strings.filter_FilteredBySavedStories) >
		 * 0) { filterBy(vz_strings.filter_Everything); } }
		 */
    }

    public void playVideo() throws Exception {
        baseControlsHelper.clickOn(vz_strings.button_play);
    }

    public void selectAllAction(String action) throws Exception {
        gridView.clickAllElements();
        Thread.sleep(5000);
        baseControlsHelper.openContext(action);
        if (action.contentEquals(vz_strings.context_delete)) {
            baseControlsHelper.clickOn(vz_strings.button_yes);
            baseControlsHelper.waitForDismiss(vz_strings.toast_itemDeleted);
        } else if (action.contentEquals(vz_strings.context_removeFromAlbum)) {
            baseControlsHelper.clickOn(vz_strings.button_yes);
            baseControlsHelper.waitForShow(vz_strings.empty_albumTitle);
            Thread.sleep(2000);
        }
    }

    public void createAlbum(String albumName) throws Exception {
        if (baseControlsHelper.getCountById(vz_strings.button_newAlbum) > 0)
            baseControlsHelper.clickOn(vz_strings.button_newAlbum);
        else
            baseControlsHelper.openContext(vz_strings.context_newAlbum);
        baseControlsHelper.setValuetoTextFieldByName(albumName, vz_strings.alertTextField);
        baseControlsHelper.clickOn(vz_strings.button_addItems);
        baseControlsHelper.waitForShow("Save Album");
        Thread.sleep(2000);
        gridView.tapMultipleItems(1, vz_strings.DataType.PHOTO);
        baseControlsHelper.clickOn(vz_strings.button_done);
        baseControlsHelper.waitForDismiss(vz_strings.toast_photoAddtoAlbum);
    }

    public void createAlbumWithPhotos(String albumName) throws Exception {
        if (baseControlsHelper.getCountById(vz_strings.button_newAlbum) > 0)
            baseControlsHelper.clickOn(vz_strings.button_newAlbum);
        else
            baseControlsHelper.openContext(vz_strings.context_newAlbum);
        baseControlsHelper.setValuetoTextFieldByName(albumName, vz_strings.alertTextField);
        baseControlsHelper.clickOn(vz_strings.button_addItems);
        baseControlsHelper.waitForShow("Save Album");
        Thread.sleep(2000);
        gridView.tapMultiplePhotoItems(5 );
        baseControlsHelper.clickOn(vz_strings.button_done);
        baseControlsHelper.waitForDismiss(vz_strings.toast_photoAddtoAlbum);
    }

    public void createAlbumWithMultipleItems(String albumName) throws Exception {
        if (baseControlsHelper.getCountById(vz_strings.button_newAlbum) > 0)
            baseControlsHelper.clickOn(vz_strings.button_newAlbum);
        else
            baseControlsHelper.openContext(vz_strings.context_newAlbum);
        baseControlsHelper.setValuetoTextFieldByName(albumName, vz_strings.alertTextField);
        baseControlsHelper.clickOn(vz_strings.button_addItems);
        baseControlsHelper.waitForShow("Save Album");
        baseControlsHelper.clickOnElementByXpath(vz_strings.name_photo);
        baseControlsHelper.clickOn(vz_strings.button_done);
        baseControlsHelper.waitForDismiss(vz_strings.toast_photoAddtoAlbum);
    }

    public void cancelDownload() throws Exception {
        if (baseControlsHelper.getCountById(vz_strings.progressbar) > 0) {
            baseControlsHelper.clickOn(vz_strings.cancel_progressbar);
            baseControlsHelper.clickOn(vz_strings.button_yes);
            baseControlsHelper.waitForDismiss(vz_strings.progressbar);
        }
    }

    public void checkDownload() throws Exception {
        for (int i = 0; i < 120; i++) {
            Thread.sleep(1000);
            if (baseControlsHelper.getCountById(vz_strings.progressbar) < 1) {
                break;
            }
        }
        cancelDownload();
    }

    public void createAlbumByDataType(vz_strings.DataType DataType, String AlbumName) throws Exception {
        if (!ifAnyAlbumExists()) {
            gridView.tapItemInSelectMode(DataType);
            baseControlsHelper.clickOn(vz_strings.actionBar_selectView_AddToAlbum);
            createAlbumFromAllView(AlbumName);
        }
    }

    /**
     * createStory : create a story with each data type from tab all
     */
    public void createStory() throws Exception {
        baseControlsHelper.openContext(vz_strings.context_select);
        gridView.tapItems();
        baseControlsHelper.openContext(vz_strings.context_createStory);
        baseControlsHelper.waitForShow("Edit scenes");
        baseControlsHelper.clickOn(vz_strings.button_saveIt);
        baseControlsHelper.clearValueOnTextfieldByName("rpai_first_text_field");
        baseControlsHelper.setValuetoTextFieldByName("Temporary", "rpai_first_text_field");
        baseControlsHelper.clickOn(vz_strings.button_save);
        baseControlsHelper.waitForContent();
        baseControlsHelper.waitForDismiss(vz_strings.progressbar);
    }

    public void uploadSavedStory() throws Exception {
        baseControlsHelper.clickOn(vz_strings.button_backUp_icon);
        baseControlsHelper.clickOn(vz_strings.navi_backUpNow);
        checkDownload();
    }

    public void downloadSavedStory() throws Exception {
        selectTab(vz_strings.tab_all);
        baseControlsHelper.openContext(vz_strings.context_select);
        baseControlsHelper.clickOn("Saved Story 0");
        baseControlsHelper.openContext(vz_strings.context_download);
        checkDownload();
    }

    public void cancelCreateAlbum(String albumName) throws Exception {
        if (baseControlsHelper.getCountById(vz_strings.no_albumTitle) != 0) {
            baseControlsHelper.clickOn(vz_strings.button_newAlbum);
        } else {
            baseControlsHelper.openContext(vz_strings.context_newAlbum);
        }
        baseControlsHelper.setValuetoTextFieldByName(albumName, vz_strings.alertTextField);
        baseControlsHelper.clickOn(vz_strings.button_addItems);
        Thread.sleep(2000);
        gridView.tapItem(vz_strings.DataType.PHOTO);
        baseControlsHelper.clickOn(vz_strings.button_cancel);
        Thread.sleep(2000);

        baseControlsHelper.clickOn(vz_strings.tab_all);
        baseControlsHelper.clickOn(vz_strings.tab_albums);
    }

    public void addToAlbum10(vz_strings.DataType DataType) throws Exception {
       //baseControlsHelper.swipe("up");
        gridView.tapItemInSelectMode(DataType);
        baseControlsHelper.clickOnElementByXpath(vz_strings.actionBar_AddToAlbum_xpath);
        baseControlsHelper.clickOn(vz_strings.button_addToAlbumPickerOk);
        baseControlsHelper.waitForDismiss(vz_strings.toast_photoAddtoAlbum);
    }

    public void addToNewAlbum10(String albumName) throws Exception {
        gridView.tapFolderInSelectMode10(albumName);
        baseControlsHelper.openContext(vz_strings.context_addToAlbum);
        baseControlsHelper.clickOn(vz_strings.button_pickerNew);
        baseControlsHelper.setValuetoTextFieldByName(albumName, vz_strings.alertTextField);
        baseControlsHelper.clickOn(vz_strings.button_save);
        baseControlsHelper.waitForDismiss(vz_strings.toast_photoAddtoAlbum);
    }

    public void addItemFromAlbum(vz_strings.DataType DataType) throws Exception {
        if (baseControlsHelper.getCountById(vz_strings.button_addPhotosAndVideos) > 0)
            baseControlsHelper.clickOn(vz_strings.button_addPhotosAndVideos);
        else {
            baseControlsHelper.openContext(vz_strings.context_addPhotoAndVideos);
        }
        baseControlsHelper.waitForContent();
        gridView.tapItem(DataType);
        Thread.sleep(3000);
        baseControlsHelper.clickOn(vz_strings.button_done);
        if(baseControlsHelper.isVisible(vz_strings.button_done)){
            baseControlsHelper.clickOn(vz_strings.button_cancel);
        }
        baseControlsHelper.waitForShow(vz_strings.context_menu);
        baseControlsHelper.tapOnBackButton();
    }

    public void addItemsFromAlbum() throws Exception {
        if (baseControlsHelper.getCountById(vz_strings.button_addPhotosAndVideos) > 0)
            baseControlsHelper.clickOn(vz_strings.button_addPhotosAndVideos);
        else {
            baseControlsHelper.clickOn(vz_strings.context_menu);
            baseControlsHelper.clickOn(vz_strings.context_addPhotoAndVideos);
        }
        baseControlsHelper.waitForContent();
        gridView.tapItems();
        baseControlsHelper.clickOn(vz_strings.button_done);
        baseControlsHelper.waitForShow(vz_strings.context_menu);
        baseControlsHelper.tapOnBackButton();
    }

    public void createAlbumFromAllView(String albumName) throws Exception {
        baseControlsHelper.clickOn(vz_strings.button_newAlbum);
        baseControlsHelper.setValuetoTextFieldByName(albumName, vz_strings.alertTextField);
        baseControlsHelper.clickOn(vz_strings.button_save);
        baseControlsHelper.waitForDismiss(vz_strings.toast_photoAddtoAlbum);
    }

    public void selectFavoriteAlbum() throws Exception {
        selectTab(vz_strings.tab_albums);
        baseControlsHelper.clickOn(vz_strings.photoFavoriteAlbum);
    }

    /**
     * this will open first album under Albums
     */
    public void openAlbum() throws Exception {
        selectTab(vz_strings.tab_albums);
        baseControlsHelper.waitForContent();
        baseControlsHelper.clickOn(vz_strings.photo_video_album + " 0");
        baseControlsHelper.waitForDismiss(vz_strings.tab_albums);
        baseControlsHelper.waitForContent();
        dismissCampaign();
    }

    public void openStory10() throws Exception {
        baseControlsHelper.clickOnNameBeginswith("Story-0");
    }

    public void openMonth10(String timeline) throws Exception {
        selectTab(vz_strings.tab_timeline);
        baseControlsHelper.clickOnLabelBeginswith(timeline);
    }

    public boolean isFavoriteAlbumExisted() throws Exception {
    	return baseControlsHelper.getCountById(vz_strings.no_favoriteTitle) == 0;
    }

    public boolean ifAnyAlbumExists() throws Exception {
        return baseControlsHelper.getCountByNameLike(vz_strings.photo_video_album) > 0;
    }

 /*   public int getAlbumCountAPI() throws Exception {
        *//** Only checking at the first album since automation only working with the first album at this moment *//*
        VZServerRequests vzServerRequests = new VZServerRequests();
        return vzServerRequests.getPlaylistCount(vz_strings.DataType.PHOTO);
    }
*/
 /*   public boolean isAlbumExisted() throws Exception {
        return getAlbumCountAPI() > 0;
    }*/

    /*public int getCountInAlbumAPI() throws Exception {
        *//** Only checking at the first album since automation only working with the first album at this moment *//*
        VZServerRequests vzServerRequests = new VZServerRequests();
        return vzServerRequests.getItemCountInPlaylist(vz_strings.DataType.PHOTO);
    }*/

  /*  public boolean isAlbumEmptyAPI() throws Exception {
        return getCountInAlbumAPI() < 1;
    }*/

    private final List<String> sortOptions = Arrays.asList(
            vz_strings.sort_dateUploaded,
            vz_strings.sort_dateTaken);

    public void sortBy(String option) throws Exception {
        baseControlsHelper.openContext(vz_strings.context_sort);
        String current = baseControlsHelper.getTextByType("XCUIElementTypePicker");
        int currentIndex = 0;
        int targetIndex = 0;
        if (sortOptions.contains(option)) {
            for (int i = 0; i < sortOptions.size(); i++) {
                if (sortOptions.get(i).contentEquals(current)) {
                    currentIndex = i;
                    break;
                }
            }
            for (int i = 0; i < sortOptions.size(); i++) {
                if (sortOptions.get(i).contentEquals(option)) {
                    targetIndex = i;
                    break;
                }
            }
            if (targetIndex > currentIndex) {
                for (int i = 0; i < (targetIndex - currentIndex); i++) {
                    baseControlsHelper.clickOn(vz_strings.button_prev);
                }
            } else if (targetIndex < currentIndex) {
                for (int i = 0; i < (currentIndex - targetIndex); i++) {
                    baseControlsHelper.clickOn(vz_strings.button_next);
                }
            }
            baseControlsHelper.clickOn(vz_strings.button_ok);
            Thread.sleep(10000);
        }
    }

	/*
	 * public void uploadPhoto() throws Exception { VZServerRequests
	 * vzServerRequests = new VZServerRequests();
	 * vzServerRequests.uploadFile(DataType.PHOTO); }
	 * 
	 * public void createAlbumViaServerCall(String playlistName, String
	 * playlistTypes, String fileName) throws Exception { if (!getFile()) {
	 * uploadPhoto(); } VZServerRequests vzServerRequests = new VZServerRequests();
	 * vzServerRequests.createPlaylist(playlistName, playlistTypes, fileName); }
	 * 
	 * public boolean getFile() throws Exception { VZServerRequests vzServerRequests
	 * = new VZServerRequests(); String response = vzServerRequests.getFile();
	 * boolean fileExists = response.contains(vz_serverConfigs.photoFileName);
	 * boolean fileTrashed = response.contains("purgePath"); return fileExists &&
	 * !fileTrashed; }
	 */

    public void accessPrintShopFromIcon() throws Exception {
        baseControlsHelper.openContext(vz_strings.context_select);
        Thread.sleep(3000);
        gridView.tapItemInSelectMode(vz_strings.DataType.PHOTO);//failing at this step
        baseControlsHelper.openContext(vz_strings.context_printAndGifts);
        baseControlsHelper.waitForDismiss(vz_strings.spinner);
        if (baseControlsHelper.getCountById(vz_strings.button_acceptContinue) != 0)
            baseControlsHelper.clickOn(vz_strings.button_acceptContinue);
    }

    public void setPickWheelFilter(String value) throws Exception {
        System.out.println("Appium Helper Select filter for " + value);
        baseControlsHelper.openContext(vz_strings.context_select);
        baseControlsHelper.setPickerValue(value);
    }
    
    public void sortAndFilter(String value) throws Exception {
        System.out.println("Appium Helper Select filter for " + value);
        baseControlsHelper.openContext(vz_strings.context_sortAndFilter);
        baseControlsHelper.setPickerValue(value);
    }
  
    public void filterBy(String filterOption) throws Exception{
		baseControlsHelper.openContext(vz_strings.context_sortAndFilter);
        System.out.println(baseControlsHelper.getCountByXpath(vz_strings.filter_unselectedRadioButton));
		if(filterOption.equals(vz_strings.filterByPhotos)) {
            if(baseControlsHelper.getCountByXpath(vz_strings.filter_unselectedRadioButton) ==0) {
                System.out.println("Filter By Photos");
                baseControlsHelper.clickOnElementByXpath(vz_strings.filterByVideos);
                baseControlsHelper.clickOnElementByXpath(vz_strings.filterBySavedStories);
            }else {
                baseControlsHelper.clickOnLabelBeginsWithAndType
                        (vz_strings.filter_selectAll,"XCUIElementTypeButton");
                baseControlsHelper.clickOnElementByXpath(vz_strings.filterByVideos);
                baseControlsHelper.clickOnElementByXpath(vz_strings.filterBySavedStories);
            }
		}
		else if(filterOption.equals(vz_strings.filterByVideos )){
                if(baseControlsHelper.getCountByXpath(vz_strings.filter_unselectedRadioButton) ==0) {
                 //   baseControlsHelper.clickOnElementByXpath(vz_strings.selectAll_filter);
                    System.out.println("Filter By Videos");
                    baseControlsHelper.clickOnElementByXpath(vz_strings.filterByPhotos);
                    baseControlsHelper.clickOnElementByXpath(vz_strings.filterBySavedStories);
                }else {
                    baseControlsHelper.clickOnLabelBeginsWithAndType
                            (vz_strings.filter_selectAll,"XCUIElementTypeButton");
                    System.out.println("Filter By Videos");
                    baseControlsHelper.clickOnElementByXpath(vz_strings.filterByPhotos);
                    baseControlsHelper.clickOnElementByXpath(vz_strings.filterBySavedStories);
                }
		}
		else if(filterOption.equals(vz_strings.filterBySavedStories)) {
            if (baseControlsHelper.getCountByXpath(vz_strings.filter_unselectedRadioButton) == 0) {
                System.out.println("Filter By Saved Stories");
                // baseControlsHelper.clickOnElementByXpath(vz_strings.selectAll_filter);
                baseControlsHelper.clickOnElementByXpath(vz_strings.filterByPhotos);
                baseControlsHelper.clickOnElementByXpath(vz_strings.filterByVideos);
            } else {
                baseControlsHelper.clickOnLabelBeginsWithAndType
                        (vz_strings.filter_selectAll,"XCUIElementTypeButton");
                baseControlsHelper.clickOnElementByXpath(vz_strings.filterByPhotos);
                baseControlsHelper.clickOnElementByXpath(vz_strings.filterByVideos);
            }
        }
		else if(filterOption.equals(vz_strings.filter_Everything)){
			System.out.println("Filter By Everything");
			baseControlsHelper.clickOnLabelBeginsWithAndType
                    (vz_strings.filter_selectAll,"XCUIElementTypeButton");
			Thread.sleep(7000);
		}

		baseControlsHelper.clickOn(vz_strings.button_save);	
	}

    public void sortBy10(String sortOption) throws Exception{
		baseControlsHelper.openContext(vz_strings.context_sortAndFilter);
		baseControlsHelper.clickOnElementByXpath(sortOption);
		baseControlsHelper.clickOn(vz_strings.button_save);	
	}

    public void addToFavAlbum10() throws Exception {
        if (baseControlsHelper.getCountById(vz_strings.view_photoStories) != 0) {
            baseControlsHelper.clickOnLabelBeginswith("Story");
        }
        baseControlsHelper.waitForContent();
        gridView.tapItemsInSelectMode();
        baseControlsHelper.openContext(vz_strings.context_addFavorite);
        baseControlsHelper.waitForDismiss(vz_strings.toast_addtoFavorite);
    }

    public void openInVerizonCloudDialog() throws Exception {
        if (baseControlsHelper.getCountById(vz_strings.button_open) != 0)
            baseControlsHelper.clickOn(vz_strings.button_open);
    }

    /**
     * Zooms the picture element in by the specified amount.
     *
     * @param scale    Float, value between 0.0 and 1.0 zooms out, value of more than 1 zooms in.
     * @param velocity Float, the velocity of the zoom, if (scale < 0), velocity < 0.
     * @author Alen Kalac
     */
    public void pinchZoom(float scale, float velocity) {
        System.out.println("Trying to pinch zoom");
        JavascriptExecutor js = driver;
        Map<String, Object> params = new HashMap<>();
        WebElement element = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeScrollView/**/XCUIElementTypeImage"));
        params.put("scale", scale);
        params.put("velocity", velocity);
        params.put("element", ((Thread) element).getId());
        js.executeScript("mobile: pinch", params);
    }

    /**
     * Pinch Zoom in with scale of 1.3f and velocity of 1.1f
     *
     * @author Alen Kalac
     */
    public void pinchZoomInPhoto() {
        pinchZoom(1.3f, 1.1f);
    }

    public Rectangle getPhotoRect() {
    	WebElement element = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeScrollView/**/XCUIElementTypeImage"));
        Rectangle rect = element.getRect();
        System.out.println("Picture Rect - Width: " + rect.getWidth() + " Height: " + rect.getHeight() + " X: " + rect.getX() + " Y:" + rect.getY());
        return rect;
    }

/*    public void uploadMultipleImages(int num) throws Exception {
        VZServerRequests srv = new VZServerRequests();
        for (int i = 0; i < num; i++)
            srv.uploadFile(DataType.PHOTO, "Test" + i + ".jpg");
    }*/

    public boolean search(String option) throws Exception {
        String current = null;
        switch (option.toUpperCase()) {
            case "MONTH": {
                String[] months = new DateFormatSymbols().getMonths();
                for (String month : months) {
                    storySearch(month);
                    if (baseControlsHelper.getCountById(vz_strings.emptyText_AllFiles) == 0) {
                        current = baseControlsHelper.getAttrByContainsLabelAndType("Story");
                        if (current.contains(month)) {
                            return true;
                        }
                    }
                    baseControlsHelper.clickOn(vz_strings.clear_text);
                    baseControlsHelper.clickOn(vz_strings.button_cancel);
                }
                break;

            }
            case "YEAR": {
                Calendar cal;
                int[] years = new int[10];
                cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                for (int index = 0; index < years.length; ) {
                    years[index++] = year - index;
                }
                for (int yearcount : years) {
                    String yearvalue = String.valueOf(yearcount);
                    storySearch(yearvalue);
                    if (baseControlsHelper.getCountById(vz_strings.emptyText_AllFiles) == 0) {
                        current = baseControlsHelper.getAttrByContainsLabelAndType("Story");
                        if (current.contains(yearvalue)) {
                            return true;
                        }
                    }
                    baseControlsHelper.clickOn(vz_strings.clear_text);
                    baseControlsHelper.clickOn(vz_strings.button_cancel);
                }
                break;
            }
            case "TITLE": {
                current = baseControlsHelper.getAttrByContainsLabelAndType("Story");
                String[] currentvalue = current.split("-");
                storySearch(currentvalue[2]);
                current = baseControlsHelper.getAttrByContainsLabelAndType("Story");
                if (current.contains(currentvalue[2])) {
                    return true;
                }
                break;
            }
        }
        return false;
    }

    public void clickPrintsAndGift(String contextinside, String contextoutside) throws Exception {
    	// driver.findElement("-custom", "ai:cart").click();
        if (baseControlsHelper.getCountById(contextoutside) == 0) {
            baseControlsHelper.openContext(contextinside);
        } else {
            baseControlsHelper.clickOn(contextoutside);
        }
        clickIfElementPresent(vz_strings.button_gotIt);
        clickIfElementPresent(vz_strings.button_ok);
    }

    public void createStroytype(vz_strings.DataType dataType, String realstoryname) throws Exception {
        baseControlsHelper.tapOnBackButton();
        selectTab(vz_strings.tab_all);
        gridView.tapItem(dataType);
        baseControlsHelper.openContext(vz_strings.context_createStory);
        baseControlsHelper.waitForShow("Edit scenes");
        baseControlsHelper.clickOn(vz_strings.button_saveIt);
        baseControlsHelper.clearValueOnTextfieldByName("rpai_first_text_field");
        baseControlsHelper.setValuetoTextFieldByName(realstoryname, "rpai_first_text_field");
        baseControlsHelper.clickOn(vz_strings.button_save);
        baseControlsHelper.waitForContent();
        baseControlsHelper.waitForDismiss(vz_strings.progressbar);
        baseControlsHelper.tapOnBackButton();
        openMonth10("Timeline");
    }

    public boolean compareTimelineMonthOrder(String year) throws Exception{
        List<String> monthList = getCollectionOfTimeLineMonthsForYear(year);
        List<Integer> monthNum = covnvertMonthToIntegerMonth(monthList);
        return MonthOrder(monthNum);
    }

    public boolean compareTimelineMonthMediaCount(String month) throws Exception {
        int count = getMediaCountFromTimeLineMonth(month);
        System.out.println("Total Media Count on Timeline Month Label == " + count);
        openMonth10(vz_strings.timelineFolder);
        int count1 = gridView.getAlbumContentCount();
        baseControlsHelper.tapOnBackButton();
        System.out.println("Total Media Count inside Timeline folder is == " + count1);
        if (count == count1) {
            System.out.println("MEDIA COUNT ON TIMELINE MONTH FOLDER IS DISPLAYED CORRECT");
            return true;
        }
        return false;
    }

    public String getMediaCountFromElementName(String element) {
        String p = element.substring(element.lastIndexOf("-"), element.lastIndexOf("items"));
        return p.substring(p.indexOf(' ') + 1);
    }

    public int getMediaCountFromTimeLineMonth(String label) throws Exception{
        String elementName = baseControlsHelper.getAttrByContainsLabelAndType(label);
        System.out.println("element Name is ...." + elementName);
        String media = getMediaCountFromElementName(elementName);
        int mediaCount = Integer.parseInt(media.trim());
        return mediaCount;
    }

    public String numericPattern(String value) throws Exception {
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(value);
        while (matcher.find()) {
            value = matcher.group(1);
        }
        return value;
    }

    public String contentSize(String value) throws Exception {
        double size = Double.parseDouble(numericPattern(value));
        String sizes;
        if (value.contains("KB")) {
            size = size / 1024;
        }
        sizes = Double.toString(size);
        return sizes;
    }

    public String ContentData(int index, vz_strings.DataType DataType) throws Exception {
        String value = getMultiplePhotoSize(index, DataType);
        value = contentSize(value);
        int j;
        char[] s1 = value.toCharArray();
        int dot = value.indexOf('.');
        if (value.startsWith("0")) {
            j = dot + 3;
        } else {
            j = dot + 2;
        }
        char[] s3 = new char[j];
        System.arraycopy(s1, 0, s3, 0, j);
        String contentSize = String.valueOf(s3) + " MB";
        System.out.println("Appium Helper ContentSize Value is " + contentSize);
        return contentSize;
    }

    public String getMultiplePhotoSize(int index, vz_strings.DataType DataType) throws Exception {
        double photo;
        double sum = 0;
        String type = gridView.selectDataTypeSwitch(DataType);
        ArrayList<String> list = baseControlsHelper.getListOfAttrLabel(index, type);
        for (int i = 0; i < index; i++) {
            baseControlsHelper.clickOn(list.get(i));
            baseControlsHelper.openContext(vz_strings.context_info);
            String size1 = baseControlsHelper.infoItems(vz_strings.sort_size);
            photo = Double.parseDouble(contentSize(size1));
            baseControlsHelper.tapOnBackButton();
            baseControlsHelper.tapOnBackButton();
            sum = Double.valueOf(photo + sum);
        }
        String sizes = Double.toString(sum);
        return sizes;
    }

    public boolean isNoFlashBackTextPresent() throws Exception {
        return baseControlsHelper.getCountById(vz_strings.text_NoFlashBacksText) > 0;
    }

    public void clickFlashBackThumnail(int thumbnailIndex, String className) throws Exception {
        baseControlsHelper.clickOnByIndexFromClassName(thumbnailIndex, className);
    }

    public void navigateToOrdersPage() throws Exception {
        clickPrintsAndGift(vz_strings.context_printAndGifts, vz_strings.context_icon_printShop);
        baseControlsHelper.waitForDismiss(vz_strings.spinner);
        baseControlsHelper.clickOn(vz_strings.button_getItDelievred);
        baseControlsHelper.clickOn(vz_strings.printsAndGifts_Prints); 
        baseControlsHelper.waitForShow("4x6 Print");
        baseControlsHelper.clickOn("4x6 Print");
        //baseControlsHelper.waitForShowByClassName("XCUIElementTypeImage");
        //baseControlsHelper.clickOnByIndexFromClassName(0,"XCUIElementTypeImage");
    }

    public void removeAllProductFromCart() throws Exception {
        accessPrintShopFromIcon();
        baseControlsHelper.waitForDismiss(vz_strings.spinner);
            while (baseControlsHelper.getCountById(vz_strings.negative_Icon) > 0) {
                baseControlsHelper.clickOn(vz_strings.negative_Icon);
                baseControlsHelper.clickOn(vz_strings.button_yes);
            }
            baseControlsHelper.tapOnBackButton();
            baseControlsHelper.clickOn(vz_strings.button_yes);
    }

    public void selectAllAddToCartAndEdit() throws Exception {
        navigateToOrdersPage();
        baseControlsHelper.clickOn(vz_strings.photoBucket_PlusOrCrossIcon);
        baseControlsHelper.clickOn(vz_strings.printsAndGifts_selectAll);
        baseControlsHelper.clickOn(vz_strings.photoBucket_PlusOrCrossIcon);
        Thread.sleep(3000);
        baseControlsHelper.clickOn(vz_strings.AddAndContinueToCart);
        baseControlsHelper.waitForShow(vz_strings.printsAndGifts_Edit_Button);
        baseControlsHelper.clickOn(vz_strings.printsAndGifts_Edit_Button);
    }

    public void storySearch(String content) throws Exception {
        if (content != null) {
            baseControlsHelper.setValuetoTextFieldByName(content, vz_strings.view_searchStoriesBar);
        }
    }

    public List<Integer> covnvertMonthToIntegerMonth(List<String> list) {
        System.out.println("****Converting Calendar Months into Month Numbers****");
        List<Integer> list1 = new ArrayList<>();
        int elementData1;
        for (int i = 0; i < list.size(); i++) {
            String element1 = list.get(i);
            elementData1 = getMonthNumber(element1);
            System.out.println(elementData1);
            list1.add(elementData1);
        }
        return list1;
    }

    public String getMonthNameFrom(String element) {
        return element.substring(9, element.lastIndexOf("20"));
    }

    public int getMonthNumber(String monthName) {
        int num = Month.valueOf(monthName.toUpperCase().trim()).getValue();
        return num;
    }

    public boolean MonthOrder(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++)
            if (list.get(i) < list.get(i + 1)) {
                return false;
            }
        System.out.println("TIMELINE MONTHS ARE IN DESENDING ORDER....");
        return true;
    }

    public List<String> getCollectionOfTimeLineMonthsForYear(String label) throws Exception{
        ArrayList<String> collections = new ArrayList<>();
        List<WebElement> mobileElementList = baseControlsHelper.getListByLabelContainsAndType(label, "XCUIElementTypeCell");
        for (int i = 0; i < mobileElementList.size(); i++) {
            collections.add(mobileElementList.get(i).getAttribute("label"));
        }
        for (String obj : collections) {
            System.out.println(obj);
        }
        System.out.println("****Getting Timeline Months from year " + label + "****");
        List<String> list = new ArrayList<>();
        String elementData = "";
        for (int i = 0; i < collections.size(); i++) {
            String element = collections.get(i);
            elementData = getMonthNameFrom(element);
            System.out.println(elementData);
            list.add(elementData);
        }
        return list;
    }

    public void clickOnShareAndCopyShare(String sharetype) throws Exception {
        baseControlsHelper.openContext(sharetype);
        clickIfElementPresent(vz_strings.button_yesRemindMeNextTime);
    }

    public void clickIfElementPresent(String element) throws Exception {
        if (baseControlsHelper.getCountById(element) != 0) {
            baseControlsHelper.clickOn(element);
        }
    }

    public void filterByPhotosSortByUpload() throws Exception {
        HomeScreenView homeScreenView=new HomeScreenView(driver);
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        selectTab(vz_strings.tab_all);
        sortBy(vz_strings.sort_dateUploaded);
        setPickWheelFilter(vz_strings.filter_PhotosOnly);
    }
    public boolean uploadAndFilterLivePhotos(int count) throws Exception {
        Preconditions preconditions=new Preconditions(driver);
        boolean flag=false;
        filterByPhotosSortByUpload();
        if (baseControlsHelper.getCountByNameLike(vz_strings.name_livePhoto_index) < 1) {
            HomeScreenView homeScreenView=new HomeScreenView(driver);
            preconditions.uploadLivePhotos(count);
            homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
            flag = true;
        }
    return flag;
    }
    public boolean uploadLivePhotoAndAddToAlbum() throws Exception {
        boolean flag=false;
        flag = uploadAndFilterLivePhotos(1);
        gridView.tapItemsInMultiSelectModeUniversal(1, vz_strings.DataType.LIVEPHOTO);
        baseControlsHelper.openContext(vz_strings.context_addToAlbum);
        baseControlsHelper.clickOn(vz_strings.button_pickerNew);
        baseControlsHelper.setValuetoTextFieldByName("new album", vz_strings.alertTextField);
        baseControlsHelper.clickOn(vz_strings.button_save);
        baseControlsHelper.waitForDismiss(vz_strings.toast_photoAddtoAlbum);
        selectTab(vz_strings.tab_albums);
        baseControlsHelper.waitForContent();
        openAlbum();
        baseControlsHelper.waitForContent();
        return flag;
    }

    public void addLivePhotoToFavoritesAndPlay() throws Exception {
        baseControlsHelper.clickOnLabelLike(vz_strings.name_livePhoto_index);
        baseControlsHelper.clickOn(vz_strings.actionBar_addToFavorite);
        baseControlsHelper.waitForDismiss(vz_strings.toast_addtoFavorite);
        baseControlsHelper.tapOnBackButton();
        selectFavoriteAlbum();
        baseControlsHelper.clickOnLabelLike(vz_strings.name_livePhoto_index);
        Thread.sleep(1000);
        baseControlsHelper.touchAndHoldOnElement(baseControlsHelper.getLivePhotoElement());
    }

    public void EditAndSavePhotosInPrintsAndGifts(int count) throws Exception {
        HomeScreenView homeScreenView=new HomeScreenView(driver);
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        selectTab(vz_strings.tab_all);
        setPickWheelFilter(vz_strings.filter_PhotosOnly);
        removeAllProductFromCart();
        Thread.sleep(3000);
        gridView.tapItemsInMultiSelectMode(count, vz_strings.DataType.PHOTO);
        navigateToOrdersPage();
        baseControlsHelper.clickOn(vz_strings.photoBucket_PlusOrCrossIcon);
        baseControlsHelper.clickOn(vz_strings.printsAndGifts_selectAll);
        baseControlsHelper.clickOn(vz_strings.photoBucket_PlusOrCrossIcon);
        Thread.sleep(5000);
        WebElement element=driver.findElement(AppiumBy.name("Selected Checkmark"));
        baseControlsHelper.touchAndHoldOnElement(element);
        Thread.sleep(5000);
        baseControlsHelper.clickOnByIndexFromClassName(1, vz_strings.class_Image);
        baseControlsHelper.clickOn(vz_strings.button_save);
        Thread.sleep(3000);
    }
    
    private final List<String> alBumsortOptions = Arrays.asList(
            vz_strings.sort_dateCreateNewtoOld,
            vz_strings.sort_dateCreateOldtoNew,
            vz_strings.sort_AtoZ,
            vz_strings.sort_ZtoA);
    
    public List<String> getAlbumSortOptions() {
    	return this.alBumsortOptions;
    }
    
    public int getTotalPhotosAndVideosCount() throws Exception {
		baseControlsHelper.clickOn(vz_strings.navi_icon);
		baseControlsHelper.waitForShow(vz_strings.navi_Photosandvideos);
		String pvCount = baseControlsHelper.getPhotoVideoCount();
		int count = Integer.parseInt(pvCount.replaceAll(",", ""));
		System.out.println("******** Total Photos and Videos count ********* " +count);
		return count;

    }
}