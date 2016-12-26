package ru.stqa.a4.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.a4.addressbook.model.GroupData;
import ru.stqa.a4.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

// статический импорт функций ( методов ) из глобальных библиотек
// статический импорт метода
// можно выполнять только для глобальных классов



public class GroupCreationTests2 extends TestBase {

   // @DataProvider
   //  public Iterator<Object[]> validGroups() {
   //     List<Object[]> list = new ArrayList<Object[]>();
   //     list.add(new Object[] {new GroupData().withName("test1").withHeader("header1").withFooter("footer1")});
   //     list.add(new Object[] {new GroupData().withName("test2").withHeader("header2").withFooter("footer2")});
   //     list.add(new Object[] {new GroupData().withName("test3").withHeader("header3").withFooter("footer3")});
   //     return list.iterator();
   //}

    // csv
      @DataProvider
      public Iterator<Object[]> validGroups() throws IOException {
          List<Object[]> list = new ArrayList<Object[]>();
          BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
          String line = reader.readLine();
          while (line != null )
         {
             String[] str = line.split(";");
             list.add(new Object[] { new GroupData().withName(str[0]).withHeader(str[1]).withFooter(str[2])});
             line = reader.readLine();
         }
          return list.iterator();
      }

    //xml
     @DataProvider
     public Iterator<Object[]> validGroups2() throws IOException {
         BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")));
         String xml = "";
         String line = reader.readLine();
         while (line != null) {
             xml += line;
             line = reader.readLine();
         }
         XStream xStream = new XStream();
         xStream.processAnnotations(GroupData.class);
         List<GroupData> groups = (List<GroupData>) xStream.fromXML(xml);
         return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
     }


    @Test(dataProvider = "validGroups2")
    public void testGroupCreation(GroupData group) {
        //GroupData group = new GroupData().withName(name).withHeader(header).withFooter(footer);
        app.goTo().GroupPage();
        //int before = app.group().getGroupCount();
        //Set<GroupData> before = app.group().all();
        Groups before = app.group().all();
        //GroupData group = new GroupData().withName("test1_x1");
        app.group().create(group);

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

    }

}
