package TestCase;

import Core.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FrameDemo extends BaseTest {

    @Test
    public void TestFrame() throws InterruptedException {
        driver.get("https://anhtester.com/contact");

        int Frame_total = driver.findElements(By.tagName("iFrame")).size();
        System.out.println(Frame_total);

        Thread.sleep(4000);

        driver.switchTo().frame(0);

        System.out.println(driver.findElement(By.tagName("strong")).getText());

    }
    @Test
    public void FrameFpt(){
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframeResult']")));

        driver.switchTo().parentFrame();

        driver.findElement(By.xpath("//*[@id=\"breadcrumb\"]/ul/li[1]/a")).click();
    }
    @Test
    public void test(){
        driver.get("https://www.w3schools.com/");
    }
}
