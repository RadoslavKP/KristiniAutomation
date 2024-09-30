package modules;

import pages.AppliToolsPage;

public class AppliToolsModule {
    private AppliToolsPage appliToolsPage;

    public AppliToolsModule(AppliToolsPage appliToolsPage) {
        this.appliToolsPage = appliToolsPage;
    }


    public void connectToAppliTools() {
        appliToolsPage.initializeEyes();
    }

    public void dissconectFromAppliTools() {
        appliToolsPage.endVisualTest();
    }

    public void startVisualTest(String appName, String testName,int width, int height) {
        appliToolsPage.startVisualTest(appName, testName, width, height);
    }

}
