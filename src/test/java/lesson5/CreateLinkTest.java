package lesson5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateLinkTest extends BeforeAllTest {

    @Test
    void createLink() {
        login();
        Actions actionProvider = new Actions(getDriver());

        actionProvider.moveToElement(getDriver().findElement(By.cssSelector("ul.mu-footer__info-links a[href=\"/ru/cashback/rules\"]")))
                .build()
                .perform();

        actionProvider.click(getDriver().findElement(By.cssSelector("ul.mu-footer-links a[href=\"/ru/cashback/friends\"]")))
                .build()
                .perform();

        actionProvider.moveToElement(getDriver().findElement(By.cssSelector(".faq-info")))
                .sendKeys(getDriver().findElement(By.cssSelector(".card.link input[placeholder=\"Например, aliexpress.com/item/Xi...\"]")), "https://aliexpress.ru/")
                .click(getDriver().findElement(By.cssSelector(".card.link .action-block button")))
                .build()
                .perform();

        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector(".cashback-link-modal div[role=\"dialog\"]"))));

    }

}
