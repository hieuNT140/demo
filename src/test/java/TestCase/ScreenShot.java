package TestCase;

import Core.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static Page.Element_AnhTester.Home.url_AnhTestter;

public class ScreenShot extends BaseTest {
    @Test
    public void testScreenShot() throws IOException, InterruptedException {
        driver.get(url_AnhTestter);

        driver.manage().window().maximize();
        Thread.sleep(2000);
        File fileScreen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(fileScreen, new File("D:\\TuHoc_Selenium\\src\\test\\java\\Day1\\" + "Scren" + ".jpg"));


    }
}
