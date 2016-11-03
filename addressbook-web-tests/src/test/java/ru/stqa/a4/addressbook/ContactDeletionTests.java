package ru.stqa.a4.addressbook;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        gotoHome();
        selectContact();
        deleteContact();
        logout();
    }

}
