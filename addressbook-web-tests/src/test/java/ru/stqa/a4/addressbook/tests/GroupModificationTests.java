package ru.stqa.a4.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.a4.addressbook.model.GroupData;
import ru.stqa.a4.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by leonov_ai on 22.11.16.
 */
public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    //app.goTo().GroupPage();
    //if (app.group().all().size() == 0) {
    //  app.group().create(new GroupData().withName("test_x1"));
    //}
    // список читаем из БД
    if (app.db().groups().size() == 0) {
      app.goTo().GroupPage();
      app.group().create(new GroupData().withName("test_x1"));
    }
  }

  @Test
  public void testGroupModification() {
    //int before = app.group().getGroupCount();
    //Groups before = app.group().all();
    Groups before = app.db().groups();
    //int index = before.size() - 1;
    GroupData modifiedGroup = before.iterator().next();
    //app.group().fillGroupForm(new GroupData("x11_test1", "x22_test2", "x33_test3"));
    //GroupData group = new GroupData(before.get(index).getId(), "x11_test1", "x22_test2", "x33_test3");
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("x11_test1").withHeader("x22_test2").withFooter("x33_test3");
    //
    // перейти на страницу групп
    app.goTo().GroupPage();
    // так как id группы есть в объекте GroupData, передавать его не нужно
    app.group().modify(group);
    //
    //int after = app.group().getGroupCount();
    assertThat(app.group().getGroupCount(), equalTo(before.size()));

    //Groups after = app.group().all();
    Groups after = app.db().groups();
    //
    // after - действительное значение элементов, ожидаемое значение элементов
    //assertEquals(after.size(), before.size() );
    //

    //before.remove(modifiedGroup);
    //before.add(group);

    //Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    //before.sort(byId);
    //after.sort(byId);
    // преобразование к множеству и сравнение множеств
    //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    // сравнение упорядоченных списков
    //assertEquals(before, after);

    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));

  }

}
