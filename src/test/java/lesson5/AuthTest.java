package lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthTest extends BeforeAllTest {

    @Test
    void test() throws InterruptedException {
        getDriver().get(url);

        Actions login = new Actions(getDriver());

        login.sendKeys(getDriver().findElement(By.cssSelector(cssUsername)), username)
                .click(getDriver().findElement(By.cssSelector(cssPassword)))
                .sendKeys(password)
                .click(getDriver().findElement(By.cssSelector(cssBtnAuth)))
                .build()
                .perform();

        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector(".mu-dropdown--user-menu_desktop .mu-user-card__name"))));
        Assertions.assertEquals(username, getDriver().findElement(By.cssSelector(".mu-dropdown--user-menu_desktop .mu-user-card__name")).getText());
    }

}

