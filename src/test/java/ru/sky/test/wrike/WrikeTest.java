package ru.sky.test.wrike;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sky.test.wrike.utils.GeneratorEmail;

import java.util.List;
import java.util.Random;

public class WrikeTest extends WebDriverSettings {




    @Test
    public void wrikeTest() throws InterruptedException {
        //Первый этап, проверка открытия URL
        driver.get("https://www.wrike.com/");
        String title = driver.getTitle();
        Assert.assertEquals("Your online project management software - Wrike", title);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //Выбор кнопки "Get started for free" расположенной рядом с кнопкой "Login"
        WebElement webElement = driver.findElements(By.cssSelector(".wg-header__free-trial-button.wg-btn.wg-btn--green")).get(2);
        webElement.click();

        String email = GeneratorEmail.getTestEmail((int) (Math.random() * 10));

        driver.findElement(By.cssSelector(".wg-input.modal-form-trial__input")).sendKeys(email);
        driver.findElement(By.cssSelector((".wg-btn.wg-btn--blue.modal-form-trial__submit"))).click();


        /**
         * An expectation for the URL of the current page to be a specific url.
         *
         * @param url the url that the page should be on
         * @return <code>true</code> when the URL is what it should be
         */
        wait.until(ExpectedConditions.urlToBe("https://www.wrike.com/resend/"));
        Assert.assertEquals("https://www.wrike.com/resend/", driver.getCurrentUrl());

        Random random = new Random();

        int first = random.nextInt(2);
        int second = 2 + random.nextInt(5);
        int third = 7 + random.nextInt(3);

        List<WebElement> answers = driver.findElements(By.cssSelector(".switch__button"));
        answers.get(first).click();
        answers.get(second).click();
        answers.get(third).click();

        //добавление подписи в прочее
        if (third == 9) {
            driver.findElement(By.cssSelector(".switch__input")).sendKeys("SkyTestTask");
        }


        driver.findElement(By.cssSelector(".submit.wg-btn.wg-btn--navy.js-survey-submit")).click();


        //проверка
        wait.until(ExpectedConditions.invisibilityOf(driver.findElements(By.cssSelector(".switch__button")).get(0)));
        Assert.assertFalse(driver.findElements(By.cssSelector(".switch__button")).get(0).isDisplayed());

        //twitter
        WebElement twitterIcon = driver.findElement(By.cssSelector(".wg-footer__group.wg-footer__group--social")).findElements(By.cssSelector(".wg-footer__social-link")).get(0);
        Assert.assertTrue(twitterIcon.isDisplayed());

        Assert.assertEquals("https://twitter.com/wrike", twitterIcon.getAttribute("href"));

        //twitter Icon
        String imageAddress = twitterIcon.findElement(By.tagName("use")).getAttribute("xlink:href");
        Assert.assertEquals("/content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg?v2#twitter", imageAddress);
    }
}