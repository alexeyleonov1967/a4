package ru.stqa.a4.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.a4.addressbook.model.ContactData;
import ru.stqa.a4.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by leonov_ai on 14.11.16.
 */
public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    //click(By.xpath("//div[@id='content']/form/input[21]"));
    click(By.xpath("//div[@id='content']/form/input[@value='Enter']"));
  }

  public void fillContactForm(ContactData contactData) {
    //
    type(By.name("firstname"), contactData.getFname());
    type(By.name("lastname"), contactData.getLname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHome());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("work"), contactData.getWork());
    type(By.name("email"), contactData.getEmail1());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    // не ясно зачем это нужно ???
    //if (isElementPresent(By.name("new_group"))) {
    //  new Select(findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    //}

  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  // не используется
  //public void deleteContact() {
  //  click(By.xpath("//tr[@class='odd']/td[8]/a/img"));
  //  click(By.xpath("//div[@id='content']/form[2]/input[2]"));
  //}

  public void deleteContact() {
    //div[@id='content']/form[2]/div[2]/input
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  //Выбор контакта по индексу
  public void selectContact(int index) {
    // click(By.name("selected[]"));
    wd.findElements(By.name("selected[]")).get(index).click();
  }


  public void initContactModification() {
    // Первая строчка в таблице с индексом 2
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  // не используется
  public void submitContactModification2() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  // создание контакта
  public void createContact(ContactData contactData) {
    initContactCreation();
    fillContactForm(contactData);
    submitContactCreation();
  }

  public boolean isThereAreContact() {
    return isElementPresent(By.name("selected[]"));
  }



  // Первая версия !!!  - Теперь не используется
  /*
  // Формирование списка контактов на основании элементов на Web странице контактов
  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    // поиск web элементов для списка по имени name - возвращает  список Web элементов
    List<WebElement> elements = wd.findElements(By.name("entry"));

    //By.className()
    //By.name()
    //By.cssSelector()

    for (WebElement element : elements) {
      //String lastname = element.getText();
      String fio = element.findElement(By.tagName("input")).getAttribute("title");
      // поиск элемента в другом элементе - id, значение value в input
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      //System.out.println(id);
      ContactData contact = new ContactData(id, fio, "First name", "Middle name", "Last name", "Nickname", "title", "Company", "Address", "123", "456", "789", "123456789", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "www.home.page", "1900", "1950", null, "Secondary Address\n", "Home Address", null, "Notes\n", "x11_test1");
      contacts.add(contact);
      //
      //System.out.println(contacts);
    }
    return contacts;
  }
  */


  /*
  // устарел - не используется
  // Формирование множества контактов на основании элементов на Web странице контактов
  public Set<ContactData> getContactList2() {
    Set<ContactData> contacts = new HashSet<ContactData>();

    List<WebElement> elements = wd.findElements(By.name("entry"));

    for (WebElement element : elements) {
      // поиск элемента в другом элементе, значение value в input
      // получение id
      //int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      //
      ContactData contact = new ContactData(id, "First name", "Middle name", "Last name", "Nickname", "title", "Company", "Address", "123", "456", "789", "123456789", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "Alexey.leonov31@gmail.com", "www.home.page", "1900", "1950", null, "Secondary Address\n", "Home Address", null, "Notes\n", "x11_test1");
      contacts.add(contact);
    }
    return contacts;
  }

*/
  // отказался так делать - будет как в лекциях с all - контейнером для контактов, метод не используется
  public Set<ContactData> getContactList3() {

    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));

    for (WebElement row : rows ) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      // id
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
      // last name
      String lastname = cells.get(1).getText();
      // first name
      String firstname = cells.get(2).getText();
      //
      // Почтовый Адрес
      String addres = cells.get(3).getText();
      //
      // адреса электронной почты
      String[] emails = cells.get(4).getText().split("\n");
      //
      //телефоны
      String[] phones = cells.get(5).getText().split("\n");

      //phones[0], phones[1], phones[2]
      //ContactData contact = new ContactData(id, firstname, null, lastname, null, ... );
      //contacts.add(contact);
      }
      return contacts;
    }

  // Формирование контейнера Contacts из элементов на web странице
  public Contacts all2() {
    Contacts contacts = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("entry"));

    for (WebElement row : rows ) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      // id
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
      // last name
      String lastname = cells.get(1).getText();
      // first name
      String firstname = cells.get(2).getText();
      //
      // Почтовый Адрес
      String address = cells.get(3).getText();
      //
      // адреса электронной почты
      String[] emails = cells.get(4).getText().split("\n");
      //
      //телефоны
      String[] phones = cells.get(5).getText().split("\n");

      //ContactData contact = new ContactData(id, firstname, lastname, address, emails[0],
      // emails[1], emails[2], phones[0], phones[1], phones[2]));
      //contacts.add(contact);

      //System.out.println(lastname);
      //System.out.println(firstname);
      //System.out.println(address);
      //System.out.println(emails[0]);
      //System.out.println(phones[0]);
      //System.out.println(phones[1]);
      //System.out.println(phones[2]);

      ContactData contact = new ContactData().withId(id).withFirstName(firstname).withLastName(lastname)
             .withHomePhones(phones[0]).withMobilePhones(phones[1]).withWorkPhones(phones[2])
              .withAddress(address).withEMail1(emails[0]).withEMail2(emails[1]).withEMail3(emails[2]);

       contacts.add(contact);
      //
      System.out.println(contacts);
    }
    return contacts;
  }

    // Получение данных из формы контактов
    public ContactData infoFromEditForm( ContactData contact ) {
      initContactModificationById(contact.getId());
      String firstname2 = wd.findElement(By.name("firstname")).getAttribute("value");
      String lastname2 = wd.findElement(By.name("lastname")).getAttribute("value");
      String home2 = wd.findElement(By.name("home")).getAttribute("value");
      String mobile2 = wd.findElement(By.name("mobile")).getAttribute("value");
      String work2 = wd.findElement(By.name("work")).getAttribute("value");
      //почтовый адрес
      String address2 = wd.findElement(By.name("address")).getText();
      // электронные адреса
      String email = wd.findElement(By.name("email")).getAttribute("value");
      String email2 = wd.findElement(By.name("email2")).getAttribute("value");
      String email3 = wd.findElement(By.name("email3")).getAttribute("value");
      wd.navigate().back();

      //ContactData contact2 = new ContactData().withId(contact.getId())
      //        .withFirstName(firstname2).withLastName(lastname2).withHomePhones(home2).withMobilePhones(mobile2);
      //        .withAddress(address).withEMail1(emails[0]).withEMail2(emails[1]).withEMail3(emails[2])

      //return contact2;

      return  new ContactData().withId(contact.getId()).withFirstName(firstname2).withLastName(lastname2)
              .withHomePhones(home2).withMobilePhones(mobile2).withWorkPhones(work2)
              .withAddress(address2).withEMail1(email).withEMail2(email2).withEMail3(email3);

    }

    // выбор определенного контакта по id
    public void initContactModificationById(int id) {
      WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
      WebElement row = checkbox.findElement(By.xpath("./../.."));
      List<WebElement> cells = row.findElements(By.tagName("td"));
      cells.get(7).findElement (By.tagName("a")).click();
    }

  public void delete(ContactData contact) {
    //initContactModificationById(contact.getId());
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", contact.getId())));
    //wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    checkbox.click();
    deleteContact();
    // Не ясно нужно или нет ???
    click(By.linkText("home"));
  }

}
