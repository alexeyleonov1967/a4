package ru.stqa.a4.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests2 extends TestBase {

    @Test
    public void testGroupCreation() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("x1_test1", "x2_test2", "x3_test3"));
        submitGroupCreation();
        returnToGroupPage();
        logout();
    }

}
