package project;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class ContactCreationTests {
  private WebDriver wd;


  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    login("admin", "secret");
  }

    private void login(String username, String password) {
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

  @Test
  public void testContactCreation() {
      initContactCreation();
      fillContactForm(new ContactData("Ivan", "Ivanov", "street","32111111", "123456@mail.com"));
      submitContactCreation();
      gotoHomePage();
      logout();
  }
    private void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }

    private void submitContactCreation() {
        wd.findElement(By.cssSelector("input[name=\"submit\"]")).click();
    }

    private void fillContactForm(ContactData contactData) {
        wd.findElement(By.cssSelector("input[name=\"firstname\"]")).clear();
        wd.findElement(By.cssSelector("input[name=\"firstname\"]")).sendKeys(contactData.getFirstName());
        wd.findElement(By.cssSelector("input[name=\"lastname\"]")).clear();
        wd.findElement(By.cssSelector("input[name=\"lastname\"]")).sendKeys(contactData.getLastName());
        wd.findElement(By.cssSelector("textarea[name=\"address\"]")).clear();
        wd.findElement(By.cssSelector("textarea[name=\"address\"]")).sendKeys(contactData.getAddress());
        wd.findElement(By.cssSelector("input[name=\"mobile\"]")).clear();
        wd.findElement(By.cssSelector("input[name=\"mobile\"]")).sendKeys(contactData.getMobile());
        wd.findElement(By.cssSelector("input[name=\"email\"]")).clear();
        wd.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys(contactData.getEmail());
    }

    private void gotoHomePage() {
        wd.findElement(By.linkText("home")).click();
    }

    private void logout() {
        wd.findElement(By.linkText("Logout")).click();
    }

    @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
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
}
