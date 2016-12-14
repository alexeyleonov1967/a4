package ru.stqa.a4.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.a4.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by leonov_ai on 22.11.16.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.goTo().gotoHome();
    if (! app.getContactHelper().isThereAreContact()) {
      app.getContactHelper().createContact(new ContactData("First name", "Middle name", "Last name", "Nickname", "title", "Company", "Address", "123", "456", "789", "123456789", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "www.home.page", "1900", "1950", "Secondary Address", "Secondary Address\n", "Home Address","Notes", "Notes\n", "x11_test1"));
    }

    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().selectContact(before.size() - 1);
    //app.getContactHelper().selectContact();

    app.getContactHelper().initContactModification();

    ContactData contact = new ContactData(before.get(before.size()-1).getId(), before.get(before.size()-1).getFio(),"First name", "Middle name", "Last name", "Nickname", "title", "Company", "Address", "123", "456", "789", "123456789", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "www.home.page", "1900", "1950", "Secondary Address", "Secondary Address\n", "Home Address", "Notes", "Notes\n", null);
    app.getContactHelper().fillContactForm(contact);
    //app.getContactHelper().fillContactForm(new ContactData("First name", "Middle name", "Last name", "Nickname", "title", "Company", "Address", "123", "456", "789", "123456789", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "www.home.page", "1900", "1950", "Secondary Address", "Secondary Address\n", "Home Address", "Notes", "Notes\n", null));

    app.getContactHelper().submitContactModification();

    //  after список
    List<ContactData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size() );


    before.remove(before.size() - 1);
    before.add(contact);

    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);

    // сравнение упорядоченных списков
    Assert.assertEquals(before, after);

    //app.logout();
  }
}
