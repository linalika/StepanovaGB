package gbHm.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AuthPO {
    public String url = "https://backit.me/app-auth/ru/auth/cashback";
    public String cssUsername = ".el-input input[type=\"text\"]";
    public String cssPassword = ".el-input input[type=\"password\"]";
    public String cssBtnAuth = "div.buttons button";

    public void getOnPage(WebDriver driver){
        driver.get(this.url);
    }

    public void auth(String username, String password, WebDriver driver){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".el-input input[type=\"text\"]"))));
        WebElement inputUsername = driver.findElement(By.cssSelector(this.cssUsername));
        WebElement inputPassword = driver.findElement(By.cssSelector(this.cssPassword));
        WebElement btnAuth = driver.findElement(By.cssSelector(this.cssBtnAuth));

        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        btnAuth.click();

        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".mu-dropdown--user-menu_desktop .mu-user-card__name"))));
        } catch (Exception e) {
            System.out.println("Тест не пройден");
        }
    }
}
