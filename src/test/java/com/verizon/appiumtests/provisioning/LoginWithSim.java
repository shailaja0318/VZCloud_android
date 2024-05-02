package com.verizon.appiumtests.provisioning;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * This test case assumes that we have cert already accepted and phone has valid verizon sim.
 */

public class LoginWithSim extends BaseTestClass {


    @Parameters({"mdn", "mdnpass"})
    @Test
    public void testLoginWithSim(@Optional("8482304099") String mdn, @Optional("Intk4099") String mdnpass) throws Exception {

        if (baseControlsHelper.getCountById(vz_strings.navi_icon) != 0) {
            System.out.println("Already logged in");
        } else {
            System.out.println("Provisioning... on Real device");
            provisioningView.buttonAllow();
           // BaseDriver.runAppInBackground(-1);
            //nativeIosAppsView.deleteAllSMS();
            Thread.sleep(2000);
            //BaseDriver.activateApp(vz_strings.BundleIds.VZ_ID);
            provisioningView.signUpforVerizonCloud();
            provisioningView.signIn(mdn, mdnpass);
            provisioningView.secretQuestion("intertek");
           // provisioningView.requestCode();
            Thread.sleep(5000);
           // BaseDriver.runAppInBackground(-1);
            //String code = nativeIosAppsView.getCodeFromSMS();
            //Thread.sleep(5000);
            
            //BaseDriver.activateApp(vz_strings.BundleIds.VZ_ID);
            //provisioningView.authorisationCode(code);

            baseControlsHelper.waitForShow(vz_strings.toast_cloudPerformance);
            baseControlsHelper.waitForDismiss(vz_strings.toast_cloudPerformance);
        }
    }
}

