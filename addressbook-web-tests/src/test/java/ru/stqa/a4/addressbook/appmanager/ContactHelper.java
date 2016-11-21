package ru.stqa.a4.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.a4.addressbook.model.ContactData;


/**
 * Created by leonov_ai on 14.11.16.
 */
public class ContactHelper extends BaseHelper {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData) {
    //
    //wd.findElement(By.name("firstname")).click();
    //wd.findElement(By.name("firstname")).clear();
    //wd.findElement(By.name("firstname")).sendKeys(contactData.getFname());
    type(By.name("firstname"), contactData.getFname());

    //wd.findElement(By.name("middlename")).click();
    //wd.findElement(By.name("middlename")).clear();
    //wd.findElement(By.name("middlename")).sendKeys(contactData.getSname());
    type(By.name("middlename"), contactData.getSname());

    //wd.findElement(By.name("lastname")).click();
    //wd.findElement(By.name("lastname")).clear();
    //wd.findElement(By.name("lastname")).sendKeys(contactData.getLname());
    type(By.name("lastname"), contactData.getLname());

    //wd.findElement(By.name("nickname")).click();
    //wd.findElement(By.name("nickname")).clear();
    //wd.findElement(By.name("nickname")).sendKeys(contactData.getNname());
    type(By.name("nickname"), contactData.getNname());

    //wd.findElement(By.name("title")).click();
    //wd.findElement(By.name("title")).clear();
    //wd.findElement(By.name("title")).sendKeys(contactData.getTitle());
    type(By.name("title"), contactData.getTitle());

    //wd.findElement(By.name("company")).click();
    //wd.findElement(By.name("company")).clear();
    //wd.findElement(By.name("company")).sendKeys(contactData.getCompany());
    type(By.name("company"),contactData.getCompany());

    //wd.findElement(By.name("address")).click();
    //wd.findElement(By.name("address")).clear();
    //wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
    type(By.name("address"), contactData.getAddress());

    //wd.findElement(By.name("home")).click();
    //wd.findElement(By.name("home")).clear();
    //wd.findElement(By.name("home")).sendKeys(contactData.getHome());
    type(By.name("home"), contactData.getHome());

    //wd.findElement(By.name("mobile")).click();
    //wd.findElement(By.name("mobile")).clear();
    //wd.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
    type(By.name("mobile"), contactData.getMobile());

    //wd.findElement(By.name("work")).click();
    //wd.findElement(By.name("work")).clear();
    //wd.findElement(By.name("work")).sendKeys(contactData.getWork());
    type(By.name("work"), contactData.getWork());

    //wd.findElement(By.name("fax")).click();
    //wd.findElement(By.name("fax")).clear();
    //wd.findElement(By.name("fax")).sendKeys(contactData.getFax());
    type(By.name("fax"), contactData.getFax());

    //wd.findElement(By.name("email")).click();
    //wd.findElement(By.name("email")).clear();
    //wd.findElement(By.name("email")).sendKeys(contactData.getEmail1());
    type(By.name("email"), contactData.getEmail1());

    //wd.findElement(By.name("email2")).click();
    //wd.findElement(By.name("email2")).clear();
    //wd.findElement(By.name("email2")).sendKeys(contactData.getEmail2());
    type(By.name("email2"), contactData.getEmail2());

    //wd.findElement(By.name("email3")).click();
    //wd.findElement(By.name("email3")).clear();
    //wd.findElement(By.name("email3")).sendKeys(contactData.getEmail3());
    type(By.name("email3"), contactData.getEmail3());

    //wd.findElement(By.name("homepage")).click();
    //wd.findElement(By.name("homepage")).clear();
    //wd.findElement(By.name("homepage")).sendKeys(contactData.getHomepage());
    type(By.name("homepage"), contactData.getHomepage());

    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[1]//option[1]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[2]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[1]//option[2]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[3]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[1]//option[3]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[4]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[1]//option[4]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[5]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[1]//option[5]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[6]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[1]//option[6]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[7]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[1]//option[7]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[7]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[1]//option[7]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[1]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[2]//option[1]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[2]//option[2]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[3]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[2]//option[3]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[4]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[2]//option[4]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[5]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[2]//option[5]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[6]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[2]//option[6]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[7]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[2]//option[7]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[8]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[2]//option[8]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[9]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[2]//option[9]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[10]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[2]//option[10]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[10]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[2]//option[10]"));
    }
    //
    //wd.findElement(By.name("byear")).click();
    //wd.findElement(By.name("byear")).clear();
    //wd.findElement(By.name("byear")).sendKeys(contactData.getByear());
    type(By.name("byear"), contactData.getByear());

    //
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[1]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[3]//option[1]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[2]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[3]//option[2]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[3]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[3]//option[3]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[4]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[3]//option[4]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[4]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[3]//option[4]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[1]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[4]//option[1]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[2]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[4]//option[2]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[3]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[4]//option[3]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[4]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[4]//option[4]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[4]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[4]//option[4]"));
    }
    //wd.findElement(By.name("ayear")).click();
    //wd.findElement(By.name("ayear")).clear();
    //wd.findElement(By.name("ayear")).sendKeys(contactData.getAyear());
    type(By.name("ayear"), contactData.getAyear());

    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[1]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[5]//option[1]"));
    }
    //wd.findElement(By.name("address2")).click();
    //wd.findElement(By.name("address2")).clear();
    //wd.findElement(By.name("address2")).sendKeys(contactData.getAddress2());
    type(By.name("address2"), contactData.getAddress2());

    //wd.findElement(By.name("address2")).click();
    //wd.findElement(By.name("address2")).clear();
    //wd.findElement(By.name("address2")).sendKeys(contactData.getAdress22());
    type(By.name("address2"), contactData.getAdress22());

    //wd.findElement(By.name("phone2")).click();
    //wd.findElement(By.name("phone2")).clear();
    //wd.findElement(By.name("phone2")).sendKeys(contactData.getPhone2());
    type(By.name("phone2"), contactData.getPhone2());

    //wd.findElement(By.name("notes")).click();
    //wd.findElement(By.name("notes")).clear();
    //wd.findElement(By.name("notes")).sendKeys(contactData.getNotes());
    type(By.name("notes"), contactData.getNotes());

    //wd.findElement(By.name("notes")).click();
    //wd.findElement(By.name("notes")).clear();
    //wd.findElement(By.name("notes")).sendKeys(contactData.getNotes2());
    //type(By.name("notes"), contactData.getNotes2());
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }


  public void deleteContact() {
    click(By.xpath("//tr[@class='odd']/td[8]/a/img"));
    click(By.xpath("//div[@id='content']/form[2]/input[2]"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

}
