package ru.stqa.a4.addressbook.model;


import com.thoughtworks.xstream.annotations.XStreamOmitField;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.io.File;


@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData
{
  //private int id;
  //private String fio;
  //private final String fname;
  //private final String sname;
  //private final String lname;
  //private String group;
  //private int id = Integer.MAX_VALUE ;
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "firstname")
  private String fname;

  @Column(name = "lastname")
  private String lname;
  //
  @Transient
  private String group;

  @Column(name = "address")
  @Type(type = "text")
  private String address;
  //
  //
  @XStreamOmitField
  @Column (name = "email")
  @Type(type = "text")
  private String email1;

  @XStreamOmitField
  @Column (name = "email2")
  @Type(type = "text")
  private String email2;

  @XStreamOmitField
  @Column (name = "email3")
  @Type(type = "text")
  private String email3;

  @XStreamOmitField
  @Column (name = "home")
  @Type(type = "text")
  private String home;

  @XStreamOmitField
  @Column (name = "mobile")
  @Type(type = "text")
  private String mobile;


  @XStreamOmitField
  @Column (name = "work")
  @Type(type = "text")
  private String work;


  @XStreamOmitField
  @Transient
  private String contactdetails;


  @XStreamOmitField
  @Column (name = "photo")
  @Type(type = "text")
  private String photo;


  public File getPhoto() {
    return new File(photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (fname != null ? !fname.equals(that.fname) : that.fname != null) return false;
    if (lname != null ? !lname.equals(that.lname) : that.lname != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (home != null ? !home.equals(that.home) : that.home != null) return false;
    if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
    return work != null ? work.equals(that.work) : that.work == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (fname != null ? fname.hashCode() : 0);
    result = 31 * result + (lname != null ? lname.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (home != null ? home.hashCode() : 0);
    result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
    result = 31 * result + (work != null ? work.hashCode() : 0);
    return result;
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
            ", address='" + address + '\'' +
            ", home='" + home + '\'' +
            ", mobile='" + mobile + '\'' +
            ", work='" + work + '\'' +
            '}';
  }

}
