package pl.edu.agh.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Krzysiu on 2014-04-15.
 */
@Entity
@Table(name = "Suppliers")
public class Supplier {

    private Long id;

    private Set<Product> suppliedProducts;

    private String companyName;
    private String contactName;
    private String contactTitle;
    private String address;
    private String city;
    private String region;
    private String postalcode;
    private String country;
    private String phone;
    private String fax;
    private String homepage;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Supplier_PK_Sequence")
    @SequenceGenerator(name = "Supplier_PK_Sequence", sequenceName = "Supplier_PK_Sequence")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @NotNull
    @Column(name = "companyName")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "contactName")
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @Basic
    @Column(name = "contactTitle")
    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
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
    @Column(name = "postalCode")
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier", fetch = FetchType.LAZY)
    public Set<Product> getSuppliedProducts() {
        return suppliedProducts;
    }
    public void setSuppliedProducts(Set<Product> suppliedProducts) {
        this.suppliedProducts = suppliedProducts;
    }
}
