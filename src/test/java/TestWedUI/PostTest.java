package TestWedUI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class PostTest {
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
        Thread.sleep(3000);

        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(By.xpath("//input[@type='text']")), "Panda")
                .sendKeys(driver.findElement(By.xpath("//input[@type='password']")), "5e4fd4f6ce")
                .click(driver.findElement(By.xpath("//*[@class='button mdc-button mdc-button--raised mdc-ripple-upgraded']")))
                .build()
                .perform();
        Thread.sleep(3000);
    }

     @AfterEach
    static void close() {
        driver.quit();
    }

  @Test
    void CheckSortOrderNextPageTest() throws InterruptedException {
     driver.get("https://test-stand.gb.ru/?sort=createdAt&order=ASC");
     String urlTest = "sort=createdAt&order=ASC";
      Thread.sleep(6000);
      Actions actions = new Actions(driver);
      actions.click(driver.findElement(By.xpath("//*[contains(text(),'Next Page')]")))
              .build()
              .perform();
      Thread.sleep(3000);
      String expectedUrl= driver.getCurrentUrl();
      Assert.assertTrue(expectedUrl.contains(urlTest));
  }
@Test
    void NextPreviousTest() throws InterruptedException {
    String urlTest = "page";
      Actions actions = new Actions(driver);
      actions.click(driver.findElement(By.xpath("//*[contains(text(),'Next Page')]")))
              .build()
              .perform();
      Thread.sleep(3000);
      actions.click(driver.findElement(By.xpath("//*[contains(text(),'Previous Page')]")))
              .build()
              .perform();
    String expectedUrl= driver.getCurrentUrl();
    Assert.assertTrue(expectedUrl.contains(urlTest));
}
@Test
    void postCheckTest() throws InterruptedException {
    Assert.assertTrue(driver.findElement(By.xpath("//*[@class='post svelte-127jg4t']")).getText(),true);
}
@Test
    void postElementTest() throws InterruptedException {
    Assert.assertTrue(driver.findElement(By.xpath("//*[@class='post svelte-127jg4t']/h2[text()]")).getText(),true); //есть заголовок у поста
    Assert.assertTrue(driver.findElement(By.xpath("//*[@class='post svelte-127jg4t']/div[text()]")).getText(),true); // есть описание
    Assert.assertTrue(driver.findElement(By.xpath("//*[@class='post svelte-127jg4t']/img[contains(@src,'http')]")).getText(),true);// есть рисунок
}
}
