package pl.edu.agh.tutorial.mappings.inheritance.annotations.joined;

import javax.persistence.*;

/**
 * Created by Krzysiu on 2014-04-17.
 */
@Entity
@Table(name = "Customers")
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {

    private Long id;
    private String address;
    private String city;

    public Customer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
}
