package ru.stqa.pft1.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by leonov_ai on 14.11.16.
 */

public class ApplicationManager {
  WebDriver wd;
  private final Properties properties;


  private String browser;


  public ApplicationManager(String browser)  {
    this.browser = browser;
    properties = new Properties();
  }


  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target) )));


    //для добавления контакта в группу



    if (browser == BrowserType.FIREFOX) {
      wd = new FirefoxDriver();
    } else if (browser == BrowserType.CHROME) {
      wd = new ChromeDriver();
    } else if (browser == BrowserType.IE) {
      wd = new InternetExplorerDriver();
    }

    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //wd.get("http://localhost/addressbook/group.php");
    //wd.get("http://localhost/addressbook/");
    wd.get(properties.getProperty("web.baseURL"));

    //login("admin", "secret");
    login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
  }

  private void login(String username, String password) {
      wd.findElement(By.name("user")).click();
      wd.findElement(By.name("user")).clear();
      wd.findElement(By.name("user")).sendKeys(username);
      wd.findElement(By.name("pass")).click();
      wd.findElement(By.name("pass")).clear();
      wd.findElement(By.name("pass")).sendKeys(password);
      wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  // Не используется
  public void logout() {
      wd.findElement(By.linkText("Logout")).click();
  }

  public void stop() {
      wd.quit();
  }




}
