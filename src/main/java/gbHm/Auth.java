package gbHm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class Auth
{
    public static void main( String[] args )
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
       //options.addArguments("start-maximized"); // не открывает в полноэкранном режиме
        options.addArguments("--incognito");
        options.addArguments("disable-popup-blocking");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://letyshops.com/");
        String username = "qukuv@mailto.plus";
        String password = "Qw123456";
        String userUrl = "https://letyshops.com/user";

        WebElement btnLogin = driver.findElement(By.cssSelector("div.welcome-module-auth__footer span.welcome-module-auth__link"));
        btnLogin.click();


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement inputUsername = driver.findElement(By.cssSelector(".b-module-auth  input[name=\"_username\"]"));
        WebElement inputPassword = driver.findElement(By.cssSelector(".b-module-auth  input[name=\"_password\"]"));
        WebElement btnAuth = driver.findElement(By.cssSelector(".b-module-auth  button"));

        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        btnAuth.click();

        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains(userUrl));
        } catch (Exception e) {
            System.out.println("Тест не пройден");
        }


        driver.quit();
    }
};