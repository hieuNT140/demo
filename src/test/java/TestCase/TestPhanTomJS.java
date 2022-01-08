package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestPhanTomJS {

    public static void getDriver()   {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setJavascriptEnabled(true); // not really needed: JS enabled by default

        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                "E:\\Fsoft\\Selenium_Fsoft\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");


        WebDriver driver = new PhantomJSDriver(caps);

        driver.get("https://demo.guru99.com/");

        System.out.println(driver.findElement(By.xpath("//a[normalize-space()='Demo Site']")).getText());

    }


}
