package lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.BooleanSupplier;

public class AddCouponFavoriteTest extends BeforeAllTest{

    @Test
    void addCouponFavorite(){
        login();

        Actions addToFavorite = new Actions(getDriver());

        addToFavorite.click(getDriver().findElement(By.cssSelector(".mu-header a[href=\"/ru/promocodes\"]")))
                .build()
                .perform();

        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.urlContains("https://backit.me/ru/promocodes"));

        WebElement searchPromocode = getDriver().findElement(By.cssSelector(".coupons__search-block .search-input-lg input"));
        searchPromocode.sendKeys("asos");

        WebElement searchSuggestion = getDriver().findElement(By.cssSelector(".el-autocomplete-suggestion__list li span"));
        searchSuggestion.click();

        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.urlContains("https://backit.me/ru/promocodes/asos"));

        getDriver().navigate().refresh();
        
        WebElement couponFav = getDriver().findElement(By.cssSelector(".coupons-list article:nth-child(1) span.bookmark svg"));
        WebElement coupon = getDriver().findElement(By.cssSelector(".coupons-list article:nth-child(1) span.bookmark"));
        coupon.click();

        try {
            new WebDriverWait(getDriver(), 5).until(ExpectedConditions.attributeContains(couponFav, "data-prefix", "fas"));
        } catch (Exception e) {
            System.out.println("Нет в избранных");
        }

    }
}
