package Page;

import org.openqa.selenium.By;

public class Element_AnhTester {
    public static class Home {
        public static String url_AnhTestter="https://anhtester.com/";
        public static By btn_TatCaKhoaHoc = By.xpath("//a[contains(text(),'Tất Cả Khóa Học')]");
        public static By txt_Title = By.xpath("//a[@class='logo']//img[@alt='Anh Tester Logo']");
        public static By input_Search=By.xpath("//input[@placeholder='Tìm kiếm khóa học . . .']");
        public static By btn_DangKiKhoaHoc=By.xpath("//a[contains(text(),'Đăng ký học')]");
        public static By btn_ViewProfile = By.xpath("//a[normalize-space()='view profile']");
    }

}
