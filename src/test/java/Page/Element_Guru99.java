package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public  class Element_Guru99 {

   public final static String url_Guru_Alert= "https://demo.guru99.com/test/delete_customer.php";
   public final static By  userName =  By.xpath("//input[@name='uid']");
   public final static By passWord = By.xpath("//input[@name='password']");
   public final static By btn_Login = By.xpath("//input[@name='btnLogin']");
   public final static By text_Title = By.xpath("//a[normalize-space()='Demo Site']");
   //public final static By Input_CustomerId=By.xpath("//input[@name='cusid']");
   @FindBy(xpath = "//input[@name='cusid']") public static WebElement Input_CustomerId;
   public final static By btn_Submit=By.xpath("//input[@name='submit']");
}
