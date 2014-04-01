package pl.edu.agh.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Krzysiu on 2014-04-02.
 */
@Entity
public class Customers {
    private String customerid;
    private String companyname;
    private String contactname;
    private String contacttitle;
    private String address;
    private String city;
    private String region;
    private String postalcode;
    private String country;
    private String phone;
    private String fax;
    private Collection<Customercustomerdemo> customercustomerdemosByCustomerid;
    private Collection<Orders> ordersesByCustomerid;

    @Id
    @Column(name = "customerid")
    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    @Basic
    @Column(name = "companyname")
    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    @Basic
    @Column(name = "contactname")
    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    @Basic
    @Column(name = "contacttitle")
    public String getContacttitle() {
        return contacttitle;
    }

    public void setContacttitle(String contacttitle) {
        this.contacttitle = contacttitle;
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
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "fax")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customers customers = (Customers) o;

        if (address != null ? !address.equals(customers.address) : customers.address != null) return false;
        if (city != null ? !city.equals(customers.city) : customers.city != null) return false;
        if (companyname != null ? !companyname.equals(customers.companyname) : customers.companyname != null)
            return false;
        if (contactname != null ? !contactname.equals(customers.contactname) : customers.contactname != null)
            return false;
        if (contacttitle != null ? !contacttitle.equals(customers.contacttitle) : customers.contacttitle != null)
            return false;
        if (country != null ? !country.equals(customers.country) : customers.country != null) return false;
        if (customerid != null ? !customerid.equals(customers.customerid) : customers.customerid != null) return false;
        if (fax != null ? !fax.equals(customers.fax) : customers.fax != null) return false;
        if (phone != null ? !phone.equals(customers.phone) : customers.phone != null) return false;
        if (postalcode != null ? !postalcode.equals(customers.postalcode) : customers.postalcode != null) return false;
        if (region != null ? !region.equals(customers.region) : customers.region != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerid != null ? customerid.hashCode() : 0;
        result = 31 * result + (companyname != null ? companyname.hashCode() : 0);
        result = 31 * result + (contactname != null ? contactname.hashCode() : 0);
        result = 31 * result + (contacttitle != null ? contacttitle.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (postalcode != null ? postalcode.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "customersByCustomerid")
    public Collection<Customercustomerdemo> getCustomercustomerdemosByCustomerid() {
        return customercustomerdemosByCustomerid;
    }

    public void setCustomercustomerdemosByCustomerid(Collection<Customercustomerdemo> customercustomerdemosByCustomerid) {
        this.customercustomerdemosByCustomerid = customercustomerdemosByCustomerid;
    }

    @OneToMany(mappedBy = "customersByCustomerid")
    public Collection<Orders> getOrdersesByCustomerid() {
        return ordersesByCustomerid;
    }

    public void setOrdersesByCustomerid(Collection<Orders> ordersesByCustomerid) {
        this.ordersesByCustomerid = ordersesByCustomerid;
    }
}
