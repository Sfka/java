package project;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ContactCreationTests {
  private WebDriver wd;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testContactCreationTests() throws Exception {
    wd.get("http://localhost/addressbook/");
    wd.findElement(By.linkText("add new")).click();
    wd.findElement(By.cssSelector("input[name=\"firstname\"]")).clear();
    wd.findElement(By.cssSelector("input[name=\"firstname\"]")).sendKeys("Ivan");
    wd.findElement(By.cssSelector("input[name=\"lastname\"]")).clear();
    wd.findElement(By.cssSelector("input[name=\"lastname\"]")).sendKeys("Ivanov");
    wd.findElement(By.cssSelector("input[name=\"mobile\"]")).clear();
    wd.findElement(By.cssSelector("input[name=\"mobile\"]")).sendKeys("123456789");
    wd.findElement(By.cssSelector("input[name=\"email\"]")).clear();
    wd.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys("1234@mail.com");
    wd.findElement(By.cssSelector("input[name=\"submit\"]")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = wd.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
