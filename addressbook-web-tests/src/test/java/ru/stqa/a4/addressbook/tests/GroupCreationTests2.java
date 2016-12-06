package ru.stqa.a4.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.a4.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests2 extends TestBase {

    @Test
    public void testGroupCreation() {
        //
        app.getNavigationHelper().gotoGroupPage();
        //
        //int before = app.getGroupHelper().getGroupCount();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        //app.getGroupHelper().initGroupCreation();
        //app.getGroupHelper().fillGroupForm(new GroupData("x1_test1", null, null));
        //app.getGroupHelper().submitGroupCreation();
        //app.getGroupHelper().returnToGroupPage();
        //app.getGroupHelper().createGroup(new GroupData("test1_x1", null, null));
        GroupData group = new GroupData("test1_x1", null, null);
        app.getGroupHelper().createGroup(group);
        //
        //int after = app.getGroupHelper().getGroupCount();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        //
        // after - действительное значение элементов, ожидаемое значение элементов
        Assert.assertEquals(after.size(), before.size() + 1);

        // Определение максимума - не используется!
        //int max =0;
        //for (GroupData g : after) {
        //  if (g.getId() > max) {
        //    max = g.getId();
        //  }
        //}

        //Не используется - анонимные функции
        //Comparator<? super GroupData> byId = new Comparator<GroupData>() {
        //    @Override
        //    public int compare(GroupData o1, GroupData o2) {
        //        return Integer.compare(o1.getId(), o2.getId());
        //    }
        //};

        // Расчет максимального идентификатора
        //int max1 = after.stream().max(byId).get().getId();
        //group.setId(max1);

        // Расчет максимального идентификатора
        // лямбла функции
        //group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());


        before.add(group);

        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());

        before.sort(byId);
        after.sort(byId);

        //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        Assert.assertEquals(before, after);

        app.logout();
    }

}
