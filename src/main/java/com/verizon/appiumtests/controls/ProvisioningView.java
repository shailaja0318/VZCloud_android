package com.verizon.appiumtests.controls;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.driver.BaseDriver;
import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;

public class ProvisioningView {
    AppiumDriver driver = BaseDriver.getDriver();
    BaseControlsHelper baseControlsHelper = new BaseControlsHelper(driver);

    public ProvisioningView(AppiumDriver driver) {
        this.driver = driver;
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
            baseControlsHelper.setValuetoTextFieldByName(answer, vz_strings.secret_question);
            baseControlsHelper.clickOnLabelBeginsWithAndType(vz_strings.button_continue, vz_strings.XCUITypes.XCUI_BUTTON);
            baseControlsHelper.waitForShow(vz_strings.SamlView.REQUEST);
        }
    }

    public void requestCode() throws Exception {
        if (baseControlsHelper.getCountById(vz_strings.button_request) != 0) {
            baseControlsHelper.clickOn(vz_strings.button_request);
            baseControlsHelper.waitForShow(vz_strings.SamlView.AUTHORISATION_CODE);
        }
    }

    public void authorisationCode(String code) throws Exception {
        if (baseControlsHelper.getCountByClassName(vz_strings.XCUITypes.XCUI_SECURE_TEXT_FIELD) != 0) {
            baseControlsHelper.clickOnType(vz_strings.XCUITypes.XCUI_SECURE_TEXT_FIELD);
            baseControlsHelper.setValuetoTextFieldByClassChain(code, vz_strings.XCUITypes.XCUI_SECURE_TEXT_FIELD);
            baseControlsHelper.clickOnClassChain(vz_strings.SamlView.CCHAIN_AUTHORISE_BUTTON);
        }
    }
}