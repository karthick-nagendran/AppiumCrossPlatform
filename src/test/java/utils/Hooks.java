package utils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;

import java.net.MalformedURLException;

public class Hooks extends ConfigDriver {

    String os = System.getProperty("OS");

    @Before
    public void startClient() throws MalformedURLException {
        /* Start the driver based runtime variable "OS', Method implemented in ConfigDriver Class*/
        switch (os) {
            case "iOS":
                startiOSDriver();
                break;
            case "Android":
                startAndroidDriver();
                break;

        }
    }

    @After

    public void closeDriver(Scenario scenario) {
        /* To Take screenshot of failure scenarios*/
        if (scenario.isFailed()) {
            final byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        /*Stop driver*/
        stopDriver();
    }

}
