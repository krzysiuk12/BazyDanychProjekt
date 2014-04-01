package pl.edu.agh.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Krzysiu on 2014-04-02.
 */
@Entity
public class Suppliers {
    private int supplierid;
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
    private String homepage;
    private Collection<Products> productsesBySupplierid;

    @Id
    @Column(name = "supplierid")
    public int getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(int supplierid) {
        this.supplierid = supplierid;
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

    @Basic
    @Column(name = "homepage")
    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Suppliers suppliers = (Suppliers) o;

        if (supplierid != suppliers.supplierid) return false;
        if (address != null ? !address.equals(suppliers.address) : suppliers.address != null) return false;
        if (city != null ? !city.equals(suppliers.city) : suppliers.city != null) return false;
        if (companyname != null ? !companyname.equals(suppliers.companyname) : suppliers.companyname != null)
            return false;
        if (contactname != null ? !contactname.equals(suppliers.contactname) : suppliers.contactname != null)
            return false;
        if (contacttitle != null ? !contacttitle.equals(suppliers.contacttitle) : suppliers.contacttitle != null)
            return false;
        if (country != null ? !country.equals(suppliers.country) : suppliers.country != null) return false;
        if (fax != null ? !fax.equals(suppliers.fax) : suppliers.fax != null) return false;
        if (homepage != null ? !homepage.equals(suppliers.homepage) : suppliers.homepage != null) return false;
        if (phone != null ? !phone.equals(suppliers.phone) : suppliers.phone != null) return false;
        if (postalcode != null ? !postalcode.equals(suppliers.postalcode) : suppliers.postalcode != null) return false;
        if (region != null ? !region.equals(suppliers.region) : suppliers.region != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = supplierid;
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
        result = 31 * result + (homepage != null ? homepage.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "suppliersBySupplierid")
    public Collection<Products> getProductsesBySupplierid() {
        return productsesBySupplierid;
    }

    public void setProductsesBySupplierid(Collection<Products> productsesBySupplierid) {
        this.productsesBySupplierid = productsesBySupplierid;
    }
}
