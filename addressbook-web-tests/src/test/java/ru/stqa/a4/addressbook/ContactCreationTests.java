package ru.stqa.a4.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

import static org.openqa.selenium.OutputType.*;

public class ContactCreationTests {
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(260, TimeUnit.SECONDS);
    login();
  }

  private void login() {
    wd.get("http://localhost/addressbook/");
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys("admin");
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys("secret");
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }


  @Test
  public void testContactCreation() {
    gotoHome();
    initContactCreation();
    fillContactForm();
    submitContactCreation();
    logout();
  }

  private void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

  private void submitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void fillContactForm() {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys("First name");
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys("Middle name");
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys("Last name");
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys("Nickname");
    wd.findElement(By.name("title")).click();
    wd.findElement(By.name("title")).clear();
    wd.findElement(By.name("title")).sendKeys("title");
    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys("Company");
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys("Address");
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys("123");
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys("456");
    wd.findElement(By.name("work")).click();
    wd.findElement(By.name("work")).clear();
    wd.findElement(By.name("work")).sendKeys("789");
    wd.findElement(By.name("fax")).click();
    wd.findElement(By.name("fax")).clear();
    wd.findElement(By.name("fax")).sendKeys("123456789");
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys("Alexey.leonov31@gmail.com");
    wd.findElement(By.name("email2")).click();
    wd.findElement(By.name("email2")).clear();
    wd.findElement(By.name("email2")).sendKeys("Alexey.leonov31@gmail.com");
    wd.findElement(By.name("email3")).click();
    wd.findElement(By.name("email3")).clear();
    wd.findElement(By.name("email3")).sendKeys("Alexey.leonov31@gmail.com");
    wd.findElement(By.name("homepage")).click();
    wd.findElement(By.name("homepage")).clear();
    wd.findElement(By.name("homepage")).sendKeys("www.home.page");
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[2]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[2]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[3]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[3]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[4]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[4]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[5]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[5]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[6]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[6]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[7]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[7]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[7]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[7]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[1]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[1]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[3]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[3]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[4]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[4]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[5]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[5]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[6]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[6]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[7]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[7]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[8]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[8]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[9]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[9]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[10]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[10]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[10]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[10]")).click();
    }
    wd.findElement(By.name("byear")).click();
    wd.findElement(By.name("byear")).clear();
    wd.findElement(By.name("byear")).sendKeys("1900");
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[1]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[1]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[2]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[2]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[3]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[3]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[4]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[4]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[4]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[4]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[1]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[1]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[2]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[2]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[3]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[3]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[4]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[4]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[4]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[4]")).click();
    }
    wd.findElement(By.name("ayear")).click();
    wd.findElement(By.name("ayear")).clear();
    wd.findElement(By.name("ayear")).sendKeys("1950");
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[1]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[1]")).click();
    }
    wd.findElement(By.name("address2")).click();
    wd.findElement(By.name("address2")).clear();
    wd.findElement(By.name("address2")).sendKeys("Secondary Address");
    wd.findElement(By.name("address2")).click();
    wd.findElement(By.name("address2")).clear();
    wd.findElement(By.name("address2")).sendKeys("Secondary Address\n");
    wd.findElement(By.name("phone2")).click();
    wd.findElement(By.name("phone2")).clear();
    wd.findElement(By.name("phone2")).sendKeys("Home Address");
    wd.findElement(By.name("notes")).click();
    wd.findElement(By.name("notes")).clear();
    wd.findElement(By.name("notes")).sendKeys("Notes");
    wd.findElement(By.name("notes")).click();
    wd.findElement(By.name("notes")).clear();
    wd.findElement(By.name("notes")).sendKeys("Notes\n");
  }

  private void initContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }

  private void gotoHome() {
    wd.findElement(By.linkText("home")).click();
  }

  @AfterMethod
  public void tearDown() {
    wd.quit();
  }

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
