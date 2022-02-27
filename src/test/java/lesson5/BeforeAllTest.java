package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class BeforeAllTest {
    public String url = "https://backit.me/app-auth/ru/auth/cashback";
    public String cssUsername = ".el-input input[type=\"text\"]";
    public String cssPassword = ".el-input input[type=\"password\"]";
    public String cssBtnAuth = "div.buttons button";
    public String username = "ohecf@mailto.plus";
    public String password = "Qw123456";

    private static WebDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void login() {
        getDriver().get(url);
        Actions login = new Actions(getDriver());

        login.sendKeys(getDriver().findElement(By.cssSelector(cssUsername)),username)
                .click(getDriver().findElement(By.cssSelector(cssPassword)))
                .sendKeys(password)
                .click(getDriver().findElement(By.cssSelector(cssBtnAuth)))
                .build()
                .perform();
    }

    @AfterAll
    static void close(){
        //driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }


}
