package ru.stqa.a4.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.a4.addressbook.model.ContactData;
import ru.stqa.a4.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.goTo().gotoHome();

        if (! app.getContactHelper().isThereAreContact()) {
            //app.getContactHelper().createContact(new ContactData("First name", "Middle name", "Last name", "Nickname", "title", "Company", "Address", "123", "456", "789", "123456789", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "www.home.page", "1900", "1950", null, "Secondary Address\n", "Home Address", null, "Notes\n", "x11_test1"));
            app.getContactHelper().createContact(new ContactData().withFirstName("First name"));
        }
        // Удаление последнего элемента в списке контактов
        //int before = app.group().getGroupCount();
        //app.group().selectGroup(before-1);


        Contacts before = app.getContactHelper().all2();
        //List<ContactData> before = app.getContactHelper().getContactList();
        //
        //app.getContactHelper().selectContact(before.size() - 1);
        //app.getContactHelper().deleteContact();

        ContactData deletedContact = before.iterator().next();
        //int index = before.size() - 1;
        //app.group().delete(index);
        app.getContactHelper().delete(deletedContact);


        Contacts after = app.getContactHelper().all2();

        //List<ContactData> after = app.getContactHelper().getContactList();
        assertEquals(after.size(), before.size() - 1);

        System.out.println(after.size());
        System.out.println(before.size() - 1);

        assertThat(after, equalTo(before.without(deletedContact)));


        //before.remove(before.size() -1);
        //Assert.assertEquals(before, after);

    }

}
