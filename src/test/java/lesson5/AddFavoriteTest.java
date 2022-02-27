package lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.BooleanSupplier;

public class AddFavoriteTest extends BeforeAllTest {
    String shopUrl = "https://backit.me/ru/cashback/shops/ali";
    String shopName = "aliexpress";
    String searchInput = ".mu-header__search input";
    String searchSuggestion = ".el-autocomplete-suggestion__list li span";
    String btnLike = "button.shop-like";
    String shopsLink = ".shop-breadcrumb a[href=\"/ru/cashback/shops\"]";
    String favoriteShops = ".categories:nth-child(1)";
    String shopCard = ".offers .offer-cards";

    @Test
    void addShopToFavorite() {
        login();

        Actions addToFavorite = new Actions(getDriver());

        WebElement search = getDriver().findElement(By.cssSelector(searchInput));
        search.sendKeys(shopName);

        addToFavorite.click(getDriver().findElement(By.cssSelector(searchSuggestion)))
                .build()
                .perform();

        new WebDriverWait(getDriver(), 15).until(ExpectedConditions.urlContains(shopUrl));

        addToFavorite.click(getDriver().findElement(By.cssSelector(btnLike)))
                .build()
                .perform();

        addToFavorite.click(getDriver().findElement(By.cssSelector(shopsLink)))
                .build()
                .perform();

        addToFavorite.click(getDriver().findElement(By.cssSelector(favoriteShops)))
                .build()
                .perform();

        Assertions.assertEquals(1, getDriver().findElements(By.cssSelector(shopCard)).size());

    }
}
