package ru.stqa.a4.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.a4.addressbook.model.ContactData;
import ru.stqa.a4.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().gotoHome();
    //
    //List<ContactData> before = app.getContactHelper().getContactList();
    Contacts before = app.getContactHelper().all2();

    File photo = new File("src/test/resources/pic1");

    ContactData contact = new ContactData().withFirstName("First name!").withLastName("Last name!").withMobilePhones("123").withHomePhones("345").withWorkPhones("678").withAddress("Address")
            .withEMail1("email1@spsr.ru").withEMail2("email2@spsr.ru").withEMail3("email3@spsr.ru").withPhoto(photo);
    app.getContactHelper().createContact(contact);

    //
    //List<ContactData> after = app.getContactHelper().getContactList();
    Contacts after = app.getContactHelper().all2();

    //before.add(contact);
    //Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());

    //before.sort(byId);
    //after.sort(byId);


    // сравнение отсортированных списков
    //Assert.assertEquals(before, after);

    //assertThat(after.size(), equalTo(before.size() + 1));

    //Assert.assertEquals(before, after);
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }
}

