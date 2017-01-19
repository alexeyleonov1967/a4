package ru.stqa.a4.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by leonov_ai on 13.12.16.
 */
public class Groups extends ForwardingSet<GroupData> {

  private Set<GroupData> delegate;

  // конструктор копии объекта класса Groups
  public Groups(Groups groups) {
    this.delegate = new HashSet<GroupData>(groups.delegate);
  }

  // пустой конструктор Groups
  public Groups() {
    this.delegate = new HashSet<GroupData>();
  }

  // конструктор объекта класса Groups(множество HashSet) из коллекции объектов GroupData
  public Groups(Collection<GroupData> groups) {
    this.delegate = new HashSet<GroupData>(groups);
  }


  @Override
  protected Set<GroupData> delegate() {
    return delegate;
  }

  // копия объекта Groups в которую добавлена группа
  public Groups withAdded(GroupData group) {
    // создали копию объекта групп
    Groups groups = new Groups(this);
    //в эту копию добавили новую группу из параметра group
    groups.add(group);
    // вернуть копию объекта Groups c добавленной группой
    return groups;
  }

  // копия объекта Groups из которого удалена группа
  public Groups without(GroupData group) {
    // создали копию объекта групп
    Groups groups = new Groups(this);
    //в эту копию добавили новую группу из параметра group
    groups.remove(group);
    // вернуть копию объекта Groups c добавленной группой
    return groups;
  }

}
