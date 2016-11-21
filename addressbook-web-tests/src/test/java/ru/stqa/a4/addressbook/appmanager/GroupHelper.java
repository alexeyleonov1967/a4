package ru.stqa.a4.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.a4.addressbook.model.GroupData;

/**
 * Created by leonov_ai on 14.11.16.
 */
public class GroupHelper extends BaseHelper {

  public GroupHelper(FirefoxDriver wd) {
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

  public void selectGroup() {
    click(By.name("selected[]"));
  }


}
