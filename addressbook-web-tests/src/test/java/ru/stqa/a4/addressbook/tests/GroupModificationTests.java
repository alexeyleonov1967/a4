package ru.stqa.a4.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.a4.addressbook.model.GroupData;

/**
 * Created by leonov_ai on 22.11.16.
 */
public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("x11_test1", "x22_test2", "x33_test3"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    app.logout();
  }

}
