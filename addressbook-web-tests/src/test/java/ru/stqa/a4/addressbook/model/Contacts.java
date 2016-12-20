package ru.stqa.a4.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by leonov_ai on 16.12.16.
 */
public class Contacts extends ForwardingSet<ContactData> {

  private Set<ContactData> delegate;

  // конструктор копии объекта класса Contacts
  public Contacts(Contacts contacts) {
    this.delegate = new HashSet<ContactData>(contacts.delegate);
  }

  // пустой конструктор Groups
  public Contacts() {
    this.delegate = new HashSet<ContactData>();
  }

  @Override
  protected Set<ContactData> delegate() {
    return delegate;
  }

  // копия объека Contacts в которую добавлен контакт
  public Contacts withAdded(ContactData contact) {
    // создали копию объекта контакт
    Contacts contacts = new Contacts(this);
    //в эту копию добавили новый контакт из параметра contact
    contacts.add(contact);
    // вернуть копию объекта Contacts c добавленным контактом
    return contacts;
  }

  // копия объекта Contacts из которого удален контакт
  public Contacts without(ContactData contact) {
    // создали копию объекта контакт
    Contacts contacts = new Contacts(this);
    //в эту копию удалили новый контакт из параметра contact
    contacts.remove(contact);
    // вернуть копию объекта Contacts c удаленным контактом
    return contacts;
  }

}
