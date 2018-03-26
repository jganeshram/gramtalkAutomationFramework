import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;


public class mobi {

    private AndroidDriver driver;
    public static AppiumDriverLocalService service;
    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appPackage", "com.handleshinges.admin.handleshingesv1");
        desiredCapabilities.setCapability("avd", "Nexus5");
        desiredCapabilities.setCapability("appActivity", "com.handleshinges.admin.handleshingesv1.Splash");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("app", "G:\\Appiumapp\\app.apk");
        desiredCapabilities.setCapability("deviceName", "Nexus5");
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withCapabilities(desiredCapabilities)
                .usingAnyFreePort();
        service = builder.build();
        service.start();
     //   URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(service.getUrl(), desiredCapabilities);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS );

    }

    @Test
    public void sampleTest() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.handleshinges.admin.handleshingesv1:id/IDOORFITTINGS");
        el1.click();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}

