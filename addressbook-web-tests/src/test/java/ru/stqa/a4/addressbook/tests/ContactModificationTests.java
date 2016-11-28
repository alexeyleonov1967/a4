package ru.stqa.a4.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.a4.addressbook.model.ContactData;

/**
 * Created by leonov_ai on 22.11.16.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHome();
    if (! app.getContactHelper().isThereAreContact()) {
      app.getContactHelper().createContact(new ContactData("First name", "Middle name", "Last name", "Nickname", "title", "Company", "Address", "123", "456", "789", "123456789", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "www.home.page", "1900", "1950", "Secondary Address", "Secondary Address\n", "Home Address","Notes", "Notes\n", "x11_test1"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("First name", "Middle name", "Last name", "Nickname", "title", "Company", "Address", "123", "456", "789", "123456789", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "www.home.page", "1900", "1950", "Secondary Address", "Secondary Address\n", "Home Address", "Notes", "Notes\n", null));
    app.getContactHelper().submitContactModification();
    app.logout();
  }
}
