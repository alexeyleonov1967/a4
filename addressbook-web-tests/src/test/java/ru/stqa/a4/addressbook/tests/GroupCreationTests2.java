package ru.stqa.a4.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.a4.addressbook.model.GroupData;
import ru.stqa.a4.addressbook.model.Groups;

// статический импорт функций ( методов ) из глобальных библиотек
// статический импорт метода
// можно выполнять только для глобальных классов

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;



public class GroupCreationTests2 extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().GroupPage();
        //int before = app.group().getGroupCount();
        //Set<GroupData> before = app.group().all();
        Groups before = app.group().all();
        //GroupData group = new GroupData("test1_x1", null, null);
        GroupData group = new GroupData().withName("test1_x1");
        app.group().create(group);
        //
        //int after = app.group().getGroupCount();
        //Set<GroupData> after = app.group().all();
        Groups after = app.group().all();
        //
        // after - действительное значение элементов, ожидаемое значение элементов
        //Assert.assertEquals(after.size(), before.size() + 1);
        assertThat(after.size(), equalTo(before.size() + 1));

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

        //определение как сравнивать элементы в списке !!!
        //Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        //before.sort(byId);
        //after.sort(byId);
        //
        //before.add(group);
        //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        //Assert.assertEquals(before, after);
        assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
        //app.logout();
    }

}
