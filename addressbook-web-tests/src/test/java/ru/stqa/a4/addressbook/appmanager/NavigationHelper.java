package ru.stqa.a4.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by leonov_ai on 16.11.16.
 */
public class NavigationHelper extends BaseHelper {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void GroupPage() {
    //проверка - нужно ли этот переход делать
    if (isElementPresent(By.tagName("h1"))
      && findElement(By.tagName("h1")).getText().equals("Groups")
      && isElementPresent(By.name("new"))) {
      return;
    }
      click(By.linkText("groups"));
  }

  public void gotoHome() {
    //проверка - нужно ли этот переход делать
    if (isElementPresent(By.id("maintable"))) {
      return;
      }
   click(By.linkText("home"));
  }
}
