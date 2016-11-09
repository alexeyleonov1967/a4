package ru.stqa.a4.addressbook.model;

public class ContactData {
  private final String fname;
  private final String sname;
  private final String lname;
  private final String nname;
  private final String title;
  private final String company;
  private final String address;
  private final String home;
  private final String mobile;
  private final String work;
  private final String fax;
  private final String email1;
  private final String email2;
  private final String email3;
  private final String homepage;
  private final String byear;
  private final String ayear;
  private final String address2;
  private final String adress22;
  private final String phone2;
  private final String notes;
  private final String notes2;

  public ContactData(String fname, String sname, String lname, String nname, String title, String Company, String Address, String home, String mobile, String work, String fax, String email1, String email2, String email3, String homepage, String byear, String ayear, String address2, String adress22, String phone2, String notes, String notes2) {
    this.fname = fname;
    this.sname = sname;
    this.lname = lname;
    this.nname = nname;
    this.title = title;
    this.company = Company;
    this.address = Address;
    this.home = home;
    this.mobile = mobile;
    this.work = work;
    this.fax = fax;
    this.email1 = email1;
    this.email2 = email2;
    this.email3 = email3;
    this.homepage = homepage;
    this.byear = byear;
    this.ayear = ayear;
    this.address2 = address2;
    this.adress22 = adress22;
    this.phone2 = phone2;
    this.notes = notes;
    this.notes2 = notes2;
  }

  public String getFname() {
    return fname;
  }

  public String getSname() {
    return sname;
  }

  public String getLname() {
    return lname;
  }

  public String getNname() {
    return nname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
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

  public String getFax() {
    return fax;
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

  public String getHomepage() {
    return homepage;
  }

  public String getByear() {
    return byear;
  }

  public String getAyear() {
    return ayear;
  }

  public String getAddress2() {
    return address2;
  }

  public String getAdress22() {
    return adress22;
  }

  public String getPhone2() {
    return phone2;
  }

  public String getNotes() {
    return notes;
  }

  public String getNotes2() {
    return notes2;
  }
}
