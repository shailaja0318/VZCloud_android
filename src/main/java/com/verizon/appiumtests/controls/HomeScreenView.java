package com.verizon.appiumtests.controls;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.driver.BaseDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Optional;

import java.util.ArrayList;
import java.util.List;

public class HomeScreenView {

    AppiumDriver driver = BaseDriver.getDriver();
    BaseControlsHelper baseControlsHelper = new BaseControlsHelper(driver);

    public HomeScreenView(AppiumDriver driver) throws Exception {
        this.driver = driver;
        loginWithSim("8482304097","intk4097");
        dismissRateUs();
        dismissGotIt();
        dismissCampaign();
    }
    
    public void dismissGotIt() throws Exception {
        if (baseControlsHelper.getCountById(vz_strings.button_gotIt) != 0) {
            System.out.println("Verizon Cloud has detected a Chromecast device near you...");
            baseControlsHelper.clickOn(vz_strings.button_gotIt);
            Thread.sleep(3000);
        }
    }

    public void dismissRateUs() throws Exception {
        if (baseControlsHelper.getCountById(vz_strings.button_rateNoThanks) != 0) {
            System.out.println("Dismiss rate my app");
            baseControlsHelper.clickOn(vz_strings.button_rateNoThanks);
            Thread.sleep(3000);
        }
    }
    
    public void dismissCampaign() throws Exception {
        if (baseControlsHelper.getCountById(vz_strings.view_campaign) != 0) {
            System.out.println("Dismiss the campaign");
            baseControlsHelper.clickOn(vz_strings.button_close);
            Thread.sleep(3000);
        }
    }

    public void navigateTo(String naviOption) throws Exception {
        baseControlsHelper.clickOnClassChain(vz_strings.navi_ClassChain_library); //In 22.11 changing Navi icon to Navi_Library and classchain
        switch (naviOption) {
            case vz_strings.navi_music:
                baseControlsHelper.clickOnNameBeginswithAndType(vz_strings.navi_music,"XCUIElementTypeStaticText");
                baseControlsHelper.waitForDismiss(vz_strings.refresh_music);
                break;
            case vz_strings.navi_Photosandvideos:
                baseControlsHelper.clickOnNameBeginswith(vz_strings.navi_Photosandvideos);
                break;
            case vz_strings.navi_home:
                baseControlsHelper.clickOnClassChain(vz_strings.navi_ClassChain_home);
                break;
            case vz_strings.navi_documents:
                baseControlsHelper.clickOnNameBeginswith(vz_strings.navi_documents);
                break;
            case vz_strings.navi_contacts:
                baseControlsHelper.clickOnNameBeginswith(vz_strings.navi_contacts);
                break;
            case vz_strings.navi_messageCenter:
            	baseControlsHelper.clickOnNameBeginswith(vz_strings.navi_messageCenter);
            	break;
            case vz_strings.navi_printshop:
            	baseControlsHelper.clickOnNameBeginswith(vz_strings.navi_printshop);
            	break;
            default:
                baseControlsHelper.clickOn(naviOption);
        }
    }
    
    public void moreMenu_navigateTo(String naviOption) throws Exception {
        baseControlsHelper.clickOnClassChain(vz_strings.navi_ClassChain_more); //In 22.11 changing Navi icon to Navi_Library and classchain
        switch (naviOption) {
            case vz_strings.more_printsAndGifts:
                baseControlsHelper.clickOn(vz_strings.more_printsAndGifts);
                break;
            case vz_strings.more_referAFriend:
                baseControlsHelper.clickOn(vz_strings.more_referAFriend);
                break;
            case vz_strings.more_freeUpSpace:
                baseControlsHelper.clickOn(vz_strings.more_freeUpSpace);
                break;
            case vz_strings.more_cloudForDesktop:
                baseControlsHelper.clickOn(vz_strings.more_cloudForDesktop);
                break;
            case vz_strings.more_betaLab:
                baseControlsHelper.clickOn(vz_strings.more_betaLab);
                break;
            case vz_strings.more_helpFeedback:
            	baseControlsHelper.clickOn(vz_strings.more_helpFeedback);
            	break;
            case vz_strings.more_accountContentTools:
            	baseControlsHelper.clickOn(vz_strings.more_accountContentTools);
            	break;
            default:
                baseControlsHelper.clickOn(naviOption);
        }
    }

    public void clickOnStory(String name) throws Exception{
        if (baseControlsHelper.getCountByNameContains(name) > 0) {
            baseControlsHelper.clickOnNameBeginswith(name);
        } else {
            baseControlsHelper.scroll(name, "right");
        }
    }

    public void backToHome() throws Exception {
        while (baseControlsHelper.getCountById(vz_strings.navi_icon) < 1) {
            if (baseControlsHelper.getCountById(vz_strings.navi_back) > 0) {
                baseControlsHelper.clickOn(vz_strings.navi_back);
            } else {
                baseControlsHelper.tapOnBackButton();
            }
        }
        if (baseControlsHelper.getCountById(vz_strings.logs_homeScreen) < 1) {
            baseControlsHelper.clickOn(vz_strings.navi_icon);
            baseControlsHelper.clickOn(vz_strings.navi_home);
        }
    }

