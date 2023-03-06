package com.qa.utils;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class CapabilitiesManager {
    TestUtils utils = new TestUtils();

    public DesiredCapabilities getCaps() throws IOException {
        GlobalParams globParam = new GlobalParams();
        Properties props = new PropertyManager().getProps();

        try{
            utils.log().info("Getting capabilities");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, globParam.getPlatformName());
            caps.setCapability(MobileCapabilityType.UDID, globParam.getUDID());
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, globParam.getDeviceName());

            switch (globParam.getPlatformName()) {
                case "Android" -> {
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
                    caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
                    caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
                    caps.setCapability("systemPort", globParam.getSystemPort());
                    caps.setCapability("chromeDriverPort", globParam.getChromeDriverPort());
                    //String androidAppUrl = getClass().getResource(props.getProperty("androidAppLocation")).getFile();
                    String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                            + File.separator + "resources" + File.separator + "apps" + File.separator + "Android-MyDemoAppRN.1.3.0.build-244.apk";
                    utils.log().info("appUrl is " + androidAppUrl);
                    caps.setCapability("app", androidAppUrl);
                }
                case "iOS" -> {
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("iOSAutomationName"));
                    caps.setCapability("bundleId", props.getProperty("iOSBundleId"));
                    caps.setCapability("wdaLocalPort", globParam.getWdaLocalPort());
                    caps.setCapability("webkitDebugProxyPort", globParam.getWebkitDebugProxyPort());
                    //String iOSAppUrl = getClass().getResource(props.getProperty("iOSAppLocation")).getFile();
                    String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                            + File.separator + "resources" + File.separator + "apps" + File.separator + "MyRNDemoApp.app";
                    utils.log().info("appUrl is " + iOSAppUrl);
                    caps.setCapability("app", iOSAppUrl);
                }
            }
            return caps;
        } catch(Exception e){
            e.printStackTrace();
            utils.log().fatal("Failed to load capabilities. ABORT!" + e);
            throw e;
        }
    }
}
