package ru.stqa.a4.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.a4.addressbook.model.GroupData;
import ru.stqa.a4.addressbook.model.Groups;

import java.util.List;

/**
 * Created by leonov_ai on 14.11.16.
 */
public class GroupHelper extends BaseHelper {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
      // if (!wd.findElement(By.xpath("//div[@id='content']//select[normalize-space(.)='[none]']//option[1]")).isSelected()) {
      //    wd.findElement(By.xpath("//div[@id='content']//select[normalize-space(.)='[none]']//option[1]")).click();
      // }
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }


  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }


  // Выбор группы по индексу
  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
    //click(By.name("selected[]"));
  }

  // Выбор группы по ее идентификатору value для последующего ее удаления
  // By.cssSelector input , value
  public void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }


  //Выбор группы в комо-бокс
  public void selectGroupByName(GroupData group)
  {
    if (isElementPresent(By.name("to_group"))) {
      new Select(findElement(By.name("to_group"))).selectByVisibleText(group.getName());
    }
  }


  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update") );
  }

  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }


  public void modify(GroupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    returnToGroupPage();
  }

  // не используется
  public void delete(int index) {
    selectGroup(index);
    deleteSelectedGroups();
    returnToGroupPage();
  }

  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteSelectedGroups();
    returnToGroupPage();
  }

  // Не используется
  public boolean isThereAGroup() {
    return isElementPresent (By.name("selected[]"));
  }

  // Не используется
  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }


  // Формирование списка на основании элементов на Web странице
  //public List<GroupData> list() {
  //  List<GroupData> groups = new ArrayList<GroupData>();
  //  List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
  //  for (WebElement element : elements) {
  //    String name = element.getText();
      // поиск элемента в другом элементе - value в input
  //    int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
  //    groups.add(new GroupData().withId(id).withName(name));
  //  }
  //  return groups;
  //}

  // Формирование набора множества
  // не используется
  //public Set<GroupData> all() {
  //  Set<GroupData> groups = new HashSet<GroupData>();
  //  List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
  //  for (WebElement element : elements) {
  //    String name = element.getText();
      // поиск элемента в другом элементе - value в input
  //    int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
  //    groups.add(new GroupData().withId(id).withName(name));
  //  }
  //  return groups;
  //}

  // Формирование контейнера Groups
  public Groups all() {
    Groups groups = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      // поиск элемента в другом элементе - value в input
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groups.add(new GroupData().withId(id).withName(name));
    }
    return groups;
  }

}
