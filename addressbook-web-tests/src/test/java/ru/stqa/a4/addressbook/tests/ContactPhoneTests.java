package ru.stqa.a4.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.a4.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by leonov_ai on 14.12.16.
 */
public class ContactPhoneTests extends TestBase {


  @Test
  public void testContactPhones() {
    app.goTo().gotoHome();
    //
    //ContactData contact = app.getContactHelper().getContactList3().iterator().next();
    //ContactData contactInfoFromEditForm = app.getContactHelper().infoFromEditForm(contact);
    ContactData contact = app.getContactHelper().all2().iterator().next();
    ContactData contactInfoFromEditForm = app.getContactHelper().infoFromEditForm(contact);

//   тест телефонов
    assertThat(contact.getHome(), equalTo(cleaned(contactInfoFromEditForm.getHome())));
    assertThat(contact.getMobile(), equalTo(cleaned(contactInfoFromEditForm.getMobile())));
    assertThat(contact.getWork(), equalTo(cleaned(contactInfoFromEditForm.getWork())));

    // тест почтового адреса
    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));

    // тест электронных адресов
    assertThat(contact.getEmail1(), equalTo(contactInfoFromEditForm.getEmail1()));
    assertThat(contact.getEmail2(), equalTo(contactInfoFromEditForm.getEmail2()));
    assertThat(contact.getEmail3(), equalTo(contactInfoFromEditForm.getEmail3()));

  }

  public String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]","");
  }

  //public String cleanedEmail(String email) {
  //  return email.replaceAll("\\s", "").replaceAll("[*+()]","");
  //}

}
