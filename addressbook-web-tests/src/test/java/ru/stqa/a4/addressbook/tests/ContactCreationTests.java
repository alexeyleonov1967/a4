package ru.stqa.a4.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.a4.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHome();
    //
    List<ContactData> before = app.getContactHelper().getContactList();
    //
    // app.getContactHelper().initContactCreation();
   // app.getContactHelper().fillContactForm(new ContactData("First name", "Middle name", "Last name", "Nickname", "title", "Company", "Address", "123", "456", "789", "123456789", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "www.home.page", "1900", "1950", null, "Secondary Address\n", "Home Address", null, "Notes\n", "x1_test1"));
   // app.getContactHelper().submitContactCreation();
    ContactData contact = new ContactData("First name", "Middle name", "Last name", "Nickname", "title", "Company", "Address", "123", "456", "789", "123456789", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "www.home.page", "1900", "1950", null, "Secondary Address\n", "Home Address", null, "Notes\n", "x11_test1");
    app.getContactHelper().createContact(contact);
    //
    List<ContactData> after = app.getContactHelper().getContactList();

    before.add(contact);

    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());

    before.sort(byId);
    after.sort(byId);

    //System.out.println(before);
    //System.out.println(after);

    // сравнение отсортированных списков
    Assert.assertEquals(before, after);


    app.logout();
  }
}






