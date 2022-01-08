package TestCase;

import Core.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static Page.Element_AnhTester.Home.btn_ViewProfile;
import static Page.Element_AnhTester.Home.url_AnhTestter;

public class JavascriptExecutorClass extends BaseTest {
    @Test
    public void testJsExe(){
        driver.get(url_AnhTestter);
        JavascriptExecutor JsExe = (JavascriptExecutor) driver;
        JsExe.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(btn_ViewProfile));
        JsExe.executeScript("arguments[0].click();", driver.findElement(btn_ViewProfile));
    }

}
