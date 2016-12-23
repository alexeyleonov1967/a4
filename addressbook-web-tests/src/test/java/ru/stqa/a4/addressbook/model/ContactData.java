package ru.stqa.a4.addressbook.model;


import java.io.File;

public class ContactData
{
  //private int id;
  //private String fio;
  //private final String fname;
  //private final String sname;
  //private final String lname;
  //private String group;

  //private int id = Integer.MAX_VALUE ;
  private int id;
  private String fname;
  private String lname;
  //
  private String address;
  //
  private String email1;
  private String email2;
  private String email3;
  //
  private String home;
  private String mobile;
  private String work;

  private String contactdetails;

  private File photo;



  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public int getId() {
    return id;
  }

  public String getFname() {
    return fname;
  }

  public String getLname() {
    return lname;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail1() {
    return email1;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getHome() {
    return home;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWork() {
    return work;
  }

  public String getContactdetail() {
    return contactdetails;
  }




  public ContactData withId(int id){
    this.id = id;
    return this;
  }


  public ContactData withContactDetail(String details) {
    this.contactdetails = details;
    return this;
  }


  public ContactData withFirstName(String name) {
    this.fname = name;
    return this;
  }

  public ContactData withLastName(String name) {
    this.lname = name;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withEMail1(String email) {
    this.email1 = email;
    return this;
  }

  public ContactData withEMail2(String email) {
    this.email2 = email;
    return this;
  }

  public ContactData withEMail3(String email) {
    this.email3 = email;
    return this;
  }


  public ContactData withHomePhones(String phone) {
    this.home = phone;
    return this;
  }


  public ContactData withMobilePhones(String phone) {
    this.mobile = phone;
    return this;
  }


  public ContactData withWorkPhones(String phone) {
    this.work = phone;
    return this;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", fname='" + fname + '\'' +
            ", lname='" + lname + '\'' +
            ", contactdetails='" + contactdetails + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    return fname != null ? fname.equals(that.fname) : that.fname == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (fname != null ? fname.hashCode() : 0);
    return result;
  }
}
