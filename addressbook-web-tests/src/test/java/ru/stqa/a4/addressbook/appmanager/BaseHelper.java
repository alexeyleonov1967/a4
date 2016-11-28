package ru.stqa.a4.addressbook.appmanager;

import org.openqa.selenium.*;

/**
 * Created by leonov_ai on 18.11.16.
 */
public class BaseHelper {
  //protected FirefoxDriver wd;
  //private FirefoxDriver wd;

  //private WebDriver wd;
  protected WebDriver wd;

  public BaseHelper(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    findElement(locator).click();
  }


  protected WebElement findElement(By locator) {
    return wd.findElement(locator);
  }

  protected void type(By locator, String text) {
    //
    //click(locator);
    //findElement(locator).clear();
    //findElement(locator).sendKeys(text);
    //
    // Оставлять дефолтовые значения для полей на форме +
    // не менять значение в поле , если новое значение совпадает со старым
    if (text != null) {
      WebElement element = findElement(locator);

      String existingText = element.getAttribute("value");
      if (!text.equals(existingText)) {
        element.clear();
        element.sendKeys(text);
      }
    }
  }


  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  //
  protected void isSelectedClick(String path) {
    if (!findElement(By.xpath(path)).isSelected()) {
      click(By.xpath(path));
    }
  }

  // Поиск элемента на странице
  protected boolean isElementPresent(By locator) {
    try {
      findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
}
