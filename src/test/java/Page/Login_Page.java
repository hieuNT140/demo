package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Page {
    WebDriver driver;
    WebDriverWait wait;
    Login_Element testPOM;

    public Login_Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public void login(String user, String pass, String name) {
/*        wait.until(ExpectedConditions.visibilityOfElementLocated(testPOM.usernameWalmart)).sendKeys(user);
        wait.until(ExpectedConditions.visibilityOfElementLocated(testPOM.passwordWalmart)).sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(testPOM.btnLoginWalmart)).click();

        wait.until((ExpectedConditions.visibilityOfElementLocated(testPOM.usernameWalmart))).clear();
        wait.until((ExpectedConditions.visibilityOfElementLocated(testPOM.usernameWalmart))).sendKeys(user);*/


        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(testPOM.usernameWalmart));
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(testPOM.passwordWalmart));
        WebElement btnLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(testPOM.btnLoginWalmart));
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(testPOM.input_email));

        username.clear();
        username.sendKeys(user);
        password.clear();
        password.sendKeys(pass);
        btnLogin.click();
        email.clear();
        email.sendKeys(name);

    }


}
