package ru.stqa.pft1.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft1.mantis.appmanager.ApplicationManager;

/**
 * Created by leonov_ai on 08.11.16.
 */
public class TestBase {

  // Internet Explorer (IE)
  // FIREFOX
  // CHROME
  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.IE));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }

}
