package ru.stqa.a4.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by leonov_ai on 18.11.16.
 */
public class BaseHelper {
  //protected FirefoxDriver wd;
  private FirefoxDriver wd;

  public BaseHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    findElement(locator).click();
  }


  protected WebElement findElement(By locator) {
    return wd.findElement(locator);
  }

  protected void type(By locator, String text) {
    //click(locator);
    WebElement element = findElement(locator);
    //findElement(locator).clear();
    //findElement(locator).sendKeys(text);
    element.clear();
    element.sendKeys(text);
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }


  protected void isSelectedClick(String path) {
    if (!findElement(By.xpath(path)).isSelected()) {
      click(By.xpath(path));
    }
  }
}