    public void fromHomeClickAt(String name) throws Exception {
        int i = 0;
        System.out.println("Appium Helper Clicking from home at " + name);
        while(i <= 2) {
            if (baseControlsHelper.isVisible(name)) {
                baseControlsHelper.clickOn(name);
                break;
            } else {
            	System.out.println("scrolling******");
                baseControlsHelper.scroll(name, "down");
            }i++;
        }
    }

    public void backUp() throws Exception {
        baseControlsHelper.clickOn(vz_strings.button_backUp_InProgress_icon);
        Thread.sleep(2000);
        baseControlsHelper.clickOn(vz_strings.navi_backUpNow);
        baseControlsHelper.waitForShow("Backing up");
        baseControlsHelper.waitForDismiss(vz_strings.progressbar);
        Thread.sleep(2000);
    }

    //Returns the list of items visible from hamburger menu
    public List<String> getMenuItems() throws Exception {
        List<String> menuItems = new ArrayList<>();
        WebElement element = driver.findElement(AppiumBy.className("XCUIElementTypeTable"));
        List<WebElement> element1 = element.findElements(AppiumBy.className("XCUIElementTypeCell"));
        List<WebElement> elements = ((RemoteWebDriver) element1).findElements(AppiumBy.className("XCUIElementTypeCell"));
        elements.forEach(e -> menuItems.add(e.getText()));
        return menuItems;
    }

    public boolean menuOrder(List<String> expectedOrder) throws Exception {
        List<String> menuItems = getMenuItems();
        for(int i=0;i<menuItems.size();i++){

            if(!menuItems.get(i).equals(expectedOrder.get(i))){
                System.out.println("Menu item Found: " + menuItems.get(i) + " Expected: " + expectedOrder.get(i));
                return false;
            }
        }
        return true;
    }

    public void navigateToFuji() throws Exception {
        baseControlsHelper.waitForShow(vz_strings.home_promocode_link);
        baseControlsHelper.clickOn(vz_strings.home_promocode_link);
        baseControlsHelper.waitForShow(vz_strings.button_open);
        if(baseControlsHelper.getCountById(vz_strings.button_open)>0){
            baseControlsHelper.clickOn(vz_strings.button_open);
        }
    }
    
    public void loginWithSim(@Optional("8482304097") String mdn, @Optional("intk4097") String mdnpass) throws Exception {

        if (baseControlsHelper.getCountById(vz_strings.navi_verizonCLoud) != 0) {
           System.out.println("Already logged in");
        } else {
            System.out.println("Provisioning... on Real device");
            Thread.sleep(2000);
            signIn(mdn, mdnpass);
            secretQuestion("intertek");  
            Thread.sleep(5000);
            baseControlsHelper.waitForShow(vz_strings.verizon_cloud);
        }
    }
    
    public void buttonAllow() throws Exception {
        if (baseControlsHelper.getCountById(vz_strings.button_allow) > 0) {
            baseControlsHelper.clickOn(vz_strings.button_allow);
        }
    }

    /**
     * NEW SIGN IN FOR IOS 12
     * */
    public void signUpforVerizonCloud() throws Exception {
        if (baseControlsHelper.getCountById(vz_strings.button_signUpForVerizonCloud) > 0) {
            baseControlsHelper.clickOn(vz_strings.button_signUpForVerizonCloud);
            baseControlsHelper.waitForShow(vz_strings.SamlView.SIGN_IN);
        }
    }

    public void signIn(String mdn, String password) throws Exception {
        buttonAllow();
        signUpforVerizonCloud();

        if (baseControlsHelper.getCountById(vz_strings.SamlView.MOBILE_NUBER) > 0) {
            baseControlsHelper.clickOnType(vz_strings.XCUITypes.XCUI_TEXT_FIELD);
            baseControlsHelper.setValuetoTextFieldByClassChain(mdn, vz_strings.SamlView.CCHAIN_TEXT_FIELD_VALUE);
            baseControlsHelper.clickOnType(vz_strings.XCUITypes.XCUI_SECURE_TEXT_FIELD);
            baseControlsHelper.setValuetoTextFieldByClassChain(password, vz_strings.SamlView.CCHAIN_SECURE_TEXT_FIELD_VALUE);
            baseControlsHelper.clickOnLabelBeginsWithAndType(vz_strings.SamlView.SIGN_IN, vz_strings.XCUITypes.XCUI_BUTTON);
            baseControlsHelper.waitForShow(vz_strings.SamlView.VZ_SECRET);
        }
    }

    public void secretQuestion(String answer) throws Exception {
        if (baseControlsHelper.getCountById(vz_strings.SamlView.VZ_SECRET) > 0) {
            baseControlsHelper.clickOnType(vz_strings.XCUITypes.XCUI_SECURE_TEXT_FIELD);
            Thread.sleep(3000);
            baseControlsHelper.setValuetoTextFieldByName(answer, vz_strings.secret_question);
            baseControlsHelper.clickOnLabelBeginsWithAndType(vz_strings.button_continue, vz_strings.XCUITypes.XCUI_BUTTON);
            baseControlsHelper.waitForShow(vz_strings.verizon_cloud);
            
        }
    }
        
}