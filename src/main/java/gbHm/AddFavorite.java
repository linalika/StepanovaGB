package gbHm;

import gbHm.PO.AuthPO;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AddFavorite extends AuthPO{
    public static void main( String[] args )
    {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("start-maximized"); // не открывает в полноэкранном режиме
        options.addArguments("--incognito");
        options.addArguments("disable-popup-blocking");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        AuthPO po = new AuthPO();

        driver.get("https://backit.me/app-auth/ru/auth/cashback");
        String username = "ohecf@mailto.plus";
        String password = "Qw123456";
        String userUrl = "https://backit.me/ru/cashback";
        String shopUrl = "https://backit.me/ru/cashback/shops/mvideo";

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        po.auth(username,password,driver);

        WebElement search = driver.findElement(By.cssSelector(".mu-header__search input"));
        search.sendKeys("мвидео");
        WebElement searchSuggestion = driver.findElement(By.cssSelector(".el-autocomplete-suggestion__list li span"));
        searchSuggestion.click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains(shopUrl));

        WebElement likeShop = driver.findElement(By.cssSelector("button.shop-like"));
        likeShop.click();
        new WebDriverWait(driver, 7).until(ExpectedConditions.attributeContains(driver.findElement(By.cssSelector("button.shop-like svg")),"class","mu-like-button__icon_active"));


        driver.quit();

    }
}
