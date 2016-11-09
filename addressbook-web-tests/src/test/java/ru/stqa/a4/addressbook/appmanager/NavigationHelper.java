package ru.stqa.a4.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by leonov_ai on 16.11.16.
 */
public class NavigationHelper {
  private FirefoxDriver wd;

  public NavigationHelper(FirefoxDriver wd) {
    this.wd = wd;
  }


  public void gotoGroupPage() {
      wd.findElement(By.linkText("groups")).click();
  }

  public void gotoHome() {
    wd.findElement(By.linkText("home")).click();
  }
}
