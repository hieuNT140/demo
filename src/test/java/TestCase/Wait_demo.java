package TestCase;

import Core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Wait_demo extends BaseTest {

    @Test
    public void WaitDemo(){
        driver.get("https://anhtester.com/");
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement btn_CvAnhTester = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='CV Anh Tester']")));
        if(btn_CvAnhTester != null){

        }

    }

}
