import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class mweb {

public AndroidDriver driver;
 //   public WebDriver driver;
    public static AppiumDriverLocalService service;
    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("avd", "Nexus5");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "Nexus5");
       //desiredCapabilities.setCapability("deviceName", "HKE6GS5K");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
        desiredCapabilities.setCapability("showChromedriverLog",true);
        desiredCapabilities.setCapability("fastRest",true);
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withCapabilities(desiredCapabilities)
                .usingAnyFreePort();
        service = builder.build();
        service.start();

        driver = new AndroidDriver(service.getUrl(),desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS );

    }

    @Test
    public void sampleTest() {
        driver.get("https://appium.io");
        driver.findElementByClassName("navbar-toggle").click();
        driver.findElementByXPath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[5]/a").click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS );
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
