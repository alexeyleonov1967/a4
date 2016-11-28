package ru.stqa.a4.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.a4.addressbook.model.GroupData;

public class GroupCreationTests2 extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        //app.getGroupHelper().initGroupCreation();
        //app.getGroupHelper().fillGroupForm(new GroupData("x1_test1", null, null));
        //app.getGroupHelper().submitGroupCreation();
        //app.getGroupHelper().returnToGroupPage();
        app.getGroupHelper().createGroup(new GroupData("test1_x1", null, null));
        app.logout();
    }

}
