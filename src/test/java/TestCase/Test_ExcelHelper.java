package TestCase;

import Core.ExcelHelpers;
import Page.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test_ExcelHelper {

    public WebDriver driver;

    ExcelHelpers excelHelpers;
    Login_Page loginPage;
    @BeforeTest
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        excelHelpers = new ExcelHelpers();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.walmart.com/account/signup");
    }

    @Test
    public void test_ExcelHelper() throws Exception {
        excelHelpers.setExcelFile("D:\\\\TuHoc_Selenium\\\\src\\\\test\\\\resources\\\\TestLogin.xlsx", "Login");

        loginPage = new Login_Page(driver);

       loginPage.login(excelHelpers.getCellData("User name", 1), excelHelpers.getCellData("PassWord", 1), excelHelpers.getCellData("Email", 1));
        //loginPage.login(excelHelpers.getCellData(1, 0), excelHelpers.getCellData(1, 1), excelHelpers.getCellData(1, 2));

    }

    @AfterTest
    public void AfterTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

}
