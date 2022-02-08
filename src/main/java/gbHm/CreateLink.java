package gbHm;

import gbHm.PO.AuthPO;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class CreateLink extends AuthPO {
    public static void main( String[] args ) {
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

        Actions actionProvider = new Actions(driver);
        WebElement footer = driver.findElement(By.cssSelector("ul.mu-footer__info-links a[href=\"/ru/cashback/rules\"]"));
        actionProvider.moveToElement(footer).build().perform();

        WebElement goInviteFriends = driver.findElement(By.cssSelector("ul.mu-footer-links a[href=\"/ru/cashback/friends\"]"));
        goInviteFriends.click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains("https://backit.me/ru/cashback/friends"));

        WebElement card = driver.findElement(By.cssSelector(".card.link input[placeholder=\"Например, aliexpress.com/item/Xi...\"]"));
        WebElement faq = driver.findElement(By.cssSelector(".faq-info"));

        actionProvider.moveToElement(faq).build().perform();

        card.sendKeys("https://aliexpress.ru/");

        WebElement createBtn = driver.findElement(By.cssSelector(".card.link .action-block button"));
        createBtn.click();


        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".cashback-link-modal div[role=\"dialog\"]"))));
        driver.quit();
    }
}
