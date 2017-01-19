package ru.stqa.a4.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.a4.addressbook.model.ContactData;
import ru.stqa.a4.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {


  //@DataProvider
  //public Iterator<Object[]> validContacts() {
  //  List<Object[]> list = new ArrayList<Object[]>();
  //  list.add(new Object[] {new ContactData().withLastName("Last Name1").withFirstName("First Name1").withAddress("address1").withPhoto(new File("src/test/resources/pic1"))});
  //  list.add(new Object[] {new ContactData().withLastName("Last Name2").withFirstName("First Name2").withAddress("address2").withPhoto(new File("src/test/resources/pic1"))});
  //  list.add(new Object[] {new ContactData().withLastName("Last Name3").withFirstName("First Name3").withAddress("address3").withPhoto(new File("src/test/resources/pic1"))});
  //  return list.iterator();
  //}

  //csv
  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
    String line = reader.readLine();
    while (line != null )
    {
      String[] str = line.split(";");
      list.add(new Object[] { new ContactData().withFirstName(str[0]).withLastName(str[1]).withAddress(str[2])
              .withHomePhones(str[3]).withMobilePhones(str[4]).withWorkPhones(str[5])});
      line = reader.readLine();
    }
    return list.iterator();
  }

  //xml
  //@DataProvider
  //public Iterator<Object[]> validContacts() throws IOException {
  //  BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
  //  String xml = "";
  //  String line = reader.readLine();
  //  while (line != null) {
  //    xml += line;
  //    line = reader.readLine();
  //  }
  //  XStream xStream = new XStream();
  //  xStream.processAnnotations(ContactData.class);
  //  List<ContactData> contacts = (List<ContactData>) xStream.fromXML(xml);
  //  return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
  //}


  @Test (dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) {
    app.goTo().gotoHome();
    //
    //List<ContactData> before = app.getContactHelper().getContactList();
    //Contacts before = app.getContactHelper().all2();
    Contacts before = app.db().contacts();

    System.out.println("ДО");
    System.out.println(before);
    System.out.println("");

    //File photo = new File("src/test/resources/pic1");

    //ContactData contact = new ContactData().withFirstName("First name!").withLastName("Last name!").withMobilePhones("123").withHomePhones("345").withWorkPhones("678").withAddress("Address")
    //        .withEMail1("email1@spsr.ru").withEMail2("email2@spsr.ru").withEMail3("email3@spsr.ru").withPhoto(photo);


    app.getContactHelper().createContact(contact);

    //
    //List<ContactData> after = app.getContactHelper().getContactList();
    //Contacts after = app.getContactHelper().all2();
    Contacts after = app.db().contacts();


    System.out.println("ПОСЛЕ");
    System.out.println(after);
    System.out.println("");


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
