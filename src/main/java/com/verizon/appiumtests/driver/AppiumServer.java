package com.verizon.appiumtests.driver;

import com.verizon.appiumtests.constants.vz_strings;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.net.URL;

public class AppiumServer {

    private static AppiumDriverLocalService appiumDriverLocalService;
    private final static Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    public static void buildAppiumService() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withIPAddress(vz_strings.Vz_configs.APPIUM_IP)
                .usingPort(vz_strings.Vz_configs.APPIUM_PORT)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        appiumDriverLocalService = appiumDriverLocalService.buildService(builder);
    }

    public static void startAppiumServer() throws Exception {
        if (appiumDriverLocalService != null) {
            appiumDriverLocalService.start();
            logger.info("Server Status : " + appiumDriverLocalService.isRunning());
        }
    }

    public static void stopAppiumServer() {
        if (appiumDriverLocalService != null) {
            appiumDriverLocalService.stop();
            logger.info("Server Status : " + appiumDriverLocalService.isRunning());
        }
    }

    public static URL getServiceURL() {
        return appiumDriverLocalService.getUrl();
    }
}
