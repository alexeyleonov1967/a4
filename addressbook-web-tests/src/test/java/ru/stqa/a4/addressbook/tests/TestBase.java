package ru.stqa.a4.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.a4.addressbook.appmanager.ApplicationManager;

/**
 * Created by leonov_ai on 08.11.16.
 */
public class TestBase {

  // Internet Explorer (IE)
  protected final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
