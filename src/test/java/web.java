import jdk.nashorn.internal.objects.annotations.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class web {
    private static ChromeDriverService service;
    private WebDriver driver, edgedriver;
    @BeforeSuite


        public void createAndStartService() throws IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
        System.setProperty("webdriver.edge.driver","D:\\Selenium\\MicrosoftWebDriver.exe");
        //    service = new ChromeDriverService.Builder()
        //            .usingDriverExecutable(new File("D:\\Selenium\\chromedriver_win32\\chromedriver.exe"))
        //            .usingAnyFreePort()
        //            .build();
        //    service.start();
        //    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //    desiredCapabilities.setBrowserName("Chrome");
        //    desiredCapabilities.setPlatform(Platform.WIN10);
        //    driver = new RemoteWebDriver(service.getUrl(), desiredCapabilities);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        edgedriver = new EdgeDriver();
        edgedriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }


public static void action(){

}


    @Test (priority=2)
    public void testChrome(){
        driver.navigate().to("https://www.google.com");
        driver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[2]/a")).click();
        //driver.findElement(By.name("Images")).click();
        driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys("planets icon");
        driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).submit();
    }
    @Test (priority=1)
    public void testEdge(){
        edgedriver.navigate().to("https://www.google.com");
        edgedriver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[2]/a")).click();
        edgedriver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys("planets icon");
        edgedriver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).submit();
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
        edgedriver.quit();
    }
}
