package ru.stqa.a4.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.a4.addressbook.model.GroupData;

import java.util.List;


public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
           app.getGroupHelper().createGroup(new GroupData("test_x1", null, null));
        }
        // Удаление последнего элемента в списке
        //int before = app.getGroupHelper().getGroupCount();
        //app.getGroupHelper().selectGroup(before-1);
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);

        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();

        //int after = app.getGroupHelper().getGroupCount();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        //
        // after.size() - действительное значение количества элементов списка,
        // before.size() ожидаемое значение количества элементов списка
        //
        Assert.assertEquals(after.size(), before.size() - 1);
        //
        // Удаление последнего элемента в списке
        before.remove(before.size() - 1);
        //
        //for (int i = 0; i < after.size(); i++) {
        //Assert.assertEquals(before.get(i), after.get(i));
        //}
        Assert.assertEquals(before, after);
        //
        app.logout();
    }

}
