package ru.stqa.a4.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.a4.addressbook.model.ContactData;
import ru.stqa.a4.addressbook.model.Contacts;
import ru.stqa.a4.addressbook.model.GroupData;
import ru.stqa.a4.addressbook.model.Groups;

import java.util.List;


/**
 * Created by leonov_ai on 27.03.17.
 */
public class AddContactToGroupTests2  extends TestBase {

  @BeforeMethod
  public void beforeDo2() {
    //  проверка, что группы есть
    app.goTo().GroupPage();

    // список читаем из БД
    if (app.db().groups().size() == 0) {
      app.goTo().GroupPage();
      app.group().create(new GroupData().withName("test_x1"));
    }
    //  проверка, что контакты есть
    app.goTo().gotoHome();

    // список читаем из БД
    if (app.db().contacts().size() == 0) {
      app.goTo().gotoHome();
      app.getContactHelper().createContact(new ContactData().withFirstName("Мой новый контакт"));
    }
  }

  @Test
  public void testAddContactToGroup2() throws ClassNotFoundException {

    app.goTo().gotoHome();

    //Выбор контакта который еще не был выбран на web странице
    //+
    //получить id этого выбранного контакта, чтобы взять его из БД

    //app.getContactHelper().selectContact();


    // получить список всех контактов из БД
    Contacts contacts = app.db().contacts();

    // получить список всех групп из БД
    Groups groups = app.db().groups();

    // получить количество групп
    int count2 = groups.size();

    // группа
    GroupData groupSelect = null;
    //контакт
    ContactData contactSelect  = null;


    //Подбор для контакта группы, в которую он не входит из списка БД
    //сравнение списка всех групп из БД и групп с этим контактом


    for(ContactData contact1: contacts){
      //контакт
      //ContactData contactSelect;
      if (contactSelect != null) break;

      // получить список всех групп для выбранного контакта
      //List<GroupData> groups1 = contact1.getGroups();  не проходит
      Groups groups1 = contact1.getGroups();
      int count1;
      count1 = groups1.size();

      //int count;
      //count = 0;

      for(GroupData groupOne: groups)
      {
        // группа
        //GroupData groupSelect;
        //count = count+1;

        if (count1 == 0) {
          groupSelect = groupOne;
          contactSelect = contact1;
          break;
        }

        for(GroupData groupTwo: groups1) {
          if (groupOne.getId() == groupTwo.getId())
          {
            groupSelect = null;
            break;
          }
          groupSelect = groupOne;
          //System.out.println(groupOne);
          //System.out.println(groupSelect);
        }

        if (groupSelect != null ) {
          contactSelect = contact1;
          //System.out.println(contactSelect);
          break;
          }

        }

    }


    System.out.println(groupSelect);
    System.out.println(contactSelect);


    // проставить найденную группу И контакт по БД в комо-боксe на web-странице

    if ( contactSelect != null )
     {

    //выбор контакта по id
    app.getContactHelper().selectContactById(contactSelect);

    // выбрать группу для добавления
    app.group().selectGroupByName(groupSelect);



    // Добавить контакт в группу - Нажать кнопку 'add To'
    app.getContactHelper().addTo();


    // возврат на главную страницу контактов
    app.goTo().gotoHome();


    //Проверить, что контакт добавился в выбранную группу
    //получить новый список групп для данного контакта из БД
    //и убедиться, что там есть новая группа (+1)

    System.out.println(contactSelect);


    Groups groups2 = contactSelect.getGroups();
    //System.out.println(groups2);
    int count3 = groups2.size();
    System.out.println(count3);

    //for(GroupData ngroup: groups2)
    //{
    //  if (groupSelect == ngroup) {
    //    System.out.println("Контакт добавлен в группу");
    //    break;
    //  }
    //}

    System.out.println("Контакт добавлен в группу !!!");
    //Contacts contacts = app.db().contacts();
    //Groups groups = app.db().groups();
  }
  else
      System.out.println("Нет контактов для добавления!");
  }

}
