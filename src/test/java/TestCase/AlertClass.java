package TestCase;

import Core.BaseTest;

import org.testng.annotations.Test;

import static Page.Element_Guru99.*;


public class AlertClass extends BaseTest {

    @Test
    public void testAlert() {
        driver.get(url_Guru_Alert);
        Input_CustomerId.sendKeys("133");
        driver.findElement(btn_Submit).click();

        //accept_alert
        driver.switchTo().alert().accept();
        //dismiss_alert
        driver.switchTo().alert().dismiss();
        //getText_Alert
        System.out.println(driver.switchTo().alert().getText());

    }

}
