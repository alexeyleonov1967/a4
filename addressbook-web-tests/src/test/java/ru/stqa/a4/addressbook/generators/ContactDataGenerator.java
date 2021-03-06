package ru.stqa.a4.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.stqa.a4.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leonov_ai on 23.12.16.
 */
public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;


  @Parameter(names = "-d", description = "Data Format")
  public String format;


  public static void main ( String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }


  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if  (format.equals("csv")) {
      saveAsCsv(contacts, new File(file));
    } else
    if (format.equals("xml")){
      saveAsXml(contacts, new File(file));
    } else  {
      System.out.println("Unrecognized format" + format);
    }

  }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.alias("contact", ContactData.class);
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(contacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }


  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      //writer.write(String.format("%s;%s;%s\n", contact.getFname(), contact.getLname(), contact.getAddress()));
      writer.write(String.format("%s;%s;%s;%s;%s;%s\n", contact.getFname(), contact.getLname(), contact.getAddress(),
              contact.getHome(), contact.getMobile(), contact.getWork()));
    }
    writer.close();
  }



  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withFirstName(String.format("First Name %s",i))
              .withLastName(String.format("Last Name %s", i)).withAddress(String.format("Address %s",i))
              .withHomePhones(String.format("123%s",i)).withMobilePhones(String.format("456%s",i))
              .withWorkPhones(String.format("789%s",i)));
    }
    return contacts;
  }

}
