package ru.stqa.a4.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.a4.addressbook.model.ContactData;
import ru.stqa.a4.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by leonov_ai on 22.11.16.
 */
public class ContactModificationTests extends TestBase {


  @BeforeMethod
  public void beforeDo(){
    app.goTo().gotoHome();

    // список читаем из БД
    if (app.db().contacts().size() == 0) {
      app.goTo().gotoHome();
      app.getContactHelper().createContact(new ContactData().withFirstName("IvanovA"));
    }
  }


  @Test
  public void testContactModification() {

    //app.goTo().gotoHome();
    //if (! app.getContactHelper().isThereAreContact()) {
    //  //app.getContactHelper().createContact(new ContactData("First name", "Middle name", "Last name", "Nickname", "title", "Company", "Address", "123", "456", "789", "123456789", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "www.home.page", "1900", "1950", "Secondary Address", "Secondary Address\n", "Home Address","Notes", "Notes\n", "x11_test1"));
    //  app.getContactHelper().createContact(new ContactData().withFirstName("First name"));
    //}


    //System.out.println("Test1!");
    //List<ContactData> before = app.getContactHelper().getContactList();
    //Contacts before = app.getContactHelper().all2();
    Contacts before = app.db().contacts();

    System.out.println("ДО");
    System.out.println(before);

    //System.out.println("Test2!");
    ContactData modifiedContact = before.iterator().next();

    //System.out.println(modifiedContact.getId());
    //System.out.println("Test3!");

    //app.getContactHelper().selectContact(before.size() - 1);
    //app.getContactHelper().selectContact();
    app.getContactHelper().initContactModificationById(modifiedContact.getId());



    //ContactData contact = new ContactData(before.get(before.size()-1).getId(), before.get(before.size()-1).getFio(),"First name", "Middle name", "Last name", "Nickname", "title", "Company", "Address", "123", "456", "789", "123456789", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "www.home.page", "1900", "1950", "Secondary Address", "Secondary Address\n", "Home Address", "Notes", "Notes\n", null);
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("First name123").withLastName("Last name123").withAddress("Address123").withHomePhones("1230").withMobilePhones("4560").withWorkPhones("7890");


    app.getContactHelper().fillContactForm(contact);
    //app.getContactHelper().fillContactForm(new ContactData("First name", "Middle name", "Last name", "Nickname", "title", "Company", "Address", "123", "456", "789", "123456789", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "www.home.page", "1900", "1950", "Secondary Address", "Secondary Address\n", "Home Address", "Notes", "Notes\n", null));

    app.getContactHelper().submitContactModification();


    // after список
    //List<ContactData> after = app.getContactHelper().getContactList();
    //Contacts after = app.getContactHelper().all2();
    Contacts after = app.db().contacts();


    System.out.println("ПОСЛЕ");
    System.out.println(after);


    assertEquals(after.size(), before.size() );

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

    //before.remove(before.size() - 1);
    //before.add(contact);

    //Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    //before.sort(byId);
    //after.sort(byId);

    // сравнение упорядоченных списков
    //Assert.assertEquals(before, after);

  }
}
