package ru.sky.test.wrike;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class WrikeTest {
    @Test
    public void wrikeTest() {
        System.setProperty("webdriver.chrome.driver","C:\\1\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.wrike.com/");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Your online project management software - Wrike"));
        driver.quit();
    }
}
