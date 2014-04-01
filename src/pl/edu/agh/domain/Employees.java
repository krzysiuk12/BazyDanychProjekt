package pl.edu.agh.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Krzysiu on 2014-04-02.
 */
@Entity
public class Employees {
    private int employeeid;
    private String lastname;
    private String firstname;
    private String title;
    private String titleofcourtesy;
    private Date birthdate;
    private Date hiredate;
    private String address;
    private String city;
    private String region;
    private String postalcode;
    private String country;
    private String homephone;
    private String extension;
    private byte[] photo;
    private String notes;
    private String photopath;
    private Employees employeesByReportsto;
    private Collection<Employees> employeesesByEmployeeid;
    private Collection<Employeeterritories> employeeterritoriesesByEmployeeid;
    private Collection<Orders> ordersesByEmployeeid;

    @Id
    @Column(name = "employeeid")
    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "titleofcourtesy")
    public String getTitleofcourtesy() {
        return titleofcourtesy;
    }

    public void setTitleofcourtesy(String titleofcourtesy) {
        this.titleofcourtesy = titleofcourtesy;
    }

    @Basic
    @Column(name = "birthdate")
    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Basic
    @Column(name = "hiredate")
    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "postalcode")
    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "homephone")
    public String getHomephone() {
        return homephone;
    }

    public void setHomephone(String homephone) {
        this.homephone = homephone;
    }

    @Basic
    @Column(name = "extension")
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Basic
    @Column(name = "photo")
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "photopath")
    public String getPhotopath() {
        return photopath;
    }

    public void setPhotopath(String photopath) {
        this.photopath = photopath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employees employees = (Employees) o;

        if (employeeid != employees.employeeid) return false;
        if (address != null ? !address.equals(employees.address) : employees.address != null) return false;
        if (birthdate != null ? !birthdate.equals(employees.birthdate) : employees.birthdate != null) return false;
        if (city != null ? !city.equals(employees.city) : employees.city != null) return false;
        if (country != null ? !country.equals(employees.country) : employees.country != null) return false;
        if (extension != null ? !extension.equals(employees.extension) : employees.extension != null) return false;
        if (firstname != null ? !firstname.equals(employees.firstname) : employees.firstname != null) return false;
        if (hiredate != null ? !hiredate.equals(employees.hiredate) : employees.hiredate != null) return false;
        if (homephone != null ? !homephone.equals(employees.homephone) : employees.homephone != null) return false;
        if (lastname != null ? !lastname.equals(employees.lastname) : employees.lastname != null) return false;
        if (notes != null ? !notes.equals(employees.notes) : employees.notes != null) return false;
        if (!Arrays.equals(photo, employees.photo)) return false;
        if (photopath != null ? !photopath.equals(employees.photopath) : employees.photopath != null) return false;
        if (postalcode != null ? !postalcode.equals(employees.postalcode) : employees.postalcode != null) return false;
        if (region != null ? !region.equals(employees.region) : employees.region != null) return false;
        if (title != null ? !title.equals(employees.title) : employees.title != null) return false;
        if (titleofcourtesy != null ? !titleofcourtesy.equals(employees.titleofcourtesy) : employees.titleofcourtesy != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeid;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (titleofcourtesy != null ? titleofcourtesy.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        result = 31 * result + (hiredate != null ? hiredate.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (postalcode != null ? postalcode.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (homephone != null ? homephone.hashCode() : 0);
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        result = 31 * result + (photo != null ? Arrays.hashCode(photo) : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (photopath != null ? photopath.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "reportsto", referencedColumnName = "employeeid")
    public Employees getEmployeesByReportsto() {
        return employeesByReportsto;
    }

    public void setEmployeesByReportsto(Employees employeesByReportsto) {
        this.employeesByReportsto = employeesByReportsto;
    }

    @OneToMany(mappedBy = "employeesByReportsto")
    public Collection<Employees> getEmployeesesByEmployeeid() {
        return employeesesByEmployeeid;
    }

    public void setEmployeesesByEmployeeid(Collection<Employees> employeesesByEmployeeid) {
        this.employeesesByEmployeeid = employeesesByEmployeeid;
    }

    @OneToMany(mappedBy = "employeesByEmployeeid")
    public Collection<Employeeterritories> getEmployeeterritoriesesByEmployeeid() {
        return employeeterritoriesesByEmployeeid;
    }

    public void setEmployeeterritoriesesByEmployeeid(Collection<Employeeterritories> employeeterritoriesesByEmployeeid) {
        this.employeeterritoriesesByEmployeeid = employeeterritoriesesByEmployeeid;
    }

    @OneToMany(mappedBy = "employeesByEmployeeid")
    public Collection<Orders> getOrdersesByEmployeeid() {
        return ordersesByEmployeeid;
    }

    public void setOrdersesByEmployeeid(Collection<Orders> ordersesByEmployeeid) {
        this.ordersesByEmployeeid = ordersesByEmployeeid;
    }
}
