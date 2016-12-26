package ru.stqa.a4.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.a4.addressbook.appmanager.ApplicationManager;

/**
 * Created by leonov_ai on 08.11.16.
 */
public class TestBase {

  // Internet Explorer (IE)
  // FIREFOX
  // CHROME
  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }

}
