//package DataDrivenDesting_Demo;
//
//import MainClass.Init;
//import org.testng.annotations.Test;
//
//public class ProjectTest extends Init {
//
//    @Test
//    public void signInPage() throws Exception {
//
//        // Setup đường dẫn của file excel
//        excel.setExcelFile("src/test/resources/Book1.xlsx", "Sheet1");
//
//        signInPage = new signInPage(driver);
//        driver.get("https://crm.anhtester.com");
//
//        // Đọc data từ file excel
//        signInPage.signIn(excel.getCellData("username", 2), excel.getCellData("password", 2));
//
//        //Ghi data vào file excel
//        excel.setCellData("anhtester.com", 5, 0);
//
//        // Chú ý: dòng và cột trong code nó hiểu bắt đầu từ 0
//
//        Thread.sleep(2000);
//    }
//
//}
