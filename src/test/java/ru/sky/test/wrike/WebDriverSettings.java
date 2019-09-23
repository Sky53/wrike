package ru.sky.test.wrike;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
    public ChromeDriver driver;

    @Before
    public void setUp() {
        checkOS();


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    private void checkOS() {
        String property = System.getProperty("os.name");
        switch (property) {
            case ("Linux"):
                System.setProperty("webdriver.chrome.driver", "chromedriver");
                break;
            case ("Windows"):
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                break;
            case ("MacOS"):
                System.setProperty("webdriver.chrome.driver", "chromedrivermac");
                break;
            case ("Other"):
                break;
        }
    }

    @After
    public void close() {
        driver.quit();
    }
}
