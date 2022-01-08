package TestCase;

import Core.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
public class test extends BaseTest {

    @Test
    public void test1() {
        driver.get("https://anhtester.com/");
        // WebElement CustomerId = driver.findElement(By.xpath("//input[@name='cusid']"));
        //Actions actions = new Actions(driver);
//        JavascriptExecutor JsExe = (JavascriptExecutor) driver;
//        JsExe.executeScript("arguments[0].click();", driver.findElement(btn_DangKiKhoaHoc));

        //driver.findElement(btn_DangKiKhoaHoc).click();

//        actions.moveToElement(driver.findElement(btn_DangKiKhoaHoc)).build().perform();
//        actions.click(driver.findElement(btn_DangKiKhoaHoc)).build().perform();

        //driver.findElement(By.xpath("//a[normalize-space()='contact']")).click();
        System.out.println(  driver.findElement(By.xpath("//*[@id=\"style-7\"]/section[2]/div/div/div[1]/div[4]/a")).isDisplayed());



    }
}
