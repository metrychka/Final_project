package TestWedUI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class AuthorizationTest {
    private static WebDriver driver;

    @BeforeEach
     void init() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://test-stand.gb.ru/login");
        Thread.sleep(6000);
    }

    @AfterEach
    void close() {
        driver.quit();
    }

    @Test

    void AuthorizationTestPozitiv() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(By.xpath("//input[@type='text']")), "Panda")
                .sendKeys(driver.findElement(By.xpath("//input[@type='password']")), "5e4fd4f6ce")
                .click(driver.findElement(By.xpath("//*[@class='button mdc-button mdc-button--raised mdc-ripple-upgraded']")))
                .build()
                .perform();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='mdc-switch__icon mdc-switch__icon--on']")).getText(),true);

    }

    @Test

    void AuthorizationTestNegativ() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(By.xpath("//input[@type='text']")), "Panda")
                .sendKeys(driver.findElement(By.xpath("//input[@type='password']")), "5")
                .click(driver.findElement(By.xpath("//*[@class='button mdc-button mdc-button--raised mdc-ripple-upgraded']")))
                .build()
                .perform();
        Thread.sleep(3000);
        String actualUrl = "https://test-stand.gb.ru/login";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

 @Test

 void AuthorizationTestLoginShort() throws InterruptedException {
     Actions actions = new Actions(driver);
     actions.sendKeys(driver.findElement(By.xpath("//input[@type='text']")), "Lp")
             .sendKeys(driver.findElement(By.xpath("//input[@type='password']")), "83aa590baf")
             .click(driver.findElement(By.xpath("//*[@class='button mdc-button mdc-button--raised mdc-ripple-upgraded']")))
             .build()
             .perform();
     Thread.sleep(3000);
     String actualUrl = "https://test-stand.gb.ru/login";
     String expectedUrl= driver.getCurrentUrl();
     Assert.assertEquals(expectedUrl,actualUrl);
 }


 @Test

 void AuthorizationTestLoginLong() throws InterruptedException {
     Actions actions = new Actions(driver);
     actions.sendKeys(driver.findElement(By.xpath("//input[@type='text']")), "Usernamewerylongggggg")
             .sendKeys(driver.findElement(By.xpath("//input[@type='password']")), "cee5e0c70c")
             .click(driver.findElement(By.xpath("//*[@class='button mdc-button mdc-button--raised mdc-ripple-upgraded']")))
             .build()
             .perform();
     Thread.sleep(3000);
     String actualUrl = "https://test-stand.gb.ru/login";
     String expectedUrl= driver.getCurrentUrl();
     Assert.assertEquals(expectedUrl,actualUrl);
 }

 @Test

 void AuthorizationTestLoginSymbol() throws  InterruptedException {
     Actions actions = new Actions(driver);
     actions.sendKeys(driver.findElement(By.xpath("//input[@type='text']")), "P&&&")
             .sendKeys(driver.findElement(By.xpath("//input[@type='password']")), "a10ed5bcae")
             .click(driver.findElement(By.xpath("//*[@class='button mdc-button mdc-button--raised mdc-ripple-upgraded']")))
             .build()
             .perform();
     Thread.sleep(3000);
     String actualUrl = "https://test-stand.gb.ru/login";
     String expectedUrl= driver.getCurrentUrl();
     Assert.assertEquals(expectedUrl,actualUrl);
 }
}
