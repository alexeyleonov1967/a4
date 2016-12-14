package ru.stqa.a4.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.a4.addressbook.model.GroupData;
import ru.stqa.a4.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().GroupPage();
        if ((app.group().all().size() == 0)) {
            app.group().create(new GroupData().withName("test_x1"));
        }
    }

    @Test
    public void testGroupDeletion() {
        // Удаление последнего элемента в списке
        //int before = app.group().getGroupCount();
        //app.group().selectGroup(before-1);
        Groups before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        //int index = before.size() - 1;
        //app.group().delete(index);
        app.group().delete(deletedGroup);
        //int after = app.group().getGroupCount();
        Groups after = app.group().all();
        //
        // after.size() - действительное значение количества элементов списка,
        // before.size() ожидаемое значение количества элементов списка
        assertEquals(after.size(), before.size() - 1);
        //
        // Удаление последнего элемента в списке
        //before.remove(index);
        //
        //for (int i = 0; i < after.size(); i++) {
        //Assert.assertEquals(before.get(i), after.get(i));
        //}
        assertThat(after, equalTo(before.without(deletedGroup)));
        //Assert.assertEquals(before, after);
        //
        //app.logout();
    }

}
