package ru.stqa.a4.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.a4.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


/**
 * Created by leonov_ai on 22.11.16.
 */
public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test_x1", null, null));
    }
    //
    //int before = app.getGroupHelper().getGroupCount();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().initGroupModification();
    //
    //app.getGroupHelper().fillGroupForm(new GroupData("x11_test1", "x22_test2", "x33_test3"));
    GroupData group = new GroupData(before.get(before.size()-1).getId(), "BXx11_test1", "x22_test2", "x33_test3");
    app.getGroupHelper().fillGroupForm(group);
    //
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    //
    //int after = app.getGroupHelper().getGroupCount();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    //
    // after - действительное значение элементов, ожидаемое значение элементов
    Assert.assertEquals(after.size(), before.size() );
    //
    //
    before.remove(before.size() - 1);
    before.add(group);

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);

    // преобразование к множеству и сравнение множеств
    //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    // сравнение упорядоченных списков
    Assert.assertEquals(before, after);
    //
    //
    app.logout();
  }

}
