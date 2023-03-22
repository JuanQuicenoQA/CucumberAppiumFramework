package com.qa.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.util.HashMap;

public class ServerManager {
    private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();
    TestUtils utils = new TestUtils();

    public AppiumDriverLocalService getServer(){
        return server.get();
    }

    public AppiumDriverLocalService GetAppiumService() {
        GlobalParams params = new GlobalParams();
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withLogFile(new File(params.getPlatformName() + "_"
                        + params.getDeviceName() + File.separator + "Server.log")));
    }

    public void startServer(){
        utils.log().info("Starting Appium server");
        AppiumDriverLocalService server = GetAppiumService();
        server.start();
        if(!server.isRunning()){
            utils.log().fatal("Appium server not started. ABORT!");
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started. ABORT!");
        }
        server.clearOutPutStreams();
        ServerManager.server.set(server);
        utils.log().info("Appium server started");
    }
}
