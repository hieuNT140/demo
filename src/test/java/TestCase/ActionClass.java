//package TestCase;
//
//import MainClass.Init;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.Test;
//
//import static Page.Element_AnhTester.Home.*;
//
//
//public class ActionClass extends Init {
//
//    @Test
//    public void testActionsClass() {
//        driver.get(url_AnhTestter);
//        driver.manage().window().maximize();
//        Actions action = new Actions(driver);
//
//        //moveToElement
//        action.moveToElement(driver.findElement(btn_DangKiKhoaHoc)).build().perform();
//
//        //clickAndHold
//        action.clickAndHold().moveToElement(driver.findElement(btn_TatCaKhoaHoc)).build().perform();
//
//        //dragAndDrop
//        action.dragAndDrop(driver.findElement(txt_Title), driver.findElement(btn_TatCaKhoaHoc));
//
//        //SendKeys
//        action.sendKeys(driver.findElement(input_Search), "Hieu", " K", " A").sendKeys(Keys.ENTER).build().perform();
//
//    }
//
//}
