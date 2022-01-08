package TestCase;

import Core.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Set;

public class PopupWindow_Demo extends BaseTest {
    @Test
    public void PopupWindow_Demo() throws InterruptedException {

        driver.get("http://demo.guru99.com/popup.php");
        driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();
        Thread.sleep(2000);
        String MainWindow = driver.getWindowHandle();
        System.out.println(MainWindow);

        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println(windowHandles);

//        ArrayList<String> window = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(window.get(1));

        for (String window:windowHandles) {
            if(!MainWindow.equalsIgnoreCase(window)){
                driver.switchTo().window(window);
                driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("hieu@gmail.com");
                Thread.sleep(2000);
                driver.switchTo().window(MainWindow);
                System.out.println(driver.findElement(By.xpath("//h2[normalize-space()='Guru99 Bank']")).getText());

            }
        }

    }
}
