package gbHm.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddFavoritePO {
    public String username = "ohecf@mailto.plus";
    public String password = "Qw123456";
    public String userUrl = "https://backit.me/ru/cashback";
    public String shopUrl = "https://backit.me/ru/cashback/shops/mvideo";
    public String search = ".mu-header__search input";
    public String shopName = "мвидео";
    public String like = "button.shop-like";

    public void searchShop(WebDriver driver){
        WebElement search = driver.findElement(By.cssSelector(this.search));
        search.sendKeys(this.shopName);
        WebElement searchSuggestion = driver.findElement(By.cssSelector(".el-autocomplete-suggestion__list li span"));
        searchSuggestion.click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains(shopUrl));

    }

    public void addShopToFavorite(WebDriver driver){

        WebElement likeShop = driver.findElement(By.cssSelector(this.like));
        likeShop.click();
        new WebDriverWait(driver, 7).until(ExpectedConditions.attributeContains(driver.findElement(By.cssSelector("button.shop-like svg")),"class","mu-like-button__icon_active"));


    }
}
