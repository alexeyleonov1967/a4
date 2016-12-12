package ru.stqa.a4.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.a4.addressbook.model.ContactData;
import ru.stqa.a4.addressbook.model.GroupData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHome();

        if (! app.getContactHelper().isThereAreContact()) {
            app.getContactHelper().createContact(new ContactData("First name", "Middle name", "Last name", "Nickname", "title", "Company", "Address", "123", "456", "789", "123456789", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "www.home.page", "1900", "1950", null, "Secondary Address\n", "Home Address", null, "Notes\n", "x11_test1"));
        }
        // Удаление последнего элемента в списке контактов
        //int before = app.getGroupHelper().getGroupCount();
        //app.getGroupHelper().selectGroup(before-1);
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteContact();

        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

        app.logout();
    }

}
