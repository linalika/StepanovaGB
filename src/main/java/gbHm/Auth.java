package gbHm;

import gbHm.PO.AuthPO;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Hello world!
 *
 */
public class Auth extends AuthPO
{
    public static void main( String[] args )
    {
        String username = "ohecf@mailto.plus";
        String password = "Qw123456";

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
       //options.addArguments("start-maximized"); // не открывает в полноэкранном режиме
        options.addArguments("--incognito");
        options.addArguments("disable-popup-blocking");

        AuthPO po = new AuthPO();

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        po.getOnPage(driver);
        po.auth(username,password,driver);

        driver.quit();
    }


};