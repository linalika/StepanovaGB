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

public class AddCouponFavorite extends AuthPO {
    public static void main( String[] args )
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("start-maximized"); // не открывает в полноэкранном режиме
        options.addArguments("--incognito");
        options.addArguments("disable-popup-blocking");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://backit.me/app-auth/ru/auth/cashback");
        String username = "ohecf@mailto.plus";
        String password = "Qw123456";
        AuthPO po = new AuthPO();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        po.auth(username,password,driver);

        WebElement goCoupons = driver.findElement(By.cssSelector(".mu-header a[href=\"/ru/promocodes\"]"));
        goCoupons.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("https://backit.me/ru/promocodes"));

        WebElement searchPromocode = driver.findElement(By.cssSelector(".coupons__search-block .search-input-lg input"));
        searchPromocode.sendKeys("aliexpress");
        WebElement searchSuggestion = driver.findElement(By.cssSelector(".el-autocomplete-suggestion__list li span"));
        searchSuggestion.click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains("https://backit.me/ru/promocodes/ali"));
        driver.navigate().refresh();
        WebElement couponFav = driver.findElement(By.cssSelector(".coupons-list article:nth-child(1) span.bookmark svg"));
        WebElement coupon = driver.findElement(By.cssSelector(".coupons-list article:nth-child(1) span.bookmark"));
        coupon.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.attributeContains(couponFav, "data-prefix", "fas"));

        driver.quit();
    }

}
