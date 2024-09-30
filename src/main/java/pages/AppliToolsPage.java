package pages;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.visualgrid.model.ChromeEmulationInfo;
import com.applitools.eyes.visualgrid.model.DesktopBrowserInfo;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.RunnerOptions;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppliToolsPage {

    private final WebDriver webDriver;
    private Eyes eyes;

    private static final BatchInfo BATCH = new BatchInfo("Applitools Visual Test Batch");

    private static final By APPLITOOLS_SELECTORS = By.cssSelector("NA");

    public AppliToolsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Initializes Applitools Eyes for visual testing.
     */
    public void initializeEyes() {
        EyesRunner runner = new VisualGridRunner(new RunnerOptions().testConcurrency(5));
        eyes = new Eyes(runner);

        Configuration config = new Configuration();
        config.setApiKey(System.getenv("dl7o1pGptpnR1ghCTxu5yp9W37wcQgR4vHPB5GqmbJ0110"));
        config.setBatch(BATCH);

        config.addBrowsers(
                new DesktopBrowserInfo(1600, 1200, BrowserType.CHROME),
                new ChromeEmulationInfo(DeviceName.Pixel_2, ScreenOrientation.PORTRAIT),
                new ChromeEmulationInfo(DeviceName.Nexus_10, ScreenOrientation.LANDSCAPE)
        );

        eyes.setConfiguration(config);
    }

    /**
     * Starts an Applitools visual test.
     */
    public void startVisualTest(String appName, String testName, int width, int height) {
        if (eyes == null) {
            throw new IllegalStateException("Eyes not initialized. Call initializeEyes() first.");
        }
        eyes.open(webDriver, appName, testName, new RectangleSize(width, height));
    }

    /**
     * Ends the Applitools visual test and closes Eyes.
     */
    public void endVisualTest() {
        if (eyes != null) {
            eyes.closeAsync();
        }
    }

    public void checkPage(String name) {
        if (eyes != null) {
            eyes.checkWindow(name);
        } else {
            throw new IllegalStateException("Eyes not initialized. Call initializeEyes() first.");
        }
    }

}
