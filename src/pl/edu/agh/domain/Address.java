package pl.edu.agh.domain;

import javax.persistence.*;

/**
 * Created by Krzysiu on 2014-04-29.
 */
@Entity
@Table(name = "Address")
public class Address {

    private Long id;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;

    public Address() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Address_PK_Sequence")
    @SequenceGenerator(name = "Address_PK_Sequence", sequenceName = "Address_PK_Sequence", initialValue = 1, allocationSize = 1)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}
