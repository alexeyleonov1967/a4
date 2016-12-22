package ru.stqa.a4.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.a4.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by leonov_ai on 20.12.16.
 */

public class ContactDetailTests extends TestBase
{
  @Test
  public void testContactDetails() {
    app.goTo().gotoHome();

    //Получаем какой - то контакт
    //ContactData contact = app.getContactHelper().getContactList3().iterator().next();
    ContactData contact = app.getContactHelper().all2().iterator().next();

    // Получение контакта из страницы с подробной информацией о контакте
    app.getContactHelper().initContactsDetailsById(contact.getId());
    ContactData contact1 = app.getContactHelper().getContact();


    // возврат на главную страницу
    app.goTo().gotoHome();
    ContactData contactInfoFromEditForm = app.getContactHelper().infoFromEditForm(contact);

    // тест склеенной строки из 2-ух разных контактов
    // метод обратных проверок
    assertThat(contact1.getContactdetail(), equalTo(cleaned(mergeInfo(contactInfoFromEditForm))));


  }

  private String  mergeInfo(ContactData contact) {
    String contactInfo = "";

    contactInfo = contact.getFname() + contact.getLname()
            + contact.getAddress() + contact.getHome() + contact.getMobile() + contact.getWork();

    //System.out.println(contactInfo);
    return contactInfo;
  }

  private String cleaned(String contactInfo) {
    return contactInfo.replaceAll("\\s", "");
  }

}
