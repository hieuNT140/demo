package TestCase;

import Core.BaseTest;
import Core.ReadExcel;
import Page.Login_Page;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_GetDataExcel extends BaseTest {


    @DataProvider()
    public Object[][] getLoginData() throws IOException {
        // get data on excel
        ReadExcel excel = new ReadExcel();
        Object data [][] = excel.getTestData("D:\\\\TuHoc_Selenium\\\\src\\\\test\\\\resources\\\\TestLogin.xlsx","Login");
        return data;
    }

    @Test(dataProvider = "getLoginData")
    public void loginTest(String userName, String passWord,String email){
        Login_Page loginPage = new Login_Page(getDriver());
        loginPage.login(userName, passWord,email);
    }

}
